package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

public class JPanelMedicine extends JPanel {

	private CustomLabel title, lblTypeVaccine, lblDateVaccine, lblAddCommentsVaccine, lblTypeAntiparasitary,
			lblNameAntiparasitary, lblDateAntiParasitary, lblCommentsAntiparasitary;
	private JPanel jPanelRegisterVaccines, jPanelRegisterAntiParasitary, jPanelFieldsVaccine, jPanelFieldsAnti,
			jPFieldCommentsVaccine, jPFieldCommentsAnti, jPanelSaveVac, jPanelSaveAnti;
	private JComboBox<String> comboNameVaccine, comboTypeAntiparasitary;
	private CustomTxtField jtfNameAntiparasitary;
	private JDateChooser jdcDateVaccine, jdcDateAntiParasitary;
	private JTextArea jtaCommmentsVaccine, jtaCommentsAntiparasitary;
	private JButton btnSaveVaccine, btnSaveAntiparasitary, btnClearVaccine, btnClearAnti;
	private JScrollPane scrollCommentsVaccine, scrollCommentsAntiparasitary;

	public JPanelMedicine() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_MEDICINE, ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblTypeVaccine = new CustomLabel(ConstantView.NAME_VACCINE_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblDateVaccine = new CustomLabel(ConstantView.DATE_APP_VACCINE_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblAddCommentsVaccine = new CustomLabel(ConstantView.ADD_COMMENTS_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblTypeAntiparasitary = new CustomLabel(ConstantView.TYPE_ANTIPARASITARY_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblNameAntiparasitary = new CustomLabel(ConstantView.NAME_ANTIPARASITARY_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblDateAntiParasitary = new CustomLabel(ConstantView.DATE_APP_ANTIPARASITARY_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblCommentsAntiparasitary = new CustomLabel(ConstantView.ADD_COMMENTS_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);

		this.btnSaveVaccine = new JButton(ConstantView.BTN_SAVE_VACCINE);
		this.btnSaveAntiparasitary = new JButton(ConstantView.BTN_SAVE_ANTIPARASITARY);
		this.btnClearAnti = new JButton(ConstantView.BTN_CLEAR_COMMENTS);
		this.btnClearVaccine = new JButton(ConstantView.BTN_CLEAR_COMMENTS);

		this.jPanelRegisterVaccines = new JPanel(new GridBagLayout());
		this.jPanelRegisterAntiParasitary = new JPanel(new GridBagLayout());
		this.jPanelFieldsVaccine = new JPanel(new BorderLayout());
		this.jPanelFieldsAnti = new JPanel(new BorderLayout());
		this.jPFieldCommentsVaccine = new JPanel(new GridBagLayout());
		this.jPFieldCommentsAnti = new JPanel(new GridBagLayout());
		this.jPanelSaveVac = new JPanel(new GridBagLayout());
		this.jPanelSaveAnti = new JPanel(new GridBagLayout());

		if(false) {
//			if (JPanelFormDataPet.comboSpecies.getSelectedIndex() == 0)
//				this.comboNameVaccine = new JComboBox<>(ConstantView.LIST_VACCINE_CAN);
//			else
//				this.comboNameVaccine = new JComboBox<>(ConstantView.LIST_VACCINE_FELINE);
		}

		this.comboTypeAntiparasitary = new JComboBox<>(ConstantView.TYPES_ANTIPARASITARY);

		this.jtfNameAntiparasitary = new CustomTxtField(12, ConstantView.FONT_FIELD_FORM, JTextField.LEFT);

		this.jdcDateVaccine = new JDateChooser();
		this.jdcDateAntiParasitary = new JDateChooser();

		this.scrollCommentsVaccine = new JScrollPane();
		this.scrollCommentsAntiparasitary = new JScrollPane();

		this.jtaCommmentsVaccine = new JTextArea();
		this.jtaCommentsAntiparasitary = new JTextArea();
		ControlHistory.getInstance().setjPanelMedicine(this);
		init();
	}

	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
		initJPanelVaccines();
		initJPanelAntiparasitary();
		initJPanelCommentsAnti();
		initJPanelCommentsVaccine();
		initButtonsSaveAnti();
		initButtonsSaveVaccine();

		this.jPanelFieldsVaccine.setBorder(BorderFactory.createTitledBorder(ConstantView.PANEL_VACCINES_MEDICINE));
		this.jPanelFieldsVaccine.add(jPanelRegisterVaccines, BorderLayout.WEST);
		this.jPanelFieldsVaccine.add(jPFieldCommentsVaccine, BorderLayout.EAST);
		this.jPanelFieldsVaccine.add(jPanelSaveVac, BorderLayout.SOUTH);

		this.jPanelFieldsAnti.setBorder(BorderFactory.createTitledBorder(ConstantView.PANEL_ANTIPARASITARY_MEDICINE));
		this.jPanelFieldsAnti.add(jPanelRegisterAntiParasitary, BorderLayout.WEST);
		this.jPanelFieldsAnti.add(jPFieldCommentsAnti, BorderLayout.EAST);
		this.jPanelFieldsAnti.add(jPanelSaveAnti, BorderLayout.SOUTH);

		this.add(jPanelFieldsVaccine, BorderLayout.NORTH);
		this.add(jPanelFieldsAnti, BorderLayout.SOUTH);
	}

	private void initJPanelVaccines() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(30, 20, 0, 20));
		this.jPanelRegisterVaccines.add(lblTypeVaccine, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jPanelRegisterVaccines.add(comboNameVaccine, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jPanelRegisterVaccines.add(lblDateVaccine, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jdcDateVaccine.setPreferredSize(new Dimension(100, 20));
		this.jPanelRegisterVaccines.add(jdcDateVaccine, gbc);
	}

	private void initJPanelCommentsVaccine() {
		GridBagConstraints gbc = new GridBagConstraints();
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.jPFieldCommentsVaccine.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 110));
		this.jPFieldCommentsVaccine.add(lblAddCommentsVaccine, gbc);

		gbc.gridwidth = 3;
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.scrollCommentsVaccine.setPreferredSize(new Dimension(300, 100));
		this.jtaCommmentsVaccine.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.scrollCommentsVaccine.setViewportView(jtaCommmentsVaccine);
		this.jPFieldCommentsVaccine.add(scrollCommentsVaccine, gbc);
	}

	private void initJPanelCommentsAnti() {
		GridBagConstraints gbc = new GridBagConstraints();
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.jPFieldCommentsAnti.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 100));
		this.jPFieldCommentsAnti.add(lblCommentsAntiparasitary, gbc);

		gbc.gridwidth = 3;
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.scrollCommentsAntiparasitary.setPreferredSize(new Dimension(300, 100));
		this.jtaCommentsAntiparasitary.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.scrollCommentsAntiparasitary.setViewportView(jtaCommentsAntiparasitary);
		this.jPFieldCommentsAnti.add(scrollCommentsAntiparasitary, gbc);
	}

	private void initButtonsSaveVaccine() {
		this.jPanelSaveVac.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		GridBagConstraints gbc = new GridBagConstraints();

		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(0, 20, 0, 20));
		this.btnSaveVaccine.setFocusable(false);
		this.btnSaveVaccine.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelSaveVac.add(btnSaveVaccine, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.btnClearVaccine.setFocusable(false);
		this.btnClearVaccine.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UtilityClass.addCommandJButton(btnClearVaccine, HistoryCommands.CMD_WD_MEDICINE_CLEAR_VAC.toString(), ControlHistory.getInstance());
		this.jPanelSaveVac.add(btnClearVaccine, gbc);
	}

	private void initButtonsSaveAnti() {
		this.jPanelSaveAnti.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		GridBagConstraints gbc = new GridBagConstraints();

		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(0, 20, 0, 20));
		this.btnSaveAntiparasitary.setFocusable(false);
		this.btnSaveAntiparasitary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelSaveAnti.add(btnSaveAntiparasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.btnClearAnti.setFocusable(false);
		this.btnClearAnti.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UtilityClass.addCommandJButton(btnClearAnti, HistoryCommands.CMD_WD_MEDICINE_CLEAR_ANTI.toString(), ControlHistory.getInstance());
		this.jPanelSaveAnti.add(btnClearAnti, gbc);
	}

	private void initJPanelAntiparasitary() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 20, 0, 20));
		this.jPanelRegisterAntiParasitary.add(lblTypeAntiparasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jPanelRegisterAntiParasitary.add(comboTypeAntiparasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jPanelRegisterAntiParasitary.add(lblNameAntiparasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jPanelRegisterAntiParasitary.add(jtfNameAntiparasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2);
		this.jPanelRegisterAntiParasitary.add(lblDateAntiParasitary, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		this.jdcDateAntiParasitary.setPreferredSize(new Dimension(100, 20));
		this.jPanelRegisterAntiParasitary.add(jdcDateAntiParasitary, gbc);
	}

	public void clearCommentsVaccine() {
		int option = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea limpiar el área de comentarios?\nLa acción no tendrá reversa", "LIMPIEZA DE ÁREA DE VACUNAS",
				JOptionPane.YES_NO_OPTION);
		if (option == 0)
			this.jtaCommmentsVaccine.setText("");
	}
	
	public void clearCommentsAnti() {
		int option = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea limpiar el área de comentarios?\nLa acción no tendrá reversa", "LIMPIEZA DE ÁREA DE ANTIPARASITARIO",
				JOptionPane.YES_NO_OPTION);
		if (option == 0)
			this.jtaCommentsAntiparasitary.setText("");
	}

}
