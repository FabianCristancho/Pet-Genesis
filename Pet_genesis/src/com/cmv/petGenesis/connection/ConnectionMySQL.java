package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.utilities.ConstantView;

public class ConnectionMySQL {
	
	private String dataBase = ConstantView.NAME_DATA_BASE;
	private final String user = ConstantView.USER_DATA_BASE;
	private final String password = ConstantView.PSWD_DATA_BASE;
	private String url;
	private Connection con;
	
	public Connection getConnection(String base) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/" +base +"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return con;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/" +dataBase +"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return con;
	}
}
