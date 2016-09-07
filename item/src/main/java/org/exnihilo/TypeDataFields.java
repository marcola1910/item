package org.exnihilo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

@SuppressWarnings("serial")
public class TypeDataFields extends Panel {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TypeDataFields(String id) {
		super(id);
		
		setDefaultModel(new CompoundPropertyModel(this));
		
		Form mtform = new TypeForm("typeForm");
		add(mtform);
		
		
	}



}
