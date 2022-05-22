package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static Series series = new Series();

	public static void main(String[] args) {

		// int opc;

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

			escribirEnFicheroSeries("ficheros/Series.csv");
			escribirEnFicheroTemporada("ficheros/Temporada.csv");
			escribirEnFicheroCapitulos("ficheros/Capitulos.csv");

			/*
			 * menu(); opc = leerEntero("¿Qué quieres hacer?");
			 * 
			 * do {
			 * 
			 * switch (opc) { case 1: break; case 2: break; case 3: break;
			 * 
			 * default: System.out.println("opción no válida."); break; }
			 * 
			 * } while (opc != 3);
			 */

		} catch (SerieException e) {
			e.printStackTrace();
		}

	}

	private static void escribirEnFicheroSeries(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Serie iSerie : series.getMapSeries().values()) {
				cadena = iSerie.getNombreSerie() + "," + iSerie.getAnno() + "," + iSerie.getTema();
				filtroEscritura.println(cadena);
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroCapitulos(String nombre) {
		String cadena;
		String inombre;
		ArrayList<Temporada> temporadas;

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Serie iSerie : series.getMapSeries().values()) {
				inombre = iSerie.getNombreSerie();
				temporadas = iSerie.getTemporadas();

				Iterator<Temporada> iterador = temporadas.iterator();
				Temporada iTemp;

				while (iterador.hasNext()) {
					iTemp = iterador.next();

					List<String> listaCapitulos = iTemp.getCapitulos();
					Iterator<String> iter = listaCapitulos.iterator();
					String iCapitulo;
					while (iter.hasNext()) {
						iCapitulo = iter.next();
						cadena = inombre + "," + iTemp.getNombreTemporada() + "," + iCapitulo;
						filtroEscritura.println(cadena);
					}
				}
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroTemporada(String nombre) {
		String cadena;
		String inombre;
		ArrayList<Temporada> temporadas;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Serie iSerie : series.getMapSeries().values()) {
				inombre = iSerie.getNombreSerie();
				temporadas = iSerie.getTemporadas();

				Iterator<Temporada> iterador = temporadas.iterator();
				Temporada iTemp;

				while (iterador.hasNext()) {
					iTemp = iterador.next();

					cadena = inombre + "," + iTemp.toStringFichero();
					filtroEscritura.println(cadena);
				}
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void menu() {
		System.out.println("1. Añadir Series\n " + "2. Buscar Series\n" + "3. Salir.");

	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

}
