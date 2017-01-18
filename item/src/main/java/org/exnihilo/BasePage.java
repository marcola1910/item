package org.exnihilo;

import javax.servlet.http.HttpSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private static HttpSession _session;
	public BasePage(final PageParameters parameters) {
		super(parameters);
		
		Panel loginPanel = new LoginPanel("loginPanel");		
		add( loginPanel );
		
		Panel menuPanel = new MenuPanel("menuPanel");		
		add(menuPanel);
		
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		
		if ( (UserSession.getInstance().getUsuario() == null) || (!UserSession.getInstance().getUsuario().isLoginCHecked()) ){
				loginPanel.get("loginForm").setVisible(true);
				loginPanel.get("loggout").setVisible(false);
				
				if(this.getClass() != HomePage.class)
					setResponsePage(HomePage.class);
				
			}
			else{
				loginPanel.get("loginForm").setVisible(false);
				loginPanel.get("loggout").setVisible(true);
				this.showlinks( UserSession.getInstance().getUsuario().getNombre().equals("Adm") );
				
			}
		
		
	}
	private void showlinks(boolean isAdm) {
		
		
		 this.get("menuPanel").get("linkMenuAsigned").setVisible(true);
		 this.get("menuPanel").get("linkMenuIten").setVisible(true);
		 
		 if(isAdm){
			 this.get("menuPanel").get("linkMenuItenType").setVisible(true);
			 this.get("menuPanel").get("linkMenuUsuarios").setVisible(true);
			 this.get("menuPanel").get("linkMenuEstados").setVisible(true);
			 this.get("menuPanel").get("linkMenuWorkflow").setVisible(true);
			 this.get("menuPanel").get("linkProyectos").setVisible(true);
		 }
			 
		
		
	}
	public static HttpSession get_session() {
		return _session;
	}
	public static void set_session(HttpSession _session) {
		BasePage._session = _session;
	}

}
