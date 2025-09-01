package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio27 {
    
    public static void main(String[] args) {
        
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz cuadrada"));
        
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese el elemento en fila " + (i+1) + ", columna " + (j+1))
                );
            }
        }

        JTextArea area = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(area);

        area.append("Matriz cargada:\n\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area.append(matriz[i][j] + "\t");
            }
            area.append("\n");
        }

        area.append("\nDiagonal Principal: ");
        for (int i = 0; i < n; i++) {
            area.append(matriz[i][i] + " ");
        }

        area.append("\nDiagonal Secundaria: ");
        for (int i = 0; i < n; i++) {
            area.append(matriz[i][n - 1 - i] + " ");
        }

        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
