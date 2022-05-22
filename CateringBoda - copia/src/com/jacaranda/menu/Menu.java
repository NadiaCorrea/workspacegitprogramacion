package com.jacaranda.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.jacaranda.plato.Plato;
import com.jacaranda.plato.PlatoException;

public class Menu implements Servible {
	protected static final int MAX_PLATOS = 5;
	protected int codigo;
	protected String nombre;
	protected static int codigoSiguiente = 1;
	protected List<Plato> platos;

	public Menu(String nombre) throws MenuException {
		super();
		setCodigo(codigoSiguiente);
		setNombre(nombre);
		this.platos = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
		codigoSiguiente += 1;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws MenuException {
		if (nombre == null || nombre.equalsIgnoreCase("")) {
			throw new MenuException("El nombre no puede ser nulo ni vacío.");
		} else {
			this.nombre = nombre;
		}

	}

	public int getNumPlatos() {
		return platos.size();
	}

	public static int getMaxPlatos() {
		return MAX_PLATOS;
	}

	public List<Plato> ordenarMenu() {
		List<Plato> platosOrdenados = new ArrayList<>();

		Iterator<Plato> iterador = platos.iterator();
		Plato iPlato;
		while (iterador.hasNext()) {
			iPlato = iterador.next();
			platosOrdenados.add(iPlato);
		}

		Collections.sort(platosOrdenados);

		return platosOrdenados;
	}

	@Override
	public void servirPlato(String nombre, int orden, String[] grupoAlimenticios) throws MenuException {

		try {
			Plato nuevoPlato = new Plato(nombre, orden, grupoAlimenticios);
			boolean encontrado = buscarPlatoPorNombre(nuevoPlato);
			if (encontrado == false) {

				if (platos.size() == MAX_PLATOS) {
					throw new MenuException("No se puede añadir plato. Límite de platos alcanzados.");
				} else {
					this.platos.add(nuevoPlato);
				}

			} else {
				throw new MenuException("El plato ya existe.");
			}
		} catch (PlatoException e) {
			throw new MenuException("No se ha podido crear el plato. " + e.getMessage());
		}

	}

	private boolean buscarPlatoPorNombre(Plato nuevoPlato) {
		boolean resultado = false;

		Iterator<Plato> iterator = platos.iterator();
		Plato iPlato;
		while (iterator.hasNext()) {
			iPlato = iterator.next();
			if (iPlato.equals(nuevoPlato)) {
				resultado = true;
			}
		}
		return resultado;
	}

	@Override
	public void servirPlato(String nombre, String descripcion, int orden, double cantidadLactosa,
			String[] grupoAlimenticios) throws MenuException {
		try {
			Plato nuevoPlato = new Plato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
			boolean encontrado = buscarPlatoPorNombre(nuevoPlato);
			if (encontrado == false) {
				if (platos.size() == MAX_PLATOS) {
					throw new MenuException("No se puede añadir plato. Límite de platos alcanzados.");
				} else {
					this.platos.add(nuevoPlato);
				}

			} else {
				throw new MenuException("El plato ya existe.");
			}
		} catch (PlatoException e) {
			throw new MenuException("No se ha podido crear el plato. " + e.getMessage());
		}

	}

	public void eliminarPlato(int codigo) throws MenuException {
		Plato iPlato = null;

		iPlato = buscarPlato(codigo);
		if (iPlato == null) {
			throw new MenuException("Plato no encontrado.");
		} else {
			this.platos.remove(iPlato);
		}

	}

	private Plato buscarPlato(int codigo) {
		Plato resultado = null;
		Plato iPlato;
		boolean encontrado = false;

		Iterator<Plato> iterator = platos.iterator();

		if (iterator.hasNext() && !encontrado) {
			iPlato = iterator.next();

			if (iPlato.getCodigo() == codigo) {
				encontrado = true;
				resultado = iPlato;
			}
		}

		return resultado;
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
		Menu other = (Menu) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Menu [codigo=" + codigo + ", nombre=" + nombre + ", platos=" + platos + "]";
	}

}
