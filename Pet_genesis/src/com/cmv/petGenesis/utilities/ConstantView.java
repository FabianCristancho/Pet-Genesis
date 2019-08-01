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
	
	//Connection
	public final static String NAME_DATA_BASE = "historias_clinicas_cmv";
	public final static String USER_DATA_BASE = "root";
	public final static String PSWD_DATA_BASE = "123";
	
	//Window User
	public final static String TITLE_LOGIN = "PET GENESIS";
	public final static String LABEL_USER_LOGIN = "Usuario";
	public final static String LABEL_PSW_LOGIN = "Contraseña";
	public final static String BUTTON_EXIT_LOGIN = "SALIR";
	public final static String BUTTON_SIGNIN_LOGIN = "INICIAR SESIÓN";
	public final static String PATH_CMV_LOGIN = "./res/images/cmv.jpg";
	public final static String PATH_USER_LOGIN = "./res/images/user.png";
	public final static String PATH_HEALTH_LOGIN = "./res/images/logoMedicinaVeterinaria.png";
	public final static String PATH_HELP_LOGIN = "./res/images/iconHelp.png";
	public final static String PATH_ABOUT_LOGIN = "./res/images/iconAbout.png";
	public final static Font FONT_TITLE_LOGIN = new Font("Elephant", Font.BOLD, 30);
	public final static Font FONT_LABELS_LOGIN = new Font("Open Sans", Font.BOLD, 15);
	public final static Color COLOR_BUTTON_LOGIN = new Color(14, 109, 204);
	
	public final static String TITLE_SIGNIN = "REGISTRO";
	public final static String TITLE_CREATE_CLIENT = "REGISTRO DE CLIENTE";
	public final static Font FONT_TITLE_CRUD = new Font("Open Sans", Font.BOLD, 35);
	public final static String P_DATA_SIGNIN = "DATOS PERSONALES";
	public final static String U_DATA_SIGNIN = "DATOS DE USUARIO";
	public final static String LABEL_ID_USER_SIGNIN = "ID";
	public final static String LABEL_PERSONAL_DOC_SIGNIN = "Documento de identidad *";
	public final static String LABEL_NAME_SIGNIN = "Nombre *";
	public final static String LABEL_LAST_NAME_SIGNIN = "Apellido *";
	public static final String LABEL_BIRTHDATE_SIGNIN = "Fecha de Nacimiento";
	public final static String LABEL_PHONE_SIGNIN = "Teléfono*";
	public final static String LABEL_EMAIL_SIGNIN = "Email";
	public final static String LABEL_ADDRESS_SIGNIN = "Dirección de residencia";
	public final static String LABEL_ACTIVE_SIGNIN = "Estado *";
	public final static String LABEL_USER_TYPE_SIGNIN = "Tipo de usuario *";
	public final static String LABEL_USER_NAME_SIGNIN = "Nombre de usuario *";
	public final static String LABEL_PASSWORD_SIGNIN = "Contraseña *";
	public final static String LABEL_CONFIRM_PASSWORD_SIGNIN = "Confirmar contraseña *";
	public final static String LABEL_IS_ACTIVE_SIGNIN = "Activo";
	public final static String LABEL_IS_INACTIVE_SIGNIN = "Inactivo";
	public final static String[] VALUES_COMBO = {"Gerente General", "Médico Veterinario", "Asistente", "Auxiliar Veterinario"};
	public final static JComboBox<String> COMBO_USER_TYPE_SIGNIN = new JComboBox<>(VALUES_COMBO);
	public final static String BUTTON_OK_SIGNIN = "REGISTRAR USUARIO";
	public final static String BUTTON_CLEAR_SIGNIN = "LIMPIAR TODOS LOS CAMPOS";
	public final static String BUTTON_RETURN_SIGNIN = "REGRESAR";
	public final static Border BORD_FORM_LABEL = BorderFactory.createEmptyBorder(0, 10, 0, 10);
	public final static Font FONT_FORM = new Font("Open Sans", Font.BOLD, 17);
	public final static Font FONT_FIELD_FORM = new Font("Open Sans", Font.PLAIN, 14);
	
	//Client
	public final static String LABEL_ID2_SIGNIN = "ID";
	public final static String LABEL_DOC_SIGNIN = "Documento de identidad *";
	public final static String LABEL_PET_SIGNIN = "Añadir mascota";
	public final static String LABEL_OBLIGATE = "(*) CAMPOS OBLIGATORIOS";
	public final static String BUTTON_CREATE_CLIENT = "CREAR CLIENTE";
	public final static String BUTTON_FIND_CLIENT = "CONSULTAR CLIENTE";
	public final static String BUTTON_UPDATE_CLIENT = "MODIFICAR CLIENTE";
	public final static String BUTTON_INACTIV_CLIENT = "ACTIVAR/INACTIVAR CLIENTE";
	public final static String BUTTON_EXECUTE_ACTION_CLIENT = "EJECUTAR ACCIÓN";
	public final static String BUTTON_CLEAN_SIGNIN = "LIMPIAR";
	public final static String LABEL_CLICK_TO_ACTIV_CLIENT = "Haga click en un cliente para activarlo";
	public final static String LABEL_CLIENT_QUERY = "CONSULTA DE CLIENTES";
	public final static String LABEL_TITLE_INACTIV_CLIENT = "ESTADO DE ACTIVACIÓN DE CLIENTES";
	public final static String LABEL_CLIENT_WITH = "Cliente por: ";
	public final static String LABEL_INACTIV_CLIENT = "CLIENTES INACTIVOS";
	public final static String LABEL_ACTIV_CLIENT = "CLIENTES ACTIVOS";
	public final static String TOGGLE_SHOW_ACTIV_CLIENT = "MOSTRAR CLIENTES ACTIVOS";
	public final static String TOGGLE_SHOW_INACTIV_CLIENT = "MOSTRAR CLIENTES INACTIVOS";
	public final static String RADIO_ACTIV_CLIENT = "Activar cliente";
	public final static String RADIO_INACTIV_CLIENT = "Inactivar cliente";
	public final static String[] VALUES_PARAMETERS_CLIENT = {"Id", "Documento de Identidad", "Nombre", "Apellido", "Tipo de usuario"};
	public final static JComboBox<String> COMBO_PARAMETERS_CLIENT = new JComboBox<>(VALUES_PARAMETERS_CLIENT);
	public final static String[] PARAMS_INACTIV_CLIENT = {"Id", "Documento de Identidad", "Cliente"};
	public final static String[] PARAMS_UPDATE_CLIENT = {"Id", "Documento de Identidad", "Cliente"};
	public final static JComboBox<String> COMBO_PARAMS_UPDATE_CLIENT = new JComboBox<>(PARAMS_UPDATE_CLIENT);
	public final static String LABEL_TITLE_UPDATE_CLIENT = "MODIFICACIÓN DE CLIENTE";
	public final static String LABEL_DESCRIPTION_UPDATE_CLIENT = "Seleccione parámetro de búsqueda";
	public final static String BTN_SEARCH_UPDATE_CLIENT = "VER INFORMACIÓN DE CLIENTE";
	public final static String BTN_RETURN_UPDATE_CLIENT = "REGRESAR";
	public final static String BTN_DATA_UPDATE_CLIENT = "ACTUALIZAR DATOS";
	public final static String IMG_ADD_SIGNIN = "data/images/icon_plus.png";
	public final static String IMG_CHECK_SIGNIN = "data/images/icon_check.png";
	public final static String IMG_EDIT_SIGNIN = "data/images/icon_edit.png";
	public final static String IMG_GESTION_SIGNIN = "data/images/icon_search.png";
	public final static String IMG_PET_SIGNIN = "data/images/icon_pet.png";
	
	//User Management
	public final static String LABEL_USER_QUERY = "CONSULTA DE USUARIOS";
	public final static String LABEL_TITLE_INACTIV_USER = "ESTADO DE ACTIVACIÓN DE USUARIOS";
	public final static String LABEL_QUERY_WITH = "Buscar usuario por: ";
	public final static String LABEL_USER_WITH = "Usuario por: ";
	public final static String LABEL_INACTIV_WITH = "Inactivar usuario por: ";
	public final static String LABEL_INACTIV_USER = "USUARIOS INACTIVOS";
	public final static String LABEL_ACTIV_USER = "USUARIOS ACTIVOS";
	public final static String LABEL_CLICK_TO_ACTIV = "Haga click en un usuario para activarlo";
	public final static String LABEL_CLICK_TO_INACTIV = "Haga click en un usuario para inactivarlo";
	public final static String BUTTON_CREATE_USER = "CREAR USUARIO";
	public final static String BUTTON_EXECUTE_ACTION = "EJECUTAR ACCIÓN";
	public final static String BUTTON_UPDATE_USER = "MODIFICAR USUARIO";
	public final static String BUTTON_INACTIV_USER = "ACTIVAR/INACTIVAR USUARIO";
	public final static String TOGGLE_SHOW_ACTIV_USER = "MOSTRAR USUARIOS ACTIVOS";
	public final static String TOGGLE_SHOW_INACTIV_USER = "MOSTRAR USUARIOS INACTIVOS";
	public final static String RADIO_ACTIV_USER = "Activar usuario";
	public final static String RADIO_INACTIV_USER = "Inactivar usuario";
	public final static String BUTTON_FIND_USER = "CONSULTAR USUARIO";
	public final static String LABEL_TITLE_UPDATE_USER = "MODIFICACIÓN DE USUARIO";
	public final static String LABEL_DESCRIPTION_UPDATE_USER = "Seleccione parámetro de búsqueda";
	public final static String BTN_SEARCH_UPDATE_USER = "VER INFORMACIÓN DE USUARIO";
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
	public final static String BUTTON_REGISTER_HISTORY = "REGISTRAR HISTORIA";
	
	public final static String TITLE_WD_CREATE_HISTORY = "CREAR HISTORIA CLÍNICA";
	public static final String TITLE_PANEL_PET = "DATOS DE PACIENTE";
	public static final String LBL_TITLE_ID_HISTORY = "ID";
	public static final String LBL_CREATION_DATE = "Fecha de Creación*";
	public static final String LBL_NAME_PET = "Nombre de Paciente*";
	public static final String LBL_SPECIES_PET = "Especie";
	public static final String LBL_RACE_PET = "Raza";
	public static final String LBL_GENDER_PET = "Género";
	public static final String LBL_GENDER_MALE = "Macho";
	public static final String LBL_GENDER_FEMALE = "Hembra";
	public static final String LBL_BDATE_PET = "Fecha de nacimiento";
	public static final String LBL_CASTRATED_PET = "Castrado";
	public static final String LBL_COLOR_PET = "Color*";
	public static final String LBL_WEIGHT_PET = "Peso (Kg)";
	public static final String LBL_BRANDS_PET = "Marcas o Señas";
	public static final String LBL_PROPIETARY_PET = "Propietario*";
	public static final String LBL_STATE_HISTORY = "Estado de Historia";
	public static final String BTN_FIND_PROPIETARY_PET = "Nuevo cliente";
	public final static String[] COMBO_SPECIES = {"CANINO", "FELINO"};
	public static final String TABBED_DATA_PET = "DATOS DE PACIENTE";
	public static final String TABBED_APPOINT_PET = "CITAS DE PACIENTE";
	public static final String TABBED_MEDICINE_PET = "MEDICAMENTOS";
	public static final String TABBED_COMMENTS_PET = "COMENTARIOS";
	public static final String[] COMBO_SEARCH_CLIENT = {"Código de cliente generado", "Documento de Identidad"};
	public static final String[] COMBO_STATE_HISTORY = {"Activa", "Inactiva", "Archivada", "Bloqueada"};
	public static final String LBL_SEARCH_CLIENT_BY = "Buscar cliente por ";
	
	public static final String TITLE_COMMENTS = "COMENTARIOS ADICIONALES";
	public static final Font FONT_TITLE_COMMENTS = new Font("Open Sans", Font.ITALIC, 20);
	public static final String BTN_SAVE_COMMENTS = "GUARDAR COMENTARIOS";
	public static final String BTN_CLEAR_COMMENTS = "LIMPIAR AREA DE COMENTARIOS";
	public static final Font FONT_AREA_COMMENTS = new Font("Open Sans", Font.ROMAN_BASELINE, 15);
	
	public static final String TITLE_MEDICINE = "MEDICAMENTOS";
	public static final String PANEL_VACCINES_MEDICINE = "REGISTRAR RECETA";
	public static final String PANEL_ANTIPARASITARY_MEDICINE = "¿NO ENCUENTRA EL MEDICAMENTO? REGISTRELO";
	public static final String NAME_VACCINE_MEDICINE = "SELECCIONE EL MEDICAMENTO";
	public static final String DATE_APP_VACCINE_MEDICINE = "FECHA DE APLICACIÓN";
	public static final String ADD_DOSIS = "DOSIS*";
	public static final String ADD_FRECUENCY = "FRECUENCIA*";
	public static final String LBL_NAME_MEDIC = "NOMBRE DE MEDICAMENTO";
	public static final String TYPE_MEDIC = "TIPO DE MEDICAMENTO";
	public static final String DATE_APP_ANTIPARASITARY_MEDICINE= "FECHA DE APLICACIÓN";
	public static final String[] LIST_VACCINE_CAN = {"TRIPLE M-H-L", "PARVOVIROSIS", "CORONAVIROSIS", "KENEKCOUGH", "RABIA"};
	public static final String[] LIST_VACCINE_FELINE = {"LEUCEMIA FELINA", "RIN CAL PANL", "RABIA"};
	public static final String[] TYPES_ANTIPARASITARY = {"INTERNO", "EXTERNO"};
	public static final String BTN_SAVE_VACCINE = "GUARDAR REGISTRO DE VACUNA";
	public static final String BTN_SAVE_MEDIC = "REGISTRAR MEDICAMENTO";
	public static final Font FONT_LABELS_FORM_MEDICINE = new Font("Open Sans", Font.BOLD, 13);
	public static final String LABEL_TITLE_UPDATE_HISTORY = "MODIFICACIÓN DE HISTORIA CLÍNICA";
	public static final String BTN_SEARCH_UPDATE_HISTORY = "Buscar historia clínica";
	
	public final static String LABEL_PET_QUERY = "CONSULTA DE MASCOTAS";
	public final static String LABEL_SEARCH_PET_QUERY = "Ingrese id de mascota a consultar";
	public final static String BTN_LOAD_ALL_DATA = "CARGAR TODOS LOS DATOS";
	public final static String BTN_SEARCH_PET = "BUSCAR MASCOTA";
	
	public final static String LABEL_SEARCH_PET_HISTORY = "Ingrese el id de la mascota";
	public final static String LABEL_PET_WITH = "Id de la mascota: ";
	public final static String BTN_CHANGE_STATE_PET = "Mostrar";
	public final static String LABEL_TITLE_INACTIV_PETS = "ESTADO DE ACTIVACIÓN DE MASCOTAS";
	public final static String LABEL_INACTIV_PET = "MASCOTAS INACTIVAS";
	public final static String LABEL_ACTIV_PET = "MASCOTAS ACTIVAS";
	public final static String LABEL_BLOCK_PET = "MASCOTAS BLOQUEADAS";
	public final static String LABEL_STORE_PET = "MASCOTAS ARCHIVADAS";
	public final static String LABEL_CLICK_TO_ACTIV_PET = "Haga click en una mascota para activarlo";
	
	//APPOINTMENT MANAGEMENT
	public static final String LABEL_ID_AP = "ID CONSULTA";
	public static final String LABEL_DATE_AP = "FECHA CONSULTA";
	public static final String LABEL_MOT_AP = "Motivo de la consulta";
	
	//EXAM
	public static final String LBL_TITLE_EXAM = "EXAMEN DE RUTINA";
	public static final Font FONT_TITLE_EXAM = new Font("Open Sans", Font.BOLD, 20);
	public static final String LBL_EXAM_WEIGHT = "PESO (Kg)";
	public static final String LBL_EXAM_APPETITE = "APETITO";
	public static final String LBL_EXAM_STOOL = "HECES";
	public static final String LBL_EXAM_WATER = "CONSUMO DE AGUA";
	public static final String LBL_EXAM_DIET = "DIETA";
	public static final String LBL_EXAM_NAILS = "UÑAS";
	public static final String LBL_EXAM_ATT = "ACTITUD";
	public static final String LBL_EXAM_TEMP = "TEMPERAMENTO";
	public static final String LBL_EXAM_TMP = "TEMPERATURA (°C)";
	public static final String LBL_EXAM_PRESSION = "PRESION (1/min)";
	public static final String LBL_EXAM_CARD = "FRECUENCIA CARDICA (1/min)";
	public static final String LBL_EXAM_RESP = "FRECUENCIA RESPIRATORIA (1/min)";
	public static final String LBL_EXAM_CAVID = "CAVIDAD ORAL";
	public static final String LBL_EXAM_FACE = "CARA";
	public static final String LBL_EXAM_TRUNK = "TRONCO";
	public static final String LBL_EXAM_GEN = "GENITALES";
	public static final String LBL_EXAM_EXT = "EXTREMIDADES";
	public static final String LBL_EXAM_SNC = "SISTEMA NERVIOSO CENTRAL";
	public static final String LBL_EXAM_DIAGNOSTIC = "DIAGNÓSTICO DE CONSULTA";
	public static final String JRB_EXAM_APGOOD = "Bueno";
	public static final String JRB_EXAM_APREG = "Regular";
	public static final String JRB_EXAM_NULL = "Nulo";
	public static final String JRB_EXAM_SNORM = "Normales";
	public static final String JRB_EXAM_SDIARR = "Diarrea";
	public static final String JRB_EXAM_SCONS = "Constipacion";
	public static final String JRB_EXAM_WNORM = "Normal";
	public static final String JRB_EXAM_POL = "Polidipsia";
	public static final String JRB_EXAM_POR = "Poliuria";
	public static final String JRB_EXAM_DMEAT = "Carne";
	public static final String JRB_EXAM_DCARB = "Carbohidratos";
	public static final String JRB_EXAM_DVEG = "Verduras";
	public static final String JRB_EXAM_DOTHER = "Otra dieta";
	public static final String CH_EXAM_VOMIT = "Tiene vomito";
	public static final String JRB_EXAM_NAIL_OK = "OK";
	public static final String JRB_EXAM_NAIL_CUT = "Cortar";
	public static final Font FONT_TEXT_AREA = new Font("Open Sans", Font.PLAIN, 15);
	public static final String BTN_CLEAR_FIELDS = "Limpiar todos los campos";

}