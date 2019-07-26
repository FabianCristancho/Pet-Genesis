package unitTests;

import com.cmv.petGenesis.connection.SQLUsers;

public class TestCreateNameUser {

	public static void main(String[] args) {
		SQLUsers sqlUsers = new SQLUsers();
		
		String name = "A";
		String lastName = "a";
		String nameUser = name.toLowerCase() +"." +lastName.toLowerCase();
		String aux = nameUser;
		int i = 1;
		
		while(sqlUsers.existUser(nameUser)!=0) {
			nameUser = aux + i;
			i++;
		}
		
		System.out.println(nameUser);
	}

}
