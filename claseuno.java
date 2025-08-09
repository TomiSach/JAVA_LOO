package clase_1;

import javax.swing.JOptionPane;//javax.swing.* TRAE TODAS LAS LIBRERIAS DE SWING

public class ejercicioUno{

    public static void main(string[]args{
        string numero1 = JOptionPane.showInputDialog("Ingrese un numero");
        string numero2 = JOptionPane.showInputDialog("Ingrese otro numero");
        int num1=0,num2=0;
        num1 = integer.parseInt(numero1);
        num2 = integer.parseInt(numero2);
        int suma = num1+num2;

        JOptionPane.showMessageDialog(null, "La suma de " + num1 + " y " + num2 + " es: " + suma, "Resultado", JOptionPane.INFORMATION_MESSAGE);

    })

}

P




public class ejercicioUTres{

    public static void main(string[]args{
        string numero1 = JOptionPane.showInputDialog("Ingrese un numero");
        string numero2 = JOptionPane.showInputDialog("Ingrese otro numero");
        if (num1== num2) {
            JOptionPane.showMessageDialog(null, "Los numeros son iguales", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else if (num1 > num2) {
            JOptionPane.showMessageDialog(null, "El numero mayor es: " + num1, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El numero mayor es: " + num2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    })

}


public class ejercicioCuatro{

    public static void main(string[]args{

for(int j= 1 ; j<2 ;j++){
    String nombre = JOption.showInputDialog("Ingrese el"+j +"Nombre");
    system.out.println(nombre);        

        }

    
    }




public class ejercicioCinco{

    public static void main(string[]args{

for(int j= 1 ; j<2 ;j++){
    String nombre = JOption.showInputDialog("Ingrese el"+j +"Nombre");
    system.out.println(nombre);        

        }

    }

}
