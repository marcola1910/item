package org.exnihilo.Item.model;

import java.util.ArrayList;
import java.util.List;

public class WorkFlow {

	private String oid;
	private int version;
	private String Name;
	private int dbId;
	
	private List<Nodo> nodos;
	
	public WorkFlow(){
		initialize();
	}
	
	void addNodo(Nodo nodo){
		this.getNodos().add(nodo);
	}
	
	private void initialize(){
		this.nodos = new ArrayList<Nodo>();
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
	
	public List<Nodo> getNodos() {
		return nodos;
	}
	
	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
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
