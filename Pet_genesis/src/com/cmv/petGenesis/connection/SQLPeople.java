package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase SQLPeople - Se encaraga de crear la conexión con la tabla 'personas' en 
 * la base de datos, también realiza las consultas correspondientes para
 * añadir, modificar y consultar personas.
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class SQLPeople extends ConnectionMySQL{
	
	/**
	 * Obtiene el id de la ultima persona de la tabla de personas
	 * @return id v
	 */
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
	
	/**
	 * Registra los datos personales del usuario
	 * @param user usuario
	 * @return true si lo hizo -false si no
	 */
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
	
	/**
	 * Registra un cliente e la tabla de personas
	 * @param client cliente
	 * @return true si lo logró - false si se presentó un problema
	 */
	public boolean registerDataClient(Client client) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO personas (id_tipo_usuario, nombre_persona, apellido_persona, telefono_persona, estado_activacion, "
				+ "documento_identidad, correo_electronico, direccion_de_residencia, tipo_persona, fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.setString(2, client.getName());
			ps.setString(3, client.getLastName());
			ps.setString(4, client.getTelephone());
			ps.setString(5, ""+client.getActivationState().getIdState());
			ps.setString(6, client.getPersonalIdentification());
			ps.setString(7, client.getEmail());
			ps.setString(8, client.getAddress());
			ps.setString(9, "C");
			ps.setString(10, UtilityClass.changeFormatToDate(client.getBirthDate()));
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Verifica si un telefono existe
	 * @param phone telefono
	 * @return 1 si no existe y 0 si sí
	 */
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
	
	/**
	 * Verifica si un docuento de una persona ya fue registrado
	 * @param docId documento de identidad
	 * @return true si está - false si no
	 */
	public boolean existDocumentId(int docId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		
		String sql = "SELECT count(id_persona) FROM personas WHERE documento_identidad = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, docId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
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
	 * Obteien una lista con los dtos de las personas buscando por unos atributos y 
	 * condiciones especificas
	 * @param parameter atributo 1
	 * @param value valor atributo 1
	 * @param parameterState atributo 2
	 * @param state valor atributo 2
	 * @return lista de personas
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

		String sql = "SELECT p.id_persona, p.nombre_persona, p.apellido_persona, p.fecha_nacimiento, p.telefono_persona, "
				+ "p.estado_activacion, p.documento_identidad, p.correo_electronico, p.direccion_de_residencia, p.tipo_persona"
				+ ", p.id_persona FROM personas AS p" + where + and;

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
	 * Actualiza la información de un cliente
	 * @param client cliente
	 * @return true si actualizó -false si no
	 */
	public boolean updateClient(Client client) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE personas AS p SET p.nombre_persona=?, p.apellido_persona=?, p.fecha_nacimiento=?,"
				+ " p.telefono_persona=?, p.estado_activacion=?, "
				+ "p.documento_identidad=?, p.correo_electronico=?, p.direccion_de_residencia=? WHERE id_persona=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getLastName());
			ps.setString(3, UtilityClass.changeFormatToDate(client.getBirthDate()));
			ps.setString(4, client.getTelephone());
			ps.setString(5, ""+client.getActivationState().getIdState());
			ps.setString(6, client.getPersonalIdentification());
			ps.setString(7, client.getEmail());
			ps.setString(8, client.getAddress());
			ps.setInt(9, client.getIdPerson());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Cambia el estado de activación de un cliente por un parámetro específico
	 * @param parameter atributo
	 * @param valueParameter valor del atributo
	 * @param newState nuevo estado
	 * @return true si lo cambió - false si no
	 */
	public boolean changeStateClient(String parameter, String valueParameter, String newState) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE personas SET estado_activacion=? WHERE " + parameter + " = '" + valueParameter + "'";
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
	 * Verifica si un cliente existe buscando por su
	 * @param id identificador
	 * @return true si existe - false si no
	 */
	public boolean existClient(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT nombre_persona FROM personas WHERE id_persona=? AND tipo_persona='C'";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
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
	 * Verifica si un documento de identidad ya existe y si la persona es un cliente
	 * @param docId documento
	 * @return true si existe - false si no
	 */
	public boolean existDocumentIdClient(int docId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		
		String sql = "SELECT id_persona FROM personas WHERE documento_identidad = ? AND tipo_persona='C'";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, docId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
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
	 * Metodo que obtiene el id generado por el sistema de una persona, a partir de su documento de identificacion
	 * @return id generado de persona, en caso de ser valida
	 */
	public int getIdByPersonalId(int docId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		
		String sql = "SELECT id_persona FROM personas WHERE documento_identidad = ? AND tipo_persona='C'";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, docId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
			return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Obtiene el dato de cliente buscando por un atributo y valor específicos
	 * @param parameter atributo
	 * @param value valor del atributo
	 * @return client con los datos
	 */
	public Client getDataClient(String parameter, String value) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Client client = null;

		String where = "";
		String and = " p.tipo_persona='C'";
		if (!"".equals(value)) {
			where = " WHERE " + parameter + " = '" + value + "'";
		}

		String sql = "SELECT p.id_persona, p.nombre_persona, p.apellido_persona, p.fecha_nacimiento, p.telefono_persona, "
				+ "p.estado_activacion, p.documento_identidad, p.correo_electronico, p.direccion_de_residencia, p.tipo_persona "
				+ "FROM personas AS p" + where + " AND p.tipo_persona='C'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				client = new Client();
				client.setIdPerson(rs.getInt(1));
				client.setName(rs.getString(2));
				client.setLastName(rs.getString(3));
				client.setBirthDate(rs.getDate(4));
				client.setTelephone(rs.getString(5));
				client.setActivationState(ActivationState.getState(rs.getString(6).charAt(0) == 'A'));
				client.setPersonalIdentification(rs.getString(7));
				client.setEmail(rs.getString(8));
				client.setAddress(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return client;
		}
		return client;
	}
	
}
