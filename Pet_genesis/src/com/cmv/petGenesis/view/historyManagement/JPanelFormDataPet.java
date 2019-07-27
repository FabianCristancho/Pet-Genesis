package com.cmv.petGenesis.view.historyManagement;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

public class JPanelFormDataPet extends JPanel {

	private CustomLabel lblResultId, lblTitleId, lblPetName, lblSpecies, lblRace, lblGender, lblBirthDate,
			lblColor, lblPropietary, lblSearchBy;
	private JDateChooser birthDate;
	protected CustomTxtField jtfPetName, jtfColor, jtfPropietary;
	protected static JComboBox<String> comboSpecies, comboRaces, comboParameter;
	private JCheckBox isCastrated;
	private ButtonGroup groupGender;
	private JRadioButton jRButtonMale;
	private JRadioButton jRButtonFemale;
	private JPanel jPanelGender;
	private JButton btnFindPropietary;
	private SimpleDateFormat sdf;

	public JPanelFormDataPet() {
		super(new GridBagLayout());
		this.lblResultId = new CustomLabel("", ConstantView.FONT_FORM, null);
		this.lblTitleId = new CustomLabel(ConstantView.LBL_TITLE_ID_HISTORY, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblPetName = new CustomLabel(ConstantView.LBL_NAME_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblSpecies = new CustomLabel(ConstantView.LBL_SPECIES_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblRace = new CustomLabel(ConstantView.LBL_RACE_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblGender = new CustomLabel(ConstantView.LBL_GENDER_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblBirthDate = new CustomLabel(ConstantView.LBL_BDATE_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblColor = new CustomLabel(ConstantView.LBL_COLOR_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.lblPropietary = new CustomLabel(ConstantView.LBL_PROPIETARY_PET, ConstantView.FONT_LABELS_LOGIN, null);
		this.comboSpecies = new JComboBox<>(ConstantView.COMBO_SPECIES);
		this.jRButtonMale = new JRadioButton(ConstantView.LBL_GENDER_MALE);
		this.jRButtonFemale = new JRadioButton(ConstantView.LBL_GENDER_FEMALE);
		this.jtfPetName = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.comboRaces = new JComboBox<>();
		this.jtfColor = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.jtfPropietary = new CustomTxtField(10, ConstantView.FONT_FIELD_FORM);
		this.isCastrated = new JCheckBox(ConstantView.LBL_CASTRATED_PET);
		this.groupGender = new ButtonGroup();
		this.jPanelGender = new JPanel();
		this.btnFindPropietary = new JButton(ConstantView.BTN_FIND_PROPIETARY_PET);
		this.lblSearchBy = new CustomLabel(ConstantView.LBL_SEARCH_CLIENT_BY, ConstantView.FONT_LABELS_LOGIN, null);
		this.comboParameter = new JComboBox<>(ConstantView.COMBO_SEARCH_CLIENT);
		
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.birthDate = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		init();
	}

	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 10, 20, 10));
		this.add(lblTitleId, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.add(lblResultId, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		this.add(lblPetName, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		this.jtfPetName.addKeyListener(ControlHistory.getInstance());
		this.add(jtfPetName, gbc);

		gbc.insets.left = 50;
		gbc.insets.right = 0;
		UtilityClass.organizeGridLayout(gbc, 2, 3);
		this.add(lblGender, gbc);

		gbc.insets.left = 0;
		UtilityClass.organizeGridLayout(gbc, 3, 3);
		this.jRButtonMale.setFocusable(false);
		this.jRButtonFemale.setFocusable(false);
		this.groupGender.add(jRButtonMale);
		this.groupGender.add(jRButtonFemale);
		this.jRButtonMale.setSelected(true);
		this.jPanelGender.add(jRButtonMale);
		this.jPanelGender.add(jRButtonFemale);
		this.add(jPanelGender, gbc);

		gbc.insets.left = 10;
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		this.add(lblSpecies, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 6);
		this.add(comboSpecies, gbc);

		gbc.insets.left = 50;
		gbc.insets.right = 0;
		UtilityClass.organizeGridLayout(gbc, 2, 6);
		this.add(lblRace, gbc);

		gbc.insets.left = 0;
		UtilityClass.organizeGridLayout(gbc, 3, 6);
		this.add(comboRaces, gbc);

		gbc.insets.left = 10;
		UtilityClass.organizeGridLayout(gbc, 0, 5);
		this.add(lblBirthDate, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 5);
		this.birthDate.setPreferredSize(new Dimension(115, 35));
		this.birthDate.setFont(ConstantView.FONT_FIELD_FORM);
		this.birthDate.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.add(birthDate, gbc);

		gbc.insets.left = 50;
		UtilityClass.organizeGridLayout(gbc, 2, 7);
		this.isCastrated.setFocusable(false);
		this.isCastrated.setFont(ConstantView.FONT_LABELS_LOGIN);
		this.add(isCastrated, gbc);

		gbc.insets.left = 10;
		UtilityClass.organizeGridLayout(gbc, 0, 7);
		this.add(lblColor, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 7);
		this.jtfColor.addKeyListener(ControlHistory.getInstance());
		this.add(jtfColor, gbc);

		gbc.insets.top = 40;
		UtilityClass.organizeGridLayout(gbc, 0, 9);
		this.add(lblPropietary, gbc);

		gbc.insets.top = 0;
		UtilityClass.organizeGridLayout(gbc, 0, 10);
		this.add(lblSearchBy, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 10);
		this.add(comboParameter, gbc);
			
		gbc.insets.left = 20;
		UtilityClass.organizeGridLayout(gbc, 2, 10);
		this.jtfPropietary.addKeyListener(ControlHistory.getInstance());
		this.add(jtfPropietary, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 10);
		this.btnFindPropietary.setFocusable(false);
		this.btnFindPropietary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnFindPropietary, gbc);
	}

	public void createAutomaticID() {
		SQLPets sqlPets = new SQLPets();
		lblResultId.setText("" + (sqlPets.getLastIdPet() + 1));
	}
}
