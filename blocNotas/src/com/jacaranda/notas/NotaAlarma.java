package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Actible {
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;
	private LocalDateTime fechaAlarma;
	private int minutosRepetir;
	private boolean activado;

	public NotaAlarma(String texto) {
		super(texto);
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activado) throws NotaAlarmaException {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
		this.activado = activado;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) throws NotaAlarmaException {
		super(texto);
		if (fechaAlarma.isBefore(this.getFechaCreacion())) {
			throw new NotaAlarmaException("La fecha alarma no puede ser anterior a la fecha de creación.");
		} else {
			setFechaAlarma(fechaAlarma);
			this.minutosRepetir = minutosRepetir;
			this.activado = true;
		}
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaException {

		if (fechaAlarma == null) {
			throw new NotaAlarmaException("No se puede crear una alarma sin fecha.");
		} else if (this.getFechaCreacion().isAfter(fechaAlarma)) {
			throw new NotaAlarmaException("No se puede crear una alarma anterior a la fecha de creación.");
		} else {
			this.fechaAlarma = fechaAlarma;
		}

	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	@Override
	public void activar() {
		this.activado = true;
	}

	@Override
	public void desactivar() {
		this.activado = false;
	}

	public boolean isActivado() {
		boolean result = this.activado;
		return result;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}

}
