package com.cmv.petGenesis.view.historyManagement;

import javax.swing.JFrame;

public class JFrameSeeHistory extends JFrame{
	
	private JPanelSeeHistory jPanelSeeHistory;
	
	public JFrameSeeHistory(int idPet) {
		super("HISTORIA CLÍNICA DE PACIENTE");
		this.jPanelSeeHistory = new JPanelSeeHistory(idPet);
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.add(jPanelSeeHistory);
		this.setVisible(true);
	}
}
