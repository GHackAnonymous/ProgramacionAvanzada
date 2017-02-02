
public class Artefacto {
	private int id;
	private String nombre;
	private int vidaQuita;
	
	public Artefacto(int id, String nombre, int vidaQuita){
		this.id = id;
		this.nombre = nombre;
		this.vidaQuita = vidaQuita;
	}
	public int getVidaQuita() {
		return vidaQuita;
	}
	@Override
	public String toString() {
		return "Id: "+this.id+" Nombre: "+this.nombre;
	}
	public int ataque(int capacidad){
		return 0;
	}
	public int darVida(){
		return 0;
	}
	public int danoPorVeneno(){
		return 0;
	}
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}
}
