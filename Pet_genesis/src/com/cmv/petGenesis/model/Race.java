package com.cmv.petGenesis.model;

public class Race {
	private int idRace;
	private String nameRace;
	
	public Race() {
	}
	
	public Race(int idRace, String nameRace) {
		this.idRace = idRace;
		this.nameRace = nameRace;
	}
	
	public Race(int idRace) {
		this.idRace = idRace;
	}

	public int getIdRace() {
		return idRace;
	}

	public void setIdRace(int idRace) {
		this.idRace = idRace;
	}

	public String getNameRace() {
		return nameRace;
	}

	public void setNameRace(String nameRace) {
		this.nameRace = nameRace;
	}
}
