package ejercicioAvance;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        try {
            // Ingreso de datos
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");

            int nota1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la primera nota (0-10)"));
            int nota2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la segunda nota (0-10)"));

            // Validación de rango
            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
                throw new ArithmeticException("Las notas deben estar entre 0 y 10.");
            }

            // Crear objeto Alumno
            alumno alumno = new alumno(nombre, nota1, nota2);

            // Calcular promedio
            double promedio = alumno.calcularPromedio();

            JOptionPane.showMessageDialog(null,
                    "El alumno " + alumno.getNombre() + " tiene un promedio de: " + promedio);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Debe ingresar un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null,
                    "Error en cálculo: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió un error inesperado: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
