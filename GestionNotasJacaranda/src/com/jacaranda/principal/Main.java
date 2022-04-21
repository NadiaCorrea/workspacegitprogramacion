package com.jacaranda.principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listaAlumnos = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNotas = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;

		do {
			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				for (Nota nota : listaNotas) {
					System.out.println(nota);
				}
				break;
			case 5:
				for (Alumnado alu : listaAlumnos) {
					System.out.println(alu);
				}
				break;
			default:
				System.out.println("OPción no permitida");
				break;
			}
		} while (opc != 5);

	}

	public static void muestraMenu() {
		System.out.println("1. Alta alumnado \n" + "2. Alta modulo\n" + "3. Registrar nota\n"
				+ "4. Listar notas de todos los alumnos\n" + "5. salir");
	}

}
