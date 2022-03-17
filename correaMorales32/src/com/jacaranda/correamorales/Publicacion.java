package com.jacaranda.correamorales;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Publicacion implements Comparable<Publicacion>, Valorable {

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected Valoraciones valoracion;
	private int codigo;
	private static int codigoSiguiente;
	protected Usuario usuario;

	public Publicacion(String texto, Usuario usuario) {
		this.texto = texto;
		this.fechaCreacion = LocalDateTime.now();
		getValoracion();
		this.codigo = 1;
		codigoSiguiente = codigoSiguiente + 1;
		this.usuario = usuario;
	}

	protected String getTexto() {
		return texto;
	}

	protected abstract void setTexto(String texto);

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public Valoraciones getValoracion() {
		return valoracion;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isAnterior(Publicacion other) {
		boolean result = false;

		if (this.fechaCreacion.isBefore(other.getFechaCreacion())) {
			result = true;
		}
		return result;

	}

	@Override
	public int compareTo(Publicacion other) {
		int result = -1;
		if (other == null) {
			result = -1;
		} else {
			if (this.getValoracion() == other.getValoracion()) {
				result = this.getFechaCreacion().compareTo(other.getFechaCreacion());
			}
		}
		return result;
	}

	@Override
	public boolean valorar(String valoracion) {// si la valoracion no es la de los enumerados error
		boolean result = false;

		if () {

		}
		;

		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(texto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(texto, other.texto) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {

		return "Publicacion: " + this.texto + "\nRealizada por: " + this.usuario.getLogin() + "\nValoración: "
				+ this.getValoracion() + "\nFecha de publicación: " + this.getFechaCreacion();
	}

}
