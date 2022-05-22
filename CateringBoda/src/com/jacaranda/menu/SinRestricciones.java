package com.jacaranda.menu;

public class SinRestricciones extends Menu {

	public SinRestricciones(String nombre) throws MenuException {
		super(nombre);
	}

	@Override
	public void servirPlato(String nombre, int orden, String[] grupoAlimenticios) throws MenuException {
		super.servirPlato(nombre, orden, grupoAlimenticios);
	}

	@Override
	public void servirPlato(String nombre, String descripcion, int orden, double cantidadLactosa,
			String[] grupoAlimenticios) throws MenuException {
		super.servirPlato(nombre, descripcion, orden, cantidadLactosa, grupoAlimenticios);
	}
}
