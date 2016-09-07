package org.exnihilo.Item.model;

import java.util.List;

public class MiembroEquipo extends Usuario {
	
	private Puesto puesto;
	private List<Equipo> Equipos;
	private int dbId;
	
	public MiembroEquipo(){
		super();
	}
	
	public String getOid() {
		return super.getOid();
	}
	public void setOid(String oid) {
		super.setOid(oid);
	}
	public String getNombre() {
		return super.getNombre();
	}
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public List<Equipo> getEquipos() {
		return Equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		Equipos = equipos;
	}
	
	public void setIniPass(){
		super.setPassword("ini1234");
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
