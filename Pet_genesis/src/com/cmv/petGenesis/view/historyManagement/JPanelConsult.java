package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLExam;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.ExamBody;
import com.cmv.petGenesis.model.ExamTPR;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.appointment.JPanelAppointment;
import com.cmv.petGenesis.view.appointment.JPanelExam;

/**
 * Clase JPanelConsult - Se encarga del manejo del panel de para las consultas
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelConsult extends JPanel{
	
	protected JPanelAppointment jPanelAppointment;
	protected JPanelExam jPanelExam;
	private JScrollPane jScrollPane;
	private JPanel jPanelRound, jPanelBtn;
	private JButton btnClearFields;
	
	/**
	 * Constructor del panel
	 */
	public JPanelConsult() {
		super(new BorderLayout());
		this.jPanelRound = new JPanel(new BorderLayout());
		this.jPanelAppointment = new JPanelAppointment();
		this.jPanelExam = new JPanelExam();
		this.jScrollPane = new JScrollPane();
		this.jPanelBtn = new JPanel();
		this.btnClearFields = new JButton(ConstantView.BTN_CLEAR_FIELDS);
		ControlHistory.getInstance().setjPanelConsult(this);
		init();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.jPanelAppointment.createAutomaticId();
		this.add(jPanelAppointment, BorderLayout.NORTH);
		this.jPanelRound.setBorder(BorderFactory.createEmptyBorder(0, 10, 20, 10));
		this.jPanelRound.add(jPanelExam, BorderLayout.CENTER);
		this.btnClearFields.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnClearFields.setFocusable(false);
		this.jPanelBtn.add(btnClearFields);
		this.jPanelRound.add(jPanelBtn, BorderLayout.SOUTH);
		this.jScrollPane.setPreferredSize(new Dimension(1000, 100));
		this.jScrollPane.setViewportView(jPanelRound);
		this.add(jScrollPane, BorderLayout.CENTER);
		UtilityClass.addCommandJButton(btnClearFields, HistoryCommands.CMD_WD_EXAM_CLEAR_FIELDS.toString(),ControlHistory.getInstance());
	}
	
	/**
	 * Limipia los espacios del formulario
	 */
	public void clearFields() {
		this.jPanelExam.clearFields();
	}
	
	/**
	 * Obtiene el peso del campo
	 * @return jPanelExam text
	 */
	public JTextField getJtfWeight() {
		return jPanelExam.getJtfWeight();
	}

	/**
	 * Obtiene la temperatura del campo
	 * @return getJtfTemperature text
	 */
	public JTextField getJtfTemperature() {
		return jPanelExam.getJtfTemperature();
	}

	/**
	 * Obtiene la presión del campo
	 * @return getJtfPression text
	 */
	public JTextField getJtfPression() {
		return jPanelExam.getJtfPression();
	}

	/**
	 * Obtien la informacion cardiaca del campo
	 * @return getJtfCardiac text
	 */
	public JTextField getJtfCardiac() {
		return jPanelExam.getJtfCardiac();
	}

	/**
	 * Obtener la informacion de la respiración del campo
	 * @return getJtfRespiratory text
	 */
	public JTextField getJtfRespiratory() {
		return jPanelExam.getJtfRespiratory();
	}
}
