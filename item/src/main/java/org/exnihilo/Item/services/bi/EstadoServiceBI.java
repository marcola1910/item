package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

public interface EstadoServiceBI {
	
	
	
	public NodoDTO changeEstado(NodoDTO estado);
	public Collection<NodoDTO> getEstado(NodoDTO estado);
	public void addProxEstado(WorkFlowDTO workflow, NodoDTO estado);
	public void deleteEstado(String estadoID, String workflowId) throws Exception;
	public NodoDTO addEstado(NodoDTO estado, WorkFlowDTO workflow);
	public List<NodoDTO> getAllEstados();
	public List<NodoDTO> addProxEstado(String Oid, String workflowid, List<NodoDTO> proxEstados);
	public NodoDTO getEstadoByID(String oid, String workflow);

}
