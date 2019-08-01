package com.cmv.petGenesis.runner;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.connection.DataBaseCreation;
import com.cmv.petGenesis.view.mainWindow.JDialogLogin;

/**
 * Clase Run - Se encarga de inicar la aplicación
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Run {

	/**
	 * El Main
	 * 
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		DataBaseCreation dataBaseCreation = new DataBaseCreation();
		if (!dataBaseCreation.existDataBase()) {
			JOptionPane.showMessageDialog(null, "CREANDO BASE DE DATOS\nPUEDE TARDAR ALGUNOS MINUTOS");
			dataBaseCreation.createDataBase();
			JOptionPane.showMessageDialog(null, "BASE DE DATOS CREADA CON EXITO");
		} else
			JDialogLogin.getInstance().setVisible(true);
	}
}