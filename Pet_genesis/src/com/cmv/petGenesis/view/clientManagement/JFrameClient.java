package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.controller.ControlClient;

/**
 * Clase JFrameClient - 
 *
 * @author Yohan Caro
 * @version 1.0 - 18/07/2019
 */
public class JFrameClient extends JFrame {
	
	private JpanelGroupClient jpanelGroupClient;
	private JPanelOptionsClient jOptionsClient;
	
	public JFrameClient() {
		super();
		this.jOptionsClient = new JPanelOptionsClient();
		this.jpanelGroupClient = new JpanelGroupClient();
		ControlClient.getInstance().setjFrameClient(this);
		init();
	}

	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(jOptionsClient, BorderLayout.WEST);
		this.add(jpanelGroupClient, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public JpanelGroupClient getJpanelGroupClient() {
		return jpanelGroupClient;
	}

	public JPanelOptionsClient getjOptionsClient() {
		return jOptionsClient;
	}
	
	public void setJCreateClient(JPanelCreateClient jPanelCreateClient) {
		this.jpanelGroupClient.setjCreateClient(jPanelCreateClient);
	}
	
}
