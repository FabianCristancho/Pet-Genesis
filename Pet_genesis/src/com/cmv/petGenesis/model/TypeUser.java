package com.cmv.petGenesis.model;

public enum TypeUser {
	MANAGER((byte) 1, "Gerente General"), DOCTOR((byte) 2, "Médico Veterinario"),
	RECEPTION_ASSISTANT((byte) 3, "Asistente de Recepción"), VETERINARIAN_ASSISTANT((byte)4, "Auxiliar Veterinario");

	private byte idTypeUser;
	private String nameTypeUser;

	private TypeUser(byte idTypeUser, String nameTypeUser) {
		this.idTypeUser = idTypeUser;
		this.nameTypeUser = nameTypeUser;
	}
	
	public byte getIdTypeUser() {
		return idTypeUser;
	}

	public void setIdTypeUser(byte idTypeUser) {
		this.idTypeUser = idTypeUser;
	}

	public String getNameTypeUser() {
		return nameTypeUser;
	}

	public void setNameTypeUser(String nameTypeUser) {
		this.nameTypeUser = nameTypeUser;
	}

	public static TypeUser getTypeUser(int id) {
		if (id == 1) {
			return TypeUser.MANAGER;
		} else if (id == 2) {
			return TypeUser.DOCTOR;
		} else if (id == 3) {
			return TypeUser.RECEPTION_ASSISTANT;
		}else if (id == 4) {
			return TypeUser.VETERINARIAN_ASSISTANT;
		}
		return null;
	}
}
