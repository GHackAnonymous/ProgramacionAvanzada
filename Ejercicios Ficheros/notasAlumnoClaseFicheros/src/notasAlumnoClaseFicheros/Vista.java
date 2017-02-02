package notasAlumnoClaseFicheros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Vista  implements ActionListener, ListSelectionListener{

	JFrame ventana;
	JMenuBar barra;
	JMenu	menuFile, menuEdit, menuSalir;
	JMenuItem opcionMenu;
	JMenu subMenu;
	JScrollPane panelScroll;
	TratamientoFicheroTexto gestorFicheros;
	JList<Alumno> alumnos = null;
	ColeccionAlumnos coleccionAlumnos;
	JPanel panelNotas;
	File fichero;
	JPanel panelTitlulo; 
	
	
	public Vista(){
		
		gestorFicheros = new TratamientoFicheroTexto();
		
		ventana = new JFrame ("Nota Alumno clase");
		ventana.setJMenuBar(crearBarraMenu());
		ventana.add(crearToolBar(),BorderLayout.NORTH);
		ventana.setExtendedState(ventana.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Component crearPanelNorte(){
		JPanel panelnorte = new JPanel();
		JPanel panelTitulo = (JPanel) crearBarraTitulo();
		panelnorte.setSize(100, 100);
		panelnorte.add(panelTitulo);
		
		
		return panelTitlulo;
	}
	private Component crearBarraTitulo() {
		panelTitlulo = new JPanel();
		JLabel titulo = new JLabel(" ");
		panelTitlulo.add(titulo);
		return panelTitlulo;
	}

	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		JButton boton;
		boton =(JButton) toolBar.add(new JButton ("Guardar"));
		boton.setActionCommand("Guardar");
		boton.addActionListener(this);
		
		boton =(JButton) toolBar.add(new JButton ("Cargar"));
		boton.setActionCommand("Cargar");
		boton.addActionListener(this);

		return toolBar;
	}

	private JMenuBar crearBarraMenu() {
		barra = new JMenuBar();
		
		barra.add (crearMenuFile());
		
		return barra;
		
	}
	private JMenu crearMenuFile() {
		
		menuEdit = new JMenu ("File");
		menuEdit.setMnemonic(KeyEvent.VK_A);

		opcionMenu = new JMenuItem ("Guardar");
		opcionMenu.addActionListener (this);
		opcionMenu.setMnemonic(KeyEvent.VK_S);
		menuEdit.add(opcionMenu);
		
		opcionMenu = new JMenuItem ("Cargar");
		opcionMenu.addActionListener (this);
		opcionMenu.setMnemonic(KeyEvent.VK_C);
		
		menuEdit.add(opcionMenu);
		
		return menuEdit;
		
	}
	private Component crearPanelCentral() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(crearPanelNorte(), BorderLayout.NORTH);
		panel.add(crearPanelCentralInf(), BorderLayout.CENTER);
		return panel;
	}
	private Component crearPanelCentralInf() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,crearPanelIzda(),crearPanelDcha());
		panel.setDividerLocation(500);
		panel.setDividerSize(5);
		return panel;
	}
	private Component crearPanelIzda() {
		JPanel panel = new JPanel (new BorderLayout());
		
		panel.add(crearPanelIzdaCentro(),BorderLayout.CENTER);
		return panel;
	}
	private Component crearPanelIzdaCentro() {
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		alumnos = new JList<> ();
		coleccionAlumnos = new ColeccionAlumnos();
		alumnos.setModel(coleccionAlumnos);
		alumnos.setCellRenderer(coleccionAlumnos);
		alumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alumnos.addListSelectionListener(this);
		panelScroll.setViewportView(alumnos);
		
		return panelScroll;
	}
	private Component crearPanelDcha() {
		panelNotas = new JPanel();
		
		return panelNotas;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem opcion;
		JButton opcion2;
		String textoMsg= null;
		
		if (e.getSource() instanceof JMenuItem){
			opcion = (JMenuItem) e.getSource();
			if(opcion.getText().equalsIgnoreCase("Cargar")){
				JFileChooser selectorDirectorio = new JFileChooser();

				int result = selectorDirectorio.showOpenDialog(ventana);
				
				fichero = selectorDirectorio.getSelectedFile();
				
				if (fichero!=null && result == JFileChooser.APPROVE_OPTION){
					List<String[]> lineas = gestorFicheros.leer(fichero.getPath());
					
					int i = 0;
					for(String[] linea : lineas){
						if(i == 0){
							JLabel titulo = new JLabel(linea[0]);
							panelTitlulo.add(titulo);
							panelTitlulo.validate();
							panelTitlulo.repaint();
						}else{
							coleccionAlumnos.add(new Alumno(linea[0],linea[1],linea[2],linea[3],
								Double.parseDouble(linea[4]),linea[5],Integer.parseInt(linea[6]),
								linea[7],Double.parseDouble(linea[8]),linea[9],Double.parseDouble(linea[10])));
						}
					}
					
				}
				
			}
			if (e.getActionCommand().equalsIgnoreCase("Guardar")){
				
				List<Alumno> alumnos = coleccionAlumnos.getAlumnos();
				List<String> alumnosString = new ArrayList<>();
				
				for(Alumno a : alumnos){
					alumnosString.add(a.escribirParaFichero());
				}
				
				gestorFicheros.guardar(alumnosString, fichero.getPath());
			}
			
			
		}
		if (e.getSource() instanceof JButton){
			opcion2 = (JButton) e.getSource();
			if (opcion2.getActionCommand().equalsIgnoreCase("Cargar")){
				JFileChooser selectorDirectorio = new JFileChooser();
	
				int result = selectorDirectorio.showOpenDialog(ventana);
				
				fichero = selectorDirectorio.getSelectedFile();
				
				if (fichero!=null && result == JFileChooser.APPROVE_OPTION){
					List<String[]> lineas = gestorFicheros.leer(fichero.getPath());
					
					int i = 0;
					for(String[] linea : lineas){
						if(i == 0){
							JLabel titulo = new JLabel(linea[0]);
							panelTitlulo.add(titulo);
							panelTitlulo.validate();
							panelTitlulo.repaint();
							i++;
						}else{
							coleccionAlumnos.add(new Alumno(linea[0],linea[1],linea[2],linea[3],
								Double.parseDouble(linea[4]),linea[5],Double.parseDouble(linea[6]),
								linea[7],Double.parseDouble(linea[8]),linea[9],Double.parseDouble(linea[10])));
						}
					}
					
				}
			}
			if (opcion2.getActionCommand().equalsIgnoreCase("Guardar")){
				
				List<Alumno> alumnos = coleccionAlumnos.getAlumnos();
				List<String> alumnosString = new ArrayList<>();
				
				for(Alumno a : alumnos){
					alumnosString.add(a.escribirParaFichero());
				}
				
				gestorFicheros.guardar(alumnosString, fichero.getPath());
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

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		panelNotas.removeAll();
		panelNotas.validate();
		panelNotas.repaint();
		
		panelNotas.setLayout(new GridLayout(4,1,0,5));
		
		JList aString = (JList) arg0.getSource();
		
		
		Alumno a = (Alumno) aString.getSelectedValue();
		
		
		
		JLabel asig1 = new JLabel(a.getNombreAsig1()+": "+a.getNotaAsig1());
		JLabel asig2 = new JLabel(a.getNombreAsig2()+": "+a.getNotaAsig2());
		JLabel asig3 = new JLabel(a.getNombreAsig3()+": "+a.getNotaAsig3());
		JLabel asig4 = new JLabel(a.getNombreAsig4()+": "+a.getNotaAsig4());
		
		if(a.getNotaAsig1()<= 5.0){
			asig1.setForeground(Color.red);
		}
		if(a.getNotaAsig2() <= 5.0){
			asig2.setForeground(Color.red);
		}
		if(a.getNotaAsig3() <= 5.0){
			asig3.setForeground(Color.red);
		}
		if(a.getNotaAsig4() <= 5.0){
			asig4.setForeground(Color.red);
		}
		
		
		panelNotas.add(asig1);
		panelNotas.add(asig2);
		panelNotas.add(asig3);
		panelNotas.add(asig4);
		
		panelNotas.validate();
		panelNotas.repaint();
		
		
	}
}
