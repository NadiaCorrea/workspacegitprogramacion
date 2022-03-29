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
			opc = leerEntero("Introduce la opci�n deseada: ");

			switch (opc) {
//			1. Nueva p�gina consultada: Se solicitar� el nombre de la p�gina y se tomar� la fecha y hora del sistema
//			insert�ndola en el historial. No se permitir� introducir una fecha y hora anterior a la �ltima almacenada.
			case 1:
				nombre = leerCadena("Introduce el nombre de la p�gina: ");

				try {
					nuevoHistorial.addPagina(nombre);
					System.out.println("P�gina a�adida.");
				} catch (HistorialException e) {
					System.out.println("No se ha podido guardar la p�gina." + e.getMessage());
				}

				break;
			// 2. Consultar historial completo.
			case 2:
				System.out.println(nuevoHistorial.getHistorial());
				break;
			// 3.Consultar historial de un d�a.
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
				System.out.println("�Adi�s!");
				break;
			default:
				System.out.println("Opci�n no valida.");
				break;
			}
		} while (opc != 5);

	}

	public static void menu() {
		System.out.println("�Qu� desea hacer?\n" + "1. Nueva p�gina consultada\n" + "2. Consultar historial completo\n"
				+ "3.Consultar historial de un d�a\n" + "4. Borrar historial completo\n" + "5. Salir");
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
