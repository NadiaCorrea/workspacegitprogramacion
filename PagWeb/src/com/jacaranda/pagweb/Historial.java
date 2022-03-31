package com.jacaranda.pagweb;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Historial {

	List<PaginaWeb> paginas;

	public Historial() {
		super();
		paginas = new LinkedList<>();

	}

	public boolean addPagina(String nombre) throws HistorialException {
		boolean result = false;
		try {
			PaginaWeb newPagina = new PaginaWeb(nombre);
			paginas.add(newPagina);
			result = true;
		} catch (PaginaWebException e) {
			throw new HistorialException(e.getMessage());
		}
		return result;
	}

	public String getHistorial() {

		StringBuilder result = new StringBuilder();
		PaginaWeb iPagina;

		Iterator<PaginaWeb> iterador = paginas.iterator();

		while (iterador.hasNext()) {
			iPagina = iterador.next();
			result.append(iPagina + "\n");
		}
		return result.toString();
	}

	public String getHistorialDia(LocalDate fecha) {
		StringBuilder result = new StringBuilder();
		PaginaWeb iPagina;

		Iterator<PaginaWeb> iterador = paginas.iterator();

		while (iterador.hasNext()) {
			iPagina = iterador.next();

			if (iPagina.getFechaHora().toLocalDate().equals(fecha)) {
				result.append(iPagina + "\n");
			}
		}
		return result.toString();

	}

	public void delHistorial() {
		paginas.clear();
	}

}
