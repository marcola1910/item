package org.exnihilo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.model.exceptions.UsernameNotUniqueException;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.UsuarioDTO;

@SuppressWarnings({ "serial", "rawtypes" })
public class UserAdmForm extends Form {

	UsuarioDTO _usr = new UsuarioDTO();
	private EmailTextField email;

	public UserAdmForm(String id) {
		super(id);

		email = new EmailTextField("Email");

		UsuarioDTO _userdto = new UsuarioDTO();
		add(email);
		add(new RequiredTextField("Nombre"));
		add(new Label("Oid"));
		add(new PasswordTextField("Password"));
		add(new RequiredTextField("Telefono"));
		add(new FeedbackPanel("mfeed"));

		this.bindForm(_userdto);

		
	}

	public void bindForm(UsuarioDTO _user) {

		setDefaultModel(new CompoundPropertyModel<UsuarioDTO>(_user));

	}

	protected final void onSubmit() {
		try {
		// busca si hay usuario con el mail asignado
		UsuarioDTO user = ServiceLocator.getInstance().getUserService()
				.getUserByEmail(this.email.getValue().toString());

		if (((UsuarioDTO) this.getDefaultModelObject()).getOid() == null) {

			// Si el mail ya esta en uso
			if (user.getEmail() != null)
				
					throw new UsernameNotUniqueException();
				

			_usr = ServiceLocator.getInstance().getUserService()
					.addUser((UsuarioDTO) this.getDefaultModelObject());
		} else {
			// el email modificado es lo mismo o no esta en uso
			if (user.getEmail() == ((UsuarioDTO) this.getDefaultModelObject())
					.getEmail() || user != null) {

				try {
					_usr = ServiceLocator.getInstance().getUserService()
							.changeUser((UsuarioDTO) this.getDefaultModelObject());
				} catch (ItemConcurrentModificationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		bindForm(_usr);

		((UsersAdm) this.getParent().getParent()).bindUsers();

		setResponsePage(UsersAdm.class);
		
		} catch (UsernameNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
