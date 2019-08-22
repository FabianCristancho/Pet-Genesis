package com.cmv.petGenesis.model;

/**
 * Clase Client - Datos del cliente (Son los mismoa que los de la persona)
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Client extends Person {
	
	/**
	 * Constructor Vacio
	 */
	public Client() {
		
	}
	
	public Client(String name, String lastName) {
		super(name, lastName);
	}
	
	/**
	 * Crea un cliente por el id
	 * Constructor 
	 * @param idPerson
	 */
	public Client(int idPerson) {
		super(idPerson);
	}
	
	/**
	 * Constructor 
	 * @param id idetificador
	 * @param name nombre 
	 * @param lastName apellido
	 * @param telephone telefono
	 * @param activationState estado de activacion
	 * @param personalIdentification documento de identidad
	 * @param email correo elecronico
	 * @param address dirección (Enrique Segoviano)
	 * @param typePerson tipo de persona ('C'-cliente / 'U'-usuario)
	 */
	public Client(int id, String name, String lastName, String telephone, ActivationState activationState,
			String personalIdentification, String email, String address, TypePerson typePerson) {
		super(id,null,name,lastName,telephone,activationState,personalIdentification,email,address,typePerson);
	}
	
}