package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Se encarga de registrar una receta especifica y permite crear nuevos
 * medicamentos
 * 
 * @author Fabian Cristancho
 *
 */
public class JPanelMedicine extends JPanel {

	private CustomLabel lblSelectMedic, lblCreateMedic, lblTypeMedic, lblDosis, lblFrecuency;
	private JPanel jPanelSelectMedic, jPanelRegisterMedic, jPanelAux, jPanelMedic;
	private JComboBox<String> comboNameVaccine, comboTypeMedic;
	private CustomTxtField jtfDosis, jtfFrecuency, jtfNameMedic;
	private JButton btnSaveAntiparasitary;

	/**
	 * Constructor
	 */
	public JPanelMedicine() {
		super(new BorderLayout());
		this.lblSelectMedic = new CustomLabel(ConstantView.NAME_VACCINE_MEDICINE,
				ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblCreateMedic = new CustomLabel(ConstantView.LBL_NAME_MEDIC, ConstantView.FONT_LABELS_FORM_MEDICINE,
				null);
		this.lblTypeMedic = new CustomLabel(ConstantView.TYPE_MEDIC, ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblDosis = new CustomLabel(ConstantView.ADD_DOSIS, ConstantView.FONT_LABELS_FORM_MEDICINE, null);
		this.lblFrecuency = new CustomLabel(ConstantView.ADD_FRECUENCY, ConstantView.FONT_LABELS_FORM_MEDICINE, null);

		this.btnSaveAntiparasitary = new JButton(ConstantView.BTN_SAVE_MEDIC);

		this.jPanelSelectMedic = new JPanel(new GridBagLayout());
		this.jPanelRegisterMedic = new JPanel(new GridBagLayout());
		this.jPanelAux = new JPanel();
		this.jPanelMedic = new JPanel(new BorderLayout());

		this.comboTypeMedic = new JComboBox<>(ConstantView.TYPES_ANTIPARASITARY);

		this.jtfDosis = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM, JTextField.LEFT);
		this.jtfFrecuency = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM, JTextField.LEFT);
		this.jtfNameMedic = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM, JTextField.LEFT);

		ControlHistory.getInstance().setjPanelMedicine(this);

		String[] typeMedic = { "a", "b", "c", "d" };
		this.comboTypeMedic = new JComboBox<>(typeMedic);

		String[] vac = { "1", "2", "3" };
		this.comboNameVaccine = new JComboBox<>(vac);
		init();
	}

	/**
	 * Inicia los modulos del panel
	 */
	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
		initJPanelRecet();
		initJPanelCreateMedic();

		this.add(jPanelSelectMedic, BorderLayout.NORTH);
		this.add(jPanelMedic, BorderLayout.CENTER);
	}

	/**
	 * Inicia los componentes del panel de recetas
	 */
	private void initJPanelRecet() {
		GridBagConstraints gbc = new GridBagConstraints();

		this.jPanelSelectMedic.setBorder(BorderFactory.createTitledBorder(ConstantView.PANEL_VACCINES_MEDICINE));
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(30, 20, 20, 20));
		this.jPanelSelectMedic.add(lblSelectMedic, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jPanelSelectMedic.add(comboNameVaccine, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 0);
		this.jPanelSelectMedic.add(lblDosis, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 0);
		this.jPanelSelectMedic.add(jtfDosis, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jPanelSelectMedic.add(lblFrecuency, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jPanelSelectMedic.add(jtfFrecuency, gbc);
	}

	/**
	 * Inicia los componentes del panel de registro de medicamento
	 */
	private void initJPanelCreateMedic() {
		GridBagConstraints gbc = new GridBagConstraints();

		this.jPanelRegisterMedic
				.setBorder(BorderFactory.createTitledBorder(ConstantView.PANEL_ANTIPARASITARY_MEDICINE));
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 20, 20, 20));
		this.jPanelRegisterMedic.add(lblCreateMedic, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jPanelRegisterMedic.add(jtfNameMedic, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 0);
		this.jPanelRegisterMedic.add(lblTypeMedic, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 0);
		this.jPanelRegisterMedic.add(comboTypeMedic, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jPanelRegisterMedic.add(btnSaveAntiparasitary, gbc);

		jPanelMedic.add(jPanelRegisterMedic, BorderLayout.CENTER);
		jPanelAux.setBorder(BorderFactory.createEmptyBorder(60, 0, 60, 0));
		jPanelMedic.add(jPanelAux, BorderLayout.SOUTH);
	}
}
