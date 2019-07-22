package testDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLDataBase extends MyConnection {

	public boolean existDataBase(String nameDataBase) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		connectWithBD("");
		Connection con = getConnection();
		String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + nameDataBase + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean createDataBase(String nameDataBase) {
		PreparedStatement ps = null;
		connectWithBD("");
		Connection con = getConnection();
		String sql = "CREATE DATABASE " + nameDataBase;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createTableGuess() {
		PreparedStatement ps = null;
		connectWithBD("Residencia");
		Connection con = getConnection();
		String sql = "CREATE TABLE huespedes ("
				+"id_huesped	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+"nombre_huesped	VARCHAR(30)	NOT NULL,"
				+"apellido_huesped	VARCHAR(30)	NOT NULL,"
				+"telefono_huesped	VARCHAR(30)	NOT NULL,"
				+"CONSTRAINT hue_pk_idh PRIMARY KEY (id_huesped)"
				+");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
