package com.cmv.petGenesis.view.historyManagement;

import java.awt.Dimension;

import javax.swing.JDialog;

import com.cmv.petGenesis.connection.SQLHistory;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.Pet;

public class JDialogWeight extends JDialog{
	
	private JPanelWeightControl jPanelWeightControl;
	private SQLHistory sqlHistory;
	private int idPet;
	
	public JDialogWeight(int idPet) {
		super();
		jPanelWeightControl = new JPanelWeightControl(idPet);
		sqlHistory = new SQLHistory();
		this.idPet = idPet;
		ControlHistory.getInstance().setjDialogWeight(this);
		init();
	}

	private void init() {
		Pet pet = sqlHistory.getBasicData(idPet);
		this.setTitle("Control Peso de " +pet.getNamePet());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(480, 300));
		this.setLocationRelativeTo(null);
		this.add(jPanelWeightControl);
		this.setVisible(true);
	}

}
