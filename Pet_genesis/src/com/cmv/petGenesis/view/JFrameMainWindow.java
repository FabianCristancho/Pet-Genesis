package com.cmv.petGenesis.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.cmv.petGenesis.model.Usuario;

public class JFrameMainWindow extends JFrame{
	
	private JPanelMainWindow jPanelMainWindow;
	
	
	public JFrameMainWindow(Usuario usuario) {
		super();
		this.jPanelMainWindow = new JPanelMainWindow(usuario);
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
}
