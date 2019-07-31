package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.GenderPet;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Race;
import com.cmv.petGenesis.model.StatePet;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelCreateHistory extends JPanel {

	private CustomLabel title;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelButtons;
	private JPanelMedicine jPanelRecet;
	private JPanelDataPet jPanelDataPet;
	private JPanelConsult jPanelConsult;
	private JTabbedPane modules;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateHistory() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_WD_CREATE_HISTORY, null, Color.decode("#2E5569"));
		this.okButton = new JButton(ConstantView.BUTTON_REGISTER_HISTORY);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelRecet = new JPanelMedicine();
		this.modules = new JTabbedPane();
		this.jPanelDataPet = new JPanelDataPet();
		this.jPanelConsult = new JPanelConsult();
		ControlHistory.getInstance().setjPanelCreateHistory(this);
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setBackground(Color.decode("#c5dfed"));
		this.initModules();
		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 15, 20, 15);

		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);

		this.add(panelButtons, BorderLayout.SOUTH);
		this.add(modules, BorderLayout.CENTER);

		this.jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
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
		UtilityClass.addCommandJButton(okButton, HistoryCommands.CMD_WD_PET_REGISTER_HIS.toString(),
				ControlHistory.getInstance());
		this.panelButtons.add(okButton, gbc);
	}

	private void initModules() {
		this.modules.add(ConstantView.TABBED_DATA_PET, jPanelDataPet);
		this.modules.add(ConstantView.TABBED_APPOINT_PET, jPanelConsult);
		this.modules.add(ConstantView.TABBED_MEDICINE_PET, jPanelRecet);
	}

	public CustomTxtField getJtfPropietary() {
		return this.jPanelDataPet.getJtfPropietary();
	}

	public CustomTxtField getJtfNamePet() {
		return this.jPanelDataPet.getJtfNamePet();
	}

	public CustomTxtField getJtfColorPet() {
		return this.jPanelDataPet.getJtfColorPet();
	}

	public JComboBox<String> getComboSpecies() {
		return jPanelDataPet.getComboSpecies();
	}

	public void changeRaces() {
		jPanelDataPet.changeRaces();
	}

	public void registerHistory(Pet p) {
		SQLPets sqlPets = new SQLPets();
		if (jPanelDataPet.fieldsAreEmpty()) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar información en los campos que son obligatorios (*)",
					"EXISTENCIA DE CAMPOS VACIOS", JOptionPane.ERROR_MESSAGE);
		} else {
			SQLPeople sqlPeople = new SQLPeople();
			boolean validClient = false;
			if (jPanelDataPet.getComboParameter().getSelectedIndex() == 0) {
				if (!sqlPeople.existClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con codigo " + jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText())));
					validClient = true;
				}
			} else {
				if (!sqlPeople.existDocumentIdClient(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))) {
					JOptionPane.showMessageDialog(null,
							"No se ha encontrado el cliente con documento "
									+ jPanelDataPet.getJtfPropietary().getText(),
							"CLIENTE NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setClient(new Client(
							sqlPeople.getIdByPersonalId(Integer.parseInt(jPanelDataPet.getJtfPropietary().getText()))));
					validClient = true;
				}
			}
			if (validClient) {
				p.setNamePet(jPanelDataPet.getJtfNamePet().getText());
				p.setBirthDate(jPanelDataPet.getBirthDatePet().getDate());
				p.setRace(new Race(jPanelDataPet.getComboRaces().getSelectedIndex() + 1));
				p.setColorPet(jPanelDataPet.getJtfColorPet().getText());
				p.setGenderPet(GenderPet.getGender(jPanelDataPet.maleIsSelected()));
				p.setStatePet(StatePet.getState(jPanelDataPet.getComboStatePet().getSelectedIndex()));
				p.setCastrated(jPanelDataPet.isCastrated());
				p.setAditionalDescription(jPanelDataPet.getComments());
				if (sqlPets.registerPet(p)) {
					JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CON EXITO");
					this.jPanelDataPet.getjPanelFormDataPet().createAutomaticID();
					this.jPanelDataPet.newForm();
				} else {
					JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
				}
			}
		}
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
//	public String getBirthDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		if (jPanelFormUser.birthdayDateChooser.getDate() != null)
//			return sdf.format(jPanelFormUser.birthdayDateChooser.getDate());
//		return null;
//	}
//
//	public void validFields() {
//		if (isFieldIsEmpty(jPanelFormUser.jtfName) || isFieldIsEmpty(jPanelFormUser.jtfLastName) || isFieldIsEmpty(jPanelFormUser.jpfPassword)
//				|| isFieldIsEmpty(jPanelFormUser.jpfPasswordAgain)) {
//			JOptionPane.showMessageDialog(null, "SE DEBEN INGRESAR LOS CAMPOS OBLIGATORIOS");
//		} else {
//			try {
//				LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText(),
//						PasswordUtil.getHash(String.valueOf(jPanelFormUser.jpfPassword.getPassword())));
//				JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if (!String.valueOf(jPanelFormUser.jpfPassword.getPassword()).equals(String.valueOf(jPanelFormUser.jpfPasswordAgain.getPassword()))) {
//			JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
//		} else {
//			if (isFieldIsEmpty(jPanelFormUser.jpfPassword) || isFieldIsEmpty(jPanelFormUser.jpfPassword)) {
//				JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO LA CONTRSEÑA");
//			} else {
//				try {
//					LoginManage.getInstance().generateUsername(jPanelFormUser.jtfName.getText(), jPanelFormUser.jtfLastName.getText(),
//							PasswordUtil.getHash(String.valueOf(jPanelFormUser.jpfPassword.getPassword())));
//					JOptionPane.showMessageDialog(null, "SE HA REGISTRADO AL USUARIO CON EXITO");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
