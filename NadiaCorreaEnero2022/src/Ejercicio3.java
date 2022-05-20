import java.util.Scanner;

public class Ejercicio3 {
	
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// declaracion variables
		
		
		String entrada;
		double frecuenciaPulsada = 0;
		String teclaSostenida;
		boolean sostenidaPulsada;
		
		
		//solicitud de datos
		
		System.out.println("Intoduce la nota musical: "); // pido la nota
		entrada = teclado.nextLine();
		
		System.out.println("¿Es una nota sostenida? S/N"); //pregunto si es sostenida
		teclaSostenida = teclado.nextLine();
		
		if (teclaSostenida.equals ("S")) {
			sostenidaPulsada = true;
			frecuenciaPulsada = Sostenido(entrada, sostenidaPulsada); // si es sostenida llamo a la funcion que solicita los dos valores
			System.out.println("La frecuencia de la nota musical introducida es " + frecuenciaPulsada);
			
		} else if (teclaSostenida.equals("N")) {
			frecuenciaPulsada =  frecuencia(entrada); // si no es sostenida llamo a funcio de la frecuencia 
			System.out.println("La frecuencia de la nota musical introducida es " + frecuenciaPulsada);
		} else {
			System.out.println("Error.Datos introducidos incorrectos.");
		}
		

	}
 //Elabora una función que reciba el string de la tecla que se ha pulsado en mayúsculas o
//	minúsculas (do, re, mi, etc.) y devuelva la frecuencia que le corresponde.
//	Por ejemplo, si se pulsa la tecla Mi devuelve 659,26.
	
	public static double frecuencia (String teclado) {
		double frecuencia = 0;
		String notaMayuscula;
		
		notaMayuscula = teclado.toUpperCase();
		
		if (notaMayuscula.equals("DO")){
			frecuencia = 523.25;
		} else if (notaMayuscula.equals("RE")) {
			frecuencia = 587.33;
		} else if (notaMayuscula.equals("MI")) {
			frecuencia = 659.26;
		} else if (notaMayuscula.equals("FA")) {
			frecuencia = 698.46;
		} else if (notaMayuscula.equals("SOL")) {
			frecuencia = 783.99;
		} else if (notaMayuscula.equals ("la")){
			frecuencia = 880;
		} else if (notaMayuscula.equals ("si")) {
			frecuencia = 987.77;
		} else {
			frecuencia = -1;
		}
		return frecuencia;
	}
	
	public static double Sostenido(String teclado, boolean pulsado) {
		double frecTeclado;
		boolean pulsa = false;
		double resultado;
		
		frecTeclado = frecuencia (teclado);
		
		if (pulsa == true) {
			resultado = frecTeclado * 1.03;
			
		}else {
			resultado = frecTeclado;
		}
		
		return resultado;
	}
	
	
	
	
	
}
