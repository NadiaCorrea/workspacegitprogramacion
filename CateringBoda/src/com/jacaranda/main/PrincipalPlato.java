package com.jacaranda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class PrincipalPlato {

	public static void main(String[] args) {

		try {
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain",
					"programacion", "programacion");
			DatabaseMetaData infoBD = conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());

			Statement instruccion = conexion.createStatement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * public static void addPlato(Connection conexion) { String nombre, apellidos;
	 * int orden; double cantidadLactosa;
	 * 
	 * System.out.println("Introduce nif: ");
	 * 
	 * }
	 */
}
