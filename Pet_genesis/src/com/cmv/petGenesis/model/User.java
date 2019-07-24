package com.cmv.petGenesis.model;

public class User extends Person{
	
	private String nameUser;
	private String password;
	
	public User() {
	}

	public User(String nameUser, String password) {
		this.nameUser = nameUser;
		this.password = password;
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
}