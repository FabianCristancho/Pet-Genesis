package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.controller.ControlClient;

/**
 * Clase JFrameClient - Se encarga de crear elframe principal de la vista del
 * cliente
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JFrameClient extends JFrame {
	
	private JpanelGroupClient jpanelGroupClient;
	private JPanelOptionsClient jOptionsClient;
	
	/**
	 * Constructor
	 */
	public JFrameClient() {
		super();
		this.jOptionsClient = new JPanelOptionsClient();
		this.jpanelGroupClient = new JpanelGroupClient();
		ControlClient.getInstance().setjFrameClient(this);
		init();
	}

	/**
	 * Inicializa los componentes
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
	 * Obtien el grupo de paneles
	 * @return jpanelGroupClient jpanel
	 */
	public JpanelGroupClient getJpanelGroupClient() {
		return jpanelGroupClient;
	}

	/**
	 * Obtiene el panel de botones de opciones
	 * @return jOptionsClient jpanel
	 */
	public JPanelOptionsClient getjOptionsClient() {
		return jOptionsClient;
	}
	
	/**
	 * Cambia el panel de crear un cliente
	 * @param jPanelCreateClient jpanel
	 */
	public void setJCreateClient(JPanelCreateClient jPanelCreateClient) {
		this.jpanelGroupClient.setjCreateClient(jPanelCreateClient);
	}
	
}
