package cuentaClickPlus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vista implements Observer{
	
	JFrame ventana;
	JLabel texto;
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo,int posX,int posY){
		ventana = new JFrame("Cuenta Clicks Plus");
		
		this.modelo = modelo;
		modelo.addObserver(this);
		
		controlador = new Controlador(this,modelo);
		ventana.setLocation(posX,posY);
		ventana.setSize(700, 400);
		
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel  = new JPanel(new BorderLayout(10,10));
		
		panel.add(crearPanelArriba(), BorderLayout.CENTER);
		panel.add(crearPanelBotones(),BorderLayout.SOUTH);
		return panel;
	}
	
	private Component crearPanelArriba() {
		JPanel panel = new JPanel(new BorderLayout(0,0));
		texto = new JLabel (String.valueOf(modelo.getContador()));
		texto.setFont(new Font ("Arial", Font.BOLD, 29));
		texto.setHorizontalAlignment(JLabel.CENTER);
		
		
		panel.add(texto, BorderLayout.CENTER);
		panel.add(crearPanelBotonesNum(),BorderLayout.EAST);
		
		return panel;
	}
	private Component crearPanelBotonesNum() {
		JPanel panel = new JPanel(new GridLayout(3,1,0,0));

		panel.add(crearBoton("1"));
		panel.add(crearBoton("3"));
		panel.add(crearBoton("5"));
		
		return panel;
	}
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(1,2,0,10));
		panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		
		panel.add(crearBoton("Incrementar"));
		panel.add(crearBoton("Decrementar"));
		panel.add(crearBoton("Salir"));
		
		return panel;
	}
	private Component crearBoton(String titulo) {
		JButton boton;
		boton = new JButton (titulo);
		boton.setActionCommand(titulo);
		boton.addActionListener(controlador);
		return boton;
	}
	@Override
	public void update(Observable modelo, Object objeto) {
		if (modelo instanceof Modelo){
			Modelo contador = (Modelo) modelo;
			texto.setText(String.valueOf(contador.getContador()));
		}
		
	}

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista programa = new Vista(modelo,300,100);
	}
}
