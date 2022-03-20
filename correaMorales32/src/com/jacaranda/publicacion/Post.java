package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {
	private int numeroLecturas;
	private String tema;

	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
		super(texto, usuario);
		this.numeroLecturas = 0;
		this.tema = tema;
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto == null) {
			throw new PublicacionException("El texto no puede ser nulo.");
		} else if (texto.isEmpty()) {
			throw new PublicacionException("Error en la longitud del post.");
		} else {
			super.texto = texto;
		}

	}

	@Override
	public boolean valorar(String valoracion) {
		boolean resultado = super.valorar(valoracion);
		if (resultado == true) {
			this.numeroLecturas = this.numeroLecturas + 1;
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		return "Post\n" + super.toString();
	}

	
}
