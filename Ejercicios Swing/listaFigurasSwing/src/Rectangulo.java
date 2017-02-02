import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangulo extends Figura {

	private int lado1;
	private int lado2;
	
	public Rectangulo(String descipcion, int posicionX, int posicionY, int lado1, int lado2) {
		super(descipcion, posicionX, posicionY);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo: "+super.toString();
	}
	@Override
	public void dibujar(Graphics g){
		 Graphics2D gr = (Graphics2D) g;
		 
		 gr.setColor(Color.green);
		 
		 gr.fillRect((int)super.getPosicionX(),(int) super.getPosicionY(), lado1, lado2);
	 }
	
}
