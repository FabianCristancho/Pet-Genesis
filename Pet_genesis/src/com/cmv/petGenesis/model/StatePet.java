package com.cmv.petGenesis.model;


public enum StatePet {
	ACTIV(0, 'A'), INACTIV(1, 'I'), STORE(2, 'S'), BLOCKED(3,'B');
	
	private int idState;
	private char nameState;
	
	private StatePet(int idState, char nameState) {
		this.nameState = nameState;
		this.idState = idState;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public char getNameState() {
		return nameState;
	}

	public void setNameState(char nameState) {
		this.nameState = nameState;
	}

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
