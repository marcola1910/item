package org.exnihilo.Item.repositories.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.model.Equipo;
import org.exnihilo.Item.model.MiembroEquipo;

public interface EquipoRepositoryBI {
	
	public Collection<Equipo> getEquipobyName(String name);
	public Equipo getEquipobyId(String id);
	public Collection<Equipo> getEquipobyMiembro(String nombreMiembro);
	public MiembroEquipo getMiembroEquipobyId(String oID);
	public List<MiembroEquipo> getAllMiembros(String equipoOid);

}
