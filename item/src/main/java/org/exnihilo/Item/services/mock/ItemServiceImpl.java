package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Historial;
import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ItemServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.EstadoDTO;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.PuestoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemServiceBI {

	public ItemServiceImpl() {
		
	}

	public ItemServiceImpl(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	@Transactional
	@Override
	public ItemDTO addItem(ItemDTO item) {

		Item _item = new Item();
		String usrName;

		Historial _historial = new Historial();
		_historial.setFecha(new Date());
		_historial.setOid(IDGenerator.getId());

		if (item.getUsuario() == null)
			usrName = "Sys ";
		else
			usrName = item.getUsuario().getNombre();

		_historial.setRegistro(usrName + "  - Ha creado el Iten");

		_item.setDescripcion(item.getDescripcion());
		_item.setFecha(new Date());
		_item.setTitulo(item.getTitulo());
		_item.setOid(IDGenerator.getId());
		_item.getHistoriales().add(_historial);

		// buscar los objetos relacionados
		_item.setAsignado(RepositoryLocator.getInstance().getEquipoRepository()
				.getMiembroEquipobyId(item.getAsignado().getOid()));
		_item.setProyecto(RepositoryLocator.getInstance()
				.getProyectosSoftware()
				.getProyectobyId(item.getProyecto().getOid()));

		// determinar es estado como el primer nodo del workflow configurado. El
		// workflow esta bajo el tipo de item.
		_item.setType(RepositoryLocator.getInstance().getItemTypeRepository()
				.getItemTypebyId(item.getItemType().getOid()));

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys()
				.addItem(_item);

		// Asigna el ID ao deto que se devuelve
		item.setOid(_item.getOid());

		item.setAsignado(DTOFactory.getInstance().createMiembroDTO(
				_item.getAsignado().getNombre(),
				_item.getAsignado().getEmail(), (new PuestoDTO()),
				(List<EquipoDTO>) new ArrayList<EquipoDTO>()));

		return item;

	}

	@Transactional
	@Override
	public void deleteItem(String itemId) throws Exception {
		Item _item = RepositoryLocator.getInstance().get_itensRepository()
				.findbyId(itemId);

		_item.setType(null);
		_item.setAsignado(null);
		_item.setEstado(null);
		_item.getHistoriales().removeAll( _item.getHistoriales()  );
		_item.setProyecto(null);
		
				
		RepositoryLocator.getInstance().getItemSysRepository()
				.findItemSys().getItens().remove(_item);

		RepositoryLocator.getInstance().get_itensRepository().delete(_item);

	}

	@Override
	public Collection<ItemDTO> getItens(ItemDTO itemfilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ItemDTO changeItem(ItemDTO item)
			throws ItemConcurrentModificationException {

		// Buscar el iten usando el repositorio

		Item _item = RepositoryLocator.getInstance().get_itensRepository()
				.findbyId(item.getOid());

		if (_item.getVersion() != item.getVersion())
			throw new ItemConcurrentModificationException();

		_item.setAsignado(RepositoryLocator.getInstance().getEquipoRepository()
				.getMiembroEquipobyId(item.getAsignado().getOid()));
		_item.setDescripcion(item.getDescripcion());

		Historial _hist = new Historial();

		_hist.setFecha(new Date());
		_hist.setOid(IDGenerator.getId());
		_hist.setRegistro(item.getUsuario().getNombre()
				+ "   - Ha cambiando el estado de:"
				+ _item.getEstado().getName() + "  - Para :"
				+ item.getEstado().getName());

		_item.setEstado(RepositoryLocator
				.getInstance()
				.getEstadoRepository()
				.getEstadobyId(item.getEstado().getOid(),
						item.getItemType().getWorkflow().getOid()));

		_item.setFecha(new Date());

		_item.getHistoriales().add(_hist);

		_item.setProyecto(RepositoryLocator.getInstance()
				.getProyectosSoftware()
				.getProyectobyId(item.getProyecto().getOid()));
		_item.setTitulo(item.getTitulo());
		_item.setType(RepositoryLocator.getInstance().getItemTypeRepository()
				.getItemTypebyId(item.getItemType().getOid()));

		_item.setVersion(_item.getVersion() + 1);

		item.setVersion(_item.getVersion());

		return item;

	}

	@Override
	public void asignarResponsable(String itemId, MiembroEquipoDTO responsable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarEstado(String itemId, EstadoDTO estado) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public List<ItemDTO> getUsersItem(String oid) {

		Usuario mUsr = RepositoryLocator.getInstance().get_usuarioRepository()
				.findUserByID(oid);

		List<Item> mItens = RepositoryLocator.getInstance()
				.get_itensRepository().findItembyAssignment(mUsr);

		Iterator<Item> _itItem = mItens.iterator();

		List<ItemDTO> _result = new ArrayList<ItemDTO>();

		Item _item = new Item();

		while (_itItem.hasNext()) {
			_item = _itItem.next();
			ItemDTO dtoitem = DTOFactory.getInstance().createItemDTO(
					_item.getFecha(),
					_item.getTitulo(),
					_item.getDescripcion(),
					DTOFactory.getInstance().createMiembroDTO(
							_item.getAsignado().getNombre(),
							_item.getAsignado().getEmail(), null, null),
					DTOFactory.getInstance().createProyectoDTO(
							_item.getProyecto().getOid(),
							_item.getProyecto().getNombre(), null),
					DTOFactory.getInstance().createItemTypeDTO(
							_item.getType().getDescripcion(),
							_item.getType().getTitulo(), null));
			dtoitem.setOid(_item.getOid());
			_result.add(dtoitem);
		}

		return _result;

	}

	@Transactional
	public List<ItemDTO> getAllItems() {

		List<Item> mItens = RepositoryLocator.getInstance()
				.get_itensRepository().getAll();
		List<ItemDTO> _result = new ArrayList<ItemDTO>();

		Item _item = new Item();

		Iterator<Item> _itItem = mItens.iterator();

		while (_itItem.hasNext()) {
			_item = _itItem.next();

			ItemDTO itemDTO = DTOFactory.getInstance().createItemDTO(
					_item.getFecha(),
					_item.getTitulo(),
					_item.getDescripcion(),
					null,
					DTOFactory.getInstance().createProyectoDTO(
							_item.getProyecto().getOid(),
							_item.getProyecto().getNombre(), null), null);

			ItemTypeDTO itntypedto = DTOFactory.getInstance()
					.createItemTypeDTO(
							_item.getType().getDescripcion(),
							_item.getType().getTitulo(),
							DTOFactory.getInstance().createWorkflowDTO(
									_item.getType().getWorkflow().getOid(),
									_item.getType().getWorkflow().getName()));

			itntypedto.setOid(_item.getType().getOid());

			NodoDTO estadodto = DTOFactory.getInstance().createNodoDTO(
					_item.getEstado().getOid(), _item.getEstado().getName(),
					null);
			ProyectoDTO proyDto = DTOFactory.getInstance().createProyectoDTO(
					_item.getProyecto().getOid(),
					_item.getProyecto().getNombre(), null);

			MiembroEquipoDTO miembrodto = DTOFactory.getInstance()
					.createMiembroDTO(_item.getAsignado().getNombre(),
							_item.getAsignado().getEmail(), null, null);

			Iterator<Historial> ithist = _item.getHistoriales().iterator();

			while (ithist.hasNext()) {
				Historial _hist = ithist.next();
				itemDTO.getHistorial().add(
						DTOFactory.getInstance().createHistorial(
								_hist.getFecha(), _hist.getRegistro()));
			}

			miembrodto.setOid(_item.getAsignado().getOid());
			itemDTO.setEstado(estadodto);
			itemDTO.setProyecto(proyDto);
			itemDTO.setItemType(itntypedto);
			itemDTO.setAsignado(miembrodto);
			itemDTO.setEstado(DTOFactory.getInstance().createNodoDTO(
					_item.getEstado().getOid(), _item.getEstado().getName(),
					new ArrayList<NodoDTO>()));

			itemDTO.setVersion(_item.getVersion());
			itemDTO.setOid(_item.getOid());
			_result.add(itemDTO);
		}

		return _result;
	}

	@Override
	public ItemDTO getItemByID(String oid) {

		Item _item = RepositoryLocator.getInstance().get_itensRepository()
				.findbyId(oid);
		
		
		ItemDTO itemDTO = DTOFactory.getInstance().createItemDTO(
				_item.getFecha(),
				_item.getTitulo(),
				_item.getDescripcion(),
				null,
				DTOFactory.getInstance().createProyectoDTO(
						_item.getProyecto().getOid(),
						_item.getProyecto().getNombre(), null), null);

		ItemTypeDTO itntypedto = DTOFactory.getInstance()
				.createItemTypeDTO(
						_item.getType().getDescripcion(),
						_item.getType().getTitulo(),
						DTOFactory.getInstance().createWorkflowDTO(
								_item.getType().getWorkflow().getOid(),
								_item.getType().getWorkflow().getName()));

		itntypedto.setOid(_item.getType().getOid());

		NodoDTO estadodto = DTOFactory.getInstance().createNodoDTO(
				_item.getEstado().getOid(), _item.getEstado().getName(),
				null);
		ProyectoDTO proyDto = DTOFactory.getInstance().createProyectoDTO(
				_item.getProyecto().getOid(),
				_item.getProyecto().getNombre(), null);

		MiembroEquipoDTO miembrodto = DTOFactory.getInstance()
				.createMiembroDTO(_item.getAsignado().getNombre(),
						_item.getAsignado().getEmail(), null, null);
		
		itemDTO.setEstado(estadodto);
		itemDTO.setAsignado(miembrodto);
		itemDTO.setItemType(itntypedto);
		itemDTO.setProyecto(proyDto);
		itemDTO.setOid(_item.getOid());
		itemDTO.setVersion(_item.getVersion());
		return itemDTO;
	}
}
