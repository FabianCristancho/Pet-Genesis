package com.cmv.petGenesis.view.historyManagement;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

import otherTests.Jpanel1;

public class JPanelFormDataPet extends JPanel{
	
	private CustomLabel lblTitleId, lblValueID, lblCreationDate, lblPetName, lblSpecies, lblRace, lblGender, lblBirthDate, lblCastrated, lblColor, lblWeight, lblBrands, lblPropietary;
	private JDateChooser creationDate, birthDate;
	private CustomTxtField jtfPetName, jtfRace, jtfColor, jtfWeight, jtfBrands, jtfPropietary;
	private JComboBox<String> comboSpecies;
	private JCheckBox isCastrated;
	private ButtonGroup groupGender;
	private JRadioButton jRButtonMale;
	private JRadioButton jRButtonFemale;
	private JPanel jPanelGender;
	private JButton btnFindPropietary;
	
	public JPanelFormDataPet() {
		super(new GridBagLayout());
		this.lblTitleId = new CustomLabel(ConstantView.LBL_TITLE_ID_HISTORY, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblValueID = new CustomLabel();
		this.lblCreationDate = new CustomLabel(ConstantView.LBL_CREATION_DATE, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblPetName = new CustomLabel(ConstantView.LBL_NAME_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblSpecies = new CustomLabel(ConstantView.LBL_SPECIES_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblRace = new CustomLabel(ConstantView.LBL_RACE_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblGender = new CustomLabel(ConstantView.LBL_GENDER_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblBirthDate = new CustomLabel(ConstantView.LBL_BDATE_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblCastrated = new CustomLabel(ConstantView.LBL_CASTRATED_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblColor = new CustomLabel(ConstantView.LBL_COLOR_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblWeight = new CustomLabel(ConstantView.LBL_WEIGHT_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblBrands = new CustomLabel(ConstantView.LBL_BRANDS_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblPropietary = new CustomLabel(ConstantView.LBL_PROPIETARY_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.comboSpecies = new JComboBox<>(ConstantView.COMBO_SPECIES);
		this.jRButtonMale = new JRadioButton(ConstantView.LBL_GENDER_MALE);
		this.jRButtonFemale = new JRadioButton(ConstantView.LBL_GENDER_FEMALE);
		this.creationDate = new JDateChooser();
		this.birthDate = new JDateChooser();
		this.jtfPetName = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.jtfRace = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.jtfColor = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.jtfWeight = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.jtfBrands = new CustomTxtField(30, ConstantView.FONT_FIELD_FORM);
		this.jtfPropietary = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.isCastrated = new JCheckBox(ConstantView.LBL_CASTRATED_PET);
		this.groupGender = new ButtonGroup();
		this.jPanelGender = new JPanel();
		this.btnFindPropietary = new JButton(ConstantView.BTN_FIND_PROPIETARY_PET);
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
		this.creationDate.setPreferredSize(new Dimension(100, 20));
		this.creationDate.setFont(ConstantView.FONT_FIELD_FORM);
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
		this.jRButtonMale.setFocusable(false);
		this.jRButtonFemale.setFocusable(false);
		this.groupGender.add(jRButtonMale);
		this.groupGender.add(jRButtonFemale);
		this.jRButtonMale.setSelected(true);
		this.jPanelGender.add(jRButtonMale);
		this.jPanelGender.add(jRButtonFemale);
		this.add(jPanelGender, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		this.add(lblBirthDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 6);
		this.birthDate.setPreferredSize(new Dimension(100, 20));
		this.birthDate.setFont(ConstantView.FONT_FIELD_FORM);
		this.add(birthDate, gbc);
			
		UtilityClass.organizeGridLayout(gbc, 2, 6);
		this.isCastrated.setFocusable(false);
		this.isCastrated.setFont(ConstantView.FONT_LABELS_LOGIN);
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
		
		gbc.insets.left = 0;
		UtilityClass.organizeGridLayout(gbc, 2, 9);
		this.btnFindPropietary.setFocusable(false);
		this.btnFindPropietary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnFindPropietary, gbc);
	}
	
	

}
