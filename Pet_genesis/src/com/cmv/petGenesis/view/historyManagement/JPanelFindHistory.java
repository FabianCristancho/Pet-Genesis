package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLPets;
import com.cmv.petGenesis.controller.ControlHistory;
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
public class JPanelFindHistory extends JPanel {

	private JTable jTable;
	private JLabel title;
	private JLabel description;
	private JPanel panelTable;
	private JPanel panelSearch;
	private JButton btnSearch;
	private JButton btnLoadData;
	private JComboBox<String> dataSearchBy;
	private HintJTextField jtfInputQuery;
	private DefaultTableModel model;

	/**
	 * Constructor del panel
	 */
	public JPanelFindHistory() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_PET_QUERY);
		this.description = new JLabel(ConstantView.LABEL_SEARCH_PET_QUERY);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.jtfInputQuery = new HintJTextField("INGRESE AQUI SU CONSULTA", 20);
		this.btnSearch = new JButton(ConstantView.BTN_SEARCH_PET);
		this.btnLoadData = new JButton(ConstantView.BTN_LOAD_ALL_DATA);
		this.model = new DefaultTableModel();
		this.dataSearchBy = new JComboBox<>(ConstantView.COMBO_SEARCH_PET_BY);
		ControlHistory.getInstance().setjPanelFindHistory(this);
		init();
	}

	/**
	 * Inicializa los campos para encontrar las historia
	 */
	private void init() {
		initParameters();

		this.setBackground(Color.decode("#c5dfed"));
		loadTable("", "");
		this.btnLoadData.setEnabled(false);
		this.jTable.setEnabled(false);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 400));
		jScrollPane.getViewport().setBackground(Color.decode("#c5dfed"));
		jtfInputQuery.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.panelTable.setOpaque(false);
		this.panelTable.add(jScrollPane);
		jTable.addMouseListener(ControlHistory.getInstance());
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}

	/**
	 * Inicializa los parametros
	 */
	private void initParameters() {
		UtilityClass.addCommandJButton(btnSearch, HistoryCommands.CMD_WD_SEARCH_PET.toString(),
				ControlHistory.getInstance());
		UtilityClass.addCommandJButton(btnLoadData, HistoryCommands.CMD_WD_LOAD_DATA.toString(),
				ControlHistory.getInstance());

		this.panelSearch.setOpaque(false);
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);

		gbc.gridwidth = 3;
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.title.setForeground(Color.decode("#2E5569"));
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.panelSearch.add(title, gbc);

		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 0, 20, 20));
		this.panelSearch.add(description, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.panelSearch.add(dataSearchBy, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.panelSearch.add(jtfInputQuery, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 1);
		this.panelSearch.add(btnSearch, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 1);
		this.panelSearch.add(btnLoadData, gbc);
	}

	/**
	 * Cambia la el ancho de las columnas de la tabla
	 */
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 120, 140, 150, 150, 120, 100, 100, 132, 130, 130 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	/**
	 * Carga los valores de la tabla
	 * 
	 * @param valueId id
	 */
	private void loadTable(String parameter, String valueId) {
		SQLPets sqlPets = new SQLPets();
		this.model = new DefaultTableModel();

		jTable.setModel(model);

		model.addColumn("C�digo mascota");
		model.addColumn("Nombre");
		model.addColumn("G�nero");
		model.addColumn("Especie");
		model.addColumn("Raza");
		model.addColumn("Fecha de nacimiento");
		model.addColumn("Color");
		model.addColumn("Est� Castrada");
		model.addColumn("Id Propietario");
		model.addColumn("Documento Propietario");
		model.addColumn("Nombre de Propietario");
		model.addColumn("Apellido de Propietario");

		ArrayList<Object[]> table = sqlPets.loadDataPets(parameter, valueId);
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
		this.jtfInputQuery.setText("");
	}

	private String getParameter(int parameter) {
		switch (parameter) {
		case 0:
			return "m.id_mascota";
		case 1:
			return "m.nombre_mascota";
		case 2:
			return "p.id_persona";
		case 3:
			return "p.documento_identidad";

		default:
			return "m.id_mascota";
		}
	}
	
	/**
	 * Obtiene la tabla de busueda
	 */
	public void getTableSearch() {
		loadTable(getParameter(dataSearchBy.getSelectedIndex()), jtfInputQuery.getText());
		this.btnLoadData.setEnabled(true);
	}

	/**
	 * Carga todos los datos de la tabla
	 */
	public void loadAllData() {
		this.loadTable("", "");
	}

	/**
	 * Obtien ele boton para cargar los datos
	 * 
	 * @return btnLoadData button
	 */
	public JButton getBtnLoadData() {
		return btnLoadData;
	}
	
	public JTable getjTable() {
		return jTable;
	}

	public void showAllHistory(Point p) {
		int row = jTable.rowAtPoint(p);
		int idPet = (int) jTable.getValueAt(row, 0);
		new JFrameSeeHistory(idPet);
	}
}
