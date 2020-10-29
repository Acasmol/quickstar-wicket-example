/**
 * 
 */
package com.quickstar.wicket.example.enity.dao;

import java.util.List;

import com.quickstar.wicket.example.entity.Persona;


/**
 * @author Acasmol
 *
 */
public interface PersonaDAO {
	
	
	public Persona selectById(Long Id);
	
	public List<Persona> selectAll();
	
	public void insert(Persona persona);
	
	public void update(Persona persona);
	
	public void delete(Persona persona);	

}
