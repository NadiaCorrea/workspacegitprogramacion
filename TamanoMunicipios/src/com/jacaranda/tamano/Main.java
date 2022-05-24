package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String fichero = leerFichero("tamanoMunicipioComunidad.json");

		System.out.println(fichero);
	}

	public static String leerFichero(String nombre) {
		String cadena;
		StringBuilder result = new StringBuilder();

		try {
			FileReader flujoLectura = new FileReader(nombre);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			cadena = filtroLectura.readLine();
			while (cadena != null) {
				result.append(cadena);
				System.out.println(cadena);
				cadena = filtroLectura.readLine();

			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombre);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return result.toString();
	}

	public static void menu() {
		System.out.println("1. Mostrar los datos de todas las comunidades y de España\n"
				+ "2. Mostrar los datos de una comunidad y un año\n" + "3. Añadir un dato"
				+ "4. Comprobar el valor de Total\n" + "5. Salir");
	}

	/*
	 * • Mostrar los datos de todas las comunidades y de España de un año que se
	 * pedirá por teclado. Es decir, se mostrarán todos los datos. • Mostrar los
	 * datos de una comunidad y un año. Los datos se pedirán por teclado. • Añadir
	 * un dato. Se pedirá el nombre de la comunidad y la descripción (descrip). A
	 * continuación se pedirá el año y el valor del dato. Si la comunidad y la
	 * descripción no existe se mostrará un mensaje de error. Si existe se deberá
	 * mirar si existe el año y en este caso modificar el dato. Si el año no existe
	 * se deberá añadir junto con el dato. • Comprobar que el valor de Total es la
	 * suma de todos los valores: Para ello se deberá pedir la comunidad y el año.
	 * Se deberá comparar el valor “Total” de ese año con la suma de todos los datos
	 * de todos los municipios menos “Total”. Se deberá informar si el valor es
	 * igual o en caso de que no sea igual el valor actual y el que debería estar. ◦
	 * Al salir del menú pregunte si quiere guardar los nuevos datos (“¿Quieres
	 * guardar los datos en un nuevo fichero(S/N)?”) y en caso afirmativo pida el
	 * nombre del fichero a guardar. Se guardará en formato json.
	 */
}
