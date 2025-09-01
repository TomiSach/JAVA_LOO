package practicaClases;

import javax.swing.JOptionPane; // javax.swing.* traería todas las librerías de Swing

public class Ejercicio3 {

    public static void main(String[] args) {
        String numero1 = JOptionPane.showInputDialog("Ingrese un número");
        String numero2 = JOptionPane.showInputDialog("Ingrese otro número");

        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);

        if (num1 == num2) {
            JOptionPane.showMessageDialog(null, "Los números son iguales", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else if (num1 > num2) {
            JOptionPane.showMessageDialog(null, "El número mayor es: " + num1, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El número mayor es: " + num2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

