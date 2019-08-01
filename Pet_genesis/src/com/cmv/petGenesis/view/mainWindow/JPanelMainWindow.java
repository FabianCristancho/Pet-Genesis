package com.cmv.petGenesis.view.mainWindow;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;

/**
 * JPanelMainWindow, crea la ventana principal de la aplicacion
 * 
 * @version 1.0 - 28/09/2018
 * @author Fabian Alejandro Cristancho Rincon
 *
 */
public class JPanelMainWindow extends JPanel {

	private JLabel mainTitle;
	private JButton buttonExit;
	private JButton buttonSettings;
	private JLabel nameUser;
	private JPanelWindowButtons jWindowButtons;

	/**
	 * Instancia los componentes que va a tener la ventana
	 */
	public JPanelMainWindow(User user) {
		super();
		this.mainTitle = new JLabel("BIENVENIDO A PET GENESIS");
		this.buttonExit = new JButton("SALIR");
		this.buttonSettings = new JButton("Config");
		this.jWindowButtons = new JPanelWindowButtons(user.getTypeUser().getIdTypeUser());
		this.nameUser = new JLabel(user.getNameUser());
		init();
	}

	/**
	 * Agrega los componentes al panel
	 */
	private void init() {
		setComponents();
		this.setLayout(null);
		this.setBackground(Color.decode("#68C0EC"));
		this.add(mainTitle);
		this.add(jWindowButtons);
		this.add(buttonSettings);
		this.add(buttonExit);
		this.add(nameUser);
	}

	/**
	 * Da propiedades a los componentes que va a tener la ventana principal
	 */
	private void setComponents() {
		this.mainTitle.setForeground(Color.WHITE);
		this.mainTitle.setFont(new Font("Elephant", Font.BOLD, 26));
		this.mainTitle.setBounds(50, 20, 500, 20);
		this.nameUser.setBounds(50, 44, 100, 40);
		this.buttonSettings.setBackground(new Color(29, 69, 65));
		this.buttonSettings.setForeground(Color.WHITE);
		this.buttonSettings.setFocusable(false);
		this.buttonSettings.setBorderPainted(false);
		this.buttonSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonExit.setBounds(460, 500, 100, 50);
		this.buttonExit.setFont(new Font("Consolas", Font.CENTER_BASELINE, 20));
		this.buttonExit.setForeground(new Color(0, 0, 145));
		this.buttonExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
