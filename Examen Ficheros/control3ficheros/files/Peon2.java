package ajedrez;

public class Peon {
	boolean primerMovimiento;
	Posicion posicion;
	String denominacion;
	
	public Peon(Posicion posicion, String denominacion){
		this.primerMovimiento = true;
		this.posicion = posicion;
		this.denominacion = denominacion;
	}
	
	
	public Posicion getPosicion() {
		return posicion;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public boolean mover(Posicion nuevaPosicion){
		if (posicionValida (nuevaPosicion)){
			posicion.mover(nuevaPosicion);
			primerMovimiento = false;
			return true;
		}
		return false;
	}

	private boolean posicionValida(Posicion nuevaPosicion) {
		if (posicion.getHorizontal()!= nuevaPosicion.getHorizontal()){
			return false;
		}
		int desplazamiento = nuevaPosicion.getVertical() - posicion.getVertical();
		if (desplazamiento > ((primerMovimiento)?2:1)){
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		
		return denominacion + " "+ posicion.toString();
	}
	
}
