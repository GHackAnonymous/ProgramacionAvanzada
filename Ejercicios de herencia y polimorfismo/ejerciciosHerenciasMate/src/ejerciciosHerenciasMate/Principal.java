package ejerciciosHerenciasMate;

import java.util.List;
import java.util.Scanner;

public class Principal {

	private final int CUANTOSNUMNUMEROS = 10;
	private final int ENTRENUMNUMEROS = 1000;
	private Generador genera;
	private List<Integer> lista;
	private Scanner teclado;
	
	public Principal(){
		genera = new Generador(CUANTOSNUMNUMEROS,ENTRENUMNUMEROS);
		teclado = new Scanner(System.in);
	}
	public void programa(){
		try{
		System.out.print("1- primos/2- capicua/3- suma13: ");
		int opcion = teclado.nextInt();
		lista = genera.programa(opcion);
		
		for(Integer i: lista){
			System.out.println(i);
		}
		
		}catch(Exception e){
			System.out.println("Opcion no valida");
		}
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.programa();
	}

}
