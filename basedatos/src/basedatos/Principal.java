package basedatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain",
					"programacion", "programacion");
			DatabaseMetaData infoBD = conexion.getMetaData();
			// System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			// System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			// System.out.println("Base de datos: " + infoBD.getDatabaseProductName());

			Statement instruccion = conexion.createStatement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// hacer lo de la pag 13 acceso a BD

	}

	public static void addUser(Connection conexion) {
		String nif, nombre, apellidos;
		int edad;

		System.out.println("Introduce nif: ");

	}

}
