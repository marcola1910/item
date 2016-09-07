package org.exnihilo.Item.util;

import java.io.Serializable;

public class UsuarioDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8183520776924906898L;
	private String oid;
	private int version;
	private String email;
	private String password;
	private String nombre;
	private String telefono;
	private boolean isLoginCHecked;
	
	public UsuarioDTO() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isLoginCHecked() {
		return isLoginCHecked;
	}

	public void setLoginCHecked(boolean isLoginCHecked) {
		this.isLoginCHecked = isLoginCHecked;
	}

}
