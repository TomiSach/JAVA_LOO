package ejercicioExamen;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Biblioteca() {}

    public void agregarLibro(Libro libro) {
        if (libros.size() < 20) {
            libros.add(libro);
        } else {
            throw new IllegalStateException("Límite de libros alcanzado (20).");
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

    public ArrayList<Libro> getLibros() { return libros; }
    public ArrayList<Usuario> getUsuarios() { return usuarios; }
}
