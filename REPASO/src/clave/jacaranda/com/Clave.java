package clave.jacaranda.com;

public class Clave {
	private String caracteres;

	public Clave() {
		super();

	}

	public String getCaracteres() {
		return caracteres;
	}

	private void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	public String comprimirClave(String caracteres) {
		String result = "";
		char caracter = caracteres.charAt(0);
		int contador = 0;

		for (int i = 0; i <= caracteres.length() - 1; i = i + 1) {
			if (caracteres.charAt(i) == caracter) {
				contador = contador + 1;
			} else {
				result = result + caracter + String.valueOf(contador);
				caracter = caracteres.charAt(i);
				contador = 1;
			}

		}
		result = result + caracter + String.valueOf(contador);

		return result;
	}

	public String descomprimirClave(String caracteres) {
		String result = "";
		char caracter;
		int veces;
		int i = 0;

		while (i <= caracteres.length() - 1) {
			caracter = caracteres.charAt(i);
			veces = Integer.parseInt(String.valueOf(caracteres.charAt(i + 1)));

			for (int j = 0; j < veces; j = j + 1) {
				result = result + caracter;
			}

			i = i + 2;
		}

		return result;
	}

}
