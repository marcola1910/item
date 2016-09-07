package org.exnihilo.Item.services.ServiceDecorators;

import java.util.Collection;

import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.PuestoServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.PuestoDTO;

public class PuestoServiceTxHbm extends HbmTxDecorator implements PuestoServiceBI {

	public PuestoServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public PuestoServiceTxHbm( ItemSysRepositoryBI repository ) {
		
		super.set_itemSysRepository(repository);
		
	}
	
	public PuestoServiceTxHbm( BaseServiceImpl service ) {
		
		super(service);
		
	}
	
	
	@Override
	public PuestoDTO addPuesto(PuestoDTO puesto) {

		
		
		puesto = ((PuestoServiceBI) super.getServicio()).addPuesto(puesto);
		
		
		
		return puesto;
		
	}

	@Override
	public void changePuesto(PuestoDTO puesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePuesto(String puestoid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PuestoDTO> getPuestoDTO(PuestoDTO puesto) {
		// TODO Auto-generated method stub
		return null;
	}

}
