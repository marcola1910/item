/**
 * 
 */
package org.exnihilo.Item.services.ServiceDecorators;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.services.bi.BaseServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;

/**
 * Clase abstracta con finalidad de decorar la transaccion de un Servicio.
 * Participante del Design Patern: Decorator.
 * 
 * @author marcmarinho
 *
 */
public class TxDecorator extends BaseServiceImpl {

	BaseServiceImpl servicio;
	
	public BaseServiceBI getServicio() {
		return servicio;
	}



	public void setServicio(BaseServiceImpl servicio) {
		this.servicio = servicio;
	}



	/**
	 * 
	 */
	public TxDecorator() {
		
	}
	
	
	
	public TxDecorator(BaseServiceImpl service) {
		this.servicio = service;

	}



	public void beginSession(){
		
	}
	
	public void endSession(){
		
	}
	
	public void save(ItemSys aRoot ){
		
	}

}
