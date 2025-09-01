package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio23 {

	public static void main(String[] args) {

  
		        int[] vector = { 7,5,6,8,1,2,3,4 };

		        int mayor = 0;
		          
		        for (int i = 0; i < vector.length; i++) {
		        	
		        	if(vector[i] > mayor) {
		        		
		        		mayor = vector[i];
		        		
		        		

		        	}
		        
		        
		        
		        
		            		        }


		        JOptionPane.showMessageDialog(null, "El mayor numero es: " + mayor);
		    
	}

}
