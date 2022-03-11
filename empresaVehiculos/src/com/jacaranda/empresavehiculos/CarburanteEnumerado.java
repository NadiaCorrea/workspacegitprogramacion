package com.jacaranda.empresavehiculos;

public enum CarburanteEnumerado {
	DIESEL(2.5), GASOIL(3);
	private final double precio;
	
	private CarburanteEnumerado(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}
}
