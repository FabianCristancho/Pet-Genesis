package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.Consult;
import com.cmv.petGenesis.utilities.UtilityClass;

public class SQLConsult extends ConnectionMySQL{
	
	public boolean registerConsult(Consult consult) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO consultas (id_mascota, id_persona, fecha_consulta, motivo_consulta) VALUES (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, consult.getPet().getId());
			ps.setInt(2, consult.getPerson().getIdPerson());
			ps.setString(3, UtilityClass.changeFormatToDate(consult.getDateConsult()));
			ps.setString(4, consult.getMotiveConsult());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public int getLastIdConsult() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_consulta) AS max_id FROM consultas";
		
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

}
