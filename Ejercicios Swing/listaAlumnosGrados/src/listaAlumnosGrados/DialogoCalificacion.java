package listaAlumnosGrados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoCalificacion extends JDialog implements ActionListener{
	int numResultados;
	JTextField textNotas[];
	
	ListaResultadosAprendizaje listaResultados;
	
	public DialogoCalificacion (JFrame ventana, String titulo, boolean modo,
						ListaResultadosAprendizaje listaResultados){
		super(ventana,titulo,modo);		
		this.listaResultados = listaResultados;
		textNotas = new JTextField [listaResultados.size()];
		this.setSize(650,340);
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
		JPanel panel = new JPanel (new GridLayout(listaResultados.size(),1,0,10));
		for (int i = 0; i<listaResultados.size();i++){
			panel.add(crearPanelResultado(i,listaResultados.getElementAt(i)));
		}
		
		
		return panel;
	}

	

	private Component crearPanelResultado(int i,ResultadoAprendizaje resul) {
		JPanel panel = new JPanel(new FlowLayout());
	
		panel.add(crearJLabelResultado(resul));
		
		panel.add(textNotas[i] = new JTextField(5));
		textNotas[i].setText(String.valueOf(resul.getNota()));
		return panel;
	}


	


	private Component crearJLabelResultado(ResultadoAprendizaje resul) {
		JLabel etiqueta = new JLabel (resul.getTexto());
		etiqueta.setFont(new Font("arial",Font.PLAIN,10));
		etiqueta.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.cyan), resul.getCodigo()));
		
		etiqueta.setPreferredSize(new Dimension (450,40));
		return etiqueta;
	}

	private Component crearPanelBotones() {
		JPanel panel = new JPanel (new FlowLayout());
		JButton bOk = new JButton ("OK");
		bOk.setActionCommand("ok");
		bOk.addActionListener(this);
	
		panel.add(bOk);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		
			for (int i = 0; i< listaResultados.size();i++){
				listaResultados.get(i).setNota(Float.parseFloat(textNotas[i].getText()));
			}
			dispose();
		}catch (NumberFormatException ex){
			JOptionPane.showConfirmDialog(this,"Error formato datos", "Datos no válidos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
}
