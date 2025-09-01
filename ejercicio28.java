package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio28 {

    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz cuadrada"));

        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese el elemento en fila " + (i + 1) + ", columna " + (j + 1))
                );
            }
        }

        JTextArea area = new JTextArea(15, 25);
        JScrollPane scrollPane = new JScrollPane(area);

        int diagonalP = 0; 
        int diagonalS = 0; 

        area.append("Matriz cargada:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area.append(matriz[i][j] + "\t");
            }
            area.append("\n");
        }

        area.append("\nDiagonal Principal: ");
        for (int i = 0; i < n; i++) {
            area.append(matriz[i][i] + " ");
            diagonalP += matriz[i][i];
        }

        area.append("\nDiagonal Secundaria: ");
        for (int i = 0; i < n; i++) {
            area.append(matriz[i][n - 1 - i] + " ");
            diagonalS += matriz[i][n - 1 - i];
        }

        int productoDiagonales = diagonalP * diagonalS;
        area.append("\n\nProducto entre las diagonales: " + productoDiagonales);

        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
