package com.jacaranda.palabras.empiezan;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.palabra.Palabra;

public class PalabrasEmpiezan {
	Character letra;
	List<Palabra> palabras;

	public PalabrasEmpiezan(Character letra) throws PalabraEmpiezanException {
		super();
		setLetra(letra);
		this.palabras = new LinkedList<>();
	}

	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) throws PalabraEmpiezanException {

		if (letra == null) {
			throw new PalabraEmpiezanException("La letra no puede ser nula.");
		} else {
			this.letra = letra;
		}

	}

	// addPalabra

	public void addPalabra(String palabra, String significado) {

	}

//	private int buscarSuSito(Integer nuevo) { 
//		// TODO Auto-generated method stub 
//		boolean encontradoPosicion=false; 
//		int pos=0; Iterator <Integer> it= lista.iterator(); 
//		Integer elemento; 
//		while ( it.hasNext() && encontradoPosicion== false) { 
//			elemento=it.next(); 
//			if ( nuevo.intValue() < elemento.intValue()) 
//				encontradoPosicion= true; 
//			else pos++; 
//			} 
//		return pos; } 
//	}
	// delPalabra

	public void borraPalabra(String palabra) {

	}

	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabrasEmpiezan other = (PalabrasEmpiezan) obj;
		return Objects.equals(letra, other.letra);
	}

	@Override
	public String toString() {
		return "PalabrasEmpiezan [letra=" + letra + ", palabras=" + palabras + "]";
	}

}
