package com.cmv.petGenesis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cmv.petGenesis.ReportManagement.JFrameReport;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.view.clientManagement.JFrameClient;
import com.cmv.petGenesis.view.historyManagement.JFrameHistory;
import com.cmv.petGenesis.view.userManagement.JFrameUser;

public class ControlMainWindow implements ActionListener{
	
	private static ControlMainWindow controlMainWindow;
	private JFrameMainWindow jFrameMainWindow;
	
	private ControlMainWindow() {
	}
	
	public static ControlMainWindow getInstance() {
		if(controlMainWindow == null)
			controlMainWindow = new ControlMainWindow();
		return controlMainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (MainWindowCommands.valueOf(e.getActionCommand())) {
		case BUTTON_MNGM_USER:
			openUserManagementWindow();
			break;
		case BUTTON_MNGM_CLIENT:
			openClientManagementWindow();
			break;
		case BUTTON_MNGM_HISTORY:
			openHistoryManagementWindow();
			break;
		case BUTTON_MNGM_REPORT:
			openUserReporttWindow();
			break;

		default:
			break;
		}
	}

	private void openUserManagementWindow() {
//		this.jFrameMainWindow.dispose();
		new JFrameUser();
	}
	
	private void openClientManagementWindow() {
//		this.jFrameMainWindow.dispose();
		new JFrameClient();
	}
	
	private void openHistoryManagementWindow() {
//		this.jFrameMainWindow.dispose();
		new JFrameHistory(this.jFrameMainWindow.getUser());
	}
	
	private void openUserReporttWindow() {
//		this.jFrameMainWindow.dispose();
		new JFrameReport();
	}

	public void setjFrameMainWindow(JFrameMainWindow jFrameMainWindow) {
		this.jFrameMainWindow = jFrameMainWindow;
	}
	
}
