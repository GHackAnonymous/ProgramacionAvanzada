package ajedrez;

public class Peon {
	boolean primerMovimiento;
	Posicion pos;
	String denominacion;
	
	public Peon(Posicion posicion, String denominacion){
		this.primerMovimiento = true;
		this.pos = posicion;
		this.denominacion = denominacion;
	}
	
	
	public Posicion getPosicion() {
		return pos;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public boolean mover(Posicion nuevaPosicion){
		if (posicionValida (nuevaPosicion)){
			pos.mover(nuevaPosicion);
			primerMovimiento = false;
			return true;
		}
		return false;
	}

	private boolean posicionValida(Posicion nuevaPosicion) {
		if (pos.getHorizontal()!= nuevaPosicion.getHorizontal()){
			return false;
		}
		int desplazamiento = nuevaPosicion.getVertical() - pos.getVertical();
		if (desplazamiento > ((primerMovimiento)?2:1)){
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		
		return denominacion + " "+ pos.toString();
	}
	
}
