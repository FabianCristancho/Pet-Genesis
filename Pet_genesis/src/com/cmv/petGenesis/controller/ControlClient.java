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

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.model.Client;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.view.clientManagement.JFrameClient;
import com.cmv.petGenesis.view.clientManagement.JPanelCreateClient;
import com.cmv.petGenesis.view.clientManagement.JPanelFormClient;
import com.cmv.petGenesis.view.clientManagement.JPanelInactivClient;
import com.cmv.petGenesis.view.clientManagement.JpanelFindClient;
import com.cmv.petGenesis.view.clientManagement.JpanelUpdateClient;

public class ControlClient implements ActionListener, KeyListener, MouseListener, ItemListener {

	private static ControlClient controlClient;
	private JFrameClient jFrameClient;
	private JPanelCreateClient jPanelCreateClient;
	private JpanelFindClient jpanelFindClient;
	private JpanelUpdateClient jpanelUpdateClient;
	private JPanelInactivClient jPanelInactivClient;
	private JPanelFormClient jPanelFormClient;

	private ControlClient() {
	}

	public static ControlClient getInstance() {
		if (controlClient == null) {
			controlClient = new ControlClient();
		}
		return controlClient;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ClientCommands.valueOf(e.getActionCommand())) {
		case CMD_CREATE_CLIENT:
			jFrameClient.getJpanelGroupClient().showCreate();
			break;
		case CMD_UPDATE_CLIENT:
			jFrameClient.getJpanelGroupClient().showUpdate();
			break;
		case CMD_INACTIV_CLIENT:
			jFrameClient.getJpanelGroupClient().showInactive();
			break;
		case CMD_FIND_CLIENT:
			jFrameClient.getJpanelGroupClient().showFind();
			break;
		case CMD_SEARCH_CLIENT:
			jpanelFindClient.searchByParameter();
			jpanelFindClient.getBtnLoadData().setEnabled(true);
			break;
		case CMD_LOAD_DATA:
			jpanelFindClient.loadAllData();
			break;
		case OK_SIGN_IN:
			saveDataSignIn();
			break;
		case CMD_WD_UPDATE_SEARCH:
			jpanelUpdateClient.getDataQuery();
			break;
		case CMD_WD_UPDATE_CHANGE_DATA:
//			jpanelUpdateClient.saveDataSignIn(new Usuario());
			break;
		case CMD_WD_UPDATE_CLEAR:
			jPanelFormClient.clearFields();
			jPanelCreateClient.clearFileds();
			break;
		case CMD_WD_UPDATE_RETURN:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
			break;
		case CMD_WD_INACTIV_EXECUTE:
			jPanelInactivClient.changeWithField();
			break;
		case CMD_WD_CREATE_CLEAR:
			jPanelCreateClient.clearFileds();
		default:
			JOptionPane.showMessageDialog(null, "SIN ESTABLECER");
			break;
		}
	}

	private void saveDataSignIn() {
		jPanelCreateClient.saveDataSignIn(new Client());
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
		if ((e.getComponent().equals(jPanelCreateClient.getJtfName())
				|| e.getComponent().equals(jPanelCreateClient.getJtfLastName()))
				|| (e.getComponent().equals(jpanelUpdateClient.getJtfName())
						|| e.getComponent().equals(jpanelUpdateClient.getJtfLastName()))) {
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
				e.consume();
		} else if (e.getComponent().equals(jPanelCreateClient.getJtfPhone())
				|| e.getComponent().equals(jpanelUpdateClient.getJtfPhone())
				|| e.getComponent().equals(jPanelCreateClient.getJtfDoc())) {
			if (c < '0' || c > '9')
				e.consume();
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
		if(e.getComponent().equals(jPanelInactivClient.getjTable())) {
			jPanelInactivClient.setActivClient(e.getPoint());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals(jPanelInactivClient.getInactivActiv())) {
			this.jPanelInactivClient.changeStateButton(e.getStateChange());
		}
	}

	public void setjFrameClient(JFrameClient jFrameClient) {
		this.jFrameClient = jFrameClient;
	}

	public void setjPanelCreateClient(JPanelCreateClient jPanelCreateClient) {
		this.jPanelCreateClient = jPanelCreateClient;
	}

	public void setJpanelFindClient(JpanelFindClient jpanelFindClient) {
		this.jpanelFindClient = jpanelFindClient;
	}

	public void setJpanelUpdateClient(JpanelUpdateClient jpanelUpdateClient) {
		this.jpanelUpdateClient = jpanelUpdateClient;
	}
	
	public void setjPanelInactivClient(JPanelInactivClient jPanelInactivClient) {
		this.jPanelInactivClient = jPanelInactivClient;
	}

	public void setjPanelFormClient(JPanelFormClient jPanelFormClient) {
		this.jPanelFormClient = jPanelFormClient;
	}
}
