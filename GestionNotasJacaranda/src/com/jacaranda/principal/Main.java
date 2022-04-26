package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;
import com.jacaranda.gestion.NotaException;

public class Main {

	public static LinkedList<Alumnado> listaAlumnos = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNotas = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		// debe ser una ruta relativa NO se debe poner desde C en windows
		// folder\\alumnos.txt
		leerFicheroAlumnos("folder//alumnos.txt");
		leerFicheroModulos("folder//modulos.txt");
		leerFicheroNotas("folder//notas.txt");

		do {
			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1:
				System.out.println("Introduce el nombre: ");
				String nombre = teclado.nextLine();
				System.out.println("Introduce el DNI: ");
				String dni = teclado.nextLine();
				System.out.println("Introduce el correo: ");
				String correo = teclado.nextLine();
				listaAlumnos.add(new Alumnado(nombre, dni, correo));
				break;

			case 2:
				System.out.println("Introduce el nombre del módulo: ");
				String modulo = teclado.nextLine();
				System.out.println("Introduce el número de horas semanales: ");
				int numHoras = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce el número de créditos: ");
				int creditos = Integer.parseInt(teclado.nextLine());
				listaModulos.add(new Modulo(modulo, numHoras, creditos));
				break;

			case 3:
				System.out.println("Introduce el nombre del módulo: ");
				String moduloABuscar = teclado.nextLine();

				System.out.println("Introduce el DNI: ");
				String dniABuscar = teclado.nextLine();

				System.out.println("Introduce la fecha dd/mm/aaaa: ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaCorrecta = LocalDate.parse(teclado.nextLine(), formatter);

				System.out.println("Introduce la nota: ");
				double nota1 = Double.parseDouble(teclado.nextLine());

				// Nota(double nota, LocalDate fecha, Alumnado alumno, Modulo modulo) Para crear
				// una nota necesito
				/*
				 * 1.Debo buscar el m�dulo en la lista de modulos y lo copio 2. Debo buscar el
				 * alumno en la lista de alumnos y lo copio 3. crear nota 4. Si no existe�adirla
				 * a lista si existe - error
				 */

				try {
					Modulo nuevoModulo = buscarModulo(moduloABuscar);
					Alumnado nuevoAlumno = buscarAlumnado(dniABuscar);

					if (nuevoAlumno != null && nuevoModulo != null) {
						Nota nuevaNota = new Nota(nota1, fechaCorrecta, nuevoAlumno, nuevoModulo);
						if (listaNotas.contains(nuevaNota)) {
							throw new NotaException("La nota ya existe.");
						} else {
							listaNotas.add(nuevaNota);
						}
					} else {
						throw new NotaException("No se pudo crear la nota porque el módulo o el alumno no existe.");
					}
				} catch (NotaException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				for (Nota nota : listaNotas) {
					System.out.println(nota);
				}
				break;
			case 5:
				for (Alumnado alu : listaAlumnos) {
					System.out.println(alu);
				}
				break;
			case 6:
				// escribir los datos que hay en memoria en el fichero correspondiente
				escribirEnAlumnos("folder//alumnos.txt");
				escribirEnModulos("folder//modulos.txt");
				escribirEnNotas("folder//notas.txt");
				break;
			default:
				System.out.println("Opción no permitida");
				break;
			}
		} while (opc != 6);

	}

	private static void leerFicheroNotas(String fichero) {
		String linea;

		try {

			FileReader flujoLectura = new FileReader(fichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");
				Nota nota = new Nota(Double.parseDouble(campos[0]), LocalDate.parse(campos[1]),
						buscarAlumnado(campos[2]), buscarModulo(campos[3]));
				listaNotas.add(nota);

				linea = filtroLectura.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + fichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (NotaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerFicheroModulos(String fichero) {
		String linea;

		try {
			FileReader lectura = new FileReader(fichero);
			BufferedReader filtroLectura = new BufferedReader(lectura);

			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Modulo modulo = new Modulo(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]));
				listaModulos.add(modulo);

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			lectura.close();

		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + fichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void muestraMenu() {
		System.out.println("1. Alta alumnado \n" + "2. Alta modulo\n" + "3. Registrar nota\n"
				+ "4. Listar notas de todos los alumnos\n" + "5. Listar todos los alumnos\n" + "6. salir");
	}

	private static void leerFicheroAlumnos(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {
				// proceso la linea que voy a leer
				String[] campos = linea.split(",");
				Alumnado alu = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnos.add(alu);

				// leo otra linea
				linea = filtroLectura.readLine();
			}
			// cierro el fichero
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnAlumnos(String nombre) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// proceso en fichero

			for (Alumnado alu : listaAlumnos) {

				filtroEscritura.println(alu.escribeFichero());
			}

			// fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnNotas(String nombre) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Nota nota : listaNotas) {
				filtroEscritura.println(nota.getInfoNota());
			}

			filtroEscritura.close();
			flujoEscritura.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void escribirEnModulos(String nombre) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Modulo asignatura : listaModulos) {
				filtroEscritura.println(asignatura.getInfoModulo());
			}

			filtroEscritura.close();
			flujoEscritura.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static Modulo buscarModulo(String asignatura) {
		boolean encontrado = false;
		Modulo resultado = null;

		Iterator<Modulo> iterator = listaModulos.iterator();
		Modulo iModulo;

		while (iterator.hasNext() && !encontrado) {
			iModulo = iterator.next();
			if (iModulo.getNombre().equalsIgnoreCase(asignatura)) {
				resultado = iModulo;
				encontrado = true;
			}
		}

		return resultado;
	}

//	private static Modulo buscarModulo(String asignatura) {
//		Modulo resultado = null;
//		Modulo ibuscar = new Modulo(asignatura, 0, 0);
//
//		if (listaModulos.contains(ibuscar)) {
//			resultado = new Modulo(ibuscar.getNombre(), ibuscar.getNumHorasSemanales(), ibuscar.getCreditos());
//		}
//		return resultado;
//	}

	private static Alumnado buscarAlumnado(String dniABuscar) {
		Alumnado resultado = null;
		boolean encontrado = false;
		Alumnado iAlumno;
		Iterator<Alumnado> iterator = listaAlumnos.iterator();

		while (iterator.hasNext() && !encontrado) {
			iAlumno = iterator.next();

			if (iAlumno.getDni().equalsIgnoreCase(dniABuscar)) {
				resultado = iAlumno;
				encontrado = true;
			}
		}

		return resultado;
	}

}
