import java.util.ArrayList;
import java.util.List;

public class Elfo extends Criatura{
	
	private int capacidad;
	
	public Elfo(int id, String nombre, int vida, Artefacto artefactoSelecionado) {
		super(id, nombre, vida);
		this.capacidad = 1;
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
