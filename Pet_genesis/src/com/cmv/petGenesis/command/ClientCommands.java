package com.cmv.petGenesis.command;

/**
 * Enum ClientCommands - Enumerado que se encarga de listar todos los comandos
 * que se vana a utilizar para las acciones de los botones de interfaz del cliente.
 *
 * @version 1.0 - 22/07/2019
 * @author Yohan Caro -Fabian Cristancho
 */
public enum ClientCommands {
	OK_SIGN_IN, CMD_CREATE_CLIENT, CMD_UPDATE_CLIENT, CMD_INACTIV_CLIENT, CMD_FIND_CLIENT, CMD_SEARCH_CLIENT, CMD_LOAD_DATA,
	CMD_WD_UPDATE_CHANGE_DATA, CMD_WD_UPDATE_RETURN, CMD_WD_UPDATE_SEARCH, CMD_WD_INACTIV_CHANGE_TABLE,
	CMD_WD_INACTIV_EXECUTE, CMD_WD_UPDATE_CLEAR, CMD_WD_CREATE_CLEAR, CMD_BT_NEW_PET, CMD_T_ADD_PET
}