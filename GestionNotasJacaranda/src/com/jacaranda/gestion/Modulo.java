package com.jacaranda.gestion;

import java.util.Objects;

public class Modulo {
	private String nombre;
	private int codigo;
	private static int codigoSiguiente = 1;
	private int numHorasSemanales;
	private int creditos;

	public Modulo(String nombre, int numHorasSemanales, int creditos) {
		super();
		this.nombre = nombre;
		this.numHorasSemanales = numHorasSemanales;
		this.creditos = creditos;
		setCodigo(codigoSiguiente);

	}

	public int getNumHorasSemanales() {
		return numHorasSemanales;
	}

	public void setNumHorasSemanales(int numHorasSemanales) {
		this.numHorasSemanales = numHorasSemanales;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	private int setCodigo(int codigo) {
		this.codigo = codigoSiguiente;
		this.codigoSiguiente += 1;
		return this.codigo;

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
		Modulo other = (Modulo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Modulos [nombre=" + nombre + ", codigo=" + codigo + ", numHorasSemanales=" + numHorasSemanales
				+ ", creditos=" + creditos + "]";
	}

	public String getInfoModulo() {
		return this.codigo + ", " + this.nombre + ", " + this.numHorasSemanales + ", " + this.creditos;

	}
}
