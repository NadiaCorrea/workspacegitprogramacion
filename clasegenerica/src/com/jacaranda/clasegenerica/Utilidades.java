package com.jacaranda.clasegenerica;

public class Utilidades {
	public static <T> void volcarArray(T[] origen, T[] destino) {

		int tamano = Math.min(origen.length, destino.length);

		for (int i = 0; i < tamano; i++) {
			destino[i] = origen[i];
		}
	}

	public static <P> String toString(P[] array) {
		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i <= array.length - 1; i = i + 1) {
			resultado.append(array[i] + "\n");
		}
		return resultado.toString();

	}

}
