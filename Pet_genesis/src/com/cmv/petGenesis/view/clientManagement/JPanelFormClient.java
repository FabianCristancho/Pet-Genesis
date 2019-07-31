package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.EnterListener;
import com.toedter.calendar.JDateChooser;

public class JPanelFormClient extends JPanel {
	
	protected CustomLabel lblId, lblIdSet, lblName, lblLastName, lblPhone, lblEmail, lblAddress, lblBirthDate, lblDoc,
			lblActiv, lblPet, lblInfo;
	protected CustomTxtField jtfName, jtfLastName, jtfPhone, jtfEmail, jtfAdress, jtfDoc;
	protected JDateChooser birthdayDateChooser;
	protected JRadioButton activRadioButton, inactivRadioButton;
	protected JButton cleanButton, addPetButton;
	protected ButtonGroup buttonGroup;
	protected JPanel jPanelRadios, jPanelButtons;
	private SimpleDateFormat sdf;

	/**
	 * 
	 */
	public JPanelFormClient() {
		super();
		this.setBorder(BorderFactory.createTitledBorder("Formulario"));
		this.lblId = new CustomLabel(ConstantView.LABEL_ID2_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblIdSet = new CustomLabel("5", ConstantView.FONT_FORM, null);
		this.lblDoc = new CustomLabel(ConstantView.LABEL_DOC_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblName = new CustomLabel(ConstantView.LABEL_NAME_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblLastName = new CustomLabel(ConstantView.LABEL_LAST_NAME_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblBirthDate = new CustomLabel(ConstantView.LABEL_BIRTHDATE_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblPhone = new CustomLabel(ConstantView.LABEL_PHONE_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblEmail = new CustomLabel(ConstantView.LABEL_EMAIL_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblAddress = new CustomLabel(ConstantView.LABEL_ADDRESS_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblActiv = new CustomLabel(ConstantView.LABEL_ACTIVE_SIGNIN, ConstantView.FONT_FORM, null);
//		this.lblPet = new CustomLabel(ConstantView.LABEL_PET_SIGNIN, ConstantView.FONT_FORM, null);
		this.lblInfo = new CustomLabel(ConstantView.LABEL_OBLIGATE, ConstantView.FONT_FORM, null);
		this.activRadioButton = new JRadioButton(ConstantView.LABEL_IS_ACTIVE_SIGNIN);
		this.inactivRadioButton = new JRadioButton(ConstantView.LABEL_IS_INACTIVE_SIGNIN);
		this.jtfDoc = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfLastName = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfPhone = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfAdress = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.jtfEmail = new CustomTxtField(17, ConstantView.FONT_FIELD_FORM, JTextField.RIGHT);
		this.buttonGroup = new ButtonGroup();
		this.jPanelRadios = new JPanel(new BorderLayout());
		this.jPanelButtons = new JPanel(new FlowLayout());
		this.cleanButton = new JButton(ConstantView.BUTTON_CLEAN_SIGNIN);
//		this.addPetButton = new JButton();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ControlClient.getInstance().setjPanelFormClient(this);
		this.init();
	}
	
	private void init() {
		this.setOpaque(false);

		this.setLayout(new GridBagLayout());
		this.initPanelPersonalData();

		UtilityClass.addBorder(this, 20, 20, 20, 20);

		this.requestFocusInWindow(true);
	}

	private void initPanelPersonalData() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 10, 30, 20);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0, 1, 1);
		this.add(lblIdSet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, 1, 1);
		gbc.anchor = GridBagConstraints.WEST;
		this.add(lblId, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1, 1, 1);
		this.add(lblDoc, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 2, 1, 1);
		this.add(lblName, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 2, 1, 1);
		this.add(lblLastName, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 3, 2, 1);
		this.add(lblBirthDate, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 4, 1, 1);
		this.add(lblPhone, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 4, 1, 1);
		this.add(lblEmail, gbc);

		UtilityClass.organizeGridLayout(gbc, 0, 5, 1, 1);
		this.add(lblAddress, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 5, 1, 1);
		this.add(lblActiv, gbc);
		
//		UtilityClass.organizeGridLayout(gbc, 0, 6, 1, 1);
//		this.add(lblPet, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 8, 4, 1);
		this.add(lblInfo, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		
		UtilityClass.organizeGridLayout(gbc, 1, 1, 1, 1);
		this.jtfDoc.addKeyListener(ControlClient.getInstance());
		this.add(jtfDoc, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 2, 1, 1);
		this.jtfName.addKeyListener(ControlClient.getInstance());
		this.add(jtfName, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 2, 1, 1);
		this.jtfLastName.addKeyListener(ControlClient.getInstance());
		this.add(jtfLastName, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 3, 1, 1);
		this.birthdayDateChooser.setPreferredSize(new Dimension(100, 20));
		this.birthdayDateChooser.setMaxSelectableDate(new Date());
		this.add(birthdayDateChooser, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 4, 1, 1);
		this.jtfPhone.addKeyListener(EnterListener.getInstance());
		this.add(jtfPhone, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 4, 1, 1);
		this.add(jtfEmail, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 5, 1, 1);
		this.add(jtfAdress, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 5, 1, 1);
		activRadioButton.setSelected(true);
		inactivRadioButton.setFocusable(false);
		activRadioButton.setFocusable(false);
		buttonGroup.add(activRadioButton);
		buttonGroup.add(inactivRadioButton);
		jPanelRadios.add(activRadioButton, BorderLayout.WEST);
		jPanelRadios.add(inactivRadioButton, BorderLayout.EAST);
		this.add(jPanelRadios, gbc);
		
//		UtilityClass.organizeGridLayout(gbc, 3, 6, 1, 1);
//		addPetButton.setForeground(Color.WHITE);
//		addPetButton.setFocusable(false);
//		addPetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		addPetButton.setFont(ConstantView.FONT_LABELS_LOGIN);
//		UtilityClass.addCommandJButton(addPetButton, ClientCommands.CMD_BT_NEW_PET.toString(), ControlClient.getInstance());
//		ImageIcon icon = new ImageIcon(ConstantView.IMG_PET_SIGNIN);
//		addPetButton.setIcon(icon);
//		this.add(addPetButton, gbc);
		
		this.addButtons();
		
		UtilityClass.organizeGridLayout(gbc, 2, 7, 2, 1);
		gbc.gridwidth = 2;
		this.add(jPanelButtons, gbc);
	}
	
	private void addButtons() {		
		UtilityClass.addCommandJButton(cleanButton, ClientCommands.CMD_WD_UPDATE_CLEAR.toString(), ControlClient.getInstance());
		this.cleanButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.cleanButton.setForeground(Color.WHITE);
		this.cleanButton.setFocusable(false);
		this.cleanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.cleanButton.setFont(ConstantView.FONT_LABELS_LOGIN);
		jPanelButtons.add(cleanButton);
	}

	public void clearFields() {
		this.jtfAdress.setText("");
		this.jtfEmail.setText("");
		this.jtfLastName.setText("");
		this.jtfName.setText("");
		this.jtfPhone.setText("");
		this.jtfDoc.setText("");
		this.birthdayDateChooser.setDate(new Date());
	}
	
	public void newForm() {
		this.jtfAdress.setText("");
		this.jtfEmail.setText("");
		this.jtfDoc.setText("");
		this.jtfLastName.setText("");
		this.jtfName.setText("");
		this.jtfPhone.setText("");
		this.jtfAdress.setText("");
		try {
			this.birthdayDateChooser = new JDateChooser(sdf.parse("00/00/2000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.activRadioButton.setSelected(true);
	}
	
	public void createAutomaticID() {
		SQLPeople sqlPeople = new SQLPeople();
		lblIdSet.setText(""+(sqlPeople.getLastIdPerson()+1));
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

	public boolean isFieldIsEmpty(JTextField jtf) {
		return jtf.getText().length() == 0;
	}
	
}
