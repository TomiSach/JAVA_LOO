package LOGICA;

public abstract class Usuario {
    // 1. Todos los campos privados para una buena encapsulación
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String estado; 
    private String tipo;   

    public Usuario(String nombre, String apellido, String email,
                   String contrasena, String estado, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.estado = estado;
        this.tipo = tipo;
    }

    // 2. Getters para todos los campos (para poder leerlos)
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }
    public String getEstado() { return estado; }
    public String getTipo() { return tipo; }

    // 3. Setter SÓLO para 'estado' (el único que cambia)
    public void setEstado(String estado) { 
        this.estado = estado; 
    }

    // Método abstracto (queda igual)
    public abstract void mostrarAcciones();
}