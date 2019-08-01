package com.cmv.petGenesis.model;

/**
 * Clase Medicament - Clase encargada de almacenar y gestionar los datos de medicamentos
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Medicament {

	private int idMedicament;
	private String nameMedicament;
	private TypeMedicament typeMedicament;
	
	/**
	 * Constructor vacio
	 */
	public Medicament() {
	}
	
	/**
	 * Constructor con elid
	 * @param idMedicament id
	 */
	public Medicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	/**
	 * Obtien el nombre del medicamento
	 * @return nameMedicament name
	 */
	public String getNameMedicament() {
		return nameMedicament;
	}

	/**
	 * Cambia el nombre del medicamento
	 * @param nameMedicament nombre
	 */
	public void setNameMedicament(String nameMedicament) {
		this.nameMedicament = nameMedicament;
	}

	/**
	 * Obtiene le tipo de medicamento
	 * @return typeMedicament tipo
	 */
	public TypeMedicament getTypeMedicament() {
		return typeMedicament;
	}

	/**
	 * Cambia el tipo de medicamento
	 * @param typeMedicament tipo
	 */
	public void setTypeMedicament(TypeMedicament typeMedicament) {
		this.typeMedicament = typeMedicament;
	}

	/**
	 * Obtiene el id del medicamento
	 * @return idMedicament id
	 */
	public int getIdMedicament() {
		return idMedicament;
	}

	/**
	 * Cambia el id del medicamento
	 * @param idMedicament
	 */
	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
}
