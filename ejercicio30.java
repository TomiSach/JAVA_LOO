package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio30 {

    public static void main(String[] args) {
        
        JTextArea area = new JTextArea(5, 10);
        JScrollPane scrollPane = new JScrollPane(area);
        
        int count = 0;
        for (int i = 25; i <= 35; i++) {
            if (i % 3 == 0) {
                count++;
            }
        }
        
        int[] array = new int[count];
        int index = 0;
        
        for (int i = 25; i <= 35; i++) {
            if (i % 3 == 0) {
                array[index] = i;
                index++;
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            area.append(array[i] + " ");
        }
        
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
