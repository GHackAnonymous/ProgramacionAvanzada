public class Triangulo extends Figura{

	private int base;
	private int altura;
	
	public Triangulo(int puntoX, int PuntoY, String caracteristica, int base, int altura) {
		super(puntoX, PuntoY, caracteristica);
		this.base = base;
		this.altura = altura;
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Base: "+this.base+"\n"+
				"Altura: "+this.altura;
	}
	@Override
	public double area(){
		return (base * altura)/2;
	}
}
