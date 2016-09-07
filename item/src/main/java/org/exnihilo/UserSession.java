/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.exnihilo.Item.util.UsuarioDTO;

/**
 * @author marcmarinho
 *
 */
public class UserSession extends WebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932857834071725066L;

	private UsuarioDTO usuario;

	/**
	 * @param request
	 */
	public UserSession(Request request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	
	public static UserSession getInstance(){
		return (UserSession) Session.get();
	}


	public UsuarioDTO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
