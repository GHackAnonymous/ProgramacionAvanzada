package notasAlumnoClaseFicheros;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


public class ColeccionAlumnos implements ListModel<Alumno>, ListCellRenderer<Alumno>{
	
	List<Alumno> alumnos;
	List<ListDataListener> listeners;
	
	public ColeccionAlumnos(){
		alumnos = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	@Override
	public void addListDataListener(ListDataListener listener) {
		listeners.add(listener);
	}

	@Override
	public Alumno getElementAt(int indice) {
		
		return alumnos.get(indice);
	}

	@Override
	public int getSize() {
		
		return alumnos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
		
	}

	public void add(Alumno persona) {
		alumnos.add(persona);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(alumnos, ListDataEvent.CONTENTS_CHANGED,0, alumnos.size() ));
		}
	}

	public void remove(int indice) {
		alumnos.remove(indice);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(alumnos, ListDataEvent.CONTENTS_CHANGED,indice, indice));
		}
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Alumno> list,
		     Alumno a,
		     int index,
		     boolean isSelected,
		     boolean cellHasFocus) {
		JPanel panel = new JPanel();
		JLabel etiqueta = new JLabel();
		etiqueta.setText(a.toString());
		
		if(a.getNotaAsig1()<= 5.0){
			etiqueta.setForeground(Color.red);
		}else if(a.getNotaAsig2() <= 5.0){
			etiqueta.setForeground(Color.red);
		}else if(a.getNotaAsig3() <= 5.0){
			etiqueta.setForeground(Color.red);
		}else if(a.getNotaAsig4() <= 5.0){
			etiqueta.setForeground(Color.red);
		}
		
	     etiqueta.setFont(new Font("Arial",Font.PLAIN,12));
	     etiqueta.setVerticalTextPosition(0);
	     etiqueta.setHorizontalTextPosition(0); 
	     panel.setAlignmentX(0);
	     panel.setAlignmentY(0);
	     panel.setBackground(isSelected ? Color.cyan : Color.white);
	     panel.setForeground(isSelected ? Color.cyan : Color.white);
	     panel.add(etiqueta);
	     etiqueta.setOpaque(true);
		
		panel.add(etiqueta);
		return panel;
	}

	/*public Alumno buscar(String aStringABuscar) {
		
		for(Alumno a : alumnos){
			if(a.toString().equalsIgnoreCase(aStringABuscar)){
				return a;
			}
		}
		return null;
	}*/
}
