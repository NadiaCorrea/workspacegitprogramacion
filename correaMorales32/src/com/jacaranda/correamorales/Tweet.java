package com.jacaranda.correamorales;

public class Tweet extends Publicacion {

	public Tweet(String texto, Usuario usuario) {
		super(texto, usuario);

	}

	@Override
	protected void setTexto(String texto) {
		if (texto.length() <= 50) {
			this.texto = texto;
		}

	}

	@Override
	public String toString() {
		return "Tweet.\n" + super.toString();
	}

}
