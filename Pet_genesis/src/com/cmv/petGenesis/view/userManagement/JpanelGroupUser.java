package com.cmv.petGenesis.view.userManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class JpanelGroupUser extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateUser jCreateUser;
	private JpanelUpdateUser jUpdateClient;
	private JpanelFindUser jFindUser;
	private JPanelInactivUser jPanelInactivUser;
	
	public JpanelGroupUser() {
		super();
		cardLayout = new CardLayout();
		jCreateUser = new JPanelCreateUser();
		jUpdateClient = new JpanelUpdateUser();
		jFindUser = new JpanelFindUser();
		jPanelInactivUser = new JPanelInactivUser();
		init();
	}

	private void init() {
		this.setLayout(cardLayout);
		this.add("Crear", jCreateUser);
		this.add("Modificar", jUpdateClient);
		this.add("Inactivar", jPanelInactivUser);
		this.add("Consultar", jFindUser);
		cardLayout.show(this, "Crear");
	}
	
	public void showCreate() {
		this.cardLayout.show(this, "Crear");
		this.repaint();
	}
	
	public void showUpdate() {
		this.cardLayout.show(this, "Modificar");
		this.repaint();
	}
	
	public void showFind() {
		this.cardLayout.show(this, "Consultar");
		this.jFindUser.loadAllData();
		this.repaint();
	}
	
	public void showInactive() {
		this.cardLayout.show(this, "Inactivar");
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanelCreateUser getjCreateClient() {
		return jCreateUser;
	}

	public JpanelUpdateUser getjUpdateClient() {
		return jUpdateClient;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public void setjCreateUser(JPanelCreateUser jCreateClient) {
		this.jCreateUser = jCreateClient;
	}

	public void setjUpdateClient(JpanelUpdateUser jUpdateClient) {
		this.jUpdateClient = jUpdateClient;
	}
}