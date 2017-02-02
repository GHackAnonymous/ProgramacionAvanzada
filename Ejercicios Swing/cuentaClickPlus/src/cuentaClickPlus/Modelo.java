package cuentaClickPlus;

import java.util.Observable;

public class Modelo extends Observable{
	
	private int numAument = 0;
	private int contador;
	
	public Modelo(){
		contador = 0;
	}
	public int getContador() {
		return contador;
	}
	public void setNumAument(int valor){
		this.numAument = valor;
	}
	public void incrementar(){
		contador += numAument;
		this.setChanged();
		this.notifyObservers();
	}
	public void decrementar(){
		contador -= numAument;
		this.setChanged();
		this.notifyObservers();
	}
}

