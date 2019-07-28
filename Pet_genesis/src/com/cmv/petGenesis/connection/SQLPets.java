package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.UtilityClass;

public class SQLPets extends ConnectionMySQL{
	
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
	
	public Pet getDataPet(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Pet pet = null;


		String sql = "SELECT m.id_persona, m.id_raza, m.nombre_mascota, m.genero_mascota, m.fecha_de_nacimiento, "
				+ "m.color_mascota, m.castrada, m.estado_activacion, m.descripcion_adicional "
				+ "FROM mascotas AS m INNER JOIN personas AS p ON m.id_persona = p.id_persona "
				+ "INNER JOIN razas AS r ON m.id_raza = r.id_raza"
				+ "WHERE id_mascota=" + id;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				pet = new Pet();
				pet.setNamePet(rs.getString(3));
				pet.setGenderPet(GenderPet.values()[rs.getInt(4)]);
				pet.setBirthDate(rs.getDate(5));
				pet.setColorPet(rs.getString(6));
				pet.setCastrated(rs.getBoolean(7));
				pet.setStatePet(StatePet.getState(rs.getInt(8)));
				pet.setAditionalDescription(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pet;
		}
		return pet;
	}

}