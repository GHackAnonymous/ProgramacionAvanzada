package ejerciciosOpoBomberos;

public abstract class Candidato {
	private String nombre;
	private double resistencia;
	
	public Candidato(String nombre, double resistencia){
		this.nombre = nombre;
		this.resistencia = resistencia;
	}
	public String getNombre() {
		return nombre;
	}
	public double getResistencia() {
		return resistencia;
	}
	@Override
	public String toString() {
		return "El nimbre: "+this.nombre+"\n"+
				"La resistencia: "+this.resistencia;
	}
	public abstract void puntuacion();
	
}
