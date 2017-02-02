package ejercicio2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Vista  implements ActionListener{

	JFrame ventana;
	JMenuBar barra;
	JMenu	menuFile, menuEdit, menuSalir;
	JMenuItem opcionMenu;
	JMenu subMenu;
	JScrollPane panelScroll;
	JLabel superficie;
	JTextField superficieTexto;
	JList<Alumno> electrodomesticos = null;
	Clase clase;
	JPanel panelElectro;
	
	
	public Vista(){
		
		ventana = new JFrame ("Lista Electrodomestico");
		
		ventana.setJMenuBar(crearBarraMenu());
		ventana.add(crearToolBar(),BorderLayout.NORTH);
		ventana.setExtendedState(ventana.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		JButton boton;
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("icons/agt_home.png")));
		boton.setText("Poblacion");
		boton.setActionCommand("Poblacion");
		boton.addActionListener(this);
		
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("icons/access.png")));
		boton.setText("Sexo");
		boton.setActionCommand("Sexo");
		boton.addActionListener(this);
		
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("icons/enumList.png")));
		boton.setText("Nota");
		boton.setActionCommand("Nota");
		boton.addActionListener(this);
		
		toolBar.addSeparator(new Dimension (20,0));
		
		toolBar.add(Box.createHorizontalGlue());
		
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("icons/exit.png")));
		boton.setActionCommand("salir");
		boton.addActionListener(this);
		return toolBar;
	}

	private JMenuBar crearBarraMenu() {
		barra = new JMenuBar();
		
		barra.add (crearMenuEdit());
		barra.add(Box.createHorizontalGlue());
		barra.add (crearMenuSalir());
		
		return barra;
		
	}

	private JMenu crearMenuSalir() {
		JMenuItem op;
		menuSalir = new JMenu ("Salir");
		
		op=menuSalir.add("Salir");
		op.setIcon(new ImageIcon("icons/exit.png"));
		op.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				ventana.dispose();
			}
		});
		return menuSalir;
	}

	private JMenu crearMenuEdit() {
		
		menuEdit = new JMenu ("Agregar");
		menuEdit.setMnemonic(KeyEvent.VK_E);

		opcionMenu = new JMenuItem ("Anadir");
		opcionMenu.addActionListener (this);
		opcionMenu.setMnemonic(KeyEvent.VK_C);
		opcionMenu.setIcon(new ImageIcon("icons/edit_add.png"));
		menuEdit.add(opcionMenu);
		
		return menuEdit;
		
	}
	private Component crearPanelCentral() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,crearPanelIzda(),crearPanelDcha());
		panel.setDividerLocation(200);
		panel.setDividerSize(15);
		return panel;
	}
	private Component crearPanelIzda() {
		JPanel panel = new JPanel (new BorderLayout());
		superficie = new JLabel("Consumo Total");
		
		panel.add(crearPanelIzdaCentro(),BorderLayout.CENTER);
		return panel;
	}
	private Component crearPanelIzdaCentro() {
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		electrodomesticos = new JList<> ();
		clase = new Clase();
		electrodomesticos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		electrodomesticos.setModel(clase);
		//figuras.addListSelectionListener(this);
		panelScroll.setViewportView(electrodomesticos);
		
		return panelScroll;
	}
	private Component crearPanelDcha() {
		panelElectro = new JPanel();
		
		return panelElectro;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem opcion;
		JButton opcion2 = null;
		String textoMsg= null;
		
		if (e.getSource() instanceof JMenuItem){
			opcion = (JMenuItem) e.getSource();
			if(opcion.getText().equalsIgnoreCase("Anadir")){
				//DialogoInsertarElectrodomestico dialogoInsertar = new DialogoInsertarElectrodomestico (ventana,"Datos nueva Electrodomestico",true);
				//Electrodomestico electrodomestico = dialogoInsertar.getElectrodomestico();
				
			/*	if (electrodomestico!=null){
					coleccionElectrodomestico.add(electrodomestico);
				//	this.cacularConsumo();
					//coleccionElectrodomestico.addBotonElectro(panelElectro);
					
					this.addBotonPanel(electrodomestico);
					panelElectro.repaint();
					textoMsg= opcion.getText();
					JOptionPane.showMessageDialog (ventana,textoMsg,"mensaje",JOptionPane.INFORMATION_MESSAGE );
				}*/
				
			}
		}
		if (e.getSource() instanceof JButton){
			opcion2 = (JButton) e.getSource();
			if(opcion2.getActionCommand().equalsIgnoreCase("Poblacion")){
				// Se filtra los alumons por poblacion 
				//No lo he echo por falta de tiempo
			}
			if(opcion2.getActionCommand().equalsIgnoreCase("Sexo")){
				// Se filtra los alumons por Sexo 
				//No lo he echo por falta de tiempo	
			}
			if(opcion2.getActionCommand().equalsIgnoreCase("Nota")){
				// Se filtra los alumons por Nota 
				//No lo he echo por falta de tiempo	
			}
			if (e.getActionCommand().equalsIgnoreCase("Salir")){
				
				System.exit(0);
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
