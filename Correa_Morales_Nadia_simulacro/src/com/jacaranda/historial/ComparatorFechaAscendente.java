package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorFechaAscendente implements Comparator<LocalDate> {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		int result;
		if (o1 == null || o2 == null) {
			result = -1;
		} else {
			result = o1.compareTo(o2);
		}

		return result;
	}

}
