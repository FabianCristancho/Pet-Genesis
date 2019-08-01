package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;
import com.cmv.petGenesis.utilities.CustomLabel;
import com.cmv.petGenesis.utilities.UtilityClass;

/**
 * Clase JPanelComments - Se encarga de crear el formulario de comentarios de las
 * historias clinicas
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelComments extends JPanel {
	
	private CustomLabel titleComments;
	public JTextArea jtaComments;
	private JScrollPane scrollComments;
	private JButton btnClearComments;
	private JPanel jpanelButtons;

	/**
	 * Constructor del panel
	 */
	public JPanelComments() {
		super(new BorderLayout());
		this.titleComments = new CustomLabel(ConstantView.TITLE_COMMENTS, ConstantView.FONT_TITLE_COMMENTS, null);
		this.jtaComments = new JTextArea();
		this.scrollComments = new JScrollPane();
		this.btnClearComments = new JButton(ConstantView.BTN_CLEAR_COMMENTS);
		this.jpanelButtons = new JPanel(new GridBagLayout());
		ControlHistory.getInstance().setjPanelComments(this);
		init();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void init() {
		this.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 20));
		this.titleComments.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleComments, BorderLayout.NORTH);
		
		this.jtaComments.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.jtaComments.setLineWrap(true);
		this.jtaComments.setWrapStyleWord(true);
		this.jtaComments.setFont(ConstantView.FONT_AREA_COMMENTS);
		
		this.scrollComments.setViewportView(jtaComments);
		this.add(scrollComments, BorderLayout.CENTER);
		
		initPanelComments();
		this.jpanelButtons.setOpaque(false);
		this.add(jpanelButtons, BorderLayout.SOUTH);
	}
	
	/**
	 * Inicializa los componentes para los comentarios
	 */
	private void initPanelComments() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.EAST;
		
		UtilityClass.organizeGridLayout(gbc, 0, 0);
		UtilityClass.addCommandJButton(btnClearComments, HistoryCommands.CMD_WD_COMMENTS_CLEAR_COM.toString(), ControlHistory.getInstance());
		this.btnClearComments.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnClearComments.setFocusable(false);
		this.jpanelButtons.add(btnClearComments, gbc);
	}
	
	/**
	 * Limpia el area de comentarios
	 */
	public void clearComments() {
		int option = JOptionPane.showConfirmDialog(null, "ESTÁ SEGURO DE BORRAR TODOS LOS COMENTARIOS\nLA ACCIÓN NO TENDRÁ REVERSA", "BORRADO PERMANENTE", JOptionPane.YES_NO_OPTION);
		if(option == 0) {
			this.jtaComments.setText("");
			JOptionPane.showMessageDialog(null, "COMENTARIOS BORRADOS CON ÉXITO", "BORRADO DE COMENTARIOS", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Obtener los componentes 
	 * @return jtaComments text
	 */
	public String getComments() {
		return this.jtaComments.getText();
	}
}
