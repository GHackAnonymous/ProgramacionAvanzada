package ejerciciosOpoBomberos;

public class Chica extends Candidato{
	private double capacidad;
	private double velocidad;
	private double puntuacion;
	
	public Chica(String nombre, double resistencia,
			double capacidad, double velocidad){
		super(nombre, resistencia);
		this.capacidad = capacidad;
		this.velocidad = velocidad;
	}
	@Override
	public void puntuacion(){
		this.puntuacion = ((super.getResistencia()+(this.capacidad+this.velocidad))/2);
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Capacidad: "+this.capacidad+"\n"+
				"Velocidad: "+this.velocidad+"\n"+
				"Puntuacion: "+this.puntuacion;
	}
}
