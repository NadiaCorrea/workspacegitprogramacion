package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
	}

	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.numeroHabitantes = numeroHabitantes;
		this.rentaPerCapita = rentaPerCapita;
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	// El código debe tener una longitud de 5 carácteres y deben ser caracteres
	// numéricos. Se deberá lanzar una exception.
	private void setCodigo(String codigo) throws PuebloException {

		if (codigo.length() < 5) {
			throw new PuebloException("La longitud del código no es correcta.");
		} else {
			for (int i = 0; i < codigo.length() - 1; i = i + 1) {
				if (Character.codigo.chartAt(i).isDigit()) {

				}
			}

		}

		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	// the numero habitantes. Si es negativo lanzar una exception
	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	// the renta per capita. Si es negativo lanzar una exception
	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}

	// Si es negativo lanzar una exception
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

	@Override
	public int compareTo(Pueblo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
