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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.controller.ControlUser;
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
		init();
	}

	private void init() {
		initPanelUp();
		initpanelDown();
//		UtilityClass.addBorder(this, 20, 20, 20, 20);
		this.jPanelRegion.add(jPanelUp, BorderLayout.NORTH);
		this.jPanelRegion.add(jpanelCenter, BorderLayout.CENTER);
		this.jPanelRegion.add(jPanelDown, BorderLayout.SOUTH);
		this.jScrollPane.setViewportView(jPanelRegion);
		this.jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.add(jScrollPane);
	}

	private void initPanelUp() {
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridwidth = 4;
		UtilityClass.organizeGridLayout(gbc, 0, 0,  new Insets(20, 30, 0, 30));
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

	public void getDataQuery() {
	}

	public void saveDataSignIn(Usuario mod) {
	}

	private int getRole(String role) {
		switch (role) {
		case "Gerente General":
			return 0;
		case "Médico":
			return 1;
		case "Asistente":
			return 2;
		case "Auxiliar":
			return 3;
		}
		return 0;
	}

	private boolean isActive(String state) {
		if (state.equals("Activo"))
			return true;
		return false;
	}
}
