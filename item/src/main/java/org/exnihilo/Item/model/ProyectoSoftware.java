package org.exnihilo.Item.model;

public class ProyectoSoftware {
	
	private String oid;
	private int version;
	private Equipo equipo;
	private String nombre;
	private int dbId;
	
	
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
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
