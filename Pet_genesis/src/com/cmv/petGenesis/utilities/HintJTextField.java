package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.LinkedList;

import javax.swing.JTextField;

/**
 * Clase HintJTextField - Se encarga de crear un texto que desaparece al escribir en un
 * jtextfield
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class HintJTextField extends JTextField implements FocusListener {
	private static final long serialVersionUID = 1L;
	private final String hint;
	private boolean showingHint;
	private int limit;
	private LinkedList<Character> requiredCharacters;
	private LinkedList<Character> prohibitedCharacters;

	/**
	 * Constructor con:
	 * @param hint texto a ocultar
	 * @param cols columnas - tama�os
	 */
	public HintJTextField(String hint, int cols) {
		super(hint);
		this.setColumns(cols);
		this.setForeground(Color.gray);
		this.hint = hint;
		this.showingHint = true;
		this.requiredCharacters = new LinkedList<Character>();
		this.prohibitedCharacters = new LinkedList<Character>();
		this.init();
	}

	/**
	 * Constructor con:
	 * @param hint texto oculto
	 * @param limit limite
	 * @param cols columnas
	 */
	public HintJTextField(String hint, int limit, int cols) {
		this(hint, cols);
		this.limit = limit;
	}

	/**
	 * Inicializa el focuslistener
	 */
	private void init() {
		super.addFocusListener(this);
	}

	/**
	 * Verificador de caracteres
	 * @return true - false
	 */
	private boolean isCompliant() {
		for (Character c : this.requiredCharacters) {
			if (!this.getText().contains(c + ""))
				return false;
		}
		return true;
	}

	/**
	 * Se encarga de evitar que se escriban letras
	 * @param chars caracteres
	 */
	public void prohibitedCharacters(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			this.prohibitedCharacters.add(chars[i]);
		}
	}

	/**
	 * Caracteres requeridos
	 * @param chars caracteres
	 */
	public void requiredCharacters(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			this.requiredCharacters.add(chars[i]);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			this.setForeground(Color.black);
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			this.setForeground(Color.gray);
			showingHint = true;
		}
	}

	/**
	 * Cambia de color al texto oculto
	 */
	public void putHint() {
		setText(hint);
		this.setForeground(Color.gray);
		showingHint = true;
	}

	@Override
	public void setText(String t) {
		super.setText(t);
		showingHint = false;
		this.setForeground(Color.black);
		if (t.equals("")) {
			putHint();
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}