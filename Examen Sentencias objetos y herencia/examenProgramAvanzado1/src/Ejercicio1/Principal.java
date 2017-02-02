package Ejercicio1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
	private Scanner teclado;
	private Clase clase;
  public Principal(){
	  clase = new Clase();
	  teclado = new Scanner(System.in);
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

private int menu(){
	  int opcion;
	    System.out.println("1.- Ver lista Alumnos");
	    System.out.println("2.- Ver Alumnos de una determinada poblacion");
	    System.out.println("3.- Ver alumnos aprobados");
	    System.out.println("4.- Ver alumnos aprobados y de una determinada poblacion");
	    System.out.println("5.- Ver alumnos aprobados y de un determinado sexo");
	    System.out.println("0.- Salir");
	    System.out.print("opcion » ");
	    opcion = teclado.nextInt();
	    teclado.nextLine();
	    return opcion;
	
  }
  private void opcionMenu(int opcion){
	  try {
		  
		  switch(opcion){
		    case 1:
		      verLista();
		      break;
		    case 2:
		      verListaPoblacion();	
		      break;
		    case 3:
		    	verListaAprobados();
		      break;
		    case 4:
		    	verListaAprobadosyPoblacion();  
			   break;
		    case 5:
		    	verListaAprobadosySexo();
			   break;
		    case 0:
		      System.out.println("Saliendo....");
		      break;
		    default:
		      throw new GenericException("Opción no válida");
		  }
		 
	  }catch(GenericException e){
	      System.out.println(e.getMessage());
	  }catch(InputMismatchException e){
	      System.out.println("Opción no válida");
	  }catch(Exception e){
	      System.out.println("No sé que ha pasado");
	  }
  }

  
  	private void verListaAprobadosySexo() {
  		System.out.print("Que sexo: ");
  		String sexo = teclado.nextLine();
  		List<Alumno> copia = clase.comparar(FabricaComparador.getComparadorAprobadosySexo(), sexo);
 		 for(Alumno a : copia){
			  System.out.println(a);
		  }
	
}

	private void verListaAprobadosyPoblacion() {
  		System.out.print("Que poblacion: ");
  		String poblacion = teclado.nextLine();
  		List<Alumno> copia = clase.comparar(FabricaComparador.getComparadorAprobadosyPoblacion(), poblacion);
 		 for(Alumno a : copia){
			  System.out.println(a);
		  }
	
}

	private void verListaAprobados() {
  		List<Alumno> copia = clase.comparar(FabricaComparador.getComparadorAprobados(), "");
  		 for(Alumno a : copia){
			  System.out.println(a);
		  }
}

	private void verListaPoblacion() {
  		System.out.print("Que poblacion: ");
  		String poblacion = teclado.nextLine();
  		List<Alumno> copia = clase.listaAlumnos();
  		for(Alumno a : copia){
  			if(a.getPoblacion().equalsIgnoreCase(poblacion)){
			  System.out.println(a);
  			}
		  }
	}

	private void verLista() {
		  List<Alumno> copia = clase.listaAlumnos();
		  for(Alumno a : copia){
			  System.out.println(a);
		  }
	}

public void programa(){
	int opcion;
	do{
		opcion = menu();
    opcionMenu(opcion);
    }while(opcion != 0);
  }
  public static void main(String[] args){
    Principal principal = new Principal();
    principal.programa();

  }

}
