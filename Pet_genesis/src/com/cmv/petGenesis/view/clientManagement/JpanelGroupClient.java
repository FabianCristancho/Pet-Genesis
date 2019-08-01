package com.cmv.petGenesis.view.clientManagement;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Clase JpanelGroupClient - Se encarga de crear un panel que reune a los paneles de acciones
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class JpanelGroupClient extends JPanel{
	
	private CardLayout cardLayout;
	private JPanelCreateClient jCreateClient;
	private JpanelUpdateClient jUpdateClient;
	private JpanelFindClient jFindClient;
	private JPanelInactivClient jPanelInactivClient;
	
	/**
	 * Constructor
	 */
	public JpanelGroupClient() {
		super();
		cardLayout = new CardLayout();
		jCreateClient = new JPanelCreateClient();
		jUpdateClient = new JpanelUpdateClient();
		jFindClient = new JpanelFindClient();
		jPanelInactivClient = new JPanelInactivClient();
		init();
	}

	/**
	 * Inicializa los paneles
	 */
	private void init() {
		this.setLayout(cardLayout);
		this.add("Crear", jCreateClient);
		this.add("Modificar", jUpdateClient);
		this.add("Inactivar", jPanelInactivClient);
		this.add("Consultar", jFindClient);
		cardLayout.show(this, "Crear");
	}
	
	/**
	 * Muestra el panel de crear
	 */
	public void showCreate() {
		this.cardLayout.show(this, "Crear");
		this.repaint();
	}
	
	/**
	 * Muestra el panel de actualizar
	 */
	public void showUpdate() {
		this.cardLayout.show(this, "Modificar");
		this.repaint();
	}
	
	/**
	 * Muestra el panel de encontrar
	 */
	public void showFind() {
		this.cardLayout.show(this, "Consultar");
		this.jFindClient.loadAllData();
		this.repaint();
	}
	
	/**
	 * Muestra el panel de estado del cliente
	 */
	public void showInactive() {
		this.cardLayout.show(this, "Inactivar");
	}

	/**
	 * Obtiene le cardlayout
	 * @return cardLayout cards
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Obtiene el panel de crear cliente
	 * @return jCreateClient jpanel
	 */
	public JPanelCreateClient getjCreateClient() {
		return jCreateClient;
	}

	/**
	 * Obtine el panel de actualizar clientes
	 * @return jUpdateClient jpanel
	 */
	public JpanelUpdateClient getjUpdateClient() {
		return jUpdateClient;
	}

	/**
	 * Cambia el cardlayout
	 * @param cardLayout cards
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	/**
	 * Cambia el panel de crear clientes
	 * @param jCreateClient jpanel
	 */
	public void setjCreateClient(JPanelCreateClient jCreateClient) {
		this.jCreateClient = jCreateClient;
	}

	/**
	 * Cambia el panel actualizar clientes
	 * @param jUpdateClient jpanel
	 */
	public void setjUpdateClient(JpanelUpdateClient jUpdateClient) {
		this.jUpdateClient = jUpdateClient;
	}
	
}