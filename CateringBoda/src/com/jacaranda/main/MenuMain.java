package com.jacaranda.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jacaranda.menu.IntoleranteLactosa;
import com.jacaranda.menu.Menu;
import com.jacaranda.menu.MenuException;
import com.jacaranda.menu.SinRestricciones;
import com.jacaranda.menu.Vegano;
import com.jacaranda.plato.Plato;

public class MenuMain {

	private static Scanner teclado = new Scanner(System.in);

	private static List<Menu> menus = new ArrayList<>();

	public static void main(String[] args) {
		int opcion = -1;
		do {
			menu();
			opcion = leerEntero("Selecciona una opción: ");

			switch (opcion) {
			case 1:
				String resultadoMenus = mostrarMenus();
				System.out.println(resultadoMenus + "\n");
				break;
			case 2:
				try {
					crearMenu();
					System.out.println("Menú creado correctamente\n");
				} catch (MenuException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					eliminarMenu();
					System.out.println("Menú eliminado correctamente\n");
				} catch (MenuException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					servirPlato();
					System.out.println("Plato servido correctamente\n");
				} catch (MenuException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					eliminarPlato();
					System.out.println("Plato eliminado correctamente\n");
				} catch (MenuException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				break;
			default:
				System.out.println("Opción incorrecta\n");
				break;
			}
		} while (opcion != 6);
	}

	public static void menu() {
		System.out.println(
				"1. Listar menús\n2. Crear menú\n3. Eliminar menú\n4. Servir plato\n5. Eliminar plato\n6. Salir");
	}

	public static String mostrarMenus() {
		String resultado = "No hay menús que mostrar";

		if (!menus.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			Iterator<Menu> menuIterator = menus.iterator();
			Menu iMenu;
			while (menuIterator.hasNext()) {
				iMenu = menuIterator.next();
				sb.append("Menú: " + iMenu.getNombre() + "\n");
				List<Plato> platosOrdenados = iMenu.ordenarMenu();
				sb.append("\tPlatos:\n");
				if (!platosOrdenados.isEmpty()) {
					Iterator<Plato> platoIterator = platosOrdenados.iterator();
					Plato iPlato;
					while (platoIterator.hasNext()) {
						iPlato = platoIterator.next();
						sb.append("\t\t" + iPlato.getNombre() + " (" + iPlato.getDescripcion() + ")" + "\n");
					}
				} else {
					sb.append("\t\tNo hay platos que mostrar\n");
				}
			}
			resultado = sb.toString();
		}

		return resultado;
	}

	public static void crearMenu() throws MenuException {
		System.out.println("1. Sin restricciones\n2. Vegano\n3. Intolerante a lactosa");

		int opcion = leerEntero("Selecciona una opción: ");
		String nombre = leerCadena("Introduce un nombre de menú: ");
		Menu menu;

		switch (opcion) {
		case 1:
			menu = new SinRestricciones(nombre);

			if (!menus.contains(menu)) {
				menus.add(menu);
			} else {
				throw new MenuException("Ya existe el menú");
			}
			break;
		case 2:
			menu = new Vegano(nombre);

			if (!menus.contains(menu)) {
				menus.add(menu);
			} else {
				throw new MenuException("Ya existe el menú");
			}
			break;
		case 3:
			double lactosa = leerReal("Introduce el límite de lactosa: ");
			menu = new IntoleranteLactosa(nombre, lactosa);

			if (!menus.contains(menu)) {
				menus.add(menu);
			} else {
				throw new MenuException("Ya existe el menú");
			}
			break;
		default:
			System.out.println("Opción incorrecta");
			break;
		}
	}

	public static void eliminarMenu() throws MenuException {
		if (!menus.isEmpty()) {
			seleccionarMenu();
			int codMenu = leerEntero("Selecciona un menú: ");

			Iterator<Menu> menuIterator = menus.iterator();
			Menu iMenu;
			boolean enc = false;
			while (!enc && menuIterator.hasNext()) {
				iMenu = menuIterator.next();
				if (iMenu.getCodigo() == codMenu) {
					menuIterator.remove();
					enc = true;
				}
			}

			if (!enc) {
				throw new MenuException("El menú seleccionado no existe");
			}
		} else {
			throw new MenuException("No hay menús que eliminar");
		}
	}

	public static void servirPlato() throws MenuException {
		if (!menus.isEmpty()) {
			seleccionarMenu();
			int codMenu = leerEntero("Selecciona un menú: ");

			Iterator<Menu> menuIterator = menus.iterator();
			Menu iMenu;
			Menu menuSeleccionado = null;
			while (menuSeleccionado == null && menuIterator.hasNext()) {
				iMenu = menuIterator.next();
				if (iMenu.getCodigo() == codMenu) {
					menuSeleccionado = iMenu;
				}
			}

			if (menuSeleccionado == null) {
				throw new MenuException("El menu seleccionado no existe");
			} else {
				String nombre = leerCadena("Introduce el nombre del plato: ");
				String descripcion = leerCadena("Introduce la descripción del plato: ");
				int orden = leerEntero("Introduce el orden del plato: ");
				double lactosa = leerReal("Introduce la cantidad de lactosa del plato: ");
				String[] gruposAlimenticios = new String[3];
				int numGruposAlimenticios = 0;
				int opcion = -1;
				do {
					System.out.println("1. Carne\n2. Pescado\n3. Verdura\n4. Cereales\n5. No aÃ±adir mÃ¡s");
					opcion = leerEntero("Selecciona un grupo alimenticio: ");

					switch (opcion) {
					case 1:
						gruposAlimenticios[numGruposAlimenticios] = "CARNE";
						numGruposAlimenticios += 1;
						break;
					case 2:
						gruposAlimenticios[numGruposAlimenticios] = "PESCADO";
						numGruposAlimenticios += 1;
						break;
					case 3:
						gruposAlimenticios[numGruposAlimenticios] = "VERDURA";
						numGruposAlimenticios += 1;
						break;
					case 4:
						gruposAlimenticios[numGruposAlimenticios] = "CEREALES";
						numGruposAlimenticios += 1;
						break;
					case 5:
						break;
					default:
						System.out.println("Grupo alimenticio incorrecto.");
						break;
					}
				} while (opcion != 5 && numGruposAlimenticios < 3);

				menuSeleccionado.servirPlato(nombre, descripcion, orden, lactosa, gruposAlimenticios);
			}
		} else {
			throw new MenuException("No hay menús en los que servir el plato");
		}
	}

	public static void eliminarPlato() throws MenuException {
		if (!menus.isEmpty()) {
			seleccionarMenu();
			int codMenu = leerEntero("Selecciona un menú: ");

			Iterator<Menu> menuIterator = menus.iterator();
			Menu iMenu;
			Menu menuSeleccionado = null;
			while (menuSeleccionado == null && menuIterator.hasNext()) {
				iMenu = menuIterator.next();
				if (iMenu.getCodigo() == codMenu) {
					menuSeleccionado = iMenu;
				}
			}

			if (menuSeleccionado == null) {
				throw new MenuException("El menu seleccionado no existe");
			} else {
				if (menuSeleccionado.getNumPlatos() > 0) {
					seleccionarPlato(menuSeleccionado);
					int codPlato = leerEntero("Seleccionar un plato: ");

					menuSeleccionado.eliminarPlato(codPlato);
				} else {
					throw new MenuException("No hay platos que eliminar");
				}
			}
		} else {
			throw new MenuException("No hay menús en los que eliminar el plato");
		}
	}

	public static void seleccionarMenu() {
		StringBuilder sb = new StringBuilder();
		Iterator<Menu> menuIterator = menus.iterator();
		Menu iMenu;
		while (menuIterator.hasNext()) {
			iMenu = menuIterator.next();
			sb.append(iMenu.getCodigo() + ". " + iMenu.getNombre() + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void seleccionarPlato(Menu menu) {
		StringBuilder sb = new StringBuilder();
		Iterator<Plato> platoIterator = menu.ordenarMenu().iterator();
		Plato iPlato;
		while (platoIterator.hasNext()) {
			iPlato = platoIterator.next();
			sb.append(iPlato.getCodigo() + ". " + iPlato.getNombre() + "\n");
		}
		System.out.println(sb.toString());
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

	public static double leerReal(String texto) {
		double real = -1;
		boolean leido = false;

		do {
			System.out.println(texto);
			real = Double.parseDouble(teclado.nextLine());
			leido = true;
		} while (leido == false);

		return real;
	}

}
