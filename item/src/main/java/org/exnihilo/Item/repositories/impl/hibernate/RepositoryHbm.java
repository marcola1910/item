package org.exnihilo.Item.repositories.impl.hibernate;

import org.exnihilo.Item.spring.ItemApplicationContext;
import org.exnihilo.Item.spring.ItemQuery;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public abstract class RepositoryHbm  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public RepositoryHbm() {
		// TODO Auto-generated constructor stub
	}

	protected Object findById(Class<?> aClass, Object anOid) {

		return sessionFactory.getCurrentSession().get(aClass, (String) anOid);
	}
	
	protected Query getNamedQuery(String aName) {
		ApplicationContext aContext = ItemApplicationContext
				.getApplicationContext();

		ItemQuery itemQuery = (ItemQuery) aContext.getBean(aName);

		Query aQuery = sessionFactory.getCurrentSession()
				.createQuery(itemQuery.getQueryString());

		return aQuery;
	}

	
	public void delete(Object o) throws Exception {
		getSessionFactory().getCurrentSession().delete(o);
		
	}
}
