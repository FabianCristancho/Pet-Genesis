package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelStateHistory extends JPanel {
	
	private JTable jTable;
	private JLabel title, description, labelStateClient;
	private JPanel panelTable, panelSearch, jPanelStateTable, panelButtons;
	private JButton btnEnter;
	private JButton btnExecute;
	private HintJTextField jtfInputQuery;
	private JComboBox<String> statesBox;
	private DefaultTableModel model;
	private JScrollPane jScrollPane;
	
	public JPanelStateHistory() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_TITLE_INACTIV_PETS);
		this.description = new JLabel(ConstantView.LABEL_PET_WITH);
		this.labelStateClient = new JLabel(ConstantView.LABEL_INACTIV_PET);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.panelButtons = new JPanel();
		this.jtfInputQuery = new HintJTextField("INGRESE VALOR", 20);
		this.btnExecute = new JButton(ConstantView.BUTTON_EXECUTE_ACTION_CLIENT);
		this.model = new DefaultTableModel();
		this.statesBox = new JComboBox<>(ConstantView.COMBO_STATE_HISTORY);
		this.btnEnter = new JButton(ConstantView.BTN_CHANGE_STATE_PET);
		this.jPanelStateTable = new JPanel(new BorderLayout());
		this.jScrollPane = new JScrollPane();
		ControlHistory.getInstance().setjPanelStateHistory(this);
		init();
	}

	private void init() {
		initParameters();
		initPanelStateTable();
		loadTable("estado_activacion", "I");
		this.setBackground(Color.decode("#c5dfed"));
		
		jScrollPane.setViewportView(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 400));
		jScrollPane.getViewport().setBackground(Color.decode("#c5dfed"));
		jScrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jtfInputQuery.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		panelTable.setOpaque(false);
		panelTable.add(jPanelStateTable);
		panelTable.add(jScrollPane);
		
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setEnabled(false);
		jTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}
	
	private void initPanelStateTable() {
		this.jPanelStateTable.setOpaque(false);
		this.jPanelStateTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.labelStateClient.setHorizontalAlignment(JLabel.CENTER);
		this.jPanelStateTable.add(labelStateClient, BorderLayout.NORTH);
	}

	private void initParameters() {
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);

		gbc.gridwidth = 4;
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.title.setForeground(Color.decode("#2E5569"));
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.panelSearch.setOpaque(false);
		this.panelSearch.add(title, gbc);

		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 0, 20, 20));
		this.panelSearch.add(description, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.panelSearch.add(statesBox, gbc);
		
		this.panelSearch.add(panelButtons, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		this.panelSearch.add(jtfInputQuery, gbc);

		gbc.gridx = 4;
		gbc.gridy = 1;
		this.btnEnter.setFocusable(false);
		this.btnEnter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnEnter.setForeground(Color.WHITE);
		this.btnEnter.setBackground(Color.decode("#2E5569"));
		
		UtilityClass.addCommandJButton(btnExecute, HistoryCommands.CMD_WD_INACTIV_EXECUTE.toString(),
				ControlHistory.getInstance());
		this.btnExecute.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.panelSearch.add(btnExecute, gbc);

		this.btnEnter.setOpaque(true);
		this.btnEnter.setUI(new MetalButtonUI() {
			@Override
			protected Color getSelectColor() {
				return new Color(255, 255, 255, 255);
			}
		});

		this.btnEnter.setActionCommand(HistoryCommands.CMD_WD_INACTIV_CHANGE_TABLE.toString());
		this.btnEnter.addActionListener(ControlHistory.getInstance());
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.panelSearch.add(btnEnter, gbc);
	}

	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 140, 110, 110, 200, 200, 140, 200, 200};
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	public void loadTable(String parameter, String state) {
		SQLPets sqlPets = new SQLPets();
		this.model = new DefaultTableModel();

		jTable.setModel(model);

		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Genero");
		model.addColumn("Especie");
		model.addColumn("Raza");
		model.addColumn("Fecha nacimiento");
		model.addColumn("Color");
		model.addColumn("Castrada");
		model.addColumn("Estado activacion");
		model.addColumn("Nombre dueño");
		model.addColumn("Apellido dueño");

		ArrayList<Object[]> table = sqlPets.loadData("estado_de_activacion", state);
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
	}

	public String getStateHistory() {
		String parameter = null;
		switch (statesBox.getSelectedIndex()) {
		case 0:
			parameter = "Activa";
			break;
		case 1:
			parameter = "Inactiva";
			break;
		case 2:
			parameter = "Archivada";
			break;
		case 3:
			parameter = "Bloqueada";
			break;
		default:
			parameter = "Activa";
			break;
		}
		loadTable(parameter, "A");
		return parameter;
	}

	public void changeWithField() {
		if (!jtfInputQuery.getText().equals("")) {
			if (getStateHistory().equals("Activa")) {
				activPet("id_mascota", jtfInputQuery.getText(), "A");
				loadTable("", "A");
			} else if (getStateHistory().equals("Inactiva")) {
				inactivPet("id_mascota", jtfInputQuery.getText(), "I");
				loadTable("", "I");
			} else if (getStateHistory().equals("Archivada")) {
				storePet("id_mascota", jtfInputQuery.getText(), "S");
				loadTable("", "S");
			} else {
				blockPet("id_mascota", jtfInputQuery.getText(), "B");
				loadTable("", "B");
			}
			this.jtfInputQuery.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "SE DEBE INGRESAR UN VALOR EN EL CAMPO", "CAMPO SIN LLENAR",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public JTable getjTable() {
		return jTable;
	}

	private void inactivPet(String parameter, String value, String user) {
		SQLPets sqlPets = new SQLPets();
		
		try {
			if (sqlPets.existPet(Integer.parseInt(value))) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de inactivar la mascota " + user + "?",
						"INACTIVAR MASCOTA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					if (sqlPets.changeStatePet(parameter, value, "I")) {
						JOptionPane.showMessageDialog(null, "LA MASCOTA FUE INACTIVADA CON ÉXITO", "MASCOTA INACTIVA",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "NO FUE POSIBLE INACTIVAR A LA MASCOTA", "MASCOTA NO INACTIVA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA CONSULTADA NO EXISTE");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "EL VALOR DEL CAMPO DEBE SER NUMERICO", "PARAMETRO NO VALIDO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void activPet(String parameter, String value, String user) {
		SQLPets sqlPets = new SQLPets();
		
		try {
			if (sqlPets.existPet(Integer.parseInt(value))) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de activar la mascota " + user + "?",
						"ACTIVAR MASCOTA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					if (sqlPets.changeStatePet(parameter, value, "A")) {
						JOptionPane.showMessageDialog(null, "LA MASCOTA FUE ACTIVADA CON ÉXITO", "MASCOTA ACTIVA",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "NO FUE POSIBLE ACTIVAR A LA MASCOTA", "MASCOTA NO ACTIVA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA CONSULTADA NO EXISTE");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "EL VALOR DEL CAMPO DEBE SER NUMERICO", "PARAMETRO NO VALIDO",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void blockPet(String parameter, String value, String user) {
		SQLPets sqlPets = new SQLPets();
		
		try {
			if (sqlPets.existPet(Integer.parseInt(value))) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de bloquear la mascota " + user + "?",
						"BLOQUEAR MASCOTA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					if (sqlPets.changeStatePet(parameter, value, "B")) {
						JOptionPane.showMessageDialog(null, "LA MASCOTA FUE BLOQUEADA CON ÉXITO", "MASCOTA BLOUEADA",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "NO FUE POSIBLE BLOQUEAR A LA MASCOTA", "MASCOTA NO BLOUEADA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA CONSULTADA NO EXISTE");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "EL VALOR DEL CAMPO DEBE SER NUMERICO", "PARAMETRO NO VALIDO",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void storePet(String parameter, String value, String user) {
		SQLPets sqlPets = new SQLPets();
		
		try {
			if (sqlPets.existPet(Integer.parseInt(value))) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de archivar la mascota " + user + "?",
						"ARCHIVAR MASCOTA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					if (sqlPets.changeStatePet(parameter, value, "S")) {
						JOptionPane.showMessageDialog(null, "LA MASCOTA FUE ARCHIVADA CON ÉXITO", "MASCOTA ARCHIVADA",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "NO FUE POSIBLE ARCHIVAR A LA MASCOTA", "MASCOTA NO ARCHIVADA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA CONSULTADA NO EXISTE");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "EL VALOR DEL CAMPO DEBE SER NUMERICO", "PARAMETRO NO VALIDO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void changeStateButton() {
		jtfInputQuery.setText("");
		if (getStateHistory().equals("Activa")) {
			labelStateClient.setText(ConstantView.LABEL_ACTIV_CLIENT);
			loadTable("", "A");
		} else if (getStateHistory().equals("Inactiva")) {
			labelStateClient.setText(ConstantView.LABEL_INACTIV_CLIENT);
			loadTable("", "I");
		} else if (getStateHistory().equals("Archivada")) {
			labelStateClient.setText(ConstantView.LABEL_STORE_PET);
			loadTable("", "S");
		} else if (getStateHistory().equals("Bloqueada")) {
			labelStateClient.setText(ConstantView.LABEL_BLOCK_PET);
			loadTable("", "B");
		}
	}

	public HintJTextField getJtfInputQuery() {
		return jtfInputQuery;
	}

}
