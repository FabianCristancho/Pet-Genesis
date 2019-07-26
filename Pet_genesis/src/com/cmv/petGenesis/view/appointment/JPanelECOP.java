package com.cmv.petGenesis.view.appointment;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

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

public class JPanelECOP extends JPanel{
	
	private JPanel jPanelEcop, jPanelTpr, jPanelBody;
	private JPanel jPanelAp, jPanelStool, jPanelWater, jPanelDiet, jPanelNail;
	private JPanel jPanelRoundTPR, jPanelRoundBody;
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
	
	public JPanelECOP() {
		super(new GridLayout());
		init();
	}
	
	private void init() {
		lblAttitude = new JLabel(ConstantView.LBL_EXAM_ATT);
		jtfAttitude = new JTextField(30);
		lblTemp = new JLabel(ConstantView.LBL_EXAM_TEMP);
		jtfTemp = new JTextField(30);
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
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(lblAttitude, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lblAppetite, gbc);
		
//		gbc.anchor = GridBagConstraints.WEST;
//		UtilityClass.organizeGridLayout(gbc, 0, 0);
//		add(lblAttitude, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 0, 1);
//		add(lblAppetite, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 0, 2);
//		add(checkVomit, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 0, 3);
//		add(lblDiet, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 1, 0);
//		add(jtfAttitude, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 1, 3);
//		jPanelDiet = new JPanel();
//		bgDiet.add(jrbDietMeat);
//		bgDiet.add(jrbDietCarb);
//		bgDiet.add(jrbDietVeg);
//		bgDiet.add(jrbOtherDiet);
//		jPanelDiet.add(jrbDietMeat);
//		jPanelDiet.add(jrbDietCarb);
//		jPanelDiet.add(jrbDietVeg);
//		add(jPanelDiet, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 1, 1);
//		jPanelAp = new JPanel();
//		bgAp.add(jrbApGood);
//		bgAp.add(jrbApRegular);
//		bgAp.add(jrbApNull);
//		jPanelAp.add(jrbApGood);
//		jPanelAp.add(jrbApRegular);
//		jPanelAp.add(jrbApNull);
//		add(jPanelAp, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 3, 0);
//		add(lblTemp, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 3, 1);
//		add(lblStool, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 3, 2);
//		add(lblWater, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 3, 3);
//		add(lblNails, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 4, 0);
//		add(jtfTemp, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 4, 1);
//		jPanelStool = new JPanel();
//		bgStool.add(jrbStNormal);
//		bgStool.add(jrbStDiarr);
//		bgStool.add(jrbConstip);
//		jPanelStool.add(jrbStNormal);
//		jPanelStool.add(jrbStDiarr);
//		jPanelStool.add(jrbConstip);
//		add(jPanelStool, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 4, 2);
//		jPanelWater = new JPanel();
//		bgWater.add(jrbWaterNormal);
//		bgWater.add(jrbWaterPolid);
//		bgWater.add(jrbWaterPoliu);
//		jPanelWater.add(jrbWaterNormal);
//		jPanelWater.add(jrbWaterPolid);
//		jPanelWater.add(jrbWaterPoliu);
//		add(jPanelWater, gbc);
//		
//		UtilityClass.organizeGridLayout(gbc, 4, 3);
//		jPanelNail = new JPanel();
//		bgNail.add(jrbNailNormal);
//		bgNail.add(jrbNailCut);
//		jPanelNail.add(jrbNailNormal);
//		jPanelNail.add(jrbNailCut);
//		add(jPanelNail, gbc);

	}

}
