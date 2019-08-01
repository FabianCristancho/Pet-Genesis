package com.cmv.petGenesis.model;

/**
 * Clase User - Se encarga del manejo de los datos de usuario
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class User extends Person{
	
	private String nameUser;
	private String password;
	private String lastSession;
	
	/**
	 * Constructor vacio
	 */
	public User() {
	}
	
	/**
	 * Constructor con una
	 * @param p persona
	 */
	public User(Person p) {
		super(p);
	}

	/**
	 * Constructor con:
	 * @param nameUser nombre de usuario
	 * @param password contraseña
	 * @param lastSession ultima conexión
	 */
	public User(String nameUser, String password, String lastSession) {
		this.nameUser = nameUser;
		this.password = password;
		this.lastSession = lastSession;
	}

	/**
	 * Obtien el nombre de usuario
	 * @return nameUser nombre
	 */
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * Cambia el nombre de usuario
	 * @param nameUser nombre
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * Obtiene la contraseña
	 * @return password p
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Cambia la password p
	 * @param password p
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene la ultima sesión
	 * @return lastSession s
	 */
	public String getLastSession() {
		return lastSession;
	}
	
	/**
	 * Cambia la ultima sesión
	 * @param lastSession s
	 */
	public void setLastSession(String lastSession) {
		this.lastSession = lastSession;
	}
	
}