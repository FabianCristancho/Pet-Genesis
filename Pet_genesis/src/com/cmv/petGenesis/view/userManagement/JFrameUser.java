package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.controller.ControlUser;

/**
 * Clase JFrameUSer - Se encaraga de mostrar el modulo referente a la gestion de
 * usuarios
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class JFrameUser extends JFrame {

	private JpanelGroupUser jpanelGroupClient;
	private JPanelOptionsUser jOptionsClient;

	/**
	 * Constructor de la clase
	 */
	public JFrameUser() {
		super();
		this.jOptionsClient = new JPanelOptionsUser();
		this.jpanelGroupClient = new JpanelGroupUser();
		ControlUser.getInstance().setjFrameUser(this);
		init();
	}

	/**
	 * Inicializa los componentes y paneles con los que cuenta
	 */
	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(jOptionsClient, BorderLayout.WEST);
		this.add(jpanelGroupClient, BorderLayout.CENTER);
		this.setVisible(true);
	}

	/**
	 * Obtiene un objeto de la clase JPanelGroupUser
	 * 
	 * @return objeto jpanelGroupUSer
	 */
	public JpanelGroupUser getJpanelGroupClient() {
		return jpanelGroupClient;
	}

	/**
	 * Obtiene un objeto de la clase JPanelOptionsUser
	 * 
	 * @return objeto jOptionsClient
	 */
	public JPanelOptionsUser getjOptionsClient() {
		return jOptionsClient;
	}

	/**
	 * Asigna un objeto de la clase JPanelCreateUser al atributo correspondiente
	 * 
	 * @param jPanelCreateUser objeto
	 */
	public void setJCreateUser(JPanelCreateUser jPanelCreateUser) {
		this.jpanelGroupClient.setjCreateUser(jPanelCreateUser);
	}
}
