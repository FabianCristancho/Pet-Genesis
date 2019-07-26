package com.cmv.petGenesis.view.appointment;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelPru extends JPanel{
	
	private JLabel jLabel;
	private JLabel jLabel2;
	
	public JPanelPru() {
		super(new GridBagLayout());
		this.jLabel = new JLabel("PRUEBA 1");
		this.jLabel2 = new JLabel("PRUEBA 2");
		INIT();
	}
	
	private void INIT() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		this.add(jLabel, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		this.add(jLabel2, gridBagConstraints);
		
	}
	
	public static void main(String[] args) {
		JPanelPru jPanelPru = new JPanelPru();
		JFrame jFrame = new JFrame();
		
		jFrame.setSize(500, 300);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.add(jPanelPru);
		jFrame.setVisible(true);
	}
	
	

}
