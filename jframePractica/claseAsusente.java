package jframePractica;

import javax.swing.*; // Librerías de Swing (ventanas, botones, labels, etc.)
import java.awt.*;    // Librerías para Layouts (GridLayout, BorderLayout)

public class claseAsusente {
    // Ventana principal
    private JFrame frame;

    // Paneles principales: uno para el formulario y otro para la confirmación
    private JPanel panelFormulario;
    private JPanel panelConfirmacion;

    // Campos de texto donde el usuario escribe
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtCodigoPostal;

    // Labels que mostrarán los datos en el panel de confirmación
    private JLabel lblNombreConf;
    private JLabel lblApellidoConf;
    private JLabel lblDireccionConf;
    private JLabel lblCodigoConf;

    // Constructor → se ejecuta al crear la clase
    public claseAsusente() {
        // Crear la ventana principal
        frame = new JFrame("Formulario de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // al cerrar se termina el programa
        frame.setSize(400, 300); // tamaño inicial (ancho x alto)

        // Construimos los dos paneles (formulario y confirmación)
        crearPanelFormulario();
        crearPanelConfirmacion();

        // Mostrar el formulario primero
        frame.add(panelFormulario);
        frame.setVisible(true); // hacer visible la ventana
    }

    // Panel del formulario con campos y botones
    private void crearPanelFormulario() {
        // BorderLayout divide el panel en zonas (NORTH, CENTER, SOUTH, EAST, WEST)
        panelFormulario = new JPanel(new BorderLayout());

        // GridLayout crea una cuadrícula 4 filas x 2 columnas, con espacio entre celdas
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen de 10 px

        // Etiqueta + campo de texto para Nombre
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        // Etiqueta + campo de texto para Apellido
        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelCampos.add(txtApellido);

        // Etiqueta + campo de texto para Dirección
        panelCampos.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelCampos.add(txtDireccion);

        // Etiqueta + campo de texto para Código Postal
        panelCampos.add(new JLabel("Código Postal:"));
        txtCodigoPostal = new JTextField();
        panelCampos.add(txtCodigoPostal);

        // Panel para los botones (colocados en fila con FlowLayout)
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnSalir = new JButton("Salir");

        // Añadimos los botones al panel de botones
        panelBotones.add(btnAceptar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnSalir);

        // Eventos de los botones
        btnAceptar.addActionListener(e -> mostrarConfirmacion()); // abre el panel de confirmación
        btnBorrar.addActionListener(e -> limpiarCampos());        // borra los campos
        btnSalir.addActionListener(e -> System.exit(0));          // cierra el programa

        // Agregamos las secciones al panel principal
        panelFormulario.add(panelCampos, BorderLayout.CENTER); // los campos al centro
        panelFormulario.add(panelBotones, BorderLayout.SOUTH); // botones abajo
    }

    // Panel de confirmación para mostrar lo que se ingresó
    private void crearPanelConfirmacion() {
        panelConfirmacion = new JPanel(new BorderLayout());

        // GridLayout para mostrar los datos confirmados (igual que el formulario)
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiquetas vacías que se llenarán con los datos ingresados
        panelDatos.add(new JLabel("Nombre:"));
        lblNombreConf = new JLabel();
        panelDatos.add(lblNombreConf);

        panelDatos.add(new JLabel("Apellido:"));
        lblApellidoConf = new JLabel();
        panelDatos.add(lblApellidoConf);

        panelDatos.add(new JLabel("Dirección:"));
        lblDireccionConf = new JLabel();
        panelDatos.add(lblDireccionConf);

        panelDatos.add(new JLabel("Código Postal:"));
        lblCodigoConf = new JLabel();
        panelDatos.add(lblCodigoConf);

        // Botones para editar o confirmar
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnEditar = new JButton("Editar");
        JButton btnConfirmar = new JButton("Confirmar");

        // Si aprieto "Editar" → vuelvo al formulario
        btnEditar.addActionListener(e -> volverFormulario());

        // Si aprieto "Confirmar" → muestro un mensaje y vuelvo al formulario
        btnConfirmar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Datos confirmados ✅");
            volverFormulario();
        });

        // Agrego los botones al panel
        panelBotones.add(btnEditar);
        panelBotones.add(btnConfirmar);

        // Agrego todo al panel principal de confirmación
        panelConfirmacion.add(panelDatos, BorderLayout.CENTER);
        panelConfirmacion.add(panelBotones, BorderLayout.SOUTH);
    }

    // Muestra el panel de confirmación con los datos ingresados
    private void mostrarConfirmacion() {
        // Copio el texto de los campos de texto a las etiquetas
        lblNombreConf.setText(txtNombre.getText());
        lblApellidoConf.setText(txtApellido.getText());
        lblDireccionConf.setText(txtDireccion.getText());
        lblCodigoConf.setText(txtCodigoPostal.getText());

        // Cambio el panel visible: saco lo que había y pongo el panel de confirmación
        frame.getContentPane().removeAll();
        frame.add(panelConfirmacion);
        frame.revalidate(); // recalcula el layout
        frame.repaint();    // redibuja la ventana
    }

    // Vuelve al formulario
    private void volverFormulario() {
        frame.getContentPane().removeAll();
        frame.add(panelFormulario);
        frame.revalidate();
        frame.repaint();
    }

    // Limpia los campos del formulario
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtCodigoPostal.setText("");
    }

    // Método principal → arranca el programa
    public static void main(String[] args) {
        // Ejecutamos la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(claseAsusente::new);
    }
}
