package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

public class Bibliotecario extends Usuario { // Declara una clase pública 'Bibliotecario' que hereda de la clase 'Usuario'.

    public Bibliotecario(String nombre, String apellido, String email, // Define el constructor para la clase 'Bibliotecario'.
                         String contrasena, String estado) {
        super(nombre, apellido, email, contrasena, estado, "Bibliotecario"); // Llama al constructor de la clase padre ('Usuario'), pasando "Bibliotecario" como tipo.
    }

    public void cambiarEstadoLibro(Libro libro, String nuevoEstado) { // Método público para cambiar el estado de un objeto 'Libro'.
        libro.setEstado(nuevoEstado); // Llama al método 'setEstado' del libro para asignarle el nuevo estado.
    }

    @Override // Anotación que indica que este método sobrescribe un método de su clase padre.
    public void mostrarAcciones() { // Implementa el método abstracto 'mostrarAcciones' heredado de 'Usuario'.
        System.out.println("Acciones Bibliotecario: Consultar, Cambiar estado, Agregar libros"); // Imprime en la consola las acciones específicas para un bibliotecario.
    }
}
