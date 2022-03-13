package com.jacaranda.empresavehiculos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainEmpresa {

	public static Scanner teclado = new Scanner(System.in);
	private static final int TOTAL_VEHICULOS = 200; // Considerar que la empresa trabajará con un máximo de 200 vehículos
	private static Vehiculo[] arrayVehiculos = new Vehiculo[TOTAL_VEHICULOS];
	private static int numVehiculo = 0;

	public static void main(String[] args) {
		String matricula;
		LocalDate fechaSalida;
		Vehiculo nuevoVehiculo = null; 

		int opc;
		do {
			menu();
			opc = leerEntero("¿Qué acción deseas realizar?: ");
			switch (opc) {
			case 1:// 1. Alta de vehículo: Se solicitará el tipo de vehículo y sus datos y lo dará
					// de alta.
				try {
					nuevoVehiculo = pedirDatos();
					arrayVehiculos [numVehiculo] = nuevoVehiculo;
					numVehiculo = numVehiculo + 1;
					System.out.println("El vehículo ha sido dado de alta.");
				} catch (Exception e) {
					System.out.println("Se ha producido un error.");
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				// 2. Cálculo de precio de alquiler: Se solicitará la matrícula del vehículo,
//				el número de días que ha sido alquilado y se mostrará el precio del alquiler
				
				String fecha;
				boolean encontrado = false;
				int posicion = -1;
				
				matricula = leerCadena("Introduce la matricula");
				fecha = leerCadena("Introduce la fecha de salida dd/mm/yyyy: ");
			
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaSalida = LocalDate.parse(fecha, formato);
				
				try {
					for (int i=0; i <numVehiculo && encontrado == false; i= i +1) {
						if (arrayVehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
							encontrado = true;
							posicion = i;
						}
					} if (encontrado == true) {
						arrayVehiculos[posicion].setFechaSalida(fechaSalida);
						System.out.println(arrayVehiculos[posicion].getPrecio());
					} else {
						System.out.println("No se ha encontrado el vehículo.");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			case 3://3. Salir
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Error. La opción seleccionada no es valida.");
				break;
			}

		} while (opc != 3);

//		Se debe presentar un menú con las siguientes opciones: 
//		 

	}

	public static void menu() {
		System.out.println("1. Dar de alta a un vehículo\n2. Calcular el precio del alquiler\n3. Salir. ");
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

	public static Vehiculo pedirDatos() throws VehiculoException {
		String matricula;
		String tipoVehiculo;
		String gama;
		String carburante;
		double pma;
		int numPlazas;
		Vehiculo nuevoVehiculo = null;

		tipoVehiculo = leerCadena("Introduce el tipo de vehículo (coche/furgoneta/microbus): ");
		matricula = leerCadena("Introduce la matrícula: ");
		gama = leerCadena("Introduce la gama (alta/baja/media): ");

		if (tipoVehiculo.equalsIgnoreCase("coche")) {
			carburante = leerCadena("Introduce el tipo de carburante (diesel/gasolina): ");
			nuevoVehiculo = new Coche(matricula, gama, null, carburante);
		} else if (tipoVehiculo.equalsIgnoreCase("furgoneta")) {
			pma = leerDouble("Introduce el peso máximo autorizado: ");
			nuevoVehiculo = new Furgoneta(matricula, gama, null, pma);
		} else if (tipoVehiculo.equalsIgnoreCase("microbus")) {
			numPlazas = leerEntero("Introduce el número de plazas: ");
			nuevoVehiculo = new Microbus(matricula, gama, null, numPlazas);
		} else {
			throw new VehiculoException("Error. El tipo de vehículo introducido no es correcto."); 
		}
		return nuevoVehiculo;		
	}

}
