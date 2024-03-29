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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.table.DefaultTableModel;

import com.cmv.petGenesis.command.UserCommands;
import com.cmv.petGenesis.connection.SQLUsers;
import com.cmv.petGenesis.controller.ControlUser;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.HintJTextField;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelFindUser, encargada mostrar el modulo de cambio de estado de usuarios
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public class JPanelInactivUser extends JPanel {

	private JTable jTable;
	private JLabel title, description, labelStateUser, lblClickToActiv;
	private JPanel panelTable, panelSearch, jPanelStateTable, panelButtons;
	private JToggleButton inactivActiv;
	private JButton btnExecute;
	private ButtonGroup bg;
	private JRadioButton jRButtonActive, jRButtonInactive;
	private HintJTextField jtfInputQuery;
	private JComboBox<String> parameters;
	private DefaultTableModel model;
	private JScrollPane jScrollPane;

	/**
	 * Constructor de la clase
	 */
	public JPanelInactivUser() {
		super(new BorderLayout());
		this.jTable = new JTable();
		this.title = new JLabel(ConstantView.LABEL_TITLE_INACTIV_USER);
		this.description = new JLabel(ConstantView.LABEL_USER_WITH);
		this.labelStateUser = new JLabel(ConstantView.LABEL_INACTIV_USER);
		this.lblClickToActiv = new JLabel(ConstantView.LABEL_CLICK_TO_ACTIV);
		this.panelTable = new JPanel();
		this.panelSearch = new JPanel(new BorderLayout());
		this.panelButtons = new JPanel();
		this.jtfInputQuery = new HintJTextField("INGRESE VALOR", 20);
		this.btnExecute = new JButton(ConstantView.BUTTON_EXECUTE_ACTION);
		this.model = new DefaultTableModel();
		this.parameters = new JComboBox<>(ConstantView.PARAMS_INACTIV_USER);
		this.inactivActiv = new JToggleButton(ConstantView.TOGGLE_SHOW_ACTIV_USER);
		this.jPanelStateTable = new JPanel(new BorderLayout());
		this.bg = new ButtonGroup();
		this.jRButtonActive = new JRadioButton(ConstantView.RADIO_ACTIV_USER);
		this.jRButtonInactive = new JRadioButton(ConstantView.RADIO_INACTIV_USER);
		this.jScrollPane = new JScrollPane();

		ControlUser.getInstance().setjPanelInactivUser(this);
		init();
	}

	/**
	 * Inicializa componentes principales
	 */
	private void init() {
		initParameters();
		initPanelStateTable();
		loadTable("", "I");
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
		jTable.addMouseListener(ControlUser.getInstance());
		jTable.getTableHeader().setReorderingAllowed(false);
		this.changeWidthColumn();

		this.add(panelSearch, BorderLayout.NORTH);
		this.add(panelTable, BorderLayout.CENTER);
	}

	/**
	 * Inicializa panel de estado de tabla
	 */
	private void initPanelStateTable() {
		this.jPanelStateTable.setOpaque(false);
		this.jPanelStateTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.labelStateUser.setHorizontalAlignment(JLabel.CENTER);
		this.jPanelStateTable.add(labelStateUser, BorderLayout.NORTH);
		this.jPanelStateTable.add(lblClickToActiv, BorderLayout.WEST);
	}

	/**
	 * Inicializa parametros de busqueda
	 */
	private void initParameters() {
		this.panelSearch.setOpaque(false);
		this.panelSearch.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 0, 20);

		gbc.gridwidth = 4;
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		this.title.setForeground(Color.decode("#2E5569"));
		this.title.setFont(ConstantView.FONT_TITLE_CRUD);
		this.panelSearch.add(title, gbc);

		gbc.gridwidth = 1;
		UtilityClass.organizeGridLayout(gbc, 0, 1, new Insets(20, 0, 20, 20));
		this.panelSearch.add(description, gbc);

		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.panelSearch.add(parameters, gbc);

		UtilityClass.organizeGridLayout(gbc, 2, 1);
		jRButtonActive.setOpaque(false);
		jRButtonActive.setFocusable(false);
		jRButtonActive.setSelected(true);
		jRButtonInactive.setFocusable(false);

		bg.add(jRButtonActive);
		bg.add(jRButtonInactive);
		jRButtonInactive.setOpaque(false);
		panelButtons.add(jRButtonActive);
		panelButtons.add(jRButtonInactive);
		this.panelSearch.add(panelButtons, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		this.panelSearch.add(jtfInputQuery, gbc);

		gbc.gridx = 4;
		gbc.gridy = 1;
		this.inactivActiv.setFocusable(false);
		this.inactivActiv.setForeground(Color.WHITE);
		this.inactivActiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.inactivActiv.setBackground(Color.decode("#2E5569"));

		UtilityClass.addCommandJButton(btnExecute, UserCommands.CMD_WD_INACTIV_EXECUTE.toString(),
				ControlUser.getInstance());
		this.btnExecute.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.panelSearch.add(btnExecute, gbc);

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
		gbc.gridwidth = 3;
		this.panelSearch.add(inactivActiv, gbc);
	}

	/**
	 * Cambia tamanio de columna de tabla
	 */
	private void changeWidthColumn() {
		int[] widthColumns = { 50, 140, 140, 140, 110, 110, 200, 200, 110, 130, 150 };
		for (int i = 0; i < widthColumns.length; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	/**
	 * Carga la tabla
	 * @param parameter Parametro de busqueda
	 * @param state Estado de usuario
	 */
	public void loadTable(String parameter, String state) {
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

		ArrayList<Object[]> table = sqlUsers.loadData(parameter, jtfInputQuery.getText(), "estado_activacion", state);
		for (Object[] row : table) {
			model.addRow(row);
		}
		changeWidthColumn();
	}

	/**
	 * Obtiene el parametro de busqueda
	 * @return Parametro
	 */
	public String getParameter() {
		String parameter = null;
		switch (parameters.getSelectedIndex()) {
		case 0:
			parameter = "p.id_persona";
			break;
		case 1:
			parameter = "p.documento_identidad";
			break;
		case 2:
			parameter = "u.nombre_usuario";
			break;
		default:
			parameter = "p.id_persona";
			break;
		}
		loadTable(parameter, "I");
		return parameter;
	}

	/**
	 * Cambia de un campo a otro ,dependiendo del estado del usuario
	 */
	public void changeWithField() {
		if (!jtfInputQuery.getText().equals("")) {
			if (jRButtonInactive.isSelected()) {
				inactivUser(getParameter(), jtfInputQuery.getText(), jtfInputQuery.getText());
				this.jtfInputQuery.setText("");
			} else {
				activUser(getParameter(), jtfInputQuery.getText(), jtfInputQuery.getText());
				this.jtfInputQuery.setText("");
			}
			if (inactivActiv.isSelected())
				loadTable("", "A");
			else
				loadTable("", "I");

		} else {
			JOptionPane.showMessageDialog(null, "SE DEBE INGRESAR UN VALOR EN EL CAMPO", "CAMPO SIN LLENAR",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Obtiene la tabla de la clase
	 * @return tabla
	 */
	public JTable getjTable() {
		return jTable;
	}

	/**
	 * Activa a un usuario
	 * @param p Punto de la tabla
	 */
	public void setActivUser(Point p) {
		int row = jTable.rowAtPoint(p);
		String id = String.valueOf(jTable.getValueAt(row, 0));
		String user = String.valueOf(jTable.getValueAt(row, 9));
		if (inactivActiv.isSelected()) {
			inactivUser("p.id_persona", id, user);
			loadTable("", "A");
		} else {
			activUser("p.id_persona", id, user);
			loadTable("", "I");
		}
	}

	/**
	 * Inactiva a un usuario
	 * @param p Punto de la tabla
	 */
	private void inactivUser(String parameter, String value, String user) {
		SQLUsers sqlUsers = new SQLUsers();
		if (!sqlUsers.userHasState(parameter, value, "A")) {
			JOptionPane.showMessageDialog(null,
					"El usuario " + user + " no se encuentra activo\nAsegurese de que haya ingresado un valor v�lido");
		} else {
			int option = JOptionPane.showConfirmDialog(null, "�Est� seguro de inactivar al usuario " + user + "?",
					"INACTIVAR USUARIO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (option == 0) {
				if (sqlUsers.changeStateUser(parameter, value, "I")) {
					JOptionPane.showMessageDialog(null, "EL USUARIO FUE INACTIVADO CON �XITO", "USUARIO INACTIVADO",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "NO FUE POSIBLE INACTIVAR AL USUARIO", "USUARIO NO INACTIVO",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	/**
	 * Activa a un usuario dependiendo del valor y parametro
	 * @param parameter Parametro de busqueda
	 * @param value Valor de consulta
	 * @param user Usuario
	 */
	private void activUser(String parameter, String value, String user) {
		SQLUsers sqlUsers = new SQLUsers();
		if (!sqlUsers.userHasState(parameter, value, "I")) {
			JOptionPane.showMessageDialog(null,
					"El usuario " + user + " no se encuentra inactivo\nAsegurese de que haya ingresado un valor v�lido");
		} else {
			int option = JOptionPane.showConfirmDialog(null, "�Est� seguro de activar al usuario " + user + "?",
					"ACTIVAR USUARIO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (option == 0) {
				if (sqlUsers.changeStateUser(parameter, value, "A")) {
					JOptionPane.showMessageDialog(null, "EL USUARIO FUE ACTIVADO CON �XITO", "USUARIO ACTIVADO",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "NO FUE POSIBLE ACTIVAR AL USUARIO", "USUARIO NO ACTIVO",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Cambia el estado del boton, de activo a inactivo o viceversa
	 * @param state Estado de boton
	 */
	public void changeStateButton(int state) {
		jtfInputQuery.setText("");
		if (state == 1) {
			inactivActiv.setText(ConstantView.TOGGLE_SHOW_INACTIV_USER);
			labelStateUser.setText(ConstantView.LABEL_ACTIV_USER);
			lblClickToActiv.setText(ConstantView.LABEL_CLICK_TO_INACTIV);
			loadTable("", "A");
		} else if (state == 2) {
			inactivActiv.setText(ConstantView.TOGGLE_SHOW_ACTIV_USER);
			labelStateUser.setText(ConstantView.LABEL_INACTIV_USER);
			lblClickToActiv.setText(ConstantView.LABEL_CLICK_TO_ACTIV);
			loadTable("", "I");
		}
	}

	/**
	 * Obtiene el boton de estado de usuario
	 * @return
	 */
	public JToggleButton getInactivActiv() {
		return inactivActiv;
	}
}
