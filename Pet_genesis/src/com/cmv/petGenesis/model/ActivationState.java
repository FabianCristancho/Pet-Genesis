package com.cmv.petGenesis.model;

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

	public ActivationState getState(boolean isActive) {
		if (isActive)
			return ActivationState.ACTIV;
		return ActivationState.INACTIV;
	}
}
