package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.List;

public class Comunidad {
	private String nombre;
	private List<Municipio> listMunicipio;

	public Comunidad(String descrip) {

		this.nombre = descrip;
		this.listMunicipio = new ArrayList<>();

	}

}
