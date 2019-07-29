package com.cmv.petGenesis.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * JPanelWindowButtons, crea los botones de opciones de la ventana principal de
 * la aplicacion
 * 
 * @version 1.0 - 28/09/2018
 * @author Fabian Alejandro Cristancho Rincon
 *
 */
public class JPanelWindowButtons extends JPanel {

	private JButton buttonHistory;
	private JButton buttonClients;
	private JButton buttonUsers;
	private JButton buttonReport;
	private int privileges;

	/**
	 * Instancia los botones del panel
	 */
	public JPanelWindowButtons(int privileges) {
		super();
		this.buttonHistory = new JButton("<html><p>ADMINISTRAR HISTORIA</p><p>CLINICA</p></html>");
		this.buttonUsers = new JButton("ADMINISTRAR USUARIOS");
		this.buttonClients = new JButton("ADMINISTRAR CLIENTES");
		this.buttonReport = new JButton("GENERAR REPORTES");
		this.privileges = privileges;
		init();
	}

	/**
	 * Agrega los componentes al panel de botones
	 */
	private void init() {
		setComponents();
		this.setOpaque(false);
		this.setLayout(new GridLayout(2, 2, 10, 10));
		this.setBounds(new Rectangle(100, 85, 400, 400));
		this.add(buttonUsers);
		this.add(buttonClients);
		this.add(buttonHistory);
		this.add(buttonReport);
		
		if(privileges!=1) {
			this.buttonUsers.setEnabled(false);
			this.buttonUsers.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		if(privileges == 4) {
			this.buttonClients.setEnabled(false);
			this.buttonClients.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}

	/**
	 * Le da propiedades a los componentes del panel
	 */
	private void setComponents() {
		ActionListener al = ControlMainWindow.getInstance();
		this.buttonHistory.setFocusable(false);
		this.buttonHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		this.buttonHistory.setBackground(Color.decode("#3899E8"));
		UtilityClass.addCommandJButton(buttonHistory, MainWindowCommands.BUTTON_MNGM_HISTORY.toString(), al);
		
//		this.buttonUsers.setBackground(Color.decode("#3899E8"));
		this.buttonUsers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonUsers.setFocusable(false);
		UtilityClass.addCommandJButton(buttonUsers, MainWindowCommands.BUTTON_MNGM_USER.toString(), al);
		
		this.buttonClients.setFocusable(false);
		this.buttonClients.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UtilityClass.addCommandJButton(buttonClients, MainWindowCommands.BUTTON_MNGM_CLIENT.toString(), al);
		
		this.buttonReport.setFocusable(false);
		this.buttonReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UtilityClass.addCommandJButton(buttonReport, MainWindowCommands.BUTTON_MNGM_REPORT.toString(), al);
	}
}
