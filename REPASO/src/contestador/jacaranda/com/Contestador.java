package contestador.jacaranda.com;

public class Contestador {
	private String mensaje1;
	private String mensaje2;
	private int numMensajes;
	// private static final int MAXMENSAJES = 2;

	public Contestador() {
		super();
		this.mensaje1 = "";
		this.mensaje2 = "";
		this.numMensajes = 0;
	}

	public String getMensaje1() {
		return mensaje1;
	}

	private void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}

	public String getMensaje2() {
		return mensaje2;
	}

	private void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}

	public int getNumMensajes() {
		return numMensajes;
	}

	private void setNumMensajes(int numMensajes) {
		this.numMensajes = numMensajes;
	}

	public String listenMensaje(int numero) {
		String result = "";
		if (numero == 1) {
			if (getMensaje1().equals("")) {
				result = "No hay mensaje.";
			} else {
				result = "Mensaje 1: " + getMensaje1() + ".";
			}

		} else if (numero == 2) {
			if (getMensaje2().equals("")) {
				result = "No hay mensaje.";
			} else {
				result = "Mensaje 2: " + getMensaje2() + ".";
			}
		} else {
			result = "El mensaje seleccionado no existe.";
		}

		return result;
	}

	public String deleteMensaje(int numero) {
		String result = "";
		if (numero == 1) {
			setMensaje1("");
			setNumMensajes(getNumMensajes() - 1);
			result = "Mensaje 1 eliminado.";
		} else if (numero == 2) {
			setMensaje2("");
			result = "Mensaje 2 eliminado.";
			setNumMensajes(getNumMensajes() - 1);
		} else {
			result = "El mensaje seleccionado no existe.";
		}
		return result;
	}

	public String addMensaje(String mensaje) {
		String result = "";
		if (mensaje1.equals("")) {
			mensaje1 = mensaje;
			setNumMensajes(getNumMensajes() + 1);
			result = "Mensaje 1 añadido.";
		} else {
			mensaje2 = mensaje;
			setNumMensajes(getNumMensajes() + 1);
			result = "Mensaje 2 añadido.";
		}
		return result;
	}

	public String deleteAll() {
		String result = "";
		setMensaje1("");
		setMensaje2("");
		setNumMensajes(0);
		result = "Mensajes eliminados.";
		return result;
	}
}
