package com.jacaranda.main.feria;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class MainFeria {

	public static void main(String[] args) {

		File archivo = new File("folderFeria//casetasferia.xml");

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*
		 * El Ayuntamiento de Sevilla nos piden que hagamos una aplicación para
		 * gestionar las casetas de la Feria de Sevilla. Para ello nos entregan un
		 * fichero XLM en el que tienen todos los datos disponibles. Nos piden que
		 * carguemos esos datos en memoria. Nos piden que realicemos un menú con las
		 * siguientes opciones:
		 * 
		 * 1. Mostrar todas las casetas existentes en una calle.
		 * 
		 * 2. Mostrar todas las casetas de tipo familiar.
		 * 
		 * 3. Mostrar todas las casetas de tipo Distrito
		 * 
		 * 4. Mostrar todas las casetas que no sean ni familiares ni distritos.
		 * 
		 * 5. Mostrar para cada una de las calles del recinto ferial el número de
		 * casetas de tipo familiar que existen.
		 * 
		 * 6. Mostrar para cada una de las calles del recinto ferial el número de
		 * casetas de tipo Distrito que existen.
		 * 
		 * 7. Eliminar una caseta.
		 * 
		 * 8. Salir.
		 */

	}

	public void menu() {
		System.out.println("1. Mostrar todas las casetas existentes en una calle.\n"
				+ "2. Mostrar todas las casetas de tipo familiar.\n"
				+ "3. Mostrar todas las casetas de tipo Distrito\n "
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos.\n "
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen.\n "
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen.\n "
				+ "7. Eliminar una caseta.\n" + "8. Salir.");
	}
}
