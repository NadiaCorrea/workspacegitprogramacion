package com.jacaranda.personas;

public class Alumno extends Persona {

	public Alumno(String nombre, String dni, int edad) throws PersonaException {
		super(nombre, dni, edad);

	}

	/*
	 * Si la persona que env�a el mensaje es un alumno y es menor de edad s�lo puede
	 * enviar mensajes a profesores, es decir, si un alumno menor de edad intenta
	 * enviar un mensaje a otro alumno se debe provocar un error.
	 */
}
