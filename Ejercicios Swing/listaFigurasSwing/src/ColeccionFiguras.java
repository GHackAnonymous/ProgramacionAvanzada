

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ColeccionFiguras implements ListModel<Figura>{
	
	List<Figura> figuras;
	List<ListDataListener> listeners;
	
	public ColeccionFiguras(){
		figuras = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	@Override
	public void addListDataListener(ListDataListener listener) {
		listeners.add(listener);
	}

	@Override
	public Figura getElementAt(int indice) {
		
		return figuras.get(indice);
	}

	@Override
	public int getSize() {
		
		return figuras.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
		
	}

	public void add(Figura persona) {
		figuras.add(persona);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(figuras, ListDataEvent.CONTENTS_CHANGED,0, figuras.size() ));
		}
	}

	public void remove(int indice) {
		figuras.remove(indice);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(figuras, ListDataEvent.CONTENTS_CHANGED,indice, indice));
		}
	}
	public double calcularSuperficie() {
		double superficie = 0;
		for(Figura figura : figuras){
			if(figura instanceof Circulo ){
				Circulo cir = (Circulo) figura;
				superficie += Math.PI*Math.pow(cir.getRadio(), 2);
			} else if(figura instanceof Rectangulo ){
				Rectangulo rec = (Rectangulo) figura;
				superficie += rec.getLado1()+rec.getLado2();
			}
		}
		return superficie;
	}
	public void repaint(Graphics g) {
		Graphics2D gr = (Graphics2D) g;
		for(Figura figura : figuras){
			figura.dibujar(gr);
		}
	}
}
