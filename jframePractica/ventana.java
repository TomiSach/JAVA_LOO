package jframePractica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ventana extends JFrame {

    public JPanel panel;

    public ventana() {
        this.setSize(500, 500);
        setTitle("El mejor titulo");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiquetas();
    }

    private void colocarPaneles() {
        panel = new JPanel(); // ahora inicializa el atributo
        panel.setLayout(null); // importante si usas setBounds
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("ESE 4-0 NO SE OLVIDA MAS");
        etiqueta.setBounds(50, 10, 400, 40);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.white);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.black);
        etiqueta.setFont(new Font("arial", Font.ITALIC, 20));
        panel.add(etiqueta);

        // Imagen
        ImageIcon icono = new ImageIcon(getClass().getResource("/jframePractica/clown.jpg"));
        JLabel etiqueta2 = new JLabel(icono);
        etiqueta2.setBounds(80, 80, 300, 300);
        etiqueta2.setIcon(new ImageIcon(icono.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etiqueta2);
    }
}
