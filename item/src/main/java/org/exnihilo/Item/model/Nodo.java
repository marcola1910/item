package org.exnihilo.Item.model;

import java.util.ArrayList;
import java.util.List;


public class Nodo {

	private String oid;
	private int version;
	private String Name;
	private int dbId;
	
	private List<Nodo> proxEstado;
	
	public Nodo() {
		initialize();
	}

	private void initialize(){
		this.proxEstado = new ArrayList<Nodo>();
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

	public List<Nodo> getProxEstado() {
		return proxEstado;
	}

	public void setProxEstado(List<Nodo> pE) {
		proxEstado = pE;
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
