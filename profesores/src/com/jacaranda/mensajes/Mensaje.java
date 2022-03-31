package com.jacaranda.mensajes;

import java.time.LocalDateTime;

import com.jacaranda.personas.Persona;

public class Mensaje {
	private int codigo;
	private Persona remitente;
	private Persona destinatario;
	private String texto;
	private LocalDateTime fechaHora;
	private int codigoSiguiente;

}
