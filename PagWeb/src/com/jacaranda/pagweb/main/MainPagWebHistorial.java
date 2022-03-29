package com.jacaranda.pagweb.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.jacaranda.pagweb.Historial;
import com.jacaranda.pagweb.HistorialException;

public class MainPagWebHistorial {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		Historial nuevoHistorial = new Historial();
		String nombre;
		LocalDate fecha;

		do {
			menu();
			opc = leerEntero("Introduce la opción deseada: ");

			switch (opc) {
//			1. Nueva página consultada: Se solicitará el nombre de la página y se tomará la fecha y hora del sistema
//			insertándola en el historial. No se permitirá introducir una fecha y hora anterior a la última almacenada.
			case 1:
				nombre = leerCadena("Introduce el nombre de la página: ");

				try {
					nuevoHistorial.addPagina(nombre);
					System.out.println("Página añadida.");
				} catch (HistorialException e) {
					System.out.println("No se ha podido guardar la página." + e.getMessage());
				}

				break;
			// 2. Consultar historial completo.
			case 2:
				System.out.println(nuevoHistorial.getHistorial());
				break;
			// 3.Consultar historial de un día.
			case 3:
				fecha = leerFecha("Introduce la fecha a consultar (dd/mm/aaaa): ");
				System.out.println(nuevoHistorial.getHistorialDia(fecha));

				break;
//			 4. Borrar historial completo.
			case 4:
				nuevoHistorial.delHistorial();
				System.out.println("Historial eliminado.");
				break;
			case 5:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Opción no valida.");
				break;
			}
		} while (opc != 5);

	}

	public static void menu() {
		System.out.println("¿Qué desea hacer?\n" + "1. Nueva página consultada\n" + "2. Consultar historial completo\n"
				+ "3.Consultar historial de un día\n" + "4. Borrar historial completo\n" + "5. Salir");
	}

	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static LocalDate leerFecha(String texto) {
		System.out.println(texto);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(teclado.nextLine(), formatter);
	}

	// LocalDateTime.parse(fecha,DateTimeFormatter.ofPattern("dd/MM/yyyy"));

}
