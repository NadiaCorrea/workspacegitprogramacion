package boletin;

import java.util.Arrays;

public class OrdenarNum {

	public static void main(String[] args) {
		/*
		 * Realizar un programa que ordene un array de n números enteros. Usar el método
		 * de ordenación por selección
		 * 
		 * VER EXCEL CON LA CORRECCIÓN
		 */
		int[] numeros = { 1, 2, 9, 3, 4, 5, 8, 10, 6, 7 };
		ordenarNum(numeros);
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}

		int[] caso1 = { 1 };
		ordenarNum(caso1);
		System.out.println(Arrays.toString(caso1));

		int[] caso2 = { 9, 1 };
		ordenarNum(caso2);
		System.out.println(Arrays.toString(caso2));

		int[] caso3 = { 9, 1, 0 };
		ordenarNum(caso3);
		System.out.println(Arrays.toString(caso3));

		int[] caso4 = { 9, 1, 0, 3, 7, 10 };
		ordenarNum(caso4);
		System.out.println(Arrays.toString(caso4));

		int[] caso5 = { 1, 2, 9, 3, 4, 5, 8, 10, 6, 7 };
		ordenarNum(caso5);
		System.out.println(Arrays.toString(caso5));

	}

	public static void ordenarNum(int[] num) {
		int i, j;
		int menor;
		int pos;
		int numAux;

		for (i = 0; i < num.length - 1; i = i + 1) {
			menor = num[i];
			pos = i;
			for (j = i + 1; j < num.length; j = j + 1) {
				if (num[j] < menor) {
					menor = num[j];
					pos = j;
				}
			}
			if (pos != i) {
				numAux = num[i];
				num[i] = num[pos];
				num[pos] = numAux;
			}

		}

	}

}
