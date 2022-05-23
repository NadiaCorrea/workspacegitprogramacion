package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String fichero = leerFichero("fichero/prueba.json");
		System.out.println("****");
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
}
