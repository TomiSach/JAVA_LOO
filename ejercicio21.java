package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio21 {

    public static void main(String[] args) {
        
        JTextArea area = new JTextArea(5, 10);
        JScrollPane scrollPane = new JScrollPane(area);

        int[] Vector = new int[10]; // tamaño fijo de 10 elementos

        // Carga de datos
        for (int i = 0; i < Vector.length; i++) {
            int entrada = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el elemento N° " + (i + 1) + " del vector")
            );
            Vector[i] = entrada;
        }

        // Mostrar datos en el JTextArea
        for (int i = 0; i < Vector.length; i++) {
            area.append(Vector[i] + "\n");
        }

        // Mostrar en un JOptionPane con scroll
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
