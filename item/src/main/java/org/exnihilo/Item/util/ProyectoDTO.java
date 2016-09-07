package org.exnihilo.Item.util;

import java.io.Serializable;

public class ProyectoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7557840499750110174L;


	public ProyectoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private String oid;
	private int version;
	private EquipoDTO equipo;
	private String nombre;
	
	
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
	public EquipoDTO getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoDTO equipo) {
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

