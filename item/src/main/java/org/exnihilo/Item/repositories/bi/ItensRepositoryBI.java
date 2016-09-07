package org.exnihilo.Item.repositories.bi;


import java.util.List;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Usuario;

public interface ItensRepositoryBI extends ItemAbstractRepositoryBI {
	
	public  List<Item> findItembySubject(String subject );
	public  List<Item> findItembyType(ItemType itemtype );
	public  List<Item> findItembyAssignment(Usuario miembro);
	public  List<Item> findItembyProyecto(ProyectoSoftware proyecto);
	public  List<Item> findItembyEstado(Nodo estado);
	
	public  int itemExiste(Item item);
	
	public Item getItemById(String itemId);
	public List<Item> getAll();
	public Item findbyId(String oid);
	
}
