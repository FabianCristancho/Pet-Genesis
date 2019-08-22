package com.cmv.petGenesis.view.userManagement;

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

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLUsers;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.Hash;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelPanelUpdateUser, muestra la ventana de actualizacion de usuario
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class JpanelUpdateUser extends JPanel {

	private JLabel titlePanel;
	private JLabel descriptionLabel;
	private JTextField jtfInputId;
	private JPanel jPanelUp;
	private JPanelFormUser jpanelCenter;
	private JPanel jPanelDown;
	private JButton btnSearchUser;
	private JButton btnReturn;
	private JButton btnUpdateUser;
	private JComboBox<String> parameters;
	private String oldpIdentification;
	private String oldUserName;
	private String oldTelephone;

	/**
	 * Constructor de la clase
	 */
	public JpanelUpdateUser() {
		super(new BorderLayout());
		this.titlePanel = new JLabel(ConstantView.LABEL_TITLE_UPDATE_USER);
		this.descriptionLabel = new JLabel(ConstantView.LABEL_DESCRIPTION_UPDATE_USER);
		this.btnSearchUser = new JButton(ConstantView.BTN_SEARCH_UPDATE_USER);
		this.jtfInputId = new JTextField(20);
		this.jPanelUp = new JPanel();
		this.jpanelCenter = new JPanelFormUser();
		this.btnReturn = new JButton(ConstantView.BTN_RETURN_UPDATE_USER);
		this.btnUpdateUser = new JButton(ConstantView.BTN_DATA_UPDATE_USER);
		this.parameters = ConstantView.COMBO_PARAMS_UPDATE_USER;
		ControlUser.getInstance().setJpanelUpdateClient(this);
		init();
	}

	/**
	 * Inicializa paneles y componentes
	 */
	private void init() {
		initPanelUp();
		initpanelDown();
		this.setBackground(Color.decode("#c5dfed"));
		UtilityClass.addBorder(this, 20, 20, 20, 20);
		this.jPanelUp.setOpaque(false);
		this.add(jPanelUp, BorderLayout.NORTH);
		this.add(jpanelCenter, BorderLayout.CENTER);
		this.add(jPanelDown, BorderLayout.SOUTH);
	}

	/**
	 * Inicializa panel superior
	 */
	private void initPanelUp() {
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridwidth = 4;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 30, 0, 30));
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
		UtilityClass.addCommandJButton(btnSearchUser, UserCommands.CMD_WD_UPDATE_SEARCH.toString(),
				ControlUser.getInstance());
		this.btnSearchUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelUp.add(btnSearchUser, gbc);
	}

	/**
	 * Inicializa panel inferior
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

		UtilityClass.addCommandJButton(btnReturn, UserCommands.CMD_WD_UPDATE_RETURN.toString(),
				ControlUser.getInstance());
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.jPanelDown.add(btnReturn, gbc);

		gbc.gridx = 7;
		this.btnUpdateUser.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnUpdateUser.setForeground(Color.WHITE);
		this.btnUpdateUser.setFocusable(false);
		this.btnUpdateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnUpdateUser.setFont(ConstantView.FONT_PRINCIPAL_LABELS);

		UtilityClass.addCommandJButton(btnUpdateUser, UserCommands.CMD_WD_UPDATE_CHANGE_DATA.toString(),
				ControlUser.getInstance());
		this.jPanelDown.add(btnUpdateUser, gbc);
	}

	/**
	 * Obtiene parametro de busqueda
	 * 
	 * @return parametro
	 */
	public String getParam() {
		switch (parameters.getSelectedIndex()) {
		case 0:
			return "id_usuario";
		case 1:
			return "documento_identidad";
		case 2:
			return "nombre_usuario";
		default:
			return "";
		}
	}

	/**
	 * Obtiene datos de consulta de usuario
	 */
	public void getDataQueryUpdate() {
		SQLUsers sqlUsers = new SQLUsers();
		User user = sqlUsers.getDataUser(getParam(), jtfInputId.getText());

		if (user != null) {
			jpanelCenter.resultId.setText("" + user.getIdPerson());
			jpanelCenter.jtfUserName.setText(user.getNameUser());
			jpanelCenter.jtfName.setText(user.getName());
			jpanelCenter.jtfLastName.setText(user.getLastName());
			jpanelCenter.birthdayDateChooser.setDate(UtilityClass.daysAdd(user.getBirthDate(), 1));
			jpanelCenter.jtfPhone.setText(user.getTelephone());
			jpanelCenter.comboUserType.setSelectedIndex((user.getTypeUser().getIdTypeUser() - 1));

			if (!isActive(user.getActivationState().getIdState())) {
				jpanelCenter.inactivRadioButton.setSelected(true);
			}

			jpanelCenter.jtfpersonalId.setText(user.getPersonalIdentification());
			jpanelCenter.jtfEmail.setText(user.getEmail());
			jpanelCenter.jtfAdress.setText(user.getAddress());
			this.oldUserName = jpanelCenter.jtfUserName.getText();
			this.oldTelephone = jpanelCenter.jtfPhone.getText();
			this.oldpIdentification = jpanelCenter.jtfpersonalId.getText();
		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE EL USUARIO CONSULTADO");
		}
	}

	/**
	 * Almacena los nuevos valores del usuario
	 * 
	 * @param mod Usuario
	 */
	public void saveDataSignIn(User mod) {
		SQLUsers sqlUsers = new SQLUsers();
		SQLPeople sqlPeople = new SQLPeople();

		String password = new String(jpanelCenter.jpfPassword.getPassword());
		String passwordAgain = new String(jpanelCenter.jpfPasswordAgain.getPassword());

		JTextField[] requiredFields = { jpanelCenter.jtfpersonalId, jpanelCenter.jtfName, jpanelCenter.jtfLastName,
				jpanelCenter.jtfUserName, jpanelCenter.jtfPhone, jpanelCenter.jpfPassword,
				jpanelCenter.jpfPasswordAgain };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {

			if (password.equals(passwordAgain)) {

				if (oldUserName.equals(jpanelCenter.jtfUserName.getText())
						|| sqlUsers.existUser(jpanelCenter.jtfUserName.getText()) == 0) {

					if (oldpIdentification.equals(jpanelCenter.jtfpersonalId.getText())
							|| sqlPeople.existDocumentId(Integer.parseInt(jpanelCenter.jtfpersonalId.getText()))) {

						if (oldTelephone.equals(jpanelCenter.jtfPhone.getText())
								|| sqlPeople.existPhone(jpanelCenter.jtfPhone.getText()) == 0) {

							if (UtilityClass.validateEmail(jpanelCenter.jtfEmail.getText())
									|| jpanelCenter.jtfEmail.getText().length() == 0) {

								String newPass = Hash.sha1(password);
								mod.setIdPerson(Integer.parseInt(jpanelCenter.resultId.getText()));
								mod.setPersonalIdentification(jpanelCenter.jtfpersonalId.getText());
								mod.setName(jpanelCenter.jtfName.getText());
								mod.setLastName(jpanelCenter.jtfLastName.getText());
								mod.setBirthDate(jpanelCenter.birthdayDateChooser.getDate());
								mod.setTelephone(jpanelCenter.jtfPhone.getText());
								mod.setEmail(jpanelCenter.jtfEmail.getText());
								mod.setAddress(jpanelCenter.jtfAdress.getText());
								mod.setTypeUser(
										TypeUser.getTypeUser(jpanelCenter.comboUserType.getSelectedIndex() + 1));
								mod.setActivationState(
										ActivationState.getState(jpanelCenter.activRadioButton.isSelected()));
								mod.setNameUser(jpanelCenter.jtfUserName.getText());
								mod.setPassword(newPass);

								if (sqlUsers.updateUser(mod)) {
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
				} else {
					JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe", "USUARIO REPETIDO",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
			}
		}
	}

	/**
	 * Evalua si usuario esta activo
	 * 
	 * @param state Valor de activacion
	 * @return true si esta activo
	 */
	private boolean isActive(char state) {
		if (state == 'A')
			return true;
		return false;
	}

	/**
	 * Obtiene campo de nombre
	 * 
	 * @return campo de nombre
	 */
	public CustomTxtField getJtfName() {
		return jpanelCenter.jtfName;
	}

	/**
	 * Obtiene campo de apellido
	 * 
	 * @return Campo de apellido
	 */
	public CustomTxtField getJtfLastName() {
		return jpanelCenter.jtfLastName;
	}

	/**
	 * Obtiene campo id
	 * 
	 * @return campo id
	 */
	public CustomTxtField getJtfId() {
		return jpanelCenter.jtfpersonalId;
	}

	/**
	 * Obtiene campo telefono
	 * 
	 * @return campo telefono
	 */
	public CustomTxtField getJtfPhone() {
		return jpanelCenter.jtfPhone;
	}

	/**
	 * Obtiene campo id
	 * 
	 * @return id
	 */
	public String getNewpIdentification() {
		return oldpIdentification;
	}

	/**
	 * Obtiene usuario nuevo
	 * 
	 * @return usuario nuevo
	 */
	public String getNewUserName() {
		return oldUserName;
	}

	/**
	 * Obtiene nuevo telefono
	 * 
	 * @return nuevo telefono
	 */
	public String getNewTelephone() {
		return oldTelephone;
	}

	/**
	 * Limpia los campos
	 */
	public void clearFields() {
		this.jpanelCenter.clearFields();
	}
}
