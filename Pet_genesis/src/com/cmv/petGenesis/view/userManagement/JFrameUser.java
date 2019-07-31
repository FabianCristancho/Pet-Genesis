package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.controller.ControlUser;

public class JFrameUser extends JFrame{
	
	private JpanelGroupUser jpanelGroupClient;
	private JPanelOptionsUser jOptionsClient;
	
	public JFrameUser() {
		super();
		this.jOptionsClient = new JPanelOptionsUser();
		this.jpanelGroupClient = new JpanelGroupUser();
		ControlUser.getInstance().setjFrameUser(this);
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

	public JpanelGroupUser getJpanelGroupClient() {
		return jpanelGroupClient;
	}

	public JPanelOptionsUser getjOptionsClient() {
		return jOptionsClient;
	}
	
	public void setJCreateUser(JPanelCreateUser jPanelCreateUser) {
		this.jpanelGroupClient.setjCreateUser(jPanelCreateUser);
	}
}
