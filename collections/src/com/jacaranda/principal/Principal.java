package com.jacaranda.principal;

import java.util.HashSet;
import java.util.Set;

import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;
import com.jacaranda.jugadores.Alumno;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Equipo e1 = new Equipo("1ºDAW-B");
		Equipo e2 = new Equipo("1ºDAW-A");

		Set<Equipo> liga = new HashSet<Equipo>();

		liga.add(e1);

		try {
			Alumno a = new Alumno("Inma", "44444");
			e1.addAlumno(a);
			System.out.println("Alumno añadido");

			Alumno a2 = new Alumno("Nadia", "4445");
			e1.addAlumno(a2);
			System.out.println("Alumno añadido");

			Alumno a3 = new Alumno("Pedro", "4446");
			e1.addAlumno(a3);
			System.out.println("Alumno añadido");

			Alumno a4 = new Alumno("Paco", "4447");
			e1.addAlumno(a4);
			System.out.println("Alumno añadido");

			Alumno a5 = new Alumno("Claudia", "4448");
			e1.addAlumno(a5);
			System.out.println("Alumno añadido");

			Alumno a6 = new Alumno("Juana", "4452");
			e1.addAlumno(a6);
			System.out.println("Alumno añadido");

			System.out.println(e1.numAlumnos());
//			e.addAlumno(null);
//			e.addAlumno(null);
//			System.out.println(e.numAlumnos());
//			System.out.println(e);

			e2.addAlumno(a);
			System.out.println("Alumno añadido");

			e2.addAlumno(a5);
			System.out.println("Alumno añadido");

			Alumno a7 = new Alumno("Inmanol", "44449");
			e2.addAlumno(a7);
			System.out.println("Alumno añadido");

			Alumno a8 = new Alumno("Sandra", "44450");
			e2.addAlumno(a8);
			System.out.println("Alumno añadido");

			Alumno a9 = new Alumno("Paul", "44451");
			e2.addAlumno(a9);
			System.out.println("Alumno añadido");

			e1.borrarAlumno(a3);
			System.out.println("Alumno eliminado.");

			System.out.println("El equipo 1 tiene " + e1.numAlumnos() + " alumnos.");
			System.out.println("El equipo 2 tiene " + e2.numAlumnos() + " alumnos.");

			System.out.println(e1.buscarAlumno(a));
			System.out.println(e2.buscarAlumno(a8));

			System.out.println("Equipo 1:\n" + e1.mostrarListaPersonas());
			System.out.println("Equipo 2:\n" + e2.mostrarListaPersonas());

			System.out.println("La unión de equipos: " + e1.unionEquipo(e2));
			System.out.println("La intersección de equipos: " + e2.interseccionEquipo(e1));

		} catch (EquipoException e5) {
			// TODO: handle exception
			System.out.println(e5.getMessage());
		}

	}

}
