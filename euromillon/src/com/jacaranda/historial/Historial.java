package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.HashMap;

import com.jaracaranda.combinacion.Combinacion;

/*La clase Historial, que deberá almacenar la combinación ganadora de cada día,
para ello se deberá definir un mapa con clave LocalDate y valor Combinacion.*/

public class Historial {

	private HashMap<LocalDate, Combinacion> historial;

	public Historial(HashMap<LocalDate, Combinacion> historial) {
		super();
		this.historial = historial;
	}

	/*
	 * ○ El método addSorteo que reciba una fecha y una combinación y lo añada al
	 * mapa. Si ya estaba registrada una combinación para esa fecha deberá devolver
	 * false y true en el caso contrario.
	 */

	public boolean addSorteo(LocalDate fecha, Combinacion combinacion) {
		boolean result;
		if (this.historial.containsKey(fecha)) {
			result = false;
		} else {
			this.historial.put(fecha, combinacion);
			result = true;
		}
		return result;

	}

	/*
	 * ○ Un método que actualice la apuesta ganadora para una fecha dada
	 * (actualizarSorteo) recibirá una fecha y una combinación.
	 */
	public boolean actualizarSorteo(LocalDate fecha, Combinacion combinacion) {
		boolean result = false;

		return result;
	}

	/*
	 * ○ Un método que permita borrar la información guardada para una determinada
	 * fecha.
	 */

	public boolean borrarSorteo(LocalDate fecha) {
		boolean result = false;

		if (this.historial.remove(fecha) != null) {
			result = true;
		}

		return result;
	}

	/*
	 * ○ Un método para comprobar el número de aciertos en una fecha determinada.
	 * Recibirá una fecha y una combinación y devolverá el número de aciertos de la
	 * combinación que recibe como parámetro en la combinación que está almacenada
	 * en esa fecha. Si no hay combinación para esa fecha devolverá un -1.
	 */

	public boolean comprobarAciertos(LocalDate fecha, Combinacion combinacion) {
		int result;
		Combinacion aux;

		if (this.historial.containsKey(fecha)) {
			aux = this.historial.get(fecha);
			if (aux.equals(combinacion)) {

			}

		} else {
			result = -1;
		}

		return result;
	}

	/*
	 * ○ Un método que devuelva un String con todas las fechas y los resultados de
	 * las fechas por orden ascendente.
	 */

	/*
	 * ○ Un método que devuelva un String con todas las fechas y los resultados de
	 * las fechas por orden descente.
	 */

	/*
	 * ○ Un método que devuelva un String con los sorteos realizados en un
	 * determinado mes, deberá aparecer la fecha, dos puntos y el resultado (números
	 * y estrellas), un salto de línea y el siguiente resultado.Deberá recibir un
	 * número que representa el mes.
	 */
}
