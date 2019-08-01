package com.cmv.petGenesis.model;

/**
 * Clase Race - Se encarga de manejar los datos de la raza de la mascota
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Race {
	private int idRace;
	private String nameRace;
	
	/**
	 * Constructor vacio
	 */
	public Race() {
	}
	
	/**
	 * Constructor con id y nombre
	 * @param idRace id
	 * @param nameRace nombre de la raza
	 */
	public Race(int idRace, String nameRace) {
		this.idRace = idRace;
		this.nameRace = nameRace;
	}
	
	/**
	 * Constructor con id
	 * @param idRace id
	 */
	public Race(int idRace) {
		this.idRace = idRace;
	}

	/**
	 * Obtiene el id de la raza
	 * @return idRace
	 */
	public int getIdRace() {
		return idRace;
	}

	/**
	 * Cambia el id
	 * @param idRace
	 */
	public void setIdRace(int idRace) {
		this.idRace = idRace;
	}

	/**
	 * Obteiene le nombre de la raza
	 * @return nameRace nombre
	 */
	public String getNameRace() {
		return nameRace;
	}

	/**
	 * Cambia el nombre de la raza
	 * @param nameRace nombre
	 */
	public void setNameRace(String nameRace) {
		this.nameRace = nameRace;
	}
}
