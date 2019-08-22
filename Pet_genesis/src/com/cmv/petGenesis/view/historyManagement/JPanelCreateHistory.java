package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLConsult;
import com.cmv.petGenesis.connection.SQLExam;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.connection.SQLRecet;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.Consult;
import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.model.ExamECOP;
import com.cmv.petGenesis.model.ExamTPR;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Medicament;
import com.cmv.petGenesis.model.Person;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.Recet;
import com.cmv.petGenesis.model.RegisterExam;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelCreateHistory - Se encarga de crear el panel para la creación de
 * la mascota y la historia
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelCreateHistory extends JPanel {

	private CustomLabel title;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelButtons;
	private JPanelRecet jPanelRecet;
	private JPanelDataPet jPanelDataPet;
	private JPanelConsult jPanelConsult;
	private JTabbedPane modules;
	private User user;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateHistory(User user) {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_WD_CREATE_HISTORY, null, Color.decode("#2E5569"));
		this.okButton = new JButton(ConstantView.BUTTON_REGISTER_HISTORY);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelRecet = new JPanelRecet();
		this.modules = new JTabbedPane();
		this.jPanelDataPet = new JPanelDataPet();
		this.jPanelConsult = new JPanelConsult();
		this.user = user;
		ControlHistory.getInstance().setjPanelCreateHistory(this);
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		this.initModules();
		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 15, 20, 15);

		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);

		this.add(panelButtons, BorderLayout.SOUTH);
		this.add(modules, BorderLayout.CENTER);

		this.jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
	}

	/**
	 * Inicializa los botones del panel del formulario
	 */
	private void initPanelButtons() {
		this.panelButtons = new JPanel(new GridBagLayout());
		this.panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.panelButtons.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.returnButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.returnButton.setForeground(Color.WHITE);
		this.returnButton.setFocusable(false);
		this.returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.returnButton.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		this.panelButtons.add(returnButton, gbc);

		gbc.gridx = 7;
		this.okButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.okButton.setForeground(Color.WHITE);
		this.okButton.setFocusable(false);
		this.okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.okButton.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		UtilityClass.addCommandJButton(okButton, HistoryCommands.CMD_WD_PET_REGISTER_HIS.toString(),
				ControlHistory.getInstance());
		this.panelButtons.add(okButton, gbc);
	}

	/**
	 * Inicializa los modulos
	 */
	private void initModules() {
		this.modules.add(ConstantView.TABBED_DATA_PET, jPanelDataPet);
		this.modules.add(ConstantView.TABBED_APPOINT_PET, jPanelConsult);
		this.modules.add(ConstantView.TABBED_MEDICINE_PET, jPanelRecet);
	}

	/**
	 * Obtiene el campo del propietario
	 * 
	 * @return getJtfPropietary text
	 */
	public CustomTxtField getJtfPropietary() {
		return this.jPanelDataPet.getJtfPropietary();
	}

	/**
	 * Obtiene el nombre de la mascota
	 * 
	 * @return getJtfNamePet text
	 */
	public CustomTxtField getJtfNamePet() {
		return this.jPanelDataPet.getJtfNamePet();
	}

	/**
	 * Obtiene el color de la masta del campo
	 * 
	 * @return getJtfColorPet text
	 */
	public CustomTxtField getJtfColorPet() {
		return this.jPanelDataPet.getJtfColorPet();
	}

	/**
	 * Obtien el combo de especies
	 * 
	 * @return getComboSpecies combobox
	 */
	public JComboBox<String> getComboSpecies() {
		return jPanelDataPet.getComboSpecies();
	}

	/**
	 * Actualiza el valor de la raza del combobox dependiendo de la especie
	 */
	public void changeRaces() {
		jPanelDataPet.changeRaces();
	}

	/**
	 * Registra la historia clinica
	 * 
	 * @param p mascota
	 */
	public void registerHistory(Pet p) {
		SQLPets sqlPets = new SQLPets();
		if (jPanelDataPet.fieldsAreEmpty()) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {
			SQLPeople sqlPeople = new SQLPeople();
			boolean validClient = false;
			if (jPanelDataPet.getComboParameter().getSelectedIndex() == 0) {
				if (!sqlPeople.existClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con codigo " + jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText())));
					validClient = true;
				}
			} else {
				if (!sqlPeople.existDocumentIdClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con documento "
									+ jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(
							sqlPeople.getIdByPersonalId(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))));
					validClient = true;
				}
			}
			if (validClient) {
				p.setNamePet(jPanelDataPet.getJtfNamePet().getText());
				p.setBirthDate(jPanelDataPet.getBirthDatePet().getDate());
				p.setRace(new Race(sqlPets.getIdPetByRace(jPanelDataPet.getComboRaces().getSelectedItem().toString())));
				p.setColorPet(jPanelDataPet.getJtfColorPet().getText());
				p.setGenderPet(GenderPet.getGender(jPanelDataPet.maleIsSelected()));
				p.setStatePet(StatePet.getState(jPanelDataPet.getComboStatePet().getSelectedIndex()));
				p.setCastrated(jPanelDataPet.isCastrated());
				p.setAditionalDescription(jPanelDataPet.getComments());
				if (sqlPets.registerPet(p)) {
					JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
				} else {
					JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
				}
			}
		}
	}

	/**
	 * Guarda los valores de la consulta
	 * 
	 * @param consult consulta
	 */
	public void saveConsult(Consult consult) {
		SQLConsult sqlConsult = new SQLConsult();
		consult.setPet(new Pet(Integer.parseInt(jPanelDataPet.jPanelFormDataPet.lblResultId.getText())));
		consult.setPerson(new Person(user.getIdPerson()));
		consult.setMotiveConsult(jPanelConsult.jPanelAppointment.getJtaMotive().getText());

		consult.setDateConsult(jPanelConsult.jPanelAppointment.getJdcDate().getDate());
		if (!sqlConsult.registerConsult(consult)) {
			JOptionPane.showMessageDialog(null, "Error al guardar la consulta", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
			this.jPanelDataPet.newForm();
		}
	}

	/**
	 * Guarda los datos del examen tpr
	 * 
	 * @param registerExam examen a registrar
	 */
	public void saveExamTPR() {
		SQLExam sqlExam = new SQLExam();

		if (!sqlExam.registerExamTPR(jPanelConsult.jPanelExam.getResultExamTPR()))
			JOptionPane.showMessageDialog(null, "Error al guardar el examen TPR", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Guarda los datos del examen Ecop
	 * 
	 * @param registerExam datos a guardar
	 */
	public void saveExamEcop() {
		SQLExam sqlExam = new SQLExam();
		if (!sqlExam.registerExamECOP(jPanelConsult.jPanelExam.getResultExamEcop()))
			JOptionPane.showMessageDialog(null, "Error al guardar el examen ECOP", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
	}
	
	public void saveExamBody() {
		SQLExam sqlExam = new SQLExam();
		if (!sqlExam.registerExamBody(jPanelConsult.jPanelExam.getResultExamBody()))
			JOptionPane.showMessageDialog(null, "Error al guardar el examen de cuerpo", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
	}
	
	public void saveRegisterExam(RegisterExam registerExam) {
		SQLExam sqlExam = new SQLExam();
		
		registerExam.setConsult(new Consult(Integer.parseInt(jPanelConsult.jPanelAppointment.getLblResultId().getText())));
		registerExam.setExamTPR(new ExamTPR(jPanelConsult.jPanelExam.getIdExamTPR()));
		registerExam.setExamECOP(new ExamECOP(jPanelConsult.jPanelExam.getIdExamECOP()));
		registerExam.setExamBody(new ExamBody(jPanelConsult.jPanelExam.getjPanelBody().getIdExamBody()));
		registerExam.setDiagnosticExam(jPanelConsult.jPanelExam.getJtaDiagnostic().getText());
	
		if(!sqlExam.registerExam(registerExam))
			JOptionPane.showMessageDialog(null, "Error al guardar el registro de los examenes", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Guardar la inofrmación de la receta
	 * 
	 * @param recet receta
	 */
	public void saveRecet(Recet recet) {
		SQLRecet sqlRecet = new SQLRecet();
		if (!jPanelRecet.valuesAreEmpty()) {
			recet.setConsult(new Consult(Integer.parseInt(jPanelConsult.jPanelAppointment.getLblResultId().getText())));
			recet.setMedicament(new Medicament(jPanelRecet.comboMedicaments.getSelectedIndex() + 1));
			recet.setDosis(jPanelRecet.jtfDosis.getText());
			recet.setFrecuency(jPanelRecet.jtfFrecuency.getText());
			if (!sqlRecet.registerRecet(recet))
				JOptionPane.showMessageDialog(null, "Error al guardar la receta", "ERROR TYPE",
						JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Obtiene el campo del peso
	 * 
	 * @return getJtfWeight text
	 */
	public JTextField getJtfWeight() {
		return jPanelConsult.getJtfWeight();
	}

	/**
	 * Obtiene el campo de la temperatura
	 * 
	 * @return getJtfTemperature text
	 */
	public JTextField getJtfTemperature() {
		return jPanelConsult.getJtfTemperature();
	}

	/**
	 * Obtiene el campo de la presión
	 * 
	 * @return getJtfPression text
	 */
	public JTextField getJtfPression() {
		return jPanelConsult.getJtfPression();
	}

	/**
	 * Obtiene el campo de la infromación cardiaca
	 * 
	 * @return getJtfCardiac text
	 */
	public JTextField getJtfCardiac() {
		return jPanelConsult.getJtfCardiac();
	}

	/**
	 * Obtiene el campo de la información de la respiración
	 * 
	 * @return getJtfRespiratory text
	 */
	public JTextField getJtfRespiratory() {
		return jPanelConsult.getJtfRespiratory();
	}
}
