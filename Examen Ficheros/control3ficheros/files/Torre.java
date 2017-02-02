package ajedrez;

public class Torre {
	Posicion posicion;
	String denominacion;
	
	public Torre(Posicion posicion, String denominacion){
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
			return true;
		}
		return false;
	}

	private boolean posicionValida(Posicion nuevaPosicion) {
		if ((nuevaPosicion.getHorizontal()!=posicion.getHorizontal())){
			return (nuevaPosicion.getVertical()==posicion.getVertical());
		}else{
			return (nuevaPosicion.getVertical()!= posicion.getVertical());
		}
	}

	@Override
	public String toString() {
		return denominacion + " "+ posicion.toString();
	}
	
}
