/**
 * 
 */
package org.exnihilo;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.UsuarioDTO;

/**
 * @author marcmarinho
 *
 */
public class EmailAlreadyExistsValidator implements IValidator<String> {

	/**
	 * 
	 */
	public EmailAlreadyExistsValidator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void validate(IValidatable<String> email) {
		
		UsuarioDTO user = ServiceLocator.getInstance().getUserService().getUserByEmail(email.getValue().toString());

		if(user.getEmail() != null)
			email.error(new ValidationError().setMessage("Email ya exite"));
		

	}


}
