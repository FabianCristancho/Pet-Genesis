package com.cmv.petGenesis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		default:
			break;
		}
	}

	private void openUserManagementWindow() {
		this.jFrameMainWindow.dispose();
		new JFrameUser();
	}

	public void setjFrameMainWindow(JFrameMainWindow jFrameMainWindow) {
		this.jFrameMainWindow = jFrameMainWindow;
	}
	
}
