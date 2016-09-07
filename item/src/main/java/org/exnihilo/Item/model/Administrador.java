package org.exnihilo.Item.model;

public class Administrador extends Usuario {

	private String oid;
	private String nombre;
	private int dbId;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public void setOid(String soid){
		this.oid = soid ;
	}
	
	public String getOid(){
		return this.oid;
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
