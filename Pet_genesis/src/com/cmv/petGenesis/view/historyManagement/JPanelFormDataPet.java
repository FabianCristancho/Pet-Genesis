package com.cmv.petGenesis.view.historyManagement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

import otherTests.Jpanel1;

public class JPanelFormDataPet extends JPanel{
	
	private JLabel lblTitleId, lblValueID, lblCreationDate, lblPetName, lblSpecies, lblRace, lblGender, lblBirthDate, lblCastrated, lblColor, lblWeight, lblBrands, lblPropietary;
	private JDateChooser creationDate, birthDate;
	private JTextField jtfPetName, jtfRace, jtfColor, jtfWeight, jtfBrands, jtfPropietary;
	private JComboBox<String> comboSpecies;
	private JCheckBox isCastrated;
	private ButtonGroup groupGender;
	private JRadioButton jRButtonMale;
	private JRadioButton jRButtonFemale;
	private JPanel jPanelGender;
	
	public JPanelFormDataPet() {
		super(new GridBagLayout());
		this.lblTitleId = new JLabel(ConstantView.LBL_TITLE_ID_HISTORY);
		this.lblValueID = new JLabel();
		this.lblCreationDate = new JLabel(ConstantView.LBL_CREATION_DATE);
		this.lblPetName = new JLabel(ConstantView.LBL_NAME_PET);
		this.lblSpecies = new JLabel(ConstantView.LBL_SPECIES_PET);
		this.lblRace = new JLabel(ConstantView.LBL_RACE_PET);
		this.lblGender = new JLabel(ConstantView.LBL_GENDER_PET);
		this.lblBirthDate = new JLabel(ConstantView.LBL_BDATE_PET);
		this.lblCastrated = new JLabel(ConstantView.LBL_CASTRATED_PET);
		this.lblColor = new JLabel(ConstantView.LBL_COLOR_PET);
		this.lblWeight = new JLabel(ConstantView.LBL_WEIGHT_PET);
		this.lblBrands = new JLabel(ConstantView.LBL_BRANDS_PET);
		this.lblPropietary = new JLabel(ConstantView.LBL_PROPIETARY_PET);
		this.comboSpecies = new JComboBox<>(ConstantView.COMBO_SPECIES);
		this.jRButtonMale = new JRadioButton(ConstantView.LBL_GENDER_MALE);
		this.jRButtonFemale = new JRadioButton(ConstantView.LBL_GENDER_FEMALE);
		this.creationDate = new JDateChooser();
		this.birthDate = new JDateChooser();
		this.jtfPetName = new JTextField(10);
		this.jtfRace = new JTextField(10);
		this.jtfColor = new JTextField(10);
		this.jtfWeight = new JTextField(10);
		this.jtfBrands = new JTextField(30);
		this.jtfPropietary = new JTextField(10);
		this.isCastrated = new JCheckBox(ConstantView.LBL_CASTRATED_PET);
		this.groupGender = new ButtonGroup();
		this.jPanelGender = new JPanel();
		init();
	}

	private void init() {
		this.setBorder(BorderFactory.createTitledBorder(ConstantView.TITLE_PANEL_PET));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 10, 0, 10));
		this.add(lblTitleId, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.add(lblValueID, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.add(lblCreationDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.add(creationDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		this.add(lblPetName, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		this.add(jtfPetName, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 3);
		this.add(lblSpecies, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 3);
		this.add(comboSpecies, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		this.add(lblRace, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 4);
		this.add(jtfRace, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		this.add(lblGender, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		this.groupGender.add(jRButtonMale);
		this.groupGender.add(jRButtonFemale);
		this.jRButtonMale.setSelected(true);
		this.jPanelGender.add(jRButtonMale);
		this.jPanelGender.add(jRButtonFemale);
		this.add(jPanelGender, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		this.add(lblBirthDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		this.add(birthDate, gbc);
			
		UtilityClass.organizeGridLayout(gbc, 2, 6);
		this.add(isCastrated, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 7);
		this.add(lblColor, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 7);
		this.add(jtfColor, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 7);
		this.add(lblWeight, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 7);
		this.add(jtfWeight, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 8);
		this.add(lblBrands, gbc);
		
		gbc.gridwidth = 6;
		UtilityClass.organizeGridLayout(gbc, 1, 8);
		this.add(jtfBrands, gbc);
		
		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 9);
		this.add(lblPropietary, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 9);
		this.add(jtfPropietary, gbc);
	}
	
	

}
