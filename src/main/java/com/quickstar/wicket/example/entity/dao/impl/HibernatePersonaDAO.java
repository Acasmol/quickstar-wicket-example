/**
 * 
 */
package com.quickstar.wicket.example.entity.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.quickstar.wicket.example.database.HibernateSession;
import com.quickstar.wicket.example.enity.dao.PersonaDAO;
import com.quickstar.wicket.example.entity.Persona;

/**
 * @author Acasmol
 *
 */
public class HibernatePersonaDAO implements PersonaDAO {

	@Override
	public Persona selectById(Long Id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Persona persona = (Persona) session.get(Persona.class,  Id);
		session.close();
		return persona;
	}

	@Override
	public List<Persona> selectAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Persona> personas = session.createCriteria(Persona.class).list();
		session.close();
		return personas;
	}

	@Override
	public void insert(Persona persona) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Long id = (Long) session.save(persona);
		persona.setNumeroDePersona(id);
		session.getTransaction().commit();
		
		
		session.close();
	}

	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.merge(persona);
		session.getTransaction().commit();
		
		
		session.close();
	}

	@Override
	public void delete(Persona persona) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.delete(persona);
		session.getTransaction().commit();
		
		
		session.close();
	}

}
