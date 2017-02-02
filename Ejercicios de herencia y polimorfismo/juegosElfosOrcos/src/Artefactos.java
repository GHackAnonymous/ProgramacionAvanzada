import java.util.ArrayList;
import java.util.List;

public class Artefactos {

	private List<Artefacto> listaArtefacto;
	
	public Artefactos(){
		listaArtefacto = new ArrayList<Artefacto>();
	}
	
	public List<Artefacto> verArtefacto() {
		ArrayList<Artefacto> copia = new ArrayList<Artefacto>(listaArtefacto);
		return copia;
	}

	public void addArma(String nombre, int vida) {
		listaArtefacto.add(new Arma(listaArtefacto.size(),nombre,vida));
	}

	public void addVeneno(String nombre, int vida) {
		listaArtefacto.add(new Veneno(listaArtefacto.size(),nombre,vida));
	}

	public void addPocion(String nombre, int vida) {
		listaArtefacto.add(new Pocion(listaArtefacto.size(),nombre,vida));
	}
	public List<Artefacto> getListaArtefacto() {
		return listaArtefacto;
	}
}
