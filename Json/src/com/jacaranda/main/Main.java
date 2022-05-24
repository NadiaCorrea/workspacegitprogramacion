package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {

		String fichero = leerFichero("fichero/prueba.json");
		System.out.println("****");
		System.out.println(fichero);

		// Creamos un objeto Gson
		Gson gson = new Gson();

		Persona p1 = gson.fromJson(fichero, Persona.class);

		// Para obtener cada una de las propiedad del objeto
		// Recordad que no funcionario si tenemos un array.
		Properties properties = gson.fromJson(fichero, Properties.class);
		System.out.println(p1);
		// Mostrarmos cada una de las propiedades.

		System.out.println("*****");
		System.out.println(properties.get("nombre"));
		System.out.println(properties.get("apellidos"));
		System.out.println(properties.get("edad"));

		// Declaramos la variable en donde guardaremos la informacion.
		ArrayList<Persona> personas = gson.fromJson(fichero, new TypeToken<ArrayList<Persona>>() {
		}.getType());
		// TypeToken nos sirve para obtener la clase del objeto a crear.
		// Podemos trabajar ya con el ArrayList
		for (Persona aux : personas) {
			System.out.println(aux.toString());
		}

		Persona p2 = new Persona("Pepe", "Pérez", 33);
		personas.add(p2);
		personas.remove(0);

		String salida = gson.toJson(personas);
		System.out.println("info");
		System.out.println(salida);

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

	private static void escribirEnFicheroPorLineas(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(cadena);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
