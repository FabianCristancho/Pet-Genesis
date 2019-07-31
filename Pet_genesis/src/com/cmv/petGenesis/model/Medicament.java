package com.cmv.petGenesis.model;

/**
 * Clase encargada de almacenar y gestionar los datos de medicamentos
 * 
 * @author Fabian Cristancho
 *
 */
public class Medicament {

	private int idMedicament;
	private String nameMedicament;
	private TypeMedicament typeMedicament;
	
	public Medicament() {
	}
	
	public Medicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getNameMedicament() {
		return nameMedicament;
	}

	public void setNameMedicament(String nameMedicament) {
		this.nameMedicament = nameMedicament;
	}

	public TypeMedicament getTypeMedicament() {
		return typeMedicament;
	}

	public void setTypeMedicament(TypeMedicament typeMedicament) {
		this.typeMedicament = typeMedicament;
	}

	public int getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
}
