import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circulo extends Figura {

	private int radio;
	
	public Circulo(String descipcion, int posicionX, int posicionY, int radio) {
		super(descipcion, posicionX, posicionY);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	@Override
	public String toString() {
		return "Circulo: "+super.toString();
	}
	@Override
	public void dibujar(Graphics g){
		 Graphics2D gr = (Graphics2D) g;
		 gr.setColor(Color.blue);
		 gr.fillOval(Math.round((float)super.getPosicionX()), Math.round((float) super.getPosicionY()), this.radio, this.radio);
	 }
}
