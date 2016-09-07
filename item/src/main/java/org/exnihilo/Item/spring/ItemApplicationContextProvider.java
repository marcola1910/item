/**
 * Este paquete contiene clases �tiles para trabajar con el framework Spring.
 */
package org.exnihilo.Item.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ItemApplicationContextProvider implements ApplicationContextAware {

	/**
	 * Constructor.
	 */
	public ItemApplicationContextProvider() {

		super();
	}

	@Override
	public void setApplicationContext(ApplicationContext aContext)
			throws BeansException {
		ItemApplicationContext.setApplicationContext(aContext);
	}

}
