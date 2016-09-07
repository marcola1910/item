package org.exnihilo.Item.services.ServiceDecorators;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.repositories.impl.mock.ItemSysRepositoryImpl;
import org.exnihilo.Item.services.bi.UserServiceBI;
import org.exnihilo.Item.services.mock.BaseServiceImpl;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.UsuarioDTO;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class UserServiceTxHbm extends HbmTxDecorator implements UserServiceBI {

	public UserServiceTxHbm() {
		// TODO Auto-generated constructor stub
	}

	public UserServiceTxHbm(ItemSysRepositoryBI itemSysRep) {
		super.set_itemSysRepository(itemSysRep);
	}
	
	
	public UserServiceTxHbm( BaseServiceImpl service ) {
		
		super(service);
		
	}

	
	
	@Override
	public UsuarioDTO addUser(UsuarioDTO user) {

		
		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		ItemSys rootObj = RepositoryLocator.getInstance().getItemSysRepository().findItemSys();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		user = ((UserServiceBI) super.getServicio()).addUser(user);
		
		tx.commit();
		
		session.close();
		
		return user;

	}

	@Override
	public UsuarioDTO changeUser(UsuarioDTO user) {
		
		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		UserServiceBI usrservice = ((UserServiceBI) super.getServicio());
		
		try {
			user = usrservice.changeUser(user);
		} catch (ItemConcurrentModificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tx.commit();
		
		session.close();
		
		
		return user;
	}

	@Override
	public void deleteUser(String id) {
		
		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		try {
			((UserServiceBI) super.getServicio()).deleteUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tx.commit();
		
		session.close();
		
	}

	@Override
	public UsuarioDTO getUser(String userName) {

		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		UsuarioDTO _user =  ((UserServiceBI) super.getServicio()).getUser(userName);
		
		tx.commit();
		
		session.close();
		
		return _user;

	}

	@Override
	public UsuarioDTO checkLogin(String username, String password) {
		
		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		UsuarioDTO _user =  ((UserServiceBI) super.getServicio()).checkLogin(username, password);
		
		tx.commit();
		
		session.close();
		
		return _user;

	}

	@Override
	public Collection<UsuarioDTO> getUserbyProject(ProyectoDTO proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsuarioDTO> getAllUsers(UsuarioDTO user) {


		Session session = super.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		List<UsuarioDTO> _user =  ((UserServiceBI) super.getServicio()).getAllUsers(user);
		
		
		tx.commit();
		
		session.close();
		
		
		return _user;

		
	}
	
	public List<UsuarioDTO> getAllUsers(){
		
		beginSession();
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		
		// Recupera el objeto del servicio que estamos decorando y se hace boxing
		// para la interfaz del servicio de ItemType
		List<UsuarioDTO> _user =  ((UserServiceBI) super.getServicio()).getAllUsers();
		
		tx.commit();
		
		endSession();
	
		return _user;
	}

	@Override
	public UsuarioDTO getUserByEmail(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
