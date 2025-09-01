package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio26 {
    
    public static void main(String[] args) {
        
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas"));

        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese el elemento en fila " + (i+1) + ", columna " + (j+1))
                );
            }
        }

        JTextArea area = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(area);

        area.append("Matriz cargada:\n\n");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                area.append(matriz[i][j] + "\t"); 
            }
            area.append("\n");
        }

        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
