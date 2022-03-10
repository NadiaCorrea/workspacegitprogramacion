package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {
	private static int codigoSiguiente = 1;
	private int codigo; 
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota(String texto) {
		this.codigo = codigoSiguiente;
		codigoSiguiente = codigoSiguiente + 1;
		this.texto = texto;
		this.fechaCreacion = getFechaCreacion();
		this.fechaUltimaModificacion=getFechaModificacion();
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		fechaCreacion = LocalDateTime.now();
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		fechaUltimaModificacion = LocalDateTime.now();
		return fechaUltimaModificacion;
	}
	
	public boolean isModificado () {
		boolean result = false;
		if (this.getFechaCreacion().isBefore(fechaUltimaModificacion));
		result = true;
		return result;
	}
	
	public boolean isEmpty() {
		boolean result = false;
		if(this.getTexto() == null)
			result = true;
		return result;
	}
	
	public boolean isCreadoAnterior(Nota otraNota) {// si el que lo llama tiene la fecha de creacion 
		boolean result = false; 
		 if (this.getFechaCreacion().isBefore(otraNota.getFechaCreacion()))
			 result = true;
		return result;
	}
	
	public boolean isModificadoAnterior(Nota otraNota) {
		boolean result = false; 
		if(this.getFechaModificacion().isBefore(otraNota.getFechaModificacion()))
			result = true;
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}

	@Override
	public int compareTo(Nota other) {
		//para comparar la fecha de creación y el codigo. Si el resultado es negativo entonces nota iría antes que other 
		//si es positivo other iría antes que this y si es 0 se verificaría los codigos y el resultado seria la diferencia de los mismos ya sea positiva o negativa  
		int result; 
		
		if (this.getFechaCreacion().isBefore(other.getFechaCreacion())) {
			result = -1;
		} else if (this.getFechaCreacion().isAfter(other.getFechaCreacion())) {
			result = 1;
		} else {
			result = this.getCodigo() - other.getCodigo();
		}		
		return result;
	}
}
