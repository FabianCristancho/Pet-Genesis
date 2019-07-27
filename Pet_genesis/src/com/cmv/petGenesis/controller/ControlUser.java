package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.model.Person;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.cmv.petGenesis.view.userManagement.JFrameUser;
import com.cmv.petGenesis.view.userManagement.JPanelCreateUser;
import com.cmv.petGenesis.view.userManagement.JPanelFormUser;
import com.cmv.petGenesis.view.userManagement.JPanelInactivUser;
import com.cmv.petGenesis.view.userManagement.JpanelFindUser;
import com.cmv.petGenesis.view.userManagement.JpanelUpdateUser;

public class ControlUser implements ActionListener, FocusListener, KeyListener, MouseListener, ItemListener {

	private static ControlUser controlUser;
	private JFrameUser jFrameUser;
	private JPanelCreateUser jPanelCreateUser;
	private JpanelFindUser jpanelFindUser;
	private JpanelUpdateUser jpanelUpdateClient;
	private JPanelInactivUser jPanelInactivUser;
	private JPanelFormUser jPanelFormUser;

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
			jFrameUser.getJpanelGroupClient().showInactive();
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
			jpanelUpdateClient.getDataQueryUpdate();
			break;
		case CMD_WD_UPDATE_CHANGE_DATA:
			jpanelUpdateClient.saveDataSignIn(new User());
			jpanelUpdateClient.clearFields();
			break;
		case CMD_WD_UPDATE_CLEAR:
			jPanelFormUser.clearFields();
			break;
		case CMD_WD_UPDATE_RETURN:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
			break;
		case CMD_WD_INACTIV_EXECUTE:
			jPanelInactivUser.changeWithField();
			break;

		default:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
			break;
		}
	}

	private void saveDataSignIn() {
		jPanelCreateUser.saveDataSignIn(new User());
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
			jPanelCreateUser.generateUserName();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getComponent().equals(jPanelInactivUser.getjTable())) {
			jPanelInactivUser.setActivUser(e.getPoint());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals(jPanelInactivUser.getInactivActiv())) {
			this.jPanelInactivUser.changeStateButton(e.getStateChange());
		}
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

	public void setJpanelUpdateClient(JpanelUpdateUser jpanelUpdateClient) {
		this.jpanelUpdateClient = jpanelUpdateClient;
	}
	
	public void setjPanelInactivUser(JPanelInactivUser jPanelInactivUser) {
		this.jPanelInactivUser = jPanelInactivUser;
	}

	public void setjPanelFormUser(JPanelFormUser jPanelFormUser) {
		this.jPanelFormUser = jPanelFormUser;
	}
}
