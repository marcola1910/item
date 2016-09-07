package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Puesto;
import org.exnihilo.Item.repositories.bi.ProyectosSoftwareBI;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectosRepositoryHbm extends RepositoryHbm implements ProyectosSoftwareBI {

	
	private ItemSys rootobject; 

	public ProyectosRepositoryHbm()  {
		// TODO Auto-generated constructor stub
	}

	public ProyectosRepositoryHbm( ItemSys rootobj ) {
		
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
		
		//crea una consulta desde la sesion seteada al principio en el init del repository
		Query query = super.getSessionFactory().getCurrentSession().createQuery("from ProyectoSoftware where oid = :oid ");
		query.setParameter("oid", oId);
		ProyectoSoftware _result = (ProyectoSoftware) query.uniqueResult();
		
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

	public void delete(Object o) throws Exception {
		super.delete(o);
		
	}
}
