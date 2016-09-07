package org.exnihilo.Item.model;

import java.util.*;

public class Historial {
	
	private String oid;
	private int version; 
	private Date fecha;
	private MiembroEquipo respAsig;
	private int histoID;
	private String registro;
	private int dbId; 
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MiembroEquipo getRespAsig() {
		return respAsig;
	}

	public void setRespAsig(MiembroEquipo respAsig) {
		this.respAsig = respAsig;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getHistoID() {
		return histoID;
	}

	public void setHistoID(int histoID) {
		this.histoID = histoID;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
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
