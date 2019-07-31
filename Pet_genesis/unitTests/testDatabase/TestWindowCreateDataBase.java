package testDatabase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cmv.petGenesis.view.historyManagement.JPanelRecet;

public class TestWindowCreateDataBase {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(new Dimension(700, 70));
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpanel1 = new JPanel(new BorderLayout());
		JLabel jLabel = new JLabel("ESCRIBA NOMBRE DE BASE DE DATOS");
		JTextField jTextField = new JTextField(20);
		JButton jButton = new JButton("CREAR BASE DE DATOS");
		
		SQLDataBase sqlDataBase = new SQLDataBase();
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jTextField.getText();
				if(sqlDataBase.createDataBase(name))
					JOptionPane.showMessageDialog(null, "BASE DE DATOS CREADA CON EXITO");
				else
					JOptionPane.showMessageDialog(null, "NO FUE POSIBLE CREAR LA BASE DE DATOS");
					
			}
		});
		
		jpanel1.add(jLabel, BorderLayout.WEST);
		jpanel1.add(jTextField, BorderLayout.CENTER);
		jpanel1.add(jButton, BorderLayout.EAST);
		
		jFrame.add(jpanel1);
		jFrame.setVisible(true);
	}

}
