package com.cmv.petGenesis.view.clientManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class JpanelGroupClient extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateClient jCreateClient;
	private JpanelUpdateClient jUpdateClient;
	private JpanelFindClient jFindClient;
	private JPanelInactivClient jPanelInactivClient;
	
	public JpanelGroupClient() {
		super();
		cardLayout = new CardLayout();
		jCreateClient = new JPanelCreateClient();
		jUpdateClient = new JpanelUpdateClient();
		jFindClient = new JpanelFindClient();
		jPanelInactivClient = new JPanelInactivClient();
		init();
	}

	private void init() {
		this.setLayout(cardLayout);
		this.add("Crear", jCreateClient);
		this.add("Modificar", jUpdateClient);
		this.add("Inactivar", jPanelInactivClient);
		this.add("Consultar", jFindClient);
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
		this.jFindClient.loadAllData();
		this.repaint();
	}
	
	public void showInactive() {
		this.cardLayout.show(this, "Inactivar");
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanelCreateClient getjCreateClient() {
		return jCreateClient;
	}

	public JpanelUpdateClient getjUpdateClient() {
		return jUpdateClient;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public void setjCreateClient(JPanelCreateClient jCreateClient) {
		this.jCreateClient = jCreateClient;
	}

	public void setjUpdateClient(JpanelUpdateClient jUpdateClient) {
		this.jUpdateClient = jUpdateClient;
	}
	
}