package com.jacaranda.baraja;

public class BarajaInglesa  extends Baraja{

	public BarajaInglesa () {
		super(52);
	}

	@Override
	protected String generaPalo() {
		PalosBarajaInglesa[] palos = PalosBarajaInglesa.values();
		int indice = (int) (Math.random() * palos.length);
		PalosBarajaInglesa palo = palos[indice];
		
		return palo.toString();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Baraja Inglesa\n");
		
		for (int i = 0; i <super.numCartas; i++) {
			if (super.arrayCartas[i].getNumber() <=10) {
				resultado.append(super.arrayCartas[i].getNumber());	
			} else {
				if (super.arrayCartas[i].getNumber() == 11)
					resultado.append("J");
				else if (super.arrayCartas[i].getNumber() == 12)
					resultado.append("Q");
				else 
					resultado.append("K");
			}
			resultado.append(" "+ super.arrayCartas[i].getPalo() + "\n");
		}
	
		return resultado.toString();
	}
	
	
}
