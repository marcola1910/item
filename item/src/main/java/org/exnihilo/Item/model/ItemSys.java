package org.exnihilo.Item.model;

import java.util.ArrayList;
import java.util.List;

import org.exnihilo.Item.util.IDGenerator;


public class ItemSys {
	
	private List<Usuario> usuarios;
	private List<Equipo> equipos;
	private List<WorkFlow> workflows;
	private List<ProyectoSoftware> proyectos;
	private List<ItemType> tiposItem;
	private List<Item> itens;
	private List<Puesto> puestos;
	private List<MiembroEquipo> miembros;
	private String oID;
	private static ItemSys instance;
	private int dbId;
	
	public void AddMiembroEquipo(MiembroEquipo miembro){
		//adiciona un registro de usuario para cada nuevo miembro
		usuarios.add(miembro);
		miembros.add(miembro);
	}
	
	public void remove(Usuario user){
		usuarios.remove(user);
	}
	
	public void addPuesto(Puesto puesto){
		this.puestos.add(puesto);
	}
	
	public void addWorkflow(WorkFlow workflow){
		this.getWorkflows().add(workflow);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	public List<WorkFlow> getWorkflows() {
		return workflows;
	}
	public void setWorkflows(List<WorkFlow> workflows) {
		this.workflows = workflows;
	}
	public List<ProyectoSoftware> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<ProyectoSoftware> proyectos) {
		this.proyectos = proyectos;
	}
	public List<ItemType> getTiposItem() {
		return tiposItem;
	}
	public void setTiposItem(List<ItemType> tiposItem) {
		this.tiposItem = tiposItem;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public static ItemSys getInstance() {
		
		if (instance == null)
			instance = new ItemSys();
		
		return instance;
	}
	
	private void setOid(String id) {
		oID = id;
	}
	
	public String getOid(){
		return oID;
	}
	
	private void initialize(){
		this.setOid(IDGenerator.getId());
		this.setEquipos(new ArrayList<Equipo>());
		this.setItens( new ArrayList<Item>() );
		this.setProyectos( new ArrayList<ProyectoSoftware>() );
		this.setTiposItem(new ArrayList<ItemType>());
		this.setUsuarios(new ArrayList<Usuario>());
		this.setWorkflows(new ArrayList<WorkFlow>());
		this.setMiembros(new ArrayList<MiembroEquipo>());
		this.setPuestos(new ArrayList<Puesto>() );
	}
	
	public ItemSys(){
		initialize();
		
	}
	
	
	
	public Usuario addUsuario( String email, 
			String password, 
			String nombre, 
			String telefono){
	
		 
		Usuario _usuario = new Usuario();
		
		_usuario.setEmail(email);
		_usuario.setPassword(password);
		_usuario.setOid(IDGenerator.getId());
		_usuario.setNombre(nombre);
		_usuario.setTelefono(telefono);
		_usuario.setVersion(0);
		
		this.getUsuarios().add(_usuario);
		
		return _usuario;
		
	}

	public List<Puesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<Puesto> puestos) {
		this.puestos = puestos;
	}

	public List<MiembroEquipo> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<MiembroEquipo> miembros) {
		this.miembros = miembros;
	}

	public void addEquipo(Equipo mEquipo) {
		this.getEquipos().add(mEquipo);
		
	}

	public void addProyecto(ProyectoSoftware _proyecto) {
		this.getProyectos().add(_proyecto);
		
	}

	public void addItem(Item _item) {
		this.getItens().add(_item);
		
	}

	public void addUser(Usuario _user) {
		this.getUsuarios().add(_user);
		
	}

	/**
	 * @return the dbId
	 */
	public int getDbId() {
		return dbId;
	}

	/**
	 * @param dbId the dbId to set
	 */
	public void setDbId(int dbId) {
		this.dbId = dbId;
	}
	
}
