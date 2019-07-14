package com.cmv.petGenesis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;


public class LoginJPanel extends JPanel {
	private JLabel title, lblUser, lblPassword, lblWithoutAccount, imgUser, imgCMV;
	private JTextField fldUser;
	private JButton btnReturn, btnSignin;
	private JPasswordField passwordField;

	/**
	 * Constructor que inicializa los componentes de la clase
	 */
	public LoginJPanel() {
		super(new GridBagLayout());
		this.title = new JLabel(ConstantView.TITLE_LOGIN);
		this.imgUser = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_USER_LOGIN, new Dimension(130,  130)));
		this.imgCMV = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_CMV_LOGIN, new Dimension(60,  60)));
		this.lblUser = new JLabel(ConstantView.LABEL_USER_LOGIN);
		this.lblPassword = new JLabel(ConstantView.LABEL_PSW_LOGIN);
		this.lblWithoutAccount = new JLabel(ConstantView.LABEL_SIGIN_LOGIN);
		this.fldUser = new JTextField(15);
		this.btnReturn = new JButton(ConstantView.BUTTON_RETURN_LOGIN);
		this.btnSignin = new JButton(ConstantView.BUTTON_SIGNIN_LOGIN);
		this.passwordField = new JPasswordField(15);
		this.init();
	}

	/**
	 * Crea los componentes del panel y los agrega
	 */
	private void init() {
		this.setOpaque(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		title.setFont(ConstantView.FONT_TITLE_LOGIN);
		this.add(title, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		this.add(imgCMV, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		this.add(imgUser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weighty = 0;
		lblUser.setFont(ConstantView.FONT_LABELS_LOGIN);
		lblUser.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 5));
		this.add(lblUser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		fldUser.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		fldUser.setMargin(new Insets(100, 100, 100, 100));
		this.add(fldUser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		lblPassword.setFont(ConstantView.FONT_LABELS_LOGIN);
		lblPassword.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
		this.add(lblPassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.add(passwordField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		lblWithoutAccount.setFont(ConstantView.FONT_LABELS_LOGIN);
		lblWithoutAccount.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		this.add(lblWithoutAccount, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.weighty = 0.7;
		this.add(btnSignin, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.3;
		this.add(btnReturn, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.weightx = 0.3;
		JLabel l7 = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_HELP_LOGIN, new Dimension(60, 60)));
		
		JLabel l8 = new JLabel(UtilityClass.getScaledImage(ConstantView.PATH_ABOUT_LOGIN, new Dimension(60, 60)));
		
		JPanel jw = new JPanel();
		jw.add(l7, BorderLayout.WEST);
		jw.add(l8, BorderLayout.EAST);
		this.add(jw, gbc);
	}
	
	public void clearFields() {
		this.fldUser.setText("");
		this.passwordField.setText("");
	}
}
