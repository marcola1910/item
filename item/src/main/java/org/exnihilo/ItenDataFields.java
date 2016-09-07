/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * @author marcmarinho
 *
 */
public class ItenDataFields extends Panel {

	/**
	 *   
	 */
	private static final long serialVersionUID = 5818573256572988278L;

	/**
	 * @param id
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ItenDataFields(String id) {
		super(id);

		setDefaultModel(new CompoundPropertyModel(this));

		Form itnform = new ItenForm("itenForm");
		add(itnform);

	}

	/**
	 * @param id
	 * @param model
	 */
	public ItenDataFields(String id, IModel<?> model) {
		super(id, model);
		// TODO Auto-generated constructor stub
	}

}
