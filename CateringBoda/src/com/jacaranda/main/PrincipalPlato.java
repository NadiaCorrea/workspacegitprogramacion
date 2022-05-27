package com.jacaranda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jacaranda.plato.Plato;

public class PrincipalPlato {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain",
					"cateringBoda", "cateringBoda");

			DatabaseMetaData infoBD = c.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());

			String nombre, descripcion;
			String[] gruposAlimenticios;
			int opc, orden;
			double lactosa;

			// opciones de menu para crear, modificar y eliminar plato
			do {
				menu();
				opc = leerEntero("¿Qué quieres hacer?");

				switch (opc) {
				case 1:

					nombre = leerCadena("Introduce el nombre del plato: ");
					descripcion = leerCadena("Introduce la descripción del plato: ");
					orden = leerEntero("Introduce el orden del plato: ");
					lactosa = leerReal("Introduce la cantidad de lactosa del plato: ");
					gruposAlimenticios = new String[3];
					int numGruposAlimenticios = 0;
					int opcion = -1;

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

					Plato iplato = new Plato(nombre, descripcion, orden, lactosa, gruposAlimenticios);
					int cod;

					// Insertar el nuevo plato a la BBDD

					/*
					 * Tenía el cod de plato para que ser generara automaticamente asi que he
					 * cambiado eso y he creado una secuencia en bbdd para que genere el codido
					 */
					Statement query = c.createStatement();
					String q = "SELECT CODPLATO.nextval from dual"; // llama a la secuencia para que dé es siguiente
																	// valor asignable
					ResultSet result = query.executeQuery(q);
					if (result.next()) {
						cod = result.getInt(1);
						iplato.setCodigo(cod); // se asigna el cod de la secuencia al plato creado
					}

					// Añade el plato a la tabla plato
					Statement instruccion = c.createStatement();
					String q2 = "insert into PLATO values(" + iplato.getCodigo() + ",'" + iplato.getNombre() + "','"
							+ iplato.getDescripcion() + "'," + iplato.getOrden() + "," + iplato.getCantidadLactosa()
							+ ")";
					instruccion.executeQuery(q2);

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
							String q3 = "insert into PLATOGRUPO values(" + grupo + ", " + iplato.getCodigo() + ")";
							inst.executeQuery(q3);
						}
					}

					break;
				case 2:

					break;
				case 3:
					break;
				case 4:
					System.out.println("¡Adiós!");
					break;

				default:
					System.out.println("Opción no válida.");
					break;
				}

			} while (opc != 4);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void menu() {
		System.out.println("1. Añadir un plato \n" + "2. Modificar un plato\n" + "3. Eliminar un plato\n" + "4. Salir");
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
}
