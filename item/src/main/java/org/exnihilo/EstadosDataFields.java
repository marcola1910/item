/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.exnihilo.Item.util.WorkFlowDTO;

/**
 * @author marcmarinho
 *
 */
@SuppressWarnings("serial") 
public class EstadosDataFields extends Panel {

	@SuppressWarnings("unused")
	private DropDownChoice<WorkFlowDTO> drpList;
	
	/**
	 * @param id
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EstadosDataFields(String id) {
		super(id);
		
		//Load the form and all the forms components 
		Form mtform = new EstadoForm("estadoForm");
		add(mtform); 
		
		setDefaultModel(new CompoundPropertyModel(this));
		
	}

	

}
