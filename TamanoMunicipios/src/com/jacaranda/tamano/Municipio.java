package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.List;

public class Municipio {

	private String descrip;
	private List<Datos> listDatos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		this.listDatos = new ArrayList<>();
	}

}
