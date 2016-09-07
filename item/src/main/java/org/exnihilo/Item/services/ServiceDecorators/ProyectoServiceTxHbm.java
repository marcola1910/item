package org.exnihilo.Item.services.ServiceDecorators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ProyectoServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.ProyectoDTO;

public class ProyectoServiceTxHbm extends HbmTxDecorator implements
		ProyectoServiceBI {

	public ProyectoServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public ProyectoServiceTxHbm(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}
	
	public ProyectoServiceTxHbm( BaseServiceImpl service ) {
		
		super(service);
		
	}
	

	@Override
	public ProyectoDTO addProyecto(ProyectoDTO proyecto) {

		

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		proyecto = ((ProyectoServiceBI) super.getServicio()).addProyecto(proyecto) ;

		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());

		
		
		return proyecto;
	}

	@Override
	public ProyectoDTO changeProyecto(ProyectoDTO proyecto) {
		return proyecto;
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ProyectoDTO> getProyecto(ProyectoDTO proyectoFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProyecto(String proyectoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProyectoDTO> getAllProyects() {

		
		
		List<ProyectoDTO> _result = new ArrayList<ProyectoDTO>();

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		_result = ((ProyectoServiceBI) super.getServicio()).getAllProyects() ;

		

		return _result;
	}

}
