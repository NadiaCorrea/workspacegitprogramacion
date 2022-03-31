package com.jacaranda.personas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

import com.jacaranda.mensajes.Mensaje;
import com.jacaranda.mensajes.MensajeException;

public abstract class Persona {
	protected String nombre;
	protected int edad;
	protected String dni;
	protected LinkedList<Mensaje> mensajes;

	public Persona(String nombre, String dni, int edad) throws PersonaException {
		super();
		setNombre(nombre);
		this.dni = dni;
		setEdad(edad);
		this.mensajes = new LinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws PersonaException {
		if (nombre == null) {
			throw new PersonaException("No se puede crear una persona sin nombre.");
		} else {
			this.nombre = nombre;
		}
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) throws PersonaException {
		if (edad <= 0) {
			throw new PersonaException("La edad no puede ser menor o igual a 0.");
		} else {
			this.edad = edad;
		}
	}

	public String getDni() {
		return dni;
	}

	public LinkedList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void addMensaje(Mensaje nuevoMensaje) throws PersonaException {

		if (nuevoMensaje == null) {
			throw new PersonaException("No se puede añadir mensaje vacío.");
		} else {
			this.mensajes.add(nuevoMensaje);
		}
	}

	/*
	 * Un método para poder enviar un mensaje a otra persona. Recibirá como
	 * parámetro la persona destinataria y el texto del mensaje.
	 */
	public void sendMensaje(Persona destinatario, String texto) throws PersonaException {
		Mensaje newMensaje;
		if (destinatario == null) {
			throw new PersonaException("No se puede enviar mensajes a un destinatario vacío.");
		} else {
			try {
				newMensaje = new Mensaje(this, destinatario, texto);
				destinatario.addMensaje(newMensaje);
			} catch (MensajeException e) {
				throw new PersonaException(e.getMessage());
			}
		}
	}

	/*
	 * Un método para poder leer los mensajes del buzón. Este método devolverá un
	 * String con todos los mensajes que tiene. Si no tiene mensajes para leer
	 * saltará el correspondiente mensaje de error.
	 */

	public String leerMensajes() {
		StringBuilder result = new StringBuilder();
		Mensaje iMensaje;
		Iterator<Mensaje> iterador = mensajes.iterator();

		while (iterador.hasNext()) {
			iMensaje = iterador.next();
			result.append(iMensaje.toString() + " ");
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", mensajes=" + mensajes + "]";
	}

}
