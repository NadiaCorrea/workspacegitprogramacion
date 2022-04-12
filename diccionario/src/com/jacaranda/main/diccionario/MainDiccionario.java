package com.jacaranda.main.diccionario;

import com.jacaranda.diccionario.Diccionario;
import com.jacaranda.diccionario.DiccionarioException;
import com.jacaranda.palabra.Palabra;
import com.jacaranda.palabras.empiezan.PalabraEmpiezanException;
import com.jacaranda.palabras.empiezan.PalabrasEmpiezan;

public class MainDiccionario {

	public static void main(String[] args) {
		PalabrasEmpiezan letra1;
		PalabrasEmpiezan letra2;
		PalabrasEmpiezan letra3;
		Palabra p1;
		Palabra p2;
		Diccionario dic1;

		try {

			letra1 = new PalabrasEmpiezan('a');
			letra2 = new PalabrasEmpiezan('B');
			letra3 = new PalabrasEmpiezan('c');

//			letra1.addPalabra("Banco", "Asiento");
			letra1.addPalabra("Aval", "persona");
			System.out.println(letra1.toString());

			letra2.addPalabra("Banco", "asiento");
			letra2.addPalabra("Banco", "conjunto peces");
			System.out.println(letra2.toString());
			System.out.println("esto " + letra2.obtenerSignificados("banco"));

			letra3.addPalabra("Casa", "hogar");
			letra3.addPalabra("Casa", "inicio");
			System.out.println(letra3.toString());

			dic1 = new Diccionario();

			dic1.addDiccionario("Dominó", "juego de mesa");
			dic1.addDiccionario("Añil", "color");
			dic1.addDiccionario("Aval", "persona");
			dic1.addDiccionario("Banco", "conjunto peces");
			dic1.addDiccionario("Banco", "asiento");

			dic1.addDiccionario("Banco", "entidad financiera");
			dic1.addDiccionario("casa", "hogar");

			dic1.addDiccionario("Casa", "inicio");
			System.out.println(dic1.toString());

			System.out.println(dic1.buscarPalabra("banco"));

//			dic1.borrarPalabra("añil");
//			System.out.println("despues de borrar " + dic1.toString());

			System.out.println(dic1.listarDiccionario("a"));
//			dic1.addDiccionario("casa", "hogar");

//			letra3.addPalabra("Casa", "hogar");
//			letra3.borrarPalabra("Aval");
//			letra3.borrarPalabra("Abaco");

//			p1 = new Palabra("abaco");
//			p2.addSignificado("entidad financiera");
//			p2.addSignificado("asiento");

//			System.out.println("listado de significados\n" + p2.toString());
//			System.out.println(p1.toString());

//			p2.delSignificado("asiento");
//			p2.delSignificado("abaco");

//			System.out.println("DespuÃ©s de borrar\n" + p2.toString());
//			System.out.println(p2.getInicialPalabra());

		} catch (PalabraEmpiezanException | DiccionarioException e) {
			System.out.println(e.getMessage());
		}

	}

// 1. Añadir palabra 2. Buscar palabra en diccionario 3. Borrar una palabra del diccionario 4. Listado de palabras que empiecen por 5. Salir

}
