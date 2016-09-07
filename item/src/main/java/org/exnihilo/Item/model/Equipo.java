package org.exnihilo.Item.model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private String oid;
	private int version; 
	private String nombre;
	private ProyectoSoftware proyecto;
	private List<MiembroEquipo> Miembros;
	private MiembroEquipo responsable;
	private int dbId; 
	
	
	public Equipo(){
		
		initialize();
	}
	
	
	private void initialize(){
		Miembros = new ArrayList<MiembroEquipo>();
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiembroEquipo> getMiembros() {
		return Miembros;
	}
	public void setMiembros(List<MiembroEquipo> miembros) {
		Miembros = miembros;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}


	public ProyectoSoftware getProyecto() {
		return proyecto;
	}


	public void setProyecto(ProyectoSoftware proyecto) {
		this.proyecto = proyecto;
	}


	public MiembroEquipo getResponsable() {
		return responsable;
	}


	public void setResponsable(MiembroEquipo responsable) {
		this.responsable = responsable;
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
