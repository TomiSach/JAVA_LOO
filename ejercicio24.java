package practicaClases;

import javax.swing.JOptionPane;

public class ejercicio24 {
	
	public static void main(String[] args) {

		
		
        
        
        
	    
        
        int[] vector = { 7,5,6,8,1,2,3,4 };

        int mayor = 0;
        
        int menor = 100;
        
        
        //ORDENAMIENTO
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    
                    int aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }

        for (int i = 0; i < vector.length; i++) {
        	
        	if(vector[i] > mayor) {
        		
        		mayor = vector[i];
        	
        	}
        	}
        	
        	
        	

        for (int i = 0; i < vector.length; i++) {
            	
            	if(vector[i] < menor) {
            		
            		menor = vector[i];
            	
            	}
        
        
        
            		        }


        JOptionPane.showMessageDialog(null, "El mayor numero es: " + mayor +" el menor numero es "+ menor );
    
}


}
