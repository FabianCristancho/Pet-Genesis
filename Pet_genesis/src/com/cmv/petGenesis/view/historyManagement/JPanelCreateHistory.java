package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;



public class JPanelCreateHistory extends JPanel{
	
	private CustomLabel title;
	private JButton okButton;
	private JButton returnButton;
	private JPanel panelButtons;
	private JPanelFormDataPet jPanelFormDataPet;
	private JPanelMedicine jPanelMedicine;
	private JPanelDataPet jPanelDataPet;
	private JPanelComments jPanelComments;
	private JTabbedPane modules;

	/**
	 * Constructor que inicaliza los componetes del panel de registro
	 */
	public JPanelCreateHistory() {
		super(new BorderLayout());
		this.title = new CustomLabel(ConstantView.TITLE_WD_CREATE_HISTORY);
		this.okButton = new JButton(ConstantView.BUTTON_OK_SIGNIN);
		this.returnButton = new JButton(ConstantView.BUTTON_RETURN_SIGNIN);
		this.jPanelFormDataPet = new JPanelFormDataPet();
		this.jPanelMedicine = new JPanelMedicine();
		this.jPanelComments = new JPanelComments();
		this.modules = new JTabbedPane();
		this.jPanelDataPet = new JPanelDataPet();
		this.init();
	}

	/**
	 * Crea y agrega los componentes del panel de registro
	 */
	private void init() {
		this.setOpaque(false);
		this.initModules();
		this.initPanelButtons();

		UtilityClass.addBorder(this, 20, 20, 20, 20);
		
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);
		
		this.add(panelButtons, BorderLayout.SOUTH);
		this.add(modules, BorderLayout.CENTER);
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
	
	private void initModules() {
		this.modules.add(ConstantView.TABBED_DATA_PET, jPanelDataPet);
		this.modules.add(ConstantView.TABBED_APPOINT_PET, new JPanel());
		this.modules.add(ConstantView.TABBED_MEDICINE_PET, jPanelMedicine);
		this.modules.add(ConstantView.TABBED_COMMENTS_PET, jPanelComments);
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
