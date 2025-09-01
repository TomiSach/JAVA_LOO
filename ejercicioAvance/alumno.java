package ejercicioAvance;

public class alumno {
    // Atributos
    private String nombre;
    private int nota1;
    private int nota2;

    // Constructor
    public alumno(String nombre, int nota1, int nota2) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    // Método para calcular promedio
    public double calcularPromedio() throws ArithmeticException {
        if (nota1 < 0 || nota2 < 0) {
            throw new ArithmeticException("Las notas no pueden ser negativas.");
        }
        return (nota1 + nota2) / 2.0;
    }
}
