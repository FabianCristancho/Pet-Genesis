package com.cmv.petGenesis.model;

/**
 * Clase Recet - Se encarga de manejar los datos de la receta que se formula en 
 * la consulta
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Recet {
	
	private int idRecet;
	private Medicament medicament;
	private Consult consult;
	private String dosis;
	private String frecuency;
	
	/**
	 * Obteien el id de la receta
	 * @return idRecet id
	 */
	public int getIdRecet() {
		return idRecet;
	}
	
	/**
	 * Cambia el id
	 * @param idRecet id
	 */
	public void setIdRecet(int idRecet) {
		this.idRecet = idRecet;
	}
	
	/**
	 * Obtiene el medicamento
	 * @return medicament m
	 */
	public Medicament getMedicament() {
		return medicament;
	}
	
	/**
	 * Cambia el medicamento
	 * @param medicament m
	 */
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	/**
	 * Obtiene la consulta
	 * @return consult c
	 */
	public Consult getConsult() {
		return consult;
	}
	
	/**
	 * Cambia la consulta
	 * @param consult c
	 */
	public void setConsult(Consult consult) {
		this.consult = consult;
	}
	
	/**
	 * Obtiene la dosis
	 * @return dosis d
	 */
	public String getDosis() {
		return dosis;
	}
	
	/**
	 * Cambia la dosis
	 * @param dosis d
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	
	/**
	 * Obtiene la frecuencia para tomar el medicamento
	 * @return frecuency f
	 */
	public String getFrecuency() {
		return frecuency;
	}
	
	/**
	 * Cambia el valor de la frecuencia
	 * @param frecuency f
	 */
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}
}
