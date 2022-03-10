package com.jacaranda.baraja;

import java.util.Arrays;

public abstract class Baraja implements Repartible {
	protected int numCartas;
	private int siguiente;
	protected Carta[] arrayCartas;

	public Baraja(int numCartas) {
		this.numCartas = numCartas;
		this.siguiente = 0;
		this.arrayCartas = new Carta[numCartas];
		barajar(numCartas);
	}

	public void barajar(int numCartas) {

		int i = 0;
		while (i < numCartas) {
			Carta carta = new Carta(generaNumero(), generaPalo());
			boolean encontrado = false;
			for (int j = 0; j < i && encontrado == false; j = j + 1) {
				if (arrayCartas[j].equals(carta)) {
					encontrado = true;
				}
			}
			if (encontrado == false) {
				arrayCartas[i] = carta;
				i = i + 1;
			}

		}
		siguiente = 0;
	}
	
	protected abstract String generaPalo();

	private int generaNumero() {
		int num;
		num = (int) (Math.random()*(this.numCartas/4)) + 1;
		return num;
	}

	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", siguiente=" + siguiente + ", arrayCartas="
				+ Arrays.toString(arrayCartas) + "]";
	}

	@Override
	public Carta getSiguiente() {
		Carta resultado;
		resultado = new Carta(arrayCartas[siguiente].getNumber(),arrayCartas[siguiente].getPalo());
		siguiente = siguiente + 1;
		return resultado;
	}
	
	

}
