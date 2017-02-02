import java.util.ArrayList;
import java.util.List;

public class Criaturas {
	private List<Criatura> listaCriaturas; 
	private final int VIDA = 2;
	
	public Criaturas(){
		listaCriaturas = new ArrayList<Criatura>();
	}
	
	public void addElfo(String nombre, Artefacto artefactoSelecionado) {
		listaCriaturas.add(new Elfo(listaCriaturas.size(),nombre,VIDA, artefactoSelecionado));
	}

	public void addOrco(String nombre, Artefacto artefactoSelecionado) {
		listaCriaturas.add(new Orco(listaCriaturas.size(),nombre,VIDA, artefactoSelecionado));
	}

	public List<Criatura> verCriatura() {
		ArrayList<Criatura> copia = new ArrayList<Criatura>(listaCriaturas);
		return copia;
	}
	public int efectoCriaturaSobreCriatura(int idCriaMover, int idCriaActua ){
		Artefacto art = listaCriaturas.get(idCriaActua).getArtefacto();
		int vidaVeneno = 0;
		if(art instanceof Arma){
			int capacidad = listaCriaturas.get(idCriaMover).getCapacidad();
			int vida = listaCriaturas.get(idCriaMover).getArtefacto().ataque(capacidad);
			listaCriaturas.get(idCriaActua).quitarVida(vida);
		}else if(art instanceof Pocion){
			int vida = listaCriaturas.get(idCriaMover).getArtefacto().darVida();
			listaCriaturas.get(idCriaActua).ponerVida(vida);
		}else if(art instanceof Veneno){
			vidaVeneno = listaCriaturas.get(idCriaMover).getArtefacto().danoPorVeneno();
			listaCriaturas.get(idCriaActua).envenear();
			listaCriaturas.get(idCriaActua).quitarVida(vidaVeneno);
		}
		return vidaVeneno;
	}
	public void quitarVidaPorVeneno(int vida){
		for(Criatura cria : listaCriaturas){
			if(cria.isEnvenenamiento() == true){
				cria.quitarVida(vida);
			}
		}
	}

	public String combrobarVida() {
		for(Criatura cria : listaCriaturas){
			if(cria.getVida() <= 0){
				listaCriaturas.remove(cria);
				return "La cratura "+cria.getNombre()+" A muerto";
			}
		}
		return null;
	}

	public String toStringMovimoento(int idCriaMover, int idCriaActua) {
		return listaCriaturas.get(idCriaMover).getNombre()+" Actua sobre "
				+listaCriaturas.get(idCriaActua).getNombre()+" con el artefacto "
				+listaCriaturas.get(idCriaMover).getArtefacto().getNombre();
	}
}
