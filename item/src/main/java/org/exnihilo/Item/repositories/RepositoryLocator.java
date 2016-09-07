package org.exnihilo.Item.repositories;

import org.exnihilo.Item.repositories.bi.EquipoRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemTypeRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItensRepositoryBI;
import org.exnihilo.Item.repositories.bi.NodoRepositoryBI;
import org.exnihilo.Item.repositories.bi.ProyectosSoftwareBI;
import org.exnihilo.Item.repositories.bi.PuestoRepositoryBI;
import org.exnihilo.Item.repositories.bi.UsuarioRepositoryBI;
import org.exnihilo.Item.repositories.bi.WorkFlowRepositoryBI;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryLocator {
	
	private static RepositoryLocator instance;
	@Autowired
	private static EquipoRepositoryBI  equipoRepository;
	@Autowired
	private static NodoRepositoryBI  estadoRepository;
	@Autowired
	private static ItemSysRepositoryBI  itemSysRepository;
	@Autowired
	private static ItemTypeRepositoryBI itemTypeRepository;
	@Autowired
	private static ItensRepositoryBI itensRepository;
	@Autowired
	private static ProyectosSoftwareBI  proyectosSoftware;
	@Autowired
	private static PuestoRepositoryBI  puestoRepository; 
	@Autowired
	private static WorkFlowRepositoryBI workFlowRepository;
	@Autowired
	private static UsuarioRepositoryBI usuarioRepository;
	
	public RepositoryLocator() {
		
	}

	public static RepositoryLocator getInstance() {

		if(instance == null)
			instance = new RepositoryLocator();
		
		return instance;
	}

	public EquipoRepositoryBI getEquipoRepository() {
		return RepositoryLocator.equipoRepository;
	}

	public void setEquipoRepository(EquipoRepositoryBI equipoRepository) {
		RepositoryLocator.equipoRepository = equipoRepository;
	}

	public NodoRepositoryBI getEstadoRepository() {
		return estadoRepository;
	}

	public void setEstadoRepository(NodoRepositoryBI estadoRepository) {
		RepositoryLocator.estadoRepository = estadoRepository;
	}

	public ItemSysRepositoryBI getItemSysRepository() {
		return RepositoryLocator.itemSysRepository;
	}

	public void setItemSysRepository(ItemSysRepositoryBI itemSysRepository) {
		RepositoryLocator.itemSysRepository = itemSysRepository;
	}

	public ItemTypeRepositoryBI getItemTypeRepository() {
		return RepositoryLocator.itemTypeRepository;
	}

	public void setItemTypeRepository(ItemTypeRepositoryBI itemTypeRepository) {
		RepositoryLocator.itemTypeRepository = itemTypeRepository;
	}

	public ProyectosSoftwareBI getProyectosSoftware() {
		return RepositoryLocator.proyectosSoftware;
	}

	public void setProyectosSoftware(ProyectosSoftwareBI proyectosSoftware) {
		RepositoryLocator.proyectosSoftware = proyectosSoftware;
	}

	public PuestoRepositoryBI getPuestoRepository() {
		return RepositoryLocator.puestoRepository;
	}

	public void setPuestoRepository(PuestoRepositoryBI puestoRepository) {
		RepositoryLocator.puestoRepository = puestoRepository;
	}

	public WorkFlowRepositoryBI getWorkFlowRepository() {
		return RepositoryLocator.workFlowRepository;
	}

	public void setWorkFlowRepository(WorkFlowRepositoryBI workFlowRepository) {
		RepositoryLocator.workFlowRepository = workFlowRepository;
	}

	public UsuarioRepositoryBI get_usuarioRepository() {
		return usuarioRepository;
	}

	public void set_usuarioRepository(UsuarioRepositoryBI _usuarioRepository) {
		RepositoryLocator.usuarioRepository = _usuarioRepository;
	}

	public ItensRepositoryBI get_itensRepository() {
		return itensRepository;
	}

	public void set_itensRepository(ItensRepositoryBI _itensRepository) {
		RepositoryLocator.itensRepository = _itensRepository;
	}

}
