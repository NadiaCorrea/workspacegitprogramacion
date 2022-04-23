package com.jacaranda.menu;

public interface Servible {

	void servirPlato(String nombre, int orden, String[] grupoAlimenticios) throws MenuException;

	void servirPlato(String nombre, String descripcion, int orden, double cantidadLactosa, String[] grupoAlimenticios)
			throws MenuException;

}