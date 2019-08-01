package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.historyManagement.JPanelComments;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelDataPetClient - Se encarga de unir los comentarios y el formulario en un panel
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelDataPetClient extends JPanel {

	protected JPanelFormDataPetClient jPanelFormDataPet;
	private JPanelComments jPanelComments;

	/**
	 * Constructor
	 */
	public JPanelDataPetClient() {
		super(new BorderLayout());
		this.jPanelFormDataPet = new JPanelFormDataPetClient();
		this.jPanelComments = new JPanelComments();
		init();
	}

	/**
	 * Inicializa los componentes
	 */
	private void init() {
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 20));
		this.add(jPanelFormDataPet, BorderLayout.WEST);
		this.jPanelComments.setOpaque(false);
		this.add(jPanelComments, BorderLayout.EAST);
	}

	/**
	 * Obtiene el formulario
	 * @return jPanelFormDataPet jpanel
	 */
	public JPanelFormDataPetClient getjPanelFormDataPet() {
		return jPanelFormDataPet;
	}
	
	/**
	 * Obtiene el campo del propietario
	 * @return jtfPropietary text
	 */
	public CustomTxtField getJtfPropietary() {
		return jPanelFormDataPet.jtfPropietary;
	}
	
	/**
	 * Obtiene el nombre
	 * @return jtfPetName text
	 */
	public CustomTxtField getJtfNamePet() {
		return jPanelFormDataPet.jtfPetName;
	}
	
	/**
	 * Obtiene el color de la mascota
	 * @return jtfColor text
	 */
	public CustomTxtField getJtfColorPet() {
		return jPanelFormDataPet.jtfColor;
	}
	
	/**
	 * Obtiene le combo de especies
	 * @return comboSpecies comobox
	 */
	public JComboBox<String> getComboSpecies(){
		return jPanelFormDataPet.comboSpecies;
	}
	
	/**
	 * Obtiene el combo de razas
	 * @return comboRaces combobox
	 */
	public JComboBox<String> getComboRaces(){
		return jPanelFormDataPet.comboRaces;
	}
	
	/**
	 * Verifica que el male este selecionado
	 * @return true -false
	 */
	public boolean maleIsSelected() {
		return jPanelFormDataPet.jRButtonMale.isSelected();
	}
	
	/**
	 * Verifica si el iscatred está seleccionado
	 * @return true -false
	 */
	public boolean isCastrated() {
		return jPanelFormDataPet.isCastrated.isSelected();
	}
	
	/**
	 * Obtien el parámetro
	 * @return comboParameter combobox
	 */
	public JComboBox<String> getComboParameter(){
		return jPanelFormDataPet.comboParameter;
	}
	
	/**
	 * Obtiene las razas
	 */
	public void changeRaces() {
		jPanelFormDataPet.changeRaces();
	}
	
	/**
	 * Obtiene el combo de estados
	 * @return comboStateHistory combobox
	 */
	public JComboBox<String> getComboStatePet(){
		return jPanelFormDataPet.comboStateHistory;
	}
	
	/**
	 * Obtiene la fecha de nacimeinto
	 * @return birthDate fecha
	 */
	public JDateChooser getBirthDatePet() {
		return jPanelFormDataPet.birthDate;
	}
	
	/**
	 * Verifica los campos vacio
	 * @return true - false
	 */
	public boolean fieldsAreEmpty() {
		CustomTxtField[] textFields = {jPanelFormDataPet.jtfPetName, jPanelFormDataPet.jtfColor, jPanelFormDataPet.jtfPropietary};
		return UtilityClass.fieldsAreEmpty(textFields);
	}
	
	/**
	 * Crea un nuevo formulario
	 */
	public void newForm() {
		this.jPanelFormDataPet.newForm();
		this.jPanelComments.jtaComments.setText("");
	}
	
	/**
	 * Obtiene los comentario
	 * @return cadena s
	 */
	public String getComments() {
		return this.jPanelComments.getComments();
	}
}
