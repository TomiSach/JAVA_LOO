package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

public class UsuarioBasico extends Usuario { // Declara una clase pública que hereda de la clase 'Usuario'.
    private Libro libroPrestado; // Declara un campo privado para guardar el libro que el usuario tiene prestado.

    public UsuarioBasico(String nombre, String apellido, String email, // Define el constructor de la clase 'UsuarioBasico'.
                         String contrasena, String estado) {
        super(nombre, apellido, email, contrasena, estado, "Usuario"); // Llama al constructor de la clase padre ('Usuario') para inicializar los campos comunes.
        this.libroPrestado = null; // Inicializa el campo 'libroPrestado' como nulo, indicando que no tiene libros al crearse.
    }

    // Devuelve true si pudo prestar
    public boolean prestarLibro(Libro libro) { // Método para que el usuario pida prestado un libro, devuelve verdadero si tiene éxito.
        if (!getEstado().equals("Activo")) return false; // Si el estado del usuario no es "Activo", no puede prestar y devuelve falso.
        if (libroPrestado != null) return false; // Si ya tiene un libro prestado ('libroPrestado' no es nulo), no puede prestar otro y devuelve falso.
        if (!Libro.DISPONIBLE.equals(libro.getEstado())) return false; // Si el estado del libro no es "DISPONIBLE", no se puede prestar y devuelve falso.
        libroPrestado = libro; // Asigna el libro pasado como parámetro al campo 'libroPrestado' del usuario.
        libro.setEstado(Libro.PRESTADO); // Cambia el estado del libro a "PRESTADO".
        return true; // Devuelve verdadero para indicar que el préstamo fue exitoso.
    }

    public boolean devolverLibro() { // Método para que el usuario devuelva un libro, devuelve verdadero si tiene éxito.
        if (libroPrestado == null) return false; // Si no tiene ningún libro prestado ('libroPrestado' es nulo), devuelve falso.
        libroPrestado.setEstado(Libro.DISPONIBLE); // Cambia el estado del libro que tenía a "DISPONIBLE".
        libroPrestado = null; // Elimina la referencia al libro, dejando el campo 'libroPrestado' como nulo.
        return true; // Devuelve verdadero para indicar que la devolución fue exitosa.
    }

    @Override // Anotación que indica que este método está sobrescribiendo un método de la clase padre.
    public void mostrarAcciones() { // Implementación del método abstracto 'mostrarAcciones' heredado de 'Usuario'.
        System.out.println("Acciones Usuario Básico: Consultar, Pedir prestado (1), Devolver (1)"); // Imprime en la consola las acciones que este tipo de usuario puede realizar.
    }
}
