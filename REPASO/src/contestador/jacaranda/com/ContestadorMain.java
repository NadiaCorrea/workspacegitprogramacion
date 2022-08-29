package contestador.jacaranda.com;

import java.util.Scanner;

public class ContestadorMain {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opcionPrincipal;
		int mensaje;
		int opcionMensaje;
		String nuevoMensaje;
		Contestador contestador = new Contestador();

		do {

			menuPrincipal();
			opcionPrincipal = leerEntero("¿Qué opción deseas realizar?");

			switch (opcionPrincipal) {
			case 1:
				System.out.println("Hay " + contestador.getNumMensajes() + " mensaje(s).");
				break;
			case 2:
				mensaje = leerEntero("¿Cuál mensaje quiere consultar? 1 ó 2: ");
				opcionMensaje = leerEntero("¿Qué quieres hacer?\n" + "1. Oir\n" + "2.Borrar");

				switch (opcionMensaje) {
				case 1:
					System.out.println(contestador.listenMensaje(mensaje));
					break;
				case 2:
					System.out.println(contestador.deleteMensaje(mensaje));
					break;

				default:
					System.out.println("La opción seleccionada no es válida.");
					break;
				}

				break;
			case 3:
				if (contestador.getNumMensajes() == 2) {
					System.out.println("Buzón completo.");
				} else {
					nuevoMensaje = leerCadena("Introduce el mensaje: ");
					System.out.println(contestador.addMensaje(nuevoMensaje));
				}
				break;
			case 4:
				System.out.println(contestador.deleteAll());
				break;
			case 5:
				System.out.println("¡Adiós!");
				break;

			default:
				System.out.println("La opción seleccionada no es válida.");
				break;
			}

		} while (opcionPrincipal != 5);

	}

	public static void menuPrincipal() {
		System.out.println("1. Consultar número de mensajes\n" + "2. Consultar mensaje\n" + "3. Añadir mensaje\n"
				+ "4. Borrar todos los mensajes\n" + "5. Salir");
	}

	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
