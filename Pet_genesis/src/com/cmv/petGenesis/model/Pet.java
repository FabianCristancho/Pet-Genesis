package com.cmv.petGenesis.model;

import java.util.Date;

/**
 * Clase Pet - Se encarga del manejo de los datos que tiene la mascota
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
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

	/**
	 * Constructor vacio
	 */
	public Pet() {
	}
	
	/**
	 * Constructor con el id
	 * @param id id
	 */
	public Pet(int id) {
		this.id = id;
	}

	/**
	 * Constructor con:
	 * @param id id
	 * @param namePet nombre mascota
	 * @param birthDate fecha de nacimiento
	 * @param specie especie
	 * @param race raza
	 * @param genderPet genero
	 * @param isCastrated es castrada
	 * @param colorPet color
	 * @param aditionalDescription descripción
	 */
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

	/**
	 * Obtiene le id
	 * @return id id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Cambia el id 
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtien el nombre
	 * @return namePet nombre
	 */
	public String getNamePet() {
		return namePet;
	}

	/**
	 * Cambia el nombre
	 * @param namePet nombre
	 */
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

	/**
	 * Obtiene la fecha
	 * @return birthDate fecha
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Cambia la fecha
	 * @param birthDate fecha
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Obtiene la especie
	 * @return specie s
	 */
	public Specie getSpecie() {
		return specie;
	}

	/**
	 * Cambia la especie s
	 * @param specie s
	 */
	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	/**
	 * Obteien la raza
	 * @return race r
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * Cambia la raza
	 * @param race r
	 */
	public void setRace(Race race) {
		this.race = race;
	}

	/**
	 * Obtiene le genero
	 * @return genderPet g
	 */
	public GenderPet getGenderPet() {
		return genderPet;
	}

	/**
	 * Cambia el genero de la persona
	 * @param genderPet g
	 */
	public void setGenderPet(GenderPet genderPet) {
		this.genderPet = genderPet;
	}

	/**
	 * Obtiene si es castrada
	 * @return isCastrated isc
	 */
	public boolean isCastrated() {
		return isCastrated;
	}

	/**
	 * Cambia el estado
	 * @param isCastrated isc
	 */
	public void setCastrated(boolean isCastrated) {
		this.isCastrated = isCastrated;
	}
	
	/**
	 * Obtiene el estado de la mascota
	 * @return statePet estado
	 */
	public StatePet getStatePet() {
		return statePet;
	}

	/**
	 * Cambia el estado de la mascota
	 * @param statePet estado
	 */
	public void setStatePet(StatePet statePet) {
		this.statePet = statePet;
	}

	/**
	 * Obtiene el color de la mascota
	 * @return colorPet color
	 */
	public String getColorPet() {
		return colorPet;
	}

	/**
	 * Cambia el color de la mascota
	 * @param colorPet color
	 */
	public void setColorPet(String colorPet) {
		this.colorPet = colorPet;
	}

	/**
	 * Obtiene una descripcion
	 * @return aditionalDescription d
	 */
	public String getAditionalDescription() {
		return aditionalDescription;
	}

	/**
	 * Cambia la descripción
	 * @param aditionalDescription d
	 */
	public void setAditionalDescription(String aditionalDescription) {
		this.aditionalDescription = aditionalDescription;
	}

	/**
	 * Obtiene el cliente
	 * @return client c
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Cambia el cliente
	 * @param client c
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
