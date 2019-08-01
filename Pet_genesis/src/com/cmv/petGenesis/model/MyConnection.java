package com.cmv.petGenesis.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cmv.petGenesis.utilities.ConstantView;

public class MyConnection {
	
	private final String base = ConstantView.NAME_DATA_BASE;
	private final String user = "root";
	private final String password = "123";
	private final String url = "jdbc:mysql://localhost:3306/" +base +"?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC"
			+ "&useSSL=false&useServerPrepStmts=true";
	private Connection con = null;
	
	public Connection getconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}