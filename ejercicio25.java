package practicaClases;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ejercicio25 {
	
	public static void main(String[] args) {
		
		JTextArea area = new JTextArea(5, 10);
        JScrollPane scrollPane = new JScrollPane(area);
		
		int[][] matriz = {
		    {7, 5},
		    {6, 8}
		};

		int filas = matriz.length;          // cantidad de filas
		int columnas = matriz[0].length;    // cantidad de columnas

		for (int i = 0; i < filas; i++) {
		    for (int j = 0; j < columnas; j++) {
		        // Convertimos a String y agregamos espacio
		        area.append(matriz[i][j] + "  \n");
		    }
		}

		JOptionPane.showMessageDialog(null, scrollPane);
	}
}
