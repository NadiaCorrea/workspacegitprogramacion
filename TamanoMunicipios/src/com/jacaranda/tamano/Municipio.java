package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Set;

public class Municipio {

	private String descrip;
	private Set<Datos> datos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		this.datos = new HashSet<>();
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Set<Datos> getDatos() {
		return datos;
	}

	public void setDatos(Set<Datos> datos) {
		this.datos = datos;
	}

}
