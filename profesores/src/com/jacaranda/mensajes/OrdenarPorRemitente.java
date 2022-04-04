package com.jacaranda.mensajes;

import java.util.Comparator;

public class OrdenarPorRemitente implements Comparator<Mensaje> {

	@Override
	public int compare(Mensaje o1, Mensaje o2) {
		int result;

		if (o1 == null || o2 == null) {
			result = -1;
		} else {
			result = o1.getRemitente().compareTo(o2.getRemitente());
		}

		return result;
	}

}
