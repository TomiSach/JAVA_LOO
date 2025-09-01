package practicaClases;

import javax.swing.JOptionPane; // javax.swing.* traería todas las librerías de Swing

public class Ejercicio2 {

    public static void main(String[] args) {
    	
        String numero = JOptionPane.showInputDialog("Ingrese un número"); //Ingresamos numero
        
        int num = Integer.parseInt(numero); //convertimos a entero
        String resultado ;
        		
        if(num % 2 == 0) {
        	resultado = "PAR";
        	}else {
        resultado = "IMPAR";
        }
        

        JOptionPane.showMessageDialog(
            null,
            "El numero : " + num + " es " + resultado,
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
