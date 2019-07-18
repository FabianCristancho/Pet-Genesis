package com.cmv.petGenesis.view.userManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cmv.petGenesis.model.Usuario;

public class ControlUser implements ActionListener, FocusListener, KeyListener {

	private static ControlUser controlUser;
	private JFrameUser jFrameUser;
	private JPanelCreateUser jPanelCreateUser;

	private ControlUser() {
	}

	public static ControlUser getInstance() {
		if (controlUser == null) {
			controlUser = new ControlUser();
		}
		return controlUser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (UserCommands.valueOf(e.getActionCommand())) {
		case CMD_CREATE_USER:
			jFrameUser.getJpanelGroupClient().showCreate();
			break;
		case CMD_UPDATE_USER:
			jFrameUser.getJpanelGroupClient().showUpdate();
			break;
		case CMD_INACTIV_USER:
			jFrameUser.getJpanelGroupClient().showUpdate();
			break;
		case CMD_FIND_USER:
			jFrameUser.getJpanelGroupClient().showFind();
			break;
		case CMD_SEARCH_USER:
			
			break;
		case OK_SIGN_IN:
			saveDataSignIn();
			break;

		default:
			break;
		}
	}
	
	private void saveDataSignIn() {
		Usuario mod = new Usuario();
		jPanelCreateUser.saveDataSignIn(mod);
	}
	

	public void setjFrameUser(JFrameUser jFrameUser) {
		this.jFrameUser = jFrameUser;
	}

	public void setjPanelCreateUser(JPanelCreateUser jPanelCreateUser) {
		this.jPanelCreateUser = jPanelCreateUser;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (e.getComponent().equals(jPanelCreateUser.getJtfName())
				|| e.getComponent().equals(jPanelCreateUser.getJtfLastName())) {
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
				e.consume();
		} else if (e.getComponent().equals(jPanelCreateUser.getJtfId())
				|| e.getComponent().equals(jPanelCreateUser.getJtfPhone())) {
			if (c < '0' || c > '9')
				e.consume();
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getComponent().equals(jPanelCreateUser.getJtfName())
				|| e.getComponent().equals(jPanelCreateUser.getJtfLastName())) {
			jPanelCreateUser.showUserName();
		}
	}
	
	
}
