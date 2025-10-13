package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

public abstract class Usuario { // Declara una clase pública y abstracta llamada 'Usuario'.
    private String nombre; // Declara un campo privado para almacenar el nombre del usuario.
    private String apellido; // Declara un campo privado para almacenar el apellido del usuario.
    private String email; // Declara un campo privado para almacenar el email del usuario.
    private String contrasena; // Declara un campo privado para almacenar la contraseña del usuario.
    private String estado; // Declara un campo privado para almacenar el estado (ej: "Activo").
    private String tipo;   // Declara un campo privado para almacenar el tipo (ej: "Usuario").

    public Usuario(String nombre, String apellido, String email, // Define el constructor de la clase.
                   String contrasena, String estado, String tipo) {
        this.nombre = nombre; // Asigna el parámetro 'nombre' al campo 'nombre' de la instancia.
        this.apellido = apellido; // Asigna el parámetro 'apellido' al campo 'apellido' de la instancia.
        this.email = email; // Asigna el parámetro 'email' al campo 'email' de la instancia.
        this.contrasena = contrasena; // Asigna el parámetro 'contrasena' al campo 'contrasena' de la instancia.
        this.estado = estado; // Asigna el parámetro 'estado' al campo 'estado' de la instancia.
        this.tipo = tipo; // Asigna el parámetro 'tipo' al campo 'tipo' de la instancia.
    }

    public String getNombre() { return nombre; } // Método público que devuelve el valor del campo 'nombre'.
    public String getApellido() { return apellido; } // Método público que devuelve el valor del campo 'apellido'.
    public String getEmail() { return email; } // Método público que devuelve el valor del campo 'email'.
    public String getContrasena() { return contrasena; } // Método público que devuelve el valor del campo 'contrasena'.
    public String getEstado() { return estado; } // Método público que devuelve el valor del campo 'estado'.
    public String getTipo() { return tipo; } // Método público que devuelve el valor del campo 'tipo'.

    public void setEstado(String estado) { this.estado = estado; } // Método público para cambiar el valor del campo 'estado'.

    public abstract void mostrarAcciones(); // Declara un método abstracto que las clases hijas deberán implementar.
}
