package com.jaracaranda.combinacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//La clase Combinacion, que almacenará una colección para los números y una
//colección para las dos estrellas. 
import java.util.Objects;

public class Combinacion {
	List<Integer> numeros; // He usado un array list ya que no se necesitaba mantener un orden de los
							// elementos
	List<Integer> estrellas;

	/* Un constructor que reciba los 5 números y las dos estrellas. */

	public Combinacion(int num1, int num2, int num3, int num4, int num5, int est1, int est2)
			throws CombinacionException {
		super();
		setNumeros(num1, num2, num3, num4, num5);
		setEstrellas(est1, est2);
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	private void setNumeros(int num1, int num2, int num3, int num4, int num5) throws CombinacionException {

		this.numeros = new ArrayList<>();

		if ((num1 > 0 && num1 <= 50) && (num2 > 0 && num2 <= 50) && (num3 > 0 && num3 <= 50) && (num4 > 0 && num4 <= 50)
				&& (num5 > 0 && num5 <= 50)) {

			this.numeros.add(num1);
			this.numeros.add(num2);
			this.numeros.add(num3);
			this.numeros.add(num4);
			this.numeros.add(num5);
		} else {
			throw new CombinacionException("La combinación debe ser de números del 1 al 50.");
		}

	}

	public List<Integer> getEstrellas() {
		return estrellas;
	}

	private void setEstrellas(int est1, int est2) throws CombinacionException {

		this.estrellas = new ArrayList<>();

		if ((est1 > 0 && est1 <= 12) && (est2 > 0 && est2 <= 12)) {
			this.estrellas.add(est1);
			this.estrellas.add(est2);
		} else {
			throw new CombinacionException("Las estrellas deben ser números del 1 al 12.");
		}
	}

	/*
	 * Un método que devuelva una cadena con los 5 números con el formato
	 * “2-12-17-28-46”
	 */
	public String numerosToString() {

		StringBuilder resultado = new StringBuilder();

		Iterator<Integer> iterator = this.numeros.iterator();
		int iNumero;

		while (iterator.hasNext()) {
			iNumero = iterator.next();
			resultado.append(iNumero + "-");
		}
		resultado.deleteCharAt(resultado.length() - 1);
		return resultado.toString();
	}

	/*
	 * ○ Un método que devuelva una cadena con las dos estrellas con el formato
	 * “6-10”
	 */

	public String estrellasToString() {
		StringBuilder resultado = new StringBuilder();

		Iterator<Integer> iterator = this.estrellas.iterator();
		int iEstrella;

		while (iterator.hasNext()) {
			iEstrella = iterator.next();
			resultado.append(iEstrella + "-");
		}
		resultado.deleteCharAt(resultado.length() - 1);
		return resultado.toString();
	}

	/*
	 * ○ Un método que devuelva una cadena con los números y las estrellas con el
	 * formato “2-12-17-28-46 Estrellas: 6-10”
	 */
	@Override
	public String toString() {
		return "Combinación: " + numerosToString() + " Estrellas: " + estrellasToString();
	}

	/*
	 * ○ Dos combinaciones serán iguales si tienen la misma colección de números y
	 * de estrellas. Para subir Nota: dos combinaciones serán iguales si tienen el
	 * mismo número en la colección de números y los mismos números en las estrellas
	 * independientemente del orden.
	 */

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}

	/*
	 * ○ Un método comprobar aciertos que reciba un objeto Combinación y devuelva un
	 * número que será el número de aciertos de esa combinación.
	 */

}
