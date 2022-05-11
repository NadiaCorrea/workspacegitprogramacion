package com.jacaranda.main.feria;

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
				System.out.println(familiar.size());
				break;
			case 3:
				System.out.println(feria.mostrarCasetasDistrito());
				break;
			case 4:
				System.out.println(feria.mostrarCasetasOtras());
				break;
			case 5:
				System.out.println(feria.mostrarCallesFamiliar());
				break;
			case 6:
				System.out.println(feria.mostrarCallesDistrito());
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
		System.out.println("1. Mostrar todas las casetas existentes en una calle.\n"
				+ "2. Mostrar todas las casetas de tipo familiar.\n"
				+ "3. Mostrar todas las casetas de tipo Distrito\n "
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos.\n "
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen.\n "
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen.\n "
				+ "7. Eliminar una caseta.\n" + "8. Salir.");
	}
}
