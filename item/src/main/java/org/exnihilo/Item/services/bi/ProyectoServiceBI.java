package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.util.ProyectoDTO;

public interface ProyectoServiceBI {
	public ProyectoDTO addProyecto(ProyectoDTO proyecto);
	public ProyectoDTO changeProyecto(ProyectoDTO proyecto);
	public Collection<ProyectoDTO> getProyecto(ProyectoDTO proyectoFilter);
	public void deleteProyecto(String proyectoId) throws Exception;
	public List<ProyectoDTO> getAllProyects();
	

}
