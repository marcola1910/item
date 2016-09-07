package org.exnihilo.Item.services;

import org.exnihilo.Item.services.bi.EquipoServiceBI;
import org.exnihilo.Item.services.bi.EstadoServiceBI;
import org.exnihilo.Item.services.bi.ItemServiceBI;
import org.exnihilo.Item.services.bi.ItemTypeServiceBI;
import org.exnihilo.Item.services.bi.ProyectoServiceBI;
import org.exnihilo.Item.services.bi.PuestoServiceBI;
import org.exnihilo.Item.services.bi.UserServiceBI;
import org.exnihilo.Item.services.bi.WorkflowServicesBI;
import org.springframework.beans.factory.annotation.Autowired;


public class ServiceLocator {

	private static ServiceLocator instance;
	
	private static EstadoServiceBI estadosService;
	private static EquipoServiceBI equipoService;
	private static ItemServiceBI itemService;
	private static ItemTypeServiceBI itemTypeService;
	private static ProyectoServiceBI proyectoService;
	
	private static PuestoServiceBI puestoService;
	@Autowired
	private static UserServiceBI userService;
	private static WorkflowServicesBI workflowService;
	
	public static ServiceLocator getInstance() {
		if( instance == null)
			instance = new ServiceLocator();
		
		return instance;
	}
	
	public ServiceLocator() {
		// TODO Auto-generated constructor stub
	}

	public EstadoServiceBI getEstadosService() {
		return estadosService;
	}

	public void setEstadosService(EstadoServiceBI estadosService) {
		ServiceLocator.estadosService = estadosService;
	}

	public EquipoServiceBI getEquipoService() {
		return equipoService;
	}

	public void setEquipoService(EquipoServiceBI equipoService) {
		ServiceLocator.equipoService = equipoService;
	}

	public ItemServiceBI getItemService() {
		return itemService;
	}

	public void setItemService(ItemServiceBI itemService) {
		ServiceLocator.itemService = itemService;
	}

	public ItemTypeServiceBI getItemTypeService() {
		return itemTypeService;
	}

	public void setItemTypeService(ItemTypeServiceBI itemTypeService) {
		ServiceLocator.itemTypeService = itemTypeService;
	}

	public ProyectoServiceBI getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoServiceBI proyectoService) {
		ServiceLocator.proyectoService = proyectoService;
	}

	public PuestoServiceBI getPuestoService() {
		return puestoService;
	}

	public void setPuestoService(PuestoServiceBI puestoService) {
		ServiceLocator.puestoService = puestoService;
	}

	public UserServiceBI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceBI userService) {
		ServiceLocator.userService = userService;
	}

	public WorkflowServicesBI getWorkflowService() {
		return workflowService;
	}

	public void setWorkflowService(WorkflowServicesBI workflowService) {
		ServiceLocator.workflowService = workflowService;
	}
	

	
}
