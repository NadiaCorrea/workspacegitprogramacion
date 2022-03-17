package com.jacaranda.libreria.libro;

public class Papel extends Libro {

	private double peso;
	private double precio;

	public Papel(String titulo, String autor, String editorial, double peso, double precio) throws PapelException {
		super(titulo, autor, editorial);
		setPeso(peso);
		setPrecio(precio);
	}

	public Papel(String titulo, String autor, double peso, double precio) throws PapelException {
		super(titulo, autor);
		setPeso(peso);
		setPrecio(precio);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws PapelException {
		if (peso < 0) {
			throw new PapelException("El peso no puede ser menor que cero.");
		} else {
			this.peso = peso;
		}
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) throws PapelException {
		if (precio < 0) {
			throw new PapelException("El precio no puede ser negativo.");
		} else {
			this.precio = precio;
		}
	}

	public boolean esMasCaro(Digital other) throws PapelException {
		boolean resultado = false;

		if (other == null) {
			throw new PapelException("No se puede comparar.");
		} else {
			if (this.precio > other.getPrecio()) {
				resultado = true;
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Autor: " + this.autor + ". ISBN: " + this.isbn + ". Código: " + this.codigo + ". Precio: " + this.precio
				+ ". Peso: " + this.peso + ". Libro: " + this.titulo + ".";
	}

}
