package com.cmv.petGenesis.view.clientManagement;

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
import javax.swing.JTextField;

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JpanelUpdateClient - Se encarga de crear el panel para actualizar los datos de cliente
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JpanelUpdateClient extends JPanel {

	private JLabel titlePanel;
	private JLabel descriptionLabel;
	private JTextField jtfInputId;
	private JPanel jPanelUp;
	private JPanelFormClient jpanelCenter;
	private JPanel jPanelDown;
	private JButton btnSearchClient;
	private JButton btnReturn;
	private JButton btnUpdateClient;
	private JComboBox<String> parameters;
	private String oldpIdentification;
	private String oldTelephone;

	/**
	 * Constructor
	 */
	public JpanelUpdateClient() {
		super(new BorderLayout());
		this.titlePanel = new JLabel(ConstantView.LABEL_TITLE_UPDATE_CLIENT);
		this.descriptionLabel = new JLabel(ConstantView.LABEL_DESCRIPTION_UPDATE_CLIENT);
		this.btnSearchClient = new JButton(ConstantView.BTN_SEARCH_UPDATE_CLIENT);
		this.jtfInputId = new JTextField(20);
		this.jPanelUp = new JPanel();
		this.jpanelCenter = new JPanelFormClient();
		this.btnReturn = new JButton(ConstantView.BTN_RETURN_UPDATE_CLIENT);
		this.btnUpdateClient = new JButton(ConstantView.BTN_DATA_UPDATE_CLIENT);
		this.parameters = ConstantView.COMBO_PARAMS_UPDATE_CLIENT;
		ControlClient.getInstance().setJpanelUpdateClient(this);
		init();
	}

	/**
	 * Inicializa los componentes
	 */
	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		initPanelUp();
		initpanelDown();
		UtilityClass.addBorder(this, 20, 20, 20, 20);
		this.add(jPanelUp, BorderLayout.NORTH);
		this.add(jpanelCenter, BorderLayout.CENTER);
		this.add(jPanelDown, BorderLayout.SOUTH);
	}

	/**
	 * Inicializa el panel superior
	 */
	private void initPanelUp() {
		this.jPanelUp.setOpaque(false);
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridwidth = 4;
		this.titlePanel.setForeground(Color.decode("#2E5569"));
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
		UtilityClass.addCommandJButton(btnSearchClient, ClientCommands.CMD_WD_UPDATE_SEARCH.toString(),
				ControlClient.getInstance());
		this.btnSearchClient.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelUp.add(btnSearchClient, gbc);
	}

	/**
	 * Inicializa el panel inferior
	 */
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
		this.btnReturn.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		
		UtilityClass.addCommandJButton(btnReturn, ClientCommands.CMD_WD_UPDATE_RETURN.toString(),
				ControlClient.getInstance());
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.jPanelDown.add(btnReturn, gbc);

		gbc.gridx = 7;
		this.btnUpdateClient.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnUpdateClient.setForeground(Color.WHITE);
		this.btnUpdateClient.setFocusable(false);
		this.btnUpdateClient.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnUpdateClient.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		
		UtilityClass.addCommandJButton(btnUpdateClient, ClientCommands.CMD_WD_UPDATE_CHANGE_DATA.toString(),
				ControlClient.getInstance());
		this.jPanelDown.add(btnUpdateClient, gbc);
	}

	/**
	 * Obtiene el parametro de busqueda
	 * @return cadena s
	 */
	public String getParam() {
		switch (parameters.getSelectedIndex()) {
		case 0:
			return "id_persona";
		case 1:
			return "documento_identidad";
		default:
			return "";
		}
	}

	/**
	 * Obtiene los datos con la persona buscada y los pone en el formulario
	 */
	public void getDataQuery() {
		SQLPeople sqlPeople = new SQLPeople();
		Client client = sqlPeople.getDataClient(getParam(), jtfInputId.getText());

		if (client != null) {
			jpanelCenter.lblIdSet.setText("" + client.getIdPerson());
			jpanelCenter.jtfName.setText(client.getName());
			jpanelCenter.jtfLastName.setText(client.getLastName());
			jpanelCenter.jtfPhone.setText(client.getTelephone());

			if (!isActive(client.getActivationState().name())) {
				jpanelCenter.inactivRadioButton.setSelected(true);
			}

			jpanelCenter.jtfDoc.setText(client.getPersonalIdentification());
			jpanelCenter.jtfEmail.setText(client.getEmail());
			jpanelCenter.jtfAdress.setText(client.getAddress());
			this.oldTelephone = jpanelCenter.jtfPhone.getText();
			this.oldpIdentification = jpanelCenter.jtfDoc.getText();
		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE EL CLIENTE CONSULTADO");
		}
	}

	/**
	 * Actualiza los datos del formulario en el cliente
	 * @param client c
	 */
	public void saveDataSignIn(Client client) {
		SQLPeople sqlPeople = new SQLPeople();

		JTextField[] requiredFields = { jpanelCenter.jtfDoc, jpanelCenter.jtfName, jpanelCenter.jtfLastName,
				jpanelCenter.jtfPhone };
		
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {
			if (oldpIdentification.equals(jpanelCenter.jtfDoc.getText())
					|| sqlPeople.existDocumentId(Integer.parseInt(jpanelCenter.jtfDoc.getText()))) {

				if (oldTelephone.equals(jpanelCenter.jtfPhone.getText())
						|| sqlPeople.existPhone(jpanelCenter.jtfPhone.getText()) == 0) {

					if (UtilityClass.validateEmail(jpanelCenter.jtfEmail.getText())
							|| jpanelCenter.jtfEmail.getText().length() == 0) {

						client.setIdPerson(Integer.parseInt(jpanelCenter.lblIdSet.getText()));
						client.setPersonalIdentification(jpanelCenter.jtfDoc.getText());
						client.setName(jpanelCenter.jtfName.getText());
						client.setLastName(jpanelCenter.jtfLastName.getText());
						client.setBirthDate(jpanelCenter.birthdayDateChooser.getDate());
						client.setTelephone(jpanelCenter.jtfPhone.getText());
						client.setEmail(jpanelCenter.jtfEmail.getText());
						client.setAddress(jpanelCenter.jtfAdress.getText());
						client.setActivationState(
								ActivationState.getState(jpanelCenter.activRadioButton.isSelected()));

						if (sqlPeople.updateClient(client)) {
							JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Correo no valido", "CORREO SIN FORMATO",
								JOptionPane.INFORMATION_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(null, "El telefono ingresado ya existe en el sistema",
							"TELEFONO REPETIDO", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El documento de identidad ya existe en el sistema",
						"DOCUMENTO REPETIDO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Verifica si el estado está activo
	 * @param state estado
	 * @return true si -false no
	 */
	private boolean isActive(String state) {
		if (state.equals("ACTIV"))
			return true;
		return false;
	}

	/**
	 * Obtiene le campo del nombre
	 * @return jtfName text
	 */
	public CustomTxtField getJtfName() {
		return jpanelCenter.jtfName;
	}

	/**
	 * Obtiene el campo del apellido
	 * @return jtfLastName text
	 */
	public CustomTxtField getJtfLastName() {
		return jpanelCenter.jtfLastName;
	}

	/**
	 * Obtiene el campo del telefono
	 * @return jtfPhone telefono
	 */
	public CustomTxtField getJtfPhone() {
		return jpanelCenter.jtfPhone;
	}
}
