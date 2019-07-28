package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

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
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 20));
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
	
	public JComboBox<String> getComboSpecies(){
		return jPanelFormDataPet.comboSpecies;
	}
	
	public JComboBox<String> getComboRaces(){
		return jPanelFormDataPet.comboRaces;
	}
	
	public boolean maleIsSelected() {
		return jPanelFormDataPet.jRButtonMale.isSelected();
	}
	
	public boolean isCastrated() {
		return jPanelFormDataPet.isCastrated.isSelected();
	}
	
	public JComboBox<String> getComboParameter(){
		return jPanelFormDataPet.comboParameter;
	}
	
	public void changeRaces() {
		jPanelFormDataPet.changeRaces();
	}
	
	public JComboBox<String> getComboStatePet(){
		return jPanelFormDataPet.comboStateHistory;
	}
	
	public JDateChooser getBirthDatePet() {
		return jPanelFormDataPet.birthDate;
	}
	
	public boolean fieldsAreEmpty() {
		CustomTxtField[] textFields = {jPanelFormDataPet.jtfPetName, jPanelFormDataPet.jtfColor, jPanelFormDataPet.jtfPropietary};
		return UtilityClass.fieldsAreEmpty(textFields);
	}
	
	public void newForm() {
		this.jPanelFormDataPet.newForm();
		this.jPanelComments.jtaComments.setText("");
	}
	
	public String getComments() {
		return this.jPanelComments.getComments();
	}
}
