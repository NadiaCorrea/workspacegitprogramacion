package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class CompararPorNumCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {

		int result;

		if (o2 == null) {
			result = -1;
		} else {

			result = (o1.getCapitulos().size() - o2.getCapitulos().size());
		}
		return result;
	}

}
