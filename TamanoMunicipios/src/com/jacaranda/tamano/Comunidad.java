package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Set;

public class Comunidad {
	private String nombre;
	private Set<Municipio> listMunicipio;

	public Comunidad(String descrip) {

		this.nombre = descrip;
		this.listMunicipio = new HashSet<>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Municipio> getListMunicipio() {
		return listMunicipio;
	}

	public void setListMunicipio(Set<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
	}

}
