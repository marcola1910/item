package org.exnihilo;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

@SuppressWarnings({ "serial", "rawtypes" })
public class TypeForm extends Form {
	
	@SuppressWarnings("unused")
	private DropDownChoice<WorkFlowDTO> drpList;
	@SuppressWarnings("unused")
	private ItemTypeDTO _itenType;
	
	@SuppressWarnings("unchecked")
	public TypeForm(String id) {
		super(id);
		
		ItemTypeDTO mItemtype = new ItemTypeDTO();
		List<WorkFlowDTO> workflowlist = ServiceLocator.getInstance().getWorkflowService().getAllWorkflows();
		
		ChoiceRenderer typeRenderer = new ChoiceRenderer( "Name", "oid");
		
		add( new Label("Oid")  );
		add( new  RequiredTextField("Titulo"));
		add( new RequiredTextField("Descripcion"));
		
		DropDownChoice<WorkFlowDTO> drpwrkf = new DropDownChoice<WorkFlowDTO>("Workflow", workflowlist, typeRenderer)   {
			protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
			
		};
		
		drpwrkf.setRequired(true);
		add(drpwrkf );
		add(new FeedbackPanel("mfeed"));
		
		this.bindForm(mItemtype);
		
	}
	
	public void bindForm(ItemTypeDTO type ){
		setDefaultModel(new CompoundPropertyModel<ItemTypeDTO>(type));
	}
	
	protected final void onSubmit() {
		
		if ( ((ItemTypeDTO) this.getDefaultModelObject()).getOid() == null )
			_itenType = ServiceLocator.getInstance().getItemTypeService().addItemType((ItemTypeDTO) this.getDefaultModelObject());
		else
			_itenType = ServiceLocator.getInstance().getItemTypeService().changeItemType((ItemTypeDTO) this.getDefaultModelObject());
		
		setResponsePage(ItenType.class);
		
	}

}
