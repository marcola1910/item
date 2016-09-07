package org.exnihilo.Item.services.ServiceDecorators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ItemTypeServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.ItemTypeDTO;

public class ItemTypeServiceTxHbm extends HbmTxDecorator implements
		ItemTypeServiceBI {

	public ItemTypeServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public ItemTypeServiceTxHbm(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	public ItemTypeServiceTxHbm(BaseServiceImpl service) {

		super(service);
	}

	@Override
	public ItemTypeDTO addItemType(ItemTypeDTO itemType) {

		

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo
		ItemTypeDTO _result = ((ItemTypeServiceBI) super.getServicio())
				.addItemType(itemType);

		super.save(RepositoryLocator.getInstance().getItemSysRepository().findItemSys());

		

		return _result;

	}

	@Override
	public void deleteItemType(String itemTypeId) {

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de Equipo
		((ItemTypeServiceBI) super.getServicio()).deleteItemType(itemTypeId);

		super.save(this.get_itemSysRepository().findItemSys());

		

	}

	@Override
	public Collection<ItemTypeDTO> getItemType(ItemTypeDTO itemfilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemTypeDTO changeItemType(ItemTypeDTO itemtype) {

		

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de ItemType
		itemtype = ((ItemTypeServiceBI) super.getServicio())
				.changeItemType(itemtype);

		super.save(this.get_itemSysRepository().findItemSys());

		

		return itemtype;
		// TODO Auto-generated method stub

	}

	public List<ItemTypeDTO> getAllItensType() {

		List<ItemTypeDTO> _result = new ArrayList<ItemTypeDTO>();

		// Recupera el objeto del servicio que estamos decorando y se hace
		// boxing
		// para la interfaz del servicio de ItemType
		_result = ((ItemTypeServiceBI) super.getServicio()).getAllItensType();

		return _result;

	}

}
