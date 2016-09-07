package org.exnihilo.Item.repositories.impl.mock;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.repositories.bi.ItensRepositoryBI;

public class ItensRepositoryImpl implements ItensRepositoryBI {

	ItemSys rootobject;
	
	public ItensRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ItensRepositoryImpl(ItemSys mItem) {
		this.rootobject = mItem;
		
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
	public Item findbyId(String oid) {
		
		Iterator<Item> itens = this.rootobject.getItens().iterator();
		
		Item _item = new Item();
		Item _result = new Item();
		
		while (itens.hasNext()) {
			_item = itens.next();
			if (_item.getOid().equals(oid)) {
				_result = _item;
			}
		}
		
		return _result;
	}

	@Override
	public List<Item> findItembySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyType(ItemType itemtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyAssignment(Usuario miembro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyProyecto(ProyectoSoftware proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyEstado(Nodo estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int itemExiste(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getItemById(String itemId) {
		 
		
		
		return null;
	}
	
	@Override
	public List<Item> getAll(){
		return rootobject.getItens();
	}

}
