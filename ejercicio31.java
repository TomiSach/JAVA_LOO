package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio31 {

    public static void main(String[] args) {
        
        JTextArea area = new JTextArea(5, 10);
        JScrollPane scrollPane = new JScrollPane(area);
        
        int[] array ;
        int acum = 0;
        int aritmetica = 0;
        
        
        for (int i = 0; i <= 5; i++) {
	
        	int num =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        	area.append(num + "");
        	acum = acum + num;
        }
        
        aritmetica = acum % (5);
        
        area.append(" \n La media es: " + aritmetica);
        
        
       
        
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
