package LOGICA;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Libro> libros = new ArrayList<>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	public Biblioteca() {
	}

	public boolean agregarLibro(Libro libro) {
		if (libros.size() < 20) {
			libros.add(libro);
			return true; // Devolvemos true para indicar que la operación fue exitosa.
		} else {
			// Si la biblioteca está llena, simplemente devolvemos false.
			System.out.println("Intento de agregar un libro fallido: Límite de 20 libros alcanzado.");
			return false;
		}
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public Usuario login(String email, String contrasena) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email) && u.getContrasena().equals(contrasena) && "Activo".equals(u.getEstado())) {
				return u;
			}
		}
		return null;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}