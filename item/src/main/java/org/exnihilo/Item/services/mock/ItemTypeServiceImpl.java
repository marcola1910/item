package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.ItemTypeServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemTypeServiceImpl extends BaseServiceImpl implements
		ItemTypeServiceBI {

	public ItemTypeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ItemTypeServiceImpl(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	@Transactional
	@Override
	public ItemTypeDTO addItemType(ItemTypeDTO itemType) {

		ItemType mItemType = new ItemType();

		mItemType.setDescripcion(itemType.getDescripcion());
		mItemType.setTitulo(itemType.getTitulo());
		mItemType.setOid(IDGenerator.getId());
		mItemType.setWorkflow(RepositoryLocator.getInstance()
				.getWorkFlowRepository()
				.findWorkflowbyid(null, itemType.getWorkflow().getOid()));
		mItemType.setOid(IDGenerator.getId());

		itemType.setOid(mItemType.getOid());

		 RepositoryLocator.getInstance().getItemSysRepository().findItemSys().getTiposItem()
				.add(mItemType);

		return itemType;
	}

	@Transactional
	@Override
	public void deleteItemType(String itemTypeId) {
		// busca type no repositorio
		ItemType _mitemtype = RepositoryLocator.getInstance()
				.getItemTypeRepository().getItemTypebyId(itemTypeId);

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys()
				.getTiposItem().remove(_mitemtype);

	}

	@Transactional
	@Override
	public Collection<ItemTypeDTO> getItemType(ItemTypeDTO itemfilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public ItemTypeDTO changeItemType(ItemTypeDTO itemtype) {

		// busca type no repositorio
		ItemType _mitemtype = RepositoryLocator.getInstance()
				.getItemTypeRepository().getItemTypebyId(itemtype.getOid());

		// substitui os valores
		_mitemtype.setDescripcion(itemtype.getDescripcion());
		_mitemtype.setFecha(new Date());
		_mitemtype.setTitulo(itemtype.getTitulo());
		_mitemtype.setWorkflow(RepositoryLocator.getInstance()
				.getWorkFlowRepository()
				.findWorkflowbyid(null, itemtype.getWorkflow().getOid()));
		// muda a versao

		// retorna obj

		return itemtype;
		// TODO Auto-generated method stub

	}
	
	@Transactional
	public List<ItemTypeDTO> getAllItensType() {

		Iterator<ItemType> mitemType = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys().getTiposItem().iterator();
		List<ItemTypeDTO> _result = new ArrayList<ItemTypeDTO>();
		ItemType _mItemType = new ItemType();

		while (mitemType.hasNext()) {
			_mItemType = mitemType.next();
			ItemTypeDTO _mtype = DTOFactory.getInstance().createItemTypeDTO(
					_mItemType.getDescripcion(),
					_mItemType.getTitulo(),
					DTOFactory.getInstance().createWorkflowDTO(
							_mItemType.getWorkflow().getOid(),
							_mItemType.getWorkflow().getName()));
			_mtype.setOid(_mItemType.getOid());
			_result.add(_mtype);
		}

		return _result;

	}

}
