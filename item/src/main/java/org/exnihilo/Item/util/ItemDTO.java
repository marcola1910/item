package org.exnihilo.Item.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ItemDTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1610001846956289864L;
	private String oid;
	private int version;
	private Date fecha;
	private String titulo;
	private String descripcion;
	private MiembroEquipoDTO asignado;
	private NodoDTO estado;
	private List<HistorialDTO> historial;
	private ProyectoDTO proyecto;
	private ItemTypeDTO itemType; 
	private String estadoActual;
	private UsuarioDTO usuario;
	
	public ItemDTO(){
		this.historial = new ArrayList<HistorialDTO>();
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
	public MiembroEquipoDTO getAsignado() {
		return asignado;
	}
	public void setAsignado(MiembroEquipoDTO asignado) {
		this.asignado = asignado;
	}
	public NodoDTO getEstado() {
		return estado;
	}
	public void setEstado(NodoDTO estado) {
		this.estado = estado;
	}
	public List<HistorialDTO> getHistorial() {
		return historial;
	}
	public void setHistorial(List<HistorialDTO> historial) {
		this.historial = historial;
	}
	public ProyectoDTO getProyecto() {
		return proyecto;
	}
	public void setProyecto(ProyectoDTO proyecto) {
		this.proyecto = proyecto;
	}
	public ItemTypeDTO getItemType() {
		return itemType;
	}
	public void setItemType(ItemTypeDTO itemType) {
		this.itemType = itemType;
	}
	public String getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}

