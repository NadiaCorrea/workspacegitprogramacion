package com.jacaranda.versiondosdiccionario;

import java.util.HashMap;
import java.util.HashSet;

public class DiccionarioVersionDos {

	private HashMap<String, HashSet<String>> entradas;

	public DiccionarioVersionDos() {
		super();
		this.entradas = new HashMap<>();

	}

	public boolean addEntrada(String palabra, String significado) {
		boolean resultado = true;

		// tengo que averiguar si la palabra está en el diccionario

		HashSet<String> valor = this.entradas.get(palabra);

		if (valor == null) {
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if (this.entradas.put(palabra, significados) == null) {
				resultado = false;
			}

		} else { // en el caso q ya existiese
			resultado = valor.add(significado);
		}

		return resultado;
	}

	public boolean borrarEntrada(String palabra) {
		boolean resultado = false;

		if (this.entradas.containsKey(palabra)) {
			this.entradas.remove(palabra);
			resultado = true;
		}

		// para hacerlo más simple
		// resultado = this.entradas.remove(palabra);

		return resultado;

	}

	public boolean borrarSignificadoEntrada(String palabra, String significado) {
		boolean resultado = false;

		if (this.entradas.containsKey(palabra)) {
			HashSet<String> valor = this.entradas.get(palabra);
			if (valor.contains(significado)) {
				valor.remove(significado);
				resultado = true;
			}
		}

		// para hacerlo más simple
		// resultado = valor.remove(significado);

		return resultado;
	}

	// método que busque en el map una cadena. Usar un iterator

	@Override
	public String toString() {
		return "DiccionarioVersionDos [entradas=" + entradas + "]";
	}

}
