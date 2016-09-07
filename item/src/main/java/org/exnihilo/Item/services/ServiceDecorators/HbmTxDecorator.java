/**
 * 
 */
package org.exnihilo.Item.services.ServiceDecorators;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.hibernate.SessionFactory;

/**
 * @author marcmarinho
 *
 */
public abstract class HbmTxDecorator extends TxDecorator {

	private static SessionFactory sessionFactory;
	


	
	public HbmTxDecorator() {
	
	}
	
	/**
	 * 
	 */
	public HbmTxDecorator(BaseServiceImpl servicio ) {
		
		super(servicio);
		
	}
	
	
	
	public void save(ItemSys aRoot){
		
	}

	/**
	 * @return the sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HbmTxDecorator.sessionFactory = sessionFactory;
	}

	
		

}
