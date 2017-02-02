package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class Clase implements ListModel<Alumno>{
	
	List<Alumno> clase;
	List<ListDataListener> listeners;
	
	public Clase (){
		clase = new ArrayList<>();
		listeners = new ArrayList<>();
		inicializar();
	}
	public void añadir(Alumno a){
		clase.add(a);
	}
	private void inicializar() {
		this.añadir(new Alumno (1,"Iñigo","Ayestaran","Vitoria","M",7.0));
		this.añadir(new Alumno (2,"Ander","Bolumburu","Arrasate","M",6.2));
		this.añadir(new Alumno (3,"Ainhoa","Arruabarrena","Zarauz","F",8.4));
		this.añadir(new Alumno (4,"Aritz","Caballero","Zarauz","M",9.1));
		this.añadir(new Alumno (5,"Elene","Carlos de Bergara","Arrasate","F",8.8));
		this.añadir(new Alumno (6,"Txema","Perez","Vitoria","M",2.3));
		this.añadir(new Alumno (7,"Xabi","Elkoro","Arrasate","M",3.2));
		this.añadir(new Alumno (8,"Miren","Illarramendi","Bergara","F",4.7));
		this.añadir(new Alumno (9,"Iñaki","Arenaza","Vitoria","M",3.5));
		this.añadir(new Alumno (10,"Aitor","Barreiro","Vitoria","M",7.5));
		this.añadir(new Alumno (11,"Julen","Uribarren","Bergara","M",6.5));
		this.añadir(new Alumno (12,"Xanti","Leonet","Zarauz","M",8.5));
	}
	@Override
	public void addListDataListener(ListDataListener listener) {
		listeners.add(listener);
	}

	@Override
	public Alumno getElementAt(int indice) {
		
		return clase.get(indice);
	}

	@Override
	public int getSize() {
		
		return clase.size();
	}

	@Override
	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
		
	}

	public void add(Alumno persona) {
		clase.add(persona);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(clase, ListDataEvent.CONTENTS_CHANGED,0, clase.size() ));
		}
	}

	public void remove(int indice) {
		clase.remove(indice);
		for (ListDataListener listener : listeners){
			listener.contentsChanged(new ListDataEvent(clase, ListDataEvent.CONTENTS_CHANGED,indice, indice));
		}
	}
}
