package com.jacaranda.main.feria;

import java.util.Objects;

public class Caseta {

	private String titulo;
	private String calle;
	private int numero;
	private int modulo;
	private String clase;
	private String entidad;
	private int id;
	private int id_calle;

	public Caseta(String titulo, String calle, int numero, int modulo, String clase, String entidad, int id,
			int id_calle) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulo = modulo;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.id_calle = id_calle;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public int getModulo() {
		return modulo;
	}

	public String getClase() {
		return clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public int getId() {
		return id;
	}

	public int getId_calle() {
		return id_calle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", modulo=" + modulo
				+ ", clase=" + clase + ", entidad=" + entidad + ", id=" + id + ", id_calle=" + id_calle + "]";
	}

}
