package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;


import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.bi.WorkFlowRepositoryBI;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class WorkFlowRepositoryHbm extends RepositoryHbm implements WorkFlowRepositoryBI {
	
	private ItemSys rootobject; 
	
	public WorkFlowRepositoryHbm( ItemSys rootobj ) {
		
		this.rootobject = rootobj;
	}
	
	
	public WorkFlowRepositoryHbm() {
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
		
		
		Query query =  super.getSessionFactory().getCurrentSession().createQuery("from WorkFlow where oid = :oid ");
		query.setParameter("oid", oid);
		WorkFlow _result = (WorkFlow ) query.uniqueResult();
		
		return _result;
	}

}
