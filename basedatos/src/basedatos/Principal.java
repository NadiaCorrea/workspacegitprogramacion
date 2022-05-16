package basedatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain",
					"dummy", "dummy");
			DatabaseMetaData infoBD = conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// hacer lo de la pag 13 acceso a BD

	}

}
