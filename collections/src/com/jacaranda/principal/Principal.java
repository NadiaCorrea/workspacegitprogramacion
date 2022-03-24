package com.jacaranda.principal;

import java.util.HashSet;
import java.util.Set;

import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;
import com.jacaranda.jugadores.Alumno;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno a = new Alumno("inma", "44444");

		Equipo e = new Equipo("1ºDAW-B");

		Set<Equipo> liga = new HashSet<Equipo>();

		liga.add(e);

		try {
			e.addAlumno(a);
			System.out.println("Alumno añadido");
			Alumno a2 = new Alumno("inma", "4444");
			e.addAlumno(a2);
			System.out.println("Alumno añadido");
			System.out.println(e.numAlumnos());
//			e.addAlumno(null);
//			e.addAlumno(null);
//			System.out.println(e.numAlumnos());
//			System.out.println(e);

			e.borrarAlumno(a);
			System.out.println(e.numAlumnos());
			System.out.println(e.buscarAlumno(a));
			System.out.println(e.buscarAlumno(a2));

		} catch (EquipoException e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}

	}

}
