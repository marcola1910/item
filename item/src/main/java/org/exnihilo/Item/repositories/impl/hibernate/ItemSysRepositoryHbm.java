package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.spring.ItemApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class ItemSysRepositoryHbm extends RepositoryHbm implements
		ItemSysRepositoryBI {

	private ItemSys rootobject;

	public ItemSysRepositoryHbm() {

		
		
		
	}

	public ItemSysRepositoryHbm(ItemSys rootobj) {

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

		this.rootobject = (ItemSys) getSessionFactory().getCurrentSession()
				.get(ItemSys.class, oid);

		return rootobject;
	}

	@Override
	public ItemSys findItemSys() {
			
		
		this.rootobject = (ItemSys) getSessionFactory().getCurrentSession()
				.createCriteria(ItemSys.class).uniqueResult();
		
		return this.rootobject;

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
