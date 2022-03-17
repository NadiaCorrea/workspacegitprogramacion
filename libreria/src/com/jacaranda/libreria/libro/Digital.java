package com.jacaranda.libreria.libro;

public class Digital extends Libro {
	private double precio;
	private Formato formato;

//	En cuanto al libro digital debemos guardar los mismos datos que para un libro además del precio y
//	el formato del libro (los valores válido son: epub, mobi, pdf). Ambos valores son obligatorios para
//	crear el libro y si en el formato del libro no nos da un valor válido se debe generar una excepción
//	que será gestionada de forma adecuada en el menú principal.

	public Digital(String titulo, String autor, String editorial, double precio, Formato formato)
			throws DigitalException {
		super(titulo, autor, editorial);
		setPrecio(precio);
		setFormato(formato);

	}

	public Digital(String titulo, String autor, double precio, Formato formato) throws DigitalException {
		super(titulo, autor);
		setPrecio(precio);
		setFormato(formato);

	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) throws DigitalException {
		if (precio < 0) {
			throw new DigitalException("El precio no puede ser negativo.");
		} else {
			this.precio = precio;
		}
	}

	public Formato getFormato() {
		return formato;
	}

	private void setFormato(Formato formato) throws DigitalException {

		if (formato == null) {
			throw new DigitalException("El formato no puede ser nulo.");
		} else {
			if (formato != Formato.EPUB && formato != Formato.MOBI && formato != Formato.PDF) {
				throw new DigitalException("El formato no es correcto.");
			} else {
				this.formato = formato;
			}
		}
	}

//	Además de los métodos que se crean necesario se deberá crear un método en la clase libro digital
//	que reciba como argumento un libro electrónico y devuelva true si el libro digital es más caro que el
//	libro electrónico	

	public boolean esMasCaro(Papel other) throws DigitalException {
		boolean resultado = false;

		if (other == null) {
			throw new DigitalException("No se puede comparar.");
		} else {
			if (this.precio > other.getPrecio()) {
				resultado = true;
			}
		}
		return resultado;
	}

//	Cuando deseemos imprimir un libro digital nos deberá aparecer con el siguiente formato:
//	Libro: titulo del libro. Autor: autor. ISBN: isbn Código: codigo. Precio: precio Formato:
//	formato.
	@Override
	public String toString() {
		return super.toString() + ". Precio: " + this.precio + ". Formato: " + this.formato.toString() + ".";
	}

}
