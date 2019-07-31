package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.model.User;

public class JFrameHistory extends JFrame{
	
	private JPanelGroupHistory jpanelGroupHistory;
	private JPanelOptionHistory jPanelOptionHistory;
	
	public JFrameHistory(User user) {
		super();
		this.jPanelOptionHistory = new JPanelOptionHistory();
		this.jpanelGroupHistory = new JPanelGroupHistory(user);
		init();
	}

	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(jPanelOptionHistory, BorderLayout.WEST);
		this.add(jpanelGroupHistory, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
