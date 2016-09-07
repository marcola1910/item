package org.exnihilo.Item.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class NodoDTO implements Serializable {

	private String oid;
	private int version;
	private String Name;
	private NodoDTO estado ;
	private WorkFlowDTO workflow;
	
	private List<NodoDTO> proxEstado;
	
	public NodoDTO() {
		proxEstado = new ArrayList<NodoDTO>();
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

	public NodoDTO getEstado() {
		return estado;
	}

	public void setEstado(NodoDTO estado) {
		this.estado = estado;
	}

	public List<NodoDTO> getProxEstado() {
		return proxEstado;
	}

	public void setProxEstado(List<NodoDTO> pE) {
		proxEstado = pE;
	}

	public WorkFlowDTO getWorkflow() {
		return workflow;
	}

	public void setWorkflow(WorkFlowDTO workflow) {
		this.workflow = workflow;
	}

}

