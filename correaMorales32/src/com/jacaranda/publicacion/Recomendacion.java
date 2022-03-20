package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {

	private int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int numEstrellas) throws PublicacionException {
		super(texto, usuario);
		setNumeroEstrellas(numEstrellas);

	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	private void setNumeroEstrellas(int numEstrellas) throws PublicacionException {
		if (numEstrellas >= 1 && numEstrellas <= 5) {
			this.numeroEstrellas = numEstrellas;
		} else {
			throw new PublicacionException("El numero de estrellas es incorrecto.");
		}
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto == null) {
			throw new PublicacionException("El texto no puede ser nulo.");
		} else if (texto.length() < 100 || texto.length() > 200) {
			throw new PublicacionException("Error en la longitud de recomendación.");
		} else {
			super.texto = texto;
		}

	}

	@Override
	public String toString() {
		return "Recomendacion. \n" + super.toString() + "\nNúmero de estrellas: " + this.getNumeroEstrellas();
	}

}
