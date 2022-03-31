package com.jacaranda.mensajes;

import java.time.LocalDateTime;

import com.jacaranda.personas.Persona;

public class Mensaje {
	private int codigo;
	private Persona remitente;
	private Persona destinatario;
	private String texto;
	private LocalDateTime fechaHora;
	private static int codigoSiguiente = 1;

	public Mensaje(Persona remitente, Persona destinatario, String texto) throws MensajeException {
		super();
		this.codigo = codigoSiguiente;
		this.remitente = remitente;
		this.destinatario = destinatario;
		setTexto(texto);
		this.fechaHora = LocalDateTime.now();
		codigoSiguiente += 1;
	}

	public Persona getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) throws MensajeException {
		if (texto == null || texto == "") {
			throw new MensajeException("No se puede crear un mensaje con un texto vacío.");
		} else {
			this.texto = texto;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public Persona getDestinatario() {
		return destinatario;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public String toString() {
		return "Mensaje " + codigo + ": De: " + remitente.getNombre() + " Texto: " + texto + " Fecha y hora: "
				+ fechaHora;

	}

}
