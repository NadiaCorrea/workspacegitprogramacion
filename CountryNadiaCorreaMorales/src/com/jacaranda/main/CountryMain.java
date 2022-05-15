package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.jacaranda.address.Address;
import com.jacaranda.city.City;
import com.jacaranda.country.Country;

public class CountryMain {

	private static List<Country> paises = new LinkedList<>();
	private static List<City> ciudades = new LinkedList<>();

	public static void main(String[] args) {
		/*
		 * carga de ficheros primero cargo el fichero de country, luego el de city y por
		 * último el de address
		 */

		leerFicheroCountry("ficheros/country.txt");
		leerFicheroCity("ficheros/city.txt");
		leerFicheroAddress("ficheros/address2.txt");
		System.out.println(imprimir(paises));

		escribirPaisesEnFichero("ficheros/paises.txt");
		escribirCiudadesEnFichero("ficheros/ciudades.txt");
	}

	private static void leerFicheroCountry(String nombreFichero) {
		String linea;

		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				Country pais = convertirLineaCountry(linea);
				paises.add(pais);

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Country convertirLineaCountry(String linea) {
		Country result;
		String[] lineaEnArray = linea.split(",");

		int id = Integer.parseInt(lineaEnArray[0]);
		String direccion = lineaEnArray[1];
		result = new Country(id, direccion);

		return result;
	}

	private static void leerFicheroCity(String nombreFichero) {
		String linea;

		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				City ciudad = convertirLineaCity(linea);
				ciudades.add(ciudad);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static City convertirLineaCity(String linea) {
		City nueva = null;

		String[] arrayLinea = linea.split(",");
		String ciudad = arrayLinea[1];
		int idCiudad = Integer.parseInt(arrayLinea[0]);
		int idPais = Integer.parseInt(arrayLinea[2]);
		nueva = new City(idCiudad, ciudad);

		boolean encontrado = false;
		Iterator<Country> iterador = paises.iterator();
		Country iCountry;
		while (iterador.hasNext() && !encontrado) {
			iCountry = iterador.next();
			if (idPais == iCountry.getCountryId()) {
				iCountry.addCity(nueva);
				encontrado = true;
			}
		}
		return nueva;
	}

	private static void leerFicheroAddress(String nombreFichero) {
		String linea;

		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				Address direccion = convertirLineaAddress(linea);

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Address convertirLineaAddress(String linea) {
		Address nueva = null;

		String[] arrayLinea = linea.split(",");
		String direccion = arrayLinea[1];
		int idDireccion = Integer.parseInt(arrayLinea[0]);
		int idCiudad = Integer.parseInt(arrayLinea[4]);
		nueva = new Address(idDireccion, direccion);

		boolean encontrado = false;
		Iterator<City> iterador = ciudades.iterator();
		City iCity;
		while (iterador.hasNext() && !encontrado) {
			iCity = iterador.next();
			if (idCiudad == iCity.getCityId()) {
				Iterator<Country> iteradorPais = paises.iterator();
				boolean paisEncontrado = false;
				Country iCountry;
				while (iteradorPais.hasNext() && !paisEncontrado) {
					iCountry = iteradorPais.next();
					if (iCountry.existeCiudad(iCity)) {
						iCountry.addAddressCiudad(iCity, nueva);
						paisEncontrado = true;
					}
				}
				encontrado = true;
			}
		}
		return nueva;
	}

	public static String imprimir(List<Country> paises) {
		StringBuilder result = new StringBuilder();

		Iterator<Country> iterador = paises.iterator();
		Country iCountry;
		while (iterador.hasNext()) {
			iCountry = iterador.next();
			result.append(iCountry.toString() + "\n");
		}

		return result.toString();

	}
	/*
	 * El programa debe crear un nuevo fichero en donde aparezca el id y el nombre
	 * de cada país, junto con el número de ciudades que hay en ese país y el númeo
	 * de direcciones que hay, de forma que en cada pais se muestren primero las
	 * ciudades con más direcciones. Si hay dos ciudades con el mismo numero de
	 * direcciones nombre deberán aparecer ordenadas alfabéticamente. El programa
	 * también deberá crear otro fichero con los datos de las ciudades y a
	 * continuación las direcciones correspondientes.
	 */

	private static void escribirPaisesEnFichero(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			Iterator<Country> iterador = paises.iterator();
			Country iPais;

			while (iterador.hasNext()) {
				iPais = iterador.next();
				StringBuilder result = new StringBuilder();

				Iterator<City> ite = iPais.getCities().iterator();
				City iCity;
				int totalDirecciones = 0;
				while (ite.hasNext()) {
					iCity = ite.next();
					totalDirecciones = totalDirecciones + iCity.getNumDir();
					result.append("ciudad: " + iCity.getCity() + " - total direcciones: " + iCity.getNumDir() + "\n");
				}

				cadena = "País: " + iPais.getCountryId() + ", " + iPais.getCountry() + ", número de ciudades "
						+ iPais.getCities().size() + ", número de direcciones " + totalDirecciones + "\n"
						+ result.toString();
				filtroEscritura.println(cadena);
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * El programa también deberá crear otro fichero con los datos de las ciudades y
	 * a continuación las direcciones correspondientes.
	 */

	private static void escribirCiudadesEnFichero(String nombre) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			Iterator<City> iterador = ciudades.iterator();
			City iCity;

			while (iterador.hasNext()) {
				iCity = iterador.next();
				filtroEscritura.println(iCity.toString());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
