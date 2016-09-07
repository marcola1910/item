package org.exnihilo.Item.util;

import org.exnihilo.Item.model.Nodo;

public class LinkDTO {

	private String oid;
	private int version;
	
	private String name;
	
	private Nodo puntoIni;
	private Nodo puntoFinal;
	
	public LinkDTO() {
		// TODO Auto-generated constructor stub
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
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Nodo getPuntoIni() {
		return puntoIni;
	}



	public void setPuntoIni(Nodo puntoIni) {
		this.puntoIni = puntoIni;
	}



	public Nodo getPuntoFinal() {
		return puntoFinal;
	}



	public void setPuntoFinal(Nodo puntoFinal) {
		this.puntoFinal = puntoFinal;
	}

}
