package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.utilities.ConstantView;

public class DataBaseCreation extends ConnectionMySQL{
	
	public boolean existDataBase() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection("");
		String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" +ConstantView.NAME_DATA_BASE + "'";
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
		return false;
	}
	
	public boolean createDataBase() {
		PreparedStatement ps = null;
		Connection con = getConnection("");
		String sql = "CREATE DATABASE " + ConstantView.NAME_DATA_BASE;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			createTables();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	private void createTables() {
		createTableEspecies();
		createTableRazas();
		createTableTiposMedicamento();
		createTableMedicamentos();
		createTableExamenes();
		createTableTiposUsuario();
		createTablePersonas();
		createTableUsuarios();
		createTableMascotas();
		createTableConsultas();
		createTableRecetas();
		createRegistrosExamen();
	}
	
	public void createTableEspecies() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE epecies ("
				+ "id_especie	INT(8)	NOT NULL,"
				+ "nombre_especie	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT esp_pk_idu PRIMARY KEY (id_especie)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableRazas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE razas ("
				+ "id_raza	INT(8)	NOT NULL,"
				+ "id_especie	INT(8)	NOT NULL,"
				+ "nombre_raza	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT raz_pk_idr PRIMARY KEY (id_raza)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableTiposMedicamento() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE tipos_medicamento ("
				+ "id_tipo_medicamento	INT(8)	NOT NULL,"
				+ "nombre_tipo_medicamento	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT tip_pk_idt PRIMARY KEY (id_tipo_medicamento)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableMedicamentos() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE medicamentos ("
				+ "id_medicamento	INT(8)	NOT NULL,"
				+ "id_tipo_medicamento	INT(8)	NOT NULL,"
				+ "nombre_medicamento	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT tip_pk_idt PRIMARY KEY (id_medicamento)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableExamenes() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE examenes ("
				+ "id_examen	INT(8)	NOT NULL,"
				+ "nombre_examen	VARCHAR(30)	NOT NULL,"
				+ "descripcion_examen	VARCHAR(30)	,"
				+ "CONSTRAINT exa_pk_ide PRIMARY KEY (id_examen)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableTiposUsuario() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE tipos_usuario ("
				+ "id_tipo_usuario	INT(8)	NOT NULL,"
				+ "nombre_tipo_usuario	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT tipu_pk_idtu PRIMARY KEY (id_tipo_usuario)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTablePersonas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE personas ("
				+ "id_persona	INT(8)	NOT NULL,"
				+ "id_tipo_usuario	INT(8)	,"
				+ "nombre_persona	VARCHAR(30)	NOT NULL,"
				+ "apellido_persona	VARCHAR(30)	NOT NULL,"
				+ "telefono_persona	VARCHAR(30)	NOT NULL,"
				+ "estado_activacion	INT(2)	NOT NULL,"
				+ "documento_identidad	VARCHAR(30)	,"
				+ "correo_electronico	VARCHAR(30)	,"
				+ "direccion_de_residencia	VARCHAR(30)	,"
				+ "tipo_persona	CHAR(1)	NOT NULL,"
				+ "CONSTRAINT per_pk_idp PRIMARY KEY (id_persona)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableUsuarios() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE usuarios ("
				+ "id_usuario	INT(8)	NOT NULL,"
				+ "id_persona	INT(8)	NOT NULL,"
				+ "nombre_usuario	VARCHAR(30)	NOT NULL,"
				+ "contrasenia_usuario	VARCHAR(30)	NOT NULL,"
				+ "CONSTRAINT usu_pk_idu PRIMARY KEY (id_usuario)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableMascotas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE mascotas ("
				+ "id_mascota	INT(8)	NOT NULL,"
				+ "id_persona	INT(8)	NOT NULL,"
				+ "nombre_mascota	VARCHAR(30)	NOT NULL,"
				+ "genero_mascota	CHAR(1)	NOT NULL,"
				+ "fecha_de_nacimiento	DATE	NOT NULL,"
				+ "peso_mascota	INT	NOT NULL,"
				+ "color_mascota	VARCHAR(30)	NOT NULL,"
				+ "castrada	INT(1)	NOT NULL,"
				+ "estado_de_activacion	INT(1)	NOT NULL,"
				+ "descripcion_adicional	VARCHAR(120)	,"
				+ "CONSTRAINT mas_pk_idm PRIMARY KEY (id_mascota)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableConsultas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE consultas ("
				+ "id_consulta	INT(8)	NOT NULL,"
				+ "id_mascota	INT(8)	NOT NULL,"
				+ "id_persona	INT(8)	NOT NULL,"
				+ "fecha_consulta	DATE	NOT NULL,"
				+ "motivo_consulta	VARCHAR(120)	NOT NULL,"
				+ "CONSTRAINT con_pk_idc PRIMARY KEY (id_consulta)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createTableRecetas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE recetas ("
				+ "id_receta	INT(8)	NOT NULL,"
				+ "id_medicamento	INT(8)	NOT NULL,"
				+ "id_consulta	INT(8)	NOT NULL,"
				+ "dosis	INT(5)	NOT NULL,"
				+ "frecuencia	VARCHAR(50)	NOT NULL,"
				+ "CONSTRAINT rec_pk_idr PRIMARY KEY (id_receta)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createRegistrosExamen() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE registros_examen ("
				+ "id_registro_examen	INT(8)	NOT NULL,"
				+ "id_consulta	INT(8)	NOT NULL,"
				+ "id_examen	INT(8)	NOT NULL,"
				+ "resultado_examen	VARCHAR(300)	NOT NULL,"
				+ "CONSTRAINT regexa_pk_idr PRIMARY KEY (id_registro_examen)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	public boolean createTableGuess() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE huespedes ("
				+"id_huesped	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+"nombre_huesped	VARCHAR(30)	NOT NULL,"
				+"apellido_huesped	VARCHAR(30)	NOT NULL,"
				+"telefono_huesped	VARCHAR(30)	NOT NULL,"
				+"CONSTRAINT hue_pk_idh PRIMARY KEY (id_huesped)"
				+");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
