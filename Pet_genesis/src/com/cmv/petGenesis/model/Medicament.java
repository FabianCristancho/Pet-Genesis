package com.cmv.petGenesis.model;

/**
 * Clase encargada de almacenar y gestionar los datos de medicamentos
 * 
 * @author Fabian Cristancho
 *
 */
public class Medicament {

	private String nameMedicament;
	private TypeMedicament typeMedicament;

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
}
