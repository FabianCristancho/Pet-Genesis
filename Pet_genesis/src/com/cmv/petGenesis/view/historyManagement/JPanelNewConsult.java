package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelFindHistory - Se encarga de encontrar los datos de la historia en
 * un jtable
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelNewConsult extends JPanel {

	private JLabel title;
	private JLabel description;
	private JPanel jPanelButtons;
	private JPanel panelSearch;
	private JButton btnSearch;
	private JButton okButton;
	private JButton returnButton;
	private JPanelFillConsult jPanelFillConsult;
	private JTextField jtfInputQuery;

	/**
	 * Constructor del panel
	 */
	public JPanelNewConsult(User user) {
		super(new BorderLayout());
		this.title = new JLabel(ConstantView.LABEL_PET_NEW_CONSULT);
		this.description = new JLabel("CÓDIGO DE MASCOTA");
		this.jPanelButtons = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.jtfInputQuery = new JTextField(20);
		this.btnSearch = new JButton(ConstantView.BTN_SEARCH_PET);
		this.jPanelFillConsult = new JPanelFillConsult(user);
		ControlHistory.getInstance().setjPanelNewConsult(this);
		init();
	}

	/**
	 * Inicializa los campos para encontrar las historia
	 */
	private void init() {
		initParameters();
		initPanelButtons();
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		this.setBackground(Color.decode("#c5dfed"));
		jtfInputQuery.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

		this.add(panelSearch, BorderLayout.NORTH);
		jPanelFillConsult.setVisible(false);
		this.add(jPanelFillConsult, BorderLayout.CENTER);
		this.add(jPanelButtons, BorderLayout.SOUTH);
		
	}

	/**
	 * Inicializa los parametros
	 */
	private void initParameters() {
		UtilityClass.addCommandJButton(btnSearch, HistoryCommands.CMD_WD_SEARCH_PET.toString(),
				ControlHistory.getInstance());

		this.panelSearch.setOpaque(false);
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);

		gbc.gridwidth = 3;
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.title.setForeground(Color.decode("#2E5569"));
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.panelSearch.add(title, gbc);

		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 0, 20, 20));
		this.panelSearch.add(description, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		jtfInputQuery.addKeyListener(ControlHistory.getInstance());
		this.panelSearch.add(jtfInputQuery, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.btnSearch.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.btnSearch.setForeground(Color.WHITE);
		this.btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnSearch.setFocusable(false);
		UtilityClass.addCommandJButton(btnSearch, HistoryCommands.CMD_WD_RCONSULT_SEARCH.toString(), ControlHistory.getInstance());
		this.panelSearch.add(btnSearch, gbc);
	}
	
	/**
	 * Inicializa los botones del panel del formulario
	 */
	private void initPanelButtons() {
		this.jPanelButtons = new JPanel(new GridBagLayout());
		this.jPanelButtons.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		this.jPanelButtons.setOpaque(false);
		this.okButton = new JButton("Registrar Consulta");
		this.returnButton = new JButton("Regresar");
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.returnButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.returnButton.setForeground(Color.WHITE);
		this.returnButton.setFocusable(false);
		this.returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.returnButton.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		this.jPanelButtons.add(returnButton, gbc);

		gbc.gridx = 7;
		this.okButton.setEnabled(false);
		this.okButton.setBackground(ConstantView.COLOR_BUTTON_LOGIN);
		this.okButton.setForeground(Color.WHITE);
		this.okButton.setFocusable(false);
		this.okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.okButton.setFont(ConstantView.FONT_PRINCIPAL_LABELS);
		UtilityClass.addCommandJButton(okButton, HistoryCommands.CMD_WD_RCONSULT_SAVE_CONSULT.toString(), ControlHistory.getInstance());
		this.jPanelButtons.add(okButton, gbc);
	}
	
	public void searchPet() {
		SQLPets sqlPets = new SQLPets();
		if(sqlPets.existPet(Integer.parseInt(jtfInputQuery.getText()))) {
			jPanelFillConsult.idPet = Integer.parseInt(jtfInputQuery.getText());
			jPanelFillConsult.setVisible(true);
			okButton.setEnabled(true);
		}else {
			JOptionPane.showMessageDialog(null, "No se encontró la historia de la mascota", "Id no encontrado", JOptionPane.ERROR_MESSAGE);
			jPanelFillConsult.setVisible(false);
			okButton.setEnabled(false);
		}
	}
	
	public void saveAllConsultData() {
		this.jPanelFillConsult.saveAllConsultData();
	}

	public JTextField getJtfInputQuery() {
		return jtfInputQuery;
	}
}
