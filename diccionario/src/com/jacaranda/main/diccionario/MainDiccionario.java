package com.jacaranda.main.diccionario;

import com.jacaranda.palabra.Palabra;
import com.jacaranda.palabra.PalabraException;

public class MainDiccionario {

	public static void main(String[] args) {
		Palabra p1;
		Palabra p2;

		try {
			p1 = new Palabra("abaco");
			p2 = new Palabra("Banco", "asiento");

			p2.addSignificado("entidad financiera");
//			p2.addSignificado("asiento");

			System.out.println("listado de significados\n" + p2.toString());
			System.out.println(p1.toString());

			p2.delSignificado("asiento");
//			p2.delSignificado("abaco");

			System.out.println("Después de borrar\n" + p2.toString());

		} catch (PalabraException e) {
			System.out.println(e.getMessage());
		}

	}

}
