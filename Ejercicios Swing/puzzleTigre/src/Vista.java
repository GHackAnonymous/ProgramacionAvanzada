
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista{
	
	JFrame ventana;
	JLabel texto;
	JTextField userPremio;
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo,int posX,int posY){
		ventana = new JFrame("Puzzle Tigre");
		
		this.modelo = modelo;
		
		controlador = new Controlador(this,modelo);
		ventana.setLocation(posX,posY);
		ventana.setSize(700, 700);
		ventana.setResizable(false);
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel  = new JPanel(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

		panel.add(crearPanelBotones(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new GridLayout(4,3,0,0));
		for(int i = 0;i < 4; i++){
			for(int e = 0; e < 3; e++){
				String img = controlador.dameimagen();
				panel.add(crearBoton(""+img+"", img));
			}
		}
		return panel;
	}
	private Component crearBoton(String titulo, String img) {
		JButton boton = new JButton();
		boton.setActionCommand(titulo);
		ImageIcon fot = new ImageIcon("img/"+img+".jpg");
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(213,160, Image.SCALE_SMOOTH));
		boton.setIcon (icono);
		boton.addActionListener(controlador);
		return boton;
	}
	public void moverBoton(JButton botonAMover, JButton botonTigre12) {
		Icon imgBuena = botonAMover.getIcon();
		botonTigre12.setIcon(imgBuena);
		String comandoAux = botonTigre12.getActionCommand();
		botonTigre12.setActionCommand(botonAMover.getActionCommand());
		botonAMover.setIcon(null);
		botonAMover.setActionCommand(comandoAux);
	}
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		new Vista(modelo,200,30);
	}
}