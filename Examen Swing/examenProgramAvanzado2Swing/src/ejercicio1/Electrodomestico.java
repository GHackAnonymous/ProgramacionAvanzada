package ejercicio1;

import java.awt.Graphics;

public class Electrodomestico {
	private String nombre;
	private double consumo;
	private String imagen;
	
	public Electrodomestico(String nombre, double consumo, String imagen){
		this.nombre = nombre;
		this.consumo = consumo;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return this.nombre+" ";
	}
	/*public void dibujar(Graphics g){
		
	}*/
}
