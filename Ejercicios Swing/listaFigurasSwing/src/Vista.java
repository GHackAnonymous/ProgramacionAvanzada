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
	JList<Figura> figuras = null;
	ColeccionFiguras coleccionFiguras;
	JPanel panelFiguras;
	
	
	public Vista(){
		
		ventana = new JFrame ("Lista Figuras Geometricas");
		
		ventana.setJMenuBar(crearBarraMenu());
		ventana.setExtendedState(ventana.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		JButton boton;
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("img/add.png")));
		boton.setActionCommand("Anadir");
		boton.addActionListener(this);
		
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("img/remove.png")));
		boton.setActionCommand("Borrar");
		boton.addActionListener(this);
		
		toolBar.addSeparator(new Dimension (20,0));
		
		toolBar.add(Box.createHorizontalGlue());
		
		boton =(JButton) toolBar.add(new JButton (new ImageIcon("img/exit.png")));
		boton.setActionCommand("salir");
		boton.addActionListener(this);
		return toolBar;
	}

	private JMenuBar crearBarraMenu() {
		barra = new JMenuBar();
		
		barra.add (crearMenuEdit());
		barra.add (crearMenuSalir());
		
		return barra;
		
	}

	private JMenu crearMenuSalir() {
		JMenuItem op;
		menuSalir = new JMenu ("Salir");
		
		op=menuSalir.add("Salir");
		op.setIcon(new ImageIcon("img/exit.png"));
		op.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				ventana.dispose();
			}
		});
		return menuSalir;
	}

	private JMenu crearMenuEdit() {
		
		menuEdit = new JMenu ("Editar");
		menuEdit.setMnemonic(KeyEvent.VK_E);

		opcionMenu = new JMenuItem ("Anadir");
		opcionMenu.addActionListener (this);
		opcionMenu.setMnemonic(KeyEvent.VK_C);
		opcionMenu.setIcon(new ImageIcon("img/add.png"));
		menuEdit.add(opcionMenu);
		
		opcionMenu = new JMenuItem ("Borrar");
		opcionMenu.addActionListener (this);
		opcionMenu.setMnemonic(KeyEvent.VK_P);
		opcionMenu.setIcon(new ImageIcon("img/remove.png"));
		
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
		superficie = new JLabel("Superficie Total");
		
		panel.add(crearToolBar(),BorderLayout.NORTH);
		panel.add(crearPanelIzdaCentro(),BorderLayout.CENTER);
		panel.add(crearPanelIzdaInferi(),BorderLayout.SOUTH);
		return panel;
	}
	private Component crearPanelIzdaCentro() {
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		figuras = new JList<> ();
		coleccionFiguras = new ColeccionFiguras();
		//lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		figuras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		figuras.setModel(coleccionFiguras);
		//figuras.addListSelectionListener(this);
		panelScroll.setViewportView(figuras);
		
		return panelScroll;
	}
	private void cacularSuperficie() {
		superficieTexto.setText(""+coleccionFiguras.calcularSuperficie());
	}
	private void repaint() {
		Graphics g = panelFiguras.getGraphics();
		panelFiguras.paint(g);
		coleccionFiguras.repaint(g);
	}
	private Component crearPanelIzdaInferi() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		JLabel superficie = new JLabel("Superficie Total");
		superficieTexto = new JTextField("");
		superficieTexto.setEnabled(false);
		this.cacularSuperficie();
		panel.add(superficie);
		panel.add(superficieTexto);
		return panel;
	}
	private Component crearPanelDcha() {
		panelFiguras = new JPanel();
		
		return panelFiguras;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem opcion;
		JButton opcion2;
		String textoMsg= null;
		
		if (e.getSource() instanceof JMenuItem){
			opcion = (JMenuItem) e.getSource();
			if(opcion.getText().equalsIgnoreCase("Anadir")){
				DialogoInsertarFigura dialogoInsertar = new DialogoInsertarFigura (ventana,"Datos nueva Figura",true);
				Figura figura = dialogoInsertar.getFigura();
				
				if (figura!=null){
					coleccionFiguras.add(figura);
					this.cacularSuperficie();
					this.repaint();
					textoMsg= opcion.getText();
					JOptionPane.showMessageDialog (ventana,textoMsg,"mensaje",JOptionPane.INFORMATION_MESSAGE );
				}
				
			}
			if (e.getActionCommand().equalsIgnoreCase("Borrar")){
				int indice = figuras.getSelectedIndex();
				if (indice != -1){
					try{
						coleccionFiguras.remove(indice);
					}catch(IndexOutOfBoundsException ex){}
					this.cacularSuperficie();
					this.repaint();
					textoMsg= opcion.getText();
					JOptionPane.showMessageDialog (ventana,textoMsg,"mensaje",JOptionPane.INFORMATION_MESSAGE );
				}
			}
			
			
		}
		if (e.getSource() instanceof JButton){
			opcion2 = (JButton) e.getSource();
			if(opcion2.getActionCommand().equalsIgnoreCase("Anadir")){
				DialogoInsertarFigura dialogoInsertar = new DialogoInsertarFigura (ventana,"Datos nueva Figura",true);
				Figura figura = dialogoInsertar.getFigura();
				
				if (figura!=null){
					coleccionFiguras.add(figura);
					this.cacularSuperficie();
					this.repaint();
					textoMsg=  opcion2.getActionCommand();
					JOptionPane.showMessageDialog (ventana,textoMsg,"mensaje",JOptionPane.INFORMATION_MESSAGE );
				}
				
			}
			if (e.getActionCommand().equalsIgnoreCase("Borrar")){
				int indice = figuras.getSelectedIndex();
				if (indice != -1){
					try{
						coleccionFiguras.remove(indice);
					}catch(IndexOutOfBoundsException ex){}
					this.cacularSuperficie();
					this.repaint();
					textoMsg =  opcion2.getActionCommand();
					JOptionPane.showMessageDialog (ventana,textoMsg,"mensaje",JOptionPane.INFORMATION_MESSAGE );
				}
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
