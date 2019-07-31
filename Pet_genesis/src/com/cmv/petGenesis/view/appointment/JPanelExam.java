package com.cmv.petGenesis.view.appointment;

import java.awt.BorderLayout;
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

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelExam extends JPanel {

	private JPanel jPanelEcop, jPanelTpr, jPanelBody, jPanelNorth, jPanelDiag, jPanelDown;
	private JPanel jPanelAp, jPanelStool, jPanelWater, jPanelDiet, jPanelNail;
	private JPanel jPanelRoundTPR, jPanelRoundBody, jPanelRoundEcop;
	private JLabel lblTitleRutinExam, lblWeigth, lblAppetite, lblStool, lblWater, lblDiet, lblNails, lblAttitude,
			lblTemperature, lblTemp, lblPression, lblCardiac, lblRespiratory, lblOralCavid, lblFace, lblTrunk,
			lblGenitals, lblExtremities, lblSnc;
	private JRadioButton jrbApGood, jrbApRegular, jrbApNull, jrbStNormal, jrbStDiarr, jrbConstip, jrbWaterNormal,
			jrbWaterPolid, jrbWaterPoliu, jrbDietMeat, jrbDietVeg, jrbDietCarb, jrbOtherDiet, jrbNailNormal, jrbNailCut;
	private JCheckBox checkVomit;
	private JTextArea jtaOralCavid, jtaFace, jtaTrunk, jtaGenitals, jtaExtremities, jtaSnc, jtaDiagnostic;
	private JScrollPane scOralCavid, scFace, scTrunk, scGenitals, scExtrem, scSnc, scDiagnostic;
	private JTextField jtfAttitude, jtfWeight, jtfTemp, jtfTemperature, jtfPression, jtfCardiac, jtfRespiratory;
	private ButtonGroup bgAp, bgStool, bgWater, bgDiet, bgNail;

	public JPanelExam() {
		super(new BorderLayout());
		this.jPanelEcop = new JPanel(new GridBagLayout());
		this.lblTitleRutinExam = new JLabel(ConstantView.LBL_TITLE_EXAM);
		this.lblTitleRutinExam.setFont(ConstantView.FONT_TITLE_EXAM);
		this.jPanelTpr = new JPanel(new GridBagLayout());
		this.jPanelBody = new JPanel(new GridBagLayout());
		this.jPanelNorth = new JPanel(new BorderLayout());
		this.jPanelDiag = new JPanel(new GridBagLayout());
		this.jPanelRoundTPR = new JPanel();
		this.jPanelRoundBody = new JPanel();
		this.jPanelRoundEcop = new JPanel();
		this.jPanelDown = new JPanel(new BorderLayout());
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
		bgDiet.add(jrbDietMeat);
		bgDiet.add(jrbDietCarb);
		bgDiet.add(jrbDietVeg);
		bgDiet.add(jrbOtherDiet);
		jPanelDiet.add(jrbDietMeat);
		jPanelDiet.add(jrbDietCarb);
		jPanelDiet.add(jrbDietVeg);
		jPanelEcop.add(jPanelDiet, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jPanelAp = new JPanel();
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

		gbc.insets.left = 5;
		UtilityClass.organizeGridLayout(gbc, 4, 0);
		jPanelEcop.add(jtfTemp, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 1);
		jPanelStool = new JPanel();
		bgStool.add(jrbStNormal);
		bgStool.add(jrbStDiarr);
		bgStool.add(jrbConstip);
		jPanelStool.add(jrbStNormal);
		jPanelStool.add(jrbStDiarr);
		jPanelStool.add(jrbConstip);
		jPanelEcop.add(jPanelStool, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 2);
		jPanelWater = new JPanel();
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
		jPanelTpr.add(jtfTemperature, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jPanelTpr.add(jtfPression, gbc);

		UtilityClass.organizeGridLayout(gbc, 5, 0);
		jPanelTpr.add(jtfCardiac, gbc);

		UtilityClass.organizeGridLayout(gbc, 7, 0);
		jPanelTpr.add(jtfRespiratory, gbc);
	}

	private void initPanelBody() {

		lblOralCavid = new JLabel(ConstantView.LBL_EXAM_CAVID);
		lblFace = new JLabel(ConstantView.LBL_EXAM_FACE);
		lblTrunk = new JLabel(ConstantView.LBL_EXAM_TRUNK);
		lblGenitals = new JLabel(ConstantView.LBL_EXAM_GEN);
		lblExtremities = new JLabel(ConstantView.LBL_EXAM_EXT);
		lblSnc = new JLabel(ConstantView.LBL_EXAM_SNC);
		jtaOralCavid = new JTextArea();
		scOralCavid = new JScrollPane();
		jtaFace = new JTextArea();
		scFace = new JScrollPane();
		jtaTrunk = new JTextArea();
		scTrunk = new JScrollPane();
		jtaGenitals = new JTextArea();
		scGenitals = new JScrollPane();
		jtaExtremities = new JTextArea();
		jtaDiagnostic = new JTextArea();
		scExtrem = new JScrollPane();
		jtaSnc = new JTextArea();
		scSnc = new JScrollPane();
		scDiagnostic = new JScrollPane();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 20, 0, 20));
		jPanelBody.add(lblOralCavid, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelBody.add(lblFace, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelBody.add(lblGenitals, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPanelBody.add(lblExtremities, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		jPanelBody.add(lblTrunk, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 3);
		jPanelBody.add(lblSnc, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2, new Insets(0, 20, 20, 20));
		jtaOralCavid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaOralCavid.setFont(ConstantView.FONT_TEXT_AREA);
		jtaOralCavid.setLineWrap(true);
		jtaOralCavid.setWrapStyleWord(true);
		scOralCavid.setViewportView(jtaOralCavid);
		scOralCavid.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scOralCavid, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4);
		jtaFace.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaFace.setFont(ConstantView.FONT_TEXT_AREA);
		jtaFace.setLineWrap(true);
		jtaFace.setWrapStyleWord(true);
		scFace.setViewportView(jtaFace);
		scFace.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scFace, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 2);
		jtaTrunk.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaTrunk.setFont(ConstantView.FONT_TEXT_AREA);
		jtaTrunk.setLineWrap(true);
		jtaTrunk.setWrapStyleWord(true);
		scTrunk.setViewportView(jtaTrunk);
		scTrunk.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scTrunk, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		jtaGenitals.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaGenitals.setFont(ConstantView.FONT_TEXT_AREA);
		jtaGenitals.setLineWrap(true);
		jtaGenitals.setWrapStyleWord(true);
		scGenitals.setViewportView(jtaGenitals);
		scGenitals.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scGenitals, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 4);
		jtaExtremities.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaExtremities.setFont(ConstantView.FONT_TEXT_AREA);
		jtaExtremities.setLineWrap(true);
		jtaExtremities.setWrapStyleWord(true);
		scExtrem.setViewportView(jtaExtremities);
		scExtrem.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scExtrem, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 4);
		jtaSnc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaSnc.setFont(ConstantView.FONT_TEXT_AREA);
		jtaSnc.setLineWrap(true);
		jtaSnc.setWrapStyleWord(true);
		scSnc.setViewportView(jtaSnc);
		scSnc.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scSnc, gbc);

	}

	private void initJPanelDown() {
		initPanelBody();
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
		jtaDiagnostic.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jtaDiagnostic.setFont(ConstantView.FONT_TEXT_AREA);
		jtaDiagnostic.setLineWrap(true);
		jtaDiagnostic.setWrapStyleWord(true);
		scDiagnostic.setViewportView(jtaDiagnostic);
		scDiagnostic.setPreferredSize(new Dimension(500, 100));
		jPanelDiag.add(scDiagnostic, gbc);
	}

	public String getResultExamTPR() {
		String result = "Temperatura: " + jtfTemperature.getText() + ",";
		result += "Presión: " + jtfPression.getText() + ",";
		result += "Frecuencia cardiaca: " + jtfCardiac.getText() + ",";
		result += "Frecuencia Respiratoria: " + jtfRespiratory.getText();
		return result;
	}

	public String getResultExamEcop() {
		String result = "Peso: " +jtfWeight.getText() +",";
		result+="Temperamento: " +jtfTemp.getText() +",";
		result+="Actitud: " +jtfAttitude.getText() +",";
		result+="Heces: " +UtilityClass.getSelection(bgStool).getText() +",";
		result+="Apetito: " +UtilityClass.getSelection(bgAp).getText() +",";
		result+="Consumo de agua: " +UtilityClass.getSelection(bgWater).getText() +",";
		result+="Dieta: " +UtilityClass.getSelection(bgDiet).getText() +",";
		result+="Uñas: " +UtilityClass.getSelection(bgNail).getText() +",";
		result+=checkVomit.isSelected()?"Paciente con vómito":"No presenta vómito";
		return result;
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

	public JTextArea getJtaDiagnostic() {
		return jtaDiagnostic;
	}
}
