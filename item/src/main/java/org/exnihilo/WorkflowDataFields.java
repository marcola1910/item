/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * @author marcmarinho
 *
 */
public class WorkflowDataFields extends Panel {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1281845445412152335L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public WorkflowDataFields(String id) {
		super(id);
		
		setDefaultModel(new CompoundPropertyModel(this));
		
		Form mform = new WorkflowForm("workForm"); 
		
		mform.add( new FeedbackPanel("mfeed") );
		
		add(mform);

		
	}

}
