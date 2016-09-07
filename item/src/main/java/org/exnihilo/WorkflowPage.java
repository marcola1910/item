package org.exnihilo;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.WorkFlowDTO;

public class WorkflowPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893993139306272553L;
	private List<WorkFlowDTO> _wrkflist = new ArrayList<WorkFlowDTO>();
	
	public WorkflowPage(PageParameters parameters) {
		super(parameters);
		
		_wrkflist = ServiceLocator.getInstance().getWorkflowService()
					.getAllWorkflows();

		this.popTypes();
		
		add(new WorkflowDataFields("wkflwDataFields"));
		add(new Label("loggedUser"));


	}

	public void popTypes() {
		ListDataProvider<WorkFlowDTO> listDataProvider = new ListDataProvider<WorkFlowDTO>(
				_wrkflist);

		@SuppressWarnings("serial")
		DataView<WorkFlowDTO> dataView = new DataView<WorkFlowDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<WorkFlowDTO> item) {
				WorkFlowDTO type = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getOid() ));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getName() ));
				
				repeatingView
						.add(new Link<WorkFlowDTO>("Edit", item.getModel()) {
							@Override
							public void onClick() {
								// llamada al metodo que llena el form
								WorkflowForm usrWkfw = (WorkflowForm) this.getParent()
										.getParent().getParent().getParent()
										.get("wkflwDataFields").get("workForm");
								usrWkfw.bindForm((WorkFlowDTO) this
										.getDefaultModelObject());
							}
						});

				repeatingView.add(new Link<WorkFlowDTO>("Delete", item
						.getModel()) {
					@Override
					public void onClick() {
						// llamada al delete usr service
						ServiceLocator
								.getInstance()
								.getWorkflowService() 
								.deleteWorkFlow(
										((WorkFlowDTO) this
												.getDefaultModelObject())
												);
						setResponsePage(WorkflowPage.class);
					}
				});
				
				item.add(repeatingView);
			}
		};
		add(dataView);
	}
	
}
