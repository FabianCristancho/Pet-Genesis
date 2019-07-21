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

import com.cmv.petGenesis.controller.ControlUser;
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
		this.title = new CustomLabel(ConstantView.TITLE_SIGNIN);
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelFormUser = new JPanelFormUser();
		ControlUser.getInstance().setjPanelCreateUser(this);
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setOpaque(false);

		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 20, 20, 20);
		
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);
		
		this.add(panelButtons, BorderLayout.SOUTH);
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
			jPanelFormUser.jtfUserName.setText(LoginManage.getInstance().useName(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText()));
		}
	}

	public void validFields() {
		if (isFieldIsEmpty(jPanelFormUser.jtfName) || isFieldIsEmpty(jPanelFormUser.jtfLastName) || isFieldIsEmpty(jPanelFormUser.jpfPassword)
				|| isFieldIsEmpty(jPanelFormUser.jpfPasswordAgain)) {
			JOptionPane.showMessageDialog(null, "SE DEBEN INGRESAR LOS CAMPOS OBLIGATORIOS");
		} else {
			try {
				LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText(),
						PasswordUtil.getHash(String.valueOf(jPanelFormUser.jpfPassword.getPassword())));
				JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!String.valueOf(jPanelFormUser.jpfPassword.getPassword()).equals(String.valueOf(jPanelFormUser.jpfPasswordAgain.getPassword()))) {
			JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
		} else {
			if (isFieldIsEmpty(jPanelFormUser.jpfPassword) || isFieldIsEmpty(jPanelFormUser.jpfPassword)) {
				JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO LA CONTRSEÑA");
			} else {
				try {
					LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText(),
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
		return jPanelFormUser.jtfId;
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

	public void saveDataSignIn(Usuario mod) {
		SqlUSer modSql = new SqlUSer();

		String password = new String(jPanelFormUser.jpfPassword.getPassword());
		String passwordAgain = new String(jPanelFormUser.jpfPasswordAgain.getPassword());

		JTextField[] requiredFields = { jPanelFormUser.jtfId, jPanelFormUser.jtfName, jPanelFormUser.jtfLastName, jPanelFormUser.jtfUserName, jPanelFormUser.jpfPassword, jPanelFormUser.jpfPasswordAgain };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {

			if (password.equals(passwordAgain)) {

				if (modSql.existUser(jPanelFormUser.jtfUserName.getText()) == 0) {

					if (UtilityClass.validateEmail(jPanelFormUser.jtfEmail.getText()) || jPanelFormUser.jtfEmail.getText().length() == 0) {

						String newPass = Hash.sha1(password);
						mod.setPersonalDocument(jPanelFormUser.jtfId.getText());
						mod.setName(jPanelFormUser.jtfName.getText());
						mod.setLastName(jPanelFormUser.jtfLastName.getText());
						mod.setBirthDate(jPanelFormUser.birthdayDateChooser.getDate());
						if (jPanelFormUser.jtfPhone.getText().length() != 0) {
							mod.setPhone(Long.parseLong(jPanelFormUser.jtfPhone.getText()));
						}
						mod.setEmail(jPanelFormUser.jtfEmail.getText());
						mod.setAddress(jPanelFormUser.jtfAdress.getText());
						mod.setTypeUser(TypeUser.getTypeUser(jPanelFormUser.comboUserType.getSelectedIndex()+1));
						mod.setState(jPanelFormUser.activRadioButton.isSelected() ? jPanelFormUser.activRadioButton.getText()
								: jPanelFormUser.inactivRadioButton.getText());
						mod.setUserName(jPanelFormUser.jtfUserName.getText());
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
