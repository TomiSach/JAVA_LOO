package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

public class Main { // Declara una clase pública llamada 'Main'.
    public static void main(String[] args) { // Método principal que inicia la ejecución del programa.
        Biblioteca biblioteca = new Biblioteca(); // Crea una nueva instancia (objeto) de la clase 'Biblioteca'.

        // Precargar 10 libros
        biblioteca.agregarLibro(new Libro("0001", "El Quijote", "Cervantes", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0002", "1984", "Orwell", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0003", "Rayuela", "Cortázar", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0004", "La Odisea", "Homero", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0005", "La Iliada", "Homero", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0006", "Ficciones", "Borges", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0007", "El Principito", "Saint-Exupéry", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0008", "Cien años de soledad", "García Márquez", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0009", "Crimen y castigo", "Dostoyevski", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.
        biblioteca.agregarLibro(new Libro("0010", "Don Juan Tenorio", "Zorrilla", 1, Libro.DISPONIBLE)); // Agrega un nuevo libro a la biblioteca.

        // Precargar usuarios
        biblioteca.agregarUsuario(new UsuarioBasico("Juan", "Pérez", "juan@mail.com", "1234", "Activo")); // Agrega un nuevo usuario básico a la biblioteca.
        biblioteca.agregarUsuario(new UsuarioBasico("Maria", "Lopez", "maria@mail.com", "5678", "Activo")); // Agrega un nuevo usuario básico a la biblioteca.
        biblioteca.agregarUsuario(new Bibliotecario("Ana", "García", "ana@mail.com", "admin", "Activo")); // Agrega un nuevo usuario de tipo bibliotecario.

        // Abrir ventana de login
        LoginFrame login = new LoginFrame(biblioteca); // Crea una nueva instancia de la ventana de login, pasándole el objeto biblioteca.
        login.setVisible(true); // Hace que la ventana de login sea visible en la pantalla.
    }
}
