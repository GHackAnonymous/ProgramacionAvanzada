

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


public class DialogoInsertarFigura extends JDialog implements ActionListener{

	JRadioButton circulo;
	JRadioButton rectangulo;
	ButtonGroup grupo1;
	
	JTextField descricion,posicionX,posicionY,radio,lado1,lado2;
	
	JPanel radioPanel;
	JPanel lado1Panel;
	JPanel lado2Panel;
	
	Figura newFigura;
	
	public DialogoInsertarFigura(JFrame ventana, String titulo, boolean modo){
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
		panel.add(crearPanelRadio(),BorderLayout.NORTH);
		panel.add(crearPanelDatos(),BorderLayout.CENTER);
		panel.add(crearPanelBotones(),BorderLayout.SOUTH);
		return panel;
	}
	private Component crearPanelRadio() {
		JPanel panel = new JPanel (new GridLayout(1,2));

		circulo = new JRadioButton("Circulo");
		rectangulo = new JRadioButton("Rectangulo");
		
		circulo.setSelected(true);

		grupo1 = new ButtonGroup();

		
		grupo1.add(circulo);
		grupo1.add(rectangulo);
		
		panel.add(circulo);
		panel.add(rectangulo);
		
		return panel;
	}
	private Component crearPanelDatos() {
		JPanel panel = new JPanel (new GridLayout(5,1,0,10));
		descricion = new JTextField();
		posicionX = new JTextField();
		posicionY = new JTextField ();
		radio = new JTextField ();
		lado1 = new JTextField ();
		lado2 = new JTextField ();
		panel.add(crearTextField(descricion,"Descripcion: "));
		panel.add(crearTextField(posicionX,"Posicion X: "));
		panel.add(crearTextField(posicionY,"Posicion Y: "));
		
		JPanel radioPanel = (JPanel) crearTextField(radio,"Radio: ");
		panel.add(radioPanel);
		
		rectangulo.setEnabled(true);
    	circulo.setEnabled(false);

		
		circulo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	rectangulo.setEnabled(true);
	        	circulo.setEnabled(false);
	        	
	        	JPanel radioPanel = (JPanel) crearTextField(radio,"Radio: ");
	        	
	        	JPanel lado1Panel = (JPanel) panel.getComponent(3);
	        	JPanel lado2Panel = (JPanel) panel.getComponent(4);
	        	
				panel.remove(lado2Panel);
				panel.remove(lado1Panel);

	        	panel.add(radioPanel);
	        	panel.revalidate();
	        	panel.repaint();
	
	        }
	    });
		rectangulo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	rectangulo.setEnabled(false);
	        	circulo.setEnabled(true);

	        	JPanel radioPanel = (JPanel) panel.getComponent(3);
	        	JPanel lado1Panel = (JPanel) crearTextField(lado1,"Lado1: ");
	        	JPanel lado2Panel = (JPanel) crearTextField(lado2,"Lado2: ");

	        	panel.remove(radioPanel);
	        	panel.add(lado1Panel);
	        	panel.add(lado2Panel);
	        	panel.revalidate();
	        	panel.repaint();
	        }
	    });
		
		
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
			if(circulo.isSelected()){
				newFigura = new Circulo (descricion.getText(),Integer.parseInt(posicionX.getText()),
					Integer.parseInt(posicionY.getText()),Integer.parseInt(radio.getText()));
			}else if(rectangulo.isSelected()){
				newFigura = new Rectangulo (descricion.getText(),Integer.parseInt(posicionX.getText()),
						Integer.parseInt(posicionY.getText()),Integer.parseInt(lado1.getText()),
						Integer.parseInt(lado2.getText()));
			}
			dispose();
		}
		if (e.getActionCommand().equals("cancel")){
			dispose();
		}
	}
	Figura getFigura(){
		return newFigura;
	}
	
}
