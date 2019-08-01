package com.cmv.petGenesis.model;

/**
 * Enum ActivationState - Enumerado con los tipo de estado de activación del usuario 
 * y cliente
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum ActivationState {
	INACTIV('I'), ACTIV('A');

	private char idState;

	/**
	 * Constructor con un estado
	 * @param idState
	 */
	private ActivationState(char idState) {
		this.idState = idState;
	}

	/**
	 * Obtiene el valor del enum en char
	 * @return idState id del estado
	 */
	public char getIdState() {
		return idState;
	}

	/**
	 * Cambia el valor del estado
	 * @param idState estado
	 */
	public void setIdState(char idState) {
		this.idState = idState;
	}

	/**
	 * Cambia el valor del enum dependiendo si está activo
	 * @param isActive boolean p
	 * @return Enum con estado de activación
	 */
	public static ActivationState getState(boolean isActive) {
		if (isActive)
			return ActivationState.ACTIV;
		return ActivationState.INACTIV;
	}
}
