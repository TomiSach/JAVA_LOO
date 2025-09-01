package practicaClases;

import javax.swing.JOptionPane;

public class ejercicio82 {

    public static void main(String[] args) {

        try {
            // Pedimos los datos
            int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numerador"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un denominador"));

            // Realizamos la división
            int resultado = num / num2;

            // Mostramos el resultado
            JOptionPane.showMessageDialog(null,"El resultado de la división es: " + resultado);

        } catch (NumberFormatException e) {
            // Si el usuario no ingresa un número entero
            JOptionPane.showMessageDialog(null,
                    "Error: Debe ingresar solo números enteros.",
                    "Error de Formato", JOptionPane.ERROR_MESSAGE);

        } catch (ArithmeticException e) {
            // Si intenta dividir por cero
            JOptionPane.showMessageDialog(null,
                    "Error: No se puede dividir por cero.",
                    "Error Aritmético", JOptionPane.ERROR_MESSAGE);
        }
    }
}
