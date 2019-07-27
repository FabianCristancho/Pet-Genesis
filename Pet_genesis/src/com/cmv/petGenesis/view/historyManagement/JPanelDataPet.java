package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;

public class JPanelDataPet extends JPanel {

	private JPanelFormDataPet jPanelFormDataPet;
	private JPanelComments jPanelComments;

	public JPanelDataPet() {
		super(new BorderLayout());
		this.jPanelFormDataPet = new JPanelFormDataPet();
		this.jPanelComments = new JPanelComments();
		init();
	}

	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 40, 30));
		this.add(jPanelFormDataPet, BorderLayout.WEST);
		this.add(jPanelComments, BorderLayout.EAST);
	}

	public JPanelFormDataPet getjPanelFormDataPet() {
		return jPanelFormDataPet;
	}
	
	public CustomTxtField getJtfPropietary() {
		return jPanelFormDataPet.jtfPropietary;
	}
	
	public CustomTxtField getJtfNamePet() {
		return jPanelFormDataPet.jtfPetName;
	}
	
	public CustomTxtField getJtfColorPet() {
		return jPanelFormDataPet.jtfColor;
	}
}
