//package otherTests;
//
//import java.awt.CardLayout;
//
//import javax.swing.JPanel;
//
//public class JpanelGroupUser extends JPanel{
//	
//	private CardLayout cardLayout;
//	private JPanelCreateUser jCreateUser;
//	private JpanelUpdateClient jUpdateClient;
//	private JpanelFindUser jFindUser;
//	private JPanelPrueba jPanelPrueba;
//	
//	public JpanelGroupUser() {
//		super();
//		cardLayout = new CardLayout();
//		jCreateUser = new JPanelCreateUser();
//		jUpdateClient = new JpanelUpdateClient();
//		jFindUser = new JpanelFindUser();
//		jPanelPrueba = new JPanelPrueba();
//		init();
//	}
//
//	private void init() {
//		this.setLayout(cardLayout);
//		this.add("Crear", jCreateUser);
//		this.add("Modificar", jUpdateClient);
//		this.add("Consultar", jFindUser);
//		cardLayout.show(this, "Crear");
//	}
//	
//	public void showCreate() {
//		this.cardLayout.show(this, "Crear");
//		this.repaint();
//	}
//	
//	public void showUpdate() {
//		this.cardLayout.show(this, "Modificar");
//		this.repaint();
//	}
//	
//	public void showFind() {
//		this.cardLayout.show(this, "Consultar");
//		this.repaint();
//	}
//
//	public CardLayout getCardLayout() {
//		return cardLayout;
//	}
//
//	public JPanelCreateUser getjCreateClient() {
//		return jCreateUser;
//	}
//
//	public JpanelUpdateClient getjUpdateClient() {
//		return jUpdateClient;
//	}
//
//	public void setCardLayout(CardLayout cardLayout) {
//		this.cardLayout = cardLayout;
//	}
//
//	public void setjCreateUser(JPanelCreateUser jCreateClient) {
//		this.jCreateUser = jCreateClient;
//	}
//
//	public void setjUpdateClient(JpanelUpdateClient jUpdateClient) {
//		this.jUpdateClient = jUpdateClient;
//	}
//}