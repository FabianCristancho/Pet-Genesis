package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class JDialogNewClient extends JDialog {

	private JPanelCreateClient jPanelCreateClient;
	
	/**
	 * Constructor 
	 */
	public JDialogNewClient() {
		super();
		this.jPanelCreateClient = new JPanelCreateClient();
		
		this.init();
	}
	
	private void init() {
		this.setSize(900, 650);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(jPanelCreateClient);
		
		this.hint();
		
		this.setVisible(true);
	}
	
	private void hint() {
		jPanelCreateClient.getjPanelFormClient().lblPet.setVisible(false);
		jPanelCreateClient.getjPanelFormClient().addPetButton.setVisible(false);
	}
	
	/**
	 * Obtiene 
	 * @return jPanelCreateClient
	 */
	public JPanelCreateClient getjPanelCreateClient() {
		return jPanelCreateClient;
	}
	
}
