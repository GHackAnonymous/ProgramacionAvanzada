public class Rectangulo extends Figura{
	private int lado1;
	private int lado2;
	
	public Rectangulo(int puntoX, int PuntoY, String caracteristica, int lado1, int lado2) {
		super(puntoX, PuntoY, caracteristica);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Lado 1: "+this.lado1+"\n"+
				"Lado 2: "+this.lado2+"\n";
	}
	@Override
	public double area(){
		return lado1*lado2;
	}
}
