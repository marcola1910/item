/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * @author marcmarinho
 *
 */
public class ProyectosDataFields extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4727086060676126107L;

	/**
	 * @param id
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProyectosDataFields(String id) {
		super(id);
		
		setDefaultModel(new CompoundPropertyModel(this));
		
		Form mtform = new ProyectosForm("pyctForm");
		add(mtform);
		
	}


}
