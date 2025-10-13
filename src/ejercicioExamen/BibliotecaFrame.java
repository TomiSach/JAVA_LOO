package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

import javax.swing.*; // Importa las clases de Swing para la interfaz gráfica.
import java.awt.*; // Importa las clases de AWT para layouts y otros componentes gráficos.

public class BibliotecaFrame extends JFrame { // Declara una clase pública que hereda de JFrame, convirtiéndola en una ventana principal.
    private Biblioteca biblioteca; // Declara una referencia al objeto que contiene los datos de la biblioteca.
    private Usuario usuario; // Declara una referencia al usuario que ha iniciado sesión.
    private JTextArea areaLibros; // Declara el área de texto donde se mostrará la lista de libros.

    public BibliotecaFrame(Biblioteca biblioteca, Usuario usuario) { // Define el constructor de la ventana, que recibe la biblioteca y el usuario.
        this.biblioteca = biblioteca; // Asigna el objeto 'biblioteca' recibido al campo de la clase.
        this.usuario = usuario; // Asigna el objeto 'usuario' recibido al campo de la clase.

        setTitle("Biblioteca - " + usuario.getTipo() + " - " + usuario.getNombre()); // Establece el título de la ventana, personalizándolo con el tipo y nombre del usuario.
        setSize(600, 400); // Establece el tamaño de la ventana en píxeles.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la aplicación para que se cierre al cerrar esta ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.

        areaLibros = new JTextArea(); // Crea una nueva instancia del área de texto.
        areaLibros.setEditable(false); // Impide que el usuario pueda escribir directamente en el área de texto.
        JScrollPane scroll = new JScrollPane(areaLibros); // Crea un panel con barras de desplazamiento y le añade el área de texto.

        JPanel panelBotones = new JPanel(new FlowLayout()); // Crea un nuevo panel para los botones con un layout que los alinea horizontalmente.

        if (usuario instanceof UsuarioBasico) { // Comprueba si el usuario logueado es una instancia de 'UsuarioBasico'.
            JButton btnConsultar = new JButton("Consultar libros"); // Crea un botón para consultar libros.
            JButton btnPrestar = new JButton("Prestar libro"); // Crea un botón para prestar un libro.
            JButton btnDevolver = new JButton("Devolver libro"); // Crea un botón para devolver un libro.
            panelBotones.add(btnConsultar); // Añade el botón de consultar al panel de botones.
            panelBotones.add(btnPrestar); // Añade el botón de prestar al panel de botones.
            panelBotones.add(btnDevolver); // Añade el botón de devolver al panel de botones.

            btnConsultar.addActionListener(e -> mostrarLibros()); // Asigna una acción al botón consultar: llamar al método 'mostrarLibros'.

            btnPrestar.addActionListener(e -> { // Asigna una acción al botón de prestar.
                String icbn = JOptionPane.showInputDialog(this, "Ingrese ICBN del libro:"); // Muestra un cuadro de diálogo para que el usuario ingrese un ICBN.
                if (icbn == null) return; // Si el usuario presiona "Cancelar", no hace nada.
                boolean found = false; // Declara una bandera para saber si se encontró el libro.
                for (Libro l : biblioteca.getLibros()) { // Recorre la lista de todos los libros de la biblioteca.
                    if (l.getIcbn().equals(icbn)) { // Si el ICBN del libro coincide con el ingresado.
                        found = true; // Marca que el libro fue encontrado.
                        boolean ok = ((UsuarioBasico) usuario).prestarLibro(l); // Intenta prestar el libro (hace un cast a 'UsuarioBasico' para usar su método).
                        if (ok) JOptionPane.showMessageDialog(this, "Libro prestado: " + l.getTitulo()); // Si el préstamo fue exitoso, muestra un mensaje de confirmación.
                        else JOptionPane.showMessageDialog(this, "No se pudo prestar (ya tiene uno o libro no disponible).", "Info", JOptionPane.INFORMATION_MESSAGE); // Si no, muestra un mensaje informativo.
                        break; // Sale del bucle porque ya encontró el libro.
                    }
                }
                if (!found) JOptionPane.showMessageDialog(this, "ICBN no encontrado."); // Si el bucle termina y no se encontró el libro, muestra un mensaje.
                mostrarLibros(); // Actualiza la lista de libros en pantalla.
            });

            btnDevolver.addActionListener(e -> { // Asigna una acción al botón de devolver.
                boolean ok = ((UsuarioBasico) usuario).devolverLibro(); // Intenta devolver el libro que tiene el usuario (hace un cast para usar el método).
                if (ok) JOptionPane.showMessageDialog(this, "Libro devuelto."); // Si la devolución fue exitosa, muestra un mensaje.
                else JOptionPane.showMessageDialog(this, "No tiene libros prestados.", "Info", JOptionPane.INFORMATION_MESSAGE); // Si no, informa que no tenía libros.
                mostrarLibros(); // Actualiza la lista de libros en pantalla.
            });

        } else { // Si el usuario no es 'UsuarioBasico', entonces es 'Bibliotecario'.
            JButton btnConsultar = new JButton("Consultar libros"); // Crea el botón de consultar.
            JButton btnCambiarEstado = new JButton("Cambiar estado"); // Crea el botón para cambiar el estado de un libro.
            JButton btnAgregar = new JButton("Agregar libro"); // Crea el botón para agregar un nuevo libro.
            panelBotones.add(btnConsultar); // Añade el botón al panel.
            panelBotones.add(btnCambiarEstado); // Añade el botón al panel.
            panelBotones.add(btnAgregar); // Añade el botón al panel.

            btnConsultar.addActionListener(e -> mostrarLibros()); // Asigna la acción de mostrar libros al botón de consultar.

            btnCambiarEstado.addActionListener(e -> { // Asigna una acción al botón de cambiar estado.
                String icbn = JOptionPane.showInputDialog(this, "Ingrese ICBN:"); // Pide el ICBN del libro a modificar.
                if (icbn == null) return; // Si cancela, no hace nada.
                String estado = JOptionPane.showInputDialog(this, "Nuevo estado (Disponible/Prestado/Reservado/No disponible):"); // Pide el nuevo estado.
                if (estado == null) return; // Si cancela, no hace nada.
                boolean found = false; // Bandera para saber si se encontró el libro.
                for (Libro l : biblioteca.getLibros()) { // Recorre la lista de libros.
                    if (l.getIcbn().equals(icbn)) { // Si encuentra el libro por su ICBN.
                        found = true; // Marca como encontrado.
                        ((Bibliotecario) usuario).cambiarEstadoLibro(l, estado); // Cambia el estado del libro (hace un cast a 'Bibliotecario').
                        JOptionPane.showMessageDialog(this, "Estado cambiado."); // Muestra un mensaje de confirmación.
                        break; // Sale del bucle.
                    }
                }
                if (!found) JOptionPane.showMessageDialog(this, "ICBN no encontrado."); // Si no lo encontró, muestra un mensaje.
                mostrarLibros(); // Actualiza la lista en pantalla.
            });

            btnAgregar.addActionListener(e -> { // Asigna una acción al botón de agregar libro.
                if (biblioteca.getLibros().size() >= 20) { // Comprueba si ya se alcanzó el límite de 20 libros.
                    JOptionPane.showMessageDialog(this, "Límite de libros alcanzado (20)."); // Si es así, muestra un mensaje de error.
                    return; // Y no continúa.
                }
                String icbn = JOptionPane.showInputDialog(this, "ICBN:"); // Pide el ICBN del nuevo libro.
                if (icbn == null) return; // Si cancela, no hace nada.
                String titulo = JOptionPane.showInputDialog(this, "Título:"); // Pide el título del nuevo libro.
                if (titulo == null) return; // Si cancela, no hace nada.
                String autor = JOptionPane.showInputDialog(this, "Autor:"); // Pide el autor del nuevo libro.
                if (autor == null) return; // Si cancela, no hace nada.
                String edStr = JOptionPane.showInputDialog(this, "Edición (número):"); // Pide la edición del nuevo libro como texto.
                if (edStr == null) return; // Si cancela, no hace nada.
                int ed = 1; // Declara la variable para la edición con un valor por defecto.
                try { ed = Integer.parseInt(edStr); } catch (NumberFormatException ex) { ed = 1; } // Intenta convertir el texto a número; si falla, usa el valor por defecto.
                biblioteca.agregarLibro(new Libro(icbn, titulo, autor, ed, Libro.DISPONIBLE)); // Crea el nuevo libro y lo añade a la biblioteca.
                mostrarLibros(); // Actualiza la lista en pantalla.
            });
        }

        add(scroll, BorderLayout.CENTER); // Añade el panel con el área de texto al centro de la ventana.
        add(panelBotones, BorderLayout.SOUTH); // Añade el panel con los botones en la parte inferior de la ventana.

        mostrarLibros(); // Llama al método para mostrar los libros tan pronto como se crea la ventana.
    }

    private void mostrarLibros() { // Método privado para actualizar la lista de libros en el JTextArea.
        StringBuilder sb = new StringBuilder(); // Crea un 'StringBuilder' para construir eficientemente el texto a mostrar.
        for (Libro l : biblioteca.getLibros()) { // Recorre la lista de libros de la biblioteca.
            sb.append(l.toString()).append("\n"); // Añade la representación en texto de cada libro, seguida de un salto de línea.
        }
        areaLibros.setText(sb.toString()); // Establece el texto construido como el contenido del área de texto.
    }
}
