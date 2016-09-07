package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.NodoRepositoryBI;

public class EstadoRepositoryImpl implements NodoRepositoryBI {

	public EstadoRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	public EstadoRepositoryImpl( ItemSys rootobj ) {

	}
	
	
	@Override
	public Nodo getEstadobyId(String estadoId, String workflowid) {
		WorkFlow _workflow = RepositoryLocator.getInstance().getWorkFlowRepository().findWorkflowbyid(null, workflowid);
		Nodo _result = new Nodo(); 
		Nodo _noodoseek= new Nodo();

		Iterator<Nodo> iterator = _workflow.getNodos().iterator();  
		
		//varre la collecion
		while (iterator.hasNext()) {
			_noodoseek = iterator.next();
			if (_noodoseek.getOid().equals(estadoId)) {
				_result = _noodoseek;
			}
		}

		return _result;

	}

	@Override
	public Collection<Nodo> getEstadobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Nodo> getEstados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int estadoExists(String estadoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Nodo getEstadobyId(String estadoId) {		
		
		
		return null;
	}

	@Override
	public void delete(Object o) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
