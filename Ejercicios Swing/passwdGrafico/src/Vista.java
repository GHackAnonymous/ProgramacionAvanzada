
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Vista{
	
	JFrame ventana;
	JLabel labelUser, labelPass;
	JTextField UserTextBox;
	JPasswordField passTextBox;
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo,int posX,int posY){
		ventana = new JFrame("CuentaClicks");
		
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
		
		panel.add(crearPanelBox(), BorderLayout.CENTER);
		panel.add(crearPanelBotones(),BorderLayout.SOUTH);
		
		return panel;
	}
	
	private Component crearPanelBox() {
		JPanel panel = new JPanel(new GridLayout(2,2,5,0));
		
		labelUser = new JLabel ("Username: ");
		labelUser.setBorder(BorderFactory.createBevelBorder(3));
		UserTextBox = new JTextField();
		labelPass = new JLabel ("Password: ");
		labelPass.setBorder(BorderFactory.createBevelBorder(3));
		passTextBox = new JPasswordField();
		
		Border thatBorder1 = new LineBorder(Color.RED);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(thatBorder1, "Identificacion"),null));
		
		panel.add(labelUser);
		panel.add(UserTextBox);
		panel.add(labelPass);
		panel.add(passTextBox);
		
		return panel;
	}
	
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(1,2,20,0));
		
		panel.add(crearBoton("ok"));
		panel.add(crearBoton("cancelar"));
		panel.add(crearBoton("salir"));
		
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
}