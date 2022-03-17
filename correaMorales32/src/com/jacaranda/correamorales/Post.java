package com.jacaranda.correamorales;

public class Post extends Publicacion {
	private int numeroLecturas;
	private String tema;

	public Post(String texto, Usuario usuario, String tema) {
		super(texto, usuario);
		this.numeroLecturas = 0;
		this.tema = tema;
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto == null || texto == "") {
			throw new PublicacionException("No se puede crear un post sin texto.");
		} else {
			this.texto = texto;
		}

	}

}
