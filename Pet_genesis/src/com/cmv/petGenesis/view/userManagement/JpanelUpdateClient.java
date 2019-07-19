package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomTxtField;


public class JpanelUpdateClient extends JPanel{
	
	private JLabel titlePanel;
	private JLabel descriptionLabel;
	private JTextField jtfInputId;
	private JPanel jPanelUp;
	private JPanelFormUser jpanelCenter;
	private JPanel jPanelDown;
	private JButton btnSearchId;
	private JButton btnReturn;
	private JButton btnUpdateUser;
	
	public JpanelUpdateClient() {
		super(new BorderLayout());
		this.titlePanel = new JLabel(ConstantView.LABEL_TITLE_UPDATE_USER);
		this.descriptionLabel = new JLabel(ConstantView.LABEL_DESCRIPTION_UPDATE_USER);
		this.btnSearchId = new JButton(ConstantView.BTN_SEARCH_UPDATE_USER);
		this.jtfInputId = new JTextField(20);
		this.jPanelUp = new JPanel();
		this.jpanelCenter = new JPanelFormUser();
		ControlUser.getInstance().setJpanelUpdateClient(this);
		init();
	}

	private void init() {
		initPanelUp();
		this.add(jPanelUp, BorderLayout.NORTH);
		this.add(jpanelCenter, BorderLayout.CENTER);
	}
	
	private void initPanelUp() {
		this.jPanelUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets= new Insets(20, 30, 0, 30);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.titlePanel.setFont(ConstantView.FONT_TITLE_CRUD);
		this.jPanelUp.add(titlePanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.jPanelUp.add(descriptionLabel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.jPanelUp.add(jtfInputId, gbc);
		
		gbc.gridx = 2;
		this.btnSearchId.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.jPanelUp.add(btnSearchId, gbc);
	}
	
	public CustomTxtField getJtfName() {
		return jpanelCenter.jtfName;
	}

	public CustomTxtField getJtfLastName() {
		return jpanelCenter.jtfLastName;
	}
	
	public CustomTxtField getJtfId() {
		return jpanelCenter.jtfId;
	}

	public CustomTxtField getJtfPhone() {
		return jpanelCenter.jtfPhone;
	}
}
