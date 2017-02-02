
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


public class MiAdaptador  implements ListCellRenderer<Pelicula> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Pelicula> list,
				     Pelicula pelicula,
				     int index,
				     boolean isSelected,
				     boolean cellHasFocus) {
			
	 JPanel panelTodo = new JPanel(new BorderLayout());
	 
	 
	 JPanel panelImagen = new JPanel();
	 JLabel boton = new JLabel();
	 
	 ImageIcon icono = new ImageIcon("caratulas/"+pelicula.caratula);
	 boton.setIcon(icono);
	 
	 panelImagen.add(boton);
	 
	 panelTodo.add(panelImagen, BorderLayout.WEST);
	 
	 
	 JPanel panelTextos = new JPanel(new GridLayout(5,1,0,5));
	 JLabel titulo = new JLabel(pelicula.nombre);
	 titulo.setFont(new Font("Arial",Font.ITALIC,16));
	 titulo.setForeground(Color.pink);
	 
	 JLabel anyo = new JLabel(""+pelicula.anyo);
	 
	 JLabel director = new JLabel(pelicula.director);
	 director.setFont(new Font("Arial",Font.ITALIC,12));
	 
	 JLabel pais = new JLabel(pelicula.pais);
	 
	 JLabel tipo = new JLabel(pelicula.tipo);
	 tipo.setForeground(Color.red);
	 
	 panelTextos.add(titulo);
	 panelTextos.add(anyo);
	 panelTextos.add(director);
	 panelTextos.add(pais);
	 panelTextos.add(tipo);
	 
	 panelTodo.add(panelTextos, BorderLayout.CENTER);
	 
	 panelTodo.setBorder(BorderFactory.createLineBorder(Color.red));
	 panelTodo.setBackground(isSelected ? Color.blue : Color.white);
	 panelTodo.setForeground(isSelected ? Color.WHITE : Color.blue);

     
     return panelTodo;
   }
}
