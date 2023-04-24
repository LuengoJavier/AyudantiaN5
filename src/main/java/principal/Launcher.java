package principal;
import controller.RegistroController;
import View.VentanaIngreso;
public class Launcher {

	public static void main(String[] args) {
		RegistroController registroController = new RegistroController();
		registroController.cargarCuentas();
		VentanaIngreso ventanaIngreso = new VentanaIngreso(registroController);
	}
}