
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista{
	
	JFrame ventana;
	JTextField userGrados;
	JRadioButton celsius;
	JRadioButton farenheit;
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo,int posX,int posY){
		ventana = new JFrame("Comversor Grados");
		
		this.modelo = modelo;
		
		controlador = new Controlador(this,modelo);
		ventana.setLocation(posX,posY);
		ventana.setSize(360, 200);
		
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel  = new JPanel(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		panel.add(crearPanelBox(), BorderLayout.NORTH);
		panel.add(crearPanelCombo(), BorderLayout.CENTER);
		panel.add(crearPanelBotones(),BorderLayout.SOUTH);
		
		return panel;
	}
	
	private Component crearPanelBox() {
		JPanel panel = new JPanel(new BorderLayout(5,5));
		
		userGrados = new JTextField();

		panel.add(userGrados,BorderLayout.CENTER);
		
		return panel;
	}
	private Component crearPanelCombo() {
		JPanel panel = new JPanel(new GridLayout(2,1,5,0));
		
		celsius = new JRadioButton("celsius", false);
		celsius.setActionCommand("celsius");
		farenheit = new JRadioButton("farenheit", false);
		farenheit.setActionCommand("farenheit");
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(celsius);
		grupo1.add(farenheit);

		panel.add(celsius);
		panel.add(farenheit);
		
		return panel;
	}
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(1,1,20,0));
		
		panel.add(crearBoton("Comversion"));
		
		return panel;
	}
	private Component crearBoton(String titulo) {
		JButton boton;
		boton = new JButton (titulo);
		boton.setActionCommand(titulo);
		boton.addActionListener(controlador);
		return boton;
	}
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		new Vista(modelo,100,100);
	}

	public String getUserGrados() {
		return userGrados.getText();
	}
	public void setUserGrados(double valor) {
		userGrados.setText(""+valor+"");
	}

	public String getRadioBotonSelect() {
		if(celsius.isSelected()){
			return "celsius";
		}else if(farenheit.isSelected()){
			return "farenheit";
		}
		return "";
	}
}