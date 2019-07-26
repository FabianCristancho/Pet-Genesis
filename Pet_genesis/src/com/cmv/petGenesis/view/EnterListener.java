package com.cmv.petGenesis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.model.Hash;
import com.cmv.petGenesis.model.SqlUSer;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;

public class EnterListener implements ActionListener, MouseListener, FocusListener, KeyListener {

	public static EnterListener eventsLogin;
	private JDialogLogin enterJDialog;
	private JPanelLogin loginJPanel;
//	private JPanelSignIn signInJPanel;

	private EnterListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (EnterCommands.valueOf(e.getActionCommand())) {
		case OK_LOGIN:
			validFieldsLogin();
			break;
		default:
			System.out.println(e.getActionCommand() + " no tiene una acción");
			break;
		}
	}

	private void validFieldsLogin() {
		loginJPanel.validFields(new User());
	}

//	private void saveDataSignIn() {
//		Usuario mod = new Usuario();
//		signInJPanel.saveDataSignIn(mod);
//	}

//	private void saveDataSignIn() {
//		SqlUSer modSql = new SqlUSer();
//		Usuario mod = new Usuario();
//		
//		String password = new String(signInJPanel.getJpfPassword().getPassword());
//		String passwordAgain = new String(signInJPanel.getJpfPasswordAgain().getPassword());
//		
//		if(password.equals(passwordAgain)) {
//			String newPass = Hash.sha1(password);
//			
//			mod.setName(name);
//		}else {
//			JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
//		}
//	}

//	private void sendSignInData() {
//		try {
//			PokemonListener.sendData(ClientCommands.SIGNIN, this.enterJDialog.getData());
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//	}
//
//	private void sendLoginData() {
//		try {
//			PokemonListener.sendData(ClientCommands.LOGIN, this.enterJDialog.getData());
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//	}

	public static EnterListener getInstance() {
		if (eventsLogin == null)
			eventsLogin = new EnterListener();
		return eventsLogin;
	}

	public void setEnterJDialog(JDialogLogin enterJDialog) {
		this.enterJDialog = enterJDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().equals(this.loginJPanel.getImgHelp())) {
			System.out.println("Click en ayuda");
		} else if (e.getComponent().equals(this.loginJPanel.getImgAbout())) {
			System.out.println("Click en información");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent().equals(this.loginJPanel.getImgHelp())) {
			System.out.println("Entra al boton de ayuda");
		} else if (e.getComponent().equals(this.loginJPanel.getImgAbout())) {
			System.out.println("Entra en información");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void setLoginJPanel(JPanelLogin loginJPanel) {
		this.loginJPanel = loginJPanel;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
//		if (e.getComponent().equals(signInJPanel.getJtfName())
//				|| e.getComponent().equals(signInJPanel.getJtfLastName())) {
//			signInJPanel.showUserName();
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
//		char c = e.getKeyChar();
//		if (e.getComponent().equals(signInJPanel.getJtfName())
//				|| e.getComponent().equals(signInJPanel.getJtfLastName())) {
//			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' '))
//				e.consume();
//		} else if (e.getComponent().equals(signInJPanel.getJtfId())
//				|| e.getComponent().equals(signInJPanel.getJtfPhone())) {
//			if (c < '0' || c > '9')
//				e.consume();
//		}
	}
}
