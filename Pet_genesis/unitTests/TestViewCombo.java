import javax.swing.JFrame;

import com.cmv.petGenesis.view.userManagement.JPanelFormUser;

public class TestViewCombo {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(new JPanelFormUser());
		jFrame.setVisible(true);
	}

}
