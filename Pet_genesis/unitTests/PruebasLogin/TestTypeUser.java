package PruebasLogin;

import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.model.Usuario;

public class TestTypeUser {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setTypeUser(TypeUser.getTypeUser(2));
		System.out.println(usuario.getTypeUser().getNameTypeUser());
	}

}
