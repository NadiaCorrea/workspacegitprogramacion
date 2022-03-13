package com.jacaranda.empresavehiculos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainEmpresa {

	public static Scanner teclado = new Scanner(System.in);
	private static final int TOTAL_VEHICULOS = 200; // Considerar que la empresa trabajar� con un m�ximo de 200 veh�culos
	private static Vehiculo[] arrayVehiculos = new Vehiculo[TOTAL_VEHICULOS];
	private static int numVehiculo = 0;

	public static void main(String[] args) {
		String matricula;
		LocalDate fechaSalida;
		Vehiculo nuevoVehiculo = null; 

		int opc;
		do {
			menu();
			opc = leerEntero("�Qu� acci�n deseas realizar?: ");
			switch (opc) {
			case 1:// 1. Alta de veh�culo: Se solicitar� el tipo de veh�culo y sus datos y lo dar�
					// de alta.
				try {
					nuevoVehiculo = pedirDatos();
					arrayVehiculos [numVehiculo] = nuevoVehiculo;
					numVehiculo = numVehiculo + 1;
					System.out.println("El veh�culo ha sido dado de alta.");
				} catch (Exception e) {
					System.out.println("Se ha producido un error.");
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				// 2. C�lculo de precio de alquiler: Se solicitar� la matr�cula del veh�culo,
//				el n�mero de d�as que ha sido alquilado y se mostrar� el precio del alquiler
				
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
						System.out.println("No se ha encontrado el veh�culo.");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			case 3://3. Salir
				System.out.println("�Adi�s!");
				break;
			default:
				System.out.println("Error. La opci�n seleccionada no es valida.");
				break;
			}

		} while (opc != 3);

//		Se debe presentar un men� con las siguientes opciones: 
//		 

	}

	public static void menu() {
		System.out.println("1. Dar de alta a un veh�culo\n2. Calcular el precio del alquiler\n3. Salir. ");
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

		tipoVehiculo = leerCadena("Introduce el tipo de veh�culo (coche/furgoneta/microbus): ");
		matricula = leerCadena("Introduce la matr�cula: ");
		gama = leerCadena("Introduce la gama (alta/baja/media): ");

		if (tipoVehiculo.equalsIgnoreCase("coche")) {
			carburante = leerCadena("Introduce el tipo de carburante (diesel/gasolina): ");
			nuevoVehiculo = new Coche(matricula, gama, null, carburante);
		} else if (tipoVehiculo.equalsIgnoreCase("furgoneta")) {
			pma = leerDouble("Introduce el peso m�ximo autorizado: ");
			nuevoVehiculo = new Furgoneta(matricula, gama, null, pma);
		} else if (tipoVehiculo.equalsIgnoreCase("microbus")) {
			numPlazas = leerEntero("Introduce el n�mero de plazas: ");
			nuevoVehiculo = new Microbus(matricula, gama, null, numPlazas);
		} else {
			throw new VehiculoException("Error. El tipo de veh�culo introducido no es correcto."); 
		}
		return nuevoVehiculo;		
	}

}
