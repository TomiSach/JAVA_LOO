package ejercicioExamen;

public class Main {
	public static void main(String[] args) {
		// 1. Crear la instancia de la biblioteca
		Biblioteca biblioteca = new Biblioteca();

		// 2. Cargar los datos iniciales usando la nueva clase
		DatosIniciales.cargar(biblioteca);

		// 3. Iniciar la interfaz gráfica
		LoginFrame login = new LoginFrame(biblioteca);
		login.setVisible(true);
	}
}