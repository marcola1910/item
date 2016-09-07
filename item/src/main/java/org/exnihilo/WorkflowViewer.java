/**
 * 
 */
package org.exnihilo;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.exnihilo.Item.services.ServiceLocator;

/**
 * @author marcmarinho
 *
 */
public class WorkflowViewer extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1934844621519261674L;
	
	private String workflowoid;
	private String workflowname;

	@SuppressWarnings("serial")
	public WorkflowViewer(PageParameters parameters, WebPage target) {
		super(parameters);
		List<StringValue> values = parameters.getValues("workflowId");
		
		
		
		if (values != null)
			this.workflowoid = values.get(0).toString();
		else
			this.workflowoid = null;

		List<StringValue> workname = parameters.getValues("workflowname");
		if (workname != null)
			this.workflowname = workname.get(0).toString();
		else
			this.workflowname = null;
		
		Form<?> mform = new Form<Object>("vwform");
		
		mform.add(new Label("wkfwname", workflowname) );
		
		
		
		mform.add(new Behavior() {
			public void afterRender(Component component) {

				Response response = component.getResponse();
				
				final String nodes = ServiceLocator.getInstance().getWorkflowService()
						.getAllWorkflowNodesJson(workflowoid);
				
				if (nodes != null)
					response.write(nodes);
			}
		});
		
		add(mform);
	}

	@SuppressWarnings("unused")
	private void createForm() {
		

	}

	/**
	 * 
	 */
	public WorkflowViewer() {

	}

}
