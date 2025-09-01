package practicaClases;

import javax.swing.JOptionPane;

public class ejercicio14 {

    public static void main(String[] args) {

        String[] opt = { "Agua", "Fideos", "Arroz", "Huevo", "Leche","Salir" };

        String selectedOpt = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción",
                "Menú de compras",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opt,
                opt[0]
        );

        double total = 0.0;

        
        int cantAgua = 0;
        int cantFideos = 0;
        int cantArroz = 0;
        int cantHuevo = 0;
        int cantLeche = 0;
        
        
        while (selectedOpt != "Salir") {

            switch (selectedOpt) {
                case "Agua":
                    total += 12;
                    cantAgua += 1;
                    break;
                case "Fideos":
                    total += 15;
                    cantFideos += 1;
                    break;
                case "Arroz":
                    total += 8;
                    cantArroz += 1;
                    break;
                case "Huevo":
                    total += 7.5;
                    cantHuevo += 1;
                    break;
                case "Leche":
                    total += 6;
                    cantLeche += 1;
                    break;
                default:
                    break;
            }

            selectedOpt = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Menú de compras",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opt,
                    opt[0]
            );
        }

        JOptionPane.showMessageDialog(
                null,
                "El total de su compra es: " + total + "$"
                +"\n Agua: " + cantAgua
                +"\n Fideos: " + cantFideos
                +"\n Arroz: " + cantArroz
                +"\n Huevo: " + cantHuevo
                +"\n Leche: " + cantLeche
                ,
                "Compra finalizada",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}

