package com.cmv.petGenesis.view.appointment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.CustomTxtField;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;


public class JPanelAppointment extends JPanel{
	
	private CustomLabel lblTitlelblIdA, lblResultId, lblDate, lblMotive;
	private JTextArea jtaMotive;
	private JDateChooser jdcDate;
	private JScrollPane jScrollPane;
	private JPanel jPanelDate, jPanelMotive;
	
	public JPanelAppointment() {
		super(new BorderLayout());
		lblTitlelblIdA = new CustomLabel(ConstantView.LABEL_ID_AP, ConstantView.FONT_LABELS_LOGIN, null);
		lblResultId = new CustomLabel();
		lblDate = new CustomLabel(ConstantView.LABEL_DATE_AP, ConstantView.FONT_LABELS_LOGIN, null);
		lblMotive = new CustomLabel(ConstantView.LABEL_MOT_AP, ConstantView.FONT_LABELS_LOGIN, null);
		jtaMotive = new JTextArea();
		jScrollPane = new JScrollPane();
		jPanelDate = new JPanel (new GridBagLayout());
		jPanelMotive = new JPanel(new GridBagLayout());
		init();
		initPanelMotive();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 20, 10, 20));
		this.jPanelDate.add(lblDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jPanelDate.add(lblDate, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.jPanelDate.add(lblResultId, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jPanelDate.add(jdcDate, gbc);
	}
	
	private void initPanelMotive() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 20, 10, 20));
		jtaMotive.setPreferredSize(new Dimension(300, 200));
		jScrollPane.setViewportView(jtaMotive);
		jScrollPane.add(jtaMotive);
		this.jPanelMotive.add(jScrollPane);
	}

}
