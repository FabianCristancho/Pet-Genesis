import javax.swing.JFrame;

import com.cmv.petGenesis.view.EnterJDialog;
import com.cmv.petGenesis.view.LoginJPanel;
import com.cmv.petGenesis.view.SignInJPanel;

public class Tests1 {
	public static void main(String[] args) {
		JFrame j = new JFrame("Prueba Login");
		j.setSize(950, 550);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(new SignInJPanel());
		j.setVisible(true);
//		EnterJDialog.getInstance().setVisible(true);
	}
}
