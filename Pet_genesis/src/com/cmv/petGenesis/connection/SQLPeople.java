package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmv.petGenesis.model.Person;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.UtilityClass;

public class SQLPeople extends ConnectionMySQL{
	
	public int getLastIdPerson() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_persona) AS max_id FROM personas";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean registerDataUser(User user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO personas (id_tipo_usuario, nombre_persona, apellido_persona, telefono_persona, estado_activacion, "
				+ "documento_identidad, correo_electronico, direccion_de_residencia, tipo_persona, fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getTypeUser().getIdTypeUser());
			ps.setString(2, user.getName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getTelephone());
			ps.setString(5, ""+user.getActivationState().getIdState());
			ps.setString(6, user.getPersonalIdentification());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getAddress());
			ps.setString(9, "U");
			ps.setString(10, UtilityClass.changeFormatToDate(user.getBirthDate()));
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int existPhone(String phone) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT count(id_persona) FROM personas WHERE telefono_persona = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);

			rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int existDocumentId(int docId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		
		String sql = "SELECT count(id_persona) FROM personas WHERE documento_identidad = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, docId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
