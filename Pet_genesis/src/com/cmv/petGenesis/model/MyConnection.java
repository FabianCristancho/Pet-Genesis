package com.cmv.petGenesis.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	private final String base = "usuarios";
	private final String user = "root";
	private final String password = "123";
	private final String url = "jdbc:mysql://localhost:3306/" +base +"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private Connection con = null;
	
	public Connection getconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
