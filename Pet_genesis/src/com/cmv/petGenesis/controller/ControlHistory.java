package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.view.clientManagement.JDialogNewClient;
import com.cmv.petGenesis.view.historyManagement.JPanelComments;
import com.cmv.petGenesis.view.historyManagement.JPanelConsult;
import com.cmv.petGenesis.view.historyManagement.JPanelCreateHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelFormDataPet;
import com.cmv.petGenesis.view.historyManagement.JPanelGroupHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelMedicine;
import com.cmv.petGenesis.view.historyManagement.JPanelUpdateHistory;

public class ControlHistory implements ActionListener, KeyListener, ItemListener {

	private static ControlHistory controlHistory;
	private JPanelCreateHistory jPanelCreateHistory;
	private JPanelUpdateHistory jPanelUpdateHistory;
	private JPanelGroupHistory jPanelGroupHistory;
	private JPanelComments jPanelComments;
	private JPanelMedicine jPanelMedicine;
	private JPanelConsult jPanelConsult;
	private JDialogNewClient jDialogNewClient;

	private ControlHistory() {
	}

	public static ControlHistory getInstance() {
		if (controlHistory == null)
			controlHistory = new ControlHistory();
		return controlHistory;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (HistoryCommands.valueOf(e.getActionCommand())) {
		case CMD_BTN_CREATE_HISTORY:
			jPanelGroupHistory.showCreate();
			break;
		case CMD_BTN_UPDATE_HISTORY:
			jPanelGroupHistory.showUpdate();
			break;
		case CMD_BTN_STATE_HISTORY:
			jPanelGroupHistory.showState();
			break;
		case CMD_BTN_FIND_HISTORY:
			jPanelGroupHistory.showFind();
			break;
		case CMD_WD_COMMENTS_CLEAR_COM:
			jPanelComments.clearComments();
			break;
		case CMD_WD_EXAM_CLEAR_FIELDS:
			jPanelConsult.clearFields();
			break;
		case CMD_WD_PET_REGISTER_HIS:
			jPanelCreateHistory.registerHistory(new Pet());
			break;
		case CMD_BTN_NEW_CLIENT:
			jDialogNewClient = new JDialogNewClient();
			break;
		case CMD_BTN_SEARCH_CLIENT:
			jPanelUpdateHistory.getDataQuery();
			break;
		case CMD_BTN_KEEP_HISTORY:
			
			break;
		default:
			break;
		}
	}

	public void setjPanelGroupHistory(JPanelGroupHistory jPanelGroupHistory) {
		this.jPanelGroupHistory = jPanelGroupHistory;
	}

	public void setjPanelComments(JPanelComments jPanelComments) {
		this.jPanelComments = jPanelComments;
	}

	public void setjPanelMedicine(JPanelMedicine jPanelMedicine) {
		this.jPanelMedicine = jPanelMedicine;
	}

	public void setjPanelConsult(JPanelConsult jPanelConsult) {
		this.jPanelConsult = jPanelConsult;
	}
	
	

	public void setjPanelUpdateHistory(JPanelUpdateHistory jPanelUpdateHistory) {
		this.jPanelUpdateHistory = jPanelUpdateHistory;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		
		if (e.getComponent().equals(jPanelCreateHistory.getJtfPropietary())) {
			if (c < '0' || c > '9')
				e.consume();
		}else if (e.getComponent().equals(jPanelCreateHistory.getJtfNamePet()) || e.getComponent().equals(jPanelCreateHistory.getJtfColorPet())) {
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
				e.consume();
		}
	}
	
	

	public void setjPanelCreateHistory(JPanelCreateHistory jPanelCreateHistory) {
		this.jPanelCreateHistory = jPanelCreateHistory;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(jPanelCreateHistory.getComboSpecies())) {
			jPanelCreateHistory.changeRaces();
		}else if (e.getSource().equals(jPanelUpdateHistory.getComboSpecies())) {
			jPanelUpdateHistory.changeRaces();
		}
	}

}
