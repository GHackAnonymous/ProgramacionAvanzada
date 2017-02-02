public abstract class Figura {
	private int puntoX;
	private int puntoY;
	private String caracteristica;
	
	public Figura(int puntoX, int puntoY, String caracteristica){
		this.puntoX = puntoX;
		this.puntoY = puntoY;
		this.caracteristica = caracteristica;
	}

	@Override
	public String toString(){
		return "Posicion: ("+this.puntoX+","+this.puntoY+")\n"+
				"Caracteristica: "+this.caracteristica;
	}
	public abstract double area();

	public int getPuntoX() {
		return puntoX;
	}

	public int getPuntoY() {
		return puntoY;
	}
}
