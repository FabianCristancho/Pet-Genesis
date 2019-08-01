package com.cmv.petGenesis.model;

/**
 * Clase ActivationState.java - 
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public enum ActivationState {
	INACTIV('I'), ACTIV('A');

	private char idState;

	private ActivationState(char idState) {
		this.idState = idState;
	}

	public char getIdState() {
		return idState;
	}

	public void setIdState(char idState) {
		this.idState = idState;
	}

	public static ActivationState getState(boolean isActive) {
		if (isActive)
			return ActivationState.ACTIV;
		return ActivationState.INACTIV;
	}
}
