package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLHistory;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.Consult;
import com.cmv.petGenesis.model.ExamECOP;
import com.cmv.petGenesis.model.ExamTPR;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelSeeHistory extends JPanel{
	
	private JPanel JPanelSouth;
	private JPanel JPanelCenter;
	private JPanel JPanelNorth;
	private JPanel jPanelDataPet;
	private JPanel jPanelGeneralHistory, jPanelRoundGeneral;
	private JPanel jPanelChooseConsult;
	private JPanel jPanelDataConsult;
	private JLabel lblTitleHistory;
	private JPanel jPanelTitleExam;
	private JPanel jPanelTitleTPR, jPanelTPR;
	private JPanel jPanelTitleECOP, jPanelECOP;
	private JPanel jPanelTitleBody, jPanelBody;
	private JPanel jPanelCommentsPet;
	private JPanel jPanelDiagnostic;
	private JPanel jPanelTitleMedicines, jPanelMedicines; 
	private JPanelResultExamBody jPanelResultExamBody;
	private CustomLabel lblIdPet, lblRIdPet, lblNamePet, lblRNamePet, lblRace, lblRRace, lblGender, lblRGender, lblSpecie, lblBirth, lblRBirth, lblRSpecie, lblColor, lblRColor, lblRCastrated, lblNameProp, lblRNameProp;
	private CustomLabel lblAddComments;
	private CustomLabel lblChooseConsult;
	private CustomLabel lblTitleExam;
	private CustomLabel lblIdConsult, lblRIdConsult, lblMotivConsult, lblUserConsult, lblRUserConsult;
	private JTextArea jtaRMotivConsult;
	private JScrollPane jspRMotivConsult;
	private CustomLabel lblTemperature, lblRTemperature, lblPression, lblRPression, lblCardiac, lblRCardiac, lblRespiratory, lblRRespiratory;
	private CustomLabel lblTitleMedicaments;
	private JTable jTableMedicines;
	private DefaultTableModel model;
	private JScrollPane jspMedicines;
	private JComboBox<String> dataConsult;
	private JButton btnReturn;
	private JScrollPane jspRoundHistory;
	private JTextArea jtaDiagnostic;
	private JTextArea jtaCommentsPet, jtaObs;
	private JScrollPane jspCommentsPet, jspObs;
	private CustomLabel lblDiagnostic;
	private JScrollPane jspDiagnostic;
	private CustomLabel lblWeight, lblRWeight, lblTemperament, lblRTemperament, lblAttitude, lblRAttitude, lblStool, lblRStool, lblApetit, lblRApetit, lblWater, lblRWater, lblDiet, lblRDiet, lblNails, lblRNails, lblRVomit, lblObs, lblRObs;
	private JButton btnShowWeightControl;
	private int idPet;
	
	private SQLHistory sqlHistory;
	
	
	public JPanelSeeHistory(int idPet) {
		super(new BorderLayout());
		this.sqlHistory = new SQLHistory();
		this.JPanelNorth = new JPanel();
		this.JPanelCenter = new JPanel();
		this.JPanelSouth = new JPanel();
		this.jPanelGeneralHistory = new JPanel(new GridBagLayout());
		this.jPanelRoundGeneral = new JPanel();
		this.idPet = idPet;
		init();
		ControlHistory.getInstance().setjPanelSeeHistory(this);
	}

	private void init() {
		initPanelNorth();
		initPanelCenter();
		initPanelSouth();
		setDataPet();
		this.add(JPanelNorth, BorderLayout.NORTH);
		this.add(JPanelCenter, BorderLayout.CENTER);
		this.add(JPanelSouth, BorderLayout.SOUTH);
	}
	
	private void initPanelNorth() {
		this.lblTitleHistory = new JLabel("HISTORIA CLINICA DE PACIENTE");
		this.lblTitleHistory.setForeground(new Color(9, 92, 150));
		this.lblTitleHistory.setFont(ConstantView.FONT_TITLE_CRUD);
		this.lblTitleHistory.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.JPanelNorth.add(lblTitleHistory);
	}
	
	private void initPanelCenter() {
		initPanelGeneralHistory();
		JPanelCenter.add(jspRoundHistory);
		setData();
	}
	
	private void initPanelGeneralHistory() {
		this.jspRoundHistory = new JScrollPane();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		initPanelDataPet();
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 0, 20, 0));
		this.jPanelGeneralHistory.add(jPanelDataPet, gbc);
		
		initPanelCommentsPet();
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jPanelGeneralHistory.add(jPanelCommentsPet, gbc);
		
		initChooseConsult();
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		this.jPanelGeneralHistory.add(jPanelChooseConsult, gbc);
		
		initPanelDataConsult();
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		this.jPanelGeneralHistory.add(jPanelDataConsult, gbc);
		
		initPanelTitleExam();
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		this.jPanelGeneralHistory.add(jPanelTitleExam, gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		initPanelTPR();
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		this.jPanelGeneralHistory.add(jPanelTitleTPR, gbc);
		
		initPanelECOP();
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		this.jPanelGeneralHistory.add(jPanelTitleECOP, gbc);
		
		initJPanelBody();
		UtilityClass.organizeGridLayout(gbc, 0, 7);
		this.jPanelGeneralHistory.add(jPanelTitleBody, gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		initPanelDiagnostic();
		UtilityClass.organizeGridLayout(gbc, 0, 8);
		this.jPanelGeneralHistory.add(jPanelDiagnostic, gbc);
		
		initPanelTitleMedicines();
		UtilityClass.organizeGridLayout(gbc, 0, 9);
		this.jPanelGeneralHistory.add(jPanelTitleMedicines, gbc);
		
		initPanelMedicines();
		UtilityClass.organizeGridLayout(gbc, 0, 10);
		this.jPanelGeneralHistory.add(jPanelMedicines, gbc);
		
		jPanelRoundGeneral.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 10));
		jPanelRoundGeneral.add(jPanelGeneralHistory);
		jspRoundHistory.setPreferredSize(new Dimension(1200, 580));
		jspRoundHistory.setViewportView(jPanelRoundGeneral);
	}
	
	private void initPanelSouth() {
		this.btnReturn = new JButton("REGRESAR");
		this.btnReturn.setFont(ConstantView.FONT_AREA_COMMENTS);
		this.btnReturn.setForeground(Color.WHITE);
		this.btnReturn.setBackground(new Color(9,92,150));
		this.btnReturn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		this.btnReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnReturn.setFocusable(false);
		this.JPanelSouth.add(btnReturn);
	}
	
	private void initPanelDataPet() {
		this.jPanelDataPet = new JPanel(new GridBagLayout());
		lblIdPet = new CustomLabel("ID", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRIdPet = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblNamePet = new CustomLabel("Nombre", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRNamePet = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblRace = new CustomLabel("Raza", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRRace = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblGender = new CustomLabel("Género", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRGender = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblSpecie = new CustomLabel("Especie", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRSpecie = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblColor = new CustomLabel("Color", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRColor = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblRCastrated = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblBirth = new CustomLabel("Fecha de Nacimiento", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRBirth = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblNameProp = new CustomLabel("Propietario", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRNameProp = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		btnShowWeightControl = new JButton("CONTROL PESO");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPanelDataPet.add(lblIdPet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPanelDataPet.add(lblRIdPet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(5, 5, 5, 5));
		jPanelDataPet.add(lblNamePet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelDataPet.add(lblRNamePet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPanelDataPet.add(lblSpecie, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPanelDataPet.add(lblRSpecie, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 1, new Insets(5, 230, 5, 5));
		jPanelDataPet.add(lblRace, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 1, new Insets(5, 5, 5, 230));
		jPanelDataPet.add(lblRRace, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 2, new Insets(5, 230, 5, 5));
		jPanelDataPet.add(lblColor, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 2, new Insets(5, 5, 5, 230));
		jPanelDataPet.add(lblRColor, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 4, 1, new Insets(5, 5, 5, 5));
		jPanelDataPet.add(lblGender, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 5, 1);
		jPanelDataPet.add(lblRGender, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 4, 2);
		jPanelDataPet.add(lblRCastrated, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 4, 3);
		btnShowWeightControl.setFocusable(false);
		btnShowWeightControl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnShowWeightControl.setForeground(Color.WHITE);
		btnShowWeightControl.setBackground(new Color(9, 92, 150));
		UtilityClass.addCommandJButton(btnShowWeightControl, HistoryCommands.CMD_WD_RHISTORY_WEIGHT.toString(), ControlHistory.getInstance());
		jPanelDataPet.add(btnShowWeightControl, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelDataPet.add(lblBirth, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPanelDataPet.add(lblRBirth, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 3, new Insets(5, 230, 5, 5));
		jPanelDataPet.add(lblNameProp, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 3, new Insets(5, 5, 5, 5));
		jPanelDataPet.add(lblRNameProp, gbc);
	}
	
	private void initPanelCommentsPet() {
		jPanelCommentsPet = new JPanel(new GridBagLayout());
		lblAddComments = new CustomLabel("Comentarios Adicionales", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		jtaCommentsPet = new JTextArea();
		jspCommentsPet = new JScrollPane();
		
		GridBagConstraints gbc = new GridBagConstraints();
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPanelCommentsPet.add(lblAddComments, gbc);
		
		jtaCommentsPet.setLineWrap(true);
		jtaCommentsPet.setWrapStyleWord(true);
		jtaCommentsPet.setEditable(false);
		jtaCommentsPet.setFont(ConstantView.FONT_TEXT_AREA);
		jtaCommentsPet.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jspCommentsPet.setPreferredSize(new Dimension(400, 80));
		jspCommentsPet.setViewportView(jtaCommentsPet);
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPanelCommentsPet.add(jspCommentsPet, gbc);
	}

	private void initChooseConsult() {
		jPanelChooseConsult = new JPanel(new GridBagLayout());
		
		lblChooseConsult = new CustomLabel("Seleccione fecha para ver resultados de consulta", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		dataConsult = new JComboBox<>(sqlHistory.getConsultsPet(idPet));
		dataConsult.setSelectedIndex(0);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 2;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPanelChooseConsult.add(lblChooseConsult, gbc);
		
		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 2, 0);
		dataConsult.addItemListener(ControlHistory.getInstance());
		jPanelChooseConsult.add(dataConsult, gbc);
	}
	
	private void initPanelDataConsult() {
		jPanelDataConsult = new JPanel(new GridBagLayout());
		lblIdConsult = new CustomLabel("ID CONSULTA", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRIdConsult = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblMotivConsult = new CustomLabel("Motivo de la consulta", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		jtaRMotivConsult = new JTextArea();
		jspRMotivConsult = new JScrollPane();
		lblUserConsult = new CustomLabel("Paciente Atendido por", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRUserConsult = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(5, 5, 5, 5));
		jPanelDataConsult.add(lblIdConsult, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0, new Insets(5, 5, 5, 320));
		jPanelDataConsult.add(lblRIdConsult, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 0, new Insets(5, 5, 5, 5));
		jPanelDataConsult.add(lblMotivConsult, gbc);
		
		jtaRMotivConsult.setLineWrap(true);
		jtaRMotivConsult.setWrapStyleWord(true);
		jtaRMotivConsult.setEditable(false);
		jtaRMotivConsult.setFont(ConstantView.FONT_TEXT_AREA);
		jtaRMotivConsult.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaRMotivConsult.setForeground(Color.BLACK);
		jspRMotivConsult.setPreferredSize(new Dimension(300, 80));
		jspRMotivConsult.setViewportView(jtaRMotivConsult);
		UtilityClass.organizeGridLayout(gbc, 3, 0, new Insets(5, 5, 5, 5));
		jPanelDataConsult.add(jspRMotivConsult, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPanelDataConsult.add(lblUserConsult, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelDataConsult.add(lblRUserConsult, gbc);
	}
	
	private void initPanelTitleExam() {
		jPanelTitleExam = new JPanel();
		lblTitleExam = new CustomLabel("EXAMEN REALIZADO", ConstantView.FONT_TITLE_COMMENTS, new Color(9, 92, 150));
		lblTitleExam.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		jPanelTitleExam.add(lblTitleExam);
	}
	
	private void initPanelTPR() {
		jPanelTitleTPR = new JPanel();
		jPanelTPR = new JPanel(new GridBagLayout());
		lblTemperature = new CustomLabel("Temperatura (°C)", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRTemperature = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblPression = new CustomLabel("Presión (1/min)", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRPression = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblCardiac = new CustomLabel("Frecuencia Cardiaca (1/min)", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRCardiac = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblRespiratory = new CustomLabel("Frecuencia Respiratoria (1/min)", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRRespiratory = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 20, 20, 20));
		jPanelTPR.add(lblTemperature, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 0);
		jPanelTPR.add(lblPression, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 0);
		jPanelTPR.add(lblCardiac, gbc);

		UtilityClass.organizeGridLayout(gbc, 6, 0);
		jPanelTPR.add(lblRespiratory, gbc);

		gbc.insets.left = 5;
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPanelTPR.add(lblRTemperature, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jPanelTPR.add(lblRPression, gbc);

		UtilityClass.organizeGridLayout(gbc, 5, 0);
		jPanelTPR.add(lblRCardiac, gbc);

		UtilityClass.organizeGridLayout(gbc, 7, 0);
		jPanelTPR.add(lblRRespiratory, gbc);
		
		jPanelTitleTPR.setBorder(BorderFactory.createTitledBorder("TPR - TEMPERATURA, PRESIÓN, RESPIRACIÓN"));
		jPanelTitleTPR.add(jPanelTPR);
	}
	
	private void initPanelECOP() {
		jPanelECOP = new JPanel(new GridBagLayout());
		jPanelECOP.setBorder(BorderFactory.createEmptyBorder(0, 250, 0, 250));
		jPanelTitleECOP = new JPanel();
		lblWeight = new CustomLabel("PESO (kg)", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRWeight = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblTemperament = new CustomLabel("TEMPERAMENTO", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRTemperament = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblAttitude = new CustomLabel("ACTITUD", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRAttitude = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblStool = new CustomLabel("HECES", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRStool = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblApetit = new CustomLabel("APETITO", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRApetit = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblWater = new CustomLabel("CONSUMO DE AGUA", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRWater = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblDiet = new CustomLabel("DIETA", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRDiet = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblNails = new CustomLabel("UÑAS", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRNails = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblRVomit = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		lblObs = new CustomLabel("OBSERVACIONES ADICIONALES", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		lblRObs = new CustomLabel("", ConstantView.FONT_PRINCIPAL_LABELS_RESULT, Color.BLACK);
		jtaObs = new JTextArea();
		jspObs = new JScrollPane();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 5, 0, 5));
		jPanelECOP.add(lblWeight, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPanelECOP.add(lblRWeight, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPanelECOP.add(lblAttitude, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPanelECOP.add(lblApetit, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPanelECOP.add(lblRVomit, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelECOP.add(lblDiet, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelECOP.add(lblRAttitude, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPanelECOP.add(lblRDiet, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPanelECOP.add(lblRApetit, gbc);

		gbc.insets.left = 80;
		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jPanelECOP.add(lblTemperament, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 1);
		jPanelECOP.add(lblStool, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 2);
		jPanelECOP.add(lblWater, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 3);
		jPanelECOP.add(lblNails, gbc);
		
		gbc.gridwidth = 2;
		UtilityClass.organizeGridLayout(gbc, 3, 4);
		jPanelECOP.add(lblObs, gbc);
		
		gbc.insets.top = 0;
		UtilityClass.organizeGridLayout(gbc, 3, 5);
		jtaObs.setLineWrap(true);
		jtaObs.setWrapStyleWord(true);
		jtaObs.setEditable(false);
		jtaObs.setFont(ConstantView.FONT_TEXT_AREA);
		jtaObs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaObs.setForeground(Color.BLACK);
		jspObs.setPreferredSize(new Dimension(300, 80));
		jspObs.setViewportView(jtaObs);
		jPanelECOP.add(jspObs, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 4, 0, new Insets(20, 5, 0, 5));
		jPanelECOP.add(lblRTemperament, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 1);
		jPanelECOP.add(lblRStool, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 2);
		jPanelECOP.add(lblRWater, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 3);
		jPanelECOP.add(lblRNails, gbc);
		
		jPanelTitleECOP.setBorder(BorderFactory.createTitledBorder("ECOP - EXAMEN CLÍNICO ORIENTADO AL PROBLEMA"));
		jPanelTitleECOP.add(jPanelECOP);
	}
	
	private void initJPanelBody() {
		jPanelTitleBody = new JPanel();
		jPanelBody = new JPanel();
		jPanelResultExamBody = new JPanelResultExamBody();
		
		jPanelBody.setBorder(BorderFactory.createEmptyBorder(0, 250, 0, 250));
		jPanelBody.add(jPanelResultExamBody);
		jPanelTitleBody.setBorder(BorderFactory.createTitledBorder("EXAMEN CORPORAL"));
		jPanelTitleBody.add(jPanelBody);
	}
	
	private void initPanelDiagnostic() {
		jPanelDiagnostic = new JPanel(new GridBagLayout());
		lblDiagnostic = new CustomLabel("DIAGNÓSTICO", ConstantView.FONT_PRINCIPAL_LABELS, Color.BLACK);
		jspDiagnostic = new JScrollPane();
		jtaDiagnostic = new JTextArea();
		
		GridBagConstraints gbc = new GridBagConstraints();
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 10, 10, 10));
		lblDiagnostic.setForeground(new Color(9, 92, 150));
		jPanelDiagnostic.add(lblDiagnostic, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jtaDiagnostic.setLineWrap(true);
		jtaDiagnostic.setWrapStyleWord(true);
		jtaDiagnostic.setEditable(false);
		jtaDiagnostic.setFont(ConstantView.FONT_TEXT_AREA);
		jtaDiagnostic.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaDiagnostic.setForeground(Color.BLACK);
		jspDiagnostic.setPreferredSize(new Dimension(400, 80));
		jspDiagnostic.setViewportView(jtaDiagnostic);
		jPanelDiagnostic.add(jspDiagnostic, gbc);
	}
	
	private void initPanelTitleMedicines() {
		jPanelTitleMedicines = new JPanel();
		lblTitleMedicaments = new CustomLabel("MEDICAMENTOS RECETADOS", ConstantView.FONT_TITLE_COMMENTS, new Color(9, 92, 150));
		lblTitleMedicaments.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		jPanelTitleMedicines.add(lblTitleMedicaments);
	}
	
	private void initPanelMedicines() {
		jPanelMedicines = new JPanel();
		jTableMedicines = new JTable();
		jspMedicines = new JScrollPane();
		model = new DefaultTableModel();
		
		jTableMedicines.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableMedicines.setEnabled(false);
		jTableMedicines.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jTableMedicines.getTableHeader().setReorderingAllowed(false);
		
		jspMedicines.setViewportView(jTableMedicines);
		jspMedicines.setPreferredSize(new Dimension(800, 200));
		jspMedicines.getViewport().setBackground(Color.decode("#c5dfed"));
		
		jPanelMedicines.add(jspMedicines);
	}
	
	private void changeWidthColumn() {
		int[] widthColumns = { 140, 160, 160, 160, 177};
		for (int i = 0; i < widthColumns.length; i++) {
			jTableMedicines.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}
	
	private void loadTableMedicines() {
		jTableMedicines.setModel(model);
		
		model.addColumn("Id Medicamento");
		model.addColumn("Nombre Medicamento");
		model.addColumn("Tipo medicamento");
		model.addColumn("Dosis");
		model.addColumn("Frecuencia");
		
		ArrayList<Object[]> table = sqlHistory.getTableMedicines(idPet, (String) dataConsult.getSelectedItem());
		for (Object[] row : table) {
			model.addRow(row);
		}
		
		changeWidthColumn();
	}
	
	private void setDataPet() {
		Pet pet = sqlHistory.getBasicData(idPet);
		Client c = sqlHistory.getDataClient(pet.getClient().getIdPerson());
		
		lblRIdPet.setText("" +pet.getId());
		lblRNamePet.setText(pet.getNamePet());
		lblRRace.setText(pet.getRace().getNameRace());
		lblRGender.setText(pet.getGenderPet().getNameGender());
		lblRSpecie.setText(pet.getSpecie().getNameSpecie());
		lblRColor.setText(pet.getColorPet());
		lblRCastrated.setText(pet.isCastrated()?"Paciente Castrado":"Paciente sin castrar");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = simpleDateFormat.format(pet.getBirthDate());
		
		lblRBirth.setText(date);
		lblRNameProp.setText(c.getName() +" " +c.getLastName());
		jtaCommentsPet.setText(pet.getAditionalDescription());
	}
	
	public void setData() {
		setDataConsult();
		setDataExamTPR();
		setDataExamECOP();
		setDataExamBody();
		setDataDiagnostic();
		loadTableMedicines();
	}
	
	private void setDataConsult() {
		Consult consult = sqlHistory.getDataConsult(idPet, (String) dataConsult.getSelectedItem());
		lblRIdConsult.setText("" +consult.getIdConsult());
		jtaRMotivConsult.setText(consult.getMotiveConsult());
		lblRUserConsult.setText(consult.getPerson().getName() +" " +consult.getPerson().getLastName());
	}
	
	private void setDataExamTPR() {
		ExamTPR examTPR = sqlHistory.getDataTPR(idPet, (String) dataConsult.getSelectedItem());
		lblRTemperature.setText(examTPR.getTemperature());
		lblRPression.setText(examTPR.getPression());
		lblRCardiac.setText(examTPR.getfCardiac());
		lblRRespiratory.setText(examTPR.getfRespiratory());
	}
	
	private void setDataExamECOP() {
		ExamECOP examECOP = sqlHistory.getDataECOP(idPet, (String) dataConsult.getSelectedItem());
		lblRWeight.setText(examECOP.getWeight());
		lblRTemperament.setText(examECOP.getTemperament());
		lblRAttitude.setText(examECOP.getAttitude());
		lblRStool.setText(examECOP.getStool());
		lblRApetit.setText(examECOP.getApetitte());
		lblRWater.setText(examECOP.getWater());
		lblRDiet.setText(examECOP.getDiet());
		lblRNails.setText(examECOP.getNails());
		lblRVomit.setText(examECOP.getVomit());
		jtaObs.setText(examECOP.getObservations());
	}
	
	private void setDataExamBody() {
		this.jPanelResultExamBody.setDataExamBody(idPet, (String) dataConsult.getSelectedItem());
	}
	
	private void setDataDiagnostic() {
		jtaDiagnostic.setText(sqlHistory.getDiagnosticExam(idPet, (String) dataConsult.getSelectedItem()));
	}

	public JComboBox<String> getDataConsult() {
		return dataConsult;
	}
	
	public void showJDialogWeight() {
		new JDialogWeight(idPet);
	}
}
