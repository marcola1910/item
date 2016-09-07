package org.exnihilo.Item.util;

import java.io.Serializable;
import java.util.List;


public class MiembroEquipoDTO extends UsuarioDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1218540391245496494L;
	private String oid;
	private String nombre;
	private PuestoDTO puesto;
	private List<EquipoDTO> Equipos;
	private String email;
	private boolean isAdm;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PuestoDTO getPuesto() {
		return puesto;
	}
	public void setPuesto(PuestoDTO puesto) {
		this.puesto = puesto;
	}
	public List<EquipoDTO> getEquipos() {
		return Equipos;
	}
	public void setEquipos(List<EquipoDTO> equipos) {
		Equipos = equipos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdm() {
		return isAdm;
	}
	public void setAdm(boolean isAdm) {
		this.isAdm = isAdm;
	}
	
	
}