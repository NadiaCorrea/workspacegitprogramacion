package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {
	private static int codigoSiguiente = 1;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;

	public Nota(String texto) {
		this.codigo = codigoSiguiente;
		codigoSiguiente = codigoSiguiente + 1;
		this.texto = texto;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaUltimaModificacion = null;

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}

	public boolean isModificado() {
		boolean result = false;
		if (this.getFechaCreacion().isBefore(fechaUltimaModificacion)) {
			result = true;
		}
		return result;
	}

//	el isEmpty si est� vacio es decir si es igual a "" no te lo va a decir, puedes poner las dos condiciones.
	public boolean isEmpty() {
		boolean result = false;
		if (this.getTexto() == null || this.getTexto().equals("")) {
			result = true;
		}
		return result;
	}

//	isCreadoAnterior, isModificadoAnterior debes comprabar que la fecha no es anterior. En compareTo

	public boolean isCreadoAnterior(Nota otraNota) throws NotaException {
		boolean result = false;

		if (otraNota == null) {
			throw new NotaException("Error. No se puede comprobar la fecha. ");
		} else {
			if (this.getFechaCreacion().isBefore(otraNota.getFechaCreacion()))
				result = true;
		}
		return result;
	}

	public boolean isModificadoAnterior(Nota otraNota) throws NotaException {
		boolean result = false;

		if (otraNota == null) {
			throw new NotaException("Error. No se puede comprobar la fecha. ");
		} else {
			if (this.getFechaModificacion().isBefore(otraNota.getFechaModificacion()))
				result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}

	@Override
	public int compareTo(Nota other) {
		int result;

		if (other == null) {
			result = -1;
		} else {
			result = this.texto.compareTo(other.getTexto());
			if (result == 0) {
				result = this.fechaCreacion.compareTo(other.getFechaCreacion());
			}
		}

		return result;
	}
}
