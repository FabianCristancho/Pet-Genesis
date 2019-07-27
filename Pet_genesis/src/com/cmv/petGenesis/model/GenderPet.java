package com.cmv.petGenesis.model;

public enum GenderPet {
	MALE('M'), FEMALE('F');

	private char idGender;

	private GenderPet(char idGender) {
		this.idGender = idGender;
	}

	public char getIdGender() {
		return idGender;
	}

	public void setIdGender(char idGender) {
		this.idGender = idGender;
	}
	
	public static GenderPet getGender(boolean isMale) {
		if (isMale)
			return GenderPet.MALE;
		return GenderPet.FEMALE;
	}
}