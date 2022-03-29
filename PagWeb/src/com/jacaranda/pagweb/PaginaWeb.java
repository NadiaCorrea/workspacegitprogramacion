package com.jacaranda.pagweb;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {

	// De cada página web se almacenará su url y la fecha y hora en la que se
	// visitó.

	private String url;
	private LocalDateTime fechaHora;

	public PaginaWeb(String url) throws PaginaWebException {
		super();
		setUrl(url);
		this.fechaHora = LocalDateTime.now();
	}

	public String getUrl() {
		return url;
	}

	private void setUrl(String url) throws PaginaWebException {
		if (url == null) {
			throw new PaginaWebException("La url no puede ser nula.");
		} else {
			this.url = url;
		}

	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	private void setFechaHora(LocalDateTime fechaHora) throws PaginaWebException {

		if (fechaHora == null) {
			throw new PaginaWebException("La fecha no puede ser nula.");
		} else if (this.fechaHora.isAfter(fechaHora)) {
			throw new PaginaWebException("La fecha a introducir no puede ser anterior a la fecha de consulta.");
		} else {
			this.fechaHora = fechaHora;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		return Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fechaHora=" + fechaHora + "]";
	}

}
