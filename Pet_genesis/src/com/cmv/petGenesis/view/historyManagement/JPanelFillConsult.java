package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
public class JPanelFillConsult extends JPanel {

	private JPanelRecet jPanelRecet;
	private JPanelConsult jPanelConsult;
	private JTabbedPane modules;
	private User user;
	protected int idPet;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelFillConsult(User user) {
		super();
		this.jPanelRecet = new JPanelRecet();
		this.modules = new JTabbedPane();
		this.jPanelConsult = new JPanelConsult();
		this.user = user;
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		this.initModules();
		this.add(modules);
	}


	/**
	 * Inicializa los modulos
	 */
	private void initModules() {
		this.modules.add(ConstantView.TABBED_APPOINT_PET, jPanelConsult);
		this.modules.add(ConstantView.TABBED_MEDICINE_PET, jPanelRecet);
	}

	/**
	 * Guarda los valores de la consulta
	 * 
	 * @param consult consulta
	 */
	public void saveConsult() {
		SQLConsult sqlConsult = new SQLConsult();
		Consult consult = new Consult();
		consult.setPet(new Pet(idPet));
		consult.setPerson(new Person(user.getIdPerson()));
		consult.setMotiveConsult(jPanelConsult.jPanelAppointment.getJtaMotive().getText());

		consult.setDateConsult(jPanelConsult.jPanelAppointment.getJdcDate().getDate());
		if (!sqlConsult.registerConsult(consult)) {
			JOptionPane.showMessageDialog(null, "Error al guardar la consulta", "ERROR TYPE",
					JOptionPane.ERROR_MESSAGE);
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
	
	public void saveRegisterExam() {
		SQLExam sqlExam = new SQLExam();
		RegisterExam registerExam = new RegisterExam();
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
	public void saveRecet() {
		SQLRecet sqlRecet = new SQLRecet();
		Recet recet = new Recet();
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
	
	public void saveAllConsultData() {
		saveConsult();
		saveExamTPR();
		saveExamEcop();
		saveExamBody();
		saveRegisterExam();
		saveRecet();
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
