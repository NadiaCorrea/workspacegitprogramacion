package boletin;

public class Max {

	public static void main(String[] args) {
		/*
		 * 1. Realizar un programa en Java que calcule el máximo de tres números que
		 * recibirá como parámetros.
		 *
		 */

		System.out.println(maxNumero(8, 10, 7));
		System.out.println(maxNumero(3, 2, 1)); // camino1
		System.out.println(maxNumero(2, 1, 3)); // camino2
		System.out.println(maxNumero(1, 3, 4)); // camino3
		System.out.println(maxNumero(1, 3, 2)); // camino4

	}

	public static int maxNumero(int num1, int num2, int num3) {
		int max;

		if (num1 > num2) {
			if (num1 > num3) {
				max = num1;
			} else {
				max = num3;
			}
		} else {
			if (num2 > num3) {
				max = num2;
			} else {
				max = num3;
			}
		}
		return max;

	}
}
