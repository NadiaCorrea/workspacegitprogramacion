package com.jacaranda.tamano;

import java.util.ArrayList;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {

		lista = new ArrayList<Comunidad>();
	}

	public ArrayList<Comunidad> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Comunidad> lista) {
		this.lista = lista;
	}
}
