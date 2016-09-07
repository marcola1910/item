package org.exnihilo.Item.repositories.bi;

import java.util.Collection;

import org.exnihilo.Item.model.Nodo;

public interface NodoRepositoryBI {
	
	public Nodo getEstadobyId(String estadoId);
	public Collection<Nodo> getEstadobyName(String name);
	public Collection<Nodo> getEstados();
	
	public int estadoExists(String estadoId);
	public Nodo getEstadobyId(String estadoId, String workflowid);
	
	public void delete(Object o) throws Exception;

}
