package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.util.LinkDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

public interface WorkflowServicesBI {
	public WorkFlowDTO addWorkFlow(WorkFlowDTO workflow);
	public void addNodo(NodoDTO nodo);
	public void addLink( LinkDTO link);
	public void removeNodo(NodoDTO nodo);
	public void removeLink(LinkDTO link);
	public void deleteWorkFlow(WorkFlowDTO workflow);
	
	public Collection<WorkFlowDTO> getWorkflow(WorkFlowDTO workflow);
	public Collection<WorkFlowDTO> getWorkflowbyId(String wrkId);
	public List<WorkFlowDTO> getAllWorkflows();
	public List<NodoDTO> getWorkFlowNodes(String workflowId);
	public WorkFlowDTO changeWorkflow(WorkFlowDTO defaultModelObject);
	
	public String getAllWorkflowNodesJson(String WorkflowID);
}
