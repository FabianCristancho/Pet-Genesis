package com.cmv.petGenesis.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

public class ConstantView {
	
	public final static String TITLE_LOGIN = "PET GENESIS";
	public final static String LABEL_USER_LOGIN = "Usuario";
	public final static String LABEL_PSW_LOGIN = "Contrase�a";
	public final static String BUTTON_EXIT_LOGIN = "SALIR";
	public final static String BUTTON_SIGNIN_LOGIN = "INICIAR SESI�N";
	public final static String PATH_CMV_LOGIN = "./res/images/cmv.jpg";
	public final static String PATH_USER_LOGIN = "./res/images/user.png";
	public final static String PATH_HEALTH_LOGIN = "./res/images/logoMedicinaVeterinaria.png";
	public final static String PATH_HELP_LOGIN = "./res/images/iconHelp.png";
	public final static String PATH_ABOUT_LOGIN = "./res/images/iconAbout.png";
	public final static Font FONT_TITLE_LOGIN = new Font("Elephant", Font.BOLD, 30);
	public final static Font FONT_LABELS_LOGIN = new Font("Open Sans", Font.BOLD, 15);
	public final static Color COLOR_BUTTON_LOGIN = new Color(14, 109, 204);
	
	public final static String TITLE_SIGNIN = "REGISTRO";
	public final static Font FONT_TITLE_CRUD = new Font("Open Sans", Font.BOLD, 35);
	public final static String P_DATA_SIGNIN = "DATOS PERSONALES";
	public final static String U_DATA_SIGNIN = "DATOS DE USUARIO";
	public final static String LABEL_ID_SIGNIN = "Documento de identidad *";
	public final static String LABEL_NAME_SIGNIN = "Nombre *";
	public final static String LABEL_LAST_NAME_SIGNIN = "Apellido *";
	public static final String LABEL_BIRTHDATE_SIGNIN = "Fecha de Nacimiento";
	public final static String LABEL_PHONE_SIGNIN = "Tel�fono";
	public final static String LABEL_EMAIL_SIGNIN = "Email";
	public final static String LABEL_ADDRESS_SIGNIN = "Direcci�n de residencia";
	public final static String LABEL_ACTIVE_SIGNIN = "Estado *";
	public final static String LABEL_USER_TYPE_SIGNIN = "Tipo de usuario *";
	public final static String LABEL_USER_NAME_SIGNIN = "Nombre de usuario *";
	public final static String LABEL_PASSWORD_SIGNIN = "Contrase�a *";
	public final static String LABEL_CONFIRM_PASSWORD_SIGNIN = "Confirmar contrase�a *";
	public final static String LABEL_IS_ACTIVE_SIGNIN = "Activo";
	public final static String LABEL_IS_INACTIVE_SIGNIN = "Inactivo";
	public final static String[] VALUES_COMBO = {"Gerente General", "M�dico Veterinario", "Asistente", "Auxiliar Veterinario"};
	public final static JComboBox<String> COMBO_USER_TYPE_SIGNIN = new JComboBox<>(VALUES_COMBO);
	public final static String BUTTON_OK_SIGNIN = "REGISTRAR USUARIO";
	public final static String BUTTON_RETURN_SIGNIN = "REGRESAR";
	public final static Border BORD_FORM_LABEL = BorderFactory.createEmptyBorder(0, 10, 0, 10);
	public final static Font FONT_FORM = new Font("Open Sans", Font.BOLD, 17);
	public final static Font FONT_FIELD_FORM = new Font("Open Sans", Font.PLAIN, 14);
	
	
	//User Management
	public final static String LABEL_USER_QUERY = "CONSULTA DE USUARIOS";
	public final static String LABEL_TITLE_INACTIV_USER = "ESTADO DE ACTIVACI�N DE USUARIOS";
	public final static String LABEL_QUERY_WITH = "Buscar usuario por: ";
	public final static String LABEL_USER_WITH = "Usuario por: ";
	public final static String LABEL_INACTIV_WITH = "Inactivar usuario por: ";
	public final static String LABEL_INACTIV_USER = "USUARIOS INACTIVOS";
	public final static String LABEL_ACTIV_USER = "USUARIOS ACTIVOS";
	public final static String LABEL_CLICK_TO_ACTIV = "Haga click en un usuario para activarlo";
	public final static String LABEL_CLICK_TO_INACTIV = "Haga click en un usuario para inactivarlo";
	public final static String BUTTON_CREATE_USER = "CREAR USUARIO";
	public final static String BUTTON_EXECUTE_ACTION = "EJECUTAR ACCI�N";
	public final static String BUTTON_UPDATE_USER = "MODIFICAR USUARIO";
	public final static String BUTTON_INACTIV_USER = "ACTIVAR/INACTIVAR USUARIO";
	public final static String TOGGLE_SHOW_ACTIV_USER = "MOSTRAR USUARIOS ACTIVOS";
	public final static String TOGGLE_SHOW_INACTIV_USER = "MOSTRAR USUARIOS INACTIVOS";
	public final static String RADIO_ACTIV_USER = "Activar usuario";
	public final static String RADIO_INACTIV_USER = "Inactivar usuario";
	public final static String BUTTON_FIND_USER = "CONSULTAR USUARIO";
	public final static String LABEL_TITLE_UPDATE_USER = "MODIFICACI�N DE USUARIO";
	public final static String LABEL_DESCRIPTION_UPDATE_USER = "Seleccione par�metro de b�squeda";
	public final static String BTN_SEARCH_UPDATE_USER = "VER INFORMACI�N DE USUARIO";
	public final static String BTN_RETURN_UPDATE_USER = "REGRESAR";
	public final static String BTN_DATA_UPDATE_USER = "ACTUALIZAR DATOS";
	
	public final static String[] VALUES_PARAMETERS_USER = {"Id", "Documento de Identidad", "Nombre", "Apellido", "Tipo de usuario"};
	public final static JComboBox<String> COMBO_PARAMETERS = new JComboBox<>(VALUES_PARAMETERS_USER);
	public final static String[] PARAMS_INACTIV_USER = {"Id", "Documento de Identidad", "Usuario"};
	public final static String[] PARAMS_UPDATE_USER = {"Id", "Documento de Identidad", "Usuario"};
	public final static JComboBox<String> COMBO_PARAMS_UPDATE_USER = new JComboBox<>(PARAMS_UPDATE_USER);
	
	
	//HISTORY MANAGEMENT
	public final static String CARD_CREATE_HISTORY = "Crear Historia";
	public final static String CARD_UPDATE_HISTORY = "Actualizar historia";
	public final static String CARD_STATE_HISTORY = "Cambiar estado historia";
	public final static String CARD_FIND_HISTORY = "Consultar historia";
	public static final String BUTTON_CREATE_HISTORY = "CREAR HISTORIA CLINICA";
	public static final String BUTTON_UPDATE_HISTORY = "MODIFICAR HISTORIA CLINICA";
	public static final String BUTTON_STATE_HISTORY = "ESTADO HISTORIA CLINICA";
	public static final String BUTTON_FIND_HISTORY = "CONSULTAR HISTORIA CLINICA";
	
	private JLabel lblCreationDate, lblPetName, lblSpecies, lblRace, lblGender, lblBirthDate, lblCastrated, lblColor, lblWeight, lblBrands, lblPropietary;
	private JDateChooser creationDate, birthDate;
	private JTextField jtfPetName, jtfRace, jtfColor, jtfWeight, jtfBrands, jtfPropietary;
	private JComboBox<String> comboSpecies;
	private JCheckBox isCastrated;
	
	public final static String TITLE_WD_CREATE_HISTORY = "CREAR HISTORIA CL�NICA";
	public static final String TITLE_PANEL_PET = "DATOS DE PACIENTE";
	public static final String LBL_TITLE_ID_HISTORY = "ID";
	public static final String LBL_CREATION_DATE = "Fecha de Creaci�n*";
	public static final String LBL_NAME_PET = "Nombre de Paciente*";
	public static final String LBL_SPECIES_PET = "Especie";
	public static final String LBL_RACE_PET = "Raza";
	public static final String LBL_GENDER_PET = "G�nero";
	public static final String LBL_GENDER_MALE = "Macho";
	public static final String LBL_GENDER_FEMALE = "Hembra";
	public static final String LBL_BDATE_PET = "Fecha de nacimiento";
	public static final String LBL_CASTRATED_PET = "Castrado";
	public static final String LBL_COLOR_PET = "Color";
	public static final String LBL_WEIGHT_PET = "Peso al ingresar";
	public static final String LBL_BRANDS_PET = "Marcas o Se�as";
	public static final String LBL_PROPIETARY_PET = "Propietario";
	public static final String BTN_FIND_PROPIETARY_PET = "Buscar propietario";
	public final static String[] COMBO_SPECIES = {"CANINO", "FELINO"};
	public static final String TABBED_DATA_PET = "DATOS DE PACIENTE";
	public static final String TABBED_APPOINT_PET = "CITAS DE PACIENTE";
	public static final String TABBED_MEDICINE_PET = "MEDICAMENTOS";
	public static final String TABBED_COMMENTS_PET = "COMENTARIOS";
	
	public static final String TITLE_COMMENTS = "COMENTARIOS GENERALES";
	public static final Font FONT_TITLE_COMMENTS = new Font("Open Sans", Font.ITALIC, 25);
	public static final String BTN_SAVE_COMMENTS = "GUARDAR COMENTARIOS";
	public static final String BTN_CLEAR_COMMENTS = "LIMPIAR AREA DE COMENTARIOS";
	public static final Font FONT_AREA_COMMENTS = new Font("Open Sans", Font.ROMAN_BASELINE, 15);
	
	public static final String TITLE_MEDICINE = "MEDICAMENTOS";
	public static final String PANEL_VACCINES_MEDICINE = "REGISTRO DE VACUNA";
	public static final String PANEL_ANTIPARASITARY_MEDICINE = "REGISTRO DE ANTIPARASITARIO";
	public static final String NAME_VACCINE_MEDICINE = "NOMBRE DE VACUNA";
	public static final String DATE_APP_VACCINE_MEDICINE = "FECHA DE APLICACI�N";
	public static final String ADD_COMMENTS_MEDICINE = "COMENTARIOS ADICIONALES";
	public static final String TYPE_ANTIPARASITARY_MEDICINE = "TIPO DE ANTIPARASITARIO";
	public static final String NAME_ANTIPARASITARY_MEDICINE = "NOMBRE ANTIPARASITARIO";
	public static final String DATE_APP_ANTIPARASITARY_MEDICINE= "FECHA DE APLICACI�N";
	public static final String[] LIST_VACCINE_CAN = {"TRIPLE M-H-L", "PARVOVIROSIS", "CORONAVIROSIS", "KENEKCOUGH", "RABIA"};
	public static final String[] LIST_VACCINE_FELINE = {"LEUCEMIA FELINA", "RIN CAL PANL", "RABIA"};
	public static final String[] TYPES_ANTIPARASITARY = {"INTERNO", "EXTERNO"};
	public static final String BTN_SAVE_VACCINE = "GUARDAR REGISTRO DE VACUNA";
	public static final String BTN_SAVE_ANTIPARASITARY = "GUARDAR REGISTRO DE ANTIPARASITARIO";
	public static final Font FONT_LABELS_FORM_MEDICINE = new Font("Open Sans", Font.BOLD, 13);
}