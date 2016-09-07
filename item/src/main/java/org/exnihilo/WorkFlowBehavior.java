/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.request.Response;

/**
 * @author marcmarinho
 *
 */
public class WorkFlowBehavior extends Behavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3305387877381870686L;

	/**
	 * 
	 */
	public WorkFlowBehavior() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void afterRender(Component component){
		
		Response response = component.getResponse(); 
		response.write("<script>alert('oloko');</script>");
		
	}
	

}
