package com.jacaranda.baraja;

public class BarajaEspannola extends Baraja{
	
	public BarajaEspannola() {
		super(40);
		
	}

	@Override
	protected String generaPalo() {
		PalosBarajaEspannola [] palos = PalosBarajaEspannola.values();
		int indice = (int) (Math.random()*palos.length);
		PalosBarajaEspannola palo = palos[indice]; 
	
		return palo.toString();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Baraja Española\n");
		
		for (int i = 0; i <super.numCartas; i++) {
			if (super.arrayCartas[i].getNumber() <= 7) {
				resultado.append(super.arrayCartas[i].getNumber());	
			} else {
				if (super.arrayCartas[i].getNumber() == 8)
					resultado.append("Sota");
				else if (super.arrayCartas[i].getNumber() == 9)
					resultado.append("Caballo");
				else 
					resultado.append("Rey");
			}
			resultado.append(" de "+ super.arrayCartas[i].getPalo() + "\n");
		}
	
		return resultado.toString();
	}

	

}
