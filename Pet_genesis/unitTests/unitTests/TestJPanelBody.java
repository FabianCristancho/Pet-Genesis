package unitTests;

import javax.swing.JFrame;

import com.cmv.petGenesis.view.appointment.JPanelBody;

public class TestJPanelBody {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(new JPanelBody());
		jFrame.setVisible(true);
	}
}
