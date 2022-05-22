package com.jacaranda.menu;

import java.util.Iterator;

import com.jacaranda.plato.Plato;
import com.jacaranda.plato.PlatoException;

public class IntoleranteLactosa extends Menu {
	private double limiteLactosa;

	public IntoleranteLactosa(String nombre, double limiteLactosa) throws MenuException {
		super(nombre);
		this.limiteLactosa = limiteLactosa;
	}

	public double getLimiteLactosa() {
		return limiteLactosa;
	}

	@Override
	public void servirPlato(String nombre, int orden, String[] grupoAlimenticios) throws MenuException {
		super.servirPlato(nombre, orden, grupoAlimenticios);
	}

	@Override
	public void servirPlato(String nombre, String descripcion, int orden, double cantidadLactosa,
			String[] grupoAlimenticios) throws MenuException {
		try {
			Plato plato = new Plato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
			Iterator<Plato> platoIterator = this.platos.iterator();
			double totalLactosa = 0;
			Plato iPlato;
			while (platoIterator.hasNext()) {
				iPlato = platoIterator.next();
				totalLactosa = totalLactosa + iPlato.getCantidadLactosa();
			}
			double nuevaCantidadLactosa = totalLactosa + plato.getCantidadLactosa();
			if (nuevaCantidadLactosa > this.limiteLactosa) {
				throw new MenuException(
						"La cantidad de lactosa supera el límite de lactosa del menú para intolerantes a la lactosa.");
			}
			super.servirPlato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
		} catch (PlatoException e) {
			throw new MenuException(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "IntoleranteLactosa [codigo=" + codigo + ", nombre=" + nombre + ", limiteLactosa=" + limiteLactosa
				+ ", platos=" + platos + "]";
	}
}
