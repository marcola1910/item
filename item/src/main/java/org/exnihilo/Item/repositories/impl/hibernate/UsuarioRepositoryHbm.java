package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.repositories.bi.UsuarioRepositoryBI;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioRepositoryHbm extends RepositoryHbm  implements UsuarioRepositoryBI  {
	
	ItemSys rootobject;
		
	public UsuarioRepositoryHbm() {
		
	}
	
	public UsuarioRepositoryHbm(ItemSys mItem){
		this.rootobject = mItem;
	}

	@Override
	public Usuario findUserByEmail(String email) {

		//crea una consulta desde la sesion seteada al principio en el init del repository
		Query query =  super.getSessionFactory().getCurrentSession().createQuery("from Usuario where email = :email ");
		query.setParameter("email", email);
		Usuario _result = (Usuario) query.uniqueResult();
		
		return _result;
	}

	public List<Usuario> findAllUsers() {
		
		//crea una consulta desde la sesion seteada al principio en el init del repository
		Query query = getSessionFactory().getCurrentSession().createQuery("from Usuario");
		
		List<Usuario> _result = query.list();
		
		return _result;
	}
	
	@Override
	public Usuario findUserByID(String userID) {

		//crea una consulta desde la sesion seteada al principio en el init del repository
		Query query = super.getSessionFactory().getCurrentSession().createQuery("from Usuario where oid = :oid ");
		query.setParameter("oid", userID);
		Usuario _result = (Usuario) query.list().get(0);

		
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
		super.delete(_user);
		
	}


}
