package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmv.petGenesis.model.Person;
import com.cmv.petGenesis.model.User;

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
	
	public boolean register(Person person) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO personas (id_tipo_usuario, nombre_persona, apellido_persona, telefono_persona, estado_activacion, "
				+ "documento_identidad, correo_electronico, direccion_de_residencia, tipo_persona) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, person.getTypeUser().getIdTypeUser());
			ps.setString(2, person.getName());
			ps.setString(3, person.getLastName());
			ps.setString(4, person.getTelephone());
			ps.setString(5, ""+person.getActivationState().getIdState());
			ps.setString(6, person.getPersonalIdentification());
			ps.setString(7, person.getEmail());
			ps.setString(8, person.getAddress());
			ps.setString(9, "U");
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
