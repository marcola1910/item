/**
 * 
 */
package org.exnihilo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;

/**
 * @author marcmarinho
 *
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class EstadoForm extends Form {
	private NodoDTO _nodo;
	private RepeatingView listItems;
	private ModalWindow modalWindow;
	private String workflowId;

	@SuppressWarnings("unchecked")
	public EstadoForm(String id) {
		super(id);

		// Add labels
		final Label labelOid = new Label("Oid");
		add(labelOid);
		add(new TextField("Name"));
		add(new FeedbackPanel("mfeed"));

		// Set up the visible fields of the workflow
		ChoiceRenderer workflowrender = new ChoiceRenderer("Name", "oid");

		// Brings a DTO of Workflows object
		List<WorkFlowDTO> workflowlist = ServiceLocator.getInstance()
				.getWorkflowService().getAllWorkflows();

		// Set up the list of workflow which only one is selectable
		final DropDownChoice<WorkFlowDTO> wkfdrop = new DropDownChoice<WorkFlowDTO>(
				"Workflow", workflowlist, workflowrender) {
			protected boolean wantOnSelectionChangedNotifications() {
				if (this.getModelObject() != null) {
					ServiceLocator
							.getInstance()
							.getWorkflowService()
							.getWorkFlowNodes(
									((WorkFlowDTO) this.getModelObject())
											.getOid());
					workflowId = ((WorkFlowDTO) this.getModelObject()).getOid();

				}
				return true;
			}
		};

		add(wkfdrop);

		ServiceLocator.getInstance().getEstadosService().getAllEstados();

		// List of proxnode
		listItems = new RepeatingView("listprox");

		add(listItems);

		// Prepare the modal page for next state selection
		modalWindow = new ModalWindow("modalWindow", wkfdrop.getDefaultModel());
		modalWindow.setPageCreator(new PageCreator() {

			@Override
			public Page createPage() {

				PageParameters parameters = new PageParameters();
				parameters.add("workflowId", workflowId);
				parameters.add("estadoOid",
						((NodoDTO) getModelObject()).getOid());
				return new ProximosEstados(parameters, (WebPage) modalWindow
						.getParent().getPage());
			}
		});

		modalWindow.setTitle("Selecione los Proximos estados y confirme");
		modalWindow.setWindowClosedCallback(new WindowClosedCallback() {

			@Override
			public void onClose(AjaxRequestTarget target) {

				setResponsePage(EstadosPage.class);

			}
		});

		AjaxLink<String> ajaxLink = new AjaxLink<String>("viewLink") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				try {
					modalWindow.show(target);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		modalWindow.setParent(this);
		ajaxLink.setParent(this);

		add(ajaxLink);

		add(modalWindow);

		// In the first page load, all fields in blank
		clearForm();

	}

	void clearForm() {
		NodoDTO mnodo = new NodoDTO();
		List<NodoDTO> prox = new ArrayList<NodoDTO>();
		mnodo.setProxEstado(prox);
		this.bindForm(mnodo);
	}

	void bindForm(NodoDTO mnodo) {
		// Bind the form fields according to the selected
		setDefaultModel(new CompoundPropertyModel<NodoDTO>(mnodo));

		// Bind the list manually cuz compoundModel doens't work with multiple
		// choice list - shit
		Iterator<NodoDTO> _itNodos = mnodo.getProxEstado().iterator();
		NodoDTO _nodo = new NodoDTO();

		if (!_itNodos.hasNext())
			listItems.removeAll();

		while (_itNodos.hasNext()) {
			_nodo = _itNodos.next();

			listItems.add(new Label(listItems.newChildId(), _nodo.getName()));

		}

	}

	@Override
	protected final void onSubmit() {
		if (((NodoDTO) this.getDefaultModelObject()).getOid() == null)
			_nodo = ServiceLocator
					.getInstance()
					.getEstadosService()
					.addEstado(
							(NodoDTO) this.getDefaultModelObject(),
							((NodoDTO) this.getDefaultModelObject())
									.getWorkflow());
		else {

			_nodo = ServiceLocator.getInstance().getEstadosService()
					.changeEstado((NodoDTO) this.getDefaultModelObject());
			this.setDefaultModelObject(_nodo);
		}

		setResponsePage(EstadosPage.class);
	}

}
