package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.Iterator;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.bi.ItemTypeRepositoryBI;
import org.exnihilo.Item.util.ItemTypeDTO;

public class ItemTypeRepositoryImpl implements ItemTypeRepositoryBI {

	private ItemSys rootobject; 
	
	public ItemTypeRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemTypeRepositoryImpl( ItemSys rootobj ) {
		
			this.rootobject = rootobj;
	}

	@Override
	public ItemType getItemTypebyId(String itemTypeId) {
		
		Iterator<ItemType> types = this.rootobject.getTiposItem().iterator();
		ItemType _itemType = new ItemType();
		ItemType _result = new ItemType();
		
		while(types.hasNext()){
			_itemType = types.next();
			if (_itemType.getOid().equals(itemTypeId))
				_result = _itemType;
			
		}
		
		return _result;
	}

	@Override
	public Collection<ItemType> getItemTypebyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ItemType> getItemType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int proyectoExists(String proyectoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WorkFlow getWorkflowbyItemTypeId(String itemTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkFlow getWorkflowbyItemType(ItemTypeDTO itemType) {
		// TODO Auto-generated method stub
		return null;
	}

}
