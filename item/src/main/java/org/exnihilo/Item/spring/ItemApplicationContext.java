package org.exnihilo.Item.spring;

import java.io.Serializable;
import org.springframework.context.ApplicationContext;

public class ItemApplicationContext implements Serializable {

	/**
	 * UID por defecto para la serializaciÛn.
	 */
	private static final long serialVersionUID = -8314525704793980700L;

	/**
	 * Mantiene una referencia del contexto de la aplicaciÛn.
	 */
	private static ApplicationContext applicationContext;

	/**
	 * Setter.
	 * 
	 * @param aContext
	 *            es el contexto de la aplicaciÛn inyectado a travÈs de la clase
	 *            ApplicationContextoProvider.
	 */
	public static void setApplicationContext(ApplicationContext aContext) {
		applicationContext = aContext;
	}

	/**
	 * Getter.
	 * 
	 * @return el contexto de la aplicaciÛn.
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
