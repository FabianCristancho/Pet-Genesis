package com.cmv.petGenesis.model;

public class Client extends Person {
	
	/**
	 * Constructor Vacio
	 */
	public Client() {
		
	}
	
	public Client(int id, String name, String lastName, String telephone, ActivationState activationState,
			String personalIdentification, String email, String address, TypePerson typePerson) {
		super(id,null,name,lastName,telephone,activationState,personalIdentification,email,address,typePerson);
	}
	
}