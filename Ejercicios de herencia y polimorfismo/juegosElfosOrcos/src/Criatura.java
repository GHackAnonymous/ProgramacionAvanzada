import java.util.ArrayList;
import java.util.List;

public abstract class Criatura {
	private int id;
	private String nombre;
	private int vida;
	private boolean envenenamiento;
	private Artefacto artefacto;
	
	public Criatura(int id, String nombre, int vida){
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
	}
	public void addArtefacto(Artefacto art){
		artefacto = art;
	}
	public void envenear(){
		this.envenenamiento = true;
	}
	@Override
	public String toString() {
		return "ID: "+this.id+"\nNombre: "+this.nombre+
				"\nVida: "+this.vida+"\n Artefacto: \n"
				+ "      "+artefacto+"\n";
	}
	public Artefacto getArtefacto() {
		return artefacto;
	}
	public void quitarVida(int  menosVida){
		this.vida = this.vida - menosVida;
	}
	public void ponerVida(int  masVida){
		this.vida = this.vida + masVida;
	}
	public boolean isEnvenenamiento() {
		return envenenamiento;
	}
	public String getNombre() {
		return nombre;
	}
	public int getVida() {
		return vida;
	}
	public abstract int getCapacidad();
}
