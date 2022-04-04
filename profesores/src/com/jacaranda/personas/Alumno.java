package com.jacaranda.personas;

public class Alumno extends Persona {

	public Alumno(String nombre, String dni, int edad) throws PersonaException {
		super(nombre, dni, edad);

	}

	/*
	 * Si la persona que envía el mensaje es un alumno y es menor de edad sólo puede
	 * enviar mensajes a profesores, es decir, si un alumno menor de edad intenta
	 * enviar un mensaje a otro alumno se debe provocar un error.
	 */

	@Override
	public void sendMensaje(Persona destinatario, String texto) throws PersonaException {
		if (this.getEdad() < 18 && destinatario instanceof Alumno) {
			throw new PersonaException("No puedes enviar mensaje a otro alumno solo a profesores.");
		} else {
			super.sendMensaje(destinatario, texto);
		}
	}

}
