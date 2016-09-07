package org.exnihilo;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

@SuppressWarnings("serial")
public class UserDataFields extends Panel {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserDataFields(String id) {
		super(id);
		
		setDefaultModel(new CompoundPropertyModel(this));
		
		Form mform = new UserAdmForm("userForm");
		add(mform);
		
		
	}

	public UserDataFields(String id, IModel<?> model) {
		super(id, model);
		// TODO Auto-generated constructor stub
	}

}
