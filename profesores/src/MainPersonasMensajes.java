import com.jacaranda.personas.Alumno;
import com.jacaranda.personas.Persona;
import com.jacaranda.personas.PersonaException;
import com.jacaranda.personas.Profesor;

public class MainPersonasMensajes {

	public static void main(String[] args) {
		Persona remitente, destinatario;

		try {
			remitente = new Profesor("Mario", "3037", 30, "Biologo");
			destinatario = new Alumno("Pablo", "3466", 16);

			remitente.sendMensaje(destinatario, "Hola");
			remitente.sendMensaje(destinatario, "Hola2");

			System.out.println(destinatario.leerMensajes());

		} catch (PersonaException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
