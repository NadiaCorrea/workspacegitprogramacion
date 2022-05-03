package com.jacaranda.main;

import com.jaracaranda.combinacion.Combinacion;
import com.jaracaranda.combinacion.CombinacionException;

public class EuromillonMain {

	public static void main(String[] args) {

		try {
			Combinacion c1 = new Combinacion(1, 3, 5, 25, 45, 3, 12);
			// Combinacion c2 = new Combinacion(1, -3, 5, 25, 45, 3, 12);
			// Combinacion c3 = new Combinacion(1, 3, 5, 25, 45, 0, 12);

			System.out.println(c1.numerosToString());
			System.out.println(c1.estrellasToString());
			System.out.println(c1.toString());
		} catch (CombinacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
