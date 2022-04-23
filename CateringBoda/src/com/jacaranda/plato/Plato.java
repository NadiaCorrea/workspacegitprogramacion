package com.jacaranda.plato;

import java.util.Arrays;
import java.util.Objects;

public class Plato implements Comparable<Plato> {
	private static final int MAX_GRUPOS_ALIMENTICIOS = 3;
	private int codigo;
	private static int codigoSiguiente = 1;
	private String nombre;
	private String descripcion;
	private int orden;
	private int numGrupoAlimenticios;
	private double cantidadLactosa;
	private GrupoAlimenticio[] gruposAlimenticios;

	public Plato(String nombre, int orden, String[] gruposAlimenticios) throws PlatoException {
		super();
		setCodigo(codigoSiguiente);
		setNombre(nombre);
		setOrden(orden);
		this.descripcion = null;
		setGruposAlimenticios(gruposAlimenticios); // cuando agrega los grupos alimenticios también agrega el num de
													// grupos
		this.cantidadLactosa = 0;

	}

	public Plato(String nombre, String descripcion, int orden, double cantidadLactosa, String[] gruposAlimenticios)
			throws PlatoException {
		super();
		setCodigo(codigoSiguiente);
		setNombre(nombre);
		setOrden(orden);
		this.descripcion = descripcion;
		setGruposAlimenticios(gruposAlimenticios);
		setCantidadLactosa(cantidadLactosa);

	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
		codigoSiguiente += 1;

	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws PlatoException {
		if (nombre == null || nombre.equalsIgnoreCase("")) {
			throw new PlatoException("El nombre no puede ser nulo.");
		} else {
			this.nombre = nombre;
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrden() {
		return orden;
	}

	private void setOrden(int orden) throws PlatoException {
		if (orden <= 0) {
			throw new PlatoException("El orden de servir debe ser mayor que cero.");
		} else {
			this.orden = orden;
		}

	}

	public int getNumGrupoAlimenticios() {
		return numGrupoAlimenticios;
	}

	private void setNumGrupoAlimenticios(int numGrupoAlimenticios) {
		this.numGrupoAlimenticios = numGrupoAlimenticios;
	}

	public double getCantidadLactosa() {
		return cantidadLactosa;
	}

	public void setCantidadLactosa(double cantidadLactosa) throws PlatoException {
		if (cantidadLactosa < 0) {
			throw new PlatoException("La cantidad de lactosa no puede ser negativa.");
		} else {
			this.cantidadLactosa = cantidadLactosa;
		}

	}

	public GrupoAlimenticio[] getGruposAlimenticios() {
		return gruposAlimenticios;
	}

	private void setGruposAlimenticios(String[] gruposAlimenticios) throws PlatoException {
		this.gruposAlimenticios = new GrupoAlimenticio[MAX_GRUPOS_ALIMENTICIOS];
		int numGrupos = 0;

		GrupoAlimenticio grupoAlimenticio;

		try {
			for (int i = 0; i < gruposAlimenticios.length; i++) {
				if (gruposAlimenticios[i] != null) {
					grupoAlimenticio = GrupoAlimenticio.valueOf(gruposAlimenticios[i]);
					this.gruposAlimenticios[i] = grupoAlimenticio;
					numGrupos = numGrupos + 1;
				}
			}
			setNumGrupoAlimenticios(numGrupos);
		} catch (Exception e) {

			throw new PlatoException("Grupo alimenticion no válido. " + e.getMessage());
		}
	}

	public static int getMaxGruposAlimenticios() {
		return MAX_GRUPOS_ALIMENTICIOS;
	}

	public static int getCodigoSiguiente() {
		return codigoSiguiente;
	}

	public boolean contieneGrupoAlimenticio(String grupoAlimenticio) {
		boolean encontrado = false;
		int i = 0;

		while (i < this.numGrupoAlimenticios && !encontrado) {
			if (this.gruposAlimenticios[i].toString().equalsIgnoreCase(grupoAlimenticio)) {
				encontrado = true;
			} else {
				i = i + 1;
			}
		}
		return encontrado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Plato [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", orden=" + orden
				+ ", numGrupoAlimenticios=" + numGrupoAlimenticios + ", cantidadLactosa=" + cantidadLactosa
				+ ", gruposAlimenticios=" + Arrays.toString(gruposAlimenticios) + "]";
	}

	@Override
	public int compareTo(Plato o) {
		int resultado;

		if (o == null) {
			resultado = -1;
		} else {
			resultado = this.getOrden() - o.getOrden();
			if (resultado == 0) {
				resultado = this.getNombre().compareTo(o.getNombre());
			}
		}

		return resultado;
	}

}
