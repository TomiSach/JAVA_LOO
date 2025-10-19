package ejercicioExamen;

public class Bibliotecario extends Usuario {

	public Bibliotecario(String nombre, String apellido, String email, String contrasena, String estado) {
		super(nombre, apellido, email, contrasena, estado, "Bibliotecario");
	}

	public void cambiarEstadoLibro(Libro libro, String nuevoEstado) {
		libro.setEstado(nuevoEstado);
	}

	@Override
	public void mostrarAcciones() {
		System.out.println("Acciones Bibliotecario: Consultar, Cambiar estado, Agregar libros");
	}
}