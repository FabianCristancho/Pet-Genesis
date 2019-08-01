package testDatabase;

import javax.swing.JOptionPane;

public class TestExistBD {

	public static void main(String[] args) {
		SQLDataBase sqlDataBase = new SQLDataBase();
		String nameDataBase = JOptionPane.showInputDialog("INGRESE NOMBRE DE BASE DE DATOS");
		
		if(sqlDataBase.existDataBase(nameDataBase)) {
			JOptionPane.showMessageDialog(null, "LA BASE DE DATOS EXISTE");
		}else
			JOptionPane.showMessageDialog(null, "LA BASE DE DATOS NO EXISTE");
	}
}