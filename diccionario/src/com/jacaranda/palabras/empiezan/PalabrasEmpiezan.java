package com.jacaranda.palabras.empiezan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.jacaranda.palabra.Palabra;
import com.jacaranda.palabra.PalabraException;

public class PalabrasEmpiezan implements Comparable<PalabrasEmpiezan> {
	Character letra;
	List<Palabra> palabras;

	public PalabrasEmpiezan(Character letra) throws PalabraEmpiezanException {
		super();
		setLetra(letra);
		this.palabras = new LinkedList<>();
	}

	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) throws PalabraEmpiezanException {

		if (letra == null) {
			throw new PalabraEmpiezanException("La letra no puede ser nula.");
		} else {
			this.letra = Character.toUpperCase(letra);
		}

	}

	// addPalabra

	public void addPalabra(String palabra, String significado) throws PalabraEmpiezanException {
		Palabra palabraAux = null;
		int position;
		Character letraInicial;

		try {
			palabraAux = new Palabra(palabra, significado);
			position = this.palabras.indexOf(palabraAux);
			letraInicial = palabraAux.getInicialPalabra();

			if (!this.getLetra().equals(Character.toUpperCase(letraInicial))) {
				throw new PalabraEmpiezanException("La palabra no empieza por la letra debida.");
			} else {
				if (position < 0) {
					this.palabras.add(palabraAux);
				} else {
					Palabra palabraExistente = this.palabras.get(position);
					palabraExistente.addSignificado(significado);
				}

			}

		} catch (PalabraException e) {
			throw new PalabraEmpiezanException(e.getMessage());
		}
	}

	// delPalabra

	public void borrarPalabra(String palabra) throws PalabraEmpiezanException {
		Palabra palabraAux = null;
		int position;

		try {
			palabraAux = new Palabra(palabra);
			position = this.palabras.indexOf(palabraAux);

			if (position >= 0) {
				this.palabras.remove(position);
			} else {
				throw new PalabraEmpiezanException("La palabra introducida no existe.");
			}

		} catch (PalabraException e) {
			throw new PalabraEmpiezanException(e.getMessage());
		}

	}

	// Método para obtener los significados

	public Set<String> obtenerSignificados(String palabra) throws PalabraEmpiezanException {
		Set<String> resultado = null;
		int position;
		try {
			Palabra palabraAux = new Palabra(palabra);
			position = this.palabras.indexOf(palabraAux);

			if (position > -1) {
				resultado = this.palabras.get(position).getSignificados();
			} else {
				throw new PalabraEmpiezanException("No se encontrado la palabra.");
			}
		} catch (PalabraException e) {
			throw new PalabraEmpiezanException("Error. " + e.getMessage());
		}

		return resultado;

	}

	// buscar palabras que empiezan x texto

	public String buscarTexto(String texto) {
		List<String> listaAux = new ArrayList<>();

		Iterator<Palabra> iterator = palabras.iterator();
		Palabra iPalabra;
		while (iterator.hasNext()) {
			iPalabra = iterator.next();

			if (iPalabra.getPalabra().toLowerCase().startsWith(texto.toLowerCase())) {
				listaAux.add(iPalabra.getPalabra());
			}

		}
		Collections.sort(listaAux);

		return listaAux.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabrasEmpiezan other = (PalabrasEmpiezan) obj;
		return Objects.equals(letra, other.letra);
	}

	@Override
	public String toString() {
		return "[Letra=" + letra + ", Palabras=" + palabras + "]";
	}

	@Override
	public int compareTo(PalabrasEmpiezan o) {
		int resultado;
		if (o == null) {
			resultado = -1;
		} else {
			resultado = this.getLetra().compareTo(o.getLetra());
		}

		return resultado;
	}

}
