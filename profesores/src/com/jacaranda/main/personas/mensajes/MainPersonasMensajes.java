package com.jacaranda.main.personas.mensajes;

import com.jacaranda.personas.Alumno;
import com.jacaranda.personas.Persona;
import com.jacaranda.personas.PersonaException;
import com.jacaranda.personas.Profesor;

public class MainPersonasMensajes {

	public static void main(String[] args) {
		Persona remitente, destinatario, des1;

		try {
			remitente = new Profesor("Mario", "3037", 30, "Biologo");
			destinatario = new Alumno("Pablo", "3466", 16);
			des1 = new Alumno("Pedro", "3478", 18);

			remitente.sendMensaje(destinatario, "Hola como estas");
			remitente.sendMensaje(des1, "Hola2 que tal");
			remitente.sendMensaje(destinatario, "Hola3 como vas");
			remitente.sendMensaje(destinatario, "Hola4 estas alli");
			remitente.sendMensaje(destinatario, "Hola3 como vas");

			System.out.println("antes de borrar\n" + destinatario.leerMensajesRecibidos());
//			destinatario.sendMensaje(des1, "que tal");
			destinatario.delMensaje(3);
			System.out.println("despues de borrar\n" + destinatario.leerMensajesRecibidos());

			System.out.println("buscar texto\n" + destinatario.searchTexto("como"));

			System.out.println(remitente.leerMensajesEnviados());
			System.out.println(des1.leerMensajesRecibidos());
//			System.out.println(des1.leerMensajesEnviados());

		} catch (PersonaException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
