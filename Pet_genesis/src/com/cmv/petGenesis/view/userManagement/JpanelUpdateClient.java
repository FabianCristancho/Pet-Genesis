package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cmv.petGenesis.model.Hash;
import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;

public class JpanelUpdateClient extends JPanel {

	private JLabel titlePanel;
	private JLabel idUser;
	private JLabel descriptionLabel;
	private JTextField jtfInputId;
	private JPanel jPanelUp;
	private JPanelFormUser jpanelCenter;
	private JPanel jPanelDown;
	private JButton btnSearchUser;
	private JButton btnReturn;
	private JButton btnUpdateUser;
	private JComboBox<String> parameters;

	public JpanelUpdateClient() {
		super(new BorderLayout());
		this.titlePanel = new JLabel(ConstantView.LABEL_TITLE_UPDATE_USER);
		this.idUser = new JLabel();
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

	private void init() {
		initPanelUp();
		initpanelDown();
		UtilityClass.addBorder(this, 20, 20, 20, 20);
		this.add(jPanelUp, BorderLayout.NORTH);
		this.add(jpanelCenter, BorderLayout.CENTER);
		this.add(jPanelDown, BorderLayout.SOUTH);
	}

	private void initPanelUp() {
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 30, 0, 30);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		this.titlePanel.setFont(ConstantView.FONT_TITLE_CRUD);
		this.jPanelUp.add(titlePanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
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

	private void initpanelDown() {
		this.jPanelDown = new JPanel(new GridBagLayout());
		this.jPanelDown.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.jPanelDown.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.btnReturn.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnReturn.setForeground(Color.WHITE);
		this.btnReturn.setFocusable(false);
		this.btnReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnReturn.setFont(ConstantView.FONT_LABELS_LOGIN);
		UtilityClass.addCommandJButton(btnReturn, UserCommands.CMD_WD_UPDATE_RETURN.toString(),
				ControlUser.getInstance());
		this.jPanelDown.add(btnReturn, gbc);

		gbc.gridx = 7;
		this.btnUpdateUser.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnUpdateUser.setForeground(Color.WHITE);
		this.btnUpdateUser.setFocusable(false);
		this.btnUpdateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnUpdateUser.setFont(ConstantView.FONT_LABELS_LOGIN);
		UtilityClass.addCommandJButton(btnUpdateUser, UserCommands.CMD_WD_UPDATE_CHANGE_DATA.toString(),
				ControlUser.getInstance());
		this.jPanelDown.add(btnUpdateUser, gbc);
	}

	public String getParam() {
		switch (parameters.getSelectedIndex()) {
		case 0:
			return "id_usuario";
		case 1:
			return "documento_usuario";
		case 2:
			return "usuario";
		default:
			return "";
		}
	}

	public void getDataQuery() {
		SqlUSer sqlUSer = new SqlUSer();
		ArrayList<Object[]> data = sqlUSer.loadData(getParam(), jtfInputId.getText());

		if (data.size() != 0) {
			Object[] register = data.get(0);
			this.idUser.setText(""+register[0]);
			jpanelCenter.jtfId.setText((String) register[1]);
			jpanelCenter.jtfName.setText((String) register[2]);
			jpanelCenter.jtfLastName.setText((String) register[3]);
			jpanelCenter.birthdayDateChooser.setDate(UtilityClass.daysAdd((Date) register[4], 1));
			jpanelCenter.jtfPhone.setText((String) register[5]);
			jpanelCenter.jtfEmail.setText((String) register[6]);
			jpanelCenter.jtfAdress.setText((String) register[7]);
			jpanelCenter.comboUserType.setSelectedIndex(getRole((String) register[8]));

			if (isActive((String) register[9])) {
				jpanelCenter.activRadioButton.setSelected(true);
			}

			jpanelCenter.jtfUserName.setText((String) register[10]);

		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE EL USUARIO CONSULTADO");
		}
	}

	public void saveDataSignIn(Usuario mod) {
		SqlUSer modSql = new SqlUSer();

		String password = new String(jpanelCenter.jpfPassword.getPassword());
		String passwordAgain = new String(jpanelCenter.jpfPasswordAgain.getPassword());

		JTextField[] requiredFields = { jpanelCenter.jtfId, jpanelCenter.jtfName, jpanelCenter.jtfLastName,
				jpanelCenter.jtfUserName, jpanelCenter.jpfPassword, jpanelCenter.jpfPasswordAgain };
		if (UtilityClass.fieldsAreEmpty(requiredFields)) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {

			if (password.equals(passwordAgain)) {

				if (UtilityClass.validateEmail(jpanelCenter.jtfEmail.getText())
						|| jpanelCenter.jtfEmail.getText().length() == 0) {

					String newPass = Hash.sha1(password);
					mod.setId(Integer.parseInt(this.idUser.getText()));
					mod.setPersonalDocument(jpanelCenter.jtfId.getText());
					mod.setName(jpanelCenter.jtfName.getText());
					mod.setLastName(jpanelCenter.jtfLastName.getText());
					mod.setBirthDate(jpanelCenter.birthdayDateChooser.getDate());
					if (jpanelCenter.jtfPhone.getText().length() != 0) {
						mod.setPhone(Long.parseLong(jpanelCenter.jtfPhone.getText()));
					}
					mod.setEmail(jpanelCenter.jtfEmail.getText());
					mod.setAddress(jpanelCenter.jtfAdress.getText());
					mod.setTypeUser(TypeUser.getTypeUser(jpanelCenter.comboUserType.getSelectedIndex() + 1));
					mod.setState(jpanelCenter.activRadioButton.isSelected() ? jpanelCenter.activRadioButton.getText()
							: jpanelCenter.inactivRadioButton.getText());
					mod.setUserName(jpanelCenter.jtfUserName.getText());
					mod.setPassword(newPass);

					if (modSql.update(mod)) {
						JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Correo no valido", "CORREO SIN FORMATO",
							JOptionPane.INFORMATION_MESSAGE);

				}

			} else {
				JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
			}
		}
	}

	private int getRole(String role) {
		switch (role) {
		case "Gerente General":
			return 0;
		case "Médico":
			return 1;
		case "Asistente":
			return 2;
		case "Auxiliar":
			return 3;
		}
		return 0;
	}

	private boolean isActive(String state) {
		if (state.equals("Activo"))
			return true;
		return false;
	}

	public CustomTxtField getJtfName() {
		return jpanelCenter.jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jpanelCenter.jtfLastName;
	}

	public CustomTxtField getJtfId() {
		return jpanelCenter.jtfId;
	}

	public CustomTxtField getJtfPhone() {
		return jpanelCenter.jtfPhone;
	}
}
