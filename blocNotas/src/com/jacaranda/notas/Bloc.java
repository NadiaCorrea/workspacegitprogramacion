package com.jacaranda.notas;

public class Bloc {

	private static final int NUMERO_NOTAS_MAXIMA = 10;
	private int numNotas;
	private String nombre;
	private Nota [] arrayNotas;
	
	
	
	public Bloc(String nombre) {
		super();
		this.numNotas = 0;
		this.nombre = nombre;
		this.arrayNotas = new Nota [NUMERO_NOTAS_MAXIMA];
	} 
	
	public String getNota(int posicion) throws BlocException {
		String result;
		
		if (posicion < 0 || posicion > NUMERO_NOTAS_MAXIMA) {
			throw new BlocException("Posición de nota incorrecta.");
		} else {
			result = this.arrayNotas[posicion].getTexto();
		}
		return result;
	}

	
	
	
	
}
