package ejercicio1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ColeccionElectrodomestico implements ListModel<Electrodomestico>{
	
	List<Electrodomestico> electrodomesticos;
	List<ListDataListener> listeners;
	
	public ColeccionElectrodomestico(){
		electrodomesticos = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	@Override
	public void addListDataListener(ListDataListener listener) {
		listeners.add(listener);
	}

	@Override
	public Electrodomestico getElementAt(int indice) {
		
		return electrodomesticos.get(indice);
	}

	@Override
	public int getSize() {
		
		return electrodomesticos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
		
	}

	public void add(Electrodomestico persona) {
		electrodomesticos.add(persona);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(electrodomesticos, ListDataEvent.CONTENTS_CHANGED,0, electrodomesticos.size() ));
		}
	}

	public void remove(int indice) {
		electrodomesticos.remove(indice);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(electrodomesticos, ListDataEvent.CONTENTS_CHANGED,indice, indice));
		}
	}
	public double calcularConsumo() {
		double consumo = 0;
		for(Electrodomestico electro : electrodomesticos){
			consumo += electro.getConsumo();
		}
		return consumo;
	}
	public void addBotonElectro(JPanel panelElectro) {
		for(Electrodomestico electro : electrodomesticos){
			JButton boton = new JButton();
			ImageIcon image = new ImageIcon(electro.getImagen());
			boton.setIcon(image);
			boton.setText(electro.getNombre());
			boton.setActionCommand("botonElectro");
			panelElectro.add(boton);
			panelElectro.repaint();
		}
	}

	public Color encender(String nombre) {
		for(Electrodomestico electro : electrodomesticos){
			if(electro.getNombre().equalsIgnoreCase(nombre)){
				return Color.red;
			}
		}
		return null;
	}
}
