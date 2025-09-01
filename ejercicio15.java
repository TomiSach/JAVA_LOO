package practicaClases;

import javax.swing.JOptionPane;

public class ejercicio15 {

    public static void main(String[] args) {

        int votoMasc = 0;
        int votoFem = 0;

        int cantVoto1 = 0;
        int cantVoto2 = 0;
        int cantVoto3 = 0;
        int cantVoto4 = 0;
        int votosBlanco = 0;
        int totalVotos = 0;

        // Bucle principal
        while (true) {

            // Seleccionar sexo
            String[] sexo = { "Masculino", "Femenino", "Salir" };
            String selectedSex = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Seleccione su género",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    sexo,
                    sexo[0]);

            if (selectedSex == null || selectedSex.equals("Salir")) {
                break; // salir del bucle
            }

            // Contar según género
            if (selectedSex.equals("Masculino")) {
                votoMasc++;
            } else if (selectedSex.equals("Femenino")) {
                votoFem++;
            }

            // Seleccionar voto
            String[] voto = { "1", "2", "3", "4", "Blanco" };
            String selectedVoto = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción para votar",
                    "Seleccione su candidato",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    voto,
                    voto[0]);

            if (selectedVoto == null) {
                break; // si cancela
            }

            switch (selectedVoto) {
                case "1":
                    cantVoto1++;
                    break;
                case "2":
                    cantVoto2++;
                    break;
                case "3":
                    cantVoto3++;
                    break;
                case "4":
                    cantVoto4++;
                    break;
                case "Blanco":
                    votosBlanco++;
                    break;
            }

            totalVotos++;
        }

        // Variables para porcentajes
        double porc1 = 0;
        double porc2 = 0;
        double porc3 = 0;
        double porc4 = 0;
        double porcBlanco = 0;

        // Calcular porcentajes solo si hay votos
        if (totalVotos > 0) {
            porc1 = (cantVoto1 * 100.0) / totalVotos;
            porc2 = (cantVoto2 * 100.0) / totalVotos;
            porc3 = (cantVoto3 * 100.0) / totalVotos;
            porc4 = (cantVoto4 * 100.0) / totalVotos;
            porcBlanco = (votosBlanco * 100.0) / totalVotos;
        }

        // Mostrar resultados
        String resultado = "Resultados:\n"
                + "Votantes masculinos: " + votoMasc + "\n"
                + "Votantes femeninos: " + votoFem + "\n\n"
                + "Votos candidato 1: " + cantVoto1 + " (" + String.format("%.2f", porc1) + "%)\n"
                + "Votos candidato 2: " + cantVoto2 + " (" + String.format("%.2f", porc2) + "%)\n"
                + "Votos candidato 3: " + cantVoto3 + " (" + String.format("%.2f", porc3) + "%)\n"
                + "Votos candidato 4: " + cantVoto4 + " (" + String.format("%.2f", porc4) + "%)\n"
                + "Votos en blanco: " + votosBlanco + " (" + String.format("%.2f", porcBlanco) + "%)\n"
                + "Total votos: " + totalVotos;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
