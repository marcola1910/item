package org.exnihilo.Item.services.bi;


import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItemTypeRepositoryBI;
import org.exnihilo.Item.repositories.bi.ItensRepositoryBI;
import org.exnihilo.Item.repositories.bi.NodoRepositoryBI;
import org.exnihilo.Item.repositories.bi.ProyectosSoftwareBI;
import org.exnihilo.Item.repositories.bi.PuestoRepositoryBI;
import org.exnihilo.Item.repositories.bi.WorkFlowRepositoryBI;
import org.exnihilo.Item.util.DTOFactory;

public interface BaseServiceBI {
	public DTOFactory getDTOFactory();
	public ItensRepositoryBI getItensrepository();
	public ItemTypeRepositoryBI getItemTypeRepository();
	public ProyectosSoftwareBI getProyectosRepository();
	public NodoRepositoryBI getEstadosRepository();
	public PuestoRepositoryBI getPuestoRepository();
	public WorkFlowRepositoryBI getWorkflowRepository();
	public ItemSysRepositoryBI get_itemSysRepository();
	public void set_itemSysRepository(ItemSysRepositoryBI _itemSysRepository);
	public void save(ItemSys aRoot);
	
}
