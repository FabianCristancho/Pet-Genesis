package com.cmv.petGenesis.view.historyManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.utilities.ConstantView;

/**
 * Clase JPanelGroupHistory - Se encarga de manejar y agrpar los paneles de acciones 
 * de las historias clinicas y los unen con un cardlayout
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JPanelGroupHistory extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateHistory jCreateHistory;
	private JPanelUpdateHistory jUpdateHistory;
	private JPanelFindHistory jFindHistory;
	private JPanelStateHistory jChangeStateHistory;
	private JPanelNewConsult jPanelNewConsult;
	
	/**
	 * Constructor del panel de grupos
	 * @param user usuario
	 */
	public JPanelGroupHistory(User user) {
		super();
		cardLayout = new CardLayout();
		jCreateHistory = new JPanelCreateHistory(user);
		jUpdateHistory = new JPanelUpdateHistory();
		jFindHistory = new JPanelFindHistory();
		jChangeStateHistory = new JPanelStateHistory();
		jPanelNewConsult = new JPanelNewConsult(user);
		ControlHistory.getInstance().setjPanelGroupHistory(this);
		init();
	}

	/**
	 * Inicializa los paneles de las opciones historia clinica
	 */
	private void init() {
		this.setLayout(cardLayout);
		this.add(ConstantView.CARD_CREATE_HISTORY, jCreateHistory);
		this.add(ConstantView.CARD_UPDATE_HISTORY, jUpdateHistory);
		this.add(ConstantView.CARD_STATE_HISTORY, jChangeStateHistory);
		this.add(ConstantView.CARD_FIND_HISTORY, jFindHistory);
		this.add(ConstantView.CARD_NEW_CONSULT, jPanelNewConsult);
		cardLayout.show(this, ConstantView.CARD_CREATE_HISTORY);
	}
	
	/**
	 * Muestra el panel de creación
	 */
	public void showCreate() {
		this.cardLayout.show(this, ConstantView.CARD_CREATE_HISTORY);
		this.repaint();
	}
	
	/**
	 * Muestra el panel de actalización
	 */
	public void showUpdate() {
		this.cardLayout.show(this, ConstantView.CARD_UPDATE_HISTORY);
		this.repaint();
	}
	
	public void showNewConsult() {
		this.cardLayout.show(this, ConstantView.CARD_NEW_CONSULT);
		this.repaint();
	}
	
	/**
	 * Muestra el panel de busquedas
	 */
	public void showFind() {
		this.cardLayout.show(this, ConstantView.CARD_FIND_HISTORY);
		this.repaint();
	}
	
	/**
	 * Muestra el panel de estados
	 */
	public void showState() {
		this.cardLayout.show(this, ConstantView.CARD_STATE_HISTORY);
	}

	/**
	 * Obtiene el card layout
	 * @return cardLayout cards
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Cambia el cardlayout por uno nuevo
	 * @param cardLayout cards
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

}
