package com.cmv.petGenesis.runner;

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
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		JDialogLogin.getInstance().setVisible(true);
	}
}