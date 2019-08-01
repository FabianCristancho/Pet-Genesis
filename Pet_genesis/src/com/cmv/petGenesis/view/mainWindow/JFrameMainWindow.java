package com.cmv.petGenesis.view.mainWindow;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.cmv.petGenesis.controller.ControlMainWindow;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;

public class JFrameMainWindow extends JFrame{
	
	private JPanelMainWindow jPanelMainWindow;
	private User user;
	
	public JFrameMainWindow(User user) {
		super();
		this.jPanelMainWindow = new JPanelMainWindow(user);
		this.user = user;
		ControlMainWindow.getInstance().setjFrameMainWindow(this);
		init();
	}

	private void init() {
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(jPanelMainWindow);
		this.setVisible(true);
	}

	public User getUser() {
		return user;
	}
}
