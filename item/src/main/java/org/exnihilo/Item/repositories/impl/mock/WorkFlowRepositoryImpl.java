package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;


import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.bi.WorkFlowRepositoryBI;

public class WorkFlowRepositoryImpl implements WorkFlowRepositoryBI {
	
	private ItemSys rootobject; 
	
	public WorkFlowRepositoryImpl( ItemSys rootobj ) {
		
		this.rootobject = rootobj;
	}
	
	
	public WorkFlowRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleObjects(Collection<Object> co) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findbyId(String oid) {

		
		return null;
	}

	@Override
	public Collection<Nodo> findNodosByWorkFlowId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkFlow> findWorkFlowbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkFlow findWorkflowbyid(ItemSys rootObj ,String oid) {
		
		WorkFlow _workflow;
		WorkFlow _result = new WorkFlow();
		
		Iterator<WorkFlow> iterator = this.rootobject.getWorkflows().iterator() ;
		

		while (iterator.hasNext()) {
			_workflow = iterator.next();
			if (_workflow.getOid().equals(oid)) {
				_result = _workflow;
			}
		}
		
		
		return _result;
	}

}
