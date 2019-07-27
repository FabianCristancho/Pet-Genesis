package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.UtilityClass;

public class SQLUsers extends ConnectionMySQL {

	public boolean register(User user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO usuarios (id_usuario, id_persona, nombre_usuario, contrasenia_usuario) VALUES (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getIdPerson());
			ps.setInt(2, user.getIdPerson());
			ps.setString(3, user.getNameUser());
			ps.setString(4, user.getPassword());
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
		Connection con = getConnection();

		String sql = "SELECT count(id_usuario) FROM usuarios WHERE nombre_usuario = ?";
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

	public boolean updateUser(User user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE usuarios AS u INNER JOIN personas AS p ON u.id_persona=p.id_persona SET u.nombre_usuario=?, u.contrasenia_usuario=?, "
				+ "p.id_tipo_usuario=?, p.nombre_persona=?, p.apellido_persona=?, p.fecha_nacimiento=?, p.telefono_persona=?, p.estado_activacion=?, "
				+ "p.documento_identidad=?, p.correo_electronico=?, p.direccion_de_residencia=? WHERE id_usuario=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getNameUser());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getTypeUser().getIdTypeUser());
			ps.setString(4, user.getName());
			ps.setString(5, user.getLastName());
			ps.setString(6, UtilityClass.changeFormatToDate(user.getBirthDate()));
			ps.setString(7, user.getTelephone());
			ps.setString(8, "" + user.getActivationState().getIdState());
			ps.setString(9, user.getPersonalIdentification());
			ps.setString(10, user.getEmail());
			ps.setString(11, user.getAddress());
			ps.setInt(12, user.getIdPerson());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Object[]> loadData(String parameter, String value, String parameterState, String state) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ArrayList<Object[]> tableData = new ArrayList<>();

		String where = "";
		String and = "";
		if (!"".equals(value)) {
			where = " WHERE " + parameter + " = '" + value + "'";
		}

		if (!"".equals(state)) {
			and = " AND " + parameterState + " = '" + state + "'";
		}

		String sql = "SELECT u.id_usuario, u.nombre_usuario, p.nombre_persona, p.apellido_persona, p.fecha_nacimiento, p.telefono_persona, "
				+ "p.id_tipo_usuario, p.estado_activacion, p.documento_identidad, p.correo_electronico, p.direccion_de_residencia "
				+ "FROM usuarios AS u INNER JOIN personas AS p " + "ON u.id_persona=p.id_persona" + where + and;

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

	public User getDataUser(String parameter, String value, String parameterState, String state) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		User user = null;

		String where = "";
		String and = "";
		if (!"".equals(value)) {
			where = " WHERE " + parameter + " = '" + value + "'";
		}

		if (!"".equals(state)) {
			and = " AND " + parameterState + " = '" + state + "'";
		}

		String sql = "SELECT u.id_usuario, u.nombre_usuario, p.nombre_persona, p.apellido_persona, p.fecha_nacimiento, p.telefono_persona, "
				+ "p.id_tipo_usuario, p.estado_activacion, p.documento_identidad, p.correo_electronico, p.direccion_de_residencia "
				+ "FROM usuarios AS u INNER JOIN personas AS p " + "ON u.id_persona=p.id_persona" + where + and;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setIdPerson(rs.getInt(1));
				user.setNameUser(rs.getString(2));
				user.setName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setBirthDate(rs.getDate(5));
				user.setTelephone(rs.getString(6));
				user.setTypeUser(TypeUser.getTypeUser(rs.getInt(7)));
				user.setActivationState(ActivationState.getState(rs.getString(8).charAt(0) == 'A'));
				user.setPersonalIdentification(rs.getString(9));
				user.setEmail(rs.getString(10));
				user.setAddress(rs.getString(11));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		}
		return user;
	}

	public boolean login(User user) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT u.id_usuario, u.nombre_usuario, u.contrasenia_usuario, p.nombre_persona, p.apellido_persona, p.telefono_persona, p.documento_identidad, p.correo_electronico, p.direccion_de_residencia, t.id_tipo_usuario"
				+ " FROM usuarios AS u INNER JOIN personas AS p ON u.id_persona=p.id_persona INNER JOIN tipos_usuario AS t ON p.id_tipo_usuario=t.id_tipo_usuario WHERE u.nombre_usuario = ? AND p.estado_activacion = 'A'";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getNameUser());
			rs = ps.executeQuery();

			if (rs.next()) {
				if (user.getPassword().equals(rs.getString(3))) {

					String sqlUpdate = "UPDATE usuarios SET ultima_sesion = ? WHERE id_usuario= ?";

					ps = con.prepareStatement(sqlUpdate);
					ps.setString(1, user.getLastSession());
					ps.setInt(2, rs.getInt(1));
					ps.execute();

					user.setIdPerson(rs.getInt(1));
					user.setName(rs.getString(4));
					user.setLastName(rs.getString(5));
					user.setTelephone(rs.getString(6));
					user.setPersonalIdentification(rs.getString(7));
					user.setEmail(rs.getString(8));
					user.setAddress(rs.getString(9));
					user.setTypeUser(TypeUser.getTypeUser(rs.getInt(10)));
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
}
