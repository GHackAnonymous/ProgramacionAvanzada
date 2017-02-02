public class Circulo extends Figura{

	private int radio;
	
	public Circulo(int puntoX, int PuntoY, String caracteristica, int radio) {
		super(puntoX, PuntoY, caracteristica);
		this.radio = radio;
	}

	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Radio: "+this.radio;
	}
	@Override
	public double area(){
		return (Math.PI*Math.pow(radio, 2));
	}
}
