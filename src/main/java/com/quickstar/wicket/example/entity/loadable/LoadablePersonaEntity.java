/**
 * 
 */
package com.quickstar.wicket.example.entity.loadable;

import org.apache.wicket.model.LoadableDetachableModel;

import com.quickstar.wicket.entity.dao.impl.HibernatePersonaDAO;
import com.quickstar.wicket.example.enity.dao.PersonaDAO;
import com.quickstar.wicket.example.entity.Persona;

/**
 * @author Acasmol
 *
 */
@SuppressWarnings("rawtypes")
public class LoadablePersonaEntity extends LoadableDetachableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8979484655026244577L;
	private Long numeroDePersona = null;
	private transient Persona persona = null; //El objeto persona no se va a serializar

	/**
	 * @param medico
	 */
	@SuppressWarnings("unchecked")
	public LoadablePersonaEntity(Persona persona, Long numeroDePersona) {
		super(persona);
		this.persona = persona;
		this.numeroDePersona = numeroDePersona;
	}

	


	/**
	 * @param medicoId
	 */
	@SuppressWarnings("unchecked")
	public LoadablePersonaEntity(Persona persona) {
		super(persona);
		this.numeroDePersona = persona.getNumeroDePersona();
	}
	
	/**
	 * @param medicoId
	 */
	public LoadablePersonaEntity(Long numeroDePersona) {
		super();
		this.numeroDePersona = numeroDePersona;
	}
	@Override
	protected Object load() 
	{
		// TODO Auto-generated method stub
		if(persona != null)
		{
			return persona;
		}
		else if(persona == null || numeroDePersona == 0L)
		{
			return new Persona();
		}
		else if(numeroDePersona != null )
		{
			PersonaDAO personaDAO = new HibernatePersonaDAO();
			return personaDAO.selectById(numeroDePersona);
		}
		else
		{
			return new Persona();
		}
	}

}
