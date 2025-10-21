package UI;

// Imports de Swing y AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Imports de LÓGICA
import LOGICA.Biblioteca;
import LOGICA.Libro;
import LOGICA.Usuario;
import LOGICA.UsuarioBasico;
import LOGICA.Bibliotecario;

public class BibliotecaFrame extends JFrame implements ActionListener { 
    private Biblioteca biblioteca;
    private Usuario usuario;
    private JTextArea areaLibros;

    // Campos para los botones
    private JButton btnConsultar;
    private JButton btnPrestar;
    private JButton btnDevolver;
    private JButton btnCambiarEstado;
    private JButton btnAgregar;


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

        // --- Configuración de botones (sin cambios) ---
        if (usuario instanceof UsuarioBasico) {
            btnConsultar = new JButton("Consultar libros");
            btnPrestar = new JButton("Prestar libro");
            btnDevolver = new JButton("Devolver libro");
            
            panelBotones.add(btnConsultar);
            panelBotones.add(btnPrestar);
            panelBotones.add(btnDevolver);

            btnConsultar.addActionListener(this);
            btnPrestar.addActionListener(this);
            btnDevolver.addActionListener(this);

        } else { // Bibliotecario
            btnConsultar = new JButton("Consultar libros");
            btnCambiarEstado = new JButton("Cambiar estado");
            btnAgregar = new JButton("Agregar libro");

            panelBotones.add(btnConsultar);
            panelBotones.add(btnCambiarEstado);
            panelBotones.add(btnAgregar);

            btnConsultar.addActionListener(this);
            btnCambiarEstado.addActionListener(this);
            btnAgregar.addActionListener(this);
        }

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        mostrarLibros();
    }

    /**
     * Actualiza el JTextArea con la lista de libros.
     */
    private void mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro l : biblioteca.getLibros()) {
            sb.append(l.toString()).append("\n");
        }
        areaLibros.setText(sb.toString());
    }

    //
    // --- LÓGICA DE EVENTOS (Adaptada al estilo del profesor) ---
    //
    
    /**
     * Listener centralizado. Redirige la acción al método privado correspondiente.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object botonPulsado = e.getSource();

        if (botonPulsado == btnConsultar) {
            accionConsultar();
            
        } else if (botonPulsado == btnPrestar) {
            accionPrestar();
            
        } else if (botonPulsado == btnDevolver) {
            accionDevolver();
            
        } else if (botonPulsado == btnCambiarEstado) {
            accionCambiarEstado();
            
        } else if (botonPulsado == btnAgregar) {
            accionAgregar();
        }
    }

    // --- MÉTODOS PRIVADOS PARA CADA ACCIÓN ---
    // (Este es el estilo que usa tu profesor, como sus métodos "mostrar()" o "salida()")

    private void accionConsultar() {
        mostrarLibros();
    }

    private void accionPrestar() {
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
    }

    private void accionDevolver() {
        boolean ok = ((UsuarioBasico) usuario).devolverLibro();
        if (ok) JOptionPane.showMessageDialog(this, "Libro devuelto.");
        else JOptionPane.showMessageDialog(this, "No tiene libros prestados.", "Info", JOptionPane.INFORMATION_MESSAGE);
        mostrarLibros();
    }

    private void accionCambiarEstado() {
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
    }

    private void accionAgregar() {
        String icbn = JOptionPane.showInputDialog(this, "ICBN:");
        if (icbn == null) return;
        String titulo = JOptionPane.showInputDialog(this, "Título:");
        if (titulo == null) return;
        String autor = JOptionPane.showInputDialog(this, "Autor:");
        if (autor == null) return;
        String edStr = JOptionPane.showInputDialog(this, "Edición (número):");
        if (edStr == null) return;
        int ed = 1;
        try { 
            ed = Integer.parseInt(edStr); 
        } catch (NumberFormatException ex) { 
            // Podrías poner un aviso aquí si quisieras
            ed = 1; 
        }
        
        Libro nuevoLibro = new Libro(icbn, titulo, autor, ed, Libro.DISPONIBLE);
        // Usamos la versión de 'agregarLibro' que devuelve boolean
        boolean fueAgregado = biblioteca.agregarLibro(nuevoLibro); 
        
        if(fueAgregado) {
            JOptionPane.showMessageDialog(this, "Libro agregado.");
            mostrarLibros();
        } else {
            // El mensaje de error viene de la lógica de 'agregarLibro' (que devuelve false)
            JOptionPane.showMessageDialog(this, "Límite de libros alcanzado (20).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}