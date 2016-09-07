package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.bi.ItemTypeRepositoryBI;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ItemTypeRepositoryHbm extends RepositoryHbm implements ItemTypeRepositoryBI {

	private ItemSys rootobject; 
	
	public ItemTypeRepositoryHbm() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemTypeRepositoryHbm( ItemSys rootobj ) {
		
			this.rootobject = rootobj;
	}

	@Override
	public ItemType getItemTypebyId(String oid) {
		
		//crea una consulta desde la sesion seteada al principio en el init del repository
		Query query =  super.getSessionFactory().getCurrentSession().createQuery("from ItemType where oid = :oid ");
		query.setParameter("oid", oid);
		ItemType _result = (ItemType ) query.uniqueResult();
		
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
