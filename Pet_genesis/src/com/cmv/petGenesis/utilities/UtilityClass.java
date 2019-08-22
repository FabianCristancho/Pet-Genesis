package com.cmv.petGenesis.utilities;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cmv.petGenesis.connection.SQLUsers;

/**
 * Clase UtilityClass - Se encaraga de manejar  métodos adicionales que pueden y son
 * usados en varias clases para reutilizar código
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class UtilityClass {

	/**
	 * Obtiene el dato scaled image.
	 *
	 * @param path el dato path
	 * @param d    el dato d
	 * @return el dato scaled image
	 */
	public static Icon getScaledImage(String path, Dimension d) {
		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH));
	}

	/**
	 * Obtiene el dato secaled image a partir de una ruta pasado por parametro
	 * 
	 * @param path Ruta de imagen
	 * @return Imagen escalada
	 */
	public static Icon getScaledIcon(String path) {
		return new ImageIcon(path);
	}

	/**
	 * Escala un icono a partir de su ruta y nuevas dimensiones
	 * 
	 * @param path Ruta de icono
	 * @param d    Nueva Dimension
	 * @return Icono escalado
	 */
	public static Image getScaledIcon(String path, Dimension d) {
		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH))
				.getImage();
	}

	/**
	 * Obtiene una imagen
	 * 
	 * @param path Ruta de imagen
	 * @return Imagen
	 */
	public static Image getImage(String path) {
		return new ImageIcon(UtilityClass.class.getResource(path)).getImage();
	}

	/**
	 * Verifica si un JTextField está vacio
	 * @param fields campos
	 * @return true vacio- false no
	 */
	public static boolean fieldsAreEmpty(JTextField[] fields) {
		for (int i = 0; i < fields.length; i++)
			if (fields[i].getText().length() == 0)
				return true;
		return false;
	}

	/**
	 * Agrega el comando ActionListener a un boton
	 * 
	 * @param jButton boton a agregar comandos
	 * @param command nombre de comando a implementar
	 */
	public static void addCommandJButton(JButton jButton, String command, ActionListener al) {
		jButton.setActionCommand(command);
		jButton.addActionListener(al);
	}

	/**
	 * Añade un borde a un componente con:
	 * @param component componente
	 * @param top arriba
	 * @param left izq
	 * @param bottom abajo
	 * @param right der
	 */
	public static void addBorder(JComponent component, int top, int left, int bottom, int right) {
		component.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
	}

	/**
	 * Cambia el formato de una fecha a yyyy-MM-dd
	 * @param date fechas
	 * @return fecha en otro formato
	 */
	public static String changeFormatToDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	/**
	 * Verifica que un email se avalido
	 * @param email correo
	 * @return true valido- false no
	 */
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

	/**
	 * Le pone formato a una fechas
	 * @param oldDate fecha
	 * @return cadena con formato
	 */
	public static String formatDate(String oldDate) {
		String[] newDate = oldDate.split("-");
		int day = ((int) newDate[2].charAt(1)) + 1;
		return newDate[2].charAt(0) + "" + (char) day + "/" + newDate[1] + "/" + newDate[0];
	}

	/**
	 * Añade días a una fecha
	 * @param fecha date
	 * @param dias days
	 * @return date d
	 */
	public static Date daysAdd(Date fecha, int dias) {
		if (dias == 0)
			return fecha;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

	/**
	 * Cambia el ancho de una columna
	 * @param jTable tabla
	 * @param position posicion
	 * @param newWidth nuevo ancho
	 */
	public static void changeWidthColumn(JTable jTable, int position, int newWidth) {
		jTable.getColumnModel().getColumn(position).setPreferredWidth(newWidth);
	}

	/**
	 * Organiza un GridBagLayout
	 * @param gbc GridBagLayout
	 * @param gridx pos x
	 * @param gridy pos y
	 */
	public static void organizeGridLayout(GridBagConstraints gbc, int gridx, int gridy) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
	}

	/**
	 * Organiza un GridBagLayout
	 * @param gbc GridBagLayout
	 * @param gridx pos x
	 * @param gridy pox y
	 * @param gridWidth ancho
	 * @param gridHeight alto
	 */
	public static void organizeGridLayout(GridBagConstraints gbc, int gridx, int gridy, int gridWidth, int gridHeight) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridWidth;
		gbc.gridheight = gridHeight;
	}

	/**
	 * Organiza un GridBagLayout con
	 * @param gbc GridBagLayout
	 * @param gridx pos x
	 * @param gridy pox y
	 * @param insets reposición del la celda
	 */
	public static void organizeGridLayout(GridBagConstraints gbc, int gridx, int gridy, Insets insets) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.insets = insets;
	}

	/**
	 * Genera un nombre de usuario
	 * @param name nombre
	 * @param lastName apellido
	 * @return cadena con nombre
	 */
	public static String generateUserName(String name, String lastName) {
		SQLUsers sqlUsers = new SQLUsers();

		String nameUser = name.toLowerCase() + "." + lastName.toLowerCase();
		String aux = nameUser;
		int i = 1;
		while (sqlUsers.existUser(nameUser) != 0) {
			nameUser = aux + i;
			i++;
		}

		return nameUser;
	}

	/**
	 * Retorna un jRadioButton seleccionado de un objeto ButtonGroup pasado por
	 * parametro
	 * 
	 * @param group Objeto ButtonGroup
	 * @return jRadioButton seleccionado
	 */
	public static JRadioButton getSelection(ButtonGroup group) {
		for (Enumeration e = group.getElements(); e.hasMoreElements();) {
			JRadioButton b = (JRadioButton) e.nextElement();
			if (b.getModel() == group.getSelection()) {
				return b;
			}
		}

		return null;
	}
	
	public static String changeFormatDate(String date) {
		String[] dateInput = date.split("/");
		return dateInput[2] +"-" +dateInput[1] +"-" +dateInput[0];
	}
	
}
