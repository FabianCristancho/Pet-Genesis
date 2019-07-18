package com.cmv.petGenesis.view.userManagement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelOptionsUser extends JPanel {
	
	private JButton btnCreateUser;
	private JButton btnUpdateUser;
	private JButton btnInactivUser;
	private JButton btnFindUser;

	public JPanelOptionsUser() {
		super(new GridBagLayout());
		this.btnCreateUser = new JButton(ConstantView.BUTTON_CREATE_USER);
		this.btnUpdateUser = new JButton(ConstantView.BUTTON_UPDATE_USER);
		this.btnInactivUser = new JButton(ConstantView.BUTTON_INACTIV_USER);
		this.btnFindUser = new JButton(ConstantView.BUTTON_FIND_USER);
		init();
	}

	private void init() {
		ActionListener al = ControlUser.getInstance();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(50, 20, 50, 20);
		gbc.gridx = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		UtilityClass.addCommandJButton(btnCreateUser, UserCommands.CMD_CREATE_USER.toString(), al);
		this.add(btnCreateUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		UtilityClass.addCommandJButton(btnUpdateUser, UserCommands.CMD_UPDATE_USER.toString(), al);
		this.add(btnUpdateUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		UtilityClass.addCommandJButton(btnInactivUser, UserCommands.CMD_INACTIV_USER.toString(), al);
		this.add(btnInactivUser, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		UtilityClass.addCommandJButton(btnFindUser, UserCommands.CMD_FIND_USER.toString(), al);
		this.add(btnFindUser, gbc);
	}
}
