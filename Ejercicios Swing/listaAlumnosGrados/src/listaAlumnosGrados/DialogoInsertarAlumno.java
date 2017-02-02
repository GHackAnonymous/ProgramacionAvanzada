package listaAlumnosGrados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogoInsertarAlumno extends JDialog implements ActionListener	{
	final int NUMRESULTADOS = 4;
	JTextField nombre,apellido1,apellido2;
	Alumno newAlumno = null;
	static int id = 0;
	
	public DialogoInsertarAlumno(JFrame ventana, String titulo, boolean modo){
		super(ventana,titulo,modo);		
		
		
		this.setSize(400,340);
		this.setLocation(200,200);
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
		JPanel panel = new JPanel (new GridLayout(4,1,0,10));
		nombre = new JTextField(20);
		apellido1 = new JTextField(20);
		apellido2 = new JTextField (20);
		panel.add(crearTextField(nombre,"Nombre"));
		panel.add(crearTextField(apellido1,"Primer Apellido"));
		panel.add(crearTextField(apellido2,"Segundo Apellido"));
		
		return panel;
	}

	

	private Component crearTextField(JTextField text, String titulo) {
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.cyan), titulo));
		
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
			ListaResultadosAprendizaje listaResultados = new ListaResultadosAprendizaje();
			newAlumno = new Alumno (++id,nombre.getText(),apellido1.getText(),apellido2.getText(),listaResultados);
			dispose();
		}
		if (e.getActionCommand().equals("cancel")){
			dispose();
		}	
	}
	
	Alumno getAlumno(){
		return newAlumno;
	}
}
