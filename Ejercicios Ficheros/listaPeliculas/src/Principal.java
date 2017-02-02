
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;


public class Principal extends JFrame implements ActionListener{
	JList<Pelicula> lista;
	List<Pelicula> lista2;
	DefaultListModel<Pelicula> modelo;
	private final String PATHICONOS = "iconos/";
	private final String PATHFICHERO = "file/peliculas.txt";
	JLabel tantoEnTanto;
	TratamientoFicheroTexto gestorFicheros;
	JButton botonAtras;
	JButton botonAlante;
	int indiceBueno = 6;
	
	public Principal(){
		super ("Lista peliculas");
		
		lista2 = new ArrayList<>();
		
		this.setSize (380,450);
		this.setLocation(200,200);
		this.setContentPane(crearPanelVentana());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		botonAtras =(JButton) toolBar.add(new JButton ());
		botonAtras.setIcon(new ImageIcon(PATHICONOS+"/atras.png"));
		botonAtras.setActionCommand("Atras");
		botonAtras.setEnabled(false);
		botonAtras.addActionListener(this);
		
		toolBar.addSeparator(new Dimension (20,0));
		toolBar.add(Box.createHorizontalGlue());
		
		tantoEnTanto = new JLabel("1/6");
		toolBar.add(tantoEnTanto);
		
		toolBar.add(Box.createHorizontalGlue());
		
		botonAlante =(JButton) toolBar.add(new JButton ());
		botonAlante.setIcon(new ImageIcon(PATHICONOS+"/alante.png"));
		botonAlante.setActionCommand("Alante");
		botonAlante.addActionListener(this);

		return toolBar;
	}
	private Container crearPanelVentana() {
		JPanel panel = new JPanel(new BorderLayout(0,10));
		panel.add(crearToolBar(),BorderLayout.NORTH);
		panel.add(crearPanelLista(),BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
		return panel;
	}
	private Component crearPanelLista() {
		JScrollPane panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		MiAdaptador adaptador = new MiAdaptador();
		lista = new JList<>();
		modelo = new DefaultListModel<>();
		gestorFicheros = new TratamientoFicheroTexto();
		leer();
		siguentes(0, 6);
		lista.setModel(modelo);
		lista.setCellRenderer(adaptador);
		panel.setViewportView(lista);
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Atras")){
			//pasamo para atras
			if(indiceBueno == 14){
				indiceBueno = 12;
				atras(indiceBueno, indiceBueno-6);
				indiceBueno -= 6;
				tantoEnTanto.setText(indiceBueno+"/"+(indiceBueno+6));
				botonAlante.setEnabled(true);
				botonAtras.setEnabled(true);
			}else{
				atras(indiceBueno, indiceBueno-6);
				tantoEnTanto.setText((indiceBueno-6)+"/"+indiceBueno);
				botonAlante.setEnabled(true);
				botonAtras.setEnabled(false);
			}
		}
		if (e.getActionCommand().equals("Alante")){
			//lista.removeAll();
			//lista.validate();
			if(indiceBueno != 12){
				siguentes(indiceBueno, indiceBueno+6);
				indiceBueno += 6;
				tantoEnTanto.setText((indiceBueno-6)+"/"+indiceBueno);
				botonAtras.setEnabled(true);
				botonAlante.setEnabled(true);
			}else{
				siguentes(indiceBueno, indiceBueno+2);
				indiceBueno += 2;
				tantoEnTanto.setText((indiceBueno-2)+"/"+indiceBueno);
				botonAlante.setEnabled(false);
				botonAtras.setEnabled(true);
			}
			//lista.validate();
			//lista.repaint();
		}
		
	}
	public void leer(){
		List<String[]> lineas = gestorFicheros.leer(PATHFICHERO);
		for(String[] linea : lineas){
			lista2.add(new Pelicula(linea[0],linea[1],Integer.parseInt(linea[2]),linea[3],
					linea[4],linea[5]));

		}
		
	}
	public void siguentes(int inicio, int max){
		int a = 0;
		modelo.removeAllElements();
		for(int i = inicio; i<max; i++){
			Pelicula p = lista2.get(i);
			modelo.add(a, p);
			a++;
		}
	}
	public void atras(int max, int inicio){
		int a = 0;
		modelo.removeAllElements();
		for(int i = inicio; i<max; i++){
			Pelicula p = lista2.get(i);
			modelo.add(a, p);
			a++;
		}
	}
	public static void main(String[] args) {
		
		Principal ejercicio = new Principal();
		
	}
	
}
