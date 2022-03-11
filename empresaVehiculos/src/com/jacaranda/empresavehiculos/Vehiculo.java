package com.jacaranda.empresavehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {
	
	protected String matricula;
	protected GamaEnumerado gama; 
	protected LocalDate fechaEntrada;
	protected LocalDate fechaSalida;
	
	
	public Vehiculo(String matricula, String gama, LocalDate fechaSalida) throws VehiculoException {
		super();
		this.matricula = matricula;
		this.gama = GamaEnumerado.valueOf(gama.toUpperCase());
		this.fechaEntrada = LocalDate.now();
		
		if(fechaSalida != null) {
			if (fechaSalida.isBefore(this.fechaEntrada)) {
				throw new VehiculoException ();
			}else {
				this.fechaSalida = fechaSalida;
			}
		}
		
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public GamaEnumerado getGama() {
		return gama;
	}


	public void setGama(String gama) {
		this.gama = GamaEnumerado.valueOf(gama);
	}


	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public LocalDate getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + ", fechaEntrada=" + fechaEntrada
				+ ", fechaSalida=" + fechaSalida + "]";
	}
	
	
	public double getPrecio() {
		if (this.fechaSalida == null) {
			this.fechaSalida = LocalDate.now();
		}
		double result = gama.getPrecio()* getTotalDays(fechaEntrada,fechaSalida);
		//double result = gama.getPrecio()* (int) fechaEntrada.until(fechaSalida, ChronoUnit.DAYS);
		return result;
	}

	
	public int getTotalDays(LocalDate entrada, LocalDate salida) {
		int result;
		result = (int)entrada.until(salida, ChronoUnit.DAYS);
		return result;
	}
}
