package com.cmv.petGenesis.view.userManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Clase JPanelFindUser, encargada mostrar el modulo de gestion de usuarios
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class JpanelGroupUser extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateUser jCreateUser;
	private JpanelUpdateUser jUpdateClient;
	private JpanelFindUser jFindUser;
	private JPanelInactivUser jPanelInactivUser;
	
	/**
	 * Constructor de la clase
	 */
	public JpanelGroupUser() {
		super();
		cardLayout = new CardLayout();
		jCreateUser = new JPanelCreateUser();
		jUpdateClient = new JpanelUpdateUser();
		jFindUser = new JpanelFindUser();
		jPanelInactivUser = new JPanelInactivUser();
		init();
	}

	/**
	 * Agrega los modulos de gestion de usuarios 
	 */
	private void init() {
		this.setLayout(cardLayout);
		this.add("Crear", jCreateUser);
		this.add("Modificar", jUpdateClient);
		this.add("Inactivar", jPanelInactivUser);
		this.add("Consultar", jFindUser);
		cardLayout.show(this, "Crear");
	}
	
	/**
	 * Muestra la ventana de registro de usuario
	 */
	public void showCreate() {
		this.cardLayout.show(this, "Crear");
		this.repaint();
	}
	
	/**
	 * Muestra la ventana de modificacion de usuario
	 */
	public void showUpdate() {
		this.cardLayout.show(this, "Modificar");
		this.repaint();
	}
	
	/**
	 * Muestra la ventana de consulta de usuario
	 */
	public void showFind() {
		this.cardLayout.show(this, "Consultar");
		this.jFindUser.loadAllData();
		this.repaint();
	}
	
	/**
	 * Muestra la ventana de estado de usuario
	 */
	public void showInactive() {
		this.cardLayout.show(this, "Inactivar");
	}
	
	/**
	 * Asigna un nuevo panel al atributo propio 
	 * @param jCreateClient atributo propio de la clase
	 */
	public void setjCreateUser(JPanelCreateUser jCreateClient) {
		this.jCreateUser = jCreateClient;
	}

}