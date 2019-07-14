package com.cmv.petGenesis.views;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame{
	public MainWindow() {
		setTitle("Test1");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel l = new JLabel("TestLabel1");
		this.add(l);
		
		setVisible(true);
	}
}
