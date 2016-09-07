package org.exnihilo.Item.model;

public class Puesto {

	
	private String oid;
	private int version;
	private String Name;
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
