package com.cmv.petGenesis.model;

public class Specie {
	private int idSpecie;
	private String nameSpecie;
	
	
	public Specie() {
	}
	
	public Specie(int idSpecie, String nameSpecie) {
		this.idSpecie = idSpecie;
		this.nameSpecie = nameSpecie;
	}

	public int getIdSpecie() {
		return idSpecie;
	}

	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}

	public String getNameSpecie() {
		return nameSpecie;
	}

	public void setNameSpecie(String nameSpecie) {
		this.nameSpecie = nameSpecie;
	}
}
