package org.exnihilo.Item.repositories.bi;

import java.util.Collection;

import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Puesto;

public interface ProyectosSoftwareBI {
	
	public ProyectosSoftwareBI getPuestobyId(String proyectoId);
	public Collection<ProyectosSoftwareBI> getProyectobyName(String name);
	public Collection<Puesto> getProyectos();
	public ProyectoSoftware getProyectobyId(String oId);	
	public int proyectoExists(String puestoId);
	public void delete(Object o) throws Exception;


}
