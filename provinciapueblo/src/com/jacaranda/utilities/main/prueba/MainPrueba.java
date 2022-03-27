package com.jacaranda.utilities.main.prueba;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;

public class MainPrueba {

	public static void main(String[] args) {

		try {

			Provincia prov1 = new Provincia("Sevilla", "41");

			prov1.addPueblo("Alcalá", "500", 100, 20, 100);
			prov1.addPueblo("dos hermanas", "700", 150, 50, 80);
			prov1.addPueblo("mairena", "600", 100, 50, 80);
			// prov1.addPueblo("Alcalá", "300", 150, 30, 0);

			System.out.println(prov1.listadoPueblos());
			System.out.println(prov1.getNumHabitantes());
			System.out.println(prov1.getSuperficie());
			System.out.println(prov1.getCodigo());
			System.out.println(prov1.getRentaPerCapita());
			System.out.println(prov1.getInformacionPueblo("dos hermanas"));
			System.out.println(prov1.delPueblo("mairena"));
			System.out.println(prov1.listadoNombresPueblos());
			// Provincia prov2 = new Provincia("madrid", "410");
			// Provincia prov3 = new Provincia("cordoba", "4");
			Provincia prov4 = new Provincia("cordoba", "4a");

		} catch (ProvinciaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
