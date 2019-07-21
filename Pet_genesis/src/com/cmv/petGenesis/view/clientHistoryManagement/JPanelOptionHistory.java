package com.cmv.petGenesis.view.clientHistoryManagement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelOptionHistory extends JPanel{
	
	private JButton btnCreateHistory;
	private JButton btnUpdateHistory;
	private JButton btnStateHistory;
	private JButton btnFindHistory;

	public JPanelOptionHistory() {
		super(new GridBagLayout());
		this.btnCreateHistory = new JButton(ConstantView.BUTTON_CREATE_HISTORY);
		this.btnUpdateHistory = new JButton(ConstantView.BUTTON_UPDATE_HISTORY);
		this.btnStateHistory = new JButton(ConstantView.BUTTON_STATE_HISTORY);
		this.btnFindHistory = new JButton(ConstantView.BUTTON_FIND_HISTORY);
		init();
	}

	private void init() {
		ActionListener al = ControlHistory.getInstance();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(50, 20, 50, 20));
		UtilityClass.addCommandJButton(btnCreateHistory, HistoryCommands.CMD_BTN_CREATE_HISTORY.toString(), al);
		this.add(btnCreateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		UtilityClass.addCommandJButton(btnUpdateHistory, HistoryCommands.CMD_BTN_UPDATE_HISTORY.toString(), al);
		this.add(btnUpdateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		UtilityClass.addCommandJButton(btnStateHistory, HistoryCommands.CMD_BTN_STATE_HISTORY.toString(), al);
		this.add(btnStateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		UtilityClass.addCommandJButton(btnFindHistory, HistoryCommands.CMD_BTN_FIND_HISTORY.toString(), al);
		this.add(btnFindHistory, gbc);
	}
}
