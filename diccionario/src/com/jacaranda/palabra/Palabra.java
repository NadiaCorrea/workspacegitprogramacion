package com.jacaranda.palabra;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Palabra {
	private String palabra;
	private Set<String> significados;

	public Palabra(String palabra) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados = new HashSet<>();
	}

	public Palabra(String palabra, String significado) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados = new HashSet<>();
		if (significado == null || significado == "") {
			throw new PalabraException("El significado no puede ser nulo.");
		} else {
			this.significados.add(significado);
		}

	}

	public String getPalabra() {
		return palabra;
	}

	private void setPalabra(String palabra) throws PalabraException {
		if (palabra == null || palabra == "") {
			throw new PalabraException("La palabra no puede ser nula.");
		} else {
			this.palabra = palabra;
		}
	}

	public Set<String> getSignificados() {
		return significados;
	}

	public void addSignificado(String newSignificado) throws PalabraException {
		if (newSignificado == null || newSignificado == "") {
			throw new PalabraException("No se puede añadir un significado nulo o vacío.");
		} else {
			boolean encontrado = false;
			String iSignificado;
			Iterator<String> iterador = significados.iterator();

			while (iterador.hasNext() && !encontrado) {
				iSignificado = iterador.next();
				if (iSignificado.equalsIgnoreCase(newSignificado)) {
					encontrado = true;
				}
			}

			if (encontrado == true) {
				throw new PalabraException("El significado ya existe.");
			} else {
				this.significados.add(newSignificado);
			}
		}
	}

	public void delSignificado(String significado) throws PalabraException {

		if (significado == null || significado == "") {
			throw new PalabraException("No se puede borrar un significado nulo o vacío.");
		} else {

			boolean encontrado = false;
			String iSignificado;
			Iterator<String> iterador = significados.iterator();

			while (iterador.hasNext() && !encontrado) {
				iSignificado = iterador.next();

				if (iSignificado.equalsIgnoreCase(significado)) {
					significados.remove(significado);
					encontrado = true;
				}
			}

			if (encontrado == false) {
				throw new PalabraException("No se encontrado el significado a borrar.");
			}

		}

	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", significados=" + significados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}

}
