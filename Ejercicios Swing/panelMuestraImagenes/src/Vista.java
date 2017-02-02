import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Vista implements ActionListener, ListSelectionListener{

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
	
	public Vista(){
		filtroImagen=new FileNameExtensionFilter("Archivos de Imagen JPG","jpg","JPG");
		ventana = new JFrame ("Lista Figuras Geometricas");
		
		ventana.setExtendedState(ventana.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ventana.getContentPane().add(crearPanelCentral(),BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	private JToolBar crearToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel labelDirectorio = new JLabel("Directorio"); 

		toolBar.add(labelDirectorio);
		
		toolBar.addSeparator(new Dimension (5,0));
		
		TextFieldDirectorio = new JTextField();
		TextFieldDirectorio.setToolTipText("Inserta la ruta del directorio");
		TextFieldDirectorio.setBounds(52, 26, 209, 20);
		TextFieldDirectorio.setEnabled(false);;
		TextFieldDirectorio.setColumns(10);
		
		toolBar.add(TextFieldDirectorio);

		toolBar.addSeparator(new Dimension (5,0));
		
		JButton btnSeleccionar = new JButton("Seleccionar...");
		btnSeleccionar.setActionCommand("selecionarCD");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(288, 25, 109, 23);
		toolBar.add(btnSeleccionar);
		
		toolBar.add(Box.createHorizontalGlue());

		return toolBar;
	}
	private Component crearPanelCentral() {
		JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,crearPanelIzda(),crearPanelDcha());
		panel.setDividerLocation(400);
		panel.setDividerSize(15);
		return panel;
	}
	private Component crearPanelIzda() {
		JPanel panel = new JPanel (new BorderLayout());
		
		panel.add(crearToolBar(),BorderLayout.NORTH);
		panel.add(crearPanelIzdaCentro(),BorderLayout.CENTER);
		return panel;
	}
	private Component crearPanelIzdaCentro() {
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		imagenes = new JList<> ();
		imagenes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		imagenes.addListSelectionListener(this);
		panelScroll.setViewportView(imagenes);
		
		return panelScroll;
	}
	private void paint(String img) {
		//File file = new File(img);
		ImageIcon image = new ImageIcon(img);  // esto funciona siempre quelos ficeros este en el propia carpeta del proyecto 
		JLabel imagenLabel = new JLabel(image);
		imagenLabel.setSize(panelImagen.getWidth(), panelImagen.getHeight());
		panelImagen.removeAll();
		panelImagen.add(imagenLabel);
		panelImagen.revalidate();
		panelImagen.repaint();
		
	}
	private Component crearPanelDcha() {
		panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelImagen = new JPanel();
		//JLabel imagenLabel = new JLabel();
		//panelImagen.add(imagenLabel);
		//this.paint("img/add.jpg");
		panelScroll.setViewportView(panelImagen);
		
		return panelScroll;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton opcion2;
		
		if (e.getSource() instanceof JButton){
			opcion2 = (JButton) e.getSource();
			if(opcion2.getActionCommand().equalsIgnoreCase("selecionarCD")){
				JFileChooser selectorDirectorio = new JFileChooser();
				
				selectorDirectorio.setFileFilter(filtroImagen);
				selectorDirectorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				int result = selectorDirectorio.showOpenDialog(ventana);
				
				File directorio = selectorDirectorio.getSelectedFile();
				
				if (directorio!=null && result == JFileChooser.APPROVE_OPTION){
					
					DefaultListModel defaultListModel = buscar(directorio);
					pathDirectorio = directorio.getPath();
					pathDirectorio = pathDirectorio.replace('\\', '/');
					
					ficheros = directorio.listFiles();
					TextFieldDirectorio.setText(pathDirectorio);
					

					imagenes.setModel(defaultListModel);
					
				}
				
			}
		}
	}
	FileFilter filefilter = new FileFilter() {        
        @Override
        public boolean accept(File file) {           
            return file.getName().endsWith(".jpg");
        }
    };
    public DefaultListModel buscar(File directorio ){
        DefaultListModel defaultListModel = new DefaultListModel ();
        // Si es un directorio valido
        if ( directorio.isDirectory() ) {   
            // obtenemos su contenido
            File[] ficheros = directorio.listFiles( filefilter );             
            //y lo llenamos en un DefaultListModel
            for ( File fichero : ficheros ) {
                defaultListModel.addElement( fichero.getName() );
            }
        }        
        return defaultListModel;
    }
    public void valueChanged(ListSelectionEvent e) {
    	int posicion = e.getFirstIndex();
    	String imgName = imagenes.getSelectedValue();
    	System.out.println(imgName);
    	String pathCompleto = pathDirectorio+"/"+imgName;
    	System.out.println(pathCompleto);
    	
    	this.paint(pathCompleto);
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
