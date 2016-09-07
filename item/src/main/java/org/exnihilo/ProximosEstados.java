package org.exnihilo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.NodoDTO;

public class ProximosEstados extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7851405934035624480L;
	private String workflowoid;
	private String estadoOid;
	private List<NodoDTO> estadoslist;
	@SuppressWarnings("unused")
	private WebPage targetPage;
	private List<NodoDTO> selectedList = new ArrayList<NodoDTO>();

	

	public ProximosEstados(PageParameters parameters, WebPage target) {
		super(parameters);
		List<StringValue> values = parameters.getValues("workflowId");
		this.targetPage = target;
		if (values != null)
			this.workflowoid = values.get(0).toString();
		else
			this.workflowoid = null;
		
		List<StringValue> estadooid = parameters.getValues("estadoOid");
		if (estadooid != null)
			this.estadoOid = estadooid.get(0).toString();
		else
			this.estadoOid = null;
		
		createForm();
	}
	
	@SuppressWarnings({ "unchecked", "serial" })
	void createForm() {

		estadoslist = ServiceLocator.getInstance().getWorkflowService()
				.getWorkFlowNodes(this.workflowoid);

		// Set up the visible fields of the ProxEstados
		@SuppressWarnings("rawtypes")
		ChoiceRenderer render = new ChoiceRenderer("Name", "oid");

		@SuppressWarnings("rawtypes")
		Form frmEstados = new Form("frmEstados"); 
		@SuppressWarnings({ "rawtypes" })
		ListMultipleChoice manyChoice = new ListMultipleChoice("choices",
				new Model((Serializable) selectedList),estadoslist).setMaxRows(5);
		manyChoice.setChoiceRenderer(render);
		frmEstados.add(manyChoice);
		
		frmEstados.add(new Button("button") {
			@Override
			public void onSubmit() {
				
				final ListMultipleChoice<NodoDTO> mcho = (ListMultipleChoice<NodoDTO>) this.getParent().get("choices");
				
				ServiceLocator.getInstance().getEstadosService().addProxEstado(  estadoOid, workflowoid , (List<NodoDTO>)  mcho.getDefaultModelObject());
				
				info("button1.onSubmit executed");
			}
		});
		
		add(frmEstados);
		
	
	}

}
