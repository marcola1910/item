package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Equipo;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.MiembroEquipo;
import org.exnihilo.Item.repositories.bi.EquipoRepositoryBI;

public class EquipoRepositoryImpl implements EquipoRepositoryBI {

	
	private ItemSys rootobject; 
	
	public EquipoRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	public EquipoRepositoryImpl(ItemSys rootobj ) {
		this.rootobject = rootobj;
		
	}
	
	@Override
	public Collection<Equipo> getEquipobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo getEquipobyId(String id) {
		
		Equipo _equipo = new Equipo();
		Equipo _result = new Equipo();
		
		Iterator<Equipo> iterator = this.rootobject.getEquipos().iterator();
		
		while (iterator.hasNext()) {
			_equipo = iterator.next();
			if (_equipo.getOid().equals(id))
				_result = _equipo;
		}
		
		return _result;
	}

	@Override
	public Collection<Equipo> getEquipobyMiembro(String nombreMiembro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroEquipo getMiembroEquipobyId(String oID){
		
		MiembroEquipo _miembro = new MiembroEquipo();
		MiembroEquipo _result = new MiembroEquipo();
		
		Iterator<MiembroEquipo> iterator = this.rootobject.getMiembros().iterator();

		// varre la collecion
		while (iterator.hasNext()) {
			_miembro = iterator.next();
			if(_miembro.getOid().equals(oID))
				_result = _miembro;
			
		}
		
		return _result; 
	}
	
	@Override
	public List<MiembroEquipo> getAllMiembros(String equipoOid){
		
		if(equipoOid == null)
			return this.rootobject.getMiembros();
		else{
			return this.getEquipobyId(equipoOid).getMiembros();
		}
	}
}
