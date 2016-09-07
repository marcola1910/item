package org.exnihilo.Item.services.ServiceDecorators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.WorkflowServicesBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.LinkDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

public class WorkFlowServicesTxHbm extends HbmTxDecorator implements
		WorkflowServicesBI {

	public WorkFlowServicesTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public WorkFlowServicesTxHbm(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	
	public WorkFlowServicesTxHbm( BaseServiceImpl service ) {
		
		super(service);
		
	}

	
	@Override
	public WorkFlowDTO addWorkFlow(WorkFlowDTO workflow) {

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		WorkFlowDTO _wrkf =  ((WorkflowServicesBI) super.getServicio()).addWorkFlow(workflow);
		
		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
				
		
		
		return _wrkf;
	}

	@Override
	public void addNodo(NodoDTO nodo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLink(LinkDTO link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNodo(NodoDTO nodo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLink(LinkDTO link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteWorkFlow(WorkFlowDTO workflow) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<WorkFlowDTO> getWorkflow(WorkFlowDTO workflow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkFlowDTO> getWorkflowbyId(String wrkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkFlowDTO> getAllWorkflows() {

		List<WorkFlowDTO> _result = new ArrayList<WorkFlowDTO>();
		
		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		_result =  ((WorkflowServicesBI) super.getServicio()).getAllWorkflows();
		
		

		return _result;
	}

	public List<NodoDTO> getWorkFlowNodes(String workflowId) {

		List<NodoDTO> _result = new ArrayList<NodoDTO>();

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		_result =  ((WorkflowServicesBI) super.getServicio()).getWorkFlowNodes(workflowId);
		
		return _result;
	}

	@Override
	public WorkFlowDTO changeWorkflow(WorkFlowDTO defaultModelObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllWorkflowNodesJson(String WorkflowID) {
		
		String _result;
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		_result =  ((WorkflowServicesBI) super.getServicio()).getAllWorkflowNodesJson(WorkflowID);
		
		return _result;
		
	}

	
}
