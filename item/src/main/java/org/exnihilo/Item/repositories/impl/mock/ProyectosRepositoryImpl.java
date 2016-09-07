package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Puesto;
import org.exnihilo.Item.repositories.bi.ProyectosSoftwareBI;

public class ProyectosRepositoryImpl implements ProyectosSoftwareBI {

	
	private ItemSys rootobject; 

	public ProyectosRepositoryImpl()  {
		// TODO Auto-generated constructor stub
	}

	public ProyectosRepositoryImpl( ItemSys rootobj ) {
		
		this.rootobject = rootobj;
	}
	
	@Override
	public ProyectosSoftwareBI getPuestobyId(String proyectoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ProyectosSoftwareBI> getProyectobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProyectoSoftware getProyectobyId(String oId) {
		
		ProyectoSoftware _proySeek = new ProyectoSoftware();
		ProyectoSoftware _result = new ProyectoSoftware();
		
		Iterator<ProyectoSoftware> iterator = this.rootobject.getProyectos().iterator();  
		
		//varre la collecion
		while (iterator.hasNext()) {
			_proySeek = iterator.next();
			if (_proySeek.getOid().equals(oId)) {
				_result = _proySeek;
			}
		}
		
		return _result;
	}

	@Override
	public Collection<Puesto> getProyectos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int proyectoExists(String puestoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Object o) throws Exception {
	
		
	}

}
