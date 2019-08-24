package com.cmv.petGenesis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.command.HistoryCommands;
import com.cmv.petGenesis.model.Consult;
import com.cmv.petGenesis.model.Medicament;
import com.cmv.petGenesis.model.Pet;
import com.cmv.petGenesis.model.Recet;
import com.cmv.petGenesis.model.RegisterExam;
import com.cmv.petGenesis.view.clientManagement.JDialogNewClient;
import com.cmv.petGenesis.view.historyManagement.JDialogWeight;
import com.cmv.petGenesis.view.historyManagement.JPanelComments;
import com.cmv.petGenesis.view.historyManagement.JPanelConsult;
import com.cmv.petGenesis.view.historyManagement.JPanelCreateHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelFindHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelGroupHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelNewConsult;
import com.cmv.petGenesis.view.historyManagement.JPanelRecet;
import com.cmv.petGenesis.view.historyManagement.JPanelSeeHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelStateHistory;
import com.cmv.petGenesis.view.historyManagement.JPanelUpdateHistory;

/**
 * Clase ControlHistory - Se encarga de la conexión de la vista y el modelo para
 * los enventos de la interfaz de usuario de la historia clinica y la lógica de
 * la historia ( de las mascotas)
 *
 * @version 1.0 - 31/07/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class ControlHistory implements ActionListener, KeyListener, ItemListener, MouseListener {

	private static ControlHistory controlHistory;
	private JPanelCreateHistory jPanelCreateHistory;
	private JPanelUpdateHistory jPanelUpdateHistory;
	private JPanelGroupHistory jPanelGroupHistory;
	private JPanelSeeHistory jPanelSeeHistory;
	private JPanelComments jPanelComments;
	private JPanelRecet jPanelMedicine;
	private JPanelConsult jPanelConsult;
	private JPanelFindHistory jPanelFindHistory;
	private JPanelStateHistory jPanelStateHistory;
	private JDialogWeight jDialogWeight;
	private JPanelNewConsult jPanelNewConsult;
	private JDialogNewClient jDialogNewClient;

	/**
	 * Constructor vacio
	 */
	private ControlHistory() {
	}

	/**
	 * Instancia única del controlador (Singleton)
	 * 
	 * @return controlClient controlador
	 */
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
		case CMD_BTN_NEW_CONSULT:
			jPanelGroupHistory.showNewConsult();
			break;
		case CMD_WD_RCONSULT_SEARCH:
			jPanelNewConsult.searchPet();
			break;
		case CMD_WD_COMMENTS_CLEAR_COM:
			jPanelComments.clearComments();
			break;
		case CMD_WD_EXAM_CLEAR_FIELDS:
			jPanelConsult.clearFields();
			break;
		case CMD_WD_PET_REGISTER_HIS:
			jPanelCreateHistory.registerHistory(new Pet());
			jPanelCreateHistory.saveConsult(new Consult());
			jPanelCreateHistory.saveExamEcop();
			jPanelCreateHistory.saveExamTPR();
			jPanelCreateHistory.saveExamBody();;
			jPanelCreateHistory.saveRegisterExam(new RegisterExam());
			jPanelCreateHistory.saveRecet(new Recet());
			break;
		case CMD_WD_RCONSULT_SAVE_CONSULT:
			jPanelNewConsult.saveAllConsultData();
			break;
		case CMD_BTN_NEW_CLIENT:
			jDialogNewClient = new JDialogNewClient();
			break;
		case CMD_BTN_SEARCH_CLIENT:
			jPanelUpdateHistory.getDataQuery();
			break;
		case CMD_BTN_KEEP_HISTORY:
			jPanelUpdateHistory.saveDataSignIn(new Pet());
			break;
		case CMD_WD_RECET_ADD_MEDIC:
			jPanelMedicine.addMedicament(new Medicament());
			break;
		case CMD_WD_SEARCH_PET:
			jPanelFindHistory.getTableSearch();
			break;
		case CMD_WD_LOAD_DATA:
			jPanelFindHistory.loadAllData();
			break;
		case CMD_WD_INACTIV_EXECUTE:
			jPanelStateHistory.changeWithField();
			break;
		case CMD_WD_INACTIV_CHANGE_TABLE:
			jPanelStateHistory.changeStateButton();
			break;
		case CMD_WD_WEIGTH_CLOSE:
			jDialogWeight.dispose();
			break;
		case CMD_WD_RHISTORY_WEIGHT:
			jPanelSeeHistory.showJDialogWeight();
			break;
		default:
			break;
		}
	}

	/**
	 * Cambia el valor de panel de agrupacion
	 * 
	 * @param jPanelGroupHistory jpanel
	 */
	public void setjPanelGroupHistory(JPanelGroupHistory jPanelGroupHistory) {
		this.jPanelGroupHistory = jPanelGroupHistory;
	}

	/**
	 * Cambia el valor del panel de comentarios
	 * 
	 * @param jPanelComments jpanel
	 */
	public void setjPanelComments(JPanelComments jPanelComments) {
		this.jPanelComments = jPanelComments;
	}

	/**
	 * Cambia el valor del panel de recetas
	 * 
	 * @param jPanelMedicine jpanel
	 */
	public void setjPanelMedicine(JPanelRecet jPanelMedicine) {
		this.jPanelMedicine = jPanelMedicine;
	}

	/**
	 * Cambia el valor del panel de consultas
	 * 
	 * @param jPanelConsult jpanel
	 */
	public void setjPanelConsult(JPanelConsult jPanelConsult) {
		this.jPanelConsult = jPanelConsult;
	}

	/**
	 * Cambia el valor del panel de actualizar historias
	 * 
	 * @param jPanelUpdateHistory jpanel
	 */
	public void setjPanelUpdateHistory(JPanelUpdateHistory jPanelUpdateHistory) {
		this.jPanelUpdateHistory = jPanelUpdateHistory;
	}

	/**
	 * Cambia el valor del panel de encontrar historias
	 * 
	 * @param jPanelFindHistory jpanel
	 */
	public void setjPanelFindHistory(JPanelFindHistory jPanelFindHistory) {
		this.jPanelFindHistory = jPanelFindHistory;
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

		if (e.getComponent().equals(jPanelCreateHistory.getJtfPropietary()) || e.getComponent().equals(jPanelNewConsult.getJtfInputQuery())) {
			if (c < '0' || c > '9')
				e.consume();
		} else if (e.getComponent().equals(jPanelCreateHistory.getJtfNamePet())
				|| e.getComponent().equals(jPanelCreateHistory.getJtfColorPet())) {
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
				e.consume();
		} else if (e.getComponent().equals(jPanelCreateHistory.getJtfWeight())
				|| e.getComponent().equals(jPanelCreateHistory.getJtfTemperature())
				|| e.getComponent().equals(jPanelCreateHistory.getJtfPression())
				|| e.getComponent().equals(jPanelCreateHistory.getJtfCardiac())
				|| e.getComponent().equals(jPanelCreateHistory.getJtfRespiratory())) {
			if ((c < '0' || c > '9') && (c < '.' || c > '.'))
				e.consume();
		}
	}
	

	public void setjPanelNewConsult(JPanelNewConsult jPanelNewConsult) {
		this.jPanelNewConsult = jPanelNewConsult;
	}

	/**
	 * Cambia el valor del panel de crear historias
	 * 
	 * @param jPanelCreateHistory jpanel
	 */
	public void setjPanelCreateHistory(JPanelCreateHistory jPanelCreateHistory) {
		this.jPanelCreateHistory = jPanelCreateHistory;
	}

	/**
	 * Cambia el valor de
	 * 
	 * @param jPanelStateHistory a jPanelStateHistory
	 */
	public void setjPanelStateHistory(JPanelStateHistory jPanelStateHistory) {
		this.jPanelStateHistory = jPanelStateHistory;
	}

	public void setjPanelSeeHistory(JPanelSeeHistory jPanelSeeHistory) {
		this.jPanelSeeHistory = jPanelSeeHistory;
	}
	
	public void setjDialogWeight(JDialogWeight jDialogWeight) {
		this.jDialogWeight = jDialogWeight;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(jPanelSeeHistory.getDataConsult())) {
			jPanelSeeHistory.setData();
		} else if (e.getSource().equals(jPanelCreateHistory.getComboSpecies())) {
			jPanelCreateHistory.changeRaces();
		} else if (e.getSource().equals(jPanelUpdateHistory.getComboSpecies())) {
			jPanelUpdateHistory.changeRaces();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent().equals(jPanelFindHistory.getjTable())) {
			jPanelFindHistory.showAllHistory(e.getPoint());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
