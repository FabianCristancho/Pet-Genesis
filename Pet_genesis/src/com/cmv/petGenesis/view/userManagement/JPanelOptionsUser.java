package com.cmv.petGenesis.view.userManagement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.controller.ControlUser;
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
		
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(50, 20, 50, 20));
		UtilityClass.addCommandJButton(btnCreateUser, UserCommands.CMD_CREATE_USER.toString(), al);
		this.add(btnCreateUser, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		UtilityClass.addCommandJButton(btnUpdateUser, UserCommands.CMD_UPDATE_USER.toString(), al);
		this.add(btnUpdateUser, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		UtilityClass.addCommandJButton(btnInactivUser, UserCommands.CMD_INACTIV_USER.toString(), al);
		this.add(btnInactivUser, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		UtilityClass.addCommandJButton(btnFindUser, UserCommands.CMD_FIND_USER.toString(), al);
		this.add(btnFindUser, gbc);
	}
}
