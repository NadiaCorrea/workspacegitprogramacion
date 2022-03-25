package boletin;

import java.util.Random;

public class ED1T4P {
	static Random rnd = new Random();

//	Cuarto programa: ejecución aleatoria 
//	El programa aumenta y disminuye el valor de un iterador de un bucle. 
//	¿Acaba el bucle o estamos ante otro bucle infinito? 
//	Usa “Step Into” para ver el comportamiento de las funciones. 
//	Plantea una solución. 

	public static void main(String[] args) {
		int iterador = 0;
		while (iterador >= 0) {
			iterador = aumentar(iterador);
			iterador = disminuir(iterador);
		}
	}

	public static int aumentar(int a) {
		int aumento = rnd.nextInt(50); // num random 0 al 49
		System.out.println("Aumentando " + aumento);
		return (a + aumento);
	}

	public static int disminuir(int a) {
		int disminucion = rnd.nextInt(10); // num random 0 al 9
		System.out.println("Disminuyendo " + disminucion);
		return (a - disminucion);
	}

}

/*
 * Distribución de breakpoints: Inicio del bucle, inicio de métodos, en las
 * variable aumento y disminución expresiones aumento, disminuciónm a iterador.
 * En el primer método se aumenta el iterador con un número random del 0 al 49,
 * mienstras que el segundo método disminuye el iterador con un número aleatorio
 * del 0 al 9 por lo que i irá aumentado y no será menor igual que cero. Para
 * solucionarlo podríamos cambiar la condición de parada del bucle while o
 * aumentar el rango de los números aleatorios del método disminuir.
 */
