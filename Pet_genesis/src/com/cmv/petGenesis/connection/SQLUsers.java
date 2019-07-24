package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cmv.petGenesis.model.User;

public class SQLUsers extends ConnectionMySQL{
	
	public boolean register(User user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO usuarios (id_persona, nombre_usuario, contrasenia_usuario) VALUES (?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getIdPerson());
			ps.setString(2, user.getNameUser());
			ps.setString(3, user.getPassword());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
