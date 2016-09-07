package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Equipo;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.MiembroEquipo;
import org.exnihilo.Item.repositories.bi.EquipoRepositoryBI;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EquipoRepositoryHbm extends RepositoryHbm implements EquipoRepositoryBI {

	
	private ItemSys rootobject; 
	
	public EquipoRepositoryHbm() {
		// TODO Auto-generated constructor stub
	}

	public EquipoRepositoryHbm(ItemSys rootobj ) {
		this.rootobject = rootobj;
		
	}
	
	@Override
	public Collection<Equipo> getEquipobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo getEquipobyId(String id) {
		
		Query query =  super.getSessionFactory().getCurrentSession().createQuery("from Equipo where oid = :oid ");
		query.setParameter("oid", id);
		Equipo _result = (Equipo) query.uniqueResult();
		
		return _result;
	}

	@Override
	public Collection<Equipo> getEquipobyMiembro(String nombreMiembro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroEquipo getMiembroEquipobyId(String oID){
		
		Query query =  super.getSessionFactory().getCurrentSession().createQuery("from MiembroEquipo where oid = :oid ");
		query.setParameter("oid", oID);
		MiembroEquipo _result = (MiembroEquipo) query.uniqueResult();
		
		return _result; 
	}
	
	@Override
	public List<MiembroEquipo> getAllMiembros(String equipoOid){
		
		if(equipoOid == null){
			Query query =  super.getSessionFactory().getCurrentSession().createQuery("from MiembroEquipo");
			List<MiembroEquipo> _result = query.list();
			return _result;
		}
		else{
						
			Query query =  super.getSessionFactory().getCurrentSession().createQuery("from Equipo where oid = :oid");
					
			query.setParameter("oid", equipoOid);
			Equipo _result = (Equipo) query.uniqueResult();
			return _result.getMiembros();
		}
	}
}
