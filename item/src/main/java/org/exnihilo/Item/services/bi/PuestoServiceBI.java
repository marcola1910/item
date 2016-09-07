package org.exnihilo.Item.services.bi;

import java.util.Collection;

import org.exnihilo.Item.util.PuestoDTO;

public interface PuestoServiceBI {
	
	public PuestoDTO addPuesto( PuestoDTO puesto);
	public void changePuesto( PuestoDTO puesto );
	public void deletePuesto (String puestoid);
	public Collection<PuestoDTO> getPuestoDTO(PuestoDTO puesto);
	

}
