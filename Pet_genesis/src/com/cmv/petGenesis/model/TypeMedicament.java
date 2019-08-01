package com.cmv.petGenesis.model;

/**
 * Clase TypeMedicament - Clase que almacena o modifica los tipos de medicamentos
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class TypeMedicament {

	private int idTypeMed;
	private String nameTypeMed;

	/**
	 * Constructor vacio
	 */
	public TypeMedicament() {
	}

	/**
	 * Constructor que recibe objetos de id tipo medicamento, con su respectivo
	 * nombre
	 * 
	 * @param idTypeMed   Codigo del tipo
	 * @param nameTypeMed Nombre del tipo
	 */
	public TypeMedicament(int idTypeMed, String nameTypeMed) {
		this.idTypeMed = idTypeMed;
		this.nameTypeMed = nameTypeMed;
	}
	
	
	/**
	 * Constructor que recibe objetos de id tipo medicamento
	 * @param idTypeMed   Codigo del tipo
	 */
	public TypeMedicament(int idTypeMed) {
		this.idTypeMed = idTypeMed;
	}

	/**
	 * Obteiene el id
	 * @return idTypeMed id
	 */
	public int getIdTypeMed() {
		return idTypeMed;
	}

	/**
	 * Cambia el id del tipo
	 * @param idTypeMed id
	 */
	public void setIdTypeMed(int idTypeMed) {
		this.idTypeMed = idTypeMed;
	}

	/**
	 * Obtiene el nombre del tipo
	 * @return nameTypeMed nombre
	 */
	public String getNameTypeMed() {
		return nameTypeMed;
	}

	/**
	 * Cambia el nombre sel tipo
	 * @param nameTypeMed nombre
	 */
	public void setNameTypeMed(String nameTypeMed) {
		this.nameTypeMed = nameTypeMed;
	}
}
