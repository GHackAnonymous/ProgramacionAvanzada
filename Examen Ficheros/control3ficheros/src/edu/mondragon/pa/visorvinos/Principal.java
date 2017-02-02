package edu.mondragon.pa.visorvinos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Principal implements ActionListener,ListSelectionListener{

	JFrame ventana;
	JMenuBar barra;
	JMenu	menuAgregaciones, menuSalir;
	JMenuItem opcionMenu;
	AbstractAction accAgregarBodega,accAgregarTipoVino,accAgregarAño;
	ColeccionVinos coneccionVinos;
	TratamientoTXT gestorTxt;
	ModeloTablaVino tabla;
	ModeloColumnasTablaVino columnas;
	TrazadorTablaVino trazado;
	final String PATH = "files/vinos.txt";
	JTable valoresTabla;
	JList<Vino> vinos = null;
	Vino v1;
	
	
	JScrollPane panelScrollTabla;
	
	
	public Principal(){
		
		ventana = new JFrame ("Visor Vinos");
		
		coneccionVinos = new ColeccionVinos();
		gestorTxt = new TratamientoTXT();
		trazado = new TrazadorTablaVino();
		columnas = new ModeloColumnasTablaVino(trazado);
		tabla = new ModeloTablaVino(columnas, coneccionVinos.getVinos());
		
		this.leerFichero(PATH);
		
		this.crearAcciones();
	
		ventana.setJMenuBar(crearBarraMenu());
		ventana.setLocation(200,100);
		ventana.setSize(800,600);
		ventana.getContentPane().add(crearToolBar(),BorderLayout.NORTH);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void leerFichero(String pATH2) {
		List<String[]> palabras = gestorTxt.leer(PATH);

		for(String[] linea : palabras){
			coneccionVinos.add(new Vino(linea[0],linea[1],linea[2],Integer.parseInt(linea[3]),
					Double.parseDouble(linea[4]),
					(linea[5].equalsIgnoreCase("true") ?true:false)));
		}
	}

	private Component crearPanelCentral() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false,
				crearPanelOpciones(),crearPanelVinos());
			
		return panel;
	}

	private Component crearPanelOpciones() {
		JScrollPane panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		vinos = new JList<> ();
		vinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vinos.setModel(coneccionVinos);
		vinos.addListSelectionListener(this);
		panel.setViewportView(vinos);
		return panel;
		
	}

	private Component crearPanelVinos() {
		panelScrollTabla = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		crearTabla();
		panelScrollTabla.setViewportView(valoresTabla);
		return panelScrollTabla;
	}
	private void crearTabla() {
		valoresTabla = new JTable(tabla,columnas);
		valoresTabla.setFillsViewportHeight(true);
		
	}
	private void crearAcciones() {
		accAgregarBodega = new AccionAgregarPoblacion ("Bodega", new ImageIcon("icons/home.png"), "Agregar por Bodega", KeyEvent.VK_P);
		
		accAgregarTipoVino = new AccionAgregarTipoVino ("Tipo Vino",new ImageIcon("icons/kedit.png"),"Agregar por tipo vino",KeyEvent.VK_X);
		
		accAgregarAño= new AccionAgregarAño ("Año", new ImageIcon("icons/date.png"),"Agregar por año", KeyEvent.VK_N);
		
	}

	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton boton;
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		boton = new JButton (accAgregarBodega);
		boton.setActionCommand("Bodega");
		boton.addActionListener(this);
	    toolBar.add(boton);
	    boton = new JButton (accAgregarTipoVino);
	    boton.setActionCommand("Tipo");
	    boton.addActionListener(this);
		toolBar.add(boton);
		boton = new JButton (accAgregarAño);
		boton.setActionCommand("anio");
		boton.addActionListener(this);
		toolBar.add(boton);
		toolBar.add(Box.createHorizontalGlue());
	
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("icons/exit.png")));
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				ventana.dispose();
			}
		});
		return toolBar;
	}

	private JMenuBar crearBarraMenu() {
		barra = new JMenuBar();
		barra.add (crearMenuAcciones());
		
		
		barra.add(Box.createHorizontalGlue());
		barra.add (crearMenuSalir());
		
		return barra;
		
	}

	private JMenu crearMenuSalir() {
		JMenuItem op;
		menuSalir = new JMenu ("Salir");
		
		op=menuSalir.add("Salir");
		op.setIcon(new ImageIcon("iconos/shutdown.png"));
		op.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				ventana.dispose();
			}
		});
		return menuSalir;
	}

	private JMenu crearMenuAcciones() {
		
		menuAgregaciones = new JMenu ("Agregar");
		menuAgregaciones.setMnemonic(KeyEvent.VK_A);
		
		//boton.setActionCommand("Bodega");
		//boton.addActionListener(this);
	   
		
		opcionMenu = menuAgregaciones.add (accAgregarBodega);
		
		menuAgregaciones.addSeparator();
		
	    //boton.setActionCommand("Tipo");
	    //boton.addActionListener(this);
		
		opcionMenu = menuAgregaciones.add (accAgregarTipoVino);
		menuAgregaciones.addSeparator();
		
		//boton.setActionCommand("anio");
		//boton.addActionListener(this);
		
		opcionMenu = menuAgregaciones.add(accAgregarAño);
		
	
		return menuAgregaciones;
		
	}

	private class AccionAgregarPoblacion extends AbstractAction {
		String texto;
		public AccionAgregarPoblacion (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem opcion;
			JButton opcion2;
			String textoMsg= null;
			
			if (e.getSource() instanceof JMenuItem){
				opcion = (JMenuItem) e.getSource();
				if(opcion.getText().equalsIgnoreCase("Bodega")){
					tabla.filtrarPorBodega(v1.getBodega());
				}
				if (e.getActionCommand().equalsIgnoreCase("Tipo")){
					tabla.filtrarPorTipo(v1.getTipo());
				}
				if (e.getActionCommand().equalsIgnoreCase("anio")){
					tabla.filtrarPorAnio(v1.getAnio());
				}
				
				
			}
			if (e.getSource() instanceof JButton){
				opcion2 = (JButton) e.getSource();
				if(opcion2.getActionCommand().equalsIgnoreCase("Bodega")){
					tabla.filtrarPorBodega(v1.getBodega());
				}
				if (e.getActionCommand().equalsIgnoreCase("Tipo")){
					tabla.filtrarPorTipo(v1.getTipo());
				}
				if (e.getActionCommand().equalsIgnoreCase("anio")){
					tabla.filtrarPorAnio(v1.getAnio());
				}
				if (e.getActionCommand().equalsIgnoreCase("Salir")){
					System.exit(0);
				}
				
			}
		}
	}
	public class AccionAgregarTipoVino extends AbstractAction{
		String texto;
		public AccionAgregarTipoVino (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
	public class AccionAgregarAño extends AbstractAction{
		String texto;
		public AccionAgregarAño (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
	}
		
	}
	public static void main(String[] args) {
		
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Principal ejercicio = new Principal ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		JList aString = (JList) arg0.getSource();
		
		v1 = (Vino) aString.getSelectedValue();
		
		

	}


}
