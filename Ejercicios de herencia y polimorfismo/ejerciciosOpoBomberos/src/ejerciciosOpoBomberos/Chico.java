package ejerciciosOpoBomberos;

public class Chico extends Candidato{
	private double potencia;
	private double puntuacion;
	
	public Chico(String nombre, double resistencia, double potencia){
		super(nombre, resistencia);
		this.potencia = potencia;
	}
	@Override
	public void puntuacion(){
		this.puntuacion = ((super.getResistencia()+this.potencia)/2);
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Potencia: "+this.potencia+"\n"+
				"Puntuacion: "+this.puntuacion;
	}
}
