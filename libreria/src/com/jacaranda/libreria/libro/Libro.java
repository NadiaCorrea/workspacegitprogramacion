package com.jacaranda.libreria.libro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Libro {
	protected String titulo;
	protected String autor;
	protected String editorial;
	protected LocalDate fechaEdicion;
	protected String isbn;
	protected int codigo;
	private static int codigoSiguiente = 1;

//	Para poder crear un libro es necesario tener el título, el autor y la editorial. Aunque también se
//	puede crear el libro sin editorial. Los únicos datos que se podrán modificar del libro son la editorial
//	y la fecha de edición.

	public Libro(String titulo, String autor, String editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaEdicion = null;
		this.isbn = obtenerIsbn();
		this.codigo = codigoSiguiente;
		codigoSiguiente = codigoSiguiente + 1;
	}

	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = null;
		this.fechaEdicion = null;
		this.isbn = obtenerIsbn();
		this.codigo = codigoSiguiente;
		codigoSiguiente = codigoSiguiente + 1;
	}

//	 ISBN se calcula de la siguiente forma: los tres primeros caracteres (sin tener en
//	 cuenta los espacios) del título, la longitud del título, los tres últimos caracteres del autor (sin tener
//	 en cuenta los espacios) junto con la longitud del autor.

	private String obtenerIsbn() {
		StringBuilder resultado = new StringBuilder();

		String tituloSinEspacio = this.titulo.replace(" ", "");
		resultado.append(tituloSinEspacio.substring(0, 3));

		resultado.append(this.titulo.length());

		String autorSinEspacio = this.autor.replace(" ", "");
		resultado.append(autorSinEspacio.substring(autorSinEspacio.length() - 3));

		resultado.append(this.autor.length());

		return resultado.toString();
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getCodigo() {
		return codigo;
	}

	public static int getCodigoSiguiente() {
		return codigoSiguiente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

//	También deberemos crear un método en la clase libro que reciba como parámetro otro libro y nos
//	devuelva el número de días que han pasado entre las dos fechas de edición. El valor deberá ser
//	siempre positivo.

	public int calcularDiferenciaDias(Libro other) throws LibroException {
		int resultado;

		if (other == null || other.getFechaEdicion() == null || this.fechaEdicion == null) {
			throw new LibroException("No se puede calcular.");
		} else {
			resultado = (int) this.fechaEdicion.until(other.getFechaEdicion(), ChronoUnit.DAYS);
			resultado = Math.abs(resultado);
		}
		return resultado;
	}

//	Cuando deseemos imprimir un libro nos deberá aparecer con el siguiente formato.
//	Libro: titulo del libro. Autor: autor. ISBN: isbn Código: codigo
	@Override
	public String toString() {
		return "Libro: " + this.titulo + ". Autor: " + this.autor + ". ISBN: " + this.isbn + ". Código: " + this.codigo;
	}

}
