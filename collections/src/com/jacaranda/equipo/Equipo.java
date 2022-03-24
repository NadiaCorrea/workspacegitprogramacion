package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Set;

import com.jacaranda.jugadores.Alumno;

public class Equipo {

	private String nombre;
	private Set<Alumno> listado;

	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado = new HashSet<Alumno>();
	}

	public void addAlumno(Alumno alumno) throws EquipoException {
		if (listado.contains(alumno)) {// si el listado contine el alumno lanza error
			throw new EquipoException("Alumno ya existe.");
		} else {
			listado.add(alumno);
		}

	}

	public void addAlumno2(Alumno alumno) throws EquipoException {
		if (!listado.add(alumno) || alumno == null) {// si el listado contine el alumno lanza error
			throw new EquipoException("Alumno ya existe o nulo.");
		}

	}

	public void addAlumno3(Alumno alumno) throws EquipoException {
		if (alumno == null) {
			throw new EquipoException("Alumno nulo no permitido.");
		}
		if (listado.add(alumno) == false) {
			throw new EquipoException("Alumno ya existe.");
		}

	}

	// Borrar un alumno (recibe como parámetro el objeto alumno a borrar).
	// Si el alumno no existe en el equipo debe saltar una excepción.

	public void borrarAlumno(Alumno alumno) throws EquipoException {
		if (listado.contains(alumno) == false) {
			throw new EquipoException("Alumno no existe.");
		} else {
			listado.remove(alumno);
		}

	}

//	Saber si un alumno pertenece al equipo. Recibe como parámetro el objeto alumno a buscar 
//	y devuelve null si no lo encuentra y el  objeto alumno si existe. 

	public Alumno buscarAlumno(Alumno alumno) {
		Alumno a = null;
		if (listado.contains(alumno) == true) {
			a = new Alumno(alumno.getNombre(), alumno.getDni());
		}
		return a;
	}

	// Mostrar en pantalla la lista de personas del equipo.
	public String mostrarListaPersonas() {
		StringBuilder result = new StringBuilder();

		for (Alumno a : listado) {
			result.append("Alumno " + a + "\n");
		}
		return result.toString();

	}

	public Equipo unionEquipo(Equipo e2) throws EquipoException {
//iterator

		Equipo result = new Equipo("");
		for (Alumno a : this.listado) {
			if (e2.listado.contains(a)) {// pon un try and catch
				result.addAlumno(a);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}

	public int numAlumnos() {
		return this.listado.size();
	}

}
