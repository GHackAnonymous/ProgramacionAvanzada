package Ejercicio3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Principal {
	Map<String,List<Alumno>> indice;
	private Clase clase;
  public Principal(){
	  clase = new Clase();
	  indice = new LinkedHashMap<>();
	  inicialzar();
  }
  
  private void inicialzar() {
	clase.addAlumno(new Alumno(1, "Iñigo","Ayestaran", "Bergara", "M", 7.0));
	clase.addAlumno(new Alumno(2, "Ander","Bolumburu", "Arrasate", "M", 6.2));
	clase.addAlumno(new Alumno(3, "Ainhoa","Arruabarrena", "Zarauz", "F", 8.4));
	clase.addAlumno(new Alumno(4, "Aritz","Caballero", "Donosti", "M", 9.1));
	clase.addAlumno(new Alumno(5, "Elene","Carlos", "Durango", "F", 8.8));
	clase.addAlumno(new Alumno(6, "Txema","Perez", "Vitoria", "M", 2.3));
	clase.addAlumno(new Alumno(7, "Xabi","Elkoro", "Arrasate", "M", 3.2));
	clase.addAlumno(new Alumno(8, "Miren","Illarramendi", "Zestoa", "F", 4.7));
	clase.addAlumno(new Alumno(9, "Inaki","Arenaza", "Vitoria", "M", 3.5));
	clase.addAlumno(new Alumno(10, "Aitor","Barreiro", "Vitoria", "M", 7.5));
	clase.addAlumno(new Alumno(11, "Julen","Uribarren", "Bergara", "M", 6.5));
	clase.addAlumno(new Alumno(12, "Xanti","Leonet", "Zarauz", "M", 8.5));
  }


  

  public void contarpoblacion(){
	  List<Alumno> copia = clase.listaAlumnos();
		for(Alumno a : copia){
			List<Alumno> alumn = new ArrayList<>();
			for(Alumno a2 : copia){
				if (a.getPoblacion().equalsIgnoreCase(a2.getPoblacion())){
					alumn.add(a2);
				}
			}
			indice.put(a.getPoblacion(), alumn);
		}
	}

  public void verIndice(){
		
		Set<Entry<String,List<Alumno>>> poblacion = indice.entrySet();
		for (Entry<String,List<Alumno>> par : poblacion){
			System.out.print(par.getKey()+"->");
			int contador = 0;
			double media = 0;
			List<Alumno> list =  par.getValue();
			for(Alumno a2 :list){
				//media = 0;
					//media = a2.getNota();
					media += a2.getNota();
					contador++;
				}
				Double mediafin =  media/contador;
				System.out.println("nota media:"+mediafin);
				System.out.println(par.getValue());
			}

			System.out.println();
	}

public void programa(){
	contarpoblacion();
	verIndice();
  }
  public static void main(String[] args){
    Principal principal = new Principal();
    principal.programa();

  }

}
