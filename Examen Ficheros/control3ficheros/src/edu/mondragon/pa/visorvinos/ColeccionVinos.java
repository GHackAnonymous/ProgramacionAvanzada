package edu.mondragon.pa.visorvinos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ColeccionVinos implements ListModel<Vino>{
	
	List<Vino> vinos;
	List<ListDataListener> listeners;
	
	public ColeccionVinos(){
		vinos = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	@Override
	public void addListDataListener(ListDataListener listener) {
		listeners.add(listener);
	}

	@Override
	public Vino getElementAt(int indice) {
		
		return vinos.get(indice);
	}

	@Override
	public int getSize() {
		
		return vinos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
		
	}

	public void add(Vino vino) {
		vinos.add(vino);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(vinos, ListDataEvent.CONTENTS_CHANGED,0, vinos.size() ));
		}
	}

	public void remove(int indice) {
		vinos.remove(indice);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(vinos, ListDataEvent.CONTENTS_CHANGED,indice, indice));
		}
	}
	public List<Vino> getVinos() {
		return vinos;
	}
}
