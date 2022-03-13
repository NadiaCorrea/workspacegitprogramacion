package com.jacaranda.empresavehiculos;

import java.time.LocalDate;

public class Microbus extends Vehiculo{
	
	private int numPlazas;

	public Microbus(String matricula, String gama, LocalDate fechaSalida, int numPlazas) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		if (numPlazas <= 0) {
			throw new VehiculoException("Error. El número de plazas deber ser mayor que 0.");
		} else {
			this.numPlazas = numPlazas;
		}
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) throws VehiculoException {
		if (numPlazas <= 0) {
			throw new VehiculoException("Error. El número de plazas deber ser mayor que 0.");
		} else {
			this.numPlazas = numPlazas;
		}
	}

	// En caso de alquiler de un microbús se le añade la cantidad de 5 euros por plaza que disponga el microbús.
	@Override
	public double getPrecio() {
		return super.getPrecio() + (5 * this.getNumPlazas());
	}
	
	
	
	
	
	

}


