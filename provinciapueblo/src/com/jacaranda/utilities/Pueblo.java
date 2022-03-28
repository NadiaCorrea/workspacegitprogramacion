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
		if (nombre == null) {
			throw new PuebloException("El nombre no puede ser nulo.");
		} else {
			this.nombre = nombre.toUpperCase();
		}
		setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
	}

	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		if (nombre == null) {
			throw new PuebloException("El nombre no puede ser nulo.");
		} else {
			this.nombre = nombre.toUpperCase();
		}
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	// El c�digo debe tener una longitud de 5 car�cteres y deben ser caracteres
	// num�ricos. Se deber� lanzar una exception.

	private void setCodigo(String codigo) throws PuebloException {

		if (codigo.length() != 5) {
			throw new PuebloException("La longitud del c�digo no es correcta.");
		} else {
			boolean encontrado = false;
			for (int i = 0; i < codigo.length() && !encontrado; i = i + 1) {
				if (!Character.isDigit(codigo.charAt(i))) {
					encontrado = true;
				}
			}
			if (encontrado == false) {
				this.codigo = codigo;
			} else {
				throw new PuebloException("El formato del c�digo no es correcto.");
			}
		}

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
	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {

		if (numeroHabitantes < 0) {
			throw new PuebloException("El n�mero de habitantes no puede ser menor que 0.");
		} else {
			this.numeroHabitantes = numeroHabitantes;
		}

	}

	// the renta per capita. Si es negativo lanzar una exception
	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita < 0) {
			throw new PuebloException("La renta per capita no puede ser menor que 0.");
		} else {
			this.rentaPerCapita = rentaPerCapita;
		}
	}

	// Si es negativo lanzar una exception
	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie < 0) {
			throw new PuebloException("La superficie no puede ser menor que 0.");
		} else {
			this.superficie = superficie;
		}

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
		// un pueblo es igual al otro si tienen el mismo código
		int result;

		if (o == null) {
			result = -1;

		} else {
			result = this.getNombre().compareTo(o.getNombre());
		}

		return result;
	}

}
