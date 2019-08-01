package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.cmv.petGenesis.command.LoginCommands;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.view.about.JDialogAbout;
import com.cmv.petGenesis.view.mainWindow.JDialogLogin;
import com.cmv.petGenesis.view.mainWindow.JPanelLogin;

/**
 * Clase ControlLogin, escuchador que da soporte a las ventanas de inicio de
 * sesion
 * 
 * @author Yohan Caro - Fabian Cristancho
 * @version 1.0 - 30/07/2019
 *
 */
public class ControlLogin implements ActionListener, MouseListener, FocusListener, KeyListener {

	public static ControlLogin eventsLogin;
	private JDialogLogin enterJDialog;
	private JPanelLogin loginJPanel;

	private ControlLogin() {

	}

	/**
	 * Valida el panel de inicio de sesion
	 */
	private void validFieldsLogin() {
		loginJPanel.validFields(new User());
	}

	/**
	 * Obtiene una unica instancia de la propia clase
	 * 
	 * @return Unica instancia
	 */
	public static ControlLogin getInstance() {
		if (eventsLogin == null)
			eventsLogin = new ControlLogin();
		return eventsLogin;
	}

	/**
	 * Asigna un valor al objeto enterJDialog
	 * 
	 * @param enterJDialog objeto que llega
	 */
	public void setEnterJDialog(JDialogLogin enterJDialog) {
		this.enterJDialog = enterJDialog;
	}

	// Metodos sobreescritos

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (LoginCommands.valueOf(e.getActionCommand())) {
		case OK_LOGIN:
			validFieldsLogin();
			break;
		default:
			System.out.println(e.getActionCommand() + " no tiene una acción");
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().equals(this.loginJPanel.getImgHelp())) {
			System.out.println("Click en ayuda");
		} else if (e.getComponent().equals(this.loginJPanel.getImgAbout())) {
			JDialogAbout jDialogAbout = new JDialogAbout();
			jDialogAbout.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent().equals(this.loginJPanel.getImgHelp())) {
			System.out.println("Entra al boton de ayuda");
		} else if (e.getComponent().equals(this.loginJPanel.getImgAbout())) {
			System.out.println("Entra en información");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void setLoginJPanel(JPanelLogin loginJPanel) {
		this.loginJPanel = loginJPanel;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
