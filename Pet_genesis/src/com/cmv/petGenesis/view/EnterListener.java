package com.cmv.petGenesis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EnterListener implements ActionListener, MouseListener, FocusListener {

	public static EnterListener eventsLogin;
	private EnterJDialog enterJDialog;
	private LoginJPanel loginJPanel;
	private SignInJPanel signInJPanel;

	private EnterListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (EnterCommands.valueOf(e.getActionCommand())) {
		case ENTER_SWITCH:
			this.enterJDialog.changeState();
			break;
		case OK_SIGN_IN:
			this.signInJPanel.validFields();
			break;
		case OK_LOGIN:
			this.loginJPanel.validFields();
			break;
		default:
			System.out.println(e.getActionCommand() + " no tiene una acción");
			break;
		}
	}

//	private void sendSignInData() {
//		try {
//			PokemonListener.sendData(ClientCommands.SIGNIN, this.enterJDialog.getData());
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//	}
//
//	private void sendLoginData() {
//		try {
//			PokemonListener.sendData(ClientCommands.LOGIN, this.enterJDialog.getData());
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//	}

	public static EnterListener getInstance() {
		if (eventsLogin == null)
			eventsLogin = new EnterListener();
		return eventsLogin;
	}

	public void setEnterJDialog(EnterJDialog enterJDialog) {
		this.enterJDialog = enterJDialog;
	}

	public void setSignInJPanel(SignInJPanel signInJPanel) {
		this.signInJPanel = signInJPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().equals(this.loginJPanel.getImgHelp())) {
			System.out.println("Click en ayuda");
		} else if (e.getComponent().equals(this.loginJPanel.getImgAbout())) {
			System.out.println("Click en información");
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

	public void setLoginJPanel(LoginJPanel loginJPanel) {
		this.loginJPanel = loginJPanel;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getComponent().equals(signInJPanel.getJtfName())
				|| e.getComponent().equals(signInJPanel.getJtfLastName())) {
			signInJPanel.showUserName();
		}
	}
}
