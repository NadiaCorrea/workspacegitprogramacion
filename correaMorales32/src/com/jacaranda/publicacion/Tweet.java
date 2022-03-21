package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);

	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto == null) {
			throw new PublicacionException("El texto no puede ser nulo.");
		} else if (texto.length() > 50) {
			throw new PublicacionException("Error en la longitud del tweet.");
		} else {
			super.texto = texto;
		}
	}

	@Override
	public boolean valorar(String valoracion) {
		boolean result = false;
		try {
			super.valoracion = super.valoracion + (2 * Valoraciones.valueOf(valoracion.toUpperCase()).getValoracion());
			result = true;
		} catch (Exception e) {
			System.out.println("La valoración no es correcta.");
			result = false;
		}

		return result;
	}

	@Override
	public String toString() {
		return "Tweet.\n" + super.toString();
	}

}
