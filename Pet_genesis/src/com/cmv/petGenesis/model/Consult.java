package com.cmv.petGenesis.model;

import java.util.Date;

/**
 * Clase Consult - Se encarga de los datos de la consulta
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Consult {

	private int idConsult;
	private String motiveConsult;
	private Date dateConsult;
	private Pet pet;
	private Person person;

	/**
	 * Constructor vacio
	 */
	public Consult() {
	}

	/**
	 * Constructor con sólo id
	 * @param idConsult id
	 */
	public Consult(int idConsult) {
		this.idConsult = idConsult;
	}

	/**
	 * Obtiene el id
	 * @return id v
	 */
	public int getIdConsult() {
		return idConsult;
	}

	/**
	 * Cambia el valor del id
	 * @param idConsult v
	 */
	public void setIdConsult(int idConsult) {
		this.idConsult = idConsult;
	}

	/**
	 * Obtiene el motivo de la consulta
	 * @return motiveConsult motivo
	 */
	public String getMotiveConsult() {
		return motiveConsult;
	}

	/**
	 * Cambia los motivos de la consulta
	 * @param motiveConsult motivo
	 */
	public void setMotiveConsult(String motiveConsult) {
		this.motiveConsult = motiveConsult;
	}

	/**
	 * Obtiene la fecha de la consulta
	 * @return dateConsult fecha
	 */
	public Date getDateConsult() {
		return dateConsult;
	}

	/**
	 * Cambia la fecha de la consulta
	 * @param dateConsult fecha
	 */
	public void setDateConsult(Date dateConsult) {
		this.dateConsult = dateConsult;
	}

	/**
	 * Obtiene la mascota
	 * @return pet mascota
	 */
	public Pet getPet() {
		return pet;
	}

	/**
	 * Cambia la mascota
	 * @param pet mascota
	 */
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	/**
	 * Obtiene la persona
	 * @return person p
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Cambia los valores de la persona
	 * @param person persona
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
