import javax.swing.JFrame;

import com.cmv.petGenesis.view.JDialogLogin;
import com.cmv.petGenesis.view.JPanelLogin;
import com.cmv.petGenesis.view.JPanelSignIn;

public class Tests1 {
	public static void main(String[] args) {
//		JFrame j = new JFrame("Prueba Login");
//		j.setSize(950, 550);
//		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		j.add(new LoginJPanel());
//		j.setVisible(true);
		JDialogLogin.getInstance().setVisible(true);
	}
}
