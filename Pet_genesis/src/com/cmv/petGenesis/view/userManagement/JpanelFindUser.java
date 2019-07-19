package com.cmv.petGenesis.view.userManagement;

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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JpanelFindUser extends JPanel {

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

	public JpanelFindUser() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_USER_QUERY);
		this.description = new JLabel(ConstantView.LABEL_QUERY_WITH);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.jtfInputQuery = new HintJTextField("INGRESE AQUI SU CONSULTA", 20);
		this.btnSearch = new JButton("BUSCAR USUARIO");
		this.btnLoadData = new JButton("CARGAR TODOS LOS DATOS");
		this.model = new DefaultTableModel();
		this.parameters = ConstantView.COMBO_PARAMETERS;
		init();
		ControlUser.getInstance().setJpanelFindUser(this);
	}

	private void init() {
		initParameters();

		loadTable("");
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
		UtilityClass.addCommandJButton(btnSearch, UserCommands.CMD_SEARCH_USER.toString(), ControlUser.getInstance());
		UtilityClass.addCommandJButton(btnLoadData, UserCommands.CMD_LOAD_DATA.toString(), ControlUser.getInstance());
		
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.panelSearch.add(title, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 0, 20, 20);
		this.panelSearch.add(description, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.panelSearch.add(parameters, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.panelSearch.add(jtfInputQuery, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.panelSearch.add(btnSearch, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		this.panelSearch.add(btnLoadData, gbc);
	}

	
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 120, 100, 200, 160, 120, 90, 110, 130 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	public void loadTable(String parameter) {
		SqlUSer sqlUSer = new SqlUSer();
		this.model = new DefaultTableModel();

		jTable.setModel(model);

		model.addColumn("Codigo");
		model.addColumn("Documento de identidad");
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

		ArrayList<Object[]> table = sqlUSer.loadData(parameter, jtfInputQuery.getText());
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
	}
	
	public void searchByParameter() {
		String parameter = null;
		switch (parameters.getSelectedIndex()) {
		case 0:
			parameter = "id_usuario";
			break;
		case 1:
			parameter = "documento_usuario";
			break;
		case 2:
			parameter = "nombre_usuario";
			break;
		case 3:
			parameter = "apellido_usuario";
			break;
		case 4:
			parameter = "tipo_usuario";
			break;
		default:
			parameter = "id_usuario";
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
