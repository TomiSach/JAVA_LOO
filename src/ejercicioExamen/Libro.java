package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

public class Libro { // Declara una clase pública llamada 'Libro'.
    private String icbn; // Declara un campo privado para almacenar el ICBN (similar a ISBN) del libro.
    private String titulo; // Declara un campo privado para almacenar el título del libro.
    private String autor; // Declara un campo privado para almacenar el autor del libro.
    private int edicion; // Declara un campo privado de tipo entero para almacenar el número de edición.
    private String estado; // Declara un campo privado para almacenar el estado actual del libro.

    public static final String DISPONIBLE = "Disponible"; // Declara una constante pública para representar el estado "Disponible".
    public static final String PRESTADO = "Prestado"; // Declara una constante pública para representar el estado "Prestado".
    public static final String RESERVADO = "Reservado"; // Declara una constante pública para representar el estado "Reservado".
    public static final String NO_DISPONIBLE = "No disponible"; // Declara una constante pública para representar el estado "No disponible".

    public Libro(String icbn, String titulo, String autor, int edicion, String estado) { // Define el constructor de la clase 'Libro'.
        this.icbn = icbn; // Asigna el parámetro 'icbn' al campo 'icbn' de la instancia.
        this.titulo = titulo; // Asigna el parámetro 'titulo' al campo 'titulo' de la instancia.
        this.autor = autor; // Asigna el parámetro 'autor' al campo 'autor' de la instancia.
        this.edicion = edicion; // Asigna el parámetro 'edicion' al campo 'edicion' de la instancia.
        this.estado = estado; // Asigna el parámetro 'estado' al campo 'estado' de la instancia.
    }

    public String getIcbn() { return icbn; } // Método público que devuelve el valor del campo 'icbn'.
    public String getTitulo() { return titulo; } // Método público que devuelve el valor del campo 'titulo'.
    public String getAutor() { return autor; } // Método público que devuelve el valor del campo 'autor'.
    public int getEdicion() { return edicion; } // Método público que devuelve el valor del campo 'edicion'.
    public String getEstado() { return estado; } // Método público que devuelve el valor del campo 'estado'.

    public void setEstado(String estado) { this.estado = estado; } // Método público para cambiar el valor del campo 'estado'.

    @Override // Anotación que indica que este método está sobrescribiendo un método de la clase padre (Object).
    public String toString() { // Sobrescribe el método 'toString' para proporcionar una representación en texto del objeto.
        return String.format("ICBN: %s | %s - %s (Ed. %d) [%s]", icbn, titulo, autor, edicion, estado); // Devuelve una cadena de texto formateada con los datos del libro.
    }
}
