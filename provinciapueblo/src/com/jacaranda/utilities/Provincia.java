package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Provincia {
	private String nombre;
	private String codigo;
	private int numHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private Set<Pueblo> pueblos;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		if (nombre == null) {
			throw new ProvinciaException("El nombre no puede ser nulo.");
		} else {
			this.nombre = nombre.toUpperCase();
		}
		setCodigo(codigo);
		this.numHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
		this.pueblos = new HashSet<Pueblo>();
	}

	// El código debe tener una longitud de 2 carácteres y deben ser numéricos.
	private void setCodigo(String codigo) throws ProvinciaException {

		if (codigo.length() != 2) {
			throw new ProvinciaException("La longitud del código no es correcta.");
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
				throw new ProvinciaException("El formato del código no es correcto.");
			}
		}

	}

	// Comprobacion del nombre del pueblo true si existe - false si no
	private boolean existePueblo(String nuevoPueblo) {
		boolean result = false;
		Pueblo iPueblo;

		Iterator<Pueblo> iterador = pueblos.iterator();

		while (iterador.hasNext() && !result) {
			iPueblo = iterador.next();

			if (iPueblo.getNombre().equalsIgnoreCase(nuevoPueblo)) {
				result = true;
			}
		}
		return result;
	}

	public boolean addPueblo(String nombrePueblo, String codigo, int numeroHabitantes, double rentaPerCapita,
			double superficie) throws ProvinciaException {
		boolean result = false;
		if (nombrePueblo == null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo.");
		} else {
			try {
				Pueblo newPueblo = new Pueblo(nombrePueblo, this.getCodigo().concat(codigo), numeroHabitantes,
						rentaPerCapita, superficie);
				if (existePueblo(nombrePueblo) == true) {
					throw new ProvinciaException("El pueblo ya existe.");
				} else if (pueblos.contains(newPueblo)) {
					throw new ProvinciaException("El pueblo ya existe");
				} else {
					pueblos.add(newPueblo);
					this.superficie += superficie;
					this.numHabitantes += numeroHabitantes;
					this.rentaPerCapita += rentaPerCapita;
					result = true;
				}
			} catch (PuebloException e) {
				throw new ProvinciaException("No se ha podido crear el pueblo." + e.getMessage());
			}
		}
		return result;
	}

	// Devuelve una cadena con los nombres de los pueblos, de forma que cada pueblo
	// se escribe en una línea
	public String listadoNombresPueblos() {

		StringBuilder result = new StringBuilder();

		for (Pueblo iPueblo : pueblos) {
			result.append(iPueblo.getNombre() + "\n");
		}
		return result.toString();
	}

	// Devuelve una cadena con toda la información de todos los pueblos de la
	// provincia
	public String listadoPueblos() {

		StringBuilder result = new StringBuilder();

		for (Pueblo iPueblo : pueblos) {
			result.append(iPueblo.toString() + "\n");
		}
		return result.toString();
	}

	// Borra un pueblo si existe un pueblo con ese nombre en la provincia
	// true, si el pueblo se ha podido borrar y false en caso contrario.
	public boolean delPueblo(String pueblo) {

		boolean result = false;
		Iterator<Pueblo> iterador = pueblos.iterator();
		Pueblo iPueblo;

		while (iterador.hasNext() && !result) {
			iPueblo = iterador.next();

			if (iPueblo.getNombre().equalsIgnoreCase(pueblo)) {
				this.superficie -= iPueblo.getSuperficie();
				this.numHabitantes -= iPueblo.getNumeroHabitantes();
				iterador.remove();
				result = true;
			}
		}
		return result;
	}

	// Hay que tener en cuenta que si cambia la superficie del pueblo habrá que
	// cambiar
	// también la superficie de la provincia. true, if successful
	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException {
		boolean encontrado = false;
		Iterator<Pueblo> iterador = pueblos.iterator();
		double antiguaSuperficie;

		try {
			while (iterador.hasNext() && !encontrado) {
				Pueblo iPueblo = iterador.next();

				if (iPueblo.getNombre().equalsIgnoreCase(pueblo)) {
					antiguaSuperficie = iPueblo.getSuperficie();
					iPueblo.setSuperficie(superficie);
					this.superficie = this.superficie + (superficie - antiguaSuperficie);
					encontrado = true;
				}
			}
		} catch (PuebloException e) {
			throw new ProvinciaException("No se ha podido modificar la superficie." + e.getMessage());
		}
		return encontrado;
	}

	public boolean setNumHabitantes(String pueblo, int numHabitantes) throws ProvinciaException {
		boolean encontrado = false;
		Iterator<Pueblo> iterador = pueblos.iterator();
		int antiguoNumHabitantes;

		try {
			while (iterador.hasNext() && !encontrado) {
				Pueblo iPueblo = iterador.next();

				if (iPueblo.getNombre().equalsIgnoreCase(pueblo)) {
					antiguoNumHabitantes = iPueblo.getNumeroHabitantes();
					iPueblo.setNumeroHabitantes(numHabitantes);
					this.numHabitantes = this.numHabitantes + (numHabitantes - antiguoNumHabitantes);
					encontrado = true;
				}
			}
		} catch (PuebloException e) {
			throw new ProvinciaException("No se ha podido modificar el número de habitantes." + e.getMessage());
		}
		return encontrado;
	}

	public int numPueblos() {
		return pueblos.size();
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}

	public String getProvincia() {
		return this.nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public double getSuperficie() {
		return superficie;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numHabitantes=" + numHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}

	// Devuelve null si el pueblo no existe o se le pasa null como parámetro
	// Si el pueblo está en la lista de pueblos devolverá el toString de pueblo.the
	// informacion pueblo

	public String getInformacionPueblo(String nombrePueblo) {
		String result = null;
		boolean encontrado = false;
		Iterator<Pueblo> iterador = pueblos.iterator();

		if (nombrePueblo == null) {
			result = null;
		} else {

			while (iterador.hasNext() && !encontrado) {
				Pueblo iPueblo = iterador.next();
				if (iPueblo.getNombre().equalsIgnoreCase(nombrePueblo)) {
					result = iPueblo.toString();
					encontrado = true;
				}
			}
		}
		return result;

	}
}
