package org.exnihilo.Item.repositories.bi;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.model.Usuario;

public interface UsuarioRepositoryBI {
	
	public Usuario findUserByEmail(String email);
	public Usuario findUserByID(String userID);
	public Collection<Usuario> findUsersByEmail(String email);
	public Collection<Usuario> findUsersByName(String name);
	public List<Usuario> findAllUsers();
	public void delete(Usuario _user) throws Exception;

}
