package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelDataPet - Se encarga de unir el panel de formulario y el de comentario de
 * las historias
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelDataPet extends JPanel {

	protected JPanelFormDataPet jPanelFormDataPet;
	private JPanelComments jPanelComments;

	/**
	 * Constructor
	 */
	public JPanelDataPet() {
		super(new BorderLayout());
		this.jPanelFormDataPet = new JPanelFormDataPet();
		this.jPanelComments = new JPanelComments();
		init();
	}

	/**
	 * Inicializa los paneles
	 */
	private void init() {
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 20));
		this.add(jPanelFormDataPet, BorderLayout.WEST);
		this.jPanelComments.setOpaque(false);
		this.add(jPanelComments, BorderLayout.EAST);
	}

	/**
	 * Obtiene el panel del formulario
	 * @return jPanelFormDataPet jpanel
	 */
	public JPanelFormDataPet getjPanelFormDataPet() {
		return jPanelFormDataPet;
	}
	
	/**
	 * Obtien el campo de propietario
	 * @return jtfPropietary text
	 */
	public CustomTxtField getJtfPropietary() {
		return jPanelFormDataPet.jtfPropietary;
	}
	
	/**
	 * Obtiene el campo del nombre de la mascota
	 * @return jtfPetName text
	 */
	public CustomTxtField getJtfNamePet() {
		return jPanelFormDataPet.jtfPetName;
	}
	
	/**
	 * Obtiene el campo del color
	 * @return jtfColor text
	 */
	public CustomTxtField getJtfColorPet() {
		return jPanelFormDataPet.jtfColor;
	}
	
	/**
	 * Obtiene el combo de especies
	 * @return comboSpecies combobox
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
	 * Verifica si el radiobutton de male está selecioando (es macho)
	 * @return true si sí - false si no
	 */
	public boolean maleIsSelected() {
		return jPanelFormDataPet.jRButtonMale.isSelected();
	}
	
	/**
	 * Verifica si el checkbox isCastrated de esta seleccioando
	 * @return true si sí - false no no
	 */
	public boolean isCastrated() {
		return jPanelFormDataPet.isCastrated.isSelected();
	}
	
	/**
	 * Obtiene el combo de parametros
	 * @return comboParameter combobox
	 */
	public JComboBox<String> getComboParameter(){
		return jPanelFormDataPet.comboParameter;
	}
	
	/**
	 * Actualiza el combo de las razas respecto a la especie
	 */
	public void changeRaces() {
		jPanelFormDataPet.changeRaces();
	}
	
	/**
	 * Obtiene el combo del estado de la mascota
	 * @return comboStateHistory combobox
	 */
	public JComboBox<String> getComboStatePet(){
		return jPanelFormDataPet.comboStateHistory;
	}
	
	/**
	 * Obtiene el datechooser fecha
	 * @return birthDate fecha
	 */
	public JDateChooser getBirthDatePet() {
		return jPanelFormDataPet.birthDate;
	}
	
	/**
	 * Verifica si los campos del fromulario estan vacios
	 * @return textFields texto
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
	 * Obtiene el id de la mascota
	 * @return lblResultId label del id
	 */
	public int getIdPet() {
		return Integer.parseInt(jPanelFormDataPet.lblResultId.getText());
	}
	
	/**
	 * Obtiene el campo de comentarios
	 * @return jPanelComments comentarios
	 */
	public String getComments() {
		return this.jPanelComments.getComments();
	}
}
