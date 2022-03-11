package com.jacaranda.empresavehiculos;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo{
	private final double PRECIO_PESO = 0.5;
	private double pma;

	public Furgoneta(String matricula, String gama, LocalDate fechaSalida, double pma) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		if (pma <= 0) {
			throw new VehiculoException("El pma debes ser un valor positivo mayor que 0.");
		} else {
			this.pma = pma;			
		}
	}

	@Override
	public double getPrecio() {
		
		return super.getPrecio();
	}
	
	
	
	
	
	

}
