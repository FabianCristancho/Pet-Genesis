package com.cmv.petGenesis.view;

import java.awt.Color;
import java.awt.Font;

/**
 * Clase ConstantsLogin
 * 
 * @author Yohan Caro
 * @version 1.1 15/03/2019
 *
 */

public class ConstantsLogin {
	
	//Buttons
	public static final String COMMAND_SWITCH = "SWITCH";
	public static final String BT_LOG_ACT = "BT_LOG_ACT";
	public static final String BT_SIGN_ACT = "BT_SIGN_ACT";
	public static final String BT_ACEPT_LOG = "BT_ACEPT_LOG";
	public static final String BT_ACEPT_SIGN = "BT_ACEPT_SIGN";
	public static final String LOGIN_USER = "Registrarse";
	public static final String SIGN_IN = "SIGN_IN";
	public static final String LOGIN = "LOGIN";

	//Fonts
	public static final Font FONT_LOG = new Font("Bahnschrift SemiBold", 1, 15);
	
	//SingIn
	public static final String IMG_TITLES_SING_IN = "./res/icons/ini.png";
	
	//Paths user in
	public static final String PATH_ICON_USER = "./res/icons/user.png";
	public static final String ICON_PASSWORD = "./res/icons/password.png";
	public static final String ICON_BIRTHDATE = "./res/icons/birthdate.png";
	public static final String ICON_EMAIL = "./res/icons/email.png";
	public static final String ICON_POKEBALL = "./res/icons/pokeball.png";
	public static final String ICON_NAME = "./res/icons/name.png";
	public static final String ICON_GENDER = "./res/icons/gender.png";
	public static final String PATH_FONT_IN = "./res/images/loginFont.jpg";
	
	//SignInJPanel
	public static final String BUTTON_ACCEPT = "Aceptar";
	
	
	//Names JPanelLogin
	public static final String LB_NICKNAME = "Nombre de usuario";
	public static final String LB_FIRST_NAME = "Nombre";
	public static final String LB_LAST_NAME = "Apellido";
	public static final String LB_PASSWORD = "Contraseña";
	public static final String LB_EMAIL = "Correo";
	public static final String LB_BIRTH_DATE = "Fecha de Nacimiento";
	public static final String LB_GENDER = "Genero";
	public static final String LB_MALE = "Hombre";
	public static final String LB_FEMALE = "Mujer";
	
	//EnterJDialog
	public static final String LOGIN_TEXT = "Iniciar sesion";
	public static final String SINGIN_TEXT = "Registrarse";
	public static final String TITLE_ENTER_DIALOG = "Ingreso Pokémon";
	
	
	//Colorsk
	public static final Color COLOR_LB_BACKGROUND = new Color(190, 249, 137);
	
	//UserDAO
	public static final String PATH_USERS_DATA = "./res/persistance/users_list.bin";
	public static final String METHOD_WRITE_READ = "rw";
	
}
