package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.RegisterExam;

/**
 * Clase SQLExam, se encarga de las operaciones realizadas en las tablas de
 * examenes y registros_examen
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class SQLExam extends ConnectionMySQL {

	/**
	 * Se encarga de almacenar un nuevo registro de examen realizado durante una
	 * consulta
	 * 
	 * @param registerExam Objeto de tipo RegisterExam
	 * @return
	 */
	public boolean registerExam(RegisterExam registerExam) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO registros_examen (id_consulta, id_examen, resultado_examen, diagnostico_examen) VALUES (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, registerExam.getConsult().getIdConsult());
			ps.setInt(2, registerExam.getExam().getIdExam());
			ps.setString(3, registerExam.getResultExam());
			ps.setString(4, registerExam.getDiagnosticExam());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
