package com.cmv.petGenesis.ReportManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.cmv.petGenesis.utilities.UtilityClass;

import otherTests.Jpanel1;

public class JpanelReport extends JPanel{
	
	private JLabel title;
	private JComboBox<String> typeReport;
	private JTextField jtfQuery;
	private JLabel typeReport2;
	private JLabel imgReport;
	private JButton generateReport;
	private JPanel jpUp;
	private JScrollPane jScrollPane;
	
	public JpanelReport() {
		super(new BorderLayout());
		init();
	}
	
	private void init() {
		this.jScrollPane = new JScrollPane();
		this.typeReport2 = new JLabel("Tipo de Reporte");
		this.typeReport2.setFont(new Font("Open Sans", Font.PLAIN, 15));
		this.jpUp = new JPanel(new GridBagLayout());
		this.title = new JLabel("GENERACIÓN DE REPORTES");
		this.title.setFont(new Font("Open Sans", Font.BOLD, 25));
		this.title.setForeground(Color.decode("#2E5569"));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		
		String[] type = {"Clientes", "Usuarios", "Mascotas"};
		this.typeReport = new JComboBox<>(type);
		
		this.jtfQuery = new JTextField(20);
		
		this.generateReport = new JButton("Generar reporte");
		this.generateReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				visible();
			}
		});
		this.imgReport = new JLabel(new ImageIcon("./res/images/reporte.PNG"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		UtilityClass.organizeGridLayout(gbc, 1, 0, new Insets(20, 20, 20, 20));
		
		this.jpUp.add(title, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 0, 1);
		this.jpUp.add(typeReport2, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 1, 1);
		this.jpUp.add(typeReport, gbc);
		
		UtilityClass.organizeGridLayout(gbc, 2, 1);
		this.jpUp.add(generateReport, gbc);
		
		this.add(jpUp, BorderLayout.NORTH);
//		this.jScrollPane.setVisible(false);
		
		jScrollPane.setPreferredSize(new Dimension(817, 100));
		jScrollPane.setViewportView(imgReport);
		jScrollPane.setVisible(true);
		this.add(jScrollPane, BorderLayout.CENTER);
		
		
	}
	
	public void visible() {
		this.repaint();
	}

}
