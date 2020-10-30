/**
 * 
 */
package com.quickstar.wicket.example.entity;

import java.io.Serializable;

/**
 * @author Acasmol
 *
 */
public class Persona implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8544427317819657839L;
	private String nombre = null;
	private String apellidoPaterno = null;
	private String apellidoMaterno = null;
	private Integer edad = null;
	private String numeroDeTelefono = null;
	private Long numeroDePersona = null;
	
	
	/**
	 * 
	 */
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param appellidoPaterno
	 * @param apellidoMaterno
	 * @param edad
	 * @param numeroDeTelefono
	 * @param numeroDePersona
	 */
	@SuppressWarnings("unused")
	private Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Integer edad,
			String numeroDeTelefono, Long numeroDePersona) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
		this.numeroDeTelefono = numeroDeTelefono;
		this.numeroDePersona = numeroDePersona;
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the appellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	/**
	 * @param appellidoPaterno the appellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}


	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	/**
	 * @return the numeroDeTelefono
	 */
	public String getNumeroDeTelefono() {
		return numeroDeTelefono;
	}


	/**
	 * @param numeroDeTelefono the numeroDeTelefono to set
	 */
	public void setNumeroDeTelefono(String numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the numeroDePersona
	 */
	public Long getNumeroDePersona() {
		return numeroDePersona;
	}

	/**
	 * @param numeroDePersona the numeroDePersona to set
	 */
	public void setNumeroDePersona(Long numeroDePersona) {
		this.numeroDePersona = numeroDePersona;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", appellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", edad=" + edad + ", numeroDeTelefono=" + numeroDeTelefono + ", numeroDePersona="
				+ numeroDePersona + "]";
	}
		
}
