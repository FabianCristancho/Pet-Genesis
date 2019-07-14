package com.cmv.petGenesis.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.toedter.calendar.JDateChooser;

public class SignInJPanel extends JPanel {

	private JLabel title, lblId, lblName, lblLastName, lblPhone, lblEmail, lblAddress, lblActiv, lblUserType,
			lblUserName, lblPsw, lblPswAgain, lblBirthDate;
	private JTextField jtfId, jtfName, jtfLastName, jtfPhone, jtfEmail, jtfAdress, jtfUserName;
	private JPasswordField jpfPassword, jpfPasswordAgain;
	private JComboBox<String> comboUserType;
	private JRadioButton activRadioButton, inactivRadioButton;
	private JDateChooser birthdayDateChooser;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelPersonalData;
	private JPanel panelUserData;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public SignInJPanel() {
		super(new BorderLayout());
		this.title = new JLabel(ConstantView.TITLE_SIGNIN);
		this.lblId = new JLabel(ConstantView.LABEL_ID_SIGNIN);
		this.lblName = new JLabel(ConstantView.LABEL_NAME_SIGNIN);
		this.lblLastName = new JLabel(ConstantView.LABEL_LAST_NAME_SIGNIN);
		this.lblBirthDate = new JLabel(ConstantView.LABEL_BIRTHDATE_SIGNIN);
		this.lblPhone = new JLabel(ConstantView.LABEL_PHONE_SIGNIN);
		this.lblEmail = new JLabel(ConstantView.LABEL_EMAIL_SIGNIN);
		this.lblAddress = new JLabel(ConstantView.LABEL_ADDRESS_SIGNIN);
		this.lblActiv = new JLabel(ConstantView.LABEL_ACTIVE_SIGNIN);
		this.lblUserType = new JLabel(ConstantView.LABEL_USER_TYPE_SIGNIN);
		this.lblUserName = new JLabel(ConstantView.LABEL_USER_NAME_SIGNIN);
		this.lblPsw = new JLabel(ConstantView.LABEL_PASSWORD_SIGNIN);
		this.lblPswAgain = new JLabel(ConstantView.LABEL_CONFIRM_PASSWORD_SIGNIN);
		this.jtfId = new JTextField(20);
		this.jtfName = new JTextField(20);
		this.jtfLastName = new JTextField(20);
		this.jtfPhone = new JTextField(20);
		this.jtfAdress = new JTextField(20);
		this.jtfEmail = new JTextField(20);
		this.jtfUserName = new JTextField(20);
		this.jpfPassword = new JPasswordField(20);
		this.jpfPasswordAgain = new JPasswordField(20);
		this.activRadioButton = new JRadioButton(ConstantView.LABEL_IS_ACTIVE_SIGNIN);
		this.inactivRadioButton = new JRadioButton(ConstantView.LABEL_IS_INACTIVE_SIGNIN);
		this.comboUserType = ConstantView.COMBO_USER_TYPE_SIGNIN;
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);

		this.birthdayDateChooser = new JDateChooser();
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setOpaque(false);
		
		this.initPanelPersonalData();
		this.initSigInData();
		
		this.add(panelPersonalData, BorderLayout.WEST);
		this.add(panelUserData, BorderLayout.EAST);
		
		this.title.setFont(ConstantView.FONT_TITLE_SIGNIN);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);
	}

	private void initPanelPersonalData() {
		this.panelPersonalData = new JPanel(new GridBagLayout());
		this.panelPersonalData.setBorder(BorderFactory.createTitledBorder(ConstantView.P_DATA_SIGNIN));
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
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
		this.panelPersonalData.add(jtfName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.panelPersonalData.add(jtfId, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.panelPersonalData.add(jtfLastName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.panelPersonalData.add(birthdayDateChooser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.panelPersonalData.add(jtfPhone, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.panelPersonalData.add(jtfEmail, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.panelPersonalData.add(jtfAdress, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.panelPersonalData.add(returnButton, gbc);
	}

	private void initSigInData() {
		this.panelUserData = new JPanel(new GridBagLayout());
		this.panelUserData.setBorder(BorderFactory.createTitledBorder(ConstantView.U_DATA_SIGNIN));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
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
		this.panelUserData.add(jpfPassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.panelUserData.add(jpfPasswordAgain, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.panelUserData.add(okButton, gbc);
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getBirthDate() {
		if (birthdayDateChooser.getDate() != null)
			return DateFormat.getDateInstance().format(birthdayDateChooser.getDate());
		return null;
	}


	public void clearFields() {
//		this.nicknameField.setText("");
//		this.firstNameField.setText("");
//		this.lastNameField.setText("");
//		this.emailField.setText("");
//		this.passwordField.setText("");
//		this.bithdayDateChooser.setDate(new Date());
	}
}
