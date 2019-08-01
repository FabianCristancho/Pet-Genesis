package testDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase de prueba MyConnection, encargada de conectar la aplicacion a la base
 * de datos
 * 
 * @author usuario
 *
 */
public class MyConnection {

	public Connection connection;
	public Statement sentence;
	public ResultSet result;

	/**
	 * Se conecta a la bd
	 * 
	 * @param bd
	 */
	public void connectWithBD(String bd) {
		try {
			String controller = "com.mysql.cj.jdbc.Driver";
			Class.forName(controller);
			String urlBD = "jdbc:mysql://localhost:3306/?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String urlBD2 = "jdbc:mysql://localhost:3306/" + bd
					+ "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			if (bd.equals("")) {
				connection = DriverManager.getConnection(urlBD, "root", "123");
			} else {
				connection = DriverManager.getConnection(urlBD2, "root", "123");
			}
			sentence = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se desconecta de la base de datos
	 */
	public void disconnectedBD() {
		try {
			if (connection != null) {
				if (sentence != null) {
					sentence.close();
				}
				connection.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Obtiene una conexion a la base de datos
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
}
