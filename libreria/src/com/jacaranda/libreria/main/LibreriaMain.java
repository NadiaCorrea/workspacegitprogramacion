package com.jacaranda.libreria.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.jacaranda.libreria.libro.Digital;
import com.jacaranda.libreria.libro.DigitalException;
import com.jacaranda.libreria.libro.Libro;
import com.jacaranda.libreria.libro.LibroException;
import com.jacaranda.libreria.libro.Papel;
import com.jacaranda.libreria.libro.PapelException;

public class LibreriaMain {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// Realiza un programa principal que pida los datos para crear dos libros,
		// imprima dichos libros y
//		utilice la función anterior.
//		El programa principal también deberá pedir los datos para crear dos libros en papel y dos libros
//		digitales, los imprima y use los métodos de ver cual es más caro.

		try {
			Libro libro1 = leerLibro();
			Libro libro2 = leerLibro();
			System.out.println(libro1.toString());
			System.out.println(libro2.toString());
			System.out.println(
					"La diferencia de dias entre los libros es de " + libro1.calcularDiferenciaDias(libro2) + " dias");
		} catch (LibroException e) {
			System.out.println(e.getMessage());
		}

		Papel libroPapel1 = leerLibroPapel();
		Papel libroPapel2 = leerLibroPapel();
		Digital libroDigital1 = leerLibroDigital();
		Digital libroDigital2 = leerLibroDigital();
		System.out.println(libroPapel1.toString());
		System.out.println(libroPapel2.toString());
		System.out.println(libroDigital1.toString());
		System.out.println(libroDigital2.toString());

		try {
			System.out.println("¿El primer libro en papel es más caro que el primer libro digital?: "
					+ libroPapel1.esMasCaro(libroDigital1));
			System.out.println("¿El primer libro en papel es más caro que el segundo libro digital?: "
					+ libroPapel1.esMasCaro(libroDigital2));
			System.out.println("¿El primer libro digital es más caro que el segundo libro en papel?: "
					+ libroDigital1.esMasCaro(libroPapel2));
			System.out.println("¿El segundo libro digital es más caro que el segundo libro en papel?: "
					+ libroDigital2.esMasCaro(libroPapel2));
		} catch (PapelException e) {
			System.out.println(e.getMessage());
		} catch (DigitalException e) {
			System.out.println(e.getMessage());
		}

	}

	private static Digital leerLibroDigital() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Papel leerLibroPapel() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void menu() {
		System.out.println();
	}

	public static Libro leerLibro() {

		String titulo = leerCadena("Introduce el título: ");
		String autor = leerCadena("Introduce el autor: ");
		String editorial = leerCadena("Introduce la editorial: ");
		LocalDate fechaEdicion = leerFecha("Introduce la fecha de edición: ");

		Libro libro = new Libro(titulo, autor, editorial);
		libro.setFechaEdicion(fechaEdicion);

		return libro;

	}

	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}

	public static LocalDate leerFecha(String texto) {
		System.out.println(texto);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(teclado.nextLine(), formatter);
	}

}
