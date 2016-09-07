package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;
import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Puesto;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.PuestoRepositoryBI;

public class PuestoRepositoryHbm extends RepositoryHbm implements PuestoRepositoryBI {

	
	public PuestoRepositoryHbm( ItemSys rootobj ) {

	}
	
	
	public PuestoRepositoryHbm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Puesto getPuestobyId(String puestoId) {

		Puesto _result = new Puesto();
		Puesto _puestoseek= new Puesto();

		Iterator<Puesto> iterator = RepositoryLocator.getInstance().getItemSysRepository().findItemSys().getPuestos().iterator();  
		
		//varre la collecion
		while (iterator.hasNext()) {
			_puestoseek = iterator.next();
			if (_puestoseek.getOid().equals(puestoId)) {
				_result = _puestoseek;
			}
		}
		
		return _result;
	}

	@Override
	public Collection<Puesto> getPuestobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Puesto> getPuestos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int puestoExists(String puestoId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
