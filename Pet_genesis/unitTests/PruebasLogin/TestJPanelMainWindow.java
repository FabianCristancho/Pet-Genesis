package PruebasLogin;

import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;
import com.cmv.petGenesis.view.JFrameMainWindow;


/**
 * TestJPanelMainWindow, prueba el funcionamiento de la ventana principal de la
 * app
 * 
 * @version 1.0 - 28/09/2018
 * @author Fabian Alejandro Cristancho Rincon
 *
 */
public class TestJPanelMainWindow {

	public static void main(String[] args) {
//		JFrame jFrame = new JFrame("POKEMON GO - GAMEAREA");
//		jFrame.setSize(600, 600);
//		jFrame.setLocationRelativeTo(null);
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanelMainWindow jWindow = new JPanelMainWindow("ddf");
//		jFrame.add(jWindow);
//		jFrame.setVisible(true);
		new JFrameMainWindow(new User());
	}
}
