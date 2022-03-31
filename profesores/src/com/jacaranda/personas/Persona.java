package com.jacaranda.personas;

import java.util.LinkedList;

import com.jacaranda.mensajes.Mensaje;

public abstract class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private LinkedList<Mensaje> mensajes;

	private Persona(String nombre, int edad, LinkedList<Mensaje> mensajes) throws PersonaException {
		super();
		setNombre(nombre);
		setEdad(edad);
		this.mensajes = mensajes;
	}

	protected String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre == null) {
			throw new PersonaException("No se puede crear una persona sin nombre.");
		} else {
			this.nombre = nombre;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad <= 0) {
			throw new PersonaException("La edad no puede ser menor o igual a 0.");
		} else {
			this.edad = edad;
		}
	}

	public LinkedList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(LinkedList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	private void enviarMensaje() {

	}

}
