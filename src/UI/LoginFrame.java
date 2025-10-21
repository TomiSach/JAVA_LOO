package UI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import LOGICA.Biblioteca;
import LOGICA.Usuario;

public class LoginFrame extends JFrame {
	private JTextField emailField;
	private JPasswordField passField;
	private Biblioteca biblioteca;

	public LoginFrame(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;

		setTitle("Biblioteca Virtual - Login");
		setSize(320, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 2, 5, 5));

		add(new JLabel("Email:"));
		emailField = new JTextField();
		add(emailField);

		add(new JLabel("Contraseña:"));
		passField = new JPasswordField();
		add(passField);

		JButton loginButton = new JButton("Ingresar");
		add(new JLabel());
		add(loginButton);

		loginButton.addActionListener(e -> {
			String email = emailField.getText().trim();
			String pass = new String(passField.getPassword());
			Usuario usuario = biblioteca.login(email, pass);

			if (usuario != null) {
				JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getNombre());
				dispose();
				BibliotecaFrame bf = new BibliotecaFrame(biblioteca, usuario);
				bf.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Usuario/contraseña incorrectos o inactivo", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}

//action listener apartir de un solo boton y anido case o if 
//