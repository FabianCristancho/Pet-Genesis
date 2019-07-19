package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class JPanelPrueba extends JPanel{
	
	private JPanelFormUser jPanelFormUser;
	
	public JPanelPrueba() {
		this.jPanelFormUser = new JPanelFormUser();
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		this.add(jPanelFormUser, BorderLayout.CENTER);
	}

}
