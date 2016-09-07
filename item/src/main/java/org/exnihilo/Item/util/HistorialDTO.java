package org.exnihilo.Item.util;


import java.io.Serializable;
import java.util.*;

public class HistorialDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8364455601437732290L;
	private String oid;
	private int version; 
	private Date fecha;
	private int histoID;
	private String registro;
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	
	
}
