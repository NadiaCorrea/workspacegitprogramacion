package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Series series = new Series();
		Temporada temp = new Temporada("hawai");
		int opc;

		try {

			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			Serie serie1 = new Serie("friends", 1980, Tema.COMEDIA);
			serie1.annadirTemporada("1temp");

			temp.annadirCapitulo("this prueba");
			temp.annadirCapitulo("the prueba");
			temp.annadirCapitulo("this probar");

			System.out.println(temp.primerCapituloQueContieneEstaPalabara("this"));
			// System.out.println(temp.primerCapituloQueContieneEstaPalabara("that"));

			temp.anadirCapituloDespues("this prueba2", "the prueba");
			System.out.println(temp.toString());

			System.out.println();

			menu();
			opc = leerEntero("¿Qué quieres hacer?");

			do {

				switch (opc) {
				case 1:

					break;
				case 2:

					break;
				case 3:
					escribirEnFicheroSeries("ficheros/Series.csv");
					break;

				default:
					System.out.println("opción no válida.");
					break;
				}

			} while (opc != 3);

		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void menu() {
		System.out.println("1. Añadir Series\n " + "2. Buscar Series\n" + "3. Salir.");

	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	private static void escribirEnFicheroSeries(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (int i = 1; i <= series.size(); i++) {

				cadena = teclado.nextLine();
				filtroEscritura.println(cadena);
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
