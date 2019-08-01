package com.cmv.petGenesis.view.historyManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelOptionHistory - Se encarga de rear el panel con los botones de las 
 * opciones para visualizar un panel de las historias
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelOptionHistory extends JPanel{
	
	private JButton btnCreateHistory;
	private JButton btnUpdateHistory;
	private JButton btnStateHistory;
	private JButton btnFindHistory;

	/**
	 * Constructor del panel
	 */
	public JPanelOptionHistory() {
		super(new GridBagLayout());
		this.btnCreateHistory = new JButton(ConstantView.BUTTON_CREATE_HISTORY);
		this.btnUpdateHistory = new JButton(ConstantView.BUTTON_UPDATE_HISTORY);
		this.btnStateHistory = new JButton(ConstantView.BUTTON_STATE_HISTORY);
		this.btnFindHistory = new JButton(ConstantView.BUTTON_FIND_HISTORY);
		init();
	}

	/**
	 * Inicializa los botones del panel
	 */
	private void init() {
		ActionListener al = ControlHistory.getInstance();
		this.setBackground(Color.decode("#2E5569"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(50, 20, 50, 20));
		UtilityClass.addCommandJButton(btnCreateHistory, HistoryCommands.CMD_BTN_CREATE_HISTORY.toString(), al);
		btnCreateHistory.setIcon(new ImageIcon(ConstantView.IMG_ADD_SIGNIN));
		btnCreateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCreateHistory.setMaximumSize(new Dimension(220,70));
		btnCreateHistory.setMinimumSize(new Dimension(220,70));
		this.add(btnCreateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		UtilityClass.addCommandJButton(btnUpdateHistory, HistoryCommands.CMD_BTN_UPDATE_HISTORY.toString(), al);
		btnUpdateHistory.setIcon(new ImageIcon(ConstantView.IMG_EDIT_SIGNIN));
		btnUpdateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUpdateHistory.setMaximumSize(new Dimension(220,70));
		btnUpdateHistory.setMinimumSize(new Dimension(220,70));
		this.add(btnUpdateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		UtilityClass.addCommandJButton(btnStateHistory, HistoryCommands.CMD_BTN_STATE_HISTORY.toString(), al);
		btnStateHistory.setIcon(new ImageIcon(ConstantView.IMG_CHECK_SIGNIN));
		btnStateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnStateHistory.setMaximumSize(new Dimension(220,70));
		btnStateHistory.setMinimumSize(new Dimension(220,70));
		this.add(btnStateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		UtilityClass.addCommandJButton(btnFindHistory, HistoryCommands.CMD_BTN_FIND_HISTORY.toString(), al);
		btnFindHistory.setIcon(new ImageIcon(ConstantView.IMG_GESTION_SIGNIN));
		btnFindHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFindHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFindHistory.setMaximumSize(new Dimension(220,70));
		btnFindHistory.setMinimumSize(new Dimension(220,70));
		this.add(btnFindHistory, gbc);
	}
}
