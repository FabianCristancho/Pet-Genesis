package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Clase CustomLabel - Maneja el JLabel de una manera más fácil que ahorra código
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class CustomLabel extends JLabel{
	
	private Font font;
	private Color color;
	private Border border;
	
	/**
	 * Constructor vacio
	 */
	public CustomLabel() {
	}
	
	/**
	 * Constructor con un texto por defceto pra el label
	 * @param text texto
	 */
	public CustomLabel(String text) {
		super(text);
	}
	
	/**
	 * Constructor con:
	 * @param text texto
	 * @param font fuente
	 * @param color color
	 * @param border dorde
	 */
	public CustomLabel(String text, Font font, Color color, Border border) {
		super(text);
		this.font = font;
		this.color = color;
		this.border = border;
		init();
	}
	
	/**
	 * Constructor con:
	 * @param text texto
	 * @param font fuente
	 * @param color color
	 */
	public CustomLabel(String text, Font font, Color color) {
		super(text);
		this.font = font;
		this.color = color;
		init();
	}

	/**
	 * Inicia componentes
	 */
	private void init() {
		if(font!=null) {
			this.setFont(font);
		}
		if(color!=null) {
			this.setForeground(color);
		}
		if(border!=null) {
			this.setBorder(border);
		}
	}
}
