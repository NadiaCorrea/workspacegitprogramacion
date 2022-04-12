package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		PalabrasEmpiezan nuevaLetra;
		int positionLetra;

		try {
			nuevaLetra = new PalabrasEmpiezan(palabra.charAt(0));
			positionLetra = this.listaLetras.indexOf(nuevaLetra);

			if (positionLetra > -1) {
				this.listaLetras.get(positionLetra).addPalabra(palabra, significado);

			} else {
				nuevaLetra.addPalabra(palabra, significado);
				this.listaLetras.add(nuevaLetra);
			}

		} catch (PalabraEmpiezanException e) {
			throw new DiccionarioException("No se ha podido añadir la palabra. " + e.getMessage());
		}

	}

	// Borrar una palabra del diccionario: Se solicitará la palabra y se borrará,
	// con todos sus significados.

	public void borrarPalabra(String palabra) throws DiccionarioException {
		Character letraAux = Character.toUpperCase(palabra.charAt(0));
		try {
			PalabrasEmpiezan listaAux = new PalabrasEmpiezan(letraAux);
			int position = this.listaLetras.indexOf(listaAux);

			if (position > -1) {
				this.listaLetras.get(position).borrarPalabra(palabra);
			}
		} catch (PalabraEmpiezanException e) {
			throw new DiccionarioException("Error. " + e.getMessage());
		}

	}

	// Buscar palabra se solicitará la palabra y
	// se mostrarán todos sus significados

	public String buscarPalabra(String palabra) throws DiccionarioException {
		try {

			Palabra palabraAux = new Palabra(palabra);
			Character letraInicial = Character.toUpperCase(palabraAux.getInicialPalabra());
			PalabrasEmpiezan listaAux = new PalabrasEmpiezan(letraInicial);

			String resultado;

			int posicionLetra = this.listaLetras.indexOf(listaAux);

			if (posicionLetra > -1) {

				resultado = this.listaLetras.get(posicionLetra).obtenerSignificados(palabra).toString();
			} else {
				resultado = "No existe la palabra.";
			}

			return resultado;
		} catch (PalabraEmpiezanException | PalabraException e) {
			throw new DiccionarioException("Error. " + e.getMessage());
		}

	}
	// Listado de palabras que empiecen por ...
	// Se solicitará una cadena y se mostrará un listado de palabras
	// ordenado alfabéticamente que comiencen por esa cadena.

//	aval, avion, 

	public String listarDiccionario(String texto) throws DiccionarioException {
		String resultado;
		try {
			Character letraInicial = Character.toUpperCase(texto.charAt(0));
			PalabrasEmpiezan listaAux = new PalabrasEmpiezan(letraInicial);
			int posicionLetra = this.listaLetras.indexOf(listaAux);

			if (posicionLetra > -1) {
				resultado = this.listaLetras.get(posicionLetra).buscarTexto(texto);
			} else {
				throw new DiccionarioException("Error. No se ha encontrado el texto.");
			}

		} catch (PalabraEmpiezanException e) {
			throw new DiccionarioException("Error. " + e.getMessage());
		}

		return resultado;
	}

	@Override
	public String toString() {
		String resultado = "";
		Collections.sort(this.listaLetras);
		Iterator<PalabrasEmpiezan> iterator = listaLetras.iterator();
		PalabrasEmpiezan iLista;

		while (iterator.hasNext()) {
			iLista = iterator.next();
			resultado = resultado + iLista.toString() + " ";
		}

		return resultado;
	}

}
