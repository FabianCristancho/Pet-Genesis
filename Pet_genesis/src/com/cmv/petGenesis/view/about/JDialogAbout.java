package com.cmv.petGenesis.view.about;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cmv.petGenesis.utilities.ConstantView;

/**
 * Se encarga de mostrar la ventana de acerca de la aplicacion
 * 
 * @version 1.0 - 01/08/2018
 * @author Yohan Caro - Fabian Alejandro Cristancho Rincon
 *
 */
public class JDialogAbout extends JDialog {

	private JPanel panelN;
	private JPanel panelC;
	private JPanel panelS;
	private JLabel title;
	private JTextArea textAbout;
	private JScrollPane scroll;

	/**
	 * Constructor que inicializa los principales componentes de la ventana
	 */
	public JDialogAbout() {
		super();
		this.panelN = new JPanel();
		this.panelC = new JPanel();
		this.panelS = new JPanel();
		this.title = new JLabel();
		this.textAbout = new JTextArea();
		this.scroll = new JScrollPane(panelC, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		init();
	}

	/**
	 * Se encarga de dar propiedades a los componentes de la ventana
	 */
	public void init() {
		title.setFont(ConstantView.FONT_ABOUT);
		title.setText(ConstantView.APP_NAME);
		title.setForeground(new Color(255, 252, 76));

		textAbout.setText(ConstantView.ABOUT);
		textAbout.setFont(ConstantView.FONT_TEXT_ABOUT);
		textAbout.setEditable(false);
		textAbout.setBackground(new Color(185, 206, 229));

		panelN.setBackground(new Color(75, 120, 168));
		panelN.setForeground(Color.WHITE);
		panelC.setBackground(new Color(185, 206, 229));
		panelC.setForeground(Color.WHITE);
		panelS.setBackground(new Color(75, 120, 168));
		panelS.setForeground(Color.WHITE);

		panelS.setLayout(new FlowLayout());
		panelN.add(title);
		panelC.add(textAbout);

		setLayout(new BorderLayout());
		setResizable(true);
		setSize(ConstantView.DIMENSION_ABOUT);
		setLocationRelativeTo(null);
		setBackground(Color.ORANGE);
		setForeground(Color.WHITE);

		this.add(panelC, BorderLayout.CENTER);
		this.add(panelN, BorderLayout.NORTH);
		this.add(panelS, BorderLayout.SOUTH);
		this.scroll.setViewportView(panelC);
		this.add(scroll, BorderLayout.CENTER);
	}

}
