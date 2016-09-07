package org.exnihilo.Item.services.mock;

import java.util.Collection;

import org.exnihilo.Item.model.Puesto;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.PuestoServiceBI;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.PuestoDTO;

public class PuestoServiceImpl extends BaseServiceImpl implements PuestoServiceBI {

	public PuestoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public PuestoServiceImpl( ItemSysRepositoryBI repository ) {
		
		super.set_itemSysRepository(repository);
		
	}
	
	@Override
	public PuestoDTO addPuesto(PuestoDTO puesto) {
		Puesto _puesto = new Puesto();
		
		_puesto.setName( puesto.getName());
		_puesto.setOid(IDGenerator.getId());
		_puesto.setVersion(0);
		
		RepositoryLocator.getInstance().getItemSysRepository().findItemSys().addPuesto(_puesto);
		
		puesto.setOid(_puesto.getOid());
		
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
