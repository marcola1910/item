package org.exnihilo.Item.services.ServiceDecorators;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.EquipoServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;

public class EquipoServiceTxHbm extends HbmTxDecorator implements
		EquipoServiceBI {

	public EquipoServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public EquipoServiceTxHbm(ItemSysRepositoryBI itemsys) {
		super.set_itemSysRepository(itemsys);

	}
	
	public EquipoServiceTxHbm( BaseServiceImpl service ) {
		
		super(service);
		
	}
	
	
	@Override
	public EquipoDTO addEquipo(EquipoDTO equipo) {

		

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EquipoServiceBI) super.getServicio()).addEquipo(equipo);

		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());

		
		return equipo;

	}

	@Override
	public void changeEquipo(EquipoDTO equipo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEquipo(String EquipoID) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<EquipoDTO> getEquipo(EquipoDTO equipofilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroEquipoDTO addMiembro(MiembroEquipoDTO miembro) {

		

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		((EquipoServiceBI) super.getServicio()).addMiembro(miembro);
		
		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());

		

		return miembro;

	}

	@Override
	public List<EquipoDTO> getAllEquipos() {
		
		

		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		List<EquipoDTO> _result = ((EquipoServiceBI) super.getServicio()).getAllEquipos();

		
		
		return _result;
	}

	@Override
	public List<MiembroEquipoDTO> getAllMiembros(String equipoOid) {
		

		
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de Equipo
		List<MiembroEquipoDTO> _result = ((EquipoServiceBI) super.getServicio()).getAllMiembros(equipoOid);
		
		
		
		return _result;

	}

}
