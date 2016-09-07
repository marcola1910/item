package org.exnihilo.Item.model;

import java.util.*;

import org.exnihilo.Item.util.IDGenerator;

public class Item {
	
	private String oid;
	
	private ItemType type;
	
	private int version;
	private Date fecha;
	private String titulo;
	private String descripcion;
	private MiembroEquipo asignado;
	private Nodo estado;
	private List<Historial> historiales;
	private ProyectoSoftware proyecto;
	private int dbId;
	
	
	public Item(){
		Initialize();
	}
	
	public Item(String titulo, String descripcion,ItemType tipo,ProyectoSoftware proyecto){
		Initialize();
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.setType(tipo);
		this.proyecto = proyecto;
		this.setOid( IDGenerator.getId());
		//TODO - Agregar a logica que adicionar o responsavel da equipe asignada ao tipo de item do tipo de projeto
		
		if (this.asignado == null)
			this.asignado = proyecto.getEquipo().getResponsable();
		 
		
	}
	
	private void Initialize(){
		this.fecha = new Date();
		this.historiales = new ArrayList<Historial>();
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MiembroEquipo getAsignado() {
		return asignado;
	}
	public void setAsignado(MiembroEquipo asignado) {
		this.asignado = asignado;
	}
	public Nodo getEstado() {
		return estado;
	}
	public void setEstado(Nodo estado) {
		this.estado = estado;
	}
	public List<Historial> getHistoriales() {
		return historiales;
	}
	
	public void setHistoriales(List<Historial> historial) {
		this.historiales = historial;
	}
	
	public ProyectoSoftware getProyecto() {
		return proyecto;
	}
	
	public void setProyecto(ProyectoSoftware proyecto) {
		this.proyecto = proyecto;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
		
		//si se trata de una alta retorna lo primero nodo del workflow com oestado inicial
		if(this.estado == null)
			this.estado = this.type.getWorkflow().getNodos().get(0);
		else
		//si existe un objeto pero esta vacio es porque se modifico el tipo
			if(this.estado.getOid() == null)
				this.estado = this.type.getWorkflow().getNodos().get(0);
		
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
