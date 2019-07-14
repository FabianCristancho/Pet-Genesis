package com.cmv.petGenesis.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;

public class EnterJDialog extends JDialog {
	private static EnterJDialog enterJDialog;
	private CardLayout cardLayout;
	private LoginJPanel loginJPanel;
	private SignInJPanel signInJPanel;
	private JToggleButton switchButton;
	private JPanel downJPanel;

	/**
	 * Constructor que iniclaiza los componetes que va atener el dialog del
	 * login
	 */
	private EnterJDialog() {
		EnterListener.getInstance().setEnterJDialog(this);
		this.switchButton = new JToggleButton(ConstantsLogin.LOGIN_USER);
		this.cardLayout = new CardLayout();
		this.loginJPanel = new LoginJPanel();
		this.signInJPanel = new SignInJPanel();
		this.downJPanel = new JPanel(cardLayout);
		this.init();
	}

	/**
	 * Añade los componentes al JDialog del login
	 */
	private void init() {
		this.setIconImage(new ImageIcon("./res/icons/icon.png").getImage());
		JLabel backgroundImage = new JLabel(new ImageIcon("./res/images/loginBack.jpg"));
		backgroundImage.setLayout(new BorderLayout());
		JPanel upJPanel = new JPanel(new FlowLayout());
		upJPanel.setOpaque(false);
		this.switchButton.setFont(ConstantsLogin.FONT_LOG);
		this.switchButton.setBackground(Color.WHITE);
		this.switchButton.setOpaque(false);
		switchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.switchButton.setActionCommand(EnterCommands.ENTER_SWITCH.toString());
		this.switchButton.addActionListener(EnterListener.getInstance());
		this.switchButton.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return new Color(0, 0, 0, 0);
			}
		});
		this.switchButton.setBorder(null);

		upJPanel.add(switchButton);
		backgroundImage.add(upJPanel, BorderLayout.SOUTH);

		downJPanel.add(loginJPanel, ConstantsLogin.LOGIN);
		downJPanel.add(signInJPanel, ConstantsLogin.SIGN_IN);
		this.downJPanel.setOpaque(false);
		backgroundImage.add(downJPanel, BorderLayout.CENTER);
		this.add(backgroundImage);
		this.setTitle(ConstantsLogin.TITLE_ENTER_DIALOG);
		this.setSize(600, 550);
		this.setBackground(ConstantsLogin.COLOR_LB_BACKGROUND);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Muestra la carta del card layout
	 * @param name nombre de la carta
	 */
	public void show(String name) {
		this.cardLayout.show(this.downJPanel, name);
		this.repaint();
	}

	/**
	 * Cambia de Panel 
	 */
	public void changeState() {
		if (this.switchButton.isSelected()) {
			this.setSize(950, 550);
			this.switchButton.setText(ConstantsLogin.LOGIN_TEXT);
			this.show(ConstantsLogin.SIGN_IN);
			this.loginJPanel.clearFields();
			this.setLocationRelativeTo(null);
		} else {
			this.setSize(600, 550);
			this.switchButton.setText(ConstantsLogin.SINGIN_TEXT);
			this.show(ConstantsLogin.LOGIN);
			this.signInJPanel.clearFields();
			this.setLocationRelativeTo(null);
		}
	}

	public void clearFields() {
		this.loginJPanel.clearFields();
		this.signInJPanel.clearFields();
		
	}

	/**
	 * Setea el estado
	 * @param state boolean con el estado
	 */
	public void setSignInState(boolean state) {
		this.switchButton.setSelected(state);
	}

	/**
	 * Pasa los datos a un array de bytes
	 * @return bytes los bytes
	 * @throws IOException excepcion
	 */
//	public byte[] getData() throws IOException {
//		if (this.switchButton.isSelected())
//			return this.signInJPanel.getBytes();
//		return this.loginJPanel.getBytes();
//	}

	/**
	 * Crea la instancia de la clase
	 * @return enterJDioalog objeto instanciado
	 */
	public static EnterJDialog getInstance() {
		if (enterJDialog == null)
			enterJDialog = new EnterJDialog();
		return enterJDialog;
	}

}
