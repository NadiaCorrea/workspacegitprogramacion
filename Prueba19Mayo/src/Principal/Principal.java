package Principal;

import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Principal {

	public static void main(String[] args) {

		try {
			Temporada temp = new Temporada("Hawai");

			temp.annadirCapitulo("this prueba");
			temp.annadirCapitulo("the prueba");
			temp.annadirCapitulo("this probar");

			Serie serie1 = new Serie("friends", 1980, Tema.COMEDIA);
			Serie serie2 = new Serie("Falcon", 1982, Tema.DRAMA);
			Serie serie3 = new Serie("Summer", 1992, Tema.DRAMA);

			serie1.annadirTemporada("1temp");
			serie1.annadirTemporada("2temp");
			serie1.annadirTemporada("3temp");

			serie2.annadirTemporada("1temp");
			serie2.annadirTemporada("2temp");

			serie1.annadirCapituloTemporada("1temp", "this prueba");
			serie1.annadirCapituloTemporada("1temp", "the prueba");
			serie1.annadirCapituloTemporada("1temp", "this probar");
			serie1.annadirCapituloTemporada("2temp", "this prueba");
			serie1.annadirCapituloTemporada("3temp", "the prueba");
			serie1.annadirCapituloTemporada("3temp", "this probar");

			serie2.annadirCapituloTemporada("1temp", "this prueba");
			serie2.annadirCapituloTemporada("2temp", "the prueba");
			serie2.annadirCapituloTemporada("2temp", "this probar");

			serie1.valorarTemporada("3temp", 3);
			serie1.valorarTemporada("2temp", 1);
			serie1.valorarTemporada("1temp", 2);

			serie2.valorarTemporada("1temp", 1);
			serie2.valorarTemporada("2temp", 5);

			System.out.println("serie 1 ");
			System.out.println(serie1.listadoTemporadasPorNotaMedia());
			System.out.println(serie1.listadoTemporadasPorNumeroDeCapitulos());

			System.out.println("serie 2 ");
			System.out.println(serie2.listadoTemporadasPorNotaMedia());
			System.out.println(serie2.listadoTemporadasPorNumeroDeCapitulos());

			/*
			 * System.out.println(temp.primerCapituloQueContieneEstaPalabara("this"));
			 * System.out.println(temp.primerCapituloQueContieneEstaPalabara("that"));
			 * 
			 * temp.anadirCapituloDespues("this prueba2", "the prueba");
			 * System.out.println(temp.toString());
			 * System.out.println(temp.toStringFichero());
			 */

		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
