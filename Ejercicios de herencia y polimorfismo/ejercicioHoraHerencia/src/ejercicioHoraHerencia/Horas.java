package ejercicioHoraHerencia;

import java.util.ArrayList;
import java.util.Collections;

public class Horas {
	
	private ArrayList<Hora> listaHora;
	
	public Horas(){
		listaHora = new ArrayList<Hora>();
	}

	public void añadirHora(String hh){
		listaHora.add(new Hora(hh));
	}
	public ArrayList<Hora> getListaHora() {
		return listaHora;
	}

	public void setListaHora(String listaHora) {
		this.listaHora.add(new Hora(listaHora));
	}
	public void setListaHoraPrecisa(String listaHora) {
		this.listaHora.add(new HoraPrecisa(listaHora));
	}
	public Hora saberHoraMenor(){
		Collections.sort(listaHora);
		return listaHora.get(0);
	}
}
