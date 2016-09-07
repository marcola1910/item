package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;

public class ItemSysRepositoryImpl implements ItemSysRepositoryBI {

	private ItemSys rootobject; 
	
	public ItemSysRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	public ItemSysRepositoryImpl( ItemSys rootobj ) {
		
			this.rootobject = rootobj;
	}
	
	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleObjects(Collection<Object> co) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemSys findbyId(String oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemSys findItemSys() {

		ItemSys aItemSys = rootobject;
		
		return aItemSys;
		
	}

	@Override
	public Map<String, Object> getStatistcs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
