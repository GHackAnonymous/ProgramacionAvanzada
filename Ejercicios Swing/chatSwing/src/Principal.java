import java.util.ArrayList;

public class Principal {

	Chat chat;
	ArrayList<Usuario> usuarios;
	
	public Principal(){
		chat = new Chat();
		usuarios = new ArrayList<>();
		inicializar();
		crearVentanasUsuarios();
	}
	private void crearVentanasUsuarios() {
	   for (int i = 0; i < usuarios.size(); i++){
		   VentanaUsuario ventana = new VentanaUsuario (i,usuarios.get(i),chat);
	   }
	}
	private void inicializar() {
		usuarios.add(new Usuario("Eder"));
		usuarios.add(new Usuario("Nerea"));
		usuarios.add(new Usuario("Jesus"));
	}
	public static void main(String[] args) {
		Principal ejercicio = new Principal();
	}
}
