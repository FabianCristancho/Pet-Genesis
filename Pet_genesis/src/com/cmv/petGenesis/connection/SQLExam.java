package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.model.ExamECOP;
import com.cmv.petGenesis.model.ExamTPR;
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

		String sql = "INSERT INTO registros_examen (id_consulta, id_examen_tpr, id_examen_ecop, id_examen_cuerpo, diagnostico_examen) VALUES (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, registerExam.getConsult().getIdConsult());
			ps.setInt(2, registerExam.getExamTPR().getIdTpr());
			ps.setInt(3, registerExam.getExamECOP().getIdEcop());
			ps.setInt(4, registerExam.getExamBody().getIdExamBody());
			ps.setString(5, registerExam.getDiagnosticExam());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registerExamTPR(ExamTPR examTPR) {
		PreparedStatement ps = null;
		Connection con = getConnection();

		String sql = "INSERT INTO examenesTPR VALUES (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, examTPR.getIdTpr());
			ps.setString(2, examTPR.getTemperature());
			ps.setString(3, examTPR.getPression());
			ps.setString(4, examTPR.getfCardiac());
			ps.setString(5, examTPR.getfRespiratory());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registerExamECOP(ExamECOP examECOP) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "INSERT INTO examenesECOP VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, examECOP.getIdEcop());
			ps.setString(2, examECOP.getWeight());
			ps.setString(3, examECOP.getTemperament());
			ps.setString(4, examECOP.getAttitude());
			ps.setString(5, examECOP.getStool());
			ps.setString(6, examECOP.getApetitte());
			ps.setString(7, examECOP.getWater());
			ps.setString(8, examECOP.getDiet());
			ps.setString(9, examECOP.getNails());
			ps.setString(10, examECOP.getVomit());
			ps.setString(11, examECOP.getObservations());
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registerExamBody(ExamBody examBody) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "INSERT INTO examenes_cuerpo VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, examBody.getIdExamBody());
			ps.setString(2, examBody.getDientes());
			ps.setString(3, examBody.getMucosa());
			ps.setString(4, examBody.getLengua());
			ps.setString(5, examBody.getTonsillas());
			ps.setString(6, examBody.getFaringe());
			ps.setString(7, examBody.getLaringe());
			ps.setString(8, examBody.getOralAdd());
			ps.setString(9, examBody.getTrufa());
			ps.setString(10, examBody.getFlujoNasal());
			ps.setString(11, examBody.getRespiracion());
			ps.setString(12, examBody.getNarizAdd());
			ps.setString(13, examBody.getConjuntiva());
			ps.setString(14, examBody.getEsclerotica());
			ps.setString(15, examBody.getCornea());
			ps.setString(16, examBody.getIris());
			ps.setString(17, examBody.getCristalino());
			ps.setString(18, examBody.getParpados());
			ps.setString(19, examBody.getOjosAdd());
			ps.setString(20, examBody.getOreja());
			ps.setString(21, examBody.getCondAudExt());
			ps.setString(22, examBody.getTimpano());
			ps.setString(23, examBody.getOidosAdd());
			ps.setString(24, examBody.getTraquea());
			ps.setString(25, examBody.getSonidosPulmonares());
			ps.setString(26, examBody.getRuidosCardiacos());
			ps.setString(27, examBody.getToraxAdd());
			ps.setString(28, examBody.getEstomago());
			ps.setString(29, examBody.getIntestinos());
			ps.setString(30, examBody.getHigado());
			ps.setString(31, examBody.getBazo());
			ps.setString(32, examBody.getRiniones());
			ps.setString(33, examBody.getVejiga());
			ps.setString(34, examBody.getAbdomenAdd());
			ps.setString(35, examBody.getSubmaxilares());
			ps.setString(36, examBody.getPreescapulares());
			ps.setString(37, examBody.getPopliteos());
			ps.setString(38, examBody.getMesentericos());
			ps.setString(39, examBody.getGangliosAdd());
			ps.setString(40, examBody.getTesticulos());
			ps.setString(41, examBody.getPrepuecio());
			ps.setString(42, examBody.getProstata());
			ps.setString(43, examBody.getVulva());
			ps.setString(44, examBody.getVagina());
			ps.setString(45, examBody.getUtero());
			ps.setString(46, examBody.getGenitalesAdd());
			ps.setString(47, examBody.getTumoraciones());
			ps.setString(48, examBody.getHeridas());
			ps.setString(49, examBody.getParasitos());
			ps.setString(50, examBody.getPelaje());
			ps.setString(51, examBody.getgAnales());
			ps.setString(52, examBody.getgMamarias());
			ps.setString(53, examBody.getDeshidratacion());
			ps.setString(54, examBody.getTegumentoAdd());
			ps.setString(55, examBody.getClaudicacion());
			ps.setString(56, examBody.getArticulaciones());
			ps.setString(57, examBody.getHuesos());
			ps.setString(58, examBody.getTejidosBlandos());
			ps.setString(59, examBody.getExtremidadesAdd());
			ps.setString(60, examBody.getActitud());
			ps.setString(61, examBody.getReflejos());
			ps.setString(62, examBody.getCerebro());
			ps.setString(63, examBody.getMedulaEspinal());
			ps.setString(64, examBody.getSncAdd());
			ps.setString(65, examBody.getCondicionCorporal());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public int getLastTPR() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_examen_tpr) AS max_id FROM examenesTPR";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int getLastECOP() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_examen_ecop) AS max_id FROM examenesECOP";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int getLastBody() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String sql = "SELECT MAX(id_examen_cuerpo) AS max_id FROM examenes_cuerpo";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
