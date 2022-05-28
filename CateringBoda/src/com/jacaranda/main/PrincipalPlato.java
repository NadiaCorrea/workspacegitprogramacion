package com.jacaranda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jacaranda.plato.Plato;
import com.jacaranda.plato.PlatoException;

public class PrincipalPlato {

	public static Scanner teclado = new Scanner(System.in);
	public static Connection c;

	public static void main(String[] args) {

		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "cateringBoda",
					"cateringBoda");

			DatabaseMetaData infoBD = c.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());

			int codigo;
			String nombre;
			String descripcion;
			String[] gruposAlimenticios;
			int opc;
			int orden;
			double lactosa;
			int numGruposAlimenticios;
			int opcion;

			// opciones de menu para crear, modificar y eliminar plato
			do {
				menu();
				opc = leerEntero("¿Qué quieres hacer?");

				switch (opc) {
				case 1:
					mostrarTodosPlatos();
					break;
				case 2:
					nombre = leerCadena("Introduce el nombre del plato: ");
					descripcion = leerCadena("Introduce la descripción del plato: ");
					orden = leerEntero("Introduce el orden del plato: ");
					lactosa = leerReal("Introduce la cantidad de lactosa del plato: ");
					gruposAlimenticios = new String[3];
					numGruposAlimenticios = 0;
					opcion = -1;

					do {
						System.out.println("1. Carne\n2. Pescado\n3. Verdura\n4. Cereales\n5. No añadir más");
						opcion = leerEntero("Selecciona un grupo alimenticio: ");

						switch (opcion) {
						case 1:
							gruposAlimenticios[numGruposAlimenticios] = "CARNE";
							numGruposAlimenticios += 1;
							break;
						case 2:
							gruposAlimenticios[numGruposAlimenticios] = "PESCADO";
							numGruposAlimenticios += 1;
							break;
						case 3:
							gruposAlimenticios[numGruposAlimenticios] = "VERDURA";
							numGruposAlimenticios += 1;
							break;
						case 4:
							gruposAlimenticios[numGruposAlimenticios] = "CEREALES";
							numGruposAlimenticios += 1;
							break;
						case 5:
							break;
						default:
							System.out.println("Grupo alimenticio incorrecto.");
							break;
						}
					} while (opcion != 5 && numGruposAlimenticios < 3);

					guardarPlato(nombre, descripcion, orden, lactosa, gruposAlimenticios);

					System.out.println("Plato insertado correctamente.\n");

					break;
				case 3:
					mostrarTodosPlatos();
					codigo = leerEntero("Introduce el código del plato a modificar: ");

					nombre = leerCadena("Introduce el nombre del plato: ");
					descripcion = leerCadena("Introduce la descripción del plato: ");
					orden = leerEntero("Introduce el orden del plato: ");
					lactosa = leerReal("Introduce la cantidad de lactosa del plato: ");
					gruposAlimenticios = new String[3];
					numGruposAlimenticios = 0;
					opcion = -1;

					do {
						System.out.println("1. Carne\n2. Pescado\n3. Verdura\n4. Cereales\n5. No añadir más");
						opcion = leerEntero("Selecciona un grupo alimenticio: ");

						switch (opcion) {
						case 1:
							gruposAlimenticios[numGruposAlimenticios] = "CARNE";
							numGruposAlimenticios += 1;
							break;
						case 2:
							gruposAlimenticios[numGruposAlimenticios] = "PESCADO";
							numGruposAlimenticios += 1;
							break;
						case 3:
							gruposAlimenticios[numGruposAlimenticios] = "VERDURA";
							numGruposAlimenticios += 1;
							break;
						case 4:
							gruposAlimenticios[numGruposAlimenticios] = "CEREALES";
							numGruposAlimenticios += 1;
							break;
						case 5:
							break;
						default:
							System.out.println("Grupo alimenticio incorrecto.");
							break;
						}
					} while (opcion != 5 && numGruposAlimenticios < 3);

					actualizarPlato(codigo, nombre, descripcion, orden, lactosa, gruposAlimenticios);

					System.out.println("Plato actualizado correctamente.\n");

					break;
				case 4:
					mostrarTodosPlatos();
					codigo = leerEntero("Introduce el código del plato a eliminar: ");
					eliminarPlato(codigo);
					System.out.println("Plato eliminado correctamente.\n");
					break;
				case 5:
					System.out.println("¡Adiós!");
					break;
				default:
					System.out.println("Opción no válida.");
					break;
				}

			} while (opc != 5);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void menu() {
		System.out.println("1. Mostrar todos los platos\n" + "2. Añadir un plato\n" + "3. Modificar un plato\n"
				+ "4. Eliminar un plato\n" + "5. Salir");
	}

	public static int leerEntero(String texto) {
		int entero = -1;
		boolean leido = false;

		do {
			System.out.println(texto);
			entero = Integer.parseInt(teclado.nextLine());
			leido = true;
		} while (leido == false);

		return entero;
	}

	public static String leerCadena(String texto) {
		String cadena = "";
		boolean leido = false;

		do {
			System.out.println(texto);
			cadena = teclado.nextLine();
			leido = true;
		} while (leido == false);

		return cadena;
	}

	public static double leerReal(String texto) {
		double real = -1;
		boolean leido = false;

		do {
			System.out.println(texto);
			real = Double.parseDouble(teclado.nextLine());
			leido = true;
		} while (leido == false);

		return real;
	}

	public static void mostrarTodosPlatos() throws SQLException {
		Statement query = c.createStatement();
		String q = "SELECT p.CODIGOPLATO, p.NOMBRE, p.DESCRIPCION, p.ORDEN, p.CANTIDADLACTOSA FROM PLATO p";
		ResultSet result = query.executeQuery(q);
		StringBuilder sb = new StringBuilder();
		int codigo;
		String nombre;
		String descripcion;
		int orden;
		double lactosa;
		String grupoAlimenticio;
		while (result.next()) {
			codigo = result.getInt("CODIGOPLATO");
			nombre = result.getString("NOMBRE");
			descripcion = result.getString("DESCRIPCION");
			orden = result.getInt("ORDEN");
			lactosa = result.getDouble("CANTIDADLACTOSA");
			sb.append("CODIGO: " + codigo + ", NOMBRE: " + nombre + ", DESCRIPCION: " + descripcion + ", ORDEN: "
					+ orden + ", LACTOSA: " + lactosa + ", GRUPOS ALIMENTICIOS: ");
			Statement query1 = c.createStatement();
			String q1 = "SELECT ga.NOMBRE FROM PLATOGRUPO pg, GRUPOALIMENTICIO ga WHERE ga.CODIGOGRUPO = pg.CODIGOGRUPO AND pg.CODIGOPLATO = "
					+ codigo;
			ResultSet result1 = query1.executeQuery(q1);
			while (result1.next()) {
				grupoAlimenticio = result1.getString("NOMBRE");
				sb.append(grupoAlimenticio + " - ");
			}
			if (sb.toString().endsWith(" - ")) {
				sb.delete(sb.length() - 3, sb.length());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void guardarPlato(String nombre, String descripcion, int orden, double lactosa,
			String[] gruposAlimenticios) throws PlatoException, SQLException {
		Plato iplato = new Plato(nombre, descripcion, orden, lactosa, gruposAlimenticios);
		int cod;

		// Insertar el nuevo plato a la BBDD

		/*
		 * Tenía el cod de plato para que ser generara automaticamente asi que he
		 * cambiado eso y he creado una secuencia en bbdd para que genere el codido
		 */
		Statement query = c.createStatement();
		String q = "SELECT CODPLATO.nextval FROM DUAL"; // llama a la secuencia para que dé es siguiente
														// valor asignable
		ResultSet result = query.executeQuery(q);
		if (result.next()) {
			cod = result.getInt("NEXTVAL");
			iplato.setCodigo(cod); // se asigna el cod de la secuencia al plato creado
		}

		// Añade el plato a la tabla plato
		Statement instruccion = c.createStatement();
		String q2 = "INSERT INTO PLATO VALUES(" + iplato.getCodigo() + ",'" + iplato.getNombre() + "','"
				+ iplato.getDescripcion() + "'," + iplato.getOrden() + "," + iplato.getCantidadLactosa() + ")";
		instruccion.executeUpdate(q2);

		// Añade los valores a la tabla platogrupo

		for (int i = 0; i < gruposAlimenticios.length; i = i + 1) {
			int grupo;
			if (gruposAlimenticios[i] != null) {

				if (gruposAlimenticios[i].equalsIgnoreCase("CARNE")) {
					grupo = 1;
				} else if (gruposAlimenticios[i].equalsIgnoreCase("PESCADO")) {
					grupo = 2;
				} else if (gruposAlimenticios[i].equalsIgnoreCase("VERDURA")) {
					grupo = 3;
				} else {
					grupo = 4;
				}

				Statement inst = c.createStatement();
				String q3 = "INSERT INTO PLATOGRUPO VALUES(" + grupo + ", " + iplato.getCodigo() + ")";
				inst.executeUpdate(q3);
			}
		}
	}

	public static void actualizarPlato(int codigo, String nombre, String descripcion, int orden, double lactosa,
			String[] gruposAlimenticios) throws PlatoException, SQLException {
		Plato iplato = new Plato(nombre, descripcion, orden, lactosa, gruposAlimenticios);
		iplato.setCodigo(codigo);

		// Elimina los grupos alimenticios del plato para añadir los nuevos
		Statement statement = c.createStatement();
		String q1 = "DELETE FROM PLATOGRUPO WHERE CODIGOPLATO = " + iplato.getCodigo();
		statement.executeUpdate(q1);

		// Actualiza el plato a la tabla plato
		Statement instruccion = c.createStatement();
		String q2 = "UPDATE PLATO SET NOMBRE = '" + iplato.getNombre() + "', DESCRIPCION = '" + iplato.getDescripcion()
				+ "', ORDEN = " + iplato.getOrden() + ", CANTIDADLACTOSA = " + iplato.getCantidadLactosa()
				+ " WHERE CODIGOPLATO = " + iplato.getCodigo();
		instruccion.executeUpdate(q2);

		// Añade los valores a la tabla platogrupo

		for (int i = 0; i < gruposAlimenticios.length; i = i + 1) {
			int grupo;
			if (gruposAlimenticios[i] != null) {

				if (gruposAlimenticios[i].equalsIgnoreCase("CARNE")) {
					grupo = 1;
				} else if (gruposAlimenticios[i].equalsIgnoreCase("PESCADO")) {
					grupo = 2;
				} else if (gruposAlimenticios[i].equalsIgnoreCase("VERDURA")) {
					grupo = 3;
				} else {
					grupo = 4;
				}

				Statement inst = c.createStatement();
				String q3 = "INSERT INTO PLATOGRUPO VALUES(" + grupo + ", " + iplato.getCodigo() + ")";
				inst.executeUpdate(q3);
			}
		}
	}

	public static void eliminarPlato(int codigo) throws SQLException {
		// Elimina los grupos alimenticios del plato
		Statement statement = c.createStatement();
		String q1 = "DELETE FROM PLATOGRUPO WHERE CODIGOPLATO = " + codigo;
		statement.executeUpdate(q1);

		// Elimina el plato de BBDD por su código
		Statement query = c.createStatement();
		String q2 = "DELETE FROM PLATO WHERE CODIGOPLATO = " + codigo;
		query.executeUpdate(q2);
	}
}
