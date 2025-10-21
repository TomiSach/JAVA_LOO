package LOGICA;

public class Libro {
    private String icbn;
    private String titulo;
    private String autor;
    private int edicion;
    private String estado;

    public static final String DISPONIBLE = "Disponible";
    public static final String PRESTADO = "Prestado";
    public static final String RESERVADO = "Reservado";
    public static final String NO_DISPONIBLE = "No disponible";

    public Libro(String icbn, String titulo, String autor, int edicion, String estado) {
        this.icbn = icbn;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.estado = estado;
    }

    public String getIcbn() { return icbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getEdicion() { return edicion; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format("ICBN: %s | %s - %s (Ed. %d) [%s]", icbn, titulo, autor, edicion, estado);
    }
}