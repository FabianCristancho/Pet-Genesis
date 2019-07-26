package com.cmv.petGenesis.view.appointment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelExam extends JPanel {

	private JPanel jPanelEcop, jPanelTpr, jPanelBody;
	private JPanel jPanelAp, jPanelStool, jPanelWater, jPanelDiet, jPanelNail;
	private JPanel jPanelRoundTPR, jPanelRoundBody, jPanelRoundEcop;
	private JLabel lblWeigth, lblAppetite, lblStool, lblWater, lblDiet, lblNails, lblAttitude, lblTemperature, lblTemp,
			lblPression, lblCardiac, lblRespiratory, lblOralCavid, lblFace, lblTrunk, lblGenitals, lblExtremities,
			lblSnc;
	private JRadioButton jrbApGood, jrbApRegular, jrbApNull, jrbStNormal, jrbStDiarr, jrbConstip, jrbWaterNormal,
			jrbWaterPolid, jrbWaterPoliu, jrbDietMeat, jrbDietVeg, jrbDietCarb, jrbOtherDiet,  jrbNailNormal, jrbNailCut;
	private JCheckBox checkVomit;
	private JTextArea jtaOralCavid, jtaFace, jtaTrunk, jtaGenitals, jtaExtremities, jtaSnc;
	private JScrollPane scOralCavid, scFace, scTrunk, scGenitals, scExtrem, scSnc;
	private JTextField jtfAttitude, jtfWeight, jtfTemp, jtfTemperature, jtfPression, jtfCardiac, jtfRespiratory;
	private ButtonGroup bgAp, bgStool, bgWater, bgDiet, bgNail;

	public JPanelExam() {
		super(new BorderLayout());
		this.jPanelEcop = new JPanel(new GridBagLayout());
		this.jPanelTpr = new JPanel(new GridBagLayout());
		this.jPanelBody = new JPanel(new GridBagLayout());
		this.jPanelRoundTPR = new JPanel();
		this.jPanelRoundBody = new JPanel();
		this.jPanelRoundEcop = new JPanel();
		init();
	}
	
	private void init() {
		initPanelEcop();
		initPanelTPR();
		initPanelBody();
		this.jPanelRoundTPR.setBorder(BorderFactory.createTitledBorder("TPF - TEMPERATURA, PRESIÓN, RESPIRACIÓN"));
		this.jPanelRoundTPR.add(jPanelTpr);
		this.add(jPanelRoundTPR, BorderLayout.NORTH);
		
		this.jPanelRoundBody.setBorder(BorderFactory.createTitledBorder("CUERPO"));
		this.jPanelRoundBody.add(jPanelBody);
		this.add(jPanelRoundBody, BorderLayout.CENTER);
		
		this.jPanelRoundEcop.setBorder(BorderFactory.createTitledBorder("ORIENTADO AL PROBLEMA"));
		this.jPanelRoundEcop.add(jPanelEcop);
		this.add(jPanelRoundEcop, BorderLayout.SOUTH);
	}

	private void initPanelEcop() {
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
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 20, 10, 20));
		jPanelEcop.add(lblAttitude, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		jPanelEcop.add(lblAppetite, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		jPanelEcop.add(checkVomit, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelEcop.add(lblDiet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
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
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelAp = new JPanel();
		bgAp.add(jrbApGood);
		bgAp.add(jrbApRegular);
		bgAp.add(jrbApNull);
		jPanelAp.add(jrbApGood);
		jPanelAp.add(jrbApRegular);
		jPanelAp.add(jrbApNull);
		jPanelEcop.add(jPanelAp, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jPanelEcop.add(lblTemp, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 1);
		jPanelEcop.add(lblStool, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 2);
		jPanelEcop.add(lblWater, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 3);
		jPanelEcop.add(lblNails, gbc);
		
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
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 20, 10, 20));
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
		lblWeigth = new JLabel(ConstantView.LBL_EXAM_WEIGHT);
		lblOralCavid = new JLabel(ConstantView.LBL_EXAM_CAVID);
		lblFace = new JLabel(ConstantView.LBL_EXAM_FACE);
		lblTrunk = new JLabel(ConstantView.LBL_EXAM_TRUNK);
		lblGenitals = new JLabel(ConstantView.LBL_EXAM_GEN);
		lblExtremities = new JLabel(ConstantView.LBL_EXAM_EXT);
		lblSnc = new JLabel(ConstantView.LBL_EXAM_SNC);
		
		jtfWeight = new JTextField(10);
		jtaOralCavid = new JTextArea();
		scOralCavid = new JScrollPane();
		jtaFace = new JTextArea();
		scFace = new JScrollPane();
		jtaTrunk = new JTextArea();
		scTrunk = new JScrollPane();
		jtaGenitals = new JTextArea();
		scGenitals = new JScrollPane();
		jtaExtremities = new JTextArea();
		scExtrem = new JScrollPane();
		jtaSnc = new JTextArea();
		scSnc = new JScrollPane();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 20, 0, 20));
		jPanelBody.add(lblWeigth, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		jPanelBody.add(jtfWeight, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 20, 0, 20));
		jPanelBody.add(lblOralCavid, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		jPanelBody.add(lblFace, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		jPanelBody.add(lblTrunk, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jPanelBody.add(lblGenitals, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		jPanelBody.add(lblExtremities, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		jPanelBody.add(lblSnc, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2, new Insets(0, 20, 0, 20));
		scOralCavid.setViewportView(jtaOralCavid);
		scOralCavid.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scOralCavid, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		scFace.setViewportView(jtaFace);
		scFace.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scFace, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		scTrunk.setViewportView(jtaTrunk);
		scTrunk.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scTrunk, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		scGenitals.setViewportView(jtaGenitals);
		scGenitals.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scGenitals, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		scExtrem.setViewportView(jtaExtremities);
		scExtrem.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scExtrem, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		scSnc.setViewportView(jtaSnc);
		scSnc.setPreferredSize(new Dimension(250, 70));
		jPanelBody.add(scSnc, gbc);
	}
}
