package com.cmv.petGenesis.view.clientManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.ClientCommands;
import com.cmv.petGenesis.connection.SQLPeople;
import com.cmv.petGenesis.controller.ControlClient;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JpanelFindClient extends JPanel {

	private JTable jTable;
	private JLabel title;
	private JLabel description;
	private JPanel panelTable;
	private JPanel panelSearch;
	private JButton btnSearch;
	private JButton btnLoadData;
	private HintJTextField jtfInputQuery;
	private JComboBox<String> parameters;
	private DefaultTableModel model;

	public JpanelFindClient() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_CLIENT_QUERY);
		this.description = new JLabel(ConstantView.LABEL_QUERY_WITH);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.jtfInputQuery = new HintJTextField("INGRESE AQUI SU CONSULTA", 20);
		this.btnSearch = new JButton("BUSCAR CLIENTE");
		this.btnLoadData = new JButton("CARGAR TODOS LOS DATOS");
		this.model = new DefaultTableModel();
		this.parameters = ConstantView.COMBO_PARAMETERS;
		init();
		ControlClient.getInstance().setJpanelFindClient(this);
	}

	private void init() {
		initParameters();

		loadTable("estado_activacion");
		this.btnLoadData.setEnabled(false);
		this.jTable.setEnabled(false);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 400));
		jScrollPane.getViewport().setBackground(Color.CYAN);
		jtfInputQuery.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setBackground(Color.CYAN);
		this.panelTable.setOpaque(false);
		this.panelTable.add(jScrollPane);
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}

	private void initParameters() {
		UtilityClass.addCommandJButton(btnSearch, ClientCommands.CMD_SEARCH_CLIENT.toString(), ControlClient.getInstance());
		UtilityClass.addCommandJButton(btnLoadData, ClientCommands.CMD_LOAD_DATA.toString(), ControlClient.getInstance());
		
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);
		
		gbc.gridwidth = 3;
		UtilityClass.organizeGridLayout(gbc, 1, 0);
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.panelSearch.add(title, gbc);
		
		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 0, 20, 20));
		this.panelSearch.add(description, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.panelSearch.add(parameters, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.panelSearch.add(jtfInputQuery, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 3, 1);
		this.panelSearch.add(btnSearch, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 4, 1);
		this.panelSearch.add(btnLoadData, gbc);
	}

	
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 140, 110, 110, 200, 200, 110 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	private void loadTable(String parameter) {
		SQLPeople sqlPeople = new SQLPeople();
		this.model = new DefaultTableModel();

		jTable.setModel(model);

		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Telefono");
		model.addColumn("Estado activacion");
		model.addColumn("Documento de identidad");
		model.addColumn("Email");
		model.addColumn("Direccion de residencia");

		ArrayList<Object[]> table = sqlPeople.loadData("tipo_persona", "C", parameter, jtfInputQuery.getText());
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
	}
	
	public void searchByParameter() {
		String parameter = null;
		switch (parameters.getSelectedIndex()) {
		case 0:
			parameter = "id_persona";
			break;
		case 1:
			parameter = "documento_identidad";
			break;
		case 2:
			parameter = "nombre_persona";
			break;
		case 3:
			parameter = "apellido_persona";
			break;
		default:
			parameter = "id_persona";
			break;
		}
		loadTable(parameter);
		this.jtfInputQuery.setText("");
	}

	public void loadAllData() {
		this.jtfInputQuery.setText("");
		this.loadTable("");
	}

	public JButton getBtnLoadData() {
		return btnLoadData;
	}
}
