package ejercicioExamen; // Define que esta clase pertenece al paquete 'ejercicioExamen'.

import javax.swing.*; // Importa las clases de Swing para la interfaz gráfica (ventanas, botones, etc.).
import java.awt.*; // Importa clases de AWT para el manejo de layouts y eventos.

public class LoginFrame extends JFrame { // Declara una clase pública que hereda de JFrame, convirtiéndola en una ventana.
    private JTextField emailField; // Declara un campo de texto para que el usuario ingrese su email.
    private JPasswordField passField; // Declara un campo de texto especial para contraseñas (oculta los caracteres).
    private Biblioteca biblioteca; // Declara una referencia al objeto principal 'Biblioteca'.

    public LoginFrame(Biblioteca biblioteca) { // Define el constructor, que se ejecuta al crear un objeto 'LoginFrame'.
        this.biblioteca = biblioteca; // Asigna el objeto 'biblioteca' recibido al campo de la clase para poder usarlo.

        setTitle("Biblioteca Virtual - Login"); // Establece el texto que aparecerá en la barra de título de la ventana.
        setSize(320, 180); // Establece el tamaño de la ventana en píxeles (ancho, alto).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que el programa se cerrará cuando se cierre esta ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla al aparecer.
        setLayout(new GridLayout(3, 2, 5, 5)); // Establece un layout de rejilla (3 filas, 2 columnas) con 5px de espacio entre componentes.

        add(new JLabel("Email:")); // Crea y añade una etiqueta de texto "Email:" a la ventana.
        emailField = new JTextField(); // Crea una nueva instancia del campo de texto para el email.
        add(emailField); // Añade el campo de texto del email a la ventana.

        add(new JLabel("Contraseña:")); // Crea y añade una etiqueta de texto "Contraseña:" a la ventana.
        passField = new JPasswordField(); // Crea una nueva instancia del campo de texto para la contraseña.
        add(passField); // Añade el campo de texto de la contraseña a la ventana.

        JButton loginButton = new JButton("Ingresar"); // Crea un nuevo botón con el texto "Ingresar".
        add(new JLabel()); // Añade una etiqueta vacía como relleno para ocupar un espacio en la rejilla.
        add(loginButton); // Añade el botón de "Ingresar" a la ventana.

        loginButton.addActionListener(e -> { // Añade un "oyente de acción" al botón para ejecutar código cuando se haga clic.
            String email = emailField.getText().trim(); // Obtiene el texto del campo email y elimina espacios en blanco al inicio y final.
            String pass = new String(passField.getPassword()); // Obtiene la contraseña del campo de contraseña y la convierte a un String.
            Usuario usuario = biblioteca.login(email, pass); // Llama al método 'login' de la biblioteca para verificar las credenciales.

            if (usuario != null) { // Comprueba si el método 'login' devolvió un usuario (inicio de sesión exitoso).
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getNombre()); // Muestra un cuadro de diálogo de bienvenida.
                dispose(); // Cierra y elimina la ventana de login actual.
                BibliotecaFrame bf = new BibliotecaFrame(biblioteca, usuario); // Crea la ventana principal de la biblioteca, pasándole los datos necesarios.
                bf.setVisible(true); // Hace visible la nueva ventana principal de la biblioteca.
            } else { // Si el inicio de sesión falló ('usuario' es nulo).
                JOptionPane.showMessageDialog(this, "Usuario/contraseña incorrectos o inactivo", "Error", JOptionPane.ERROR_MESSAGE); // Muestra un cuadro de diálogo de error.
            }
        });
    }
}
