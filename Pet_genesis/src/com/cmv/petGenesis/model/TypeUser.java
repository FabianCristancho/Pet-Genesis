package com.cmv.petGenesis.model;

/**
 * Enum TypeUser - Enumerado con los tipos de usuarios
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum TypeUser {
	MANAGER((byte) 1, "Gerente General"), DOCTOR((byte) 2, "Médico Veterinario"),
	RECEPTION_ASSISTANT((byte) 3, "Asistente de Recepción"), VETERINARIAN_ASSISTANT((byte) 4, "Auxiliar Veterinario");

	private byte idTypeUser;
	private String nameTypeUser;

	/**
	 * Constructor con:
	 * @param idTypeUser id
	 * @param nameTypeUser nombre del tipo de usuario
	 */
	private TypeUser(byte idTypeUser, String nameTypeUser) {
		this.idTypeUser = idTypeUser;
		this.nameTypeUser = nameTypeUser;
	}

	/**
	 * Obtener el id
	 * @return idTypeUser id
	 */
	public byte getIdTypeUser() {
		return idTypeUser;
	}

	/**
	 * Cambia el id
	 * @param idTypeUser id
	 */
	public void setIdTypeUser(byte idTypeUser) {
		this.idTypeUser = idTypeUser;
	}

	/**
	 * Obtien el nombre
	 * @return nameTypeUser nombre
	 */
	public String getNameTypeUser() {
		return nameTypeUser;
	}

	/**
	 * Cambia el nombre del tipo
	 * @param nameTypeUser name
	 */
	public void setNameTypeUser(String nameTypeUser) {
		this.nameTypeUser = nameTypeUser;
	}

	/**
	 * Cambia el tipo de usuario
	 * @param id id
	 * @return TypeUser tipo de usuario
	 */
	public static TypeUser getTypeUser(int id) {
		if (id == 1) {
			return TypeUser.MANAGER;
		} else if (id == 2) {
			return TypeUser.DOCTOR;
		} else if (id == 3) {
			return TypeUser.RECEPTION_ASSISTANT;
		} else if (id == 4) {
			return TypeUser.VETERINARIAN_ASSISTANT;
		}
		return null;
	}
}
