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
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLUsers;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelFindUser, encargada de realizar las respectivas consultas para
 * encontrar un usuario que se encuentra o no en el sistema
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class JpanelFindUser extends JPanel {

	private JTable jTable;
	private JLabel title;
	private JLabel description;
	private JPanel panelTable;
	private JPanel panelSearch;
	private JButton btnSearch;
	private JButton btnLoadData;
	private HintJTextField jtfInputQuery;
	private JComboBox<String> parameters, typesUser;
	private DefaultTableModel model;

	/**
	 * Constructor de la clase
	 */
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
		SQLUsers sqlUsers = new SQLUsers();
		this.typesUser = new JComboBox<>(sqlUsers.loadTypesUser());

		init();
		ControlUser.getInstance().setJpanelFindUser(this);
	}

	/**
	 * Inicializa los componentes principales de la clase
	 */
	private void init() {
		initParameters();

		this.setBackground(Color.decode("#c5dfed"));
		loadTable("");
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
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}

	/*
	 * Se encarga de inicializar los parametros por los que se va a buscar al
	 * usuario
	 */
	private void initParameters() {
		UtilityClass.addCommandJButton(btnSearch, UserCommands.CMD_SEARCH_USER.toString(), ControlUser.getInstance());
		UtilityClass.addCommandJButton(btnLoadData, UserCommands.CMD_LOAD_DATA.toString(), ControlUser.getInstance());

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
		this.parameters.addItemListener(ControlUser.getInstance());
		this.panelSearch.add(parameters, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.typesUser.setVisible(false);
		this.panelSearch.add(typesUser, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.panelSearch.add(jtfInputQuery, gbc);

		UtilityClass.organizeGridLayout(gbc, 3, 1);
		this.panelSearch.add(btnSearch, gbc);

		UtilityClass.organizeGridLayout(gbc, 4, 1);
		this.panelSearch.add(btnLoadData, gbc);
	}

	/**
	 * Asigna un nuevo tamanio a las columnas de la tabla que contiene los datos de
	 * los usuarios
	 */
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 140, 110, 110, 200, 200, 110, 130, 150 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	/**
	 * Carga de la base de datos los datos del usuario
	 * 
	 * @param parameter Parametro de busqueda de usuario
	 */
	private void loadTable(String parameter) {
		SQLUsers sqlUsers = new SQLUsers();
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

		String input;
		if (parameters.getSelectedIndex() == 4)
			input = typesUser.getSelectedItem().toString();
		else
			input = jtfInputQuery.getText();

		ArrayList<Object[]> table = sqlUsers.loadData(parameter, input, "estado_activacion", "A");
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
	}

	/**
	 * Filtra la busqueda de un usuario dependiendo del parametro elegido
	 */
	public void searchByParameter() {
		String parameter = null;
		switch (parameters.getSelectedIndex()) {
		case 0:
			parameter = "p.id_persona";
			break;
		case 1:
			parameter = "p.documento_identidad";
			break;
		case 2:
			parameter = "p.nombre_persona";
			break;
		case 3:
			parameter = "p.apellido_persona";
			break;
		case 4:
			parameter = "t.nombre_tipo_usuario";
			break;
		default:
			parameter = "p.id_persona";
			break;
		}
		loadTable(parameter);
		this.jtfInputQuery.setText("");
	}

	/**
	 * Cambia entre el campo de consulta y el combobox
	 */
	public void changeInputQuery() {
		if (parameters.getSelectedIndex() == 4) {
			jtfInputQuery.setVisible(false);
			typesUser.setVisible(true);
		} else {
			typesUser.setVisible(false);
			jtfInputQuery.setVisible(true);
		}
	}

	/**
	 * Carga en la tabla todos los usuarios activos en el sistema
	 */
	public void loadAllData() {
		parameters.setSelectedIndex(0);
		typesUser.setVisible(false);
		jtfInputQuery.setVisible(true);
		this.jtfInputQuery.setText("");
		this.loadTable("");
	}

	/**
	 * Obtiene el combobox de parametros
	 * 
	 * @return combobox
	 */
	public JComboBox<String> getParameters() {
		return parameters;
	}

	/**
	 * Obtiene el boton que carga los datos
	 * 
	 * @return Boton de carga de datos
	 */
	public JButton getBtnLoadData() {
		return btnLoadData;
	}
}
