package practicaClases;

import javax.swing.JOptionPane; // javax.swing.* traería todas las librerías de Swing

public class Ejercicio1 {

    public static void main(String[] args) {
        String numero1 = JOptionPane.showInputDialog("Ingrese un número");
        String numero2 = JOptionPane.showInputDialog("Ingrese otro número");

        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);

        int suma = num1 + num2;

        JOptionPane.showMessageDialog(
            null,
            "La suma de " + num1 + " y " + num2 + " es: " + suma,
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}

