package com.jacaranda.main.diccionario;

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

			letra3.addPalabra("Casa", "hogar");
			letra3.addPalabra("Casa", "inicio");
			System.out.println(letra3.toString());
//			letra3.addPalabra("Casa", "hogar");
			letra3.borrarPalabra("Aval");
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

		} catch (PalabraEmpiezanException e) {
			System.out.println(e.getMessage());
		}

	}

	// 1. Añadir palabra. Se solicitará a palabra y su significado. Si la palabra ya
	// tenía un significado se guardará este nuevo significado con los anteriores 2.
	// Buscar palabra en diccionario: Se solicitará la palabra y se mostrarán todos
	// sus significados 3. Borrar una palabra del diccionario: Se solicitará la
	// palabra y se borrará, con todos sus significados. 4. Listado de palabras que
	// empiecen por ... Se solicitará una cadena y se mostrará un listado de
	// palabras ordenado alfabéticamente que comiencen por esa cadena. 5. Salir

}
