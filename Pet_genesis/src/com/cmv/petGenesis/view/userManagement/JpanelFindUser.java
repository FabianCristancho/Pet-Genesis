package com.cmv.petGenesis.view.userManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JpanelFindUser extends JPanel {

	private JTable jTable;
	private JPanel panelTable;
	private JPanel panelSearch;
	private JButton btnSearch;
	private JButton btnLoadData;
	private JTextField parameters;
	private DefaultTableModel model;

	public JpanelFindUser() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.parameters = new JTextField(20);
		this.btnSearch = new JButton("BUSCAR USUARIO");
		this.btnLoadData = new JButton("CARGAR TODOS LOS DATOS");
	    this.model = new DefaultTableModel();
		init();
	}

	private void init() {
		initParameters();
		jTable.setModel(model);

		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Telefono");
		model.addColumn("Email");
		model.addColumn("Direccion de residencia");
		model.addColumn("Tipo de usuario");
		model.addColumn("Estado");
		model.addColumn("Usuario");
		model.addColumn("Ultima Sesion");

		loadAllData();

		JScrollPane jScrollPane = new JScrollPane();
		this.jTable.setEnabled(false);
		jScrollPane.setViewportView(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 600));
		jScrollPane.getViewport().setBackground(Color.CYAN);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setBackground(Color.CYAN);
		this.panelTable.setOpaque(false);
		this.panelTable.add(jScrollPane);
		jTable.getTableHeader().setReorderingAllowed(false);
		changeWidthColumn();
		
		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}

	private void initParameters() {
		UtilityClass.addCommandJButton(btnSearch, UserCommands.CMD_SEARCH_USER.toString(), ControlUser.getInstance());
		UtilityClass.addCommandJButton(btnLoadData, UserCommands.CMD_LOAD_DATA.toString(), ControlUser.getInstance());
		panelSearch.add(parameters, BorderLayout.WEST);
		panelSearch.add(btnSearch, BorderLayout.CENTER);
	}
	
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 120, 100, 200, 160, 120, 90, 110, 130 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}
	
	public void loadAllData() {
		SqlUSer sqlUSer = new SqlUSer();
		ArrayList<Object[]> table = sqlUSer.loadData();
		for (Object[] row : table) {
			model.addRow(row);
		}
	}
}
