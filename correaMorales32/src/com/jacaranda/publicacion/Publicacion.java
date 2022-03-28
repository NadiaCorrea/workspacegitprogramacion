package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Comparable<Publicacion>, Valorable {

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente = 1;
	protected Usuario usuario;

	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		this.setTexto(texto);
		this.fechaCreacion = LocalDateTime.now();
		this.valoracion = 0;
		this.codigo = codigoSiguiente;
		codigoSiguiente = codigoSiguiente + 1;
		this.usuario = usuario;
	}

	protected String getTexto() {
		return texto;
	}

	protected abstract void setTexto(String texto) throws PublicacionException;

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isAnterior(Publicacion other) {
		boolean result = false;

		if (other != null && this.fechaCreacion.isBefore(other.getFechaCreacion())) {
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
			result = this.getValoracion() - other.getValoracion();
			if (result == 0) {
				result = this.getFechaCreacion().compareTo(other.getFechaCreacion());
			}
		}
		return result;
	}

	@Override
	public boolean valorar(String valoracion) throws PublicacionException {// si la valoracion no es la de los
																			// enumerados error
		boolean result = false;

		try {
			this.valoracion = this.valoracion + Valoraciones.valueOf(valoracion.toUpperCase()).getValoracion();
			result = true;
		} catch (Exception e) {
			throw new PublicacionException("La valoraci�n no es correcta.");
		}

		return result;
	}

	public String getLoginUsuario() {
		String loginUsuario = "";

		if (this.usuario != null) {
			loginUsuario = this.usuario.getLogin();
		}

		return loginUsuario;
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

		return "Publicaci�n: " + this.texto + "\nRealizada por: " + this.usuario.getLogin() + "\nValoraci�n: "
				+ this.getValoracion() + "\nFecha de publicaci�n: " + this.getFechaCreacion();
	}

}
