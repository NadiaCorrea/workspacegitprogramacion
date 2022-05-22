package com.jacaranda.menu;

import com.jacaranda.plato.GrupoAlimenticio;
import com.jacaranda.plato.Plato;
import com.jacaranda.plato.PlatoException;

public class Vegano extends Menu {

	public Vegano(String nombre) throws MenuException {
		super(nombre);
	}

	@Override
	public void servirPlato(String nombre, int orden, String[] grupoAlimenticios) throws MenuException {
		try {
			Plato plato = new Plato(nombre, orden, grupoAlimenticios);
			if (plato.contieneGrupoAlimenticio(GrupoAlimenticio.CARNE.toString())
					|| plato.contieneGrupoAlimenticio(GrupoAlimenticio.PESCADO.toString())) {
				throw new MenuException("El menú vegano no puede contener ni carne ni pescado.");
			} else {
				super.servirPlato(nombre, orden, grupoAlimenticios);
			}
		} catch (PlatoException e) {
			throw new MenuException(e.getMessage());
		}
	}

	@Override
	public void servirPlato(String nombre, String descripcion, int orden, double cantidadLactosa,
			String[] grupoAlimenticios) throws MenuException {
		try {
			Plato plato = new Plato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
			if (plato.contieneGrupoAlimenticio(GrupoAlimenticio.CARNE.toString())
					|| plato.contieneGrupoAlimenticio(GrupoAlimenticio.PESCADO.toString())) {
				throw new MenuException("El menú vegano no puede contener ni carne ni pescado.");
			} else {
				super.servirPlato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
			}
		} catch (PlatoException e) {
			throw new MenuException(e.getMessage());
		}
	}

}
