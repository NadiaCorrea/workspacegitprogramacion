package com.jacaranda.main.diccionario;

import java.util.Scanner;

import com.jacaranda.diccionario.Diccionario;

public class PrincipalDiccionario {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		String palabra;
		String significado;
		Diccionario dic1 = new Diccionario();

		do {

			menu();
			opc = leerEntero("¿Qué opción deseas realizar?");

			switch (opc) {
			// Añadir palabra. Se solicitará a palabra y su significado. Si la palabra ya
			// tenía un significado se guardará este nuevo significado con los anteriores
			case 1:
				palabra = leerCadena("Introduce la palabra que deseas añadir: ");
				significado = leerCadena("Introduce su significado: ");
				try {
					dic1.addDiccionario(palabra, significado);
					System.out.println("La palabra ha sido añadida.");
				} catch (Exception e) {
					System.out.println("Error. " + e.getMessage());
				}
				break;
			// Buscar palabra en diccionario: Se solicitará la palabra y se mostrarán todos
			// sus significados
			case 2:
				palabra = leerCadena("Introduce la palabra que deseas buscar: ");
				try {
					System.out.println(dic1.buscarPalabra(palabra));
				} catch (Exception e) {
					System.out.println("Error. " + e.getMessage());
				}
				break;
			// Borrar una palabra del diccionario: Se solicitará la palabra y se borrará,
			// con todos sus significados.
			case 3:
				palabra = leerCadena("Introduce la palabra que deseas borrar: ");

				try {
					dic1.borrarPalabra(palabra);
					System.out.println("Palabra eliminada.");
				} catch (Exception e) {
					System.out.println("Error. " + e.getMessage());
				}

				break;
			// Listado de palabras que empiecen por ... Se solicitará una cadena y se
			// mostrará un listado de palabras ordenado alfabéticamente que comiencen por
			// esa cadena.
			case 4:
				palabra = leerCadena("Introduce las primeras letras de la palabra a buscar: ");
				try {
					System.out.println(dic1.listarDiccionario(palabra));
				} catch (Exception e) {
					System.out.println("Error. " + e.getMessage());
				}
				break;
			case 5:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Error. Opción no válida.");
				break;
			}

		} while (opc != 5);

	}

	public static void menu() {
		System.out.println("1. Añadir palabra\n" + "2. Buscar palabra en diccionario\n"
				+ "3. Borrar una palabra del diccionario\n" + "4. Listado de palabras que empiecen por\n" + "5. Salir");
	}

	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

}
