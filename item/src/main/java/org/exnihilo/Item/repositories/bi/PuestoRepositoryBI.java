package org.exnihilo.Item.repositories.bi;

import java.util.Collection;

import org.exnihilo.Item.model.Puesto;

public interface PuestoRepositoryBI {
	
	public Puesto getPuestobyId(String puestoId);
	public Collection<Puesto> getPuestobyName(String name);
	public Collection<Puesto> getPuestos();
	
	public int puestoExists(String puestoId);

}
