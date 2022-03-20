package com.jacaranda.main;

import com.jacaranda.memoryStorage.MemoryStorage;
import com.jacaranda.memoryStorage.MemoryStorageException;
import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario usuario = null;
		Tweet tweet = null;
		Post post = null;
		Recomendacion recomendacion = null;
		MemoryStorage memoryStorage = null;

		usuario = new Usuario("nadia", "pass1");

		try {
			tweet = new Tweet("Tweet", usuario);
			tweet.valorar("buena");
			tweet.valorar("normal");
			System.out.println(tweet.toString());
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}

		try {
			post = new Post("Post", usuario, "Tema post");
			post.valorar("normal");
			post.valorar("muymala");
			System.out.println(post.toString());
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}

		try {
			recomendacion = new Recomendacion(
					"Recomendación, Recomendación, Recomendación, Recomendación, Recomendación, Recomendación, Recomendación, ",
					usuario, 1);
			recomendacion.valorar("muymala");
			recomendacion.valorar("regular");
			System.out.println(recomendacion.toString());
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}

		memoryStorage = new MemoryStorage();
		try {
			memoryStorage.addUsuario("nadia", "pass1");
		} catch (MemoryStorageException e) {
			System.out.println(e.getMessage());
		}
		try {
			memoryStorage.addPublicacion("Nuevo tweet", "nadia");
		} catch (MemoryStorageException e) {
			System.out.println(e.getMessage());
		}
		try {
			memoryStorage.addPublicacion("Nuevo post", "nadia", "Nuevo tema");
		} catch (MemoryStorageException e) {
			System.out.println(e.getMessage());
		}
		try {
			memoryStorage.addPublicacion(
					"Nueva Recomendación, Nueva Recomendación, Nueva Recomendación, Nueva Recomendación, Nueva Recomendación, ",
					"nadia", 3);
		} catch (MemoryStorageException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nLas publicaciones son:\n" + memoryStorage.mostrarListaPublicaciones() + "\n");
		System.out.println("Los tweets son:\n" + memoryStorage.mostrarTweets() + "\n");
		System.out.println("Los posts son: \n" + memoryStorage.mostrarPosts() + "\n");
		System.out.println("Las recomendaciones son: \n" + memoryStorage.mostrarRecomendacion() + "\n");
	}
}
