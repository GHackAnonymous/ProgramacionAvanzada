
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	JLabel labelCalculo;
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo,int posX,int posY){
		ventana = new JFrame("bar Paco");
		
		this.modelo = modelo;
		
		controlador = new Controlador(this,modelo);
		ventana.setLocation(posX,posY);
		ventana.setSize(500, 500);
		
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel  = new JPanel(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.add(crearPanelTexto(), BorderLayout.NORTH);
		panel.add(crearPanelBotones(),BorderLayout.CENTER);
		
		return panel;
	}
	
	private Component crearPanelTexto() {
		JPanel panel = new JPanel(new GridLayout(1,2,0,0));
		
		labelCalculo = new JLabel("0");
		labelCalculo.setHorizontalAlignment(JLabel.RIGHT);
		labelCalculo.setVerticalAlignment(JLabel.CENTER);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.red),
				BorderFactory.createLoweredBevelBorder()));
		
		
		panel.add(labelCalculo);
		
		return panel;
	}
	
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(2,2,2,2));
		
		panel.add(crearBoton("Cerveza","cerveza.jpg"));
		panel.add(crearBoton("Pintxo","pintxo.jpg"));
		panel.add(crearBoton("Vino","vino.jpg"));
		panel.add(crearBoton("Total","total.jpg"));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setBackground(Color.gray);
		
		return panel;
	}
	private Component crearBoton(String titulo, String img) {
		JButton boton;
		boton = new JButton (titulo);
		boton.setIcon (new ImageIcon("img/"+img+""));
		boton.setActionCommand(titulo);
		boton.addActionListener(controlador);
		return boton;
	}
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		new Vista(modelo,100,100);
	}

	public JLabel getLabelCalculo() {
		return labelCalculo;
	}

	public void setLabelCalculo(JLabel labelCalculo) {
		this.labelCalculo = labelCalculo;
	}
}