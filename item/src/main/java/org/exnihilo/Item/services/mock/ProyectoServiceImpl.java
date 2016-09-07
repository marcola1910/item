package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ProyectoServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.ProyectoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoServiceImpl extends BaseServiceImpl implements
		ProyectoServiceBI {

	public ProyectoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ProyectoServiceImpl(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	@Transactional
	@Override
	public ProyectoDTO addProyecto(ProyectoDTO proyecto) {

		ProyectoSoftware _proyecto = new ProyectoSoftware();

		_proyecto.setNombre(proyecto.getNombre());
		_proyecto.setOid(IDGenerator.getId());
		_proyecto.setEquipo(RepositoryLocator.getInstance()
				.getEquipoRepository()
				.getEquipobyId(proyecto.getEquipo().getOid()));
		_proyecto.setVersion(0);
		proyecto.setOid(_proyecto.getOid());

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys()
				.addProyecto(_proyecto);

		return proyecto;
	}

	@Transactional
	@Override
	public ProyectoDTO changeProyecto(ProyectoDTO proyecto) {

		ProyectoSoftware modelproj = RepositoryLocator.getInstance()
				.getProyectosSoftware().getProyectobyId(proyecto.getOid());

		modelproj.setNombre(proyecto.getNombre());
		modelproj.setEquipo(RepositoryLocator.getInstance()
				.getEquipoRepository()
				.getEquipobyId(proyecto.getEquipo().getOid()));

		return proyecto;

	}

	@Override
	public Collection<ProyectoDTO> getProyecto(ProyectoDTO proyectoFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void deleteProyecto(String proyectoId) throws Exception {


		ProyectoSoftware modelproj = RepositoryLocator.getInstance()
				.getProyectosSoftware().getProyectobyId(proyectoId);
		
		RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys().getProyectos().remove(modelproj);
		
		modelproj.setEquipo(null);
		
		RepositoryLocator.getInstance().getProyectosSoftware().delete(modelproj);

	}

	@Transactional
	@Override
	public List<ProyectoDTO> getAllProyects() {

		List<ProyectoSoftware> proyectos = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys().getProyectos();
		List<ProyectoDTO> _result = new ArrayList<ProyectoDTO>();
		Iterator<ProyectoSoftware> itproy = proyectos.iterator();

		while (itproy.hasNext()) {
			ProyectoSoftware _proy = itproy.next();

			_result.add(DTOFactory.getInstance().createProyectoDTO(
					_proy.getOid(),
					_proy.getNombre(),
					DTOFactory.getInstance().createEquipoDTO(
							_proy.getEquipo().getOid(),
							_proy.getEquipo().getNombre())));

		}

		return _result;
	}

}
