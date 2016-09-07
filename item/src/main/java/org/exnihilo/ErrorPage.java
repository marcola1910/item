/**
 * Este paquete contiene las clases que representan las diferentes p�ginas de la 
 * aplicaci�n.
 */
package org.exnihilo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Las instancias de esta clase se utilizan para mostrar condiciones de error en
 * la aplicaci�n.
 * 
 * @author Javier Bazzocco javier.bazzocco@zinbig.com
 * 
 */
public class ErrorPage extends BasePage {

	/**
	 * Constructor.
	 */
	public ErrorPage(PageParameters parameters) {
		super(parameters);
		
		Label errormsg = new Label("msg", parameters.get("error").toString() );
		
		add(errormsg);
		
	}

	/**
	 * Getter.
	 * 
	 * @return true ya que esta clase representa una clase de error
	 */
	@Override
	public boolean isErrorPage() {
		return true;
	}

}
