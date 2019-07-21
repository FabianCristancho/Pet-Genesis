package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelComments extends JPanel {
	
	private CustomLabel titleComments;
	private JTextArea areaComments;
	private JScrollPane scrollComments;
	private JButton btnSaveComments, btnClearComments;
	private JPanel jpanelButtons;

	public JPanelComments() {
		super(new BorderLayout());
		this.titleComments = new CustomLabel(ConstantView.TITLE_COMMENTS, ConstantView.FONT_TITLE_COMMENTS, null);
		this.areaComments = new JTextArea();
		this.scrollComments = new JScrollPane();
		this.btnSaveComments = new JButton(ConstantView.BTN_SAVE_COMMENTS);
		this.btnClearComments = new JButton(ConstantView.BTN_CLEAR_COMMENTS);
		this.jpanelButtons = new JPanel(new GridBagLayout());
		init();
	}

	private void init() {
		this.titleComments.setHorizontalAlignment(JLabel.CENTER);
		this.titleComments.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		this.add(titleComments, BorderLayout.NORTH);
		
		this.areaComments.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.areaComments.setFont(ConstantView.FONT_AREA_COMMENTS);
		
		this.scrollComments.setBorder(BorderFactory.createEmptyBorder(20, 50, 15, 50));
		this.scrollComments.setViewportView(areaComments);
		this.add(scrollComments, BorderLayout.CENTER);
		
		initPanelComments();
		this.add(jpanelButtons, BorderLayout.SOUTH);
	}
	
	private void initPanelComments() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.EAST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0, new Insets(20, 20, 20, 20));
		this.jpanelButtons.add(btnSaveComments, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 0, new Insets(20, 20, 20, 20));
		this.jpanelButtons.add(btnClearComments, gbc);
	}

}
