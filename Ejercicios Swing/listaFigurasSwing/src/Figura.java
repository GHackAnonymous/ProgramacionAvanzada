import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Figura {
	private String descipcion;
	private int posicionX;
	private int posicionY;
	
	public Figura(String descipcion, int posicionX, int posicionY){
		this.descipcion = descipcion;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	@Override
	public String toString() {
		return this.descipcion+" ";
	}
	public void dibujar(Graphics g){
		
	}
}
