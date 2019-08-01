package com.cmv.petGenesis.model;

/**
 * Clase Specie - Se encarga del manejo de las especies de mascotas
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Specie {
	private int idSpecie;
	private String nameSpecie;
	
	/**
	 * Constructor vacio
	 */
	public Specie() {
	}
	
	/**
	 * Constructor con id
	 * @param idSpecie id
	 */
	public Specie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	
	/**
	 * Constructor con nombre e id
	 * @param idSpecie id
	 * @param nameSpecie nombre
	 */
	public Specie(int idSpecie, String nameSpecie) {
		this.idSpecie = idSpecie;
		this.nameSpecie = nameSpecie;
	}

	/**
	 * Obtiene le id
	 * @return idSpecie id
	 */
	public int getIdSpecie() {
		return idSpecie;
	}

	/**
	 * Cambia el id de la especie
	 * @param idSpecie id
	 */
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}

	/**
	 * Obtien el nombre de la especie
	 * @return nameSpecie name
	 */
	public String getNameSpecie() {
		return nameSpecie;
	}

	/**
	 * Cambia el nombre de la especie
	 * @param nameSpecie name
	 */
	public void setNameSpecie(String nameSpecie) {
		this.nameSpecie = nameSpecie;
	}
}
