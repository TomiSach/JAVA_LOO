package practicaClases;

import javax.swing.JOptionPane; // javax.swing.* traería todas las librerías de Swing

public class Ejercicio5 {

	public static void main(String[] args) {
        for (int j = 1; j <= 2; j++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el " + j + "º nombre");
            System.out.println(nombre);
        }
    }
}