package org.exnihilo;


import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.exnihilo.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	
	String modalTransfer;
	@Autowired
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	private IniMode inimode;
	private InitStrategy inistrategy;

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		/*
		// 1 - Set up the persistence strategy
		this.inimode = IniMode.valueOf(getServletContext().getInitParameter("InitMode") ); 
		
		switch (this.inimode ) {
	        case MOCK:  this.inistrategy = new MockInitStrategy();
	                 break;
	        case MYSQLHBM:   
	        		 this.inistrategy = new HbmInitStrategy();
	        		 HbmInitStrategy.setWebapp(this);
	                 break;
	                 
	        case NEO4J:   this.inistrategy = new HbmInitStrategy();
	        	break; 
		}
		

		// 2 - pop up the Masters: Equipo, miembroequipo, puesto, usuario
		this.inistrategy.initModel();
		
		// 3 - configure the services locator for mock
		this.inistrategy.initServices();
		
		// 4 - configure the repositories locator for mock
		this.inistrategy.initRepositories();
		
		@SuppressWarnings("unused")
		int x = 0;
		
		*/
	}

	public String getModalTransfer() {
		return modalTransfer;
	}

	public void setModalTransfer(String modalTransfer) {
		this.modalTransfer = modalTransfer;
	}

	@Override
	public Session newSession(Request request, Response response) {
		// TODO Auto-generated method stub
		return new UserSession(request);
	}

}
