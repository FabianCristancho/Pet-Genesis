package com.cmv.petGenesis.model;

/**
 * Enum GenderPet - Enumerado con los genros de las macotas (macho - hembra)
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum GenderPet {
	MALE('M', "Macho"), FEMALE('F', "Hembra");

	private char idGender;
	private String nameGender;

	/**
	 * Constructor vacio
	 * @param idGender genero
	 */
	private GenderPet(char idGender, String nameGender) {
		this.idGender = idGender;
		this.nameGender = nameGender;
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
	
	public String getNameGender() {
		return nameGender;
	}

	public void setNameGender(String nameGender) {
		this.nameGender = nameGender;
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