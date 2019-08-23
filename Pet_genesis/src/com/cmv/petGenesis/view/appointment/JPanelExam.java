package com.cmv.petGenesis.view.appointment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cmv.petGenesis.connection.SQLExam;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.model.ExamECOP;
import com.cmv.petGenesis.model.ExamTPR;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelExam extends JPanel {

	private JPanel jPanelEcop, jPanelTpr, jPanelNorth, jPanelDiag, jPanelDown;
	private JPanelBody jPanelBody;
	private JPanel jPanelAp, jPanelStool, jPanelWater, jPanelDiet, jPanelNail;
	private JPanel jPanelRoundTPR, jPanelRoundBody, jPanelRoundEcop;
	private JLabel lblTitleRutinExam, lblWeigth, lblAppetite, lblStool, lblWater, lblDiet, lblNails, lblAttitude,
			lblTemperature, lblTemp, lblPression, lblCardiac, lblRespiratory, lblObsECOP;
	private JRadioButton jrbApGood, jrbApRegular, jrbApNull, jrbStNormal, jrbStDiarr, jrbConstip, jrbWaterNormal,
			jrbWaterPolid, jrbWaterPoliu, jrbDietMeat, jrbDietVeg, jrbDietCarb, jrbOtherDiet, jrbNailNormal, jrbNailCut;
	private JCheckBox checkVomit;
	private JTextArea jtaOralCavid, jtaFace, jtaTrunk, jtaGenitals, jtaExtremities, jtaSnc, jtaDiagnostic, jtaObsECOP;
	private JScrollPane scDiagnostic, jspObsECOP;
	protected JTextField jtfAttitude, jtfWeight, jtfTemp, jtfTemperature, jtfPression, jtfCardiac, jtfRespiratory;
	private ButtonGroup bgAp, bgStool, bgWater, bgDiet, bgNail;

	private int idExamTPR;
	private int idExamECOP;
	
	public JPanelExam() {
		super(new BorderLayout());
		this.jPanelEcop = new JPanel(new GridBagLayout());
		this.lblTitleRutinExam = new JLabel(ConstantView.LBL_TITLE_EXAM);
		this.lblTitleRutinExam.setFont(ConstantView.FONT_TITLE_EXAM);
		this.jPanelTpr = new JPanel(new GridBagLayout());
		this.jPanelNorth = new JPanel(new BorderLayout());
		this.jPanelDiag = new JPanel(new GridBagLayout());
		this.jPanelRoundTPR = new JPanel();
		this.jPanelRoundBody = new JPanel();
		this.jPanelRoundEcop = new JPanel();
		this.jPanelDown = new JPanel(new BorderLayout());
		this.jPanelBody = new JPanelBody();
		
		SQLExam sqlExam = new SQLExam();
		idExamTPR = sqlExam.getLastTPR()+1;
		idExamECOP = sqlExam.getLastECOP()+1;
		
		init();
	}

	private void init() {
		initPanelEcop();
		initPanelTPR();
		initJPanelDown();
		this.lblTitleRutinExam.setHorizontalAlignment(JLabel.CENTER);
		this.lblTitleRutinExam.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		this.jPanelRoundTPR.setBorder(BorderFactory.createTitledBorder("TPF - TEMPERATURA, PRESIÓN, RESPIRACIÓN"));
		this.jPanelRoundTPR.add(jPanelTpr);
		this.jPanelNorth.add(lblTitleRutinExam, BorderLayout.NORTH);
		this.jPanelNorth.add(jPanelRoundTPR, BorderLayout.SOUTH);
		this.add(jPanelNorth, BorderLayout.NORTH);

		this.jPanelRoundEcop.setBorder(BorderFactory.createTitledBorder("ORIENTADO AL PROBLEMA"));
		this.jPanelRoundEcop.add(jPanelEcop);
		this.add(jPanelRoundEcop, BorderLayout.CENTER);

		this.add(jPanelDown, BorderLayout.SOUTH);

	}

	private void initPanelEcop() {
		lblWeigth = new JLabel(ConstantView.LBL_EXAM_WEIGHT);
		jtfWeight = new JTextField(10);
		lblAttitude = new JLabel(ConstantView.LBL_EXAM_ATT);
		jtfAttitude = new JTextField(10);
		lblTemp = new JLabel(ConstantView.LBL_EXAM_TEMP);
		jtfTemp = new JTextField(10);
		lblAppetite = new JLabel(ConstantView.LBL_EXAM_APPETITE);
		jrbApGood = new JRadioButton(ConstantView.JRB_EXAM_APGOOD);
		jrbApRegular = new JRadioButton(ConstantView.JRB_EXAM_APREG);
		jrbApNull = new JRadioButton(ConstantView.JRB_EXAM_NULL);
		lblStool = new JLabel(ConstantView.LBL_EXAM_STOOL);
		jrbStNormal = new JRadioButton(ConstantView.JRB_EXAM_SNORM);
		jrbStDiarr = new JRadioButton(ConstantView.JRB_EXAM_SDIARR);
		jrbConstip = new JRadioButton(ConstantView.JRB_EXAM_SCONS);
		checkVomit = new JCheckBox(ConstantView.CH_EXAM_VOMIT);
		lblWater = new JLabel(ConstantView.LBL_EXAM_WATER);
		jrbWaterNormal = new JRadioButton(ConstantView.JRB_EXAM_WNORM);
		jrbWaterPolid = new JRadioButton(ConstantView.JRB_EXAM_POL);
		jrbWaterPoliu = new JRadioButton(ConstantView.JRB_EXAM_POR);
		lblDiet = new JLabel(ConstantView.LBL_EXAM_DIET);
		jrbDietMeat = new JRadioButton(ConstantView.JRB_EXAM_DMEAT);
		jrbDietCarb = new JRadioButton(ConstantView.JRB_EXAM_DCARB);
		jrbDietVeg = new JRadioButton(ConstantView.JRB_EXAM_DVEG);
		lblNails = new JLabel(ConstantView.LBL_EXAM_NAILS);
		jrbNailNormal = new JRadioButton(ConstantView.JRB_EXAM_NAIL_OK);
		jrbNailCut = new JRadioButton(ConstantView.JRB_EXAM_NAIL_CUT);
		jrbOtherDiet = new JRadioButton(ConstantView.JRB_EXAM_DOTHER);
		jspObsECOP = new JScrollPane();
		jtaObsECOP = new JTextArea();
		lblObsECOP = new JLabel(ConstantView.LBL_OTHER_OBS);
		bgAp = new ButtonGroup();
		bgDiet = new ButtonGroup();
		bgNail = new ButtonGroup();
		bgStool = new ButtonGroup();
		bgWater = new ButtonGroup();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 5, 0, 5));
		jPanelEcop.add(lblWeigth, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jtfWeight.addKeyListener(ControlHistory.getInstance());
		jPanelEcop.add(jtfWeight, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPanelEcop.add(lblAttitude, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPanelEcop.add(lblAppetite, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jPanelEcop.add(checkVomit, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelEcop.add(lblDiet, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelEcop.add(jtfAttitude, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPanelDiet = new JPanel();
		jrbDietMeat.setSelected(true);
		bgDiet.add(jrbDietMeat);
		bgDiet.add(jrbDietCarb);
		bgDiet.add(jrbDietVeg);
		bgDiet.add(jrbOtherDiet);
		jPanelDiet.add(jrbDietMeat);
		jPanelDiet.add(jrbDietCarb);
		jPanelDiet.add(jrbDietVeg);
		jPanelDiet.add(jrbOtherDiet);
		jPanelEcop.add(jPanelDiet, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPanelAp = new JPanel();
		jrbApGood.setSelected(true);
		bgAp.add(jrbApGood);
		bgAp.add(jrbApRegular);
		bgAp.add(jrbApNull);
		jPanelAp.add(jrbApGood);
		jPanelAp.add(jrbApRegular);
		jPanelAp.add(jrbApNull);
		jPanelEcop.add(jPanelAp, gbc);

		gbc.insets.left = 80;
		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jPanelEcop.add(lblTemp, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 1);
		jPanelEcop.add(lblStool, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 2);
		jPanelEcop.add(lblWater, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 3);
		jPanelEcop.add(lblNails, gbc);
		
		gbc.gridwidth = 2;
		UtilityClass.organizeGridLayout(gbc, 3, 4);
		jPanelEcop.add(lblObsECOP, gbc);
		
		gbc.insets.bottom = 0;
		gbc.insets.top = 0;
		UtilityClass.organizeGridLayout(gbc, 3, 5);
		jtaObsECOP.setLineWrap(true);
		jtaObsECOP.setWrapStyleWord(true);
		jtaObsECOP.setFont(ConstantView.FONT_TEXT_AREA);
		jtaObsECOP.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaObsECOP.setForeground(Color.BLACK);
		jspObsECOP.setPreferredSize(new Dimension(300, 80));
		jspObsECOP.setViewportView(jtaObsECOP);
		jPanelEcop.add(jspObsECOP, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 0, new Insets(20, 5, 0, 5));
		jPanelEcop.add(jtfTemp, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 1);
		jPanelStool = new JPanel();
		jrbStNormal.setSelected(true);
		bgStool.add(jrbStNormal);
		bgStool.add(jrbStDiarr);
		bgStool.add(jrbConstip);
		jPanelStool.add(jrbStNormal);
		jPanelStool.add(jrbStDiarr);
		jPanelStool.add(jrbConstip);
		jPanelEcop.add(jPanelStool, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 2);
		jPanelWater = new JPanel();
		jrbWaterNormal.setSelected(true);
		bgWater.add(jrbWaterNormal);
		bgWater.add(jrbWaterPolid);
		bgWater.add(jrbWaterPoliu);
		jPanelWater.add(jrbWaterNormal);
		jPanelWater.add(jrbWaterPolid);
		jPanelWater.add(jrbWaterPoliu);
		jPanelEcop.add(jPanelWater, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 3);
		jPanelNail = new JPanel();
		bgNail.add(jrbNailNormal);
		bgNail.add(jrbNailCut);
		jrbNailNormal.setSelected(true);
		jPanelNail.add(jrbNailNormal);
		jPanelNail.add(jrbNailCut);
		jPanelEcop.add(jPanelNail, gbc);
	}

	private void initPanelTPR() {
		lblTemperature = new JLabel(ConstantView.LBL_EXAM_TMP);
		jtfTemperature = new JTextField(5);
		lblPression = new JLabel(ConstantView.LBL_EXAM_PRESSION);
		jtfPression = new JTextField(5);
		lblCardiac = new JLabel(ConstantView.LBL_EXAM_CARD);
		jtfCardiac = new JTextField(5);
		lblRespiratory = new JLabel(ConstantView.LBL_EXAM_RESP);
		jtfRespiratory = new JTextField(5);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 10, 10, 10));
		jPanelTpr.add(lblTemperature, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 0);
		jPanelTpr.add(lblPression, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 0);
		jPanelTpr.add(lblCardiac, gbc);

		UtilityClass.organizeGridLayout(gbc, 6, 0);
		jPanelTpr.add(lblRespiratory, gbc);

		gbc.insets.left = 5;
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jtfTemperature.addKeyListener(ControlHistory.getInstance());
		jPanelTpr.add(jtfTemperature, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 0);
		this.jtfPression.addKeyListener(ControlHistory.getInstance());
		jPanelTpr.add(jtfPression, gbc);

		UtilityClass.organizeGridLayout(gbc, 5, 0);
		this.jtfCardiac.addKeyListener(ControlHistory.getInstance());
		jPanelTpr.add(jtfCardiac, gbc);

		UtilityClass.organizeGridLayout(gbc, 7, 0);
		this.jtfRespiratory.addKeyListener(ControlHistory.getInstance());
		jPanelTpr.add(jtfRespiratory, gbc);
	}

	private void initJPanelDown() {
		initJPanelDiagnostic();
		this.jPanelRoundBody.setBorder(BorderFactory.createTitledBorder("CUERPO"));
		this.jPanelRoundBody.add(jPanelBody);
		this.jPanelDown.add(jPanelRoundBody, BorderLayout.NORTH);
		this.jPanelDown.add(jPanelDiag, BorderLayout.SOUTH);
	}

	private void initJPanelDiagnostic() {
		this.jPanelDiag.setBorder(BorderFactory.createTitledBorder(ConstantView.LBL_EXAM_DIAGNOSTIC));
		GridBagConstraints gbc = new GridBagConstraints();

		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 20, 20, 20));
		jtaDiagnostic = new JTextArea();
		jtaDiagnostic.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaDiagnostic.setFont(ConstantView.FONT_TEXT_AREA);
		jtaDiagnostic.setLineWrap(true);
		jtaDiagnostic.setWrapStyleWord(true);
		scDiagnostic = new JScrollPane();
		scDiagnostic.setViewportView(jtaDiagnostic);
		scDiagnostic.setPreferredSize(new Dimension(500, 100));
		jPanelDiag.add(scDiagnostic, gbc);
	}

	public ExamTPR getResultExamTPR() {
		ExamTPR examTPR = new ExamTPR();
		
		examTPR.setIdTpr(idExamTPR);
		examTPR.setTemperature(jtfTemperature.getText());
		examTPR.setPression(jtfPression.getText());
		examTPR.setfCardiac(jtfCardiac.getText());
		examTPR.setfRespiratory(jtfRespiratory.getText());
		
		return examTPR;
	}

	public ExamECOP getResultExamEcop() {
		ExamECOP examECOP = new ExamECOP();
		
		examECOP.setIdEcop(idExamECOP);
		examECOP.setWeight(jtfWeight.getText());
		examECOP.setTemperament(jtfTemp.getText());
		examECOP.setAttitude(jtfAttitude.getText());
		examECOP.setStool(UtilityClass.getSelection(bgStool).getText());
		examECOP.setApetitte(UtilityClass.getSelection(bgAp).getText());
		examECOP.setWater(UtilityClass.getSelection(bgWater).getText());
		examECOP.setDiet(UtilityClass.getSelection(bgDiet).getText());
		examECOP.setNails(UtilityClass.getSelection(bgNail).getText());
		examECOP.setVomit(checkVomit.isSelected()?"Paciente con vómito":"No presenta vómito");
		examECOP.setObservations(jtaObsECOP.getText());
		return examECOP;
	}
	
	public ExamBody getResultExamBody() {
		return jPanelBody.getResultExamBody();
	}

	public void clearFields() {
		jtaExtremities.setText("");
		jtaFace.setText("");
		jtaGenitals.setText("");
		jtaOralCavid.setText("");
		jtaDiagnostic.setText("");
		jtaSnc.setText("");
		jtaTrunk.setText("");
		jtfAttitude.setText("");
		jtfCardiac.setText("");
		jtfPression.setText("");
		jtfRespiratory.setText("");
		jtfTemp.setText("");
		jtfTemperature.setText("");
		jtfWeight.setText("");
	}
	
	public boolean fieldsTPRAreEmpty() {
		JTextField[] fields = {jtfTemperature, jtfPression, jtfCardiac, jtfRespiratory};
		return UtilityClass.fieldsAreEmpty(fields);
	}
	
	public boolean fieldsEreEmpty() {
		JTextField[] fields = {jtfWeight, jtfTemp, jtfAttitude};
		return UtilityClass.fieldsAreEmpty(fields);
	}

	public JTextArea getJtaDiagnostic() {
		return jtaDiagnostic;
	}

	public JTextField getJtfWeight() {
		return jtfWeight;
	}

	public JTextField getJtfTemperature() {
		return jtfTemperature;
	}

	public JTextField getJtfPression() {
		return jtfPression;
	}

	public JTextField getJtfCardiac() {
		return jtfCardiac;
	}

	public JTextField getJtfRespiratory() {
		return jtfRespiratory;
	}

	public JPanelBody getjPanelBody() {
		return jPanelBody;
	}

	public int getIdExamTPR() {
		return idExamTPR;
	}

	public int getIdExamECOP() {
		return idExamECOP;
	}
	
}
