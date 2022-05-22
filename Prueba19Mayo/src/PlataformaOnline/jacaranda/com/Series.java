package PlataformaOnline.jacaranda.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Series {

	private HashMap<String, Serie> mapSeries;

	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries = new HashMap<String, Serie>();
	}

	/**
	 * A�ade una serie a la lista de series. Si existe una serie con el mismo nombre
	 * lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}

	/**
	 * A�ade una temporada a la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}

	/**
	 * Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por
	 * argumento, si no existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}

	/**
	 * Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}

	/**
	 * Devuelve el n�mero de temporadas que tiene la serie que se pasa por
	 * parámetro Si no existe la serie saltar� la excepci�n.
	 * 
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException {
		int result = 0;
		Serie iSerie = this.mapSeries.get(nombreSerie);

		if (iSerie == null) {
			throw new SerieException("No existe la serie.");
		} else {
			result = iSerie.numeroTemporadas();
		}
		return result;
	}

	/**
	 * Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese
	 * tema saltará la excepción.
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema(String nombreSerie, Tema nuevoTema) throws SerieException {
		Serie valor;

		if (mapSeries.containsKey(nombreSerie)) {
			valor = mapSeries.get(nombreSerie);
			if (valor.getTema().equals(nuevoTema)) {
				throw new SerieException("La serie ya ten�a ese tema.");
			} else {
				valor.setTema(nuevoTema);
			}
		} else {
			throw new SerieException("No existe la serie");
		}

	}

	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie.
	 * Para cada serie se mostrará su nombre, año y número de temporadas. Si no
	 * hay ninguna serie de ese tema saltará la excepción.
	 * 
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public String listadoOrdenadoSeriesDeUnTema(Tema tema) throws SerieException {

		ArrayList<Serie> listaSeries = new ArrayList<>();
		StringBuilder result = new StringBuilder();

		for (Serie series : this.mapSeries.values()) {
			if (series.getTema().equals(tema)) {
				listaSeries.add(series);
			}
		}

		Collections.sort(listaSeries, new CompararPorAno());

		Iterator<Serie> iterador = listaSeries.iterator();
		Serie iSerie;
		while (iterador.hasNext()) {
			iSerie = iterador.next();

			result.append(iSerie.getNombreSerie() + ", " + iSerie.getAnno() + ", " + iSerie.numeroTemporadas() + "\n");
		}

		return result.toString();
	}

	public HashMap<String, Serie> getMapSeries() {
		return mapSeries;
	}

}
