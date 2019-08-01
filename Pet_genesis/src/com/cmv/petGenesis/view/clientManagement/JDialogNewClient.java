package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;

import javax.swing.JDialog;

/**
 * Clase JDialogNewClient - Se encarga de crear un dialog con el formulario de crear un 
 * cliente
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
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
	
	/**
	 * Inicializa los componentes
	 */
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
	
	/**
	 * Aculta botones no necesarios
	 */
	private void hint() {
		jPanelCreateClient.getjPanelFormClient().lblPet.setVisible(false);
		jPanelCreateClient.getjPanelFormClient().addPetButton.setVisible(false);
	}
	
	/**
	 * Obtiene el panel
	 * @return jPanelCreateClient
	 */
	public JPanelCreateClient getjPanelCreateClient() {
		return jPanelCreateClient;
	}
	
}
