public class Cuadrado extends Figura{
	private int lado;
	
	public Cuadrado(int puntoX, int PuntoY, String caracteristica, int lado) {
		super(puntoX, PuntoY, caracteristica);

		this.lado = lado;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\n"+
				"Lado: "+this.lado;
	}
	@Override
	public double area(){
		return Math.pow(lado, 2);
	}
}
