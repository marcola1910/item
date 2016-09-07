package org.exnihilo.Item.services.ServiceDecorators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.EstadoServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

public class EstadoServiceTxHbm extends HbmTxDecorator implements
		EstadoServiceBI {

	public EstadoServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}
	
	public EstadoServiceTxHbm( BaseServiceImpl service  ){
		
		super(service);
	}
	
	public EstadoServiceTxHbm(ItemSysRepositoryBI itemSysRep) {
		super.set_itemSysRepository(itemSysRep);
	}

	@Override
	public NodoDTO addEstado(NodoDTO estado, WorkFlowDTO workflow) {

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EstadoServiceBI) super.getServicio()).addEstado(estado, workflow) ;
		
		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
		
		
		
		return estado;

	}

	@Override
	public List<NodoDTO> addProxEstado(String Oid, String workflowid, List<NodoDTO> proxEstados){

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EstadoServiceBI) super.getServicio()).addProxEstado(Oid, workflowid, proxEstados) ;

		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
		
		
		return proxEstados;

	}
	
	@Override
	public NodoDTO changeEstado(NodoDTO estado) {

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EstadoServiceBI) super.getServicio()).changeEstado(estado) ;
		
		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
			
		
			
		return estado;
	}

	@Override
	public Collection<NodoDTO> getEstado(NodoDTO estado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public NodoDTO getEstadoByID(String oid,String workflow ) {

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		NodoDTO _nododto = ((EstadoServiceBI) super.getServicio()).getEstadoByID(oid, workflow) ;
		
		
		
		return _nododto;
	}

	@Override
	public void deleteEstado(String estadoID, String workflowId) {

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		try {
			((EstadoServiceBI) super.getServicio()).deleteEstado(estadoID, workflowId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
		
		

	}

	@Override
	public void addProxEstado(WorkFlowDTO workflow, NodoDTO estado) {
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EstadoServiceBI) super.getServicio()).addProxEstado(workflow, estado);

		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());
		
		
	}

	@Override
	public List<NodoDTO> getAllEstados() {

		
		
		List<NodoDTO> _result = new ArrayList<NodoDTO>();

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		_result = ((EstadoServiceBI) super.getServicio()).getAllEstados();

		
		return _result;
	}

}
