package com.cmv.petGenesis.view.mainWindow;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JDialogLogin extends JDialog {
	private static JDialogLogin enterJDialog;
	private CardLayout cardLayout;
	private JPanelLogin loginJPanel;
	private JPanelSignIn signInJPanel;
	private JPanel downJPanel;

	/**
	 * Constructor que iniclaiza los componetes que va atener el dialog del
	 * login
	 */
	private JDialogLogin() {
		EnterListener.getInstance().setEnterJDialog(this);
		this.cardLayout = new CardLayout();
		this.loginJPanel = new JPanelLogin();
		this.signInJPanel = new JPanelSignIn();
		this.downJPanel = new JPanel(cardLayout);
		this.init();
	}

	/**
	 * Añade los componentes al JDialog del login
	 */
	private void init() {
		this.setIconImage(new ImageIcon("./res/icons/icon.png").getImage());
		JLabel backgroundImage = new JLabel(new ImageIcon("./res/images/loginBack.jpg"));
		backgroundImage.setLayout(new BorderLayout());
		JPanel upJPanel = new JPanel(new FlowLayout());
		upJPanel.setOpaque(false);

		backgroundImage.add(upJPanel, BorderLayout.SOUTH);

		downJPanel.add(loginJPanel, ConstantsLogin.LOGIN);
		downJPanel.add(signInJPanel, ConstantsLogin.SIGN_IN);
		this.downJPanel.setOpaque(false);
		backgroundImage.add(downJPanel, BorderLayout.CENTER);
		this.add(backgroundImage);
		this.setTitle(ConstantsLogin.TITLE_ENTER_DIALOG);
		this.setSize(600, 550);
		this.setBackground(ConstantsLogin.COLOR_LB_BACKGROUND);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Muestra la carta del card layout
	 * @param name nombre de la carta
	 */
	public void show(String name) {
		this.cardLayout.show(this.downJPanel, name);
		this.repaint();
	}



	public void clearFields() {
		this.loginJPanel.clearFields();
		this.signInJPanel.clearFields();
		
	}

	/**
	 * Crea la instancia de la clase
	 * @return enterJDioalog objeto instanciado
	 */
	public static JDialogLogin getInstance() {
		if (enterJDialog == null)
			enterJDialog = new JDialogLogin();
		return enterJDialog;
	}

}
