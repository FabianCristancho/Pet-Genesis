package com.cmv.petGenesis.toDelete;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Clase que crea los componentes basicos de GridBagLayout y
 * GridBagConstraints, además de crear botones y labeles por defecto.
 * 
 * @version 1.2 - 08/03/2019
 * @author Yohan Caro
 *
 */
public class GBLComponent {

	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	/**
	 * Crea y devuleve un GridBagLayout
	 * @return gbl layout
	 */
	public GridBagLayout getGBLComponent() {
		gbl = new GridBagLayout();
		gbl.rowHeights = new int[] {0, 0, 0, 0};
		gbl.columnWeights = new double[]{1.0, 1.0};
		gbc = new GridBagConstraints();
		return gbl;
	}

	/**
	 * Modifica las restricciones del GridBagLauout
	 * @param gridx x
	 * @param gridy y
	 * @param gridwidth columnas a ocupar
	 * @param gridHeigth filas a ocupar
	 * @param gbcFill config de la celda
	 * @return gbc contrains
	 */
	public GridBagConstraints changeGBC(int gridx, int gridy, int gridwidth, int gridHeigth, int gbcFill) {
		
		if (gbl != null) {
			gbc.insets = new Insets(0, 40, 30, 50);
			gbc.fill = gbcFill;
			gbc.gridx = gridx;
			gbc.gridy = gridy;
			gbc.gridwidth = gridwidth;
			gbc.gridheight = gridHeigth;
		} else {
			System.err.println("No ha instanciado el GridBagConstrains, primero cree el GBL");
		}
		
		return gbc;
	}
	
	/**
	 * Crea un boton con los siguientes parametros
	 * @param name nombre
	 * @param backGround color de fondo
	 * @param foreGround color de letra
	 * @param font fuente
	 * @return button boton
	 */
	public JButton createButton(String name, Color backGround, Color foreGround, Font font, boolean isOpaque) {
		JButton button = new JButton(name);
		if (font != null) {
			button.setFont(font);
		}
		button.setForeground(foreGround);
		button.setBackground(backGround);
		button.setOpaque(isOpaque);
		return button;
	}
	
	/**
	 * Crea un Jlabel con la siguiente informacion
	 * @param name nombre
	 * @param backGround color de fondo
	 * @param foreGround color de letra
	 * @param font fuente
	 * @return label JLabel
	 */
	public JLabel createLabel(String name, Color backGround, Color foreGround, Font font) {
		JLabel label = new JLabel(name);
		if (font != null) {
			label.setFont(font);
		}
		label.setForeground(foreGround);
		label.setBackground(backGround);
		
		return label;
	}
}
