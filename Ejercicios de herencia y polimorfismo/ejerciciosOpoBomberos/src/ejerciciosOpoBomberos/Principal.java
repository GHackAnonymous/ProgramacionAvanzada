package ejerciciosOpoBomberos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	Scanner teclado;
	Candidatos candidatos;
	
	private Principal(){
		teclado = new Scanner(System.in);
		candidatos = new Candidatos();
	}
	private int menu(){
		System.out.println("1.- Introducir candidato");
		System.out.println("2.- Evaluar");
		System.out.println("3.- Ver lista");
		System.out.println("0.- Salir");
		System.out.print("opcion >> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion;
	}
	private void opcionMenu(int opcion){
		switch(opcion){
		case 1:
			int opcion2 = menu2();
			opcionMenu2(opcion2);
			break;
		case 2:
			evaluar();
			break;
		case 3:
			verLista();
			break;
		case 0:
			System.out.println("Saliendo....");
			break;
		default:
			opcionNoValida();
		}
	}
	private int menu2(){
		System.out.println("1.- Chico");
		System.out.println("2.- Chica");
		System.out.print("opcion >> ");
		int opcion2 = teclado.nextInt();
		teclado.nextLine();
		return opcion2;
	}
	private void opcionMenu2(int opcion2){
		switch(opcion2){
		case 1:
			pedirDatosChico();
			break;
		case 2:
			pedirDatosChica();
			break;
		default:
			opcionNoValida();
		}
	}
	private String pedirNombre(){
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		return nombre;
	}
	private double pedirDouble(String texto){
		double varDouble;
		do{
			System.out.print(texto);
			varDouble = teclado.nextDouble();
			teclado.nextLine();
		}while(validadDouble(varDouble)!= true);
		return varDouble;
	}
	private void pedirDatosChico(){
		String nombre = pedirNombre();
		double resistencia = pedirDouble("Resistencia (entre 1 y 10): ");
		double potencia = pedirDouble("Potencia (entre 1 y 10): ");
		candidatos.addChico(nombre, resistencia, potencia);
	}
	private void pedirDatosChica(){
		String nombre = pedirNombre();
		double resistencia = pedirDouble("Resistencia (entre 1 y 10): ");
		double capacidad = pedirDouble("Capacidad (entre 1 y 10): ");
		double velocidad = pedirDouble("Velocidad (entre 1 y 10): ");
		candidatos.addChica(nombre, resistencia, capacidad, velocidad);
	}
	private void evaluar(){
		System.out.println("\nEvaluando...");
		candidatos.evaluar();
		System.out.println("Evaluado\n");
	}
	private void verLista(){
		ArrayList<Candidato> listaCandidatos = candidatos.listaCandidatos();
		for(Candidato candi : listaCandidatos){
			System.out.println(candi);
			System.out.println();
		}
	}
	private boolean validadDouble(double a){
		if(a >= 0 && a <= 10){
			return true;
		}
		return false;
	}
	private void opcionNoValida(){
		System.err.println("Opcion no Valida");
	}
	private void programa(){
		int opcion = -1;
		do{
			opcion = menu();
			opcionMenu(opcion);
		}while(opcion != 0);
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}
}
