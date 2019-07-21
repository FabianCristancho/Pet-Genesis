package com.cmv.petGenesis.view.historyManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.cmv.petGenesis.controller.ControlHistory;
import com.cmv.petGenesis.utilities.ConstantView;

public class JPanelGroupHistory extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateHistory jCreateHistory;
	private JPanelUpdateHistory jUpdateHistory;
	private JPanelFindHistory jFindHistory;
	private JPanelStateHistory jChangeStateHistory;
	
	public JPanelGroupHistory() {
		super();
		cardLayout = new CardLayout();
		jCreateHistory = new JPanelCreateHistory();
		jUpdateHistory = new JPanelUpdateHistory();
		jFindHistory = new JPanelFindHistory();
		jChangeStateHistory = new JPanelStateHistory();
		ControlHistory.getInstance().setjPanelGroupHistory(this);
		init();
	}

	private void init() {
		this.setLayout(cardLayout);
		this.add(ConstantView.CARD_CREATE_HISTORY, jCreateHistory);
		this.add(ConstantView.CARD_UPDATE_HISTORY, jUpdateHistory);
		this.add(ConstantView.CARD_STATE_HISTORY, jChangeStateHistory);
		this.add(ConstantView.CARD_FIND_HISTORY, jFindHistory);
		cardLayout.show(this, ConstantView.CARD_CREATE_HISTORY);
	}
	
	public void showCreate() {
		this.cardLayout.show(this, ConstantView.CARD_CREATE_HISTORY);
		this.repaint();
	}
	
	public void showUpdate() {
		this.cardLayout.show(this, ConstantView.CARD_UPDATE_HISTORY);
		this.repaint();
	}
	
	public void showFind() {
		this.cardLayout.show(this, ConstantView.CARD_FIND_HISTORY);
//		this.jFindHistory.loadAllData();
		this.repaint();
	}
	
	public void showState() {
		this.cardLayout.show(this, ConstantView.CARD_STATE_HISTORY);
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}


	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}


}
