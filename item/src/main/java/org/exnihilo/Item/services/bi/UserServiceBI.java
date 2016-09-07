package org.exnihilo.Item.services.bi;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.validation.IValidatable;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.UsuarioDTO;

public interface UserServiceBI {

	public UsuarioDTO addUser(UsuarioDTO user);
	public UsuarioDTO changeUser(UsuarioDTO user) throws ItemConcurrentModificationException;
	public void deleteUser(String id) throws Exception;
	public UsuarioDTO getUser(String userName);
	public UsuarioDTO checkLogin(String username, String password);
	public Collection<UsuarioDTO> getUserbyProject(ProyectoDTO proyecto);
	public List<UsuarioDTO> getAllUsers(UsuarioDTO user) ;
	public List<UsuarioDTO> getAllUsers();
	public UsuarioDTO getUserByEmail(String string);
	
	
}
