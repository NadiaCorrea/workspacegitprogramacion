package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static TamanoMunicipioComunidad tamMunCom = new TamanoMunicipioComunidad();

	public static void main(String[] args) {

		String fichero = leerFichero("src/resources/tamanoMunicipioComunidad.json");

		Gson gson = new Gson();

		ArrayList<Comunidad> lista = gson.fromJson(fichero, new TypeToken<ArrayList<Comunidad>>() {
		}.getType());
		tamMunCom.setLista(lista);

		int opc;

		do {
			menu();

			int ano;
			String comunidad;
			String descripcion;
			int dato;
			String guardar;
			String nombreFichero;

			opc = leerEntero("Selecciona una opción: ");

			switch (opc) {
			case 1:
				ano = leerEntero("Introduce el año: ");
				mostrarTodoPorAno(ano);
				break;
			case 2:
				comunidad = leerCadena("Introduce la comunidad: ");
				ano = leerEntero("Introduce el año: ");
				mostrarPorComunidadYAno(comunidad, ano);
				break;
			case 3:
				comunidad = leerCadena("Introduce la comunidad: ");
				descripcion = leerCadena("Introduce la descripción: ");
				ano = leerEntero("Introduce el año: ");
				dato = leerEntero("Introduce el dato: ");
				anadirDato(comunidad, descripcion, ano, dato);
				break;
			case 4:
				comunidad = leerCadena("Introduce la comunidad: ");
				ano = leerEntero("Introduce el año: ");
				comprobarTotal(comunidad, ano);
				break;
			case 5:
				guardar = leerCadena("¿Quieres guardar los datos en un nuevo fichero(S/N)?");
				if (guardar.equalsIgnoreCase("S")) {
					nombreFichero = leerCadena("Introduce el nombre del fichero: ");
					nombreFichero = "src/resources/" + nombreFichero;
					Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
					String listaJson = prettyGson.toJson(tamMunCom.getLista());
					escribirFichero(nombreFichero, listaJson);
				}
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		} while (opc != 5);

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

	public static void escribirFichero(String nombre, String lista) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(lista);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void menu() {
		System.out.println("1. Mostrar los datos de todas las comunidades y de EspaÃ±a\n"
				+ "2. Mostrar los datos de una comunidad y un aÃ±o\n" + "3. Añadir un dato\n"
				+ "4. Comprobar el valor de Total\n" + "5. Salir");
	}

	public static int leerEntero(String texto) {
		int entero = -1;
		boolean leido = false;

		do {
			System.out.println(texto);
			entero = Integer.parseInt(teclado.nextLine());
			leido = true;
		} while (leido == false);

		return entero;
	}

	public static String leerCadena(String texto) {
		String cadena = "";
		boolean leido = false;

		do {
			System.out.println(texto);
			cadena = teclado.nextLine();
			leido = true;
		} while (leido == false);

		return cadena;
	}

	/*
	 * â€¢ Mostrar los datos de todas las comunidades y de EspaÃ±a de un aÃ±o que se
	 * pedirÃ¡ por teclado. Es decir, se mostrarÃ¡n todos los datos. â€¢ Mostrar los
	 * datos de una comunidad y un aÃ±o. Los datos se pedirÃ¡n por teclado. â€¢
	 * AÃ±adir un dato. Se pedirÃ¡ el nombre de la comunidad y la descripciÃ³n
	 * (descrip). A continuaciÃ³n se pedirÃ¡ el aÃ±o y el valor del dato. Si la
	 * comunidad y la descripciÃ³n no existe se mostrarÃ¡ un mensaje de error. Si
	 * existe se deberÃ¡ mirar si existe el aÃ±o y en este caso modificar el dato.
	 * Si el aÃ±o no existe se deberÃ¡ aÃ±adir junto con el dato. â€¢ Comprobar que
	 * el valor de Total es la suma de todos los valores: Para ello se deberÃ¡ pedir
	 * la comunidad y el aÃ±o. Se deberÃ¡ comparar el valor â€œTotalâ€� de ese aÃ±o
	 * con la suma de todos los datos de todos los municipios menos â€œTotalâ€�. Se
	 * deberÃ¡ informar si el valor es igual o en caso de que no sea igual el valor
	 * actual y el que deberÃ­a estar. â—¦ Al salir del menÃº pregunte si quiere
	 * guardar los nuevos datos (â€œÂ¿Quieres guardar los datos en un nuevo
	 * fichero(S/N)?â€�) y en caso afirmativo pida el nombre del fichero a guardar.
	 * Se guardarÃ¡ en formato json.
	 */

	public static void mostrarTodoPorAno(int ano) {
		StringBuilder sb = new StringBuilder();
		Comunidad iComunidad;
		Iterator<Comunidad> comunidadIterator = tamMunCom.getLista().iterator();
		while (comunidadIterator.hasNext()) {
			iComunidad = comunidadIterator.next();
			sb.append(iComunidad.getNombre() + "\n");
			Municipio iMunicipio;
			Iterator<Municipio> municipioIterator = iComunidad.getListMunicipio().iterator();
			while (municipioIterator.hasNext()) {
				iMunicipio = municipioIterator.next();
				sb.append("\t" + iMunicipio.getDescrip() + ": ");
				Datos iDatos;
				Iterator<Datos> datosIterator = iMunicipio.getDatos().iterator();
				boolean enc = false;
				while (datosIterator.hasNext() && !enc) {
					iDatos = datosIterator.next();
					if (iDatos.getAno() == ano) {
						enc = true;
						sb.append(iDatos.getDato());
					}
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void mostrarPorComunidadYAno(String comunidad, int ano) {
		StringBuilder sb = new StringBuilder();
		Comunidad iComunidad;
		Iterator<Comunidad> comunidadIterator = tamMunCom.getLista().iterator();
		boolean encComunidad = false;
		while (comunidadIterator.hasNext() && !encComunidad) {
			iComunidad = comunidadIterator.next();
			if (iComunidad.getNombre().equalsIgnoreCase(comunidad)) {
				encComunidad = true;
				Municipio iMunicipio;
				Iterator<Municipio> municipioIterator = iComunidad.getListMunicipio().iterator();
				while (municipioIterator.hasNext()) {
					iMunicipio = municipioIterator.next();
					sb.append(iMunicipio.getDescrip() + ": ");
					Datos iDatos;
					Iterator<Datos> datosIterator = iMunicipio.getDatos().iterator();
					boolean enc = false;
					while (datosIterator.hasNext() && !enc) {
						iDatos = datosIterator.next();
						if (iDatos.getAno() == ano) {
							enc = true;
							sb.append(iDatos.getDato());
						}
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	public static void anadirDato(String comunidad, String descripcion, int ano, int dato) {
		Comunidad iComunidad;
		Iterator<Comunidad> comunidadIterator = tamMunCom.getLista().iterator();
		boolean encComunidad = false;
		while (comunidadIterator.hasNext() && !encComunidad) {
			iComunidad = comunidadIterator.next();
			if (iComunidad.getNombre().equalsIgnoreCase(comunidad)) {
				encComunidad = true;
				Municipio iMunicipio;
				Iterator<Municipio> municipioIterator = iComunidad.getListMunicipio().iterator();
				boolean encMunicipio = false;
				while (municipioIterator.hasNext() && !encMunicipio) {
					iMunicipio = municipioIterator.next();
					if (iMunicipio.getDescrip().equalsIgnoreCase(descripcion)) {
						encMunicipio = true;
						Datos iDatos;
						Iterator<Datos> datosIterator = iMunicipio.getDatos().iterator();
						boolean encDatos = false;
						while (datosIterator.hasNext() && !encDatos) {
							iDatos = datosIterator.next();
							if (iDatos.getAno() == ano) {
								encDatos = true;
								iDatos.setDato(dato);
							}
						}
						if (!encDatos) {
							Datos datos = new Datos(ano, dato);
							iMunicipio.getDatos().add(datos);
						}
					}
				}
				if (!encMunicipio) {
					System.out.println("Error: el municipio no existe");
				}
			}
		}
		if (!encComunidad) {
			System.out.println("Error: la comunidad no existe");
		}
	}

	public static void comprobarTotal(String comunidad, int ano) {
		int total = 0;
		int iTotal = 0;

		Comunidad iComunidad;
		Iterator<Comunidad> comunidadIterator = tamMunCom.getLista().iterator();
		boolean encComunidad = false;
		while (comunidadIterator.hasNext() && !encComunidad) {
			iComunidad = comunidadIterator.next();
			if (iComunidad.getNombre().equalsIgnoreCase(comunidad)) {
				encComunidad = true;
				Municipio iMunicipio;
				Iterator<Municipio> municipioIterator = iComunidad.getListMunicipio().iterator();
				while (municipioIterator.hasNext()) {
					iMunicipio = municipioIterator.next();
					if (iMunicipio.getDescrip().equalsIgnoreCase("Total")) {
						Datos iDatos;
						Iterator<Datos> datosIterator = iMunicipio.getDatos().iterator();
						boolean encDatos = false;
						while (datosIterator.hasNext() && !encDatos) {
							iDatos = datosIterator.next();
							if (iDatos.getAno() == ano) {
								encDatos = true;
								total = iDatos.getDato();
							}
						}
					} else {
						Datos iDatos;
						Iterator<Datos> datosIterator = iMunicipio.getDatos().iterator();
						boolean encDatos = false;
						while (datosIterator.hasNext() && !encDatos) {
							iDatos = datosIterator.next();
							if (iDatos.getAno() == ano) {
								encDatos = true;
								iTotal = iTotal + iDatos.getDato();
							}
						}
					}
				}
			}
		}
		if (total == iTotal) {
			System.out.println("El total es igual");
		} else {
			System.out.println("El valor actual es " + total + " y debería ser " + iTotal);
		}
	}
}
