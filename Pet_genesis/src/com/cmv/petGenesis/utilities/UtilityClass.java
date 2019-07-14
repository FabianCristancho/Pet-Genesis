package com.cmv.petGenesis.utilities;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;


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
	
	public static void addBorder(JComponent component, int top, int left, int bottom, int right) {
		component.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
}
