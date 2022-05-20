import java.util.Scanner;
	 
public class Ejercicio2 {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// declaracion de variables 
		int annoActual;
		int annoNacimiento;
		String nacimiento ="";
		double freCarMax;
		
		
		//solicitud de datos
		
		System.out.println("Introduce el año actual: ");
		annoActual = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce tu fecha de nacimiento dd/mm/yyyy :");
		nacimiento = teclado.nextLine();
		
		annoNacimiento = extraerAnno(nacimiento);
		
		freCarMax = cacularFrecuencia (annoActual,annoNacimiento);
		System.out.println("La frecuencia cardiaca Máxima es " + freCarMax + ".");
	}

	//extraccion año nacimiento
	
	public static int extraerAnno (String fecha) {
		String anno ="";
		int annoNacimiento;
		
		for (int i = fecha.length() -1; i > fecha.length()-5; i = i-1) {
			anno = fecha.charAt(i) + anno;
		}
		annoNacimiento = Integer.parseInt(anno);
		return annoNacimiento;
	}
	
	//calcular frecuencia cardiaca 
	
	public static double cacularFrecuencia(int annoActual, int annoNacimiento) {
		double freqCardiaca;
		int edad;
		
		edad = annoActual - annoNacimiento;
		freqCardiaca = 0.85 *(220 - edad);
		return freqCardiaca;
	}
	
	
}
