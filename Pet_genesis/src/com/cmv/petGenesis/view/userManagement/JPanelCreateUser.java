package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLUsers;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.Hash;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

import PruebasLogin.LoginManage;
import PruebasLogin.PasswordUtil;

public class JPanelCreateUser extends JPanel {

	private CustomLabel title;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelButtons;
	private JPanelFormUser jPanelFormUser;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateUser() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_SIGNIN, null, Color.decode("#2E5569"));
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelFormUser = new JPanelFormUser();
		this.jPanelFormUser.createAutomaticID();
		ControlUser.getInstance().setjPanelCreateUser(this);
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 20, 20, 20);

		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);

		this.add(panelButtons, BorderLayout.SOUTH);
		this.jPanelFormUser.setOpaque(false);
		this.add(jPanelFormUser, BorderLayout.CENTER);
	}

	private void initPanelButtons() {
		this.panelButtons = new JPanel(new GridBagLayout());
		this.panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.panelButtons.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

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
		this.panelButtons.add(returnButton, gbc);

		gbc.gridx = 7;
		this.okButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.okButton.setForeground(Color.WHITE);
		this.okButton.setFocusable(false);
		this.okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.okButton.setFont(ConstantView.FONT_LABELS_LOGIN);
		this.okButton.addActionListener(ControlUser.getInstance());
		this.okButton.setActionCommand(UserCommands.OK_SIGN_IN.toString());
		this.panelButtons.add(okButton, gbc);
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (jPanelFormUser.birthdayDateChooser.getDate() != null)
			return sdf.format(jPanelFormUser.birthdayDateChooser.getDate());
		return null;
	}

	public CustomTxtField getJtfName() {
		return jPanelFormUser.jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jPanelFormUser.jtfLastName;
	}

	public void showUserName() {
		if (!isFieldIsEmpty(jPanelFormUser.jtfName) && !isFieldIsEmpty(jPanelFormUser.jtfLastName)) {
			jPanelFormUser.jtfUserName.setText(LoginManage.getInstance().useName(jPanelFormUser.jtfName.getText(),
					jPanelFormUser.jtfLastName.getText()));
		}
	}
	
	public void generateUserName() {
		if (!isFieldIsEmpty(jPanelFormUser.jtfName) && !isFieldIsEmpty(jPanelFormUser.jtfLastName)) {
			jPanelFormUser.jtfUserName.setText(UtilityClass.generateUserName(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText()));
		}
	}

	public void validFields() {
		if (isFieldIsEmpty(jPanelFormUser.jtfName) || isFieldIsEmpty(jPanelFormUser.jtfLastName)
				|| isFieldIsEmpty(jPanelFormUser.jpfPassword) || isFieldIsEmpty(jPanelFormUser.jpfPasswordAgain)) {
			JOptionPane.showMessageDialog(null, "SE DEBEN INGRESAR LOS CAMPOS OBLIGATORIOS");
		} else {
			try {
				LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(),
						jPanelFormUser.jtfLastName.getText(),
						PasswordUtil.getHash(String.valueOf(jPanelFormUser.jpfPassword.getPassword())));
				JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!String.valueOf(jPanelFormUser.jpfPassword.getPassword())
				.equals(String.valueOf(jPanelFormUser.jpfPasswordAgain.getPassword()))) {
			JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
		} else {
			if (isFieldIsEmpty(jPanelFormUser.jpfPassword) || isFieldIsEmpty(jPanelFormUser.jpfPassword)) {
				JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO LA CONTRSEÑA");
			} else {
				try {
					LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(),
							jPanelFormUser.jtfLastName.getText(),
							PasswordUtil.getHash(String.valueOf(jPanelFormUser.jpfPassword.getPassword())));
					JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isFieldIsEmpty(JTextField jtf) {
		return jtf.getText().length() == 0;
	}

	public CustomTxtField getJtfId() {
		return jPanelFormUser.jtfpersonalId;
	}

	public CustomTxtField getJtfPhone() {
		return jPanelFormUser.jtfPhone;
	}

	public JPasswordField getJpfPassword() {
		return jPanelFormUser.jpfPassword;
	}

	public void setJpfPassword(JPasswordField jpfPassword) {
		this.jPanelFormUser.jpfPassword = jpfPassword;
	}

	public JPasswordField getJpfPasswordAgain() {
		return jPanelFormUser.jpfPasswordAgain;
	}

	public void setJpfPasswordAgain(JPasswordField jpfPasswordAgain) {
		this.jPanelFormUser.jpfPasswordAgain = jpfPasswordAgain;
	}

	public void saveDataSignIn(User u) {
		SQLUsers sqlUsers = new SQLUsers();
		SQLPeople sqlPeople = new SQLPeople();

		String password = new String(jPanelFormUser.jpfPassword.getPassword());
		String passwordAgain = new String(jPanelFormUser.jpfPasswordAgain.getPassword());

		JTextField[] requiredFields = { jPanelFormUser.jtfpersonalId, jPanelFormUser.jtfName, jPanelFormUser.jtfLastName,
				jPanelFormUser.jtfPhone, jPanelFormUser.jtfUserName, jPanelFormUser.jpfPassword, jPanelFormUser.jpfPasswordAgain };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {

			if (password.equals(passwordAgain)) {

				if (sqlUsers.existUser(jPanelFormUser.jtfUserName.getText()) == 0) {

					if (sqlPeople.existDocumentId(Integer.parseInt(jPanelFormUser.jtfpersonalId.getText()))) {

						if (sqlPeople.existPhone(jPanelFormUser.jtfPhone.getText()) == 0) {

							if (UtilityClass.validateEmail(jPanelFormUser.jtfEmail.getText())
									|| jPanelFormUser.jtfEmail.getText().length() == 0) {

								String newPass = Hash.sha1(password);
								u.setPersonalIdentification(jPanelFormUser.jtfpersonalId.getText());
								u.setName(jPanelFormUser.jtfName.getText());
								u.setLastName(jPanelFormUser.jtfLastName.getText());
								u.setBirthDate(jPanelFormUser.birthdayDateChooser.getDate());
								u.setTelephone(jPanelFormUser.jtfPhone.getText());
								u.setEmail(jPanelFormUser.jtfEmail.getText());
								u.setAddress(jPanelFormUser.jtfAdress.getText());
								u.setTypeUser(
										TypeUser.getTypeUser(jPanelFormUser.comboUserType.getSelectedIndex() + 1));
								u.setActivationState(
										ActivationState.getState(jPanelFormUser.activRadioButton.isSelected()));

								u.setIdPerson(Integer.parseInt(jPanelFormUser.resultId.getText()));
								u.setNameUser(jPanelFormUser.jtfUserName.getText());
								u.setPassword(newPass);

								if (sqlPeople.registerDataUser(u) && sqlUsers.register(u)) {
									JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
									jPanelFormUser.newForm();
									this.jPanelFormUser.createAutomaticID();
								} else {
									JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
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
}
