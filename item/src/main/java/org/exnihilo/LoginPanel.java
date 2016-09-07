package org.exnihilo;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

@SuppressWarnings({ "serial"})
public class LoginPanel extends Panel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6508080295684154917L;

	@SuppressWarnings("rawtypes")
	public LoginPanel(String id) {
		super(id);
		
		add( new FeedbackPanel("mfeed") );
		
		/*add(new Link("goToHomePage") {
			@Override
			public void onClick() {
				setResponsePage(getApplication().getHomePage());
			}
		});
		*/
		add(new Link("loggout") {
			@Override
			public void onClick() {
				UserSession.getInstance().setUsuario(null);
				setResponsePage(getApplication().getHomePage());
			}
		});
		
		add( new LoginForm("loginForm"));
		
	}

	
}
