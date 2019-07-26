package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.cmv.petGenesis.view.appointment.JPanelAppointment;
import com.cmv.petGenesis.view.appointment.JPanelExam;


public class JPanelConsult extends JPanel{
	
	private JPanelAppointment jPanelAppointment;
	private JPanelExam jPanelExam;
	private JScrollPane jScrollPane;
	
	public JPanelConsult() {
		super(new BorderLayout());
		this.jPanelAppointment = new JPanelAppointment();
		this.jPanelExam = new JPanelExam();
		this.jScrollPane = new JScrollPane();
		init();
	}

	private void init() {
		this.add(jPanelAppointment, BorderLayout.NORTH);
		this.jScrollPane.setViewportView(jPanelExam);
		this.add(jScrollPane, BorderLayout.CENTER);
	}
	
	
	
	
}
