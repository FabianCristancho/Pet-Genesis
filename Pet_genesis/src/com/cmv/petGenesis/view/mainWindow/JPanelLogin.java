package com.cmv.petGenesis.view.mainWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.LoginCommands;
import com.cmv.petGenesis.connection.SQLUsers;
import com.cmv.petGenesis.controller.ControlLogin;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.Hash;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelLogin, encargada principalmente de crear la ventana de inicio de
 * sesion al sistema
 * 
 * @author Yohan Caro - Fabian Cristancho
 * @version 1.0 - 30/07/2019
 *
 */
public class JPanelLogin extends JPanel {
	private JLabel title, lblUser, lblPassword, imgUser, imgCMV, imgLogoHealth, imgHelp, imgAbout;
	private CustomTxtField fldUser;
	private JButton btnExit, btnLogin;
	private JPasswordField passwordField;

	/**
	 * Constructor que inicializa los componentes de la clase
	 */
	public JPanelLogin() {
		super(new GridBagLayout());
		this.title = new JLabel(ConstantView.TITLE_LOGIN);
		this.imgUser = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_USER_LOGIN, new Dimension(130, 130)));
		this.imgCMV = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_CMV_LOGIN, new Dimension(60, 60)));
		this.imgLogoHealth = new JLabel(
				UtilityClass.getScaledImage(ConstantView.PATH_HEALTH_LOGIN, new Dimension(70, 70)));
		this.lblUser = new JLabel(ConstantView.LABEL_USER_LOGIN);
		this.lblPassword = new JLabel(ConstantView.LABEL_PSW_LOGIN);
		this.fldUser = new CustomTxtField(15, ConstantView.FONT_FIELD_FORM, JTextField.LEFT);
		this.btnExit = new JButton(ConstantView.BUTTON_EXIT_LOGIN);
		this.btnLogin = new JButton(ConstantView.BUTTON_SIGNIN_LOGIN);
		this.passwordField = new JPasswordField(15);
		ControlLogin.getInstance().setLoginJPanel(this);
		this.init();
	}

	/**
	 * Crea los componentes del panel y los agrega
	 */
	private void init() {
		this.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		title.setFont(ConstantView.FONT_TITLE_LOGIN);
		this.add(title, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0;
		this.add(imgCMV, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(imgLogoHealth, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		this.add(imgUser, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weighty = 0;
		lblUser.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		lblUser.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 5));
		this.add(lblUser, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		fldUser.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		fldUser.setMargin(new Insets(100, 100, 100, 100));
		this.add(fldUser, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		lblPassword.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		lblPassword.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
		this.add(lblPassword, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		passwordField.setFont(ConstantView.FONT_FIELD_FORM);
		this.add(passwordField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.weighty = 0.7;
		this.btnLogin.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnLogin.setForeground(Color.WHITE);
		this.btnLogin.setFocusable(false);
		this.btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnLogin.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		this.btnLogin.addActionListener(ControlLogin.getInstance());
		this.btnLogin.setActionCommand(LoginCommands.OK_LOGIN.toString());
		this.add(btnLogin, gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.3;
		this.btnExit.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnExit.setForeground(Color.WHITE);
		this.btnExit.setFocusable(false);
		this.btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnExit.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		this.add(btnExit, gbc);

		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.weightx = 0.3;
		imgHelp = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_HELP_LOGIN, new Dimension(38, 38)));
		imgHelp.addMouseListener(ControlLogin.getInstance());
		imgHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));

		imgAbout = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_ABOUT_LOGIN, new Dimension(41, 41)));
		imgAbout.addMouseListener(ControlLogin.getInstance());
		imgAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JPanel panelInfo = new JPanel();
		panelInfo.setOpaque(false);
		panelInfo.add(imgHelp, BorderLayout.WEST);
		panelInfo.add(imgAbout, BorderLayout.EAST);
		this.add(panelInfo, gbc);
	}

	/**
	 * Limpia los campos de texto
	 */
	public void clearFields() {
		this.fldUser.setText("");
		this.passwordField.setText("");
	}

	/**
	 * Obtiene la imagen de ayuda
	 * 
	 * @return imagen de ayuda
	 */
	public JLabel getImgHelp() {
		return imgHelp;
	}

	/**
	 * Obtiene la imagen de acerca de
	 * 
	 * @return imagen acerca de
	 */
	public JLabel getImgAbout() {
		return imgAbout;
	}

	/**
	 * Se encarga de validar los campos y datos ingresados por el usuario
	 * 
	 * @param user Usuario que desea iniciar sesion
	 */
	public void validFields(User user) {
		SQLUsers sqlUsers = new SQLUsers();

		Date date = new Date();
		DateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String pass = new String(passwordField.getPassword());

		JTextField[] fields = { fldUser, passwordField };
		if (!UtilityClass.fieldsAreEmpty(fields)) {
			String newPass = Hash.sha1(pass);
			user.setNameUser(fldUser.getText());
			user.setPassword(newPass);
			user.setLastSession(dateTime.format(date));

			if (sqlUsers.login(user)) {
				JDialogLogin.getInstance().dispose();
				new JFrameMainWindow(user);
			} else {
				JOptionPane.showMessageDialog(null,
						"No puede ingresar.\nVerifique que los datos sean correctos y el usuario se encuentre activo en el sistema",
						"INCORRECTOS", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar los campos", "DATOS INCOMPLETOS",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Evalua si algun campo de texto esta vacio
	 * 
	 * @param jtf Campo de texto a evaluar
	 * @return true si el campo esta vacio
	 */
	public boolean isFieldIsEmpty(JTextField jtf) {
		return jtf.getText().length() == 0;
	}

}
