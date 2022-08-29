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
			opcionPrincipal = leerEntero("�Qu� opci�n deseas realizar?");

			switch (opcionPrincipal) {
			case 1:
				System.out.println("Hay " + contestador.getNumMensajes() + " mensaje(s).");
				break;
			case 2:
				mensaje = leerEntero("�Cu�l mensaje quiere consultar? 1 � 2: ");
				opcionMensaje = leerEntero("�Qu� quieres hacer?\n" + "1. Oir\n" + "2.Borrar");

				switch (opcionMensaje) {
				case 1:
					System.out.println(contestador.listenMensaje(mensaje));
					break;
				case 2:
					System.out.println(contestador.deleteMensaje(mensaje));
					break;

				default:
					System.out.println("La opci�n seleccionada no es v�lida.");
					break;
				}

				break;
			case 3:
				if (contestador.getNumMensajes() == 2) {
					System.out.println("Buz�n completo.");
				} else {
					nuevoMensaje = leerCadena("Introduce el mensaje: ");
					System.out.println(contestador.addMensaje(nuevoMensaje));
				}
				break;
			case 4:
				System.out.println(contestador.deleteAll());
				break;
			case 5:
				System.out.println("�Adi�s!");
				break;

			default:
				System.out.println("La opci�n seleccionada no es v�lida.");
				break;
			}

		} while (opcionPrincipal != 5);

	}

	public static void menuPrincipal() {
		System.out.println("1. Consultar n�mero de mensajes\n" + "2. Consultar mensaje\n" + "3. A�adir mensaje\n"
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
