package org.exnihilo.Item.model;

public class Usuario {

	private String oid;
	private int version;
	private String email;
	private String password;
	private String telefono;
	private String nombre;
	private int dbId;
	
	public Usuario() {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public boolean isThePwd(String pwd){
		boolean _result;
		
		if(this.getPassword().equals(pwd) )
			_result = true;
		else
			_result = false;
		
		return _result;
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
