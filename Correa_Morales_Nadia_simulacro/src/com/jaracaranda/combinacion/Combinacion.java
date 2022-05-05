package com.jaracaranda.combinacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//La clase Combinacion, que almacenarÃ¡ una colecciÃ³n para los nÃºmeros y una
//colecciÃ³n para las dos estrellas. 
import java.util.Objects;

public class Combinacion {

	// falta lo de private
	private List<Integer> numeros; // He usado un array list ya que no se necesitaba mantener un orden de los
	// elementos
	private List<Integer> estrellas;// tenía q haber sido un hashset ya que no importa ni el orden nii hay elementos
									// repetidos

	/* Un constructor que reciba los 5 nÃºmeros y las dos estrellas. */

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
			throw new CombinacionException("La combinaciÃ³n debe ser de nÃºmeros del 1 al 50.");
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
			throw new CombinacionException("Las estrellas deben ser nÃºmeros del 1 al 12.");
		}
	}

	/*
	 * Un mÃ©todo que devuelva una cadena con los 5 nÃºmeros con el formato
	 * â€œ2-12-17-28-46â€�
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
	 * â—‹ Un mÃ©todo que devuelva una cadena con las dos estrellas con el formato
	 * â€œ6-10â€�
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
	 * â—‹ Un mÃ©todo que devuelva una cadena con los nÃºmeros y las estrellas con
	 * el formato â€œ2-12-17-28-46 Estrellas: 6-10â€�
	 */
	@Override
	public String toString() {
		return "Combinación: " + numerosToString() + " Estrellas: " + estrellasToString();
	}

	/*
	 * â—‹ Dos combinaciones serÃ¡n iguales si tienen la misma colecciÃ³n de
	 * nÃºmeros y de estrellas. Para subir Nota: dos combinaciones serÃ¡n iguales si
	 * tienen el mismo nÃºmero en la colecciÃ³n de nÃºmeros y los mismos nÃºmeros en
	 * las estrellas independientemente del orden.
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
	 * â—‹ Un mÃ©todo comprobar aciertos que reciba un objeto CombinaciÃ³n y
	 * devuelva un nÃºmero que serÃ¡ el nÃºmero de aciertos de esa combinaciÃ³n.
	 */

	// arraylist se utiliza el get o e indexof
	public int comprobarAciertos(Combinacion combi) {
		int result = 0;
		List<Integer> auxNum = combi.getNumeros();
		List<Integer> auxEst = combi.getEstrellas();

		// Buscar numeros
		Iterator<Integer> iterator = auxNum.iterator();
		int iNum;
		while (iterator.hasNext()) {
			iNum = iterator.next();
			if (this.numeros.contains(iNum)) {
				result += 1;
			}
		}

		// Buscar estrellas
		Iterator<Integer> iterator2 = auxEst.iterator();
		int iEst;
		while (iterator2.hasNext()) {
			iEst = iterator2.next();
			if (this.estrellas.contains(iEst)) {
				result += 1;
			}
		}

		return result;
	}
}
