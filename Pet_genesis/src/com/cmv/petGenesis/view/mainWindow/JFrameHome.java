package com.cmv.petGenesis.view.mainWindow;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.cmv.petGenesis.model.Usuario;

public class JFrameHome extends JFrame{
	
	private JPanel jPanel;
	private JMenuBar jMenuBar;
	private Usuario mod;
	JMenu jMenu;
	JMenu jMenu2;
	
	public JFrameHome(Usuario mod) {
		super();
		this.jPanel = new JPanel();
		this.jMenuBar = new JMenuBar();
		this.mod = mod;
		init();
		
		if(mod.getTypeUser().getIdTypeUser()==1) {
			
		}else if (mod.getTypeUser().getIdTypeUser() == 2){
			jMenu.setVisible(false);
			jMenu2.setVisible(false);
		}
	}

	private void init() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.jPanel.setBackground(Color.ORANGE);
		this.add(jPanel);
		
		jMenu = new JMenu("GESTIONAR MASCOTAS");
		jMenu.add(new JMenuItem("Crear mascota"));
		jMenu.add(new JMenuItem("Modificar mascota"));
		this.jMenuBar.add(jMenu);
		
		jMenu2 = new JMenu("GESTIONAR CLIENTES");
		jMenu2.add(new JMenuItem("Crear cliente"));
		jMenu2.add(new JMenuItem("Modificar cliente"));
		
		this.setJMenuBar(jMenuBar);
		this.setVisible(true);
	}
}
