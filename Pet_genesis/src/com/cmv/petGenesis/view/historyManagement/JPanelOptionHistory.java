package com.cmv.petGenesis.view.historyManagement;

import java.awt.Color;
import java.awt.Cursor;
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
	private JButton btnNewConsult;

	/**
	 * Constructor del panel
	 */
	public JPanelOptionHistory() {
		super(new GridBagLayout());
		this.btnCreateHistory = new JButton(ConstantView.BUTTON_CREATE_HISTORY);
		this.btnUpdateHistory = new JButton(ConstantView.BUTTON_UPDATE_HISTORY);
		this.btnStateHistory = new JButton(ConstantView.BUTTON_STATE_HISTORY);
		this.btnFindHistory = new JButton(ConstantView.BUTTON_FIND_HISTORY);
		this.btnNewConsult = new JButton(ConstantView.BUTTON_NEW_CONSULT);
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
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(25, 20, 25, 20));
		UtilityClass.addCommandJButton(btnCreateHistory, HistoryCommands.CMD_BTN_CREATE_HISTORY.toString(), al);
		btnCreateHistory.setPreferredSize(new Dimension(220, 80));
		btnCreateHistory.setIcon(new ImageIcon(ConstantView.IMG_ADD_SIGNIN));
		btnCreateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCreateHistory.setMinimumSize(new Dimension(210, 80));
		btnCreateHistory.setFocusable(false);
		btnCreateHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnCreateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		UtilityClass.addCommandJButton(btnUpdateHistory, HistoryCommands.CMD_BTN_UPDATE_HISTORY.toString(), al);
		btnUpdateHistory.setPreferredSize(new Dimension(220, 80));
		btnUpdateHistory.setIcon(new ImageIcon(ConstantView.IMG_EDIT_SIGNIN));
		btnUpdateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUpdateHistory.setMinimumSize(new Dimension(210, 80));
		btnUpdateHistory.setFocusable(false);
		btnUpdateHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnUpdateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		UtilityClass.addCommandJButton(btnStateHistory, HistoryCommands.CMD_BTN_STATE_HISTORY.toString(), al);
		btnStateHistory.setPreferredSize(new Dimension(220, 80));
		btnStateHistory.setIcon(new ImageIcon(ConstantView.IMG_CHECK_SIGNIN));
		btnStateHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStateHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnStateHistory.setMinimumSize(new Dimension(210, 80));
		btnStateHistory.setFocusable(false);
		btnStateHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnStateHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		UtilityClass.addCommandJButton(btnFindHistory, HistoryCommands.CMD_BTN_FIND_HISTORY.toString(), al);
		btnFindHistory.setPreferredSize(new Dimension(220, 80));
		btnFindHistory.setIcon(new ImageIcon(ConstantView.IMG_GESTION_SIGNIN));
		btnFindHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFindHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFindHistory.setMinimumSize(new Dimension(210, 80));
		btnFindHistory.setFocusable(false);
		btnFindHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnFindHistory, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 8);
		UtilityClass.addCommandJButton(btnNewConsult, HistoryCommands.CMD_BTN_NEW_CONSULT.toString(), al);
		btnNewConsult.setIcon(new ImageIcon(ConstantView.IMG_NEW_CONSULT));
		btnNewConsult.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewConsult.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewConsult.setMinimumSize(new Dimension(220, 80));
		btnNewConsult.setFocusable(false);
		btnNewConsult.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnNewConsult, gbc);
	}
}
