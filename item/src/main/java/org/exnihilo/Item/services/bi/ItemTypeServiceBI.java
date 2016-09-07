package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.util.ItemTypeDTO;

public interface ItemTypeServiceBI {
	public ItemTypeDTO addItemType(ItemTypeDTO itemType);
	public void deleteItemType(String itemTypeId);
	public Collection<ItemTypeDTO> getItemType(ItemTypeDTO itemfilter);
	public ItemTypeDTO changeItemType(ItemTypeDTO itemtype);
	public List<ItemTypeDTO> getAllItensType();
}
