package org.exnihilo.Item.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EquipoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4880699704331801349L;
	private String oid;
	private int version;
	private String nombre;
	private ProyectoDTO proyecto;
	private List<MiembroEquipoDTO> miembros;
	private MiembroEquipoDTO responsable;
	
	public EquipoDTO(){
		this.miembros = new ArrayList<MiembroEquipoDTO>();
	}
	
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


	public List<MiembroEquipoDTO> getMiembros() {
		return miembros;
	}
	public void setMiembros(List<MiembroEquipoDTO> miembros) {
		this.miembros = miembros;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public ProyectoDTO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDTO proyecto) {
		this.proyecto = proyecto;
	}

	public MiembroEquipoDTO getResponsable() {
		return responsable;
	}

	public void setResponsable(MiembroEquipoDTO responsable) {
		this.responsable = responsable;
	}

}
