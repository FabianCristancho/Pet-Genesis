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
			alterTables();
			createTypesUser();
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
	
	private void alterTables() {
		alterTableEspecies();
		alterTableRazas();
		alterTableTiposMedicamento();
		alterTableMedicamentos();
		alterTableExamenes();
		alterTableTiposUsuario();
		alterTablePersonas();
		alterTableUsuarios();
		alterTableMascotas();
		alterTableConsultas();
		alterTableRecetas();
		alterTableRegistrosExamen();
	}
	
	public void createTableEspecies() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "CREATE TABLE especies ("
				+ "id_especie	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_raza	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_tipo_medicamento	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_medicamento	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_examen	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_tipo_usuario	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_persona	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+ "id_tipo_usuario	INT(8),"
				+ "nombre_persona	VARCHAR(30)	NOT NULL,"
				+ "apellido_persona	VARCHAR(30)	NOT NULL,"
				+ "fecha_nacimiento DATE,"
				+ "telefono_persona	VARCHAR(30)	NOT NULL,"
				+ "estado_activacion	CHAR(1)	NOT NULL,"
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
				+ "contrasenia_usuario	VARCHAR(100)	NOT NULL,"
				+ "ultima_sesion DATETIME DEFAULT '0000-00-00 00:00:00',"
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
				+ "id_mascota	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+ "id_persona	INT(8)	NOT NULL,"
				+ "id_raza		INT(8)	NOT NULL,"
				+ "nombre_mascota	VARCHAR(30)	NOT NULL,"
				+ "genero_mascota	CHAR(1)	NOT NULL,"
				+ "fecha_de_nacimiento	DATE	NOT NULL,"
				+ "color_mascota	VARCHAR(30)	NOT NULL,"
				+ "castrada	INT(1)	NOT NULL,"
				+ "estado_de_activacion	CHAR(1)	NOT NULL,"
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
				+ "id_consulta	INT(8)	NOT NULL	AUTO_INCREMENT,"
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
				+ "id_receta	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+ "id_medicamento	INT(8)	NOT NULL,"
				+ "id_consulta	INT(8)	NOT NULL,"
				+ "dosis	VARCHAR(30)	NOT NULL,"
				+ "frecuencia	VARCHAR(50)	NOT NULL,"
				+ "CONSTRAINT rec_pk_idrmc PRIMARY KEY (id_receta, id_medicamento, id_consulta)"
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
				+ "id_registro_examen	INT(8)	NOT NULL	AUTO_INCREMENT,"
				+ "id_consulta	INT(8)	NOT NULL,"
				+ "id_examen	INT(8)	NOT NULL,"
				+ "resultado_examen	VARCHAR(500)	NOT NULL,"
				+ "diagnostico_examen VARCHAR(500) ,"
				+ "CONSTRAINT regexa_pk_idrec PRIMARY KEY (id_registro_examen, id_consulta, id_examen)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void alterTableEspecies() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE especies ADD ("
				+ "CONSTRAINT esp_uq_nom UNIQUE (nombre_especie)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableRazas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE razas ADD ("
				+ "CONSTRAINT raz_fk_ide FOREIGN KEY (id_especie) REFERENCES especies(id_especie)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableTiposMedicamento() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE tipos_medicamento ADD ("
				+ "CONSTRAINT tipmed_uq_nom UNIQUE (nombre_tipo_medicamento)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableMedicamentos() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE medicamentos ADD ("
				+ "CONSTRAINT med_fk_idt FOREIGN KEY (id_tipo_medicamento) REFERENCES tipos_medicamento(id_tipo_medicamento)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableExamenes() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE examenes ADD ("
				+ "CONSTRAINT exa_uq_nom UNIQUE (nombre_examen)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableTiposUsuario() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE tipos_usuario ADD ("
				+ "CONSTRAINT tipusu_uq_nom UNIQUE (nombre_tipo_usuario)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTablePersonas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE personas ADD ("
				+ "CONSTRAINT per_uq_tel UNIQUE (telefono_persona),"
				+ "CONSTRAINT per_ck_est CHECK (estado_activacion IN ('A'/*Activo*/, 'I'/*Inactivo*/)),"
				+ "CONSTRAINT per_uq_doc UNIQUE (documento_identidad),"
				+ "CONSTRAINT per_ck_tip CHECK (tipo_persona IN ('U'/*Usuario*/, 'C'/*Cliente*/)),"
				+ "CONSTRAINT per_fk_idt FOREIGN KEY (id_tipo_usuario) REFERENCES tipos_usuario(id_tipo_usuario)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableUsuarios() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE usuarios ADD ("
				+ "CONSTRAINT usu_uq_nom UNIQUE (nombre_usuario),"
				+ "CONSTRAINT usu_fk_idp FOREIGN KEY (id_persona) REFERENCES personas(id_persona)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableMascotas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE mascotas ADD ("
				+ "CONSTRAINT mas_ck_gen CHECK (genero_mascota IN ('M' /*Macho*/, 'H' /*Hembra*/)),"
				+ "CONSTRAINT mas_ck_pes CHECK (peso_mascota > 0),"
				+ "CONSTRAINT mas_ck_pes CHECK (castrada >=0),"
				+ "CONSTRAINT mas_ck_est CHECK (estado_de_activacion IN('A'/*Activo*, 'I'/*Inactivo*/)),"
				+ "CONSTRAINT mas_fk_idp FOREIGN KEY (id_persona) REFERENCES personas(id_persona),"
				+ "CONSTRAINT mas_fk_idr FOREIGN KEY (id_raza) REFERENCES razas(id_raza)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableConsultas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE consultas ADD ("
				+ "CONSTRAINT con_uq_fcidm UNIQUE (id_mascota, fecha_consulta),"
				+ "CONSTRAINT con_fk_idp FOREIGN KEY (id_persona) REFERENCES personas(id_persona),"
				+ "CONSTRAINT con_fk_idm FOREIGN KEY (id_mascota) REFERENCES mascotas(id_mascota)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableRecetas() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE recetas ADD ("
				+ "CONSTRAINT rec_fk_idm FOREIGN KEY (id_medicamento) REFERENCES medicamentos(id_medicamento),"
				+ "CONSTRAINT rec_fk_idc FOREIGN KEY (id_consulta) REFERENCES consultas(id_consulta)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void alterTableRegistrosExamen() {
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "ALTER TABLE registros_examen ADD ("
				+ "CONSTRAINT regexa_fk_idc FOREIGN KEY (id_consulta) REFERENCES consultas(id_consulta),"
				+ "CONSTRAINT regexa_fk_ide FOREIGN KEY (id_examen) REFERENCES examenes(id_examen)"
				+ ");";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void createTypesUser() {
		createTypeUser("GERENTE GENERAL");
		createTypeUser("MEDICO VETERINARIO");
		createTypeUser("ASISTENTE DE RECEPCION");
		createTypeUser("AUXILIAR VETERINARIO");
	}
	
	private void createTypeUser(String nameType) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "INSERT INTO tipos_usuario (nombre_tipo_usuario) VALUES (?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nameType);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
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
