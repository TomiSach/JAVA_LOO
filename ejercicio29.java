package practicaClases;



import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio29 {
	
	public static void main(String[] args) {
		
		
		int [] array = {87, 12, 45, 3, 99, 56, 78, 23, 41, 65,
		              5, 90, 34, 77, 2, 18, 49, 88, 61, 7,
		              26, 33, 80, 54, 11, 70, 96, 38, 29, 14,
		              67, 42, 21, 55, 8, 19, 84, 93, 31, 47,
		              62, 9, 71, 24, 16, 37, 50, 60, 85, 6,
		              39, 27, 91, 10, 46, 32, 72, 53, 20, 4,
		              17, 64, 79, 1, 30, 36, 48, 22, 66, 13,
		              73, 25, 52, 40, 68, 44, 81, 58, 35, 76,
		              51, 83, 28, 15, 59, 74, 43, 95, 86, 63,
		              82, 0, 97, 75, 6, 98, 89, 57, 94, 69};
		
	
		JTextArea area = new JTextArea(15, 25);
        JScrollPane scrollPane = new JScrollPane(area);		
		
        
        
        
        area.append("Array modificado \n");
	for (int i = 0; i < array.length; i++) {
			if(array[i] <= 100) {
		
				array [i] = array[i] + 5;	
			}
			
			area.append(array[i]+ "\n ");
		
	}
	
	JOptionPane.showInternalMessageDialog(null, scrollPane);
		
		
		
		
		
	}

}
