package com.cmv.petGenesis.model;


public class User extends Person{
	
	private String nameUser;
	private String password;
	private String lastSession;
	
	public User() {
	}
	
	public User(Person p) {
		super(p);
	}

	public User(String nameUser, String password, String lastSession) {
		this.nameUser = nameUser;
		this.password = password;
		this.lastSession = lastSession;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastSession() {
		return lastSession;
	}
	
	public void setLastSession(String lastSession) {
		this.lastSession = lastSession;
	}
	
	
}