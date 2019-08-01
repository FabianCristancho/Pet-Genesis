package testLogin;

import java.util.Scanner;

public class TestInitSession {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("INICIO DE SESION");

		String username;
		String password;

		System.out.print("Ingrese usuario: ");
		username = sc.nextLine();
		System.out.print("Ingrese contraseña: ");
		password = sc.nextLine();

		if(LoginManage.getInstance().existUser(username, password))
			System.out.println("USUARIO SI EXISTE EN EL SISTEMA");
		else
			System.out.println("Datos incorrectos");
	}
}