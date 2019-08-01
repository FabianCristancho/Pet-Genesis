package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.Recet;

/**
 * Clase SQLRecet - Se encaraga de crear la conexión con la tabla 'recetas' en
 * la base de datos, y agregar una nueva receta
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class SQLRecet extends ConnectionMySQL {

	/**
	 * Se encarga de agregar una nueva receta en la base de datos
	 * 
	 * @param recet Nueva receta
	 * @return true si la receta fue agregada exitosamente
	 */
	public boolean registerRecet(Recet recet) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO recetas (id_medicamento, id_consulta, dosis, frecuencia) VALUES (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, recet.getMedicament().getIdMedicament());
			ps.setInt(2, recet.getConsult().getIdConsult());
			ps.setString(3, recet.getDosis());
			ps.setString(4, recet.getFrecuency());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
