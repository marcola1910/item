package org.exnihilo.Item.repositories.bi;

import java.util.Collection;

import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.util.ItemTypeDTO;

public interface ItemTypeRepositoryBI {

	
	public ItemType getItemTypebyId(String itemTypeId);
	public Collection<ItemType> getItemTypebyName(String name);
	public Collection<ItemType> getItemType();
	
	public int proyectoExists(String proyectoId);
	
	public WorkFlow getWorkflowbyItemTypeId(String itemTypeId);
	public WorkFlow getWorkflowbyItemType(ItemTypeDTO itemType);
	
}
