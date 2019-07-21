package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.Border;

public class CustomLabel extends JLabel{
	
	private Font font;
	private Color color;
	private Border border;
	
	public CustomLabel() {
	}
	
	public CustomLabel(String text) {
		super(text);
	}
	
	public CustomLabel(String text, Font font, Color color, Border border) {
		super(text);
		this.font = font;
		this.color = color;
		this.border = border;
		init();
	}
	
	public CustomLabel(String text, Font font, Color color) {
		super(text);
		this.font = font;
		this.color = color;
		init();
	}

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
