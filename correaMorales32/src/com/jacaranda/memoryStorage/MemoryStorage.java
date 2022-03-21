package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS = 15;
	private static final int NUM_MAXIMO_PUBLICACIONES = 50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	Usuario[] usuarios;
	Publicacion[] publicaciones;

	public MemoryStorage() {
		super();

		this.numPublicacionesActuales = 0;
		this.numUsuariosActuales = 0;
		this.usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		this.publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];

	}

	private int posicionUsuario(String loginUsuario) {
		int posicion = -1;

		for (int i = 0; i < this.numUsuariosActuales && posicion == -1; i = i + 1) {
			if (this.usuarios[i].getLogin().equals(loginUsuario)) {
				posicion = i;
			}
		}

		return posicion;
	}

	public void addUsuario(String login, String pass) throws MemoryStorageException {
		if (posicionUsuario(login) != -1) {
			throw new MemoryStorageException("Usuario repetido");
		} else {
			if (this.numUsuariosActuales == NUM_MAXIMO_USUARIOS) {
				throw new MemoryStorageException("Número máximo de usuarios alcanzado");
			} else {
				this.usuarios[this.numUsuariosActuales] = new Usuario(login, pass);
				this.numUsuariosActuales = this.numUsuariosActuales + 1;
			}
		}
	}

	public void addPublicacion(String texto, String login) throws MemoryStorageException {
		int posicion = posicionUsuario(login);

		if (posicion == -1) {
			throw new MemoryStorageException("Usuario no encontrado");
		} else {
			try {
				if (this.numPublicacionesActuales == NUM_MAXIMO_PUBLICACIONES) {
					for (int i = 1; i < this.numPublicacionesActuales; i = i + 1) {
						this.publicaciones[i - 1] = this.publicaciones[i];
					}
					this.publicaciones[this.numPublicacionesActuales] = new Tweet(texto, this.usuarios[posicion]);
				} else {
					this.publicaciones[this.numPublicacionesActuales] = new Tweet(texto, this.usuarios[posicion]);
					this.numPublicacionesActuales = this.numPublicacionesActuales + 1;
				}
			} catch (PublicacionException e) {
				throw new MemoryStorageException(e.getMessage());
			}
		}
	}

	public void addPublicacion(String texto, String login, String tema) throws MemoryStorageException {
		int posicion = posicionUsuario(login);

		if (posicion == -1) {
			throw new MemoryStorageException("Usuario no encontrado");
		} else {
			try {
				if (this.numPublicacionesActuales == NUM_MAXIMO_PUBLICACIONES) {
					for (int i = 1; i < this.numPublicacionesActuales; i = i + 1) {
						this.publicaciones[i - 1] = this.publicaciones[i];
					}
					this.publicaciones[this.numPublicacionesActuales] = new Post(texto, this.usuarios[posicion], tema);
				} else {
					this.publicaciones[this.numPublicacionesActuales] = new Post(texto, this.usuarios[posicion], tema);
					this.numPublicacionesActuales = this.numPublicacionesActuales + 1;
				}
			} catch (PublicacionException e) {
				throw new MemoryStorageException(e.getMessage());
			}
		}
	}

	public void addPublicacion(String texto, String login, int numEstrellas) throws MemoryStorageException {
		int posicion = posicionUsuario(login);

		if (posicion == -1) {
			throw new MemoryStorageException("Usuario no encontrado");
		} else {
			try {
				if (this.numPublicacionesActuales == NUM_MAXIMO_PUBLICACIONES) {
					for (int i = 1; i < this.numPublicacionesActuales; i = i + 1) {
						this.publicaciones[i - 1] = this.publicaciones[i];
					}
					this.publicaciones[this.numPublicacionesActuales] = new Recomendacion(texto,
							this.usuarios[posicion], numEstrellas);
				} else {
					this.publicaciones[this.numPublicacionesActuales] = new Recomendacion(texto,
							this.usuarios[posicion], numEstrellas);
					this.numPublicacionesActuales = this.numPublicacionesActuales + 1;
				}
			} catch (PublicacionException e) {
				throw new MemoryStorageException(e.getMessage());
			}
		}
	}

	public String mostrarListaPublicaciones() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.numPublicacionesActuales; i = i + 1) {
			sb.append(this.publicaciones[i].toString() + "\n");
		}

		return sb.toString();
	}

	public String mostrarTweets() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.numPublicacionesActuales; i = i + 1) {
			if (this.publicaciones[i] instanceof Tweet) {
				sb.append(this.publicaciones[i].toString() + "\n");
			}
		}

		return sb.toString();
	}

	public String mostrarPosts() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.numPublicacionesActuales; i = i + 1) {
			if (this.publicaciones[i] instanceof Post) {
				sb.append(this.publicaciones[i].toString() + "\n");
			}
		}

		return sb.toString();
	}

	public String mostrarRecomendacion() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.numPublicacionesActuales; i = i + 1) {
			if (this.publicaciones[i] instanceof Recomendacion) {
				sb.append(this.publicaciones[i].toString() + "\n");
			}
		}

		return sb.toString();
	}
}
