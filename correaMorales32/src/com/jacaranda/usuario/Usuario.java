package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {
	private String login;
	private String pass;

	public Usuario(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public boolean setPass(String passAntiguo, String passNuevo) {
		boolean result = false;

		if (this.pass.compareTo(passAntiguo) == 0) {
			this.pass = passNuevo;
			result = true;
		}
		return result;
	}

	public boolean checkPass(String passComprobar) {
		boolean result = false;

		if (passComprobar != null && this.pass.compareTo(passComprobar) == 0) {
			result = true;
		}
		return result;

	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}

}
