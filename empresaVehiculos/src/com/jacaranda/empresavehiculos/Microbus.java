package com.jacaranda.empresavehiculos;

import java.time.LocalDate;

public class Microbus extends Vehiculo{
	
	private int numPlazas;

	public Microbus(String matricula, String gama, LocalDate fechaSalida, int numPlazas) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		if (numPlazas <= 0) {
			throw new VehiculoException("Error. El n�mero de plazas deber ser mayor que 0.");
		} else {
			this.numPlazas = numPlazas;
		}
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) throws VehiculoException {
		if (numPlazas <= 0) {
			throw new VehiculoException("Error. El n�mero de plazas deber ser mayor que 0.");
		} else {
			this.numPlazas = numPlazas;
		}
	}

	// En caso de alquiler de un microb�s se le a�ade la cantidad de 5 euros por plaza que disponga el microb�s.
	@Override
	public double getPrecio() {
		return super.getPrecio() + (5 * this.getNumPlazas());
	}
	
	//Te falta el toString
	
	
	
	

}


