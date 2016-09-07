package org.exnihilo.Item.util;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class ItemTypeDTO  implements Serializable {

	private String oid;
	private int version;
	private Date fecha = null;
	private String titulo;
	private String descripcion;
	private WorkFlowDTO workflow;
	
	public ItemTypeDTO() {
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


	public WorkFlowDTO getWorkflow() {
		return workflow;
	}


	public void setWorkflow(WorkFlowDTO workflow) {
		this.workflow = workflow;
	}


}
