package com.jacaranda.gestion;

import java.time.LocalDate;
import java.util.Objects;

public class Nota {
	private double nota;
	private LocalDate fecha;
	private Alumnado alumno;
	private Modulo modulo;

	public Nota(double nota, LocalDate fecha, Alumnado alumno, Modulo modulo) throws NotaException {
		super();
		setNota(nota);
		this.fecha = fecha;
		this.alumno = alumno;
		this.modulo = modulo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws NotaException {
		if (nota < 0 || nota > 10) {
			throw new NotaException("El rango de las notas es de 0 a 10.");
		} else {
			this.nota = nota;
		}

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getAlumno() {
		return alumno.getDni();
	}

	public String getModulo() {
		return modulo.getNombre();
	}

	@Override
	public String toString() {
		return "Nota [nota=" + nota + ", fecha=" + fecha + ", alumno=" + alumno + ", modulo=" + modulo + "]";
	}

	public String getInfoNota() {
		return this.nota + ", " + this.fecha + ", " + this.alumno + ", " + this.modulo;

	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, fecha, modulo);
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
		return Objects.equals(alumno, other.alumno) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(modulo, other.modulo);
	}

}
