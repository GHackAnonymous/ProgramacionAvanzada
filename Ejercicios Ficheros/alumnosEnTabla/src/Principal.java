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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {
	
	ModeloTablaAlumno tabla;
	JTable valoresTabla;
	TrazadorTablaAlumnos trazado;
	ModeloColumnasTablaAlumnos columnas;
	JScrollPane panelScroll;
	JTextField filtro;
	JButton botonFiltrar;
	JRadioButton rodioPoblacion;
	JRadioButton radioEdad;
	JRadioButton radioNombre;
	JRadioButton radioApellido1;
	ButtonGroup opciones;
	
	
	public Principal() {
		super("Alumnos 2º de grado de informática");
		trazado = new TrazadorTablaAlumnos();
		columnas = new ModeloColumnasTablaAlumnos(trazado);
		tabla = new ModeloTablaAlumno(columnas);
		this.setSize(900,700);
		this.setLocation(100, 40);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(crearPanelVentana());
		this.setVisible(true);
	}

	private Container crearPanelVentana() {
		JPanel panel = new JPanel (new BorderLayout());
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(crearPanelIzquierda(),BorderLayout.WEST);
		panel.add(panelScroll,BorderLayout.CENTER);
		crearTabla();
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return panel;
	}
	
	private Component crearPanelIzquierda() {
		JPanel panel = new JPanel(new GridLayout(3,1,10,10));
		
		panel.add(crearPanelFiltro());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return panel;
	}

	private Component crearPanelFiltro() {
		JPanel panel = new JPanel(new GridLayout(3,1,10,10));
		
		filtro = new JTextField(10);
		botonFiltrar = new JButton("Seleccionar");
		botonFiltrar.addActionListener(this);
		botonFiltrar.setActionCommand("Filtrar");
		
		panel.add(crearPanelRadioButtons());
		panel.add(crearTextField());
		panel.add(crearBoton());
		
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.cyan), 
				BorderFactory.createEmptyBorder(10,10,10,10)));
		return panel;
	}

	private Component crearBoton() {
		JPanel panel =  new JPanel(new GridLayout(1,1,0,0));
		panel.add(botonFiltrar);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		return panel;
	}

	private Component crearTextField() {
		JPanel panel =  new JPanel(new GridLayout(1,1,0,0));
		panel.add(filtro);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		return panel;
	}

	private Component crearPanelRadioButtons() {
		JPanel panel= new JPanel(new GridLayout(2,2,20,20)); 
		opciones = new ButtonGroup();
		
		rodioPoblacion = new JRadioButton("Poblacion");
		rodioPoblacion.setSelected(true);
		opciones.add(rodioPoblacion);
		
		radioEdad = new JRadioButton("Edad");
		radioEdad.setSelected(false);
		opciones.add(radioEdad);
		
		radioNombre = new JRadioButton("Nombre");
		radioNombre.setSelected(false);
		opciones.add(radioNombre);
		
		radioApellido1 = new JRadioButton("Apellido1");
		radioApellido1.setSelected(false);
		opciones.add(radioApellido1);
		
		panel.add(rodioPoblacion);
		panel.add(radioEdad);
		panel.add(radioNombre);
		panel.add(radioApellido1);
		return panel;
	}

	private void crearTabla() {
		valoresTabla = new JTable(tabla,columnas);
		valoresTabla.setFillsViewportHeight(true);
		panelScroll.setViewportView(valoresTabla);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Principal ejercicio = new Principal();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int edad = 0;
		
		if(e.getActionCommand().equalsIgnoreCase("Filtrar")) {
			
			if(filtro.getText().length() != 0) {
				
				if(rodioPoblacion.isSelected()) {
					tabla.filtrarPorPoblacion(filtro.getText());
				}
				
				if(radioEdad.isSelected()) {
					try {
						edad = Integer.parseInt(filtro.getText());
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(this, "Error: Dato no valido. ",
								"Error",JOptionPane.ERROR_MESSAGE);
					}
					tabla.filtrarPorEdad(edad);
				}
				
				if(radioNombre.isSelected()) {
					tabla.filtrarPorNombre(filtro.getText());
				}
				
				if(radioApellido1.isSelected()) {
					tabla.filtrarPorApellido(filtro.getText());
				}
				
			} else {
				tabla.todosLosAlumnos();
			}
		}
	}
}
