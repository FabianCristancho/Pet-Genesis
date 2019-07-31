package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.appointment.JPanelAppointment;
import com.cmv.petGenesis.view.appointment.JPanelExam;

public class JPanelConsult extends JPanel{
	
	protected JPanelAppointment jPanelAppointment;
	protected JPanelExam jPanelExam;
	private JScrollPane jScrollPane;
	private JPanel jPanelRound, jPanelBtn;
	private JButton btnClearFields;
	
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
		this.jScrollPane.setViewportView(jPanelRound);
		this.add(jScrollPane, BorderLayout.CENTER);
		UtilityClass.addCommandJButton(btnClearFields, HistoryCommands.CMD_WD_EXAM_CLEAR_FIELDS.toString(),ControlHistory.getInstance());
	}
	
	public void clearFields() {
		this.jPanelExam.clearFields();
	}
	
	public JTextField getJtfWeight() {
		return jPanelExam.getJtfWeight();
	}

	public JTextField getJtfTemperature() {
		return jPanelExam.getJtfTemperature();
	}

	public JTextField getJtfPression() {
		return jPanelExam.getJtfPression();
	}

	public JTextField getJtfCardiac() {
		return jPanelExam.getJtfCardiac();
	}

	public JTextField getJtfRespiratory() {
		return jPanelExam.getJtfRespiratory();
	}
}
