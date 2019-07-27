package com.cmv.petGenesis.view.clientManagement;

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
import javax.swing.JTextField;

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.model.ActivationState;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelCreateClient extends JPanel {

	private CustomLabel title;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelButtons;
	private JPanelFormClient jPanelFormClient;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateClient() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_SIGNIN);
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelFormClient = new JPanelFormClient();
		ControlClient.getInstance().setjPanelCreateClient(this);
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
		this.add(jPanelFormClient, BorderLayout.CENTER);
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
		this.okButton.addActionListener(ControlClient.getInstance());
		this.okButton.setActionCommand(ClientCommands.OK_SIGN_IN.toString());
		this.panelButtons.add(okButton, gbc);
	}
	
	public void clearFileds() {
		this.jPanelFormClient.clearFields();
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
		if (jPanelFormClient.birthdayDateChooser.getDate() != null)
			return sdf.format(jPanelFormClient.birthdayDateChooser.getDate());
		return null;
	}

	public CustomTxtField getJtfName() {
		return jPanelFormClient.jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jPanelFormClient.jtfLastName;
	}
	
	public CustomTxtField getJtfDoc() {
		return jPanelFormClient.jtfDoc;
	}

	public void showUserName() {
//		if (!isFieldIsEmpty(jPanelFormClient.jtfName) && !isFieldIsEmpty(jPanelFormClient.jtfLastName)) {
//			jPanelFormClient.jtfClientName.setText(LoginManage.getInstance().useName(jPanelFormClient.jtfName.getText(),
//					jPanelFormClient.jtfLastName.getText()));
//		}
	}


	public boolean isFieldIsEmpty(JTextField jtf) {
		return jtf.getText().length() == 0;
	}

	public CustomTxtField getJtfPhone() {
		return jPanelFormClient.jtfPhone;
	}
	
	public void saveDataSignIn(Client client) {
		SQLPeople sqlPeople = new SQLPeople();

		JTextField[] requiredFields = { jPanelFormClient.jtfDoc, jPanelFormClient.jtfName, jPanelFormClient.jtfLastName,
				jPanelFormClient.jtfPhone };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {
			if (sqlPeople.existDocumentId(Integer.parseInt(jPanelFormClient.jtfDoc.getText()))) {

				if (sqlPeople.existPhone(jPanelFormClient.jtfPhone.getText()) == 0) {

					if (UtilityClass.validateEmail(jPanelFormClient.jtfEmail.getText())
							|| jPanelFormClient.jtfEmail.getText().length() == 0) {

						client.setPersonalIdentification(jPanelFormClient.jtfDoc.getText());
						client.setName(jPanelFormClient.jtfName.getText());
						client.setLastName(jPanelFormClient.jtfLastName.getText());
						client.setBirthDate(jPanelFormClient.birthdayDateChooser.getDate());
						client.setTelephone(jPanelFormClient.jtfPhone.getText());
						client.setEmail(jPanelFormClient.jtfEmail.getText());
						client.setAddress(jPanelFormClient.jtfAdress.getText());
						client.setActivationState(
								ActivationState.getState(jPanelFormClient.activRadioButton.isSelected()));
						if (sqlPeople.registerDataClient(client)) {
							JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
							jPanelFormClient.newForm();
							this.jPanelFormClient.createAutomaticID();
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
		}
	}
	
}
