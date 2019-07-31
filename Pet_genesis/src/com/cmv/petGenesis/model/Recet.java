package com.cmv.petGenesis.model;

public class Recet {
	
	private int idRecet;
	private Medicament medicament;
	private Consult consult;
	private String dosis;
	private String frecuency;
	
	public int getIdRecet() {
		return idRecet;
	}
	
	public void setIdRecet(int idRecet) {
		this.idRecet = idRecet;
	}
	
	public Medicament getMedicament() {
		return medicament;
	}
	
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public Consult getConsult() {
		return consult;
	}
	
	public void setConsult(Consult consult) {
		this.consult = consult;
	}
	
	public String getDosis() {
		return dosis;
	}
	
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	
	public String getFrecuency() {
		return frecuency;
	}
	
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}
}
