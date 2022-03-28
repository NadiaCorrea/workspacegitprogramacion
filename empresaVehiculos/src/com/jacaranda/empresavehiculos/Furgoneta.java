package com.jacaranda.empresavehiculos;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo {
	private final double PRECIO_PESO = 0.5;
	private double pma;

	public Furgoneta(String matricula, String gama, LocalDate fechaSalida, double pma) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		if (pma <= 0) {
			throw new VehiculoException("El pma debes ser un valor positivo mayor que 0.");
		} else {
			this.pma = pma;
		}
	}

	public double getPma() {
		return pma;
	}

	public void setPma(double pma) throws VehiculoException {
		if (pma <= 0) {
			throw new VehiculoException("El pma debes ser un valor positivo mayor que 0.");
		} else {
			this.pma = pma;
		}
	}

	public double getPRECIO_PESO() {
		return PRECIO_PESO;
	}

	// al precio base se le a�ade 0,5 euros * PMA (peso m�ximo autorizado)
	@Override
	public double getPrecio() {

		return super.getPrecio() + (0.5 * this.pma);
	}

	// Te falta el toString
	@Override
	public String toString() {
		return "Furgoneta [PRECIO_PESO=" + PRECIO_PESO + ", pma=" + pma + super.toString() + "]";
	}

}
