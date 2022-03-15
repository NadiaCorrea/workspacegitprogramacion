package com.jacaranda.notas;

import java.time.LocalDateTime;

public class Bloc {

	private static final int NUMERO_NOTAS_MAXIMA = 10;
	private int numNotas;
	private String nombre;
	private Nota[] arrayNotas;

	public Bloc(String nombre) {
		super();
		this.numNotas = 0;
		this.nombre = nombre;
		this.arrayNotas = new Nota[NUMERO_NOTAS_MAXIMA];
	}

	public String getNota(int posicion) throws BlocException {
		String result;

		if (posicion < 0 || posicion > NUMERO_NOTAS_MAXIMA) {
			throw new BlocException("Posición de nota incorrecta.");
		} else {
			result = this.arrayNotas[posicion].getTexto();
		}
		return result;
	}

	public void updateNota(int num, String texto) {

	}

	public void addNota(String descripcion) throws BlocException {
		if (numNotas == NUMERO_NOTAS_MAXIMA) {
			throw new BlocException("No se puede añadir nota. Máximo de notas alcanzadas.");
		} else {
			arrayNotas[numNotas] = new Nota(descripcion);
			numNotas = numNotas + 1;
		}
	}

	public void addNota(String descripcion, LocalDateTime fechaAlarma, boolean activado) throws BlocException {
		if (numNotas == NUMERO_NOTAS_MAXIMA)
			throw new BlocException("Máximo de notas alcanzadas.");

		try {
			arrayNotas[numNotas] = new NotaAlarma(descripcion, fechaAlarma, activado);
			numNotas = numNotas + 1;

		} catch (NotaAlarmaException e) {
			// TODO: handle exception
			throw new BlocException("Error al crear la nota con alarma. Compruebe los valores");

		}
	}

	
	
	
	
}
