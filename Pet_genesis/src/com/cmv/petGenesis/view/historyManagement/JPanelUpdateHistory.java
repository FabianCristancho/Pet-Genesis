package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelUpdateHistory extends JPanel{
	
	private JLabel titlePanel;
	private JLabel idUser;
	private JLabel descriptionLabel;
	private JTextField jtfInputId;
	private JPanel jPanelUp;
	private JPanelDataPet jpanelCenter;
	private JPanel jPanelDown;
	private JButton btnSearchUser;
	private JButton btnReturn;
	private JButton btnUpdateUser;
	private JComboBox<String> parameters;
	private JScrollPane jScrollPane;
	private JPanel jPanelRegion;

	public JPanelUpdateHistory() {
		super();
		this.titlePanel = new JLabel(ConstantView.LABEL_TITLE_UPDATE_HISTORY);
		this.idUser = new JLabel();
		this.descriptionLabel = new JLabel(ConstantView.LABEL_DESCRIPTION_UPDATE_USER);
		this.btnSearchUser = new JButton(ConstantView.BTN_SEARCH_UPDATE_HISTORY);
		this.jtfInputId = new JTextField(20);
		this.jPanelUp = new JPanel();
		this.jpanelCenter = new JPanelDataPet();
		this.btnReturn = new JButton(ConstantView.BTN_RETURN_UPDATE_USER);
		this.btnUpdateUser = new JButton(ConstantView.BTN_DATA_UPDATE_USER);
		this.parameters = ConstantView.COMBO_PARAMS_UPDATE_USER;
		this.jScrollPane = new JScrollPane();
		this.jPanelRegion = new JPanel(new BorderLayout());
		ControlHistory.getInstance().setjPanelUpdateHistory(this);
		init();
	}

	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		initPanelUp();
		initpanelDown();
		UtilityClass.addBorder(this, 0, 10, 10, 0);
		this.jPanelRegion.setOpaque(false);
		this.jPanelRegion.add(jPanelUp, BorderLayout.NORTH);
		this.jpanelCenter.setBackground(Color.decode("#c5dfed"));
		this.jPanelRegion.add(jpanelCenter, BorderLayout.CENTER);
		this.jPanelRegion.add(jPanelDown, BorderLayout.SOUTH);
		this.jScrollPane.setViewportView(jPanelRegion);
		this.jScrollPane.getViewport().setBackground(Color.decode("#c5dfed"));
		this.jScrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.add(jScrollPane);
	}

	private void initPanelUp() {
		this.jPanelUp.setOpaque(false);
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridwidth = 4;
		UtilityClass.organizeGridLayout(gbc, 0, 0,  new Insets(20, 30, 0, 30));
		this.titlePanel.setForeground(Color.decode("#2E5569"));
		this.titlePanel.setFont(ConstantView.FONT_TITLE_CRUD);
		this.jPanelUp.add(titlePanel, gbc);

		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		gbc.anchor = GridBagConstraints.EAST;
		this.jPanelUp.add(descriptionLabel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.jPanelUp.add(parameters, gbc);

		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.jPanelUp.add(jtfInputId, gbc);

		gbc.gridx = 3;
		UtilityClass.addCommandJButton(btnSearchUser, HistoryCommands.CMD_BTN_SEARCH_CLIENT.toString(),
				ControlHistory.getInstance());
		this.btnSearchUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelUp.add(btnSearchUser, gbc);
	}

	private void initpanelDown() {
		this.jPanelDown = new JPanel(new GridBagLayout());
		this.jPanelDown.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.jPanelDown.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;
		
		this.btnReturn.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnReturn.setForeground(Color.WHITE);
		this.btnReturn.setFocusable(false);
		this.btnReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnReturn.setFont(ConstantView.FONT_LABELS_LOGIN);
		
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.jPanelDown.add(btnReturn, gbc);

		gbc.gridx = 7;
		gbc.insets.bottom = 10;
		UtilityClass.addCommandJButton(btnUpdateUser, HistoryCommands.CMD_BTN_KEEP_HISTORY.toString(),
				ControlHistory.getInstance());
		this.btnUpdateUser.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnUpdateUser.setForeground(Color.WHITE);
		this.btnUpdateUser.setFocusable(false);
		this.btnUpdateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnUpdateUser.setFont(ConstantView.FONT_LABELS_LOGIN);
		
		this.jPanelDown.add(btnUpdateUser, gbc);
	}

	public String getParam() {
		switch (parameters.getSelectedIndex()) {
		case 0:
			return "id_usuario";
		case 1:
			return "documento_usuario";
		case 2:
			return "usuario";
		default:
			return "";
		}
	}
	
	public JComboBox<String> getComboSpecies() {
		return this.jpanelCenter.getComboSpecies();
	}

	public void getDataQuery() {
		SQLPets sqlPets = new SQLPets();
		Pet pet = sqlPets.getDataPet(jtfInputId.getText());

		if (pet != null) {
			jpanelCenter.jPanelFormDataPet.isCastrated.setSelected(pet.isCastrated());
			jpanelCenter.jPanelFormDataPet.jtfPetName.setText(pet.getNamePet()); 
			jpanelCenter.jPanelFormDataPet.jtfColor.setText(pet.getColorPet());
			jpanelCenter.jPanelFormDataPet.birthDate.setDate(pet.getBirthDate());
			if (pet.getGenderPet().equals(GenderPet.MALE)) {
				jpanelCenter.jPanelFormDataPet.jRButtonMale.setSelected(true);
			} else {
				jpanelCenter.jPanelFormDataPet.jRButtonFemale.setSelected(true);
			}
			jpanelCenter.jPanelFormDataPet.comboStateHistory.setSelectedIndex(pet.getStatePet().getIdState());
			jpanelCenter.jPanelFormDataPet.jtfPropietary.setText("" +pet.getClient().getIdPerson());
		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE LA MASCOTA CONSULTADA");
		}
	}

	public void saveDataSignIn(Usuario mod) {
		
	}

	public void changeRaces() {
		this.jpanelCenter.changeRaces();
	}
}
