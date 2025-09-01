package practicaClases;

import javax.swing.JOptionPane;

public class Ejercicio16 {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno (o Cancelar para salir)");

        while (nombre != null) {
            
            String curso = JOptionPane.showInputDialog("Ingrese el curso al cual pertenece");
            String division = JOptionPane.showInputDialog("Ingrese la división");

            int faltasJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de faltas justificadas"));
            int faltasI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de faltas injustificadas"));

            // Total de faltas
            int faltasTotales = faltasJ + faltasI;

            // Porcentaje de injustificadas sobre el total
            double porcentajeInjustificadas = (faltasI * 100.0) / faltasTotales;

            String condicion;

            if (faltasTotales < 15) {
                condicion = "ALUMNO REGULAR";
            } else {
                if (porcentajeInjustificadas <= 30) {
                    condicion = "ALUMNO REINCORPORADO";
                } else {
                    condicion = "ALUMNO LIBRE";
                }
            }

            // Mostrar resultados
            String mensaje = "Nombre: " + nombre +
                             "\nCurso: " + curso +
                             "\nDivisión: " + division +
                             "\nFaltas Justificadas: " + faltasJ +
                             "\nFaltas Injustificadas: " + faltasI +
                             "\nFaltas Totales: " + faltasTotales +
                             "\nPorcentaje Injustificadas: " + String.format("%.2f", porcentajeInjustificadas) + "%" +
                             "\nCondición: " + condicion;

            JOptionPane.showMessageDialog(null, mensaje);

            // Pedimos el próximo nombre o cortamos
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno (o Cancelar para salir)");
        }

        JOptionPane.showMessageDialog(null, "Programa finalizado");
    }
}
