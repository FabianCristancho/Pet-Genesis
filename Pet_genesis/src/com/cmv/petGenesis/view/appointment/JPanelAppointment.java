package com.cmv.petGenesis.view.appointment;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;
import com.toedter.calendar.JDateChooser;


public class JPanelAppointment extends JPanel{
	
	private CustomLabel lblIdA, lblResultId, lblDate, lblMotive;
	private JTextArea jtaMotive;
	private JDateChooser jdcDate;
	private JScrollPane jScrollPane;
	
	public JPanelAppointment() {
		super(new GridBagLayout());
		lblIdA = new CustomLabel(ConstantView.LABEL_ID_AP, ConstantView.FONT_LABELS_LOGIN, null);
		lblResultId = new CustomLabel();
		lblDate = new CustomLabel(ConstantView.LABEL_DATE_AP, ConstantView.FONT_LABELS_LOGIN, null);
		lblMotive = new CustomLabel(ConstantView.LABEL_MOT_AP, ConstantView.FONT_LABELS_LOGIN, null);
		jtaMotive = new JTextArea();
		jScrollPane = new JScrollPane();
		Date date = new Date();
		DateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			jdcDate = new JDateChooser(sdf.parse(dateTime.format(date)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		init();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(10, 20, 10, 20));
		this.add(lblIdA, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.add(lblResultId, gbc);
		
		
		UtilityClass.organizeGridLayout(gbc, 2, 0, new Insets(10, 20, 10, 20));
		this.add(lblMotive, gbc);
		
		gbc.insets.bottom = 50;
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.add(lblDate, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jdcDate.setPreferredSize(new Dimension(100, 20));
		this.add(jdcDate, gbc);
		
		gbc.gridheight = 2;
		UtilityClass.organizeGridLayout(gbc, 3, 0);
		jtaMotive.setLineWrap(true);
		jtaMotive.setWrapStyleWord(true);
		jtaMotive.setFont(ConstantView.FONT_TEXT_AREA);
		jtaMotive.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jScrollPane.setPreferredSize(new Dimension(300, 80));
		jScrollPane.setViewportView(jtaMotive);
		this.add(jScrollPane, gbc);
	}
	
}
