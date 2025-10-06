package ejercicioExamen;

public class UsuarioBasico extends Usuario {
    private Libro libroPrestado;

    public UsuarioBasico(String nombre, String apellido, String email,
                         String contrasena, String estado) {
        super(nombre, apellido, email, contrasena, estado, "Usuario");
        this.libroPrestado = null;
    }

    // Devuelve true si pudo prestar
    public boolean prestarLibro(Libro libro) {
        if (!getEstado().equals("Activo")) return false;
        if (libroPrestado != null) return false; // ya tiene uno
        if (!Libro.DISPONIBLE.equals(libro.getEstado())) return false;
        libroPrestado = libro;
        libro.setEstado(Libro.PRESTADO);
        return true;
    }

    public boolean devolverLibro() {
        if (libroPrestado == null) return false;
        libroPrestado.setEstado(Libro.DISPONIBLE);
        libroPrestado = null;
        return true;
    }

    @Override
    public void mostrarAcciones() {
        System.out.println("Acciones Usuario Básico: Consultar, Pedir prestado (1), Devolver (1)");
    }
}
