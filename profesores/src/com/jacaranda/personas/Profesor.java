package com.jacaranda.personas;

public class Profesor extends Persona {
	private String titulacion;

	public Profesor(String nombre, String dni, int edad, String titulacion) throws PersonaException {
		super(nombre, dni, edad);
		this.titulacion = titulacion;
	}

	public String getTitulacion() {
		return titulacion;
	}

}
