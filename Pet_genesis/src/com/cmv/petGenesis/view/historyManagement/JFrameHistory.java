package com.cmv.petGenesis.view.historyManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.cmv.petGenesis.model.User;

/**
 * Clase JFrameHistory - Se encarag de crear la ventana principal de la vista de las
 * historias clinicas
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JFrameHistory extends JFrame{
	
	private JPanelGroupHistory jpanelGroupHistory;
	private JPanelOptionHistory jPanelOptionHistory;
	
	/**
	 * Constructor 
	 * @param user usuario
	 */
	public JFrameHistory(User user) {
		super();
		this.jPanelOptionHistory = new JPanelOptionHistory();
		this.jpanelGroupHistory = new JPanelGroupHistory(user);
		init();
	}

	/**
	 * Inicia los componentes y cnfiguración del jframe
	 */
	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(jPanelOptionHistory, BorderLayout.WEST);
		this.add(jpanelGroupHistory, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
