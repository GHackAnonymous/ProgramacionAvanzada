package listaAlumnosGrados;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Principal extends JFrame implements ListSelectionListener{
	Clase clase;
	JList<Alumno> listaAlumnos;
	JList<ResultadoAprendizaje> listaResultados;
	String nombreClase;
	AñadirAlumno accAñadirAlumno;
	PonerNotasAlumno accPonerNotasAlumno;
	Salir accSalir;
	JScrollPane panelResultados;
	AdaptadorResultados adaptadorResultados;
	
	public Principal(){
		this.crearAcciones();
		this.setSize (800,600);
		this.setLocation(200,100);
		this.setJMenuBar(crearBarraMenu());
		this.getContentPane().add(crearToolBar(),BorderLayout.NORTH);
		this.getContentPane().add(crearPanelVentana(),BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		JButton boton;
		boton =(JButton) toolBar.add(new JButton (accAñadirAlumno));
		toolBar.addSeparator(new Dimension (20,0));
		boton =(JButton) toolBar.add(new JButton (accPonerNotasAlumno));
		
		
		toolBar.add(Box.createHorizontalGlue());
		
		boton =(JButton) toolBar.add(new JButton (accSalir));
		accPonerNotasAlumno.setEnabled(false);
		
		return toolBar;
	}

	private JMenuBar crearBarraMenu() {
		JMenuBar barra =  new JMenuBar();
		JMenu editar = new JMenu("Editar");
		editar.add(accAñadirAlumno);
		editar.addSeparator();
		editar.add(accPonerNotasAlumno);
		barra.add(editar);
		barra.add(Box.createHorizontalGlue());
		JMenu salir = new JMenu("Salir");
		salir.add(accSalir);
		barra.add (salir);
		
		return barra;
		
	}
	private Container crearPanelVentana() {
		JSplitPane panel= new JSplitPane (JSplitPane.HORIZONTAL_SPLIT, crearPanelListaAlumnos(),
				crearPanelListaRAs());
		
		panel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
		return panel;
	}
	private Component crearPanelListaRAs() {
		panelResultados = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		Alumno a = listaAlumnos.getSelectedValue();
		adaptadorResultados = new AdaptadorResultados();
		
		if (a != null){
			listaResultados = new JList<>();
			listaResultados.setModel(a.getNotas());
			listaResultados.setCellRenderer(adaptadorResultados);
			panelResultados.setViewportView(listaResultados);
			
		}
		return panelResultados;
	}
	private Component crearPanelListaAlumnos() {
		JScrollPane panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		AdaptadorAlumnos adaptadorAlumnos = new AdaptadorAlumnos();
		listaAlumnos = new JList<>();
		clase = new Clase(nombreClase);
		clase.inicializar();
		listaAlumnos.setModel(clase);
		listaAlumnos.setCellRenderer(adaptadorAlumnos);
		
		listaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaAlumnos.addListSelectionListener(this);
		panel.setViewportView(listaAlumnos);
		return panel;
	}
	private void crearAcciones() {
		accAñadirAlumno = new AñadirAlumno ("Añadir", new ImageIcon("imagenes/add.png"), 
				"Añadir alumno", KeyEvent.VK_A);
		accPonerNotasAlumno = new PonerNotasAlumno ("Calificar",new ImageIcon("imagenes/edit.png"),
				"Poner notas",KeyEvent.VK_C);
		accSalir = new Salir ("Salir",new ImageIcon("imagenes/exit.png"),"Salir",KeyEvent.VK_S);
		
	}
	private class AñadirAlumno extends AbstractAction {
		String texto;
		public AñadirAlumno (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DialogoInsertarAlumno dialogo = new DialogoInsertarAlumno (Principal.this,"Datos Alumno",true);
			Alumno alumno = dialogo.getAlumno();
			if (alumno != null){
				clase.addElement(alumno);
			}	
		}
	}
	private class Salir extends AbstractAction {
		String texto;
		public Salir (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Principal.this.dispose();
			clase.guardarEnFichero();
			
		}
	}
	private class PonerNotasAlumno extends AbstractAction {
		String texto;
		public PonerNotasAlumno (String texto, Icon imagen, String descrip, Integer nemonic){
			super(texto,imagen);
			this.texto = texto;
			this.putValue( Action.SHORT_DESCRIPTION ,descrip);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Alumno alumno = listaAlumnos.getSelectedValue();
			if (alumno == null){
				JOptionPane.showConfirmDialog(Principal.this,"Error", "Debes seleccionar un alumno", 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			DialogoCalificacion dialogo = new DialogoCalificacion (Principal.this, "Calificación Alumno ",
					true,alumno.getNotas());
			Principal.this.repaint();
			
		}
	}

	public static void main(String[] args) {
		Principal ejercicio = new Principal();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) return;
		Alumno a = listaAlumnos.getSelectedValue();
		
		if (a != null){
			accPonerNotasAlumno.setEnabled(true);
			listaResultados = new JList<>();
			listaResultados.setModel(a.getNotas());
			listaResultados.setCellRenderer(adaptadorResultados);
			panelResultados.setViewportView(listaResultados);
			this.repaint();
		}
	}
	
}
