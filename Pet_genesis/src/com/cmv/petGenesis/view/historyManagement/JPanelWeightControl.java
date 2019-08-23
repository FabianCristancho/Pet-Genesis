package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.connection.SQLHistory;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

public class JPanelWeightControl extends JPanel {

	private CustomLabel titleControl;
	private SQLHistory sqlHistory;
	private JTable tableWeight;
	private JScrollPane jScrollPane;
	private DefaultTableModel defaultTableModel;
	private JButton btnReturn;
	private JPanel jPanelButton;
	private int idPet;
	
	public JPanelWeightControl(int idPet) {
		super(new BorderLayout());
		titleControl = new CustomLabel("TABLA CONTROL PESO", ConstantView.FONT_TITLE_EXAM, new Color(9, 92, 150));
		sqlHistory = new SQLHistory();
		tableWeight = new JTable();
		jScrollPane = new JScrollPane();
		defaultTableModel = new DefaultTableModel();
		btnReturn = new JButton("REGRESAR");
		jPanelButton = new JPanel();
		this.idPet = idPet;
		init();
	}

	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		tableWeight.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableWeight.setEnabled(false);
		tableWeight.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tableWeight.getTableHeader().setReorderingAllowed(false);
		
		jScrollPane.setViewportView(tableWeight);
		jScrollPane.setPreferredSize(new Dimension(300, 200));
		jScrollPane.getViewport().setBackground(Color.decode("#c5dfed"));
		
		titleControl.setHorizontalAlignment(JLabel.CENTER);
		titleControl.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		jPanelButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		btnReturn.setFocusable(false);
		btnReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBackground(new Color(9, 92, 150));
		UtilityClass.addCommandJButton(btnReturn, HistoryCommands.CMD_WD_WEIGTH_CLOSE.toString(), ControlHistory.getInstance());
		jPanelButton.add(btnReturn);
		
		loadTable();
		this.add(titleControl, BorderLayout.NORTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanelButton, BorderLayout.SOUTH);
	}
	
	private void changeWidthColumn() {
		int[] widthColumns = { 100, 160, 160};
		for (int i = 0; i < widthColumns.length; i++) {
			tableWeight.getColumnModel().getColumn(i).setPreferredWidth(widthColumns[i]);
		}
	}

	private void loadTable() {
		tableWeight.setModel(defaultTableModel);

		defaultTableModel.addColumn("Peso (kg)");
		defaultTableModel.addColumn("Fecha de toma");
		defaultTableModel.addColumn("Usuario que lo tomó");

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTableHeader th; 
		th = tableWeight.getTableHeader(); 
		th.setFont(new Font("Open Sans", Font.BOLD, 13));
		
		for (int i = 0; i < 3; i++) {
			tableWeight.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
		
		ArrayList<Object[]> table = sqlHistory.getTableWeight(idPet);
		for (Object[] row : table) {
			defaultTableModel.addRow(row);
		}

		changeWidthColumn();
	}

}
