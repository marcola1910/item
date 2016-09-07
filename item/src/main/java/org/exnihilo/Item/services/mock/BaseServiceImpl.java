package org.exnihilo.Item.services.mock;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.repositories.bi.EquipoRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemAbstractRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemTypeRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItensRepositoryBI;
import org.exnihilo.Item.repositories.bi.NodoRepositoryBI;
import org.exnihilo.Item.repositories.bi.ProyectosSoftwareBI;
import org.exnihilo.Item.repositories.bi.PuestoRepositoryBI;
import org.exnihilo.Item.repositories.bi.UsuarioRepositoryBI;
import org.exnihilo.Item.repositories.bi.WorkFlowRepositoryBI;
import org.exnihilo.Item.services.bi.BaseServiceBI;
import org.exnihilo.Item.util.DTOFactory;

public class BaseServiceImpl implements BaseServiceBI {

	
	protected UsuarioRepositoryBI _usersRepository;
	protected ItemSysRepositoryBI _itemSysRepository;
	
	protected EquipoRepositoryBI _equipoRepository;
	protected NodoRepositoryBI _estadoRepository;
	
	protected ItemAbstractRepositoryBI _itemAbstractRep;
	protected ItemTypeRepositoryBI _itemTypeRepository;
	
	protected ItensRepositoryBI _itensRepository;
	protected ProyectosSoftwareBI _proyectosRepository;
	
	protected PuestoRepositoryBI _puestoRepository;
	protected WorkFlowRepositoryBI _workflowRepository;
	
	
	
	public BaseServiceImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DTOFactory getDTOFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItensRepositoryBI getItensrepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemTypeRepositoryBI getItemTypeRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProyectosSoftwareBI getProyectosRepository() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PuestoRepositoryBI getPuestoRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkFlowRepositoryBI getWorkflowRepository() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public UsuarioRepositoryBI getUsersRepository() {
		return _usersRepository;
	}

	public void setUsersRepository(UsuarioRepositoryBI _usersRepository) {
		this._usersRepository = _usersRepository;
	}
	
	@Override
	public ItemSysRepositoryBI get_itemSysRepository() {
		return _itemSysRepository;
	}

	@Override
	public void set_itemSysRepository(ItemSysRepositoryBI _itemSysRepository) {
		this._itemSysRepository = _itemSysRepository;
	}

	protected UsuarioRepositoryBI get_usersRepository() {
		return _usersRepository;
	}

	protected void set_usersRepository(UsuarioRepositoryBI _usersRepository) {
		this._usersRepository = _usersRepository;
	}

	protected EquipoRepositoryBI get_equipoRepository() {
		return _equipoRepository;
	}

	protected void set_equipoRepository(EquipoRepositoryBI _equipoRepository) {
		this._equipoRepository = _equipoRepository;
	}

	
	public NodoRepositoryBI getEstadosRepository() {
		return _estadoRepository;
	}

	protected void set_estadoRepository(NodoRepositoryBI _estadoRepository) {
		this._estadoRepository = _estadoRepository;
	}

	protected ItemAbstractRepositoryBI get_itemAbstractRep() {
		return _itemAbstractRep;
	}

	protected void set_itemAbstractRep(ItemAbstractRepositoryBI _itemAbstractRep) {
		this._itemAbstractRep = _itemAbstractRep;
	}

	protected ItemTypeRepositoryBI get_itemTypeRepository() {
		return _itemTypeRepository;
	}

	protected void set_itemTypeRepository(ItemTypeRepositoryBI _itemTypeRepository) {
		this._itemTypeRepository = _itemTypeRepository;
	}

	protected ItensRepositoryBI get_itensRepository() {
		return _itensRepository;
	}

	protected void set_itensRepository(ItensRepositoryBI _itensRepository) {
		this._itensRepository = _itensRepository;
	}

	protected ProyectosSoftwareBI get_proyectosRepository() {
		return _proyectosRepository;
	}

	protected void set_proyectosRepository(ProyectosSoftwareBI _proyectosRepository) {
		this._proyectosRepository = _proyectosRepository;
	}

	protected PuestoRepositoryBI get_puestoRepository() {
		return _puestoRepository;
	}

	protected void set_puestoRepository(PuestoRepositoryBI _puestoRepository) {
		this._puestoRepository = _puestoRepository;
	}

	protected WorkFlowRepositoryBI get_workflowRepository() {
		return _workflowRepository;
	}

	protected void set_workflowRepository(WorkFlowRepositoryBI _workflowRepository) {
		this._workflowRepository = _workflowRepository;
	}

	@Override
	public void save(ItemSys aRoot) {
		
		
	}

	public void beginSession(){
		
	}
	
	public void endSession(){
		
	}


}
