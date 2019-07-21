package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.view.historyManagement.JPanelComments;
import com.cmv.petGenesis.view.historyManagement.JPanelGroupHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelMedicine;

public class ControlHistory implements ActionListener{
	
	private static ControlHistory controlHistory;
	private JPanelGroupHistory jPanelGroupHistory;
	private JPanelComments jPanelComments;
	private JPanelMedicine jPanelMedicine;
	
	private ControlHistory() {
	}
	
	public static ControlHistory getInstance() {
		if(controlHistory == null)
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
		case CMD_WD_MEDICINE_CLEAR_VAC:
			jPanelMedicine.clearCommentsVaccine();
			break;
		case CMD_WD_MEDICINE_CLEAR_ANTI:
			jPanelMedicine.clearCommentsAnti();
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
	
}
