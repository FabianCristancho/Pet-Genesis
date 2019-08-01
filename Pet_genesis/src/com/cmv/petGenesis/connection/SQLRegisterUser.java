package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase SQLRegisterUser, encargada de gestionar el registro de un usuario en la
 * base de datos
 * 
 * @author Fabian Cristrancho - Yohan Caro
 *
 */
public class SQLRegisterUser extends ConnectionMySQL {

	/**
	 * Registra un nuevo usuario en el sistema
	 * 
	 * @param user Nuevo usuario
	 * @return true si fue registrado con exito
	 */
	public boolean register(Usuario user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO usuarios (documento_usuario, nombre_usuario, apellido_usuario, fecha_nacimiento, telefono_usuario, "
				+ "email_usuario, direccion_residencia, tipo_usuario, estado_usuario, usuario, contrasenia) VALUES (?, ?,?,?,?,?,?,?,?,?,?)";
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

	/**
	 * Actualiza los datos de un usuario
	 * 
	 * @param user Objeto de usuario a actualizar
	 * @return
	 */
	public boolean update(Usuario user) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE usuarios SET documento_usuario=?, nombre_usuario=?, apellido_usuario=?, fecha_nacimiento=?, telefono_usuario=?, "
				+ "email_usuario=?, direccion_residencia=?, tipo_usuario=?, estado_usuario=?, usuario=?, contrasenia=? WHERE id_usuario=?";
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

	/**
	 * Cambia el estado de activacion de un usuario
	 * 
	 * @param parameter      Parametro de busqueda
	 * @param valueParameter Valor del parametro
	 * @param newState       Nuevo estado de usuario
	 * @return true si el estado se cambia
	 */
	public boolean changeStateUser(String parameter, String valueParameter, String newState) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE personas SET estado_usuario=? WHERE " + parameter + " = '" + valueParameter + "'";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newState);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Evalua si existe un usuario en el sistema
	 * 
	 * @param nameUser Nombre de usuario a buscar
	 * @return 1 si encuentra al usuario
	 */
	public int existUser(String nameUser) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

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

	/**
	 * Se encarga de realizar operaciones para el inicio de sesion, tales como fecha
	 * de ultima sesion del usuario que ingresa al sistema
	 * 
	 * @param user Objeto de usuario que ingresa
	 * @return true si ingresa con exito
	 */
	public boolean login(Usuario user) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.usuario, u.contrasenia, "
				+ "u.tipo_usuario, t.nombre_tipo FROM usuarios AS u INNER JOIN tipos_usuario AS t ON u.tipo_usuario=t.id_tipo WHERE usuario = ?";
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

	/**
	 * Carga un arraylist de tipo array object con el fin de almacenar los datos mas
	 * relevantes de los usaurios
	 * 
	 * @param parameter      Parametro de busqueda
	 * @param value          Valor buscado
	 * @param parameterState Estado del parametro
	 * @param state          Estado del usuario
	 * @return Lista con los usuarios obtenidos dependiendo de las condiciones dadas
	 */
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

		String sql = "SELECT u.id_usuario, u.documento_usuario, u.nombre_usuario, u.apellido_usuario, u.fecha_nacimiento, u.telefono_usuario, "
				+ "u.email_usuario, u.direccion_residencia, t.nombre_tipo, u.usuario, u.ultima_sesion FROM usuarios AS u INNER JOIN tipos_usuario AS t "
				+ "ON u.tipo_usuario=t.id_tipo" + where + and;

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

	/**
	 * Se encarga de listar a los usuarios a partir del valor de un unico campo
	 * 
	 * @param field campo de texto
	 * @return lista de usuario segun condiciones
	 */
	public ArrayList<Object[]> loadData2(String field) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ArrayList<Object[]> tableData = new ArrayList<>();

		String where = "";
		if (!"".equals(field)) {
			where = "WHERE id_usuario = '" + field + "'";
		}
		String sql = "SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.fecha_nacimiento, u.telefono_usuario, "
				+ "u.email_usuario, u.direccion_residencia, t.nombre_tipo, u.estado_usuario, u.usuario, u.ultima_sesion FROM usuarios AS u "
				+ "INNER JOIN tipos_usuario AS t ON u.tipo_usuario=t.id_tipo" + where;

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
