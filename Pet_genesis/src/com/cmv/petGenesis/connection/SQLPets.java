package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.Specie;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase SQLPets - Se encaraga de crear la conexión con la tabla 'mascotas' en 
 * la base de datos, también realiza las consultas correspondientes para
 * añadir, modificar y consultar mascotas.
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class SQLPets extends ConnectionMySQL{
	
	/**
	 * Registra una mascota en la base de datos, la cual lleva por parametros
	 * @param pet mascota a añadir
	 * @return true si la agrego - false si no la pudo agregar
	 */
	public boolean registerPet(Pet pet) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO mascotas VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pet.getId());
			ps.setInt(2, pet.getClient().getIdPerson());
			ps.setInt(3, pet.getRace().getIdRace());
			ps.setString(4, pet.getNamePet());
			ps.setString(5, ""+pet.getGenderPet().getIdGender());
			ps.setString(6, UtilityClass.changeFormatToDate(pet.getBirthDate()));
			ps.setString(7, pet.getColorPet());
			ps.setInt(8, pet.isCastrated()?1:0);
			ps.setString(9, ""+pet.getStatePet().getNameState());
			ps.setString(10, pet.getAditionalDescription());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Obtiene el último id de la tabla de mascotas, para agregar a la siguiente
	 * @return valor de id o -1 si fi falló
	 */
	public int getLastIdPet() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_mascota) AS max_id FROM mascotas";
		
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
	 * Obtiene los valores de un combobox, por ejemplo: las razas y las especies
	 * @param atribute a seleccinar en la tabla
	 * @param table tabla a consultar
	 * @param order valor por el que se va aordenar la consulta
	 * @param valueSpecie id 
	 * @return array con los datos de una tabla
	 */
	public String[] getValuesComboBox(String atribute, String table, String order, String valueSpecie) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] values = null;
		Connection con = getConnection();
		String where = ""; 
		
		if(!"".equals(valueSpecie))
			where = " WHERE id_especie = '" +valueSpecie +"' ";
		
		String sql = "SELECT " +atribute +" FROM " +table +where +" ORDER BY " +order;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int numSpecies = countDataQuery(order, table, where);
			values = new String[numSpecies];
			for (int i = 0; i < values.length && rs.next(); i++) {
				values[i] = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return values;
		}
		return values;
	}
	
	/**
	 * Cuenta los datos de una tabla especifca por un parametro especifico (consulta)
	 * @param parameterCount atributo por el que se va acontar
	 * @param table tabla a consultar
	 * @param where condicion
	 * @return cantidad si encuentra
	 */
	private int countDataQuery(String parameterCount, String table, String where) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT count(" + parameterCount + ") FROM " + table +" " +where;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Obtiene los datos de una mascota buscando por su id
	 * @param id de la mascota a buscar
	 * @return pet mascota
	 */
	public Pet getDataPet(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Pet pet = null;
		SQLPeople sqlClient = new SQLPeople();

		String sql = "SELECT m.id_persona, m.id_raza, m.nombre_mascota, m.genero_mascota, m.fecha_de_nacimiento, "
				+ "m.color_mascota, m.castrada, m.estado_de_activacion, m.descripcion_adicional, m.id_mascota, "
				+ "r.id_especie, r.nombre_raza, e.nombre_especie "
				+ "FROM mascotas AS m INNER JOIN personas AS p ON m.id_persona = p.id_persona "
				+ "INNER JOIN razas AS r ON m.id_raza = r.id_raza "
				+ "INNER JOIN especies AS e ON r.id_especie = e.id_especie "
				+ "WHERE m.id_mascota = " + id;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				pet = new Pet();
				pet.setNamePet(rs.getString(3));
				pet.setGenderPet(GenderPet.getGender(rs.getString(4).equals("M")));
				pet.setBirthDate(rs.getDate(5));
				pet.setColorPet(rs.getString(6));
				pet.setCastrated(rs.getBoolean(7));
				pet.setStatePet(StatePet.getState(rs.getString(8).charAt(0)));
				pet.setAditionalDescription(rs.getString(9));
				pet.setSpecie(new Specie(rs.getInt(11), rs.getString(12)));
				pet.setRace(new Race(rs.getInt(2), rs.getString(13)));
				pet.setClient(sqlClient.getDataClient("id_persona","" + rs.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pet;
		}
		return pet;
	}
	
	/**
	 * Obtien el id de la raza buscando por su nombre
	 * @param race  nombre de laraza
	 * @return valor con el id
	 */
	public int getIdPetByRace(String race) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		int id = -1;

		String sql = "SELECT id_raza FROM razas "
				+ "WHERE nombre_raza = '" +race +"'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}
		return id;
	}
	
	/**
	 * Carga los datos de una tabla buscando por su estado de activacion
	 * y tambien puede por otra condicion
	 * @param value parametro
	 * @return lista con los datos de las mascotas
	 */
	public ArrayList<Object[]> loadDataPets(String parameter, String value) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ArrayList<Object[]> tableData = new ArrayList<>();
		
		String and = "";
		
		if(!"".equals(value))
			and = " AND " +parameter +" = '" +value +"'";

		String sql = "SELECT m.id_mascota, m.nombre_mascota, m.genero_mascota, e.nombre_especie, r.nombre_raza, m.fecha_de_nacimiento, "
				+ "m.color_mascota, m.castrada, p.id_persona, p.documento_identidad, p.nombre_persona, p.apellido_persona "
				+ "FROM mascotas AS m "
				+ "INNER JOIN personas AS p ON m.id_persona = p.id_persona "
				+ "INNER JOIN razas AS r ON m.id_raza = r.id_raza "
				+ "INNER JOIN especies AS e ON r.id_especie = e.id_especie "
				+ "WHERE estado_de_activacion = 'A'" + and;

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
	 * Actualiza los datos de una mascota
	 * @param pet datos a actualizar
	 * @return true si pudo agregar - false si no
	 */
	public boolean updatePet(Pet pet) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE mascotas AS m SET m.id_raza=?, m.nombre_mascota=?, m.genero_mascota=?, "
				+ "m.fecha_de_nacimiento=?, m.color_mascota=?, m.castrada=?, m.estado_de_activacion=?"
				+ ", m.descripcion_adicional=? WHERE id_mascota=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pet.getRace().getIdRace());
			ps.setString(2, pet.getNamePet());
			ps.setString(3, ""+pet.getGenderPet().getIdGender());
			ps.setString(4, UtilityClass.changeFormatToDate(pet.getBirthDate()));
			ps.setString(5, pet.getColorPet());
			ps.setInt(6, pet.isCastrated()?1:0);
			ps.setString(7, ""+pet.getStatePet().getNameState());
			ps.setString(8, pet.getAditionalDescription());
			ps.setInt(9, pet.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Verifica si una mascota existe por
	 * @param id su id
	 * @return true si existe - false si no
	 */
	public boolean existPet(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT nombre_mascota FROM mascotas WHERE id_mascota=?";
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
	 * Cambia el estado de activación de una mascota
	 * @param parameter parametro a buscar
	 * @param valueParameter valor del parametro
	 * @param newState nuevo estado de activacion
	 * @return true si lo lorgó - false si no
	 */
	public boolean changeStatePet(String parameter, String valueParameter, String newState) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "UPDATE mascotas SET estado_de_activacion=? WHERE " + parameter + " = '" + valueParameter + "'";
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
	 * Carga una lista de mascotas buscando por un atributo y valor especifico
	 * @param parameter atributo
	 * @param value valor del atributo
	 * @return lista con las mascotas
	 */
	public ArrayList<Object[]> loadData(String parameter, String value) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ArrayList<Object[]> tableData = new ArrayList<>();

		String where = "";
		if (!"".equals(value)) {
			where = " WHERE " + parameter + " = '" + value + "'";
		}

		String sql = "SELECT m.id_mascota, m.nombre_mascota, m.genero_mascota, e.nombre_especie, r.nombre_raza,"
				+ " m.fecha_de_nacimiento, m.color_mascota, m.castrada, m.estado_de_activacion, "
				+ "p.nombre_persona, p.apellido_persona "
				+ "FROM mascotas AS m "
				+ "INNER JOIN personas AS p ON m.id_persona = p.id_persona "
				+ "INNER JOIN razas AS r ON m.id_raza = r.id_raza "
				+ "INNER JOIN especies AS e ON r.id_especie = e.id_especie " + where;

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
