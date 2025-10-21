package LOGICA;

public class DatosIniciales {

	public static void cargar(Biblioteca biblioteca) {
		// Precargar 10 libros
		biblioteca.agregarLibro(new Libro("0001", "El Quijote", "Cervantes", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0002", "1984", "Orwell", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0003", "Rayuela", "Cortázar", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0004", "La Odisea", "Homero", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0005", "La Iliada", "Homero", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0006", "Ficciones", "Borges", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0007", "El Principito", "Saint-Exupéry", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0008", "Cien años de soledad", "García Márquez", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0009", "Crimen y castigo", "Dostoyevski", 1, Libro.DISPONIBLE));
		biblioteca.agregarLibro(new Libro("0010", "Don Juan Tenorio", "Zorrilla", 1, Libro.DISPONIBLE));

		// Precargar usuarios
		biblioteca.agregarUsuario(new UsuarioBasico("Juan", "Pérez", "juan@mail.com", "1234", "Activo"));
		biblioteca.agregarUsuario(new UsuarioBasico("Maria", "Lopez", "maria@mail.com", "5678", "Activo"));
		biblioteca.agregarUsuario(new Bibliotecario("Ana", "García", "ana@mail.com", "admin", "Activo"));
	}
}