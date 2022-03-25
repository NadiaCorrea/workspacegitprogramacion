package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
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
		if (listado.contains(alumno)) {// si el listado contiene el alumno lanza error
			throw new EquipoException("Alumno ya existe.");
		} else {
			listado.add(alumno);
		}

	}

	public void addAlumno2(Alumno alumno) throws EquipoException {
		if (alumno == null || !listado.add(alumno)) {// si el listado contiene el alumno lanza error
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

	private boolean delUnAlumno(String nombre) {

		Iterator<Alumno> siguiente = this.listado.iterator();
		boolean encontrado = false;

		while (siguiente.hasNext() && !encontrado) {
			Alumno a = siguiente.next();
			if (a.getNombre().equalsIgnoreCase(nombre)) {
				this.listado.remove(a);
				encontrado = true;
			}
		}
		return encontrado;
	}

	public void delAlumno(String nombre) {

		while (delUnAlumno(nombre) == true)
			;

	}
//		Iterator<Alumno> siguiente = this.listado.iterator();
//		while (siguiente.hasNext()) {
//			Alumno a = siguiente.next();
//			if (a.getNombre().equalsIgnoreCase(nombre)) {
//				this.listado.remove(a);
//			}
//		}

//NO se puede usar este ya que cuando borra un objeto luego se queda out of range		
//		for (Alumno a : this.listado) {
//			if (a.getNombre().equalsIgnoreCase(nombre)) {
//				this.listado.remove(a);
//			}
//	}

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

		for (Alumno a : this.listado) {
			result.append(a + "\n");
		}
		return result.toString();

	}

	// Unión de equipos. El método lo llamará un equipo y
	// se le pasará por parámetro el otro equipo con el que se quiere unir.
	// Devuelve un equipo formado por los alumnos de ambos equipos.

	public Equipo unionEquipo(Equipo e2) {
		Equipo result = new Equipo("");

		// los alumnos del equipo que lo llama
		for (Alumno a : this.listado) {
			try {
				result.addAlumno(a);
			} catch (EquipoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// los alumnos del equipo que recibe como parametro
		for (Alumno a : e2.listado) {
			if (result.listado.contains(a) == false) {
				try {
					result.addAlumno(a);
				} catch (EquipoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

//	Intersección de equipos.  Idem al anterior pero 
//	devuelve un equipo formado por los alumnos que están en los dos equipos 

	public Equipo interseccionEquipo(Equipo e2) {
		Equipo result = new Equipo("");

		for (Alumno a : this.listado) {
			if (e2.listado.contains(a) == true) {
				try {
					result.addAlumno(a);
				} catch (EquipoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;

	}

	@Override
	public String toString() {
		return "Equipo - " + nombre + ", Listado de alumnos: " + listado;
	}

	public int numAlumnos() {
		return this.listado.size();
	}

}
