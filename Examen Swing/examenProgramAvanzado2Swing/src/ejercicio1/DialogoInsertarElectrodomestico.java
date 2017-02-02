package ejercicio1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class DialogoInsertarElectrodomestico extends JDialog implements ActionListener{
	
	JTextField nombre,consumo,imagen;
	
	Electrodomestico newElectrodomestico;
	
	public DialogoInsertarElectrodomestico(JFrame ventana, String titulo, boolean modo){
		super(ventana,titulo,modo);		
		this.setSize(400,300);
		this.setLocation(200,200);
		this.setResizable(false); 
		this.setContentPane(crearPanelVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel = new JPanel (new BorderLayout(0,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		panel.add(crearPanelDatos(),BorderLayout.CENTER);
		panel.add(crearPanelBotones(),BorderLayout.SOUTH);
		return panel;
	}
	
	private Component crearPanelDatos() {
		JPanel panel = new JPanel (new GridLayout(5,1,0,10));
		nombre = new JTextField();
		consumo = new JTextField();
		imagen = new JTextField ();
		panel.add(crearTextField(nombre,"Nombre: "));
		panel.add(crearTextField(consumo,"Comsumo: "));
		panel.add(crearTextField(imagen,"Imagen: "));
		
		Border thatBorder1 = new LineBorder(Color.BLACK);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(thatBorder1, "Panel Datos"),null));
		
		return panel;
	}

	private Component crearTextField(JTextField text, String titulo) {
		JPanel panel = new JPanel(new GridLayout(1,2));
		JLabel tituloLabel = new JLabel(titulo);
		
		panel.add(tituloLabel);
		panel.add(text);
		return panel;
	}

	private Component crearPanelBotones() {
		JPanel panel = new JPanel (new GridLayout(1,2,20,0));
		JButton bOk = new JButton ("OK");
		bOk.setActionCommand("ok");
		bOk.addActionListener(this);
		
		JButton bCancel = new JButton ("Cancelar");
		bCancel.setActionCommand("cancel");
		bCancel.addActionListener(this);
		
		panel.add(bOk);
		panel.add(bCancel);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ok")){
			newElectrodomestico = new Electrodomestico (nombre.getText(),Double.parseDouble(consumo.getText()),
					"icons/"+imagen.getText()+".png");
			dispose();
		}
		if (e.getActionCommand().equals("cancel")){
			dispose();
		}
	}
	Electrodomestico getElectrodomestico(){
		return newElectrodomestico;
	}
	
}
