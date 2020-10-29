/**
 * 
 */
package com.quickstar.wicket.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Acasmol
 *
 */
public class HibernateSession {
	
	public static final SessionFactory sessionFactory = buildSessionFactory();
	public static Session session;
	
	
	/**
	 * Usando el archivo hibernate.cfg.xml crea un Session Factory
	 * 
	 * @return sessionFactory
	 */
	private static SessionFactory buildSessionFactory()
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return  sessionFactory;
		}
		catch(Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	/**
	 * Retorna una instancia del SessionFacotry
	 * 
	 * @return hibernate Session Factory instance
	 */
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	
	
	/**
	 * Retorna la sesion
	 * 
	 * @return
	 */
	public Session getSession()
	{
		if(null == session)
		{
			session = sessionFactory.openSession();
		}
		
		return session;
	}	

}
