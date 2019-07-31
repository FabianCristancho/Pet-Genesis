package com.cmv.petGenesis.model;

/**
 * Clase que almacena o modifica los tipos de medicamentos
 * 
 * @author Fabian Cristancho
 *
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
	 * 
	 * @param idTypeMed   Codigo del tipo
	 */
	public TypeMedicament(int idTypeMed) {
		this.idTypeMed = idTypeMed;
	}

	public int getIdTypeMed() {
		return idTypeMed;
	}

	public void setIdTypeMed(int idTypeMed) {
		this.idTypeMed = idTypeMed;
	}

	public String getNameTypeMed() {
		return nameTypeMed;
	}

	public void setNameTypeMed(String nameTypeMed) {
		this.nameTypeMed = nameTypeMed;
	}
}
