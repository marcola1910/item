package org.exnihilo.Item.repositories.bi;

import java.util.List;
import java.util.Map;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;

public interface ItemSysRepositoryBI extends ItemAbstractRepositoryBI {
	
	public ItemSys findItemSys();
	public ItemSys findbyId(String oid);
	public Map<String,Object> getStatistcs();
	public List<Item> getAll();
}

