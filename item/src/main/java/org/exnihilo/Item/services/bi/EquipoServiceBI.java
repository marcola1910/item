package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;

public interface EquipoServiceBI {
	
	public EquipoDTO addEquipo(EquipoDTO equipo);
	public void changeEquipo(EquipoDTO equipo);
	public void deleteEquipo(String EquipoID);
	public Collection<EquipoDTO> getEquipo(EquipoDTO equipofilter);
	MiembroEquipoDTO addMiembro(MiembroEquipoDTO miembro);
	public List<EquipoDTO> getAllEquipos();
	public List<MiembroEquipoDTO> getAllMiembros(String equipoOid);

}
