package edu.mondragon.pa.comparadorficheros;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Vista  implements ActionListener{

	JFrame ventana;
	JScrollPane panelScroll;
	JPanel panelFiguras;
	JButton botonBuscar1;
	JButton botonBuscar2;
	JTextField ruta1;
	JTextField ruta2;
	
	
	public Vista(){
		
		ventana = new JFrame ("Comparador ficheros");
		ventana.setLocation(200,200);
		ventana.setSize(750,520);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Component crearPanelCentral() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,crearPanelIzda(),crearPanelDcha());
		panel.setDividerLocation(350);
		panel.setDividerSize(15);
		return panel;
	}
	private Component crearPanelIzda() {
		JPanel panel = new JPanel (new BorderLayout());
		panel.add(crearPanelIzdaSupe(),BorderLayout.NORTH);
		panel.add(crearPanelIzdaTexto(),BorderLayout.CENTER);
		
		return panel;
	}
	private Component crearPanelIzdaTexto() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		JTextArea texto = new JTextArea();
		panel.add(texto);
		return panel;
	}
	private Component crearPanelIzdaSupe() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		ruta1 = new JTextField();
		botonBuscar1 = new JButton(new ImageIcon("icons/14_zoom.png"));
		botonBuscar1.setActionCommand("original");
		botonBuscar1.addActionListener(this);
		
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder()
						, "Original"),null));
		
		panel.add(ruta1);
		panel.add(botonBuscar1);
		return panel;
	}
	private Component crearPanelDchaTexto() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		JTextArea texto = new JTextArea();
		panel.add(texto);
		return panel;
	}
	private Component crearPanelDchaSupe() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		ruta2 = new JTextField();
		botonBuscar2 = new JButton(new ImageIcon("icons/14_zoom.png"));
		botonBuscar2.setActionCommand("copia");
		botonBuscar2.addActionListener(this);
		
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder()
						, "Copia"),null));
		
		panel.add(ruta2);
		panel.add(botonBuscar2);
		return panel;
	}
	private Component crearPanelDcha() {
		JPanel panel = new JPanel (new BorderLayout());
		panel.add(crearPanelDchaSupe(),BorderLayout.NORTH);
		panel.add(crearPanelDchaTexto(),BorderLayout.CENTER);
		
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem opcion;
		JButton opcion2;
		String textoMsg= null;
		
		if (e.getActionCommand().equalsIgnoreCase("original")){
			JFileChooser selectorDirectorio = new JFileChooser();

			int result = selectorDirectorio.showOpenDialog(ventana);
			
			File directorio = selectorDirectorio.getSelectedFile();
			
			if (directorio!=null && result == JFileChooser.APPROVE_OPTION){
				ruta1.setText(directorio.getPath());
				// se lee el fichero y se introduce en el  JTextatarea
			}
		}
		if (e.getActionCommand().equalsIgnoreCase("copia")){
			JFileChooser selectorDirectorio = new JFileChooser();

			int result = selectorDirectorio.showOpenDialog(ventana);
			
			File directorio = selectorDirectorio.getSelectedFile();
			
			if (directorio!=null && result == JFileChooser.APPROVE_OPTION){
				ruta2.setText(directorio.getPath());
				// se lee el fichero y se introduce en el  JTextatarea
			}
		}
			
	}

	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vista ejercicio = new Vista ();
	}
}
