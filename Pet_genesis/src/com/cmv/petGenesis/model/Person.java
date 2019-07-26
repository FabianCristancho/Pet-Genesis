package com.cmv.petGenesis.model;

import java.util.Date;

public class Person {
	
	private int idPerson;
	private TypeUser typeUser;
	private String name;
	private String lastName;
	private String telephone;
	private Date birthDate;
	private ActivationState activationState;
	private String personalIdentification;
	private String email;
	private String address;
	private TypePerson typePerson;
	
	public Person() {
	}

	public Person(int id, TypeUser typeUser, String name, String lastName, String telephone, ActivationState activationState,
			String personalIdentification, String email, String address, TypePerson typePerson) {
		this.idPerson = id;
		this.typeUser = typeUser;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.activationState = activationState;
		this.personalIdentification = personalIdentification;
		this.email = email;
		this.address = address;
		this.typePerson = typePerson;
	}

	public int getIdPerson() {
		return idPerson;
	}
	
	public void setIdPerson(int id) {
		this.idPerson = id;
	}
	
	public TypeUser getTypeUser() {
		return typeUser;
	}
	
	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public ActivationState getActivationState() {
		return activationState;
	}

	public void setActivationState(ActivationState activationState) {
		this.activationState = activationState;
	}

	public String getPersonalIdentification() {
		return personalIdentification;
	}
	
	public void setPersonalIdentification(String personalIdentification) {
		this.personalIdentification = personalIdentification;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public TypePerson getTypePerson() {
		return typePerson;
	}
	
	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
