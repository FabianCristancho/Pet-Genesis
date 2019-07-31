package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.historyManagement.JPanelDataPet;

/**
 * Clase JDialogNewPet - 
 *
 * @version 1.0 - 31/07/2019
 * @author 
 */
public class JDialogNewPet extends JDialog {
	
	private JPanelDataPetClient jPanelDataPet;
	private JButton okButton;
	private JButton returnButton;
	private JPanel jPanelButtons;
	private String idPropietary;
	
	/**
	 * Constructor 
	 */
	public JDialogNewPet(String idPropietary) {
		super();
		this.jPanelDataPet = new JPanelDataPetClient();
		this.okButton = new JButton(ConstantView.BUTTON_REGISTER_HISTORY);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelButtons = new JPanel();
		this.idPropietary = idPropietary;
		ControlClient.getInstance().setjDialogNewPet(this);
		init();
	}
	
	private void init() {
		this.setSize(1100, 650);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.add(jPanelDataPet, BorderLayout.CENTER);
		this.createButtons();
		
		jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
		jPanelDataPet.jPanelFormDataPet.jtfPropietary.setText(idPropietary);
		
		this.setVisible(true);
	}
	
	private void createButtons() {
		this.jPanelButtons = new JPanel(new GridBagLayout());
		this.jPanelButtons.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.jPanelButtons.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 30, 0);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.returnButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.returnButton.setForeground(Color.WHITE);
		this.returnButton.setFocusable(false);
		this.returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.returnButton.setFont(ConstantView.FONT_LABELS_LOGIN);
		this.jPanelButtons.add(returnButton, gbc);

		gbc.gridx = 7;
		this.okButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.okButton.setForeground(Color.WHITE);
		this.okButton.setFocusable(false);
		this.okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.okButton.setFont(ConstantView.FONT_LABELS_LOGIN);
		UtilityClass.addCommandJButton(okButton, ClientCommands.CMD_T_ADD_PET.toString(),
				ControlClient.getInstance());
		this.jPanelButtons.add(okButton, gbc);
		
		this.add(jPanelButtons, BorderLayout.SOUTH);
	}
	
	public void registerHistory(Pet p) {
		SQLPets sqlPets = new SQLPets();
		if (jPanelDataPet.fieldsAreEmpty()) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {
			SQLPeople sqlPeople = new SQLPeople();
			boolean validClient = false;
			if (jPanelDataPet.getComboParameter().getSelectedIndex() == 0) {
				if (!sqlPeople.existClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con codigo " + jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText())));
					validClient = true;
				}
			} else {
				if (!sqlPeople.existDocumentIdClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con documento "
									+ jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(
							sqlPeople.getIdByPersonalId(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))));
					validClient = true;
				}
			}
			if (validClient) {
				p.setNamePet(jPanelDataPet.getJtfNamePet().getText());
				p.setBirthDate(jPanelDataPet.getBirthDatePet().getDate());
				p.setRace(new Race(jPanelDataPet.getComboRaces().getSelectedIndex() + 1));
				p.setColorPet(jPanelDataPet.getJtfColorPet().getText());
				p.setGenderPet(GenderPet.getGender(jPanelDataPet.maleIsSelected()));
				p.setStatePet(StatePet.getState(jPanelDataPet.getComboStatePet().getSelectedIndex()));
				p.setCastrated(jPanelDataPet.isCastrated());
				p.setAditionalDescription(jPanelDataPet.getComments());
				if (sqlPets.registerPet(p)) {
					JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
					this.jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
					this.jPanelDataPet.newForm();
				} else {
					JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
				}
			}
		}
	}
	
	/**
	 * Obtiene 
	 * @return jPanelDataPet
	 */
	public JPanelDataPetClient getjPanelDataPet() {
		return jPanelDataPet;
	}

}
