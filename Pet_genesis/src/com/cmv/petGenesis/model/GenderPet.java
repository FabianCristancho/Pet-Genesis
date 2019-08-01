package com.cmv.petGenesis.model;

/**
 * Enum GenderPet - Enumerado con los genros de las macotas (macho - hembra)
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum GenderPet {
	MALE('M'), FEMALE('F');

	private char idGender;

	/**
	 * Constructor vacio
	 * @param idGender genero
	 */
	private GenderPet(char idGender) {
		this.idGender = idGender;
	}
	
	/**
	 * Obtiene el id
	 * @return idGender id
	 */
	public char getIdGender() {
		return idGender;
	}

	/**
	 * Cambia el valor del id
	 * @param idGender id
	 */
	public void setIdGender(char idGender) {
		this.idGender = idGender;
	}
	
	/**
	 * Cambia el genero de la mascota verificando si es macho
	 * @param isMale macho
	 * @return GenderPet con el genero
	 */
	public static GenderPet getGender(boolean isMale) {
		if (isMale)
			return GenderPet.MALE;
		return GenderPet.FEMALE;
	}
}