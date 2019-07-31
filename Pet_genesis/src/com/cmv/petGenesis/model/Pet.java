package com.cmv.petGenesis.model;

import java.util.Date;

public class Pet {

	private int id;
	private String namePet;
	private Date birthDate;
	private Specie specie;
	private Race race;
	private GenderPet genderPet;
	private boolean isCastrated;
	private StatePet statePet;
	private String colorPet;
	private String aditionalDescription;
	private Client client;

	public Pet() {
	}
	
	public Pet(int id) {
		this.id = id;
	}

	public Pet(int id, String namePet, Date birthDate, Specie specie, Race race, GenderPet genderPet,
			boolean isCastrated, String colorPet, String aditionalDescription) {
		this.id = id;
		this.namePet = namePet;
		this.birthDate = birthDate;
		this.specie = specie;
		this.race = race;
		this.genderPet = genderPet;
		this.isCastrated = isCastrated;
		this.colorPet = colorPet;
		this.aditionalDescription = aditionalDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public GenderPet getGenderPet() {
		return genderPet;
	}

	public void setGenderPet(GenderPet genderPet) {
		this.genderPet = genderPet;
	}

	public boolean isCastrated() {
		return isCastrated;
	}

	public void setCastrated(boolean isCastrated) {
		this.isCastrated = isCastrated;
	}
	
	public StatePet getStatePet() {
		return statePet;
	}

	public void setStatePet(StatePet statePet) {
		this.statePet = statePet;
	}

	public String getColorPet() {
		return colorPet;
	}

	public void setColorPet(String colorPet) {
		this.colorPet = colorPet;
	}

	public String getAditionalDescription() {
		return aditionalDescription;
	}

	public void setAditionalDescription(String aditionalDescription) {
		this.aditionalDescription = aditionalDescription;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
