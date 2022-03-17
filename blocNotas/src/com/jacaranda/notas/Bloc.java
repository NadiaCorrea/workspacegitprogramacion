package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

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

	public void updateNota(int num, String texto) throws BlocException {
		if (num > this.numNotas || num < 0) {
			throw new BlocException("Nota no existe.");
		} else {
			arrayNotas[num].setTexto(texto);
		}
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
			throw new BlocException("MÃ¡ximo de notas alcanzadas.");

		try {
			arrayNotas[numNotas] = new NotaAlarma(descripcion, fechaAlarma, activado);
			numNotas = numNotas + 1;

		} catch (NotaAlarmaException e) {
			// TODO: handle exception
			throw new BlocException("Error al crear la nota con alarma. Compruebe los valores");
		}
	}

	public void activa(int posicion) throws BlocException {
		if (posicion > this.numNotas || posicion < 0) {
			throw new BlocException("Nota no existe.");
		} else {
			if (arrayNotas[posicion] instanceof NotaAlarma) {
				((NotaAlarma) arrayNotas[posicion]).activar();
			} else {
				throw new BlocException("Imposible activar una nota simple.");
			}
		}
	}

	public void desactiva(int posicion) throws BlocException {
		if (posicion > this.numNotas || posicion < 0) {
			throw new BlocException("Nota no existe.");
		} else {
			if (arrayNotas[posicion] instanceof NotaAlarma) {
				((NotaAlarma) arrayNotas[posicion]).desactivar();
			} else {
				throw new BlocException("Imposible activar una nota simple.");
			}
		}
	}

	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloc other = (Bloc) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {

		StringBuilder resultado = new StringBuilder("Nombre del bloc: ");

		resultado.append(this.nombre + "\n");

		for (int i = 0; i < numNotas; i = i + 1) {
			resultado.append(arrayNotas[i].toString() + "\n");
		}

		return resultado.toString();
	}

	public String ordenaBloc() {
		Nota[] aux = new Nota[numNotas];

		for (int i = 0; i < numNotas; i = i + 1) {
			aux[i] = arrayNotas[i];
		}
		Arrays.sort(aux);

		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < numNotas - 1; i = i + 1) {
			resultado.append(aux[i].toString() + ", ");
		}

		resultado.append(aux[numNotas - 1].toString());

		return resultado.toString();
	}

}
