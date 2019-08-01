package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * Clase CustomTxtField - Se encarga de crear un JTextField de manera más sencilla
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class CustomTxtField extends JTextField{
	
	/**
	 * Constructor con:
	 * @param columns columnas
	 * @param aligment alineación
	 */
	public CustomTxtField(int columns, int aligment) {
		super(columns);
		this.setHorizontalAlignment(aligment);
	}
	
	/**
	 * Constructor con:
	 * @param columns columnas
	 * @param font fuente
	 * @param aligment alieación
	 */
	public CustomTxtField(int columns, Font font, int aligment) {
		super(columns);
		this.setFont(font);
		this.setHorizontalAlignment(aligment);
		this.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
	}
	
	/**
	 * Constructor con:
	 * @param columns columnas
	 * @param font fuente
	 */
	public CustomTxtField(int columns, Font font) {
		super(columns);
		this.setFont(font);
		this.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
	}
	
	/**
	 * Constructor con:
	 * @param columns columnas
	 * @param font fuente
	 * @param color color
	 * @param aligment alineación
	 */
	public CustomTxtField(int columns, Font font, Color color, int aligment) {
		super(columns);
		this.setFont(font);
		this.setForeground(color);
		this.setHorizontalAlignment(aligment);
	}
}
