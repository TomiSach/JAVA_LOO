package practicaClases;



import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ejercicio20 {
	
	
	public static void main(String[] args) {
	JTextArea area = new JTextArea(5,10);
	
	JScrollPane scrollPane = new JScrollPane(area);
	

   String [] nombres = {"Tomas","Adriel","Joe","Milagros","Gino"};
	for(int i = 0; i < nombres.length; i++) {
		
		area.append(nombres[i] + "\n");
	}
	JOptionPane.showMessageDialog(null, scrollPane);
        
    }
}

