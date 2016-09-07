package org.exnihilo.Item.repositories.impl.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.repositories.bi.UsuarioRepositoryBI;

public class UsuarioRepositoryImpl implements UsuarioRepositoryBI  {
	
	ItemSys rootobject;
	
	public UsuarioRepositoryImpl() {
		
	}
	
	public UsuarioRepositoryImpl(ItemSys mItem){
		this.rootobject = mItem;
	}

	@Override
	public Usuario findUserByEmail(String email) {
		
		Iterator<Usuario> _userList = rootobject.getUsuarios().iterator();
		Usuario	_result = new Usuario();
		Usuario	_usuario = new Usuario();
		
		while(_userList.hasNext()){
			_usuario = _userList.next();
			if( _usuario.getEmail().equals(email) )
				_result = _usuario; 
		}
		
		return _result;
	}

	public List<Usuario> findAllUsers() {
		
		return rootobject.getUsuarios();
	}
	
	@Override
	public Usuario findUserByID(String userID) {

		Iterator<Usuario> _userList = rootobject.getUsuarios().iterator();
		Usuario	_result = new Usuario();
		Usuario	_usuario = new Usuario();
		
		while(_userList.hasNext()){
			_usuario = _userList.next();
			if( _usuario.getOid().equals(userID) )
				_result = _usuario; 
		}
		
		return _result;
		
	}

	@Override
	public Collection<Usuario> findUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Usuario> findUsersByName(String name) {

		Iterator<Usuario> _userList = rootobject.getUsuarios().iterator();
		Collection<Usuario> _result = new ArrayList<Usuario>();
		
		while(_userList.hasNext()){
			
			if( _userList.next().getEmail() == name )
				_result.add(_userList.next()); 
		}
		
		return _result;
		
	}

	@Override
	public void delete(Usuario _user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
