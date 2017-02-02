import java.awt.BorderLayout;
import java.awt.Color;
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

public class Vista{
	
	JFrame ventana;
	JLabel texto;
	JButton boton1,boton2, boton3;
	JButton boton4, boton5, boton6;
	JButton boton7, boton8, boton9;
	JButton botonVacio , boton0, botonC;
	
	JButton botonSuma , botonResta, botonMultiplica;
	JButton botonDividir , botonResultado;
	
	Modelo modelo;
	Controlador controlador;
	
	public Vista(Modelo modelo){
		ventana = new JFrame("Calculadora");
		
		this.modelo = modelo;
		
		controlador = new Controlador(this, modelo);
		ventana.setLocation(500,200);
		ventana.setSize(300, 400);
		
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panelPrincipal  = new JPanel(new BorderLayout(10,10));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		texto = new JLabel (String.valueOf(modelo.getResultado()));
		texto.setFont(new Font ("Arial", Font.BOLD, 12));
		texto.setHorizontalAlignment(JLabel.CENTER);
		this.resetLabel();
		
		panelPrincipal.add(texto, BorderLayout.NORTH);
		panelPrincipal.add(crearPanelBotones(),BorderLayout.CENTER);
		
		return panelPrincipal;
	}
	private Component crearPanelBotones() {
		JPanel panelBotones  = new JPanel(new BorderLayout(10,10));
		
		panelBotones.add(crearPanelBotonesNum(),BorderLayout.CENTER);
		panelBotones.add(crearPanelBotonesOp(),BorderLayout.EAST);
		
		return panelBotones;
	}
	private Component crearPanelBotonesNum() {
		JPanel panelBotonesNum  = new JPanel(new GridLayout(4,3,3,3));
		boton1 = new JButton ("1");
		boton1.addActionListener(controlador);
		boton1.setActionCommand("1");
		
		boton2 = new JButton ("2");
		boton2.addActionListener(controlador);
		boton2.setActionCommand("2");
		
		boton3 = new JButton ("3");
		boton3.addActionListener(controlador);
		boton3.setActionCommand("3");
		
		boton4 = new JButton ("4");
		boton4.addActionListener(controlador);
		boton4.setActionCommand("4");
		
		boton5 = new JButton ("5");
		boton5.addActionListener(controlador);
		boton5.setActionCommand("5");
		
		boton6 = new JButton ("6");
		boton6.addActionListener(controlador);
		boton6.setActionCommand("6");
		
		boton7 = new JButton ("7");
		boton7.addActionListener(controlador);
		boton7.setActionCommand("7");
		
		boton8 = new JButton ("8");
		boton8.addActionListener(controlador);
		boton8.setActionCommand("8");
		
		boton9 = new JButton ("9");
		boton9.addActionListener(controlador);
		boton9.setActionCommand("9");
		
		boton0 = new JButton ("0");
		boton0.addActionListener(controlador);
		boton0.setActionCommand("0");
		
		botonVacio = new JButton (" ");
		botonVacio.addActionListener(controlador);
		botonVacio.setActionCommand(" ");
		botonVacio.setEnabled(false);
		
		botonC = new JButton ("C");
		botonC.addActionListener(controlador);
		botonC.setActionCommand("C");
		
		panelBotonesNum.add(boton1);
		panelBotonesNum.add(boton2);
		panelBotonesNum.add(boton3);
		
		panelBotonesNum.add(boton4);
		panelBotonesNum.add(boton5);
		panelBotonesNum.add(boton6);
		
		panelBotonesNum.add(boton7);
		panelBotonesNum.add(boton8);
		panelBotonesNum.add(boton9);
		
		panelBotonesNum.add(botonVacio);
		panelBotonesNum.add(boton0);
		panelBotonesNum.add(botonC);
		
		return panelBotonesNum;
	}
	
	private Component crearPanelBotonesOp() {
		JPanel panelBotonesOp  = new JPanel(new GridLayout(5,1,3,3));
		botonSuma = new JButton ("+");
		botonSuma.addActionListener(controlador);
		botonSuma.setActionCommand("+");
		
		botonResta = new JButton ("-");
		botonResta.addActionListener(controlador);
		botonResta.setActionCommand("-");
		
		botonMultiplica = new JButton ("*");
		botonMultiplica.addActionListener(controlador);
		botonMultiplica.setActionCommand("*");
		
		botonDividir = new JButton ("/");
		botonDividir.addActionListener(controlador);
		botonDividir.setActionCommand("/");
		
		botonResultado = new JButton ("=");
		botonResultado.addActionListener(controlador);
		botonResultado.setActionCommand("=");
		

		panelBotonesOp.add(botonSuma);
		panelBotonesOp.add(botonResta);
		panelBotonesOp.add(botonMultiplica);
		
		panelBotonesOp.add(botonDividir);
		panelBotonesOp.add(botonResultado);
		
		return panelBotonesOp;
	}
	public void valorEnPantalla(double valor){
		texto.setText(""+valor+"");
	}
	public void desOHabilitar(boolean opcion) {
		boton1.setEnabled(opcion);
		boton2.setEnabled(opcion);
		boton3.setEnabled(opcion);
		boton4.setEnabled(opcion);
		boton5.setEnabled(opcion);
		boton6.setEnabled(opcion);
		boton7.setEnabled(opcion);
		boton8.setEnabled(opcion);
		boton9.setEnabled(opcion);
		boton0.setEnabled(opcion);
		botonSuma.setEnabled(opcion);
		botonResta.setEnabled(opcion);
		botonMultiplica.setEnabled(opcion);
		botonDividir.setEnabled(opcion);
		botonResultado.setEnabled(opcion);	
	}
	public void resetLabel(){
		texto.setText("");
	}
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista programa = new Vista(modelo);
	}

}
