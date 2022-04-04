package com.jacaranda.personas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

import com.jacaranda.mensajes.Mensaje;
import com.jacaranda.mensajes.MensajeException;

public abstract class Persona implements Comparable<Persona> {
	protected String nombre;
	protected int edad;
	protected String dni;
	protected LinkedList<Mensaje> mensajesRecibido;
	protected LinkedList<Mensaje> mensajesEnviados;

	public Persona(String nombre, String dni, int edad) throws PersonaException {
		super();
		setNombre(nombre);
		this.dni = dni;
		setEdad(edad);
		this.mensajesRecibido = new LinkedList<>();
		this.mensajesEnviados = new LinkedList<>();
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

	public LinkedList<Mensaje> getMensajesRecibido() {
		return mensajesRecibido;
	}

	public LinkedList<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}

//	
//	public void addMensaje(Mensaje nuevoMensaje) throws PersonaException {
//
//		if (nuevoMensaje == null) {
//			throw new PersonaException("No se puede a�adir mensaje vac�o.");
//		} else {
//			this.mensajesRecibido.add(nuevoMensaje);
//		}
//	}

	/*
	 * Un m�todo para poder enviar un mensaje a otra persona. Recibir� como
	 * par�metro la persona destinataria y el texto del mensaje. Boolean al enviar
	 * el mensaje se debe de añadir a lista de enviados y a lista de recibidos
	 */
	public void sendMensaje(Persona destinatario, String texto) throws PersonaException {
		Mensaje newMensaje;
		if (destinatario == null) {
			throw new PersonaException("No se puede enviar mensajes a un destinatario vac�o.");
		} else {
			try {
				newMensaje = new Mensaje(this, destinatario, texto);
//				destinatario.addMensaje(newMensaje);
				destinatario.mensajesRecibido.add(newMensaje);
				this.mensajesEnviados.add(newMensaje);
//				this.addMensaje(newMensaje);
			} catch (MensajeException e) {
				throw new PersonaException(e.getMessage());
			}
		}
	}

	/*
	 * Un m�todo para poder leer los mensajes del buz�n. Este m�todo devolver� un
	 * String con todos los mensajes que tiene. Si no tiene mensajes para leer
	 * saltar� el correspondiente mensaje de error.
	 */

	public String leerMensajesRecibidos() throws PersonaException {
		StringBuilder result = new StringBuilder();

		if (mensajesRecibido == null || mensajesRecibido.isEmpty()) {
			throw new PersonaException("No hay mensajes que mostrar.");
		} else {
			result.append("Recibidos: ");
			Mensaje iMensaje;
			Iterator<Mensaje> iterador = mensajesRecibido.iterator();

			while (iterador.hasNext()) {
				iMensaje = iterador.next();
				result.append(iMensaje.toString() + " ");
			}
		}
		return result.toString();
	}

	public String leerMensajesEnviados() throws PersonaException {
		StringBuilder result = new StringBuilder();
		if (mensajesEnviados == null || mensajesEnviados.isEmpty()) {
			throw new PersonaException("No hay mensajes que mostrar.");
		} else {
			result.append("Enviados: ");
			Mensaje iMensaje;
			Iterator<Mensaje> iterador = mensajesEnviados.iterator();

			while (iterador.hasNext()) {
				iMensaje = iterador.next();
				result.append(iMensaje.toString() + " ");
			}
		}
		return result.toString();
	}

	/*
	 * Un método para poder borrar un mensaje del buzón. Al método se le pasará el
	 * número de mensaje que se desea borrar. Si no existe ese número de mensaje
	 * saltará una excepción.
	 */

	public void delMensaje(int numMensaje) throws PersonaException {

		Iterator<Mensaje> iterator = mensajesRecibido.iterator();
		Mensaje iMensaje;
		boolean encontrado = false;

		while (iterator.hasNext() && !encontrado) {
			iMensaje = iterator.next();

			if (iMensaje.getCodigo() == numMensaje) {
				mensajesRecibido.remove(iMensaje);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			throw new PersonaException("No existe el mensaje que desea borrar.");
		}
	}

	/*
	 * Un método para poder leer los mensajes del buzón pero ordenado por el nombre
	 * del remitente alfabéticamente.
	 */

	/*
	 * Un método que realice una búsqueda para poder encontrar los mensajes de su
	 * buzón que contienen una frase Este método devolverá un String con todos los
	 * mensajes que tienen esa frase o saltará la excepción si no encuentra ningún
	 * mensaje con esa frase.
	 */

	public String searchTexto(String cadena) {
		StringBuilder result = new StringBuilder();

		Iterator<Mensaje> iterator = mensajesRecibido.iterator();
		Mensaje iMensaje;

		while (iterator.hasNext()) {
			iMensaje = iterator.next();

			if (iMensaje.getTexto().contains(cadena)) {
				result.append(iMensaje.toString() + " ");
			}
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
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", mensajes=" + mensajesRecibido + "]";
	}

}
