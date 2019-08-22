package com.cmv.petGenesis.model;

import java.util.Date;

/**
 * Clase Person - Clase que tien los datos que se van a requerir de todas las personas
 * Clientes y usuarios
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
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
	
	/**
	 * Constructor vacio
	 */
	public Person() {
	}
	
	/**
	 * Constructor con el id de la persona
	 * @param idPerson id
	 */
	public Person(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	/**
	 * Constructor con
	 * @param id identificaodr
	 * @param typeUser tipo (cargo)
	 * @param name nombre
	 * @param lastName apellido
	 * @param telephone telefono
	 * @param activationState estado de activacion
	 * @param personalIdentification documento de identidad
	 * @param email correo
	 * @param address dirección
	 * @param typePerson tipo
	 */
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

	/**
	 * Constructor que coge los adatos de una persona ya instanciada
	 * @param p person
	 */
	public Person(Person p) {
		this.idPerson = p.getIdPerson();
		this.typeUser = p.getTypeUser();
		this.name = p.getName();
		this.lastName = p.getLastName();
		this.telephone = p.getTelephone();
		this.activationState = p.getActivationState();
		this.personalIdentification = p.getPersonalIdentification();
		this.email = p.getEmail();
		this.address = p.getAddress();
		this.typePerson = p.getTypePerson();
	}

	/**
	 * Obteiene el id de la persona
	 * @return id p
	 */
	public int getIdPerson() {
		return idPerson;
	}
	
	/**
	 * Cambia el id
	 * @param id id
	 */
	public void setIdPerson(int id) {
		this.idPerson = id;
	}
	
	/**
	 * Obtiene el tipo de usuario
	 * @return typeuser t
	 */
	public TypeUser getTypeUser() {
		return typeUser;
	}
	
	/**
	 * Cambia el tipo de usuario
	 * @param typeUser t
	 */
	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	
	/**
	 * Obteien el nombre de la persona
	 * @return name nombre
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Cambia el nombre de la persona
	 * @param name nombre
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtiene le apellido de la persona
	 * @return apellido l
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Cambia el apellido de la persona
	 * @param lastName apellido
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Obtiene el telefono de la persona
	 * @return telephone t
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * Cambia el telefono de la persona
	 * @param telephone t
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Obteine el estado de activación de la persona
	 * @return activationState estado de activación
	 */
	public ActivationState getActivationState() {
		return activationState;
	}

	/**
	 * Cambia el estado de activación de la persona
	 * @param activationState estado de activación
	 */
	public void setActivationState(ActivationState activationState) {
		this.activationState = activationState;
	}

	/**
	 * Obtiene le documento de la persona
	 * @return personalIdentification doc
	 */
	public String getPersonalIdentification() {
		return personalIdentification;
	}
	
	/**
	 * Cambia el doc de la persona
	 * @param personalIdentification doc 
	 */
	public void setPersonalIdentification(String personalIdentification) {
		this.personalIdentification = personalIdentification;
	}
	
	/**
	 * Obtiene el email de la persona
	 * @return email correo
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Cambia el correo de la persona
	 * @param email correo
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Obtiene la dirección 
	 * @return addres dirección
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Cambia la dirección de la persona
	 * @param address direccion
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Obtiene el tipo de persona
	 * @return typePerson t
	 */
	public TypePerson getTypePerson() {
		return typePerson;
	}
	
	/**
	 * Cambia el tipo de persona
	 * @param typePerson t
	 */
	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}

	/**
	 * Obtiene la fecha de nacimiento
	 * @return birthDate fecha
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Cambia la fecha de nacimiento
	 * @param birthDate fecha
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
