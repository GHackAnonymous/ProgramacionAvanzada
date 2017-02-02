import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Vista implements ActionListener{

	JFrame ventana;
	JMenuBar barra;
	JMenu	menuFile, menuEdit, menuSalir;
	JMenuItem opcionMenu;
	JMenu subMenu;
	JScrollPane panelScroll;
	JList<String> imagenes = null;
	JPanel panelImagen;
	FileNameExtensionFilter filtroImagen;
	String pathDirectorio;
	File[] ficheros;
	JTextField TextFieldDirectorio;
	JButton buscarFile;
	JButton Salir;
	JLabel nombreFichero;
	JLabel path;
	JLabel tamanoFile;
	JLabel miTamaño;
	
	public Vista(){
		ventana = new JFrame ("Selector Fichero");
		ventana.setLocation(200,200);
		ventana.setSize(450,220);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	private Component crearPanelCentral() {
		JPanel panel = new JPanel (new GridLayout(4,1,10,10));
		
		nombreFichero = new JLabel();
		path = new JLabel();
		
		panel.add(crearTextLabel(nombreFichero,"Nombre Fichero "));
		panel.add(crearTextLabel(path,"Path "));
		panel.add(crearPanelTamaños()); //panel doble
		panel.add(crearPanelBotones()); // botones
		
		
		
		return panel;
	}
	private JPanel crearPanelTamaños() {
		JPanel panel = new JPanel (new GridLayout(1,2,5,5));
		tamanoFile = new JLabel();
		miTamaño = new JLabel();
		panel.add(crearTextLabel(tamanoFile, "Tamaño File"));
		panel.add(crearTextLabel(miTamaño, "Mi Tamaño"));
		return panel;
	}
	private JPanel crearPanelBotones() {
		JPanel panel = new JPanel (new GridLayout(1,2,5,5));
		buscarFile = new JButton("Buscar Fichero");
		buscarFile.addActionListener(this);
		buscarFile.setActionCommand("buscar");
		Salir = new  JButton("Salir");
		Salir.addActionListener(this);
		Salir.setActionCommand("salir");
		panel.add(buscarFile);
		panel.add(Salir);
		return panel;
	}
	private Component crearTextLabel(JLabel text, String titulo) {
		JPanel panel = new JPanel();
		JLabel tituloLabel = new JLabel();

		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder()
						, titulo),null));
		
		panel.add(tituloLabel);
		panel.add(text);
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("buscar")){
			JFileChooser selectorDirectorio = new JFileChooser();

			int result = selectorDirectorio.showOpenDialog(ventana);
			
			File directorio = selectorDirectorio.getSelectedFile();
			
			if (directorio!=null && result == JFileChooser.APPROVE_OPTION){
				nombreFichero.setText(directorio.getName());
				path.setText(directorio.getPath());
				tamanoFile.setText(""+directorio.length());
				miTamaño.setText(""+cuentaByte(directorio));
			}
		}else if(e.getActionCommand().equalsIgnoreCase("salir")){
			System.exit(0);
		}
	}
	public long cuentaByte(File fichero){
		long contador = 0;
		try {
			InputStream streamDeByte = new FileInputStream(fichero);
			
			while((streamDeByte.read()) != -1){
				contador++;
			}
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
		
		return contador;
	}
	public static void main(String[] args) {
		Vista ejercicio = new Vista ();
	}
}
