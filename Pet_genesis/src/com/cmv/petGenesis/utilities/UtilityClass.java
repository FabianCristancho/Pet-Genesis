package com.cmv.petGenesis.utilities;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;


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
	
	public static boolean fieldsAreEmpty(JTextField[] fields) {
		for (int i = 0; i < fields.length; i++) 
			if(fields[i].getText().length()==0)
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
	
	public static void addBorder(JComponent component, int top, int left, int bottom, int right) {
		component.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
	
	public static String changeFormatToDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
	
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
	
	public static String formatDate(String oldDate) {
		String[] newDate = oldDate.split("-");
		int day = ((int)newDate[2].charAt(1))+1;
		return newDate[2].charAt(0) +"" +(char)day +"/" +newDate[1] +"/" +newDate[0];
	}
	
	public static Date daysAdd(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
	
	public static void changeWidthColumn(JTable jTable, int position, int newWidth) {
		jTable.getColumnModel().getColumn(position).setPreferredWidth(newWidth);
	}
	
	public static void organizeGridLayout(GridBagConstraints gbc, int gridx, int gridy) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
	}
	
	public static void organizeGridLayout(GridBagConstraints gbc, int gridx, int gridy, Insets insets) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.insets = insets;
	}
}
