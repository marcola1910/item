package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Equipo;
import org.exnihilo.Item.model.MiembroEquipo;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.EquipoServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.MiembroEquipoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipoServiceImpl extends BaseServiceImpl implements
		EquipoServiceBI {

	public EquipoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public EquipoServiceImpl(ItemSysRepositoryBI itemsys) {
		super.set_itemSysRepository(itemsys);

	}

	@Transactional
	@Override
	public EquipoDTO addEquipo(EquipoDTO equipo) {

		Equipo mEquipo = new Equipo();
		mEquipo.setNombre(equipo.getNombre());
		MiembroEquipoDTO _miembro = new MiembroEquipoDTO();

		mEquipo.setProyecto(RepositoryLocator.getInstance()
				.getProyectosSoftware()
				.getProyectobyId(equipo.getProyecto().getOid()));
		mEquipo.setOid(IDGenerator.getId());
		
		mEquipo.setResponsable(RepositoryLocator.getInstance().getEquipoRepository().getMiembroEquipobyId(equipo.getResponsable().getOid()));
		 
		Iterator<MiembroEquipoDTO> iterator = equipo.getMiembros().iterator();

		// varre la collecion
		while (iterator.hasNext()) {
			_miembro = iterator.next();
			mEquipo.getMiembros().add( RepositoryLocator.getInstance().getEquipoRepository().getMiembroEquipobyId(_miembro.getOid())  );
		}		

		equipo.setOid(mEquipo.getOid());
		this.get_itemSysRepository().findItemSys().addEquipo(mEquipo);
		
		
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

	@Transactional
	@Override
	public MiembroEquipoDTO addMiembro(MiembroEquipoDTO miembro) {

		MiembroEquipo mmiembro = new MiembroEquipo();
		mmiembro.setEmail(miembro.getEmail());
		mmiembro.setNombre(miembro.getNombre());

		mmiembro.setPuesto(RepositoryLocator.getInstance()
				.getPuestoRepository()
				.getPuestobyId(miembro.getPuesto().getOid()));
		mmiembro.setOid(IDGenerator.getId());
		
		miembro.setOid(mmiembro.getOid());
		
		super.get_itemSysRepository().findItemSys().AddMiembroEquipo(mmiembro);
		
		
		return miembro;
		
		
	}

	@Transactional
	@Override
	public List<EquipoDTO> getAllEquipos() {
		
		Iterator<Equipo> iEquipo = RepositoryLocator.getInstance().getItemSysRepository().findItemSys().getEquipos().iterator();
		List<EquipoDTO> _result = new ArrayList<EquipoDTO>();
		
		while(iEquipo.hasNext() ){
			Equipo _equipo = iEquipo.next();
			_result.add( DTOFactory.getInstance().createEquipoDTO(_equipo.getOid(), _equipo.getNombre())  );
		}
		
		return _result;
	}
	
	@Transactional
	@Override
	public List<MiembroEquipoDTO> getAllMiembros(String equipoOid){ 
		Iterator<MiembroEquipo> miembrit = RepositoryLocator.getInstance().getEquipoRepository().getAllMiembros(equipoOid).iterator();
		List<MiembroEquipoDTO> result = new ArrayList<MiembroEquipoDTO>();
		
		while(miembrit.hasNext()){
			MiembroEquipo _miembro = miembrit.next();
			result.add( DTOFactory.getInstance().createMiembroDTO(_miembro.getOid(), _miembro.getNombre(), _miembro.getEmail(), null, null) );
		}
		
		return result; 
		
	}

}
