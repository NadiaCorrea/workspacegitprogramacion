package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class CompararPorNotaMedia implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		int result;

		if (o2 == null) {
			result = -1;
		} else {

			result = (int) (o2.getNotaMedia() - o1.getNotaMedia());
		}
		return result;
	}

}
