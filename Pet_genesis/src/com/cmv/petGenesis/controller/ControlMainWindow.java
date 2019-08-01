package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cmv.petGenesis.ReportManagement.JFrameReport;
import com.cmv.petGenesis.command.MainWindowCommands;
import com.cmv.petGenesis.view.about.JDialogAbout;
import com.cmv.petGenesis.view.clientManagement.JFrameClient;
import com.cmv.petGenesis.view.historyManagement.JFrameHistory;
import com.cmv.petGenesis.view.mainWindow.JFrameMainWindow;
import com.cmv.petGenesis.view.userManagement.JFrameUser;

/**
 * Clase ControlMainWindow, encargada de gestionar los escuchadores del menu
 * principal de la aplicacion
 * 
 * @author Fabian Cristancho - Yohan Caro
 * @version 1.0 - 30/07/2019
 *
 */
public class ControlMainWindow implements ActionListener {

	private static ControlMainWindow controlMainWindow;
	private JFrameMainWindow jFrameMainWindow;

	/**
	 * Constructor principal
	 */
	private ControlMainWindow() {
	}

	/**
	 * Constructor private
	 * 
	 * @return objeto de la misma clase
	 */
	public static ControlMainWindow getInstance() {
		if (controlMainWindow == null)
			controlMainWindow = new ControlMainWindow();
		return controlMainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (MainWindowCommands.valueOf(e.getActionCommand())) {
		case BUTTON_MNGM_USER:
			openUserManagementWindow();
			break;
		case BUTTON_MNGM_CLIENT:
			openClientManagementWindow();
			break;
		case BUTTON_MNGM_HISTORY:
			openHistoryManagementWindow();
			break;
		case BUTTON_MNGM_ABOUT:
			openAbout();
			break;

		default:
			break;
		}
	}

	/**
	 * Abre el dialogo de acerca de la aplicacion
	 */
	private void openAbout() {
		JDialogAbout jDialogAbout = new JDialogAbout();
		jDialogAbout.setVisible(true);
	}

	/**
	 * Abre la ventana de gestion de usuarios
	 */
	private void openUserManagementWindow() {
		new JFrameUser();
	}

	/**
	 * Abre la ventana de gestion de clientes
	 */
	private void openClientManagementWindow() {
		new JFrameClient();
	}

	/**
	 * Abre la ventana de gestion de historias clinicas
	 */
	private void openHistoryManagementWindow() {
		new JFrameHistory(this.jFrameMainWindow.getUser());
	}

	/**
	 * Asigna un nuevo JFrameMainWindow
	 * 
	 * @param jFrameMainWindow objeto JFrameMainWindow
	 */
	public void setjFrameMainWindow(JFrameMainWindow jFrameMainWindow) {
		this.jFrameMainWindow = jFrameMainWindow;
	}

	/**
	 * Abre ventana de reportes
	 */
	private void openUserReporttWindow() {
		new JFrameReport();
	}

}
