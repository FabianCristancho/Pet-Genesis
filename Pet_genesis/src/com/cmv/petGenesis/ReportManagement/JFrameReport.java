package com.cmv.petGenesis.ReportManagement;

import javax.swing.JFrame;

public class JFrameReport extends JFrame{
	
	public JFrameReport() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(new JpanelReport());
		this.setVisible(true);
	}

}
