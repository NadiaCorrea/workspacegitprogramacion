package Principal;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;

public class PrincipalPruebas {
//pruebas realizadas mientras se realizaban los métodos
	public static void main(String[] args) {

		try {
			/*
			 * Temporada temp = new Temporada("Hawai");
			 * 
			 * temp.annadirCapitulo("this prueba"); temp.annadirCapitulo("the prueba");
			 * temp.annadirCapitulo("this probar");
			 * 
			 * Para probar los métodos de la clase Temporada
			 * System.out.println(temp.primerCapituloQueContieneEstaPalabara("this"));
			 * System.out.println(temp.primerCapituloQueContieneEstaPalabara("that"));
			 * temp.anadirCapituloDespues("this prueba2", "the prueba");
			 * System.out.println(temp.toString());
			 * System.out.println(temp.toStringFichero());
			 */

			/*
			 * Serie serie1 = new Serie("friends", 1980, Tema.COMEDIA); Serie serie2 = new
			 * Serie("Falcon", 1982, Tema.DRAMA); Serie serie3 = new Serie("Summer", 1992,
			 * Tema.DRAMA);
			 * 
			 * serie1.annadirTemporada("1temp"); serie1.annadirTemporada("2temp");
			 * serie1.annadirTemporada("3temp");
			 * 
			 * serie2.annadirTemporada("1temp"); serie2.annadirTemporada("2temp");
			 * 
			 * serie1.annadirCapituloTemporada("1temp", "this prueba");
			 * serie1.annadirCapituloTemporada("1temp", "the prueba");
			 * serie1.annadirCapituloTemporada("1temp", "this probar");
			 * serie1.annadirCapituloTemporada("2temp", "this prueba");
			 * serie1.annadirCapituloTemporada("3temp", "the prueba");
			 * serie1.annadirCapituloTemporada("3temp", "this probar");
			 * 
			 * serie2.annadirCapituloTemporada("1temp", "this prueba");
			 * serie2.annadirCapituloTemporada("2temp", "the prueba");
			 * serie2.annadirCapituloTemporada("2temp", "this probar");
			 * 
			 * serie1.valorarTemporada("3temp", 3); serie1.valorarTemporada("2temp", 1);
			 * serie1.valorarTemporada("1temp", 2);
			 * 
			 * serie2.valorarTemporada("1temp", 1); serie2.valorarTemporada("2temp", 5);
			 */

			/*
			 * Para probar los métodos de la clase Serie System.out.println("serie 1 ");
			 * System.out.println(serie1.listadoTemporadasPorNotaMedia());
			 * System.out.println(serie1.listadoTemporadasPorNumeroDeCapitulos());
			 * 
			 * System.out.println("serie 2 ");
			 * System.out.println(serie2.listadoTemporadasPorNotaMedia());
			 * System.out.println(serie2.listadoTemporadasPorNumeroDeCapitulos());
			 */

			Series plataforma = new Series();

			plataforma.annadirSerie("Jane", 1980, Tema.COMEDIA);
			plataforma.annadirSerie("Resident", 1982, Tema.DRAMA);
			plataforma.annadirSerie("Sunset", 1992, Tema.DRAMA);

			plataforma.annadirTemporada("Jane", "temp1");
			plataforma.annadirTemporada("Jane", "temp2");
			plataforma.annadirTemporada("Jane", "temp3");

			plataforma.annadirCapituloTemporada("Jane", "temp1", "bienvenidos");
			plataforma.annadirCapituloTemporada("Jane", "temp1", "piscina");
			plataforma.annadirCapituloTemporada("Jane", "temp2", "reencuentro");
			plataforma.annadirCapituloTemporada("Jane", "temp2", "cumpleaños");
			plataforma.annadirCapituloTemporada("Jane", "temp2", "secuela");
			plataforma.annadirCapituloTemporada("Jane", "temp3", "fin");

			System.out.println(plataforma.numeroDeTemporadasDeUnaSerie("Jane"));

			plataforma.modificarTema("Resident", Tema.COMEDIA);
			plataforma.modificarTema("Sunset", Tema.COMEDIA);

			System.out.println(plataforma.listadoOrdenadoSeriesDeUnTema(Tema.COMEDIA));

		} catch (SerieException e) {
			e.printStackTrace();
		}

	}

}
