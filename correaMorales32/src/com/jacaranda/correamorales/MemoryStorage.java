package com.jacaranda.correamorales;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS = 15;
	private static final int NUM_MAXIMO_PUBLICACIONES = 50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	Usuario[] usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
	Publicacion[] publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];

	public MemoryStorage() {
		super();

		this.numPublicacionesActuales = 0;
		this.numUsuariosActuales = 0;

	}

	// private int posicionUsuario(String)

	public void addUsuario(String login, String pass) {

		if (numUsuariosActuales < NUM_MAXIMO_PUBLICACIONES) {

			usuarios[numUsuariosActuales] = new Usuario(login, pass);
			numUsuariosActuales = numUsuariosActuales + 1;

		}

	}

	public void addPublicacion(String texto, Usuario usuario) {

		if (numPublicacionesActuales < NUM_MAXIMO_PUBLICACIONES) {
			publicaciones[numPublicacionesActuales] = new Tweet(texto, usuario);
			numPublicacionesActuales = numPublicacionesActuales + 1;
		}

	}

	public void addPublicacion(String texto, Usuario usuario, String tema) {

		if (numPublicacionesActuales < NUM_MAXIMO_PUBLICACIONES) {
			publicaciones[numPublicacionesActuales] = new Post(texto, usuario, tema);
			numPublicacionesActuales = numPublicacionesActuales + 1;
		}
	}

}
