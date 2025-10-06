package ejercicioExamen;

import javax.swing.*;
import java.awt.*;

public class BibliotecaFrame extends JFrame {
    private Biblioteca biblioteca;
    private Usuario usuario;
    private JTextArea areaLibros;

    public BibliotecaFrame(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Biblioteca - " + usuario.getTipo() + " - " + usuario.getNombre());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaLibros = new JTextArea();
        areaLibros.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaLibros);

        JPanel panelBotones = new JPanel(new FlowLayout());

        if (usuario instanceof UsuarioBasico) {
            JButton btnConsultar = new JButton("Consultar libros");
            JButton btnPrestar = new JButton("Prestar libro");
            JButton btnDevolver = new JButton("Devolver libro");
            panelBotones.add(btnConsultar);
            panelBotones.add(btnPrestar);
            panelBotones.add(btnDevolver);

            btnConsultar.addActionListener(e -> mostrarLibros());

            btnPrestar.addActionListener(e -> {
                String icbn = JOptionPane.showInputDialog(this, "Ingrese ICBN del libro:");
                if (icbn == null) return;
                boolean found = false;
                for (Libro l : biblioteca.getLibros()) {
                    if (l.getIcbn().equals(icbn)) {
                        found = true;
                        boolean ok = ((UsuarioBasico) usuario).prestarLibro(l);
                        if (ok) JOptionPane.showMessageDialog(this, "Libro prestado: " + l.getTitulo());
                        else JOptionPane.showMessageDialog(this, "No se pudo prestar (ya tiene uno o libro no disponible).", "Info", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                if (!found) JOptionPane.showMessageDialog(this, "ICBN no encontrado.");
                mostrarLibros();
            });

            btnDevolver.addActionListener(e -> {
                boolean ok = ((UsuarioBasico) usuario).devolverLibro();
                if (ok) JOptionPane.showMessageDialog(this, "Libro devuelto.");
                else JOptionPane.showMessageDialog(this, "No tiene libros prestados.", "Info", JOptionPane.INFORMATION_MESSAGE);
                mostrarLibros();
            });

        } else { // Bibliotecario
            JButton btnConsultar = new JButton("Consultar libros");
            JButton btnCambiarEstado = new JButton("Cambiar estado");
            JButton btnAgregar = new JButton("Agregar libro");
            panelBotones.add(btnConsultar);
            panelBotones.add(btnCambiarEstado);
            panelBotones.add(btnAgregar);

            btnConsultar.addActionListener(e -> mostrarLibros());

            btnCambiarEstado.addActionListener(e -> {
                String icbn = JOptionPane.showInputDialog(this, "Ingrese ICBN:");
                if (icbn == null) return;
                String estado = JOptionPane.showInputDialog(this, "Nuevo estado (Disponible/Prestado/Reservado/No disponible):");
                if (estado == null) return;
                boolean found = false;
                for (Libro l : biblioteca.getLibros()) {
                    if (l.getIcbn().equals(icbn)) {
                        found = true;
                        ((Bibliotecario) usuario).cambiarEstadoLibro(l, estado);
                        JOptionPane.showMessageDialog(this, "Estado cambiado.");
                        break;
                    }
                }
                if (!found) JOptionPane.showMessageDialog(this, "ICBN no encontrado.");
                mostrarLibros();
            });

            btnAgregar.addActionListener(e -> {
                if (biblioteca.getLibros().size() >= 20) {
                    JOptionPane.showMessageDialog(this, "Límite de libros alcanzado (20).");
                    return;
                }
                String icbn = JOptionPane.showInputDialog(this, "ICBN:");
                if (icbn == null) return;
                String titulo = JOptionPane.showInputDialog(this, "Título:");
                if (titulo == null) return;
                String autor = JOptionPane.showInputDialog(this, "Autor:");
                if (autor == null) return;
                String edStr = JOptionPane.showInputDialog(this, "Edición (número):");
                if (edStr == null) return;
                int ed = 1;
                try { ed = Integer.parseInt(edStr); } catch (NumberFormatException ex) { ed = 1; }
                biblioteca.agregarLibro(new Libro(icbn, titulo, autor, ed, Libro.DISPONIBLE));
                mostrarLibros();
            });
        }

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        mostrarLibros(); // mostrar al iniciar
    }

    private void mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro l : biblioteca.getLibros()) {
            sb.append(l.toString()).append("\n");
        }
        areaLibros.setText(sb.toString());
    }
}
