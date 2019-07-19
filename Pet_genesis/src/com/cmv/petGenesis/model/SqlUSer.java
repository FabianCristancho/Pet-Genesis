package com.cmv.petGenesis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cmv.petGenesis.utilities.UtilityClass;

public class SqlUSer extends MyConnection {

	public boolean register(Usuario user) {
		PreparedStatement ps = null;
		Connection con = getconnection();

		String sql = "INSERT INTO usuarios (documento_usuario, nombre_usuario, apellido_usuario, fecha_nacimiento, telefono_usuario, email_usuario, direccion_residencia, tipo_usuario, estado_usuario, usuario, contrasenia) VALUES (?, ?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPersonalDocument());
			ps.setString(2, user.getName());
			ps.setString(3, user.getLastName());
			ps.setString(4, UtilityClass.changeFormatToDate(user.getBirthDate()));
			ps.setString(5, "" + user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getTypeUser().getIdTypeUser());
			ps.setString(9, user.getState());
			ps.setString(10, user.getUserName());
			ps.setString(11, user.getPassword());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Usuario user) {
		PreparedStatement ps = null;
		Connection con = getconnection();
		
		String sql = "UPDATE usuarios SET documento_usuario=?, nombre_usuario=?, apellido_usuario=?, fecha_nacimiento=?, telefono_usuario=?, email_usuario=?, direccion_residencia=?, tipo_usuario=?, estado_usuario=?, usuario=?, contrasenia=? WHERE id_usuario=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPersonalDocument());
			ps.setString(2, user.getName());
			ps.setString(3, user.getLastName());
			ps.setString(4, UtilityClass.changeFormatToDate(user.getBirthDate()));
			ps.setString(5, "" + user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getTypeUser().getIdTypeUser());
			ps.setString(9, user.getState());
			ps.setString(10, user.getUserName());
			ps.setString(11, user.getPassword());
			ps.setInt(12, user.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int existUser(String nameUser) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getconnection();

		String sql = "SELECT count(id_usuario) FROM usuarios WHERE usuario = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nameUser);

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

	public boolean login(Usuario user) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getconnection();

		String sql = "SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.usuario, u.contrasenia, u.tipo_usuario, t.nombre_tipo FROM usuarios AS u INNER JOIN tipos_usuario AS t ON u.tipo_usuario=t.id_tipo WHERE usuario = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			rs = ps.executeQuery();

			if (rs.next()) {
				if (user.getPassword().equals(rs.getString(5))) {

					String sqlUpdate = "UPDATE usuarios SET ultima_sesion = ? WHERE id_usuario= ?";

					ps = con.prepareStatement(sqlUpdate);
					ps.setString(1, user.getLastSession());
					ps.setInt(2, rs.getInt(1));
					ps.execute();

					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setTypeUser(TypeUser.getTypeUser(rs.getInt(6)));
					return true;
				} else {
					return false;
				}
			}

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Object[]> loadData(String parameter, String field) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getconnection();
		ArrayList<Object[]> tableData = new ArrayList<>();

		String where = "";
		if(!"".equals(field)) {
			where = " WHERE " +parameter +" = '" +field +"'";
		}
		String sql = "SELECT u.id_usuario, u.documento_usuario, u.nombre_usuario, u.apellido_usuario, u.fecha_nacimiento, u.telefono_usuario, u.email_usuario, u.direccion_residencia, t.nombre_tipo, u.estado_usuario, u.usuario, u.ultima_sesion FROM usuarios AS u INNER JOIN tipos_usuario AS t ON u.tipo_usuario=t.id_tipo" +where;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData rsMd = rs.getMetaData();
			int countCols = rsMd.getColumnCount();

			while (rs.next()) {
				Object[] rows = new Object[countCols];

				for (int i = 0; i < rows.length; i++) {
					rows[i] = rs.getObject(i + 1);
				}
				tableData.add(rows);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableData;
	}
	
	public ArrayList<Object[]> loadData2(String field) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getconnection();
		ArrayList<Object[]> tableData = new ArrayList<>();
		
		String where = "";
		if(!"".equals(field)) {
			where = "WHERE id_usuario = '" +field +"'";
		}
		String sql = "SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.fecha_nacimiento, u.telefono_usuario, u.email_usuario, u.direccion_residencia, t.nombre_tipo, u.estado_usuario, u.usuario, u.ultima_sesion FROM usuarios AS u INNER JOIN tipos_usuario AS t ON u.tipo_usuario=t.id_tipo" +where;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int countCols = rsMd.getColumnCount();
			
			while (rs.next()) {
				Object[] rows = new Object[countCols];
				
				for (int i = 0; i < rows.length; i++) {
					rows[i] = rs.getObject(i + 1);
				}
				tableData.add(rows);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableData;
	}

}
