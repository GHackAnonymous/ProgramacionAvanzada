package ejerciciosOpoBomberos;

import java.util.ArrayList;

public class Candidatos {
	ArrayList<Candidato> listaCandidatos;
	
	public Candidatos(){
		listaCandidatos = new ArrayList<Candidato>();
	}
	public void addChico(String nombre, double resistencia, double potencia){
		listaCandidatos.add(new Chico(nombre, resistencia,potencia));
	}
	public void addChica(String nombre, double resistencia, double capacidad, double velocidad){
		listaCandidatos.add(new Chica(nombre, resistencia,capacidad, velocidad));
	}
	public ArrayList<Candidato> listaCandidatos(){
		ArrayList<Candidato> copia = new ArrayList<Candidato>(listaCandidatos);
		return copia;
	}
	public void evaluar(){
		for(Candidato candi : listaCandidatos){
			candi.puntuacion();
		}
	}
}
