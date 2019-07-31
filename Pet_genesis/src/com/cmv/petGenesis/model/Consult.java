package com.cmv.petGenesis.model;

import java.util.Date;

public class Consult {

	private int idConsult;
	private String motiveConsult;
	private Date dateConsult;
	private Pet pet;
	private Person person;

	public Consult() {
	}

	public Consult(int idConsult) {
		this.idConsult = idConsult;
	}

	public int getIdConsult() {
		return idConsult;
	}

	public void setIdConsult(int idConsult) {
		this.idConsult = idConsult;
	}

	public String getMotiveConsult() {
		return motiveConsult;
	}

	public void setMotiveConsult(String motiveConsult) {
		this.motiveConsult = motiveConsult;
	}

	public Date getDateConsult() {
		return dateConsult;
	}

	public void setDateConsult(Date dateConsult) {
		this.dateConsult = dateConsult;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
