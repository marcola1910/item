package org.exnihilo.Item.repositories.bi;

import java.util.Collection;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;

public interface WorkFlowRepositoryBI extends ItemAbstractRepositoryBI {

	public Collection<Nodo> findNodosByWorkFlowId(String id);
	public Collection<WorkFlow> findWorkFlowbyName(String name);
	public WorkFlow findWorkflowbyid(ItemSys rootObj ,String oid);
	
	
}
