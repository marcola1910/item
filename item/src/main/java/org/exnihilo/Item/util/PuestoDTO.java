package org.exnihilo.Item.util;

import java.io.Serializable;


public class PuestoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -141089778213680472L;
	private String oid;
	private int version;
	private String Name;
	
	public PuestoDTO(String name){
		this.Name = name;
	}
	
	public PuestoDTO(){
		
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
}
