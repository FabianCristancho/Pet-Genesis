package com.cmv.petGenesis.view.userManagement;

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
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;

public class JPanelInactivUser extends JPanel {

	private JTable jTable;
	private JLabel title;
	private JLabel description;
	private JLabel labelStateUser;
	private JLabel lblClickToActiv;
	private JPanel panelTable;
	private JToggleButton inactivActiv;
	private JPanel panelSearch;
	private JPanel jPanelStateTable;
	private JButton btnSearch;
	private HintJTextField jtfInputQuery;
	private JComboBox<String> parameters;
	private DefaultTableModel model;

	public JPanelInactivUser() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_TITLE_INACTIV_USER);
		this.description = new JLabel(ConstantView.LABEL_QUERY_WITH);
		this.labelStateUser = new JLabel(ConstantView.LABEL_INACTIV_USER);
		this.lblClickToActiv = new JLabel(ConstantView.LABEL_CLICK_TO_ACTIV);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.jtfInputQuery = new HintJTextField("INGRESE VALOR", 20);
		this.btnSearch = new JButton("INACTIVAR USUARIO");
		this.model = new DefaultTableModel();
		this.parameters = new JComboBox<>(ConstantView.PARAMS_INACTIV_USER);
		this.inactivActiv = new JToggleButton(ConstantView.TOGGLE_SHOW_ACTIV_USER);
		this.jPanelStateTable = new JPanel(new BorderLayout());
		ControlUser.getInstance().setjPanelInactivUser(this);
		init();
	}

	private void init() {
		initParameters();
		initPanelStateTable();
		loadTable("", "Inactivo");
		this.jTable.setEnabled(false);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 400));
		jScrollPane.getViewport().setBackground(Color.CYAN);
		jScrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jtfInputQuery.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setBackground(Color.CYAN);
		this.panelTable.setOpaque(false);
		this.panelTable.add(jPanelStateTable);
		this.panelTable.add(jScrollPane);
		jTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jTable.addMouseListener(ControlUser.getInstance());
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}
	
	private void initPanelStateTable() {
		this.jPanelStateTable.setOpaque(false);
		this.jPanelStateTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.labelStateUser.setHorizontalAlignment(JLabel.CENTER);
		this.jPanelStateTable.add(labelStateUser, BorderLayout.NORTH);
		this.jPanelStateTable.add(lblClickToActiv, BorderLayout.WEST);
	}

	private void initParameters() {
//		UtilityClass.addCommandJButton(btnSearch, UserCommands.CMD_SEARCH_USER.toString(), ControlUser.getInstance());

		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
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
		this.inactivActiv.setFocusable(false);
		this.inactivActiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.inactivActiv.setBackground(Color.CYAN);
		this.panelSearch.add(btnSearch, gbc);
		
		this.inactivActiv.setOpaque(true);
		this.inactivActiv.setUI(new MetalButtonUI() {
			@Override
			protected Color getSelectColor() {
				return new Color(255, 255, 255, 255);
			}
		});
		this.inactivActiv.setActionCommand(UserCommands.CMD_WD_INACTIV_CHANGE_TABLE.toString());
		this.inactivActiv.addItemListener(ControlUser.getInstance());
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.panelSearch.add(inactivActiv, gbc);
	}

	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 140, 110, 110, 200, 200, 110, 130, 150 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	public void loadTable(String parameter, String state) {
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
		model.addColumn("Usuario");
		model.addColumn("Ultima Sesion");

		ArrayList<Object[]> table = sqlUSer.loadData(parameter, jtfInputQuery.getText(), "estado_usuario", state);
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
		loadTable(parameter, "Inactivo");
		this.jtfInputQuery.setText("");
	}

	public void loadAllData() {
		this.jtfInputQuery.setText("");
		this.loadTable("", "Inactivo");
	}

	public JTable getjTable() {
		return jTable;
	}

	public int inactivUser(Point p) {
		int row = jTable.rowAtPoint(p);
		String id = String.valueOf(jTable.getValueAt(row, 0));
		String user = String.valueOf(jTable.getValueAt(row, 9));
		int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de activar al usuario " + user + "?",
				"INACTIVAR USUARIO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (option == 0)
			return Integer.parseInt(id);
		return -1;
	}
	
	public void changeStateButton(int state) {
		if(state == 1) { 
			inactivActiv.setText(ConstantView.TOGGLE_SHOW_INACTIV_USER);
			labelStateUser.setText(ConstantView.LABEL_ACTIV_USER);
			lblClickToActiv.setText(ConstantView.LABEL_CLICK_TO_INACTIV);
			loadTable("", "Activo");
		}else if (state == 2) {
			inactivActiv.setText(ConstantView.TOGGLE_SHOW_ACTIV_USER);
			labelStateUser.setText(ConstantView.LABEL_INACTIV_USER);
			lblClickToActiv.setText(ConstantView.LABEL_CLICK_TO_ACTIV);
			loadTable("", "Inactivo");
		}
	}

	public JToggleButton getInactivActiv() {
		return inactivActiv;
	}
	
//	public JButton getBtnLoadData() {
//		return btnLoadData;
//	}
}
