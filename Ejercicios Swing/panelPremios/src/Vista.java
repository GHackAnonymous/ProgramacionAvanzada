
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista{
	
	JFrame ventana;
	JLabel texto;
	JTextField userPremio;
	Modelo2 modelo;
	Controlador controlador;
	//JButton[] listaBotones;
	
	public Vista(Modelo2 modelo,int posX,int posY){
		
		//listaBotones = new JButton[7];
		
		ventana = new JFrame("Tablero de Primos");
		
		this.modelo = modelo;
		
		controlador = new Controlador(this,modelo);
		ventana.setLocation(posX,posY);
		ventana.setSize(700, 700);
		
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel  = new JPanel(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		panel.add(crearPanelBox(), BorderLayout.NORTH);
		panel.add(crearPanelBotones(), BorderLayout.CENTER);
		panel.add(crearPanelBSalir(), BorderLayout.SOUTH);
		
		return panel;
	}
	
	private Component crearPanelBox() {
		JPanel panel = new JPanel(new BorderLayout(5,5));
		texto = new JLabel("Premio Acumulado");
		userPremio = new JTextField("0");
		userPremio.setEditable(false);

		panel.add(texto,BorderLayout.WEST);
		panel.add(userPremio,BorderLayout.CENTER);
		
		return panel;
	}
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(6,6,0,0));
		for(int i = 0;i < 6; i++){
			for(int e = 0; e < 6; e++){
				int primo = controlador.damePrimo();
				panel.add(crearBoton(""+primo+""));
			}
		}
		return panel;
	}
	private Component crearPanelBSalir() {
		JPanel panel = new JPanel(new GridLayout(1,1,20,0));
		
		panel.add(crearBoton("Salir"));
		
		return panel;
	}
	private Component crearBoton(/*int id,*/ String titulo) {
		JButton boton = new JButton();
		if(titulo.equalsIgnoreCase("Salir")){
			boton.setText(titulo);
		}
		boton.setActionCommand(titulo);
		boton.addActionListener(controlador);
		//listaBotones[id]
		return boton;
	}

	public String getUserPremio() {
		return userPremio.getText();
	}
	public void setUserPremio(int valor) {
		userPremio.setText(""+valor+"");
	}
	public void visualizarBoton(Object objeto, String texto) {
		JButton boton = (JButton) objeto;
		boton.setEnabled(false);
		boton.setText(texto);
	}
	public static void main(String[] args) {
		Modelo2 modelo = new Modelo2();
		new Vista(modelo,200,30);
	}
}