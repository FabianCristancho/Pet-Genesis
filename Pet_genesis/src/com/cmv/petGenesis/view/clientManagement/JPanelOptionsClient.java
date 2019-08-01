package com.cmv.petGenesis.view.clientManagement;

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

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelOptionsClient - Se encarga de crear los botones de las opciones del cliente
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelOptionsClient extends JPanel {
	
	private JButton btnCreateClient;
	private JButton btnUpdateClient;
	private JButton btnInactivClient;
	private JButton btnFindClient;

	/**
	 * Constructor
	 */
	public JPanelOptionsClient() {
		super(new GridBagLayout());
		this.btnCreateClient = new JButton(ConstantView.BUTTON_CREATE_CLIENT);
		this.btnUpdateClient = new JButton(ConstantView.BUTTON_UPDATE_CLIENT);
		this.btnInactivClient = new JButton(ConstantView.BUTTON_INACTIV_CLIENT);
		this.btnFindClient = new JButton(ConstantView.BUTTON_FIND_CLIENT);
		init();
	}

	/**
	 * Inicializa los componentes
	 */
	private void init() {
		this.setBackground(Color.decode("#2E5569"));
		ActionListener al = ControlClient.getInstance();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(50, 20, 50, 20));
		UtilityClass.addCommandJButton(btnCreateClient, ClientCommands.CMD_CREATE_CLIENT.toString(), al);
		btnCreateClient.setIcon(new ImageIcon(ConstantView.IMG_ADD_SIGNIN));
		btnCreateClient.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreateClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCreateClient.setMaximumSize(new Dimension(200,70));
		btnCreateClient.setMinimumSize(new Dimension(200,70));
		this.add(btnCreateClient, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 2);
		UtilityClass.addCommandJButton(btnUpdateClient, ClientCommands.CMD_UPDATE_CLIENT.toString(), al);
		btnUpdateClient.setIcon(new ImageIcon(ConstantView.IMG_EDIT_SIGNIN));
		btnUpdateClient.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdateClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUpdateClient.setMaximumSize(new Dimension(200,70));
		btnUpdateClient.setMinimumSize(new Dimension(200,70));
		this.add(btnUpdateClient, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 4);
		UtilityClass.addCommandJButton(btnInactivClient, ClientCommands.CMD_INACTIV_CLIENT.toString(), al);
		btnInactivClient.setIcon(new ImageIcon(ConstantView.IMG_CHECK_SIGNIN));
		btnInactivClient.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInactivClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInactivClient.setMaximumSize(new Dimension(200,70));
		btnInactivClient.setMinimumSize(new Dimension(200,70));
		this.add(btnInactivClient, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 6);
		UtilityClass.addCommandJButton(btnFindClient, ClientCommands.CMD_FIND_CLIENT.toString(), al);
		btnFindClient.setIcon(new ImageIcon(ConstantView.IMG_GESTION_SIGNIN));
		btnFindClient.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFindClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFindClient.setMaximumSize(new Dimension(200,70));
		btnFindClient.setMinimumSize(new Dimension(200,70));
		this.add(btnFindClient, gbc);
	}
}
