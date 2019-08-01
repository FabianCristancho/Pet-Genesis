package com.cmv.petGenesis.model;

/**
 * Enum StatePet - Enumerado con los estados de activación de la mascota
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum StatePet {
	ACTIV(0, 'A'), INACTIV(1, 'I'), STORE(2, 'S'), BLOCKED(3,'B');
	
	private int idState;
	private char nameState;
	
	/**
	 * Constructor con:
	 * @param idState id
	 * @param nameState nombre
	 */
	private StatePet(int idState, char nameState) {
		this.nameState = nameState;
		this.idState = idState;
	}

	/**
	 * Obtiene el estado
	 * @return idState
	 */
	public int getIdState() {
		return idState;
	}

	/**
	 * Cambia el id del estado
	 * @param idState id
	 */
	public void setIdState(int idState) {
		this.idState = idState;
	}

	/**
	 * Obtiene el nombre del estado
	 * @return nameState nombre
	 */
	public char getNameState() {
		return nameState;
	}

	/**
	 * Cambia el nombre del estado
	 * @param nameState nombre
	 */
	public void setNameState(char nameState) {
		this.nameState = nameState;
	}

	/**
	 * Seleciona un estado por un indice
	 * @param state estado
	 * @return StatePet estado
	 */
	public static StatePet getState(int state) {
		switch (state) {
		case 0:
			return StatePet.ACTIV;
		case 1:
			return StatePet.INACTIV;
		case 2:
			return StatePet.STORE;
		case 3:
			return StatePet.BLOCKED;
		default:
			return StatePet.ACTIV;
		}
	}
	
	/**
	 * Obtiene estado por un caracter (Primera letra)
	 * @param state estado
	 * @return StatePet estado
	 */
	public static StatePet getState(char state) {
		switch (state) {
		case 'A':
			return StatePet.ACTIV;
		case 'I':
			return StatePet.INACTIV;
		case 'S':
			return StatePet.STORE;
		case 'B':
			return StatePet.BLOCKED;
		default:
			return StatePet.ACTIV;
		}
	}

}
