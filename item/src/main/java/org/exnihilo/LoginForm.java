package org.exnihilo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.UsuarioDTO;

@SuppressWarnings("rawtypes")
public class LoginForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3455076453667391782L;
	private String username;
	private String password;
	@SuppressWarnings("unused")
	private String loginStatus;

	@SuppressWarnings("unchecked")
	public LoginForm(String id) {

		super(id);
		setDefaultModel(new CompoundPropertyModel(this));
		
		add(new TextField("username"));
		add(new PasswordTextField("password"));
		add(new Label("loginStatus"));
		
		if (this.getSession().getAttribute("auth") != null)
		{
			if( this.getSession().getAttribute("auth").equals(true) )
				this.setVisible(false);
		}
	}

	protected final void onSubmit() {
		UsuarioDTO _user = ServiceLocator.getInstance().getUserService()
				.checkLogin(username, password);
		
		UserSession.getInstance().setUsuario(_user);
		
		if (UserSession.getInstance().getUsuario().isLoginCHecked()){
			this.setVisible(false);
			setResponsePage(AsignedItens.class);
		}
		else{
			loginStatus = "Wrong username or password !";
		}
		
		
	}
}
