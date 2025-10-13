package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

import java.util.ArrayList; // Importa la clase 'ArrayList' para poder crear listas dinámicas.

public class Biblioteca { // Declara la clase pública 'Biblioteca', que funcionará como el gestor principal de datos.
    private ArrayList<Libro> libros = new ArrayList<>(); // Declara y crea una lista privada para almacenar todos los objetos 'Libro'.
    private ArrayList<Usuario> usuarios = new ArrayList<>(); // Declara y crea una lista privada para almacenar todos los objetos 'Usuario'.

    public Biblioteca() {} // Define un constructor público vacío para la clase.

    public void agregarLibro(Libro libro) { // Método público para añadir un nuevo libro a la biblioteca.
        if (libros.size() < 20) { // Comprueba si el número actual de libros en la lista es menor que 20.
            libros.add(libro); // Si hay espacio, añade el libro a la lista 'libros'.
        } else { // Si la condición anterior no se cumple (ya hay 20 libros o más).
            throw new IllegalStateException("Límite de libros alcanzado (20)."); // Lanza una excepción para indicar que la biblioteca está llena.
        }
    }

    public void agregarUsuario(Usuario usuario) { // Método público para añadir un nuevo usuario.
        usuarios.add(usuario); // Añade el objeto 'usuario' a la lista 'usuarios'.
    }

    public Usuario login(String email, String contrasena) { // Método público para verificar las credenciales de un usuario.
        for (Usuario u : usuarios) { // Inicia un bucle que recorre cada 'Usuario' en la lista 'usuarios'.
            if (u.getEmail().equals(email) && u.getContrasena().equals(contrasena) && "Activo".equals(u.getEstado())) { // Comprueba si el email, la contraseña y el estado "Activo" coinciden.
                return u; // Si todas las condiciones son verdaderas, devuelve el objeto 'Usuario' encontrado.
            }
        }
        return null; // Si el bucle termina sin encontrar una coincidencia, devuelve 'null'.
    }

    public ArrayList<Libro> getLibros() { return libros; } // Método "getter" que devuelve la lista completa de libros.
    public ArrayList<Usuario> getUsuarios() { return usuarios; } // Método "getter" que devuelve la lista completa de usuarios.
}
