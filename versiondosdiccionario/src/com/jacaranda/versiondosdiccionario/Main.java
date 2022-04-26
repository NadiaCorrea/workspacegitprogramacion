package com.jacaranda.versiondosdiccionario;

public class Main {

	public static void main(String[] args) {

		DiccionarioVersionDos d1 = new DiccionarioVersionDos();

		d1.addEntrada("adios", "sig6");
		d1.addEntrada("hola", "sig1");
		d1.addEntrada("hola", "sig2");
		d1.addEntrada("funcion", "sig3");
		d1.addEntrada("como", "sig4");
		d1.addEntrada("comer", "sig5");
		d1.addEntrada("comer", "sig7");

		System.out.println(d1.toString());

		d1.borrarEntrada("adios");
		System.out.println(d1.toString());
		d1.borrarSignificadoEntrada("hola", "sig1");
		System.out.println(d1.toString());

		System.out.println("busqueda de cadena");
		System.out.println(d1.buscarCadena("co"));

	}

}
