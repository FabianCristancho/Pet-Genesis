package com.cmv.petGenesis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EnterListener implements ActionListener {

	public static EnterListener eventsLogin;
	private EnterJDialog enterJDialog;

	private EnterListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (EnterCommands.valueOf(e.getActionCommand())) {
		case ENTER_SWITCH:
			this.enterJDialog.changeState();
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
}
