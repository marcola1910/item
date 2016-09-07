package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.util.EstadoDTO;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;

public interface ItemServiceBI {
	
	public ItemDTO addItem(ItemDTO item);
	public void deleteItem(String itemId) throws Exception;
	public Collection<ItemDTO> getItens(ItemDTO itemfilter);
	public ItemDTO changeItem(ItemDTO item) throws ItemConcurrentModificationException;
	
	public void asignarResponsable(String itemId, MiembroEquipoDTO responsable);
	public void cambiarEstado(String itemId, EstadoDTO estado);
	public List<ItemDTO> getUsersItem(String oid);
	public List<ItemDTO> getAllItems();
	public ItemDTO getItemByID(String oid);
	
	
}
