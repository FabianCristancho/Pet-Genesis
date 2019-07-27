package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.EnterListener;
import com.toedter.calendar.JDateChooser;

import PruebasLogin.LoginManage;

public class JPanelFormUser extends JPanel {

	protected CustomLabel idUser, resultId, personalDoc, lblName, lblLastName, lblPhone, lblEmail, lblAddress, lblActiv, lblUserType,
			lblUserName, lblPsw, lblPswAgain, lblBirthDate;
	protected CustomTxtField jtfpersonalId, jtfName, jtfLastName, jtfPhone, jtfEmail, jtfAdress, jtfUserName;
	protected JPasswordField jpfPassword, jpfPasswordAgain;
	protected JComboBox<String> comboUserType;
	protected JRadioButton activRadioButton, inactivRadioButton;
	protected JDateChooser birthdayDateChooser;
	protected JButton okButton, returnButton, btnClearFields;
	protected JPanel panelPersonalData, panelUserData, jPanelButtons;
	protected ButtonGroup buttonGroup;
	private SimpleDateFormat sdf;

	public JPanelFormUser() {
		super();
		this.idUser = new CustomLabel(ConstantView.LABEL_ID_USER_SIGNIN, ConstantView.FONT_FORM, null);
		this.resultId = new CustomLabel("", ConstantView.FONT_FORM, null );
		this.personalDoc = new CustomLabel(ConstantView.LABEL_PERSONAL_DOC_SIGNIN, ConstantView.FONT_FORM, null);
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
		this.jtfpersonalId = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfLastName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfPhone = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfAdress = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfEmail = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jpfPassword = new JPasswordField(17);
		this.jpfPasswordAgain = new JPasswordField(17);
		this.activRadioButton = new JRadioButton(ConstantView.LABEL_IS_ACTIVE_SIGNIN);
		this.inactivRadioButton = new JRadioButton(ConstantView.LABEL_IS_INACTIVE_SIGNIN);
		this.comboUserType = new JComboBox<>(ConstantView.VALUES_COMBO);
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.btnClearFields = new JButton(ConstantView.BUTTON_CLEAR_SIGNIN);
		this.buttonGroup = new ButtonGroup();
		this.jPanelButtons = new JPanel(new BorderLayout());
		
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ControlUser.getInstance().setjPanelFormUser(this);
		this.init();
	}

	private void init() {
		this.setOpaque(false);

		this.initPanelPersonalData();
		this.initSigInData();

		UtilityClass.addBorder(this, 20, 20, 20, 20);

		JPanel panelPersonalUser = new JPanel(new GridLayout(1, 2, 20, 20));
		panelPersonalUser.add(panelPersonalData);
		panelPersonalUser.add(panelUserData);
		this.add(panelPersonalUser);
		this.requestFocusInWindow(true);
	}

	private void initPanelPersonalData() {
		this.panelPersonalData = new JPanel(new GridBagLayout());
		this.panelPersonalData.setBorder(BorderFactory.createTitledBorder(ConstantView.P_DATA_SIGNIN));
		this.panelPersonalData.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 0, 20, 5);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.panelPersonalData.add(idUser, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.panelPersonalData.add(personalDoc, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2);
		this.panelPersonalData.add(lblName, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		this.panelPersonalData.add(lblLastName, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4);
		this.panelPersonalData.add(lblBirthDate, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 5);
		this.panelPersonalData.add(lblPhone, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 6);
		this.panelPersonalData.add(lblEmail, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 7);
		this.panelPersonalData.add(lblAddress, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.panelPersonalData.add(resultId, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jtfpersonalId.addKeyListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfpersonalId, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 2);
		this.jtfName.addKeyListener(ControlUser.getInstance());
		this.jtfName.addFocusListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfName, gbc);


		UtilityClass.organizeGridLayout(gbc, 1, 3);
		this.jtfLastName.addKeyListener(ControlUser.getInstance());
		this.jtfLastName.addFocusListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfLastName, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 4);
		this.birthdayDateChooser.setPreferredSize(new Dimension(100, 20));
		this.birthdayDateChooser.setMaxSelectableDate(new Date());
		this.panelPersonalData.add(birthdayDateChooser, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 5);
		this.jtfPhone.addKeyListener(ControlUser.getInstance());
		this.panelPersonalData.add(jtfPhone, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 6);
		this.panelPersonalData.add(jtfEmail, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 7);
		this.panelPersonalData.add(jtfAdress, gbc);
	}

	private void initSigInData() {
		this.panelUserData = new JPanel(new GridBagLayout());
		this.panelUserData.setBorder(BorderFactory.createTitledBorder(ConstantView.U_DATA_SIGNIN));
		this.panelUserData.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 20, 40, 20);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
		this.panelUserData.add(lblUserType, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.panelUserData.add(lblActiv, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2);
		this.panelUserData.add(lblUserName, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3);
		this.panelUserData.add(lblPsw, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4);
		this.panelUserData.add(lblPswAgain, gbc);

		gbc.anchor = GridBagConstraints.EAST;

		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.panelUserData.add(comboUserType, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		inactivRadioButton.setFocusable(false);
		activRadioButton.setSelected(true);
		activRadioButton.setFocusable(false);
		buttonGroup.add(activRadioButton);
		buttonGroup.add(inactivRadioButton);
		jPanelButtons.add(activRadioButton, BorderLayout.WEST);
		jPanelButtons.add(inactivRadioButton, BorderLayout.EAST);
		this.panelUserData.add(jPanelButtons, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2);
		this.panelUserData.add(jtfUserName, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3);
		this.jpfPassword.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		this.jpfPassword.setFont(ConstantView.FONT_FIELD_FORM);
		this.panelUserData.add(jpfPassword, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 4);
		this.jpfPasswordAgain.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		this.jpfPasswordAgain.setFont(ConstantView.FONT_FIELD_FORM);
		this.panelUserData.add(jpfPasswordAgain, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 5);
		UtilityClass.addCommandJButton(btnClearFields, UserCommands.CMD_WD_UPDATE_CLEAR.toString(), ControlUser.getInstance());
		this.btnClearFields.setFocusable(false);
		this.btnClearFields.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnClearFields.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.panelUserData.add(btnClearFields, gbc);
	}

	public void clearFields() {
		this.resultId.setText("");
		this.jtfAdress.setText("");
		this.jtfEmail.setText("");
		this.jtfpersonalId.setText("");
		this.jtfLastName.setText("");
		this.jtfName.setText("");
		this.jtfPhone.setText("");
		this.jtfUserName.setText("");
		this.jpfPassword.setText("");
		this.jpfPasswordAgain.setText("");
		this.activRadioButton.setSelected(true);
		this.comboUserType.setSelectedIndex(0);
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void newForm() {
		this.resultId.setText("");
		this.jtfAdress.setText("");
		this.jtfEmail.setText("");
		this.jtfpersonalId.setText("");
		this.jtfLastName.setText("");
		this.jtfName.setText("");
		this.jtfPhone.setText("");
		this.jtfUserName.setText("");
		this.jpfPassword.setText("");
		this.jtfAdress.setText("");
		this.jpfPasswordAgain.setText("");
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.activRadioButton.setSelected(true);
		this.comboUserType.setSelectedIndex(0);
	}

	public CustomTxtField getJtfId() {
		return jtfpersonalId;
	}

	public void setJtfId(CustomTxtField jtfId) {
		this.jtfpersonalId = jtfId;
	}

	public CustomTxtField getJtfName() {
		return jtfName;
	}

	public void setJtfName(CustomTxtField jtfName) {
		this.jtfName = jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jtfLastName;
	}

	public void setJtfLastName(CustomTxtField jtfLastName) {
		this.jtfLastName = jtfLastName;
	}

	public CustomTxtField getJtfPhone() {
		return jtfPhone;
	}

	public void setJtfPhone(CustomTxtField jtfPhone) {
		this.jtfPhone = jtfPhone;
	}

	public CustomTxtField getJtfUserName() {
		return jtfUserName;
	}

	public void setJtfUserName(CustomTxtField jtfUserName) {
		this.jtfUserName = jtfUserName;
	}

	public void showUserName() {
		if (!isFieldIsEmpty(jtfName) && !isFieldIsEmpty(jtfLastName)) {
			jtfUserName.setText(LoginManage.getInstance().useName(jtfName.getText(), jtfLastName.getText()));
		}
	}

	public boolean isFieldIsEmpty(JTextField jtf) {
		return jtf.getText().length() == 0;
	}
	
	public void createAutomaticID() {
		SQLPeople sqlPeople = new SQLPeople();
		resultId.setText(""+(sqlPeople.getLastIdPerson()+1));
	}
}
