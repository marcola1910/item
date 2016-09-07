/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.WorkFlowDTO;

/**
 * @author marcmarinho
 *
 */
@SuppressWarnings("rawtypes")
public class WorkflowForm extends Form {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7296445116201225307L;

	WorkFlowDTO mworkflow = new WorkFlowDTO();
	String nodes = null;
	private ModalWindow modalWindow;

	private String workflowid;

	private String workflowname;

	public WorkflowForm(final String id) {
		super(id);

		WorkFlowDTO _workflow = new WorkFlowDTO();

		add(new Label("oid"));
		add(new TextField("Name"));
		AjaxLink<String> alink = new AjaxLink<String>("lnkshow") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8018879757663434712L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				
				try{
					modalWindow.show(target);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		};

		modalWindow = new ModalWindow("modalWindow");
		modalWindow.setPageCreator(new PageCreator() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 626535119426944496L;

			@Override
			public Page createPage() {

				if (((WorkFlowDTO) getDefaultModelObject()) != null) {
					workflowid = ((WorkFlowDTO) getDefaultModelObject())
							.getOid();
					workflowname = ((WorkFlowDTO) getDefaultModelObject())
							.getName();
				}

				PageParameters parameters = new PageParameters();
				parameters.add("workflowId", workflowid);
				parameters.add("workflowname", workflowname);
				return new WorkflowViewer(parameters, (WebPage) modalWindow
						.getParent().getPage());
			}
		});

		modalWindow.setTitle("Visualizacion de los nodos del Worflow");
		modalWindow.setInitialHeight(1000);
		modalWindow.setInitialWidth(1600);
		modalWindow.setHeightUnit("px");
		modalWindow.setWidthUnit("px");
		modalWindow.setWindowClosedCallback(new WindowClosedCallback() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -689026695713120823L;

			@Override
			public void onClose(AjaxRequestTarget target) {

				setResponsePage(WorkflowPage.class);

			}
		});

		alink.setParent(this);

		add(alink);

		add(modalWindow);

		this.bindForm(_workflow);

	}

	public void bindForm(WorkFlowDTO wrkflw) {
		setDefaultModel(new CompoundPropertyModel<WorkFlowDTO>(wrkflw));
	}

	protected final void onSubmit() {

		if (((WorkFlowDTO) this.getDefaultModelObject()).getOid() == null)
			mworkflow = ServiceLocator.getInstance().getWorkflowService()
					.addWorkFlow((WorkFlowDTO) this.getDefaultModelObject());
		else
			mworkflow = ServiceLocator.getInstance().getWorkflowService()
					.changeWorkflow((WorkFlowDTO) this.getDefaultModelObject());

		setResponsePage(WorkflowPage.class);

	}

}
