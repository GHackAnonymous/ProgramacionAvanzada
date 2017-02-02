package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Clase {
	private List<Alumno> lista;
	
	public Clase(){
		lista = new ArrayList<>();
	} 
	public void addAlumno(Alumno alumno){
		lista.add(alumno);
	}
	public ArrayList<Alumno> listaAlumnos(){
		ArrayList<Alumno> copia = new ArrayList<Alumno>(lista);
		return copia;
	}
	public List<Alumno> comparar(Comparador comparador, String valor) {
		List<Alumno> listaCoparada = new ArrayList<>();
		for (int i=0; i<lista.size(); i++){
			if (comparador.comparar(lista.get(i), valor)){
				listaCoparada.add(lista.get(i));
			}
		}
		return listaCoparada;
	}
}
