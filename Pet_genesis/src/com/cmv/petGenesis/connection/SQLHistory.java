package com.cmv.petGenesis.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.Consult;
import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.model.ExamECOP;
import com.cmv.petGenesis.model.ExamTPR;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Person;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.RegisterExam;
import com.cmv.petGenesis.model.Specie;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.utilities.UtilityClass;

public class SQLHistory extends ConnectionMySQL {

	public Pet getBasicData(int idPet) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Pet pet = null;

		String sql = "SELECT m.id_mascota, m.id_persona, r.id_raza, r.nombre_raza, e.id_especie, e.nombre_especie, m.nombre_mascota, m.genero_mascota, m.fecha_de_nacimiento, "
				+ "m.color_mascota, m.castrada, m.estado_de_activacion, m.descripcion_adicional "
				+ "FROM mascotas AS m INNER JOIN razas AS r ON m.id_raza = r.id_raza "
				+ "INNER JOIN especies AS e ON r.id_especie = e.id_especie " + "WHERE m.id_mascota = " + idPet;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				pet = new Pet();
				pet.setId(rs.getInt(1));
				pet.setClient(new Client(rs.getInt(2)));
				pet.setRace(new Race(rs.getInt(3), rs.getString(4)));
				pet.setSpecie(new Specie(rs.getInt(5), rs.getString(6)));
				pet.setNamePet(rs.getString(7));
				pet.setGenderPet(GenderPet.getGender(rs.getString(8).equals("M")));
				pet.setBirthDate(UtilityClass.daysAdd(rs.getDate(9), 1));
				pet.setColorPet(rs.getString(10));
				pet.setCastrated(rs.getBoolean(11));
				pet.setStatePet(StatePet.getState(rs.getString(12).charAt(0)));
				pet.setAditionalDescription(rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return pet;
		}
		return pet;
	}

	public Client getDataClient(int idClient) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Client client = null;

		String sql = "SELECT nombre_persona, apellido_persona " + "FROM personas " + "WHERE id_persona = " + idClient;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				client = new Client(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	public String[] getConsultsPet(int idPet) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] values = null;
		Connection con = getConnection();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = "";
		Date oldDate = null;
		String sql = "SELECT fecha_consulta FROM consultas " + "WHERE id_mascota = " + idPet;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int numSpecies = countConsults(idPet);
			values = new String[numSpecies];
			for (int i = 0; i < values.length && rs.next(); i++) {
				oldDate = UtilityClass.daysAdd(rs.getDate(1), 1);
				date = simpleDateFormat.format(oldDate);
				values[i] = date;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return values;
		}
		return values;
	}

	private int countConsults(int idPet) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();

		String sql = "SELECT count(id_mascota) FROM consultas " + "WHERE id_mascota = " + idPet;

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

	public Consult getDataConsult(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		Consult consult = null;

		String sql = "SELECT c.id_consulta, c.motivo_consulta, p.nombre_persona, p.apellido_persona "
				+ "FROM consultas AS c INNER JOIN personas AS p ON c.id_persona = p.id_persona "
				+ "WHERE c.id_mascota = " + idPet + " " + "AND c.fecha_consulta = '" + date + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				consult = new Consult();
				consult.setIdConsult(rs.getInt(1));
				consult.setMotiveConsult(rs.getString(2));
				consult.setPerson(new Person(rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return consult;
		}
		return consult;
	}

	public ExamTPR getDataTPR(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ExamTPR examTPR = null;

		String sql = "SELECT e.temperatura, e.presion, e.frecuencia_cardiaca, e.frecuencia_respiratoria "
				+ "FROM examenestpr AS e INNER JOIN registros_examen AS r ON e.id_examen_tpr = r.id_examen_tpr "
				+ "INNER JOIN consultas AS c ON r.id_consulta = c.id_consulta " + "WHERE c.id_mascota = " + idPet + " "
				+ "AND c.fecha_consulta = '" + date + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				examTPR = new ExamTPR();
				examTPR.setTemperature(rs.getString(1));
				examTPR.setPression(rs.getString(2));
				examTPR.setfCardiac(rs.getString(3));
				examTPR.setfRespiratory(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return examTPR;
		}
		return examTPR;
	}

	public ExamECOP getDataECOP(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ExamECOP examECOP = null;

		String sql = "SELECT e.peso, e.temperamento, e.actitud, e.heces, e.apetito, e.consumo_agua, e.dieta, e.unias, e.vomito, e.observaciones "
				+ "FROM examenesecop AS e INNER JOIN registros_examen AS r ON e.id_examen_ecop = r.id_examen_ecop "
				+ "INNER JOIN consultas AS c ON r.id_consulta = c.id_consulta " + "WHERE c.id_mascota = " + idPet + " "
				+ "AND c.fecha_consulta = '" + date + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				examECOP = new ExamECOP();
				examECOP.setWeight(rs.getString(1));
				examECOP.setTemperament(rs.getString(2));
				examECOP.setAttitude(rs.getString(3));
				examECOP.setStool(rs.getString(4));
				examECOP.setApetitte(rs.getString(5));
				examECOP.setWater(rs.getString(6));
				examECOP.setDiet(rs.getString(7));
				examECOP.setNails(rs.getString(8));
				examECOP.setVomit(rs.getString(9));
				examECOP.setObservations(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return examECOP;
		}
		return examECOP;
	}

	public ExamBody getDataBody(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ExamBody examBody = null;

		String sql = "SELECT e.dientes, e.mucosa, e.lengua, e.tonsilas, e.faringe, e.laringe, e.oral_adicional, "
				+ "e.trufa, e.flujo_nasal, e.respiracion, e.nariz_adicional, e.conjuntiva, e.esclerotica, e.cornea, "
				+ "e.iris, e.cristalino, e.parpados, e.ojos_adicional, e.oreja, e.cond_aud_ext, e.timpano, "
				+ "e.oidos_adicional, e.traquea, e.sonidos_pulmonares, e.ruidos_cardiacos, e.torax_adicional, "
				+ "e.estomago, e.intestinos, e.higado, e.bazo, e.riniones, e.vejiga, e.abdomen_adicional, "
				+ "e.submaxilares, e.preescapulares, e.popliteos, e.mesentericos, e.ganglios_adicional, "
				+ "e.testiculos, e.prepucio, e.prostata, e.vulva, e.vagina, e.utero, e.genitales_adicional, "
				+ "e.tumoraciones, e.heridas, e.parasitos, e.pelaje, e.glandulas_anales, e.glandulas_mamarias, "
				+ "e.deshidratacion, e.tegumento_adicional, e.claudicacion, e.articulaciones, e.huesos, "
				+ "e.tejidos_blandos, e.extremidades_adicional, e.actitud_snc, e.reflejos, e.cerebro, e.medula_espinal, "
				+ "e.snc_adicional "
				+ "FROM examenes_cuerpo AS e INNER JOIN registros_examen AS r ON e.id_examen_cuerpo = r.id_examen_cuerpo "
				+ "INNER JOIN consultas AS c ON r.id_consulta = c.id_consulta " + "WHERE c.id_mascota = " + idPet + " "
				+ "AND c.fecha_consulta = '" + date + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				examBody = new ExamBody();

				examBody.setDientes(rs.getString(1));
				examBody.setMucosa(rs.getString(2));
				examBody.setLengua(rs.getString(3));
				examBody.setTonsillas(rs.getString(4));
				examBody.setFaringe(rs.getString(5));
				examBody.setLaringe(rs.getString(6));
				examBody.setOralAdd(rs.getString(7));
				examBody.setTrufa(rs.getString(8));
				examBody.setFlujoNasal(rs.getString(9));
				examBody.setRespiracion(rs.getString(10));
				examBody.setNarizAdd(rs.getString(11));
				examBody.setConjuntiva(rs.getString(12));
				examBody.setEsclerotica(rs.getString(13));
				examBody.setCornea(rs.getString(14));
				examBody.setIris(rs.getString(15));
				examBody.setCristalino(rs.getString(16));
				examBody.setParpados(rs.getString(17));
				examBody.setOjosAdd(rs.getString(18));
				examBody.setOreja(rs.getString(19));
				examBody.setCondAudExt(rs.getString(20));
				examBody.setTimpano(rs.getString(21));
				examBody.setOidosAdd(rs.getString(22));
				examBody.setTraquea(rs.getString(23));
				examBody.setSonidosPulmonares(rs.getString(24));
				examBody.setRuidosCardiacos(rs.getString(25));
				examBody.setToraxAdd(rs.getString(26));
				examBody.setEstomago(rs.getString(27));
				examBody.setIntestinos(rs.getString(28));
				examBody.setHigado(rs.getString(29));
				examBody.setBazo(rs.getString(30));
				examBody.setRiniones(rs.getString(31));
				examBody.setVejiga(rs.getString(32));
				examBody.setAbdomenAdd(rs.getString(33));
				examBody.setSubmaxilares(rs.getString(34));
				examBody.setPreescapulares(rs.getString(35));
				examBody.setPopliteos(rs.getString(36));
				examBody.setMesentericos(rs.getString(37));
				examBody.setGangliosAdd(rs.getString(38));
				examBody.setTesticulos(rs.getString(39));
				examBody.setPrepuecio(rs.getString(40));
				examBody.setProstata(rs.getString(41));
				examBody.setVulva(rs.getString(42));
				examBody.setVagina(rs.getString(43));
				examBody.setUtero(rs.getString(44));
				examBody.setGenitalesAdd(rs.getString(45));
				examBody.setTumoraciones(rs.getString(46));
				examBody.setHeridas(rs.getString(47));
				examBody.setParasitos(rs.getString(48));
				examBody.setPelaje(rs.getString(49));
				examBody.setgAnales(rs.getString(50));
				examBody.setgMamarias(rs.getString(51));
				examBody.setDeshidratacion(rs.getString(52));
				examBody.setTegumentoAdd(rs.getString(53));
				examBody.setClaudicacion(rs.getString(54));
				examBody.setArticulaciones(rs.getString(55));
				examBody.setHuesos(rs.getString(56));
				examBody.setTejidosBlandos(rs.getString(57));
				examBody.setExtremidadesAdd(rs.getString(58));
				examBody.setActitud(rs.getString(59));
				examBody.setReflejos(rs.getString(60));
				examBody.setCerebro(rs.getString(61));
				examBody.setMedulaEspinal(rs.getString(62));
				examBody.setSncAdd(rs.getString(63));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return examBody;
		}
		return examBody;
	}

	public String getDiagnosticExam(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		String diagnostic = "";

		String sql = "SELECT diagnostico_examen "
				+ "FROM registros_examen AS r INNER JOIN consultas AS c ON r.id_consulta = c.id_consulta "
				+ "WHERE c.id_mascota = " + idPet + " " + "AND c.fecha_consulta = '" + date + "'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				diagnostic = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return diagnostic;
		}
		return diagnostic;
	}

	public ArrayList<Object[]> getTableMedicines(int idPet, String dateConsult) {
		String date = UtilityClass.changeFormatDate(dateConsult);
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConnection();
		ArrayList<Object[]> tableData = new ArrayList<>();

		String sql = "SELECT m.id_medicamento, m.nombre_medicamento, t.nombre_tipo_medicamento, r.dosis, r.frecuencia "
				+ "FROM tipos_medicamento AS t INNER JOIN medicamentos AS m ON t.id_tipo_medicamento = m.id_tipo_medicamento "
				+ "INNER JOIN recetas AS r ON r.id_medicamento = m.id_medicamento "
				+ "INNER JOIN consultas AS c ON c.id_consulta = r.id_consulta " + "WHERE c.id_mascota = " + idPet + " "
				+ "AND c.fecha_consulta = '" + date + "'";

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
	
	public ArrayList<Object[]> getTableWeight(int idPet) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String date = "";
		Date oldDate = null;
		Connection con = getConnection();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Object[]> tableData = new ArrayList<>();
		
		String sql = "SELECT e.peso, c.fecha_consulta, p.nombre_persona, p.apellido_persona "
				+ "FROM examenesecop AS e INNER JOIN registros_examen AS r ON e.id_examen_ecop = r.id_examen_ecop "
				+ "INNER JOIN consultas AS c ON c.id_consulta = r.id_consulta "
				+ "INNER JOIN personas AS p ON p.id_persona = c.id_persona " 
				+ "WHERE c.id_mascota = " + idPet;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int countCols = rsMd.getColumnCount();
			
			
			while (rs.next()) {
				Object[] rows = new Object[countCols-1];
				rows[0] = rs.getObject(1);
				oldDate = UtilityClass.daysAdd(rs.getDate(2), 1);
				date = simpleDateFormat.format(oldDate);
				rows[1] = date;
				rows[2] = rs.getObject(3) +" " +rs.getObject(4);
				
				tableData.add(rows);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableData;
	}

}
