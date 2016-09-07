package org.exnihilo.Item.util;

import java.io.Serializable;

public class WorkFlowDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -841375078411542534L;
	private String oid;
	private int version;
	private String Name;
	
	private String nodos;
	private String Links;
	
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
	
	public String getNodos() {
		return nodos;
	}
	
	public void setNodos(String nodos) {
		this.nodos = nodos;
	}
	
	public String getLinks() {
		return Links;
	}
	
	public void setLinks(String links) {
		Links = links;
	}
	
}
