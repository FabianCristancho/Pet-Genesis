package unitTests;

import javax.swing.JOptionPane;

import com.cmv.petGenesis.connection.DataBaseCreation;

public class TestCreateDataBase {

	public static void main(String[] args) {
		DataBaseCreation dataBaseCreation = new DataBaseCreation();
		if(!dataBaseCreation.existDataBase()) {
			dataBaseCreation.createDataBase();
		JOptionPane.showMessageDialog(null, "BASE DE DATOS CREADA CON EXITO");
		}else
			JOptionPane.showMessageDialog(null, "LA BASE DE DATOS YA EXISTE. PUEDE CONTINUAR");
	}
}
