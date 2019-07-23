package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.utilities.ConstantView;

public class DataBaseCreation extends ConnectionMySQL{
	
	public boolean existDataBase() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection("");
		String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" +ConstantView.NAME_DATA_BASE + "'";
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
		return false;
	}
	
	public boolean createDataBase() {
		PreparedStatement ps = null;
		Connection con = getConnection("");
		String sql = "CREATE DATABASE " + ConstantView.NAME_DATA_BASE;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public boolean createTableGuess() {
		PreparedStatement ps = null;
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
