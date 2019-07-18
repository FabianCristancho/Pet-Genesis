package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.model.Hash;
import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.EnterListener;
import com.toedter.calendar.JDateChooser;

import PruebasLogin.LoginManage;
import PruebasLogin.PasswordUtil;

public class JPanelCreateUser extends JPanel {

	private CustomLabel title, lblId, lblName, lblLastName, lblPhone, lblEmail, lblAddress, lblActiv, lblUserType,
			lblUserName, lblPsw, lblPswAgain, lblBirthDate;
	private CustomTxtField jtfId, jtfName, jtfLastName, jtfPhone, jtfEmail, jtfAdress, jtfUserName;
	private JPasswordField jpfPassword, jpfPasswordAgain;
	private JComboBox<String> comboUserType;
	private JRadioButton activRadioButton, inactivRadioButton;
	private JDateChooser birthdayDateChooser;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelPersonalData;
	private JPanel panelUserData;
	private JPanel panelButtons;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateUser() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_SIGNIN);
		this.lblId = new CustomLabel(ConstantView.LABEL_ID_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblName = new CustomLabel(ConstantView.LABEL_NAME_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblLastName = new CustomLabel(ConstantView.LABEL_LAST_NAME_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblBirthDate = new CustomLabel(ConstantView.LABEL_BIRTHDATE_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblPhone = new CustomLabel(ConstantView.LABEL_PHONE_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblEmail = new CustomLabel(ConstantView.LABEL_EMAIL_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblAddress = new CustomLabel(ConstantView.LABEL_ADDRESS_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblActiv = new CustomLabel(ConstantView.LABEL_ACTIVE_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblUserType = new CustomLabel(ConstantView.LABEL_USER_TYPE_SIGNIN, ConstantView.FONT_FORM, null);
		this.jtfUserName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.lblUserName = new CustomLabel(ConstantView.LABEL_USER_NAME_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblPsw = new CustomLabel(ConstantView.LABEL_PASSWORD_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblPswAgain = new CustomLabel(ConstantView.LABEL_CONFIRM_PASSWORD_SIGNIN, ConstantView.FONT_FORM, null);
		this.jtfId = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfLastName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfPhone = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfAdress = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfEmail = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jpfPassword = new JPasswordField(17);
		this.jpfPasswordAgain = new JPasswordField(17);
		this.activRadioButton = new JRadioButton(ConstantView.LABEL_IS_ACTIVE_SIGNIN);
		this.inactivRadioButton = new JRadioButton(ConstantView.LABEL_IS_INACTIVE_SIGNIN);
		this.comboUserType = ConstantView.COMBO_USER_TYPE_SIGNIN;
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ControlUser.getInstance().setjPanelCreateUser(this);
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setOpaque(false);

		this.initPanelPersonalData();
		this.initSigInData();
		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 20, 20, 20);
		
		JPanel panelPersonalUser = new JPanel(new GridLayout(1, 2, 20, 20));
		panelPersonalUser.add(panelPersonalData);
		panelPersonalUser.add(panelUserData);
		this.add(panelPersonalUser, BorderLayout.CENTER);

		this.title.setFont(ConstantView.FONT_TITLE_SIGNIN);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);

		this.add(panelButtons, BorderLayout.SOUTH);
	}

	private void initPanelPersonalData() {
		this.panelPersonalData = new JPanel(new GridBagLayout());
		this.panelPersonalData.setBorder(BorderFactory.createTitledBorder(ConstantView.P_DATA_SIGNIN));
		this.panelPersonalData.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 40, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.panelPersonalData.add(lblId, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.panelPersonalData.add(lblName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.panelPersonalData.add(lblLastName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.panelPersonalData.add(lblBirthDate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		this.panelPersonalData.add(lblPhone, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		this.panelPersonalData.add(lblEmail, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		this.panelPersonalData.add(lblAddress, gbc);

		gbc.anchor = GridBagConstraints.EAST;

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.jtfName.addKeyListener(ControlUser.getInstance());
		this.jtfName.addFocusListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.jtfId.addKeyListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfId, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		this.jtfLastName.addKeyListener(ControlUser.getInstance());
		this.jtfLastName.addFocusListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfLastName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		this.birthdayDateChooser.setPreferredSize(new Dimension(100, 20));
		this.birthdayDateChooser.setMaxSelectableDate(new Date());
		this.panelPersonalData.add(birthdayDateChooser, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		this.jtfPhone.addKeyListener(EnterListener.getInstance());
		this.panelPersonalData.add(jtfPhone, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		this.panelPersonalData.add(jtfEmail, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		this.panelPersonalData.add(jtfAdress, gbc);
	}

	private void initSigInData() {
		this.panelUserData = new JPanel(new GridBagLayout());
		this.panelUserData.setBorder(BorderFactory.createTitledBorder(ConstantView.U_DATA_SIGNIN));
		this.panelUserData.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 20, 40, 20);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.panelUserData.add(lblUserType, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.panelUserData.add(lblActiv, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.panelUserData.add(lblUserName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.panelUserData.add(lblPsw, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		this.panelUserData.add(lblPswAgain, gbc);

		gbc.anchor = GridBagConstraints.EAST;

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.panelUserData.add(comboUserType, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		ButtonGroup buttonGroup = new ButtonGroup();
		inactivRadioButton.setSelected(true);
		inactivRadioButton.setFocusable(false);
		activRadioButton.setFocusable(false);
		buttonGroup.add(activRadioButton);
		buttonGroup.add(inactivRadioButton);
		JPanel jpanelButtons = new JPanel(new BorderLayout());
		jpanelButtons.add(activRadioButton, BorderLayout.WEST);
		jpanelButtons.add(inactivRadioButton, BorderLayout.EAST);
		this.panelUserData.add(jpanelButtons, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		this.panelUserData.add(jtfUserName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		this.jpfPassword.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		this.jpfPassword.setFont(ConstantView.FONT_FIELD_FORM);
		this.panelUserData.add(jpfPassword, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		this.jpfPasswordAgain.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		this.jpfPasswordAgain.setFont(ConstantView.FONT_FIELD_FORM);
		this.panelUserData.add(jpfPasswordAgain, gbc);
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
		if (birthdayDateChooser.getDate() != null)
			return sdf.format(birthdayDateChooser.getDate());
		return null;
	}

	public void clearFields() {
		this.jtfAdress.setText("");
		this.jtfEmail.setText("");
		this.jtfId.setText("");
		this.jtfLastName.setText("");
		this.jtfName.setText("");
		this.jtfPhone.setText("");
		this.jtfUserName.setText("");
		this.birthdayDateChooser.setDate(new Date());
	}

	public CustomTxtField getJtfName() {
		return jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jtfLastName;
	}

	public void showUserName() {
		if (!isFieldIsEmpty(jtfName) && !isFieldIsEmpty(jtfLastName)) {
			jtfUserName.setText(LoginManage.getInstance().useName(jtfName.getText(), jtfLastName.getText()));
		}
	}

	public void validFields() {
		if (isFieldIsEmpty(jtfName) || isFieldIsEmpty(jtfLastName) || isFieldIsEmpty(jpfPassword)
				|| isFieldIsEmpty(jpfPasswordAgain)) {
			JOptionPane.showMessageDialog(null, "SE DEBEN INGRESAR LOS CAMPOS OBLIGATORIOS");
		} else {
			try {
				LoginManage.getInstance().generateUsername(jtfName.getText(), jtfLastName.getText(),
						PasswordUtil.getHash(String.valueOf(jpfPassword.getPassword())));
				JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!String.valueOf(jpfPassword.getPassword()).equals(String.valueOf(jpfPasswordAgain.getPassword()))) {
			JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
		} else {
			if (isFieldIsEmpty(jpfPassword) || isFieldIsEmpty(jpfPassword)) {
				JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO LA CONTRSEÑA");
			} else {
				try {
					LoginManage.getInstance().generateUsername(jtfName.getText(), jtfLastName.getText(),
							PasswordUtil.getHash(String.valueOf(jpfPassword.getPassword())));
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
		return jtfId;
	}

	public CustomTxtField getJtfPhone() {
		return jtfPhone;
	}

	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}

	public void setJpfPassword(JPasswordField jpfPassword) {
		this.jpfPassword = jpfPassword;
	}

	public JPasswordField getJpfPasswordAgain() {
		return jpfPasswordAgain;
	}

	public void setJpfPasswordAgain(JPasswordField jpfPasswordAgain) {
		this.jpfPasswordAgain = jpfPasswordAgain;
	}

	public void saveDataSignIn(Usuario mod) {
		SqlUSer modSql = new SqlUSer();

		String password = new String(jpfPassword.getPassword());
		String passwordAgain = new String(jpfPasswordAgain.getPassword());

		JTextField[] requiredFields = { jtfId, jtfName, jtfLastName, jtfUserName, jpfPassword, jpfPasswordAgain };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {

			if (password.equals(passwordAgain)) {

				if (modSql.existUser(jtfUserName.getText()) == 0) {

					if (UtilityClass.validateEmail(jtfEmail.getText()) || jtfEmail.getText().length() == 0) {

						String newPass = Hash.sha1(password);

						mod.setName(jtfName.getText());
						mod.setLastName(jtfLastName.getText());
						mod.setBirthDate(birthdayDateChooser.getDate());
						if (jtfPhone.getText().length() != 0) {
							mod.setPhone(Integer.parseInt(jtfPhone.getText()));
						}
						mod.setEmail(jtfEmail.getText());
						mod.setAddress(jtfAdress.getText());
						mod.setTypeUser(TypeUser.getTypeUser(comboUserType.getSelectedIndex()+1));
						mod.setState(activRadioButton.isSelected() ? activRadioButton.getText()
								: inactivRadioButton.getText());
						mod.setUserName(jtfUserName.getText());
						mod.setPassword(newPass);

						if (modSql.register(mod)) {
							JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");

						}
					} else {
						JOptionPane.showMessageDialog(null, "Correo no valido", "CORREO SIN FORMATO",
								JOptionPane.INFORMATION_MESSAGE);

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
