package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.List;

import com.jacaranda.palabra.Palabra;
import com.jacaranda.palabra.PalabraException;
import com.jacaranda.palabras.empiezan.PalabraEmpiezanException;
import com.jacaranda.palabras.empiezan.PalabrasEmpiezan;

public class Diccionario {

	private List<PalabrasEmpiezan> listaLetras;

	public Diccionario() {
		super();
		this.listaLetras = new ArrayList<>();
	}

	public void addDiccionario(String palabra, String significado) throws DiccionarioException {
		PalabrasEmpiezan nueva;
		try {
			nueva = new PalabrasEmpiezan(palabra.charAt(0));
			if (listaLetras.contains(nueva)) {
				// usar un indexOf para buscar
			} else {
				nueva.addPalabra(palabra, significado);

			}

		} catch (PalabraEmpiezanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Borrar una palabra del diccionario: Se solicitar� la palabra y se borrar�,
	// con todos sus significados.

	// Buscar palabra se solicitar� la palabra y
	// se mostrar�n todos sus significados

	public void buscarPalabra(String palabra) throws PalabraException {
		Palabra palabraAux = new Palabra(palabra, palabra);

	}

	public String listarDiccionario() {
		StringBuilder resultado = new StringBuilder();

		return resultado.toString();
	}
}
