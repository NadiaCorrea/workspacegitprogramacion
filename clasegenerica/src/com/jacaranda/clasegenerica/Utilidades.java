package com.jacaranda.clasegenerica;

public class Utilidades {
	public static <T> void volcarArray(T[] origen, T[] destino) {

		int tamano = Math.min(origen.length, destino.length);

		for (int i = 0; i < tamano; i++) {
			destino[i] = origen[i];
		}
	}

}
