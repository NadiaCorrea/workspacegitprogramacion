package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorFechaDescendente implements Comparator<LocalDate> {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		int result;
		if (o1 == null || o2 == null) {
			result = -1;
		} else {
			result = o2.compareTo(o1);
		}

		return result;

	}

}
