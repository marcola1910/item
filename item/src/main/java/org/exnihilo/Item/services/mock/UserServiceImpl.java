package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.UserServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserServiceBI {

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserServiceImpl(ItemSysRepositoryBI itemSysRep) {
		super.set_itemSysRepository(itemSysRep);
	}

	@Override
	@Transactional
	public UsuarioDTO addUser(UsuarioDTO user) {

		ItemSys rootobj = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys();

		// agrega el usuario al repositorio configurado, puede ser Mock (en
		// memoria) o en la BBDD
		Usuario _user = rootobj.addUsuario(user.getEmail(), user.getPassword(),
				user.getNombre(), user.getTelefono());
		user.setOid(_user.getOid());

		return user;

	}

	@Override
	@Transactional
	public UsuarioDTO changeUser(UsuarioDTO user) throws ItemConcurrentModificationException {
		// TODO Auto-generated method stub

		Usuario _user = RepositoryLocator.getInstance().get_usuarioRepository()
				.findUserByID(user.getOid());
		
		//COntrole de concurrencia
		if(_user.getVersion() != user.getVersion())
			throw new ItemConcurrentModificationException();
		
		if (_user.getOid() != null) {
			_user.setEmail(user.getEmail());
			_user.setNombre(user.getNombre());
			_user.setPassword(user.getPassword());
			_user.setTelefono(user.getTelefono());
			_user.setVersion(user.getVersion()+1);

			user.setVersion(_user.getVersion());
		}

		return user;

	}

	@Override
	@Transactional
	public void deleteUser(String id) throws Exception {

		Usuario _user = RepositoryLocator.getInstance().get_usuarioRepository()
				.findUserByID(id);

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys()
				.getUsuarios().remove(_user);
		
		RepositoryLocator.getInstance().get_usuarioRepository().delete(_user);

	}

	@Override
	@Transactional
	public UsuarioDTO getUser(String userName) {

		Usuario _user = this.getUsersRepository().findUserByEmail(userName);

		UsuarioDTO _result = DTOFactory.getInstance().createUserDTO(
				_user.getEmail(), "", _user.getNombre(), _user.getTelefono(),
				_user.getOid(), _user.getVersion());

		return _result;

	}

	@Override
	@Transactional
	public UsuarioDTO checkLogin(String username, String password) {

		Usuario _user = RepositoryLocator.getInstance().get_usuarioRepository()
				.findUserByEmail(username);
		UsuarioDTO _result = new UsuarioDTO();

		if (_user.getOid() != null) {
			if (_user.isThePwd(password)) {
				_result = DTOFactory.getInstance().createUserDTO(
						_user.getEmail(), "***Password is secret***",
						_user.getNombre(), _user.getTelefono(), _user.getOid(),
						_user.getVersion());

				_result.setLoginCHecked(true);
			}
		}

		return _result;

	}

	@Override
	public Collection<UsuarioDTO> getUserbyProject(ProyectoDTO proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	public List<UsuarioDTO> getAllUsers(UsuarioDTO user) {

		Usuario _user = RepositoryLocator.getInstance().get_usuarioRepository()
				.findUserByEmail(user.getEmail());

		Iterator<Usuario> _userList = RepositoryLocator.getInstance()
				.get_usuarioRepository().findAllUsers().iterator();

		List<UsuarioDTO> _result = new ArrayList<UsuarioDTO>();
		Usuario _usuario = new Usuario();

		while (_userList.hasNext()) {
			_usuario = _userList.next();

			_result.add(DTOFactory.getInstance().createUserDTO(
					_usuario.getEmail(), _usuario.getPassword(),
					_usuario.getNombre(), _usuario.getTelefono(),
					_usuario.getOid(), _usuario.getVersion()));

		}

		return _result;
	}

	public List<UsuarioDTO> getAllUsers() {

		Iterator<Usuario> _userList = RepositoryLocator.getInstance()
				.get_usuarioRepository().findAllUsers().iterator();

		List<UsuarioDTO> _result = new ArrayList<UsuarioDTO>();
		Usuario _usuario = new Usuario();

		while (_userList.hasNext()) {
			_usuario = _userList.next();

			_result.add(DTOFactory.getInstance().createUserDTO(
					_usuario.getEmail(), _usuario.getPassword(),
					_usuario.getNombre(), _usuario.getTelefono(),
					_usuario.getOid(), _usuario.getVersion()));

		}

		return _result;
	}

	@Override
	public UsuarioDTO getUserByEmail(String email) {
		
		String email_result=null;
		
		Usuario usuario = RepositoryLocator.getInstance().get_usuarioRepository().findUserByEmail(email.toString() );
		
		if(usuario != null)
			email_result = usuario.getEmail();
		
		UsuarioDTO _result = DTOFactory.getInstance().createUserDTO(email_result, null, null, null, null, 0);
		
		return _result;
	}

}
