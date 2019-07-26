package unitTests;

import javax.swing.JFrame;

import com.cmv.petGenesis.view.appointment.JPanelAppointment;
import com.cmv.petGenesis.view.appointment.JPanelECOP;
import com.cmv.petGenesis.view.appointment.JPanelExam;
import com.cmv.petGenesis.view.historyManagement.JPanelConsult;
import com.cmv.petGenesis.view.historyManagement.JPanelMedicine;

public class TestJPanelExam {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(new JPanelConsult());
		jFrame.setVisible(true);
	}

}
