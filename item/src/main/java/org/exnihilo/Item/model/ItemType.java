package org.exnihilo.Item.model;

import java.util.Date;

public class ItemType {

	
	private String oid;
	private int version;
	private Date fecha = null;
	private String titulo;
	private String descripcion;
	private WorkFlow workflow;
	private int dbId;
	
	
	public ItemType() {
		// TODO Auto-generated constructor stub
			
	}

	
	
	public String getOid() {
		return oid;
	}


	public void setOid(String oid) {
		this.oid = oid;
	}


	protected int getVersion() {
		return version;
	}


	protected void setVersion(int version) {
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


	public WorkFlow getWorkflow() {
		return workflow;
	}


	public void setWorkflow(WorkFlow workflow) {
		this.workflow = workflow;
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
