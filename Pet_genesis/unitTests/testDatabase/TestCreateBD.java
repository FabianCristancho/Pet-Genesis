package testDatabase;

import java.sql.SQLException;

public class TestCreateBD {

	public static void main(String[] args) {
		MyConnection myConnection = new MyConnection();
		try {
			myConnection.connectWithBD("");
			myConnection.sentence.execute("CREATE DATABASE Residencia");
			System.out.println("BASE DE DATOS CREADA CON EXITO");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
