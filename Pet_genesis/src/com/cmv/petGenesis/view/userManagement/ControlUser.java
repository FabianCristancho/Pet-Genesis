package com.cmv.petGenesis.view.userManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.Usuario;

public class ControlUser implements ActionListener, FocusListener, KeyListener {

	private static ControlUser controlUser;
	private JFrameUser jFrameUser;
	private JPanelCreateUser jPanelCreateUser;
	private JPanelFormUser jPanelFormUser;
	private JpanelFindUser jpanelFindUser;
	private JpanelUpdateClient jpanelUpdateClient;

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
			jpanelFindUser.searchByParameter();
			jpanelFindUser.getBtnLoadData().setEnabled(true);
			break;
		case CMD_LOAD_DATA:
			jpanelFindUser.loadAllData();
			break;
		case OK_SIGN_IN:
			saveDataSignIn();
			break;
		case CMD_WD_UPDATE_SEARCH:
			jpanelUpdateClient.getDataQuery();
			break;
		case CMD_WD_UPDATE_CHANGE_DATA:
			jpanelUpdateClient.saveDataSignIn(new Usuario());
			break;
		case CMD_WD_UPDATE_RETURN:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
			break;

		default:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
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

	public void setJpanelFindUser(JpanelFindUser jpanelFindUser) {
		this.jpanelFindUser = jpanelFindUser;
	}

	public void setjPanelFormUser(JPanelFormUser jPanelFormUser) {
		this.jPanelFormUser = jPanelFormUser;
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
		if ((e.getComponent().equals(jPanelCreateUser.getJtfName())
				|| e.getComponent().equals(jPanelCreateUser.getJtfLastName()))
				|| (e.getComponent().equals(jpanelUpdateClient.getJtfName())
						|| e.getComponent().equals(jpanelUpdateClient.getJtfLastName()))) {
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
				e.consume();
		} else if ((e.getComponent().equals(jPanelCreateUser.getJtfId())
				|| e.getComponent().equals(jPanelCreateUser.getJtfPhone()))
				|| (e.getComponent().equals(jpanelUpdateClient.getJtfId())
				|| e.getComponent().equals(jpanelUpdateClient.getJtfPhone()))) {
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

	public void setJpanelUpdateClient(JpanelUpdateClient jpanelUpdateClient) {
		this.jpanelUpdateClient = jpanelUpdateClient;
	}

}
