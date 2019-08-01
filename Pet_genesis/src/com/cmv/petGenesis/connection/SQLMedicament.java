package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.Medicament;

/**
 * Clase SQLExam, se encarga de las operaciones realizadas en la tabla
 * medicamentos
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class SQLMedicament extends ConnectionMySQL {

	/**
	 * Registra un medicamento en la base de datos
	 * 
	 * @param medicament Objeto de tipo Medicament
	 * @return true si la operacion fue correcta
	 */
	public boolean createMedicament(Medicament medicament) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO medicamentos (id_tipo_medicamento, nombre_medicamento) VALUES (?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, medicament.getTypeMedicament().getIdTypeMed());
			ps.setString(2, medicament.getNameMedicament());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene un arreglo con los nombres de tipos de medicamentos almacenados en la
	 * tabla tipos_medicamento
	 * 
	 * @return Arreglo con tipos
	 */
	public String[] getTypeMedicaments() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] values = null;
		Connection con = getConnection();

		String sql = "SELECT nombre_tipo_medicamento FROM tipos_medicamento";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int numSpecies = countTypesMedicaments();
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
	 * Obtiene un arreglo con los medicamentos alamacenados en la tabla medicamentos
	 * 
	 * @return Arreglo de medicamentos
	 */
	public String[] getMedicaments() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] values = null;
		Connection con = getConnection();

		String sql = "SELECT nombre_medicamento FROM medicamentos";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int numSpecies = countMedicaments();
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
	 * Se encarga de contar el numero de medicamentos almacenados actualmente en la
	 * base de datos
	 * 
	 * @return numero de medicamentos almacenados
	 */
	private int countMedicaments() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT count(id_medicamento) FROM medicamentos";

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
	 * Se encarga de contar los tipos de medicamentos almacenados en la base de
	 * datos
	 * 
	 * @return Cantidad de tipos de medicamentos almacenados
	 */
	private int countTypesMedicaments() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT count(id_tipo_medicamento) FROM tipos_medicamento";

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

}
