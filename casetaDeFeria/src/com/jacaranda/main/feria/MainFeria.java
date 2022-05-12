package com.jacaranda.main.feria;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.jacaranda.caseta.Caseta;
import com.jacaranda.caseta.CasetaManager;

public class MainFeria {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		CasetaManager feria = new CasetaManager();
		int opc;

		do {
			menu();
			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1:
				System.out.println("Introduce el nombre de la calle: ");
				String calle = teclado.nextLine();

				System.out.println(feria.mostrarCasetasPorCalle(calle));

				break;
			case 2:
				Set<Caseta> familiar = feria.mostrarCasetasFamiliar();
				System.out.println(imprimirListado(familiar));
				break;
			case 3:
				Set<Caseta> distrito = feria.mostrarCasetasDistrito();
				System.out.println(imprimirListado(distrito));
				break;
			case 4:
				Set<Caseta> otras = feria.mostrarCasetasOtras();
				System.out.println(imprimirListado(otras));
				break;
			case 5:
				Map<String, Integer> callesFamiliar = feria.mostrarCallesFamiliar();
				System.out.println(imprimirMap(callesFamiliar));
				break;
			case 6:
				Map<String, Integer> callesDistrito = feria.mostrarCallesDistrito();
				System.out.println(imprimirMap(callesDistrito));
				break;
			case 7:
				System.out.println("Introduce el título de la caseta: ");
				String titulo = teclado.nextLine();
				boolean resultado = feria.eliminarCaseta(titulo);
				if (resultado) {
					System.out.println("Caseta eliminada.");
				} else {
					System.out.println("No se ha encontrado la caseta.");
				}
				break;
			case 8:
				System.out.println("¡Adiós!");
				break;
			default:
				break;
			}
		} while (opc != 8);

	}

	public static void menu() {
		System.out.println("1. Mostrar todas las casetas existentes en una calle\n"
				+ "2. Mostrar todas las casetas de tipo familiar\n" + "3. Mostrar todas las casetas de tipo Distrito\n "
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos\n "
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen\n "
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen\n "
				+ "7. Eliminar una caseta\n" + "8. Salir.");
	}

	public static String imprimirListado(Set<Caseta> casetas) {
		StringBuilder result = new StringBuilder();

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext()) {
			iCaseta = iterador.next();
			result.append(iCaseta + "\n");
		}
		return result.toString();
	}

	public static String imprimirMap(Map<String, Integer> mapa) {
		StringBuilder result = new StringBuilder();
		for (String clave : mapa.keySet()) {
			int valor = mapa.get(clave);
			result.append("Calle: " + clave + ", número de casetas: " + valor + "\n");

		}
		return result.toString();
	}
}
