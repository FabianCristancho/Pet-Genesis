package com.cmv.petGenesis.utilities;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.Border;

public class ConstantView {
	
	public final static String TITLE_LOGIN = "PET GENESIS";
	public final static String LABEL_USER_LOGIN = "Usuario";
	public final static String LABEL_PSW_LOGIN = "Contraseña";
	public final static String BUTTON_RETURN_LOGIN = "REGRESAR";
	public final static String BUTTON_SIGNIN_LOGIN = "INICIAR SESIÓN";
	public final static String PATH_CMV_LOGIN = "./res/images/cmv.jpg";
	public final static String PATH_USER_LOGIN = "./res/images/user.png";
	public final static String PATH_HEALTH_LOGIN = "./res/images/logoMedicinaVeterinaria.png";
	public final static String PATH_HELP_LOGIN = "./res/images/iconHelp.png";
	public final static String PATH_ABOUT_LOGIN = "./res/images/iconAbout.png";
	public final static Font FONT_TITLE_LOGIN = new Font("Elephant", Font.BOLD, 30);
	public final static Font FONT_LABELS_LOGIN = new Font("Open Sans", Font.BOLD, 15);
	
	public final static String TITLE_SIGNIN = "REGISTRO";
	public final static Font FONT_TITLE_SIGNIN = new Font("Open Sans", Font.BOLD, 35);
	public final static String P_DATA_SIGNIN = "DATOS PERSONALES";
	public final static String U_DATA_SIGNIN = "DATOS DE USUARIO";
	public final static String LABEL_ID_SIGNIN = "Id";
	public final static String LABEL_NAME_SIGNIN = "Nombre";
	public final static String LABEL_LAST_NAME_SIGNIN = "Apellido";
	public static final String LABEL_BIRTHDATE_SIGNIN = "Fecha de Nacimiento";
	public final static String LABEL_PHONE_SIGNIN = "Teléfono";
	public final static String LABEL_EMAIL_SIGNIN = "Email";
	public final static String LABEL_ADDRESS_SIGNIN = "Dirección de residencia";
	public final static String LABEL_ACTIVE_SIGNIN = "Estado";
	public final static String LABEL_USER_TYPE_SIGNIN = "Tipo de usuario";
	public final static String LABEL_USER_NAME_SIGNIN = "Nombre de usuario";
	public final static String LABEL_PASSWORD_SIGNIN = "Contraseña";
	public final static String LABEL_CONFIRM_PASSWORD_SIGNIN = "Confirmar contraseña";
	public final static String LABEL_IS_ACTIVE_SIGNIN = "Activo";
	public final static String LABEL_IS_INACTIVE_SIGNIN = "Inactivo";
	public final static String[] VALUES_COMBO = {"Médico Veterinario", "Auxiliar Veterinario", "Asistente"};
	public final static JComboBox<String> COMBO_USER_TYPE_SIGNIN = new JComboBox<>(VALUES_COMBO);
	public final static String BUTTON_OK_SIGNIN = "REGISTRAR USUARIO";
	public final static String BUTTON_RETURN_SIGNIN = "REGRESAR";
	public final static Border BORD_FORM_LABEL = BorderFactory.createEmptyBorder(0, 10, 0, 10);
	public final static Font FONT_FORM = new Font("Open Sans", Font.BOLD, 15);
	public final static Font FONT_FIELD_FORM = new Font("Open Sans", Font.PLAIN, 14);
	
}