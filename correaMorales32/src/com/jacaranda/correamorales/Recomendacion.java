package com.jacaranda.correamorales;

public class Recomendacion extends Publicacion {

	private int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int numEstrellas) {
		super(texto, usuario);
		this.numeroEstrellas = numEstrellas;

	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	@Override
	protected void setTexto(String texto) {

		if (texto.length() <= 100 || texto.length() >= 200) {
			this.texto = texto;
		}

	}

	@Override
	public String toString() {
		return "Recomendacion. \n" + super.toString() + "\nNúmero de estrellas: " + this.getNumeroEstrellas();
	}

}
