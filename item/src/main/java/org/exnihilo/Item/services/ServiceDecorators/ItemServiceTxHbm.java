package org.exnihilo.Item.services.ServiceDecorators;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ItemServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.EstadoDTO;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemServiceTxHbm extends HbmTxDecorator implements ItemServiceBI {

	public ItemServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public ItemServiceTxHbm(BaseServiceImpl service) {

		super(service);
	}

	public ItemServiceTxHbm(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	@Override
	public ItemDTO addItem(ItemDTO item) {

		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// toma el root object de la base para que se use en la sesion
		ItemSys rootobject = RepositoryLocator
				.getInstance()
				.getItemSysRepository()
				.findbyId(
						RepositoryLocator.getInstance().getItemSysRepository()
								.findItemSys().getOid());

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo luego llama al additem que utiliza los objetos del modelo
		item = ((ItemServiceBI) super.getServicio()).addItem(item);
		 
		//super.save(rootobject);
		
		tx.commit();
		session.close();

		return item;

	}

	@Override
	public void deleteItem(String itemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ItemDTO> getItens(ItemDTO itemfilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO changeItem(ItemDTO item) {

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo
		try {
			item = ((ItemServiceBI) super.getServicio()).changeItem(item);
		} catch (ItemConcurrentModificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.save(RepositoryLocator.getInstance().getItemSysRepository()
				.findItemSys());

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

	@Override
	public List<ItemDTO> getUsersItem(String oid) {

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo
		List<ItemDTO> _result = ((ItemServiceBI) super.getServicio())
				.getUsersItem(oid);

		return _result;

	}

	public List<ItemDTO> getAllItems() {

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo
		List<ItemDTO> _result = ((ItemServiceBI) super.getServicio())
				.getAllItems();

		return _result;
	}

	@Override
	public ItemDTO getItemByID(String oid) {
		// TODO Auto-generated method stub
		return null;
	}
}
