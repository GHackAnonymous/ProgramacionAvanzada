package ejerciciosAjendaTelefono;

import java.util.Scanner;

public class Principal {

	private Scanner teclado;
	private Agenda agenda;
	private final int MAXNUMEROSTELEFONO = 9;
	
	private Principal(){
		teclado = new Scanner(System.in);
		agenda = new Agenda();
	}
	
	private int menu(){
		System.out.println("1.- Introducir nuevo teléfono");
		System.out.println("2.- Buscar teléfono por nombre");
		System.out.println("0.- Salir");
		System.out.print("opcion ->");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion; 
	}
	private String queNombre(){
		System.out.print("Dime que nombre: ");
		return teclado.nextLine();
	}
	private int[] queNumero(){
		System.out.print("Dime el numero de telefono (maximo "+
			MAXNUMEROSTELEFONO +" numeros separado por espacios): ");
		
		int[] numeros = new int[MAXNUMEROSTELEFONO];
		for(int i = 0; i < MAXNUMEROSTELEFONO;i++ ){
			numeros[i] = teclado.nextInt();
		}
		teclado.nextLine();
		return numeros;
	}
	private void opcionMenu(int opcion){
		switch(opcion){
			case 1:
				agenda.anadirTelefono(queNombre(), queNumero());
				break;
			case 2:
				Telefono tl = agenda.buscarTelefono(queNombre());
				System.out.println(tl.toString());
				break;
			case 0:
				System.out.println("Saliendo....");
				break;
			default:
				opcionNoValida();
		}
	} 
	private void opcionNoValida(){
		System.err.println("Opcion no valida");
	}
	private void Programa(){
		int opcion;
		do{
			opcion = menu();
			opcionMenu(opcion);
		}while(opcion != 0);
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.Programa();
	}
}
