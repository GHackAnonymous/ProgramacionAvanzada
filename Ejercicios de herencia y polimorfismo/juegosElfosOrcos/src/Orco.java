import java.util.List;

public class Orco extends Criatura{

	private int capacidad;
	
	public Orco(int id, String nombre, int vida, Artefacto artefactoSelecionado) {
		super(id, nombre, vida);
		this.capacidad = 0;
		super.addArtefacto(artefactoSelecionado);
	}
	public void addArtefacto(Artefacto artefactoSelecionado){
		super.addArtefacto(artefactoSelecionado);
	}
	@Override
	public int getCapacidad() {
		return capacidad;
	}
}
