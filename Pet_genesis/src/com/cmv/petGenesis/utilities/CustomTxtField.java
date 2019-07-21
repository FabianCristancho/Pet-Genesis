package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class CustomTxtField extends JTextField{
	
	
	public CustomTxtField(int columns, int aligment) {
		super(columns);
		this.setHorizontalAlignment(aligment);
	}
	
	public CustomTxtField(int columns, Font font, int aligment) {
		super(columns);
		this.setFont(font);
		this.setHorizontalAlignment(aligment);
		this.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
	}
	
	public CustomTxtField(int columns, Font font) {
		super(columns);
		this.setFont(font);
		this.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
	}
	
	public CustomTxtField(int columns, Font font, Color color, int aligment) {
		super(columns);
		this.setFont(font);
		this.setForeground(color);
		this.setHorizontalAlignment(aligment);
	}
}
